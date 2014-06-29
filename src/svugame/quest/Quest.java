/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.quest;

import java.util.ArrayList;
import svugame.model.action.Action;

/**
 *
 * @author Jordan
 */
public class Quest {

    public Quest(String name) {
        setCurrentStage(0);
        this.name = name;
    }

    public void addStage(int stage, String desc) {
        questStages.add(new QuestStage(stage, desc));
    }

    public QuestStage getCurrentStage() {
        return currentStage;
    }

    public void advanceQuest(Action action) {
        if (currentStage.checkActionAdvancers(action) != -1) {
            setCurrentStage(currentStage.checkActionAdvancers(action));
        }
    }
    
    public void advanceQuest(String convo, String pointer) {
        if (currentStage.checkDialogueAdvancers(convo, pointer) != -1){
            setCurrentStage(currentStage.checkDialogueAdvancers(convo, pointer));
        }
    }

    public void setCurrentStage(int stage) {
        for (int n = 0; n < questStages.size(); n++) {
            if (questStages.get(n).getStageNumber() == stage) {
                currentStage = questStages.get(n);
                return;
            }
        }
    }
    
    public void addAdvancer(int stageNumber, Action action, int stageToAdvanceTo) {
        for (int n = 0; n < questStages.size(); n++) {
            if (questStages.get(n).getStageNumber() == stageNumber) {
                questStages.get(n).addAdvancer(action, stageToAdvanceTo);
            }
        }
    }
    
    public void addAdvancer(int stageNumber, String convo, String pointer, int stageToAdvanceTo) {
        for (int n = 0; n < questStages.size(); n++) {
            if (questStages.get(n).getStageNumber() == stageNumber) {
                questStages.get(n).addAdvancer(convo, pointer, stageToAdvanceTo);
            }
        }
    }
    
    private QuestStage currentStage;
    private String name;
    private ArrayList<QuestStage> questStages = new ArrayList<>();
    
}
