/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import java.util.ArrayList;
import svugame.model.Dice;
import svugame.model.Thing;
import static svugame.model.action.ActionConstants.RESULTS_MISS;
import static svugame.model.action.ActionConstants.RESULTS_NONE;
import svugame.model.entity.Entity;

/**
 *
 * @author Alan
 */
public abstract class Action {
    
    protected Entity actor;
    protected int skillId;
    protected Thing dobj;
    protected Thing iobj;
    protected boolean attempted;
    protected boolean successful;
    protected ArrayList<Effect> results;
    
    public Action(Entity actor, int skillId){
        this(actor, skillId, null, null);
    }
    
    public Action(Entity actor, int skillId, Thing dobj){
        this(actor, skillId, dobj, null);
    }
    
    public Action(Entity actor, int skillId, Thing dobj, Thing iobj){
        this.actor = actor;
        this.skillId = skillId;
        this.dobj = dobj;
        this.iobj = iobj;
        this.successful = false;
        this.results = null;
    }
    
    public boolean isPossible() {
        if(actor.getSpirit()<actor.getSkill(skillId).getModel().getSpirit()){
            return false;
        }
        return true;
    }
    
    public boolean isSuccessful(){
        if(!attempted){
            return false;
        }
        return successful;
    }
    
    protected boolean skillCheck(int adjust){
        return Dice.roll("1d100")<(actor.getSkillValue(skillId)+adjust);
    }
    
    public ArrayList<Effect> apply() {
        results = new ArrayList<>();
        if(!isPossible()){
            attempted = true;
            successful = false;
            results.add(new Effect(RESULTS_NONE,0));
        } else {
            // subtract spirit cost
            actor.setSpirit(actor.getSpirit()-actor.getSkill(skillId).getModel().getSpirit());
            attempted = true;
            successful = skillCheck(0);
            if(!successful){
                results.add(new Effect(RESULTS_MISS, 0));
            } else {
                
            }
        }
        
        return results;
    }
    
}
