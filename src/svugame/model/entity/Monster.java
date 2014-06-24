/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import java.util.HashMap;

/**
 *
 * @author Kevin
 */


public abstract class Monster extends Entity{
    
    private HashMap<String,Integer> attacks;
    
    public void addSkill(String name, int skillNum, int level){
        attacks.put(name, skillNum);
        super.addSkillPoints(skillNum, level);
    }
    
    public Integer getSkill(String name){
        return attacks.get(name);
    }
    
    public int attackNum(){
        return attacks.size();
    }
    
    public void setAttributes(int str, int agi, int end, int per, int dex, 
            int cha, int intel, int wis, int foc){
        super.setAttribute(STR, str);
        super.setAttribute(AGI, agi);
        super.setAttribute(END, end);
        super.setAttribute(PER, per);
        super.setAttribute(DEX, dex);
        super.setAttribute(CHA, cha);
        super.setAttribute(INT, intel);
        super.setAttribute(WIS, wis);
        super.setAttribute(FOC, foc);
    }
    
}
