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
public abstract class Action {
    
    protected Entity actor;
    protected int skillId;
    protected Thing dobj;
    protected Thing iobj;
    
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
    }
    
    public abstract boolean isPossible();
    public abstract boolean isSuccessful();
    public abstract ArrayList<Integer> resultType();
    public abstract ArrayList<Integer> resultAmount();
    
}
