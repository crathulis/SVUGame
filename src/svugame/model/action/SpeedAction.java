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
        // actor has focus
        if(dobj==null){
            dobj = actor;
        } else {
            if(actor!=dobj){
                return false;
            }
        }
        return actor.getSpirit()>0;
    }

    @Override
    public ArrayList<Effect> apply() {
        ArrayList<Effect> effects = new ArrayList<>();
        
        return effects;
    }
    
}
