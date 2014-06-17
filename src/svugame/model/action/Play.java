/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import svugame.model.Dice;
import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.entity.Party;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.PLAY_INSTRUMENT;

/**
 *
 * @author Alan
 */
public class Play extends Action implements ItemConstants {

    public Play(Entity actor, int skillId) {
        super(actor, PLAY_INSTRUMENT);
    }

    public Play(Entity actor, int skillId, Thing dobj) {
        super(actor, PLAY_INSTRUMENT, dobj);
    }

    public Play(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, PLAY_INSTRUMENT, dobj, iobj);
    }
    
    @Override
    public boolean actorCan() {
        // actor must be carrying an instrument in one of their hands
        if(actor.getItemInSlot(ITEM_SLOT_RHAND).getType()!=ITEM_TYPE_INSTRUMENT &&
                actor.getItemInSlot(ITEM_SLOT_LHAND).getType()!=ITEM_TYPE_INSTRUMENT){
            return false;
        }
        // the dobj must be an entity or a party of entities
        if(!(dobj instanceof Entity) && !(dobj instanceof Party)){
            return false;
        }
        return true;
    }

    @Override
    public boolean success() {
        int successChance = actor.getSkillValue(skillId);
        return (Dice.roll("1d100")<=successChance);
    }

    @Override
    public int resultType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int resultAmount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
