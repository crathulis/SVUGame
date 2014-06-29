/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.quest;

import svugame.model.action.Action;

/**
 *
 * @author Student
 */
public class ActionAdvancer {
    
    ActionAdvancer(Action action, int stageToAdvanceTo){
        this.action = action;
        this.stageToAdvanceTo = stageToAdvanceTo;
    }

    public Action getAction() {
        return action;
    }

    public int getStageToAdvanceTo() {
        return stageToAdvanceTo;
    }
    
    private final Action action;
    private final int stageToAdvanceTo;
    
}
