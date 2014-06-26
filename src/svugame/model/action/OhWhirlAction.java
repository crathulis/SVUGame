/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.action;

import svugame.model.Thing;
import static svugame.model.action.ActionConstants.RESULTS_DAMAGE_PARTY_HP;
import svugame.model.entity.Entity;

/**
 *
 * @author Lab Admin
 */
class OhWhirlAction extends OhMeleeAction {

    public OhWhirlAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public OhWhirlAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public OhWhirlAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    @Override
    protected void addMoreEffects() {
        int damage = super.getBaseDamage() / (((Entity) dobj).getParty().getMembers().size() - 1);
        for (Entity entity : ((Entity) dobj).getParty().getMembers()) {
            if (entity != ((Entity) dobj)) {
                entity.setHealth(entity.getHealth() - damage);
            }
        }
        results.add(new Effect(RESULTS_DAMAGE_PARTY_HP, damage));
    }

}
