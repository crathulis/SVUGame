package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.items.ItemConstants;


/**
 *
 * @author Alan
 */
public abstract class CqMeleeAction extends MeleeAction implements ItemConstants {

    public CqMeleeAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public CqMeleeAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public CqMeleeAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    @Override
    public boolean isPossible() {
        // actor must have enough spirit to complete action
        if (actor.getSpirit()<(actor.getSkill(skillId).getModel().getSpirit())){
            return false;
        }
        // melee actions require a target (dobj)
        if (dobj == null) {
            return false;
        }
        // actor must be holding a two-handed melee weapon in the right hand
        if (actor.getItemInSlot(ITEM_SLOT_RHAND).getType() != ITEM_TYPE_CQ_WEAPON) {
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
