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
    
    QuestAdvancer(int thingID, int actionID, int stageToAdvanceTo){
        this.thingID = thingID;
        this.actionID = actionID;
        this.stageToAdvanceTo = stageToAdvanceTo;
    }

    public int getThingID() {
        return thingID;
    }

    public int getActionResult() {
        return actionID;
    }

    public int getStageToAdvanceTo() {
        return stageToAdvanceTo;
    }
    
    private final int thingID;
    private final int actionID;
    private final int stageToAdvanceTo;
    
}
