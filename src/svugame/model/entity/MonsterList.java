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

/**
 *
 * @author Kevin
 */
@XmlRootElement(namespace = "monsters")

public class MonsterList {
    
    public MonsterList() {
    }

    public MonsterList(ArrayList<MonsterModel> monsterList) {
        this.monsterList = monsterList;
    }

    public ArrayList<MonsterModel> getListOfMonsters() {
        return monsterList;
    }

    public void setMonsterList(ArrayList<MonsterModel> monsterList) {
        this.monsterList = monsterList;
    }

    public MonsterModel getSkillModelById(int monsterId) {
        if(!sorted){
            Collections.sort(monsterList);
            sorted = true;
        }
        return monsterList.get(monsterId);
    }
    
    public MonsterModel getMonsterModelByName(String name){
        for(MonsterModel mm : monsterList){
            if(mm.getName().equals(name)){
                return mm;
            }
        }
        return monsterList.get(0);
    }

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "monsterList")
    // XmlElement sets the name of the entities
    @XmlElement(name = "monster")
    private ArrayList<MonsterModel> monsterList;
    private boolean sorted = false;
    
}
