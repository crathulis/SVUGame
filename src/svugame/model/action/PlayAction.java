package svugame.model.action;

import java.util.ArrayList;
import svugame.model.Dice;
import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.entity.Party;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.SKILL_PLAY;


/**
 *
 * @author Alan
 */
public class PlayAction extends Action implements ItemConstants {

    public PlayAction(Entity actor, int skillId) {
        super(actor, SKILL_PLAY);
    }

    public PlayAction(Entity actor, int skillId, Thing dobj) {
        super(actor, SKILL_PLAY, dobj);
    }

    public PlayAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, SKILL_PLAY, dobj, iobj);
    }
    
    @Override
    public boolean isPossible() {
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
    public boolean isSuccessful() {
        int successChance = actor.getSkillValue(skillId);
        return (Dice.roll("1d100")<=successChance);
    }

    @Override
    public ArrayList<Integer> resultType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> resultAmount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
