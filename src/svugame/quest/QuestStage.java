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

    public int getStageNumber() {
        return stageNumber;
    }
    
    public QuestStage(int stageNumber, String desc){
        this(stageNumber, desc, 1);
    }
    
    public QuestStage(int stageNumber, String desc, int counter){
        this.stageNumber = stageNumber;
        this.desc = desc;
    }
    
    public void addAdvancer(int thingID, int actionResult, int stageToAdvanceTo){
        advancers.add(new QuestAdvancer(thingID, actionResult, stageToAdvanceTo));
    }
    
    public int checkAdvancers(int thingID, int actionID){
        for(int n = 0; n < advancers.size(); n++){
            if(advancers.get(n).getThingID() == thingID && 
                    advancers.get(n).getActionResult() == actionID){
                counter--;
                if(counter == 0) return advancers.get(n).getStageToAdvanceTo();
            }
        }
        return -1;
    }
    
    private final int stageNumber;
    private final String desc;
    private int counter;
    private ArrayList<QuestAdvancer> advancers = new ArrayList<>();
    
}
