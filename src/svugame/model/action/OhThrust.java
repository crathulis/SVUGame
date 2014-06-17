/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.OH_THRUST;

/**
 *
 * @author Alan
 */
public class OhThrust extends MeleeAction implements ItemConstants {

    public OhThrust(Entity actor) {
        super(actor, OH_THRUST);
    }

    public OhThrust(Entity actor, Thing dobj) {
        super(actor, OH_THRUST, dobj);
    }

    public OhThrust(Entity actor, Thing dobj, Thing iobj) {
        super(actor, OH_THRUST, dobj, iobj);
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
