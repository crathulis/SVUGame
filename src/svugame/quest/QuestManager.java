/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.quest;

import java.util.HashMap;
import svugame.model.action.Action;

/**
 *
 * @author Jordan
 */
public class QuestManager {
    
    public QuestManager(){
        populateQuestList(new ArenaQuest());
    }
    
    private void populateQuestList(ArenaQuest example){
        questList.put("ArenaQuest", example.getQuest());
        //This should read in an XML file of quests. Eventually.
    }
    
    public void advanceQuests(Action action){
        for(Quest q : questList.values()){
            q.advanceQuest(action);
        }
    }
    
    public void activateQuest(String questName){
        activeList.put(questName, questList.get(questName));
    }
    
    public boolean questExists(String questName){
        return questList.containsKey(questName);
    }
    
    private HashMap<String, Quest> questList = new HashMap();
    private HashMap<String, Quest> activeList = new HashMap();
    
}
