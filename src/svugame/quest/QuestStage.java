/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.quest;

import java.util.ArrayList;
import svugame.model.action.Action;

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
    
    public void addAdvancer(Action action, int stageToAdvanceTo){
        actionAdvancers.add(new ActionAdvancer(action, stageToAdvanceTo));
    }
    
    public int checkActionAdvancers(Action action){
        for(int n = 0; n < actionAdvancers.size(); n++){
            if(actionAdvancers.get(n).getAction().equals(action)){
                counter--;
                if(counter == 0) return actionAdvancers.get(n).getStageToAdvanceTo();
            }
        }
        return -1;
    }
    
    public void addAdvancer(String convo, String pointer, int stageToAdvanceTo) {
        dialogueAdvancers.add(new DialogueAdvancer(convo, pointer, stageToAdvanceTo));
    }
    
    public int checkDialogueAdvancers(String convo, String pointer) {
        for(int n = 0; n < dialogueAdvancers.size(); n++){
            if(dialogueAdvancers.get(n).getConvo().equals(convo) &&
                    dialogueAdvancers.get(n).getPointer().equals(pointer)){
                return dialogueAdvancers.get(n).getStageToAdvanceTo();
            }
        }
        return -1;
    }
    
    private final int stageNumber;
    private final String desc;
    private int counter;
    private ArrayList<ActionAdvancer> actionAdvancers = new ArrayList<>();
    private ArrayList<DialogueAdvancer> dialogueAdvancers = new ArrayList<>();
    
}
