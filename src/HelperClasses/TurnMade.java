/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

import java.util.ArrayList;
import svugame.model.action.Action;
import svugame.model.entity.Entity;

/**
 *
 * @author craig.reese
 */
public class TurnMade {
    Entity actor;
    Action action;
    ArrayList<Entity> target;

    public TurnMade(Entity actor, ArrayList<Entity> target, Action action) {
        this.actor = actor;
        this.target = target;
        this.action = action;
    }

    public TurnMade() {
    }

    public Entity getActor() {
        return actor;
    }

    public void setActor(Entity actor) {
        this.actor = actor;
    }

    public ArrayList<Entity> getTarget() {
        return target;
    }

    public void setTarget(ArrayList<Entity> target) {
        this.target = target;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    
    
    
}
