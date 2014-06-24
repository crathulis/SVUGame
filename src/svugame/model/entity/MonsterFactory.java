/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import static svugame.model.entity.MonsterConstants.NUM_MONSTERS;

/**
 *
 * @author Kevin
 */
class MonsterFactory {
    
    static {
        final String MONSTERLIST_XML = "./data/monster-jaxb.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(MonsterList.class);
            Unmarshaller um = context.createUnmarshaller();
             monsterList = (MonsterList) um.unmarshal(new FileReader(MONSTERLIST_XML));
        } catch (JAXBException ex) {
            Logger.getLogger(MonsterFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MonsterFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    public static MonsterModel getModel(int skillId) {
        return monsterList.getSkillModelById(skillId);
    }
    
    public static MonsterModel getModel(String name){
        return monsterList.getMonsterModelByName(name);
    }
    
    public static void main(String [] args){
        for(int i=0;i<NUM_MONSTERS;++i){
            MonsterModel sm = MonsterFactory.getModel(i);
            System.out.println(i + ": " + sm);
        }
    }
    
    private static MonsterList monsterList;
    
}
