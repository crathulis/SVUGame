package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.items.ItemConstants;


/**
 *
 * @author Alan
 */
public class ThMeleeAction extends MeleeAction implements ItemConstants {

    public ThMeleeAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public ThMeleeAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public ThMeleeAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    @Override
    public boolean isPossible() {
        // melee actions require a target (dobj)
        if (dobj == null) {
            return false;
        }
        // actor must be holding a melee weapon in the right hand
        if (actor.getItemInSlot(ITEM_SLOT_RHAND).getType() != ITEM_TYPE_OH_WEAPON) {
            return false;
        }
        // dobj must be an entity
        if (!(dobj instanceof Entity)) {
            return false;
        }
        // dobj must not be flying or swimming
        return true;
    }

}
