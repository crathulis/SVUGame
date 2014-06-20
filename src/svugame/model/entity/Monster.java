/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import java.util.HashMap;
import svugame.model.skills.Skill;

/**
 *
 * @author Kevin
 */


public abstract class Monster extends Entity{
    
    private HashMap<String,Skill> attacks;
    
    public void addSkill(String name, Skill skill){
        attacks.put(name, skill);
    }
    
    public Skill getSkill(String name){
        return attacks.get(name);
    }
    
    public int attackNum(){
        return attacks.size();
    }
    
}
