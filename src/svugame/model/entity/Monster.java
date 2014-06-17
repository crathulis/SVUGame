/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;
import svugame.model.skills.Skill;

/**
 *
 * @author Kevin
 */
@XmlType(propOrder = { "name", "hit", "damage", "endurance", "perception", "charisma", "focus", 
    "skill1", "attrib1", "attrib2", "level1", 
    "skill2", "attrib3", "attrib4", "level2", 
    "skill3", "attrib5", "attrib6", "level3"})

public class Monster extends Entity{
    
    private ArrayList<Skill> attacks;
    
    public Monster(String name, int hit, int damage, int end, int per, int cha, int foc,
            String skill1, int att1, int att2, int lv1,
            String skill2, int att3, int att4, int lv2,
            String skill3, int att5, int att6, int lv3){
        
        //Call super constructor
        super.setName(name);
        
        // Set Monster's Attributes
        super.setAttribute(STR, damage);
        super.setAttribute(AGI, hit);
        super.setAttribute(END, end);
        super.setAttribute(PER, per);
        super.setAttribute(DEX, hit);
        super.setAttribute(CHA, cha);
        super.setAttribute(INT, hit);
        super.setAttribute(WIS, damage);
        super.setAttribute(FOC, foc);
    }
    
}
