/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import svugame.model.Dice;
import svugame.model.Thing;
import svugame.model.entity.Entity;

/**
 *
 * @author Alan
 */
public class OhSwingAction extends OhMeleeAction {

    public OhSwingAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public OhSwingAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public OhSwingAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }
    
    @Override
    protected void addMoreEffects(){
        int duration = Dice.roll(((int)actor.getLevel()) + "d" + 4);
        int dot = getBaseDamage() / duration;
        Modifier mod = new Modifier(this, dot, duration, 0, true, false, false);
        ((Entity)dobj).modifyHealth(mod);
        results.add(new Effect(ActionConstants.RESULTS_DOT_HP, dot));
    }
    
}
