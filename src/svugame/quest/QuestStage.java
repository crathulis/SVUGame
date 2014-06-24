/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.quest;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class QuestStage {
    
    QuestStage(int stageNumber, String desc){
        this.stageNumber = stageNumber;
        this.desc = desc;
    }
    
    public void addAdvancer(int thingID, int actionResult, int stageToAdvanceTo){
        advancers.add(new QuestAdvancer(thingID, actionResult, stageToAdvanceTo));
    }
    
    public 
    
    private final int stageNumber;
    private final String desc;
    private ArrayList<QuestAdvancer> advancers = new ArrayList<>();
    
}
