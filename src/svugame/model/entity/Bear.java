/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kevin
 */
@XmlType(propOrder = { "name", "strength", "agility", "endurance", "perception", 
    "dexterity", "charisma", "intelligence", "wisdom", "focus", "exp",
    "skill1", "id1", "skill2", "id2", "skill3", "id3", "armour", "weapon"})

public class Bear extends Monster{
    
    
    
    public Bear(String name, int str, int agi, int end, int per, int dex,
            int cha, int intel, int wis, int foc, int exp,
            String skill1, int id1, String skill2, int id2,
            String skill3, int id3, String armour, String weapon){
        
        //Set Name
        super.setName(name);
        
        // Set Monster's Attributes
        super.setAttribute(STR, str);
        super.setAttribute(AGI, agi);
        super.setAttribute(END, end);
        super.setAttribute(PER, per);
        super.setAttribute(DEX, dex);
        super.setAttribute(CHA, cha);
        super.setAttribute(INT, intel);
        super.setAttribute(WIS, wis);
        super.setAttribute(FOC, foc);
        
        //Set Experience
        super.setExperience(exp);
        
        //Set Skills
        
    }
    
}
