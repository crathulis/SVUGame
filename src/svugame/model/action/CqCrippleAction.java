/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import svugame.model.Dice;
import svugame.model.Thing;
import static svugame.model.action.ActionConstants.RESULTS_HARM_AGI;
import static svugame.model.entity.AttributeConstants.AGI;
import svugame.model.entity.Entity;

/**
 *
 * @author Lab Admin
 */
class CqCrippleAction extends CqMeleeAction {

    public CqCrippleAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public CqCrippleAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public CqCrippleAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    @Override
    protected void addMoreEffects() {
        int damage = super.getBaseDamage();
        int duration = Dice.roll("1d" + ((int)actor.getLevelStep()));
        ((Entity)dobj).setAttribute(AGI, ((Entity)dobj).getAgility() - damage);
        ((Entity)dobj).modifyAttribute(AGI, new Modifier(this, damage, duration, damage, false, true, false ));
        results.add(new Effect(RESULTS_HARM_AGI, damage));
    }
    
}
