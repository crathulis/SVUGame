/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;

/**
 *
 * @author Alan
 */
public abstract class Action {
    
    protected Entity actor;
    protected Thing dobj;
    protected Thing iobj;
    
    public abstract boolean actorCan();
    public abstract boolean success();
    public abstract int resultType();
    public abstract int resultAmount();
    
}
