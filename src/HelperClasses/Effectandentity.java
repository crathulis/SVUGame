/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

import java.util.ArrayList;
import svugame.model.entity.Entity;

/**
 *
 * @author craig.reese
 */
public class Effectandentity {
    
    ArrayList effects;
    Entity entity;

    public Effectandentity() {
    }

    public Effectandentity(ArrayList effects, Entity entity) {
        this.effects = effects;
        this.entity = entity;
    }
    
    

    public ArrayList getEffects() {
        return effects;
    }

    public void setEffects(ArrayList effects) {
        this.effects = effects;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    
    
    
}
