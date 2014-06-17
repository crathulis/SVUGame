package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.SKILL_OHTH;


/**
 *
 * @author Alan
 */
public class OhThrust extends MeleeAction implements ItemConstants {

    public OhThrust(Entity actor) {
        super(actor, SKILL_OHTH);
    }

    public OhThrust(Entity actor, Thing dobj) {
        super(actor, SKILL_OHTH, dobj);
    }

    public OhThrust(Entity actor, Thing dobj, Thing iobj) {
        super(actor, SKILL_OHTH, dobj, iobj);
    }

    @Override
    public boolean actorCan() {
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
