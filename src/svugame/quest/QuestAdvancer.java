/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.quest;

/**
 *
 * @author Student
 */
public class QuestAdvancer {
    
    QuestAdvancer(int thingID, int actionResult, int stageToAdvanceTo){
        this.thingID = thingID;
        this.actionResult = actionResult;
        this.stageToAdvanceTo = stageToAdvanceTo;
    }

    public int getThingID() {
        return thingID;
    }

    public int getActionResult() {
        return actionResult;
    }

    public int getQuestToAdvanceTo() {
        return stageToAdvanceTo;
    }
    
    private final int thingID;
    private final int actionResult;
    private final int stageToAdvanceTo;
    
}
