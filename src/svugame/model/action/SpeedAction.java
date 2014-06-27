/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import java.util.ArrayList;
import svugame.model.Thing;
import svugame.model.entity.Entity;

/**
 *
 * @author Alan
 */
class SpeedAction extends Action {

    public SpeedAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    @Override
    public boolean isPossible() {
        // should always be possible if the target is the actor and the
        // actor has enough spirit to complete action
        if (actor.getSpirit()<(actor.getSkill(skillId).getModel().getSpirit())){
            return false;
        }

        if(dobj==null){
            dobj = actor;
        } else {
            if(actor!=dobj){
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<Effect> apply() {
        ArrayList<Effect> effects = new ArrayList<>();
        actor.setSpirit(actor.getSpirit()-actor.getSkill(skillId).getModel().getSpirit());
        //TODO: decide on effect of haste
        
        return effects;
    }
    
}
