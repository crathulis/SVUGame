/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

import java.util.ArrayList;
import svugame.model.action.Effect;
import svugame.model.entity.Entity;

/**
 *
 * @author craig.reese
 */
public class EffEntTar {
    
    ArrayList<Effect> effectsList;
    Entity actor;
    Entity target;
    Entity nextPC;

    public EffEntTar(ArrayList<Effect> effectsList, Entity actor, Entity target, Entity nextPC) {
        this.effectsList = effectsList;
        this.actor = actor;
        this.target = target;
        this.nextPC = nextPC;
    }

    public ArrayList<Effect> getEffectsList() {
        return effectsList;
    }

    public void setEffectsList(ArrayList<Effect> effectsList) {
        this.effectsList = effectsList;
    }

    public Entity getActor() {
        return actor;
    }

    public void setActor(Entity actor) {
        this.actor = actor;
    }

    public Entity getTarget() {
        return target;
    }

    public void setTargets(Entity target) {
        this.target = target;
    }

    public Entity getNextPC() {
        return nextPC;
    }

    public void setNextPC(Entity nextPC) {
        this.nextPC = nextPC;
    }
    
    
    
}
