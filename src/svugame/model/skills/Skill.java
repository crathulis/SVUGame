/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.skills;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author Lab Admin
 */
//@XmlRootElement(name = "skill")
@XmlType(propOrder = { "name", "attrib1", "attrib2", "level" })
public class Skill {
    
    public Skill(){
        
    }

    public Skill(String name, int attrib1, int attrib2, int level) {
        this.name = name;
        this.attrib1 = attrib1;
        this.attrib2 = attrib2;
        this.level = level;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttrib1() {
        return attrib1;
    }

    public void setAttrib1(int attrib1) {
        this.attrib1 = attrib1;
    }

    public int getAttrib2() {
        return attrib2;
    }

    public void setAttrib2(int attrib2) {
        this.attrib2 = attrib2;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    private String name;
    private int attrib1;
    private int attrib2;
    private int level;
    
}
