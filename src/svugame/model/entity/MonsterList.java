/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import svugame.model.skills.SkillModel;

/**
 *
 * @author Kevin
 */
@XmlRootElement(namespace = "skills")

public class MonsterList {
    
    public MonsterList() {
    }

    public MonsterList(ArrayList<MonsterModel> monsterList) {
        this.monsterList = monsterList;
    }

    public ArrayList<SkillModel> getListOfSkills() {
        return monsterList;
    }

    public void setSkillList(ArrayList<SkillModel> skillList) {
        this.monsterList = skillList;
    }

    public SkillModel getSkillModelById(int skillId) {
        if(!sorted){
            Collections.sort(monsterList);
            sorted = true;
        }
        return monsterList.get(skillId);
    }
    
    public SkillModel getSkillModelByName(String name){
        for(SkillModel sm : monsterList){
            if(sm.getName().equals(name)){
                return sm;
            }
        }
        return monsterList.get(0);
    }

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "skillList")
    // XmlElement sets the name of the entities
    @XmlElement(name = "skill")
    private ArrayList<SkillModel> monsterList;
    private boolean sorted = false;
    
}
