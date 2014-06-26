/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.quest;

import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public class Quest {
    
    public Quest(String name){
        currentStage = 0;
        this.name = name;
    }
    
    public void addStage(int stage, String desc){
        questStages.add(new QuestStage(stage, desc));
    }
    
    public QuestStage getStage(int stage){
        for(int n = 0; n < questStages.size(); n++){
            if(questStages.get(n).getStageNumber() == stage){
                return questStages.get(n);
            }
        }
        return null;
    }
    
    public int getCurrentStage(){
        return currentStage;
    }
    
    public void advanceQuest(int thingID, int actionID){
        for(int n = 0; n < questStages.size(); n++){
            if(questStages.get(n).checkAdvancers(thingID, actionID) != -1){
                currentStage = questStages.get(n).checkAdvancers(thingID, actionID);
                return;
            }
        }
    }
    
    private int currentStage;
    private String name;
    private ArrayList<QuestStage> questStages = new ArrayList<>();
    
}
