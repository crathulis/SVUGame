/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.skills;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alan.whitehurst
 */
@XmlRootElement(namespace = "skills")

public class SkillList {
    
    public SkillList(){
        
    }

    public SkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }

    public ArrayList<Skill> getListOfSkills() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "skillList")
    // XmlElement sets the name of the entities
    @XmlElement(name = "skill")
    private ArrayList<Skill> skillList;

}
