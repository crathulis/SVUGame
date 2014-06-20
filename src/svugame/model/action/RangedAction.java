/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import java.util.ArrayList;
import svugame.model.Thing;
import svugame.model.entity.Entity;
import static svugame.model.items.ItemConstants.ITEM_SLOT_RHAND;
import static svugame.model.items.ItemConstants.ITEM_TYPE_RG_WEAPON;

/**
 *
 * @author Lab Admin
 */
public class RangedAction extends Action {

    public RangedAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public RangedAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public RangedAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }
    
    @Override
    public boolean isPossible() {
        // ranged actions require a target (dobj)
        if (dobj == null) {
            return false;
        }
        // actor must be holding a two-handed ranged weapon in the right hand
        if (actor.getItemInSlot(ITEM_SLOT_RHAND).getType() != ITEM_TYPE_RG_WEAPON) {
            return false;
        }
        // dobj must be an entity
        if (!(dobj instanceof Entity)) {
            return false;
        }
        // dobj must not be flying or swimming
        return true;}

    @Override
    public ArrayList<Effect> apply() {
        return null;
    }
    
}
