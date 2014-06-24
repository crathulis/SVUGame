/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.quest;

import java.util.HashMap;

/**
 *
 * @author Jordan
 */
public class QuestManager {
    
    public QuestManager(){
        populateQuestList(new ArenaQuest());
    }
    
    public void populateQuestList(ArenaQuest example){
        questList.put("ArenaQuest", example.getQuest());
    }
    
    public Quest getStage(String questName){
        return questList.get(questName);
    }
    
    public void setStage(String questName, int stage){
        questList.get(questName).setStage(stage);
    }
    
    public void completeQuest(String questName){
        questList.get(questName).setStage(100);
    }
    
    public boolean QuestExists(String questName){
        return questList.containsKey(questName);
    }
    
    private HashMap<String, Quest> questList = new HashMap();
    
}
