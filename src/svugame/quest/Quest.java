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
        stage = 0;
        this.name = name;
    }
    
    public void addStage(int stage, String desc){
        questStages.add(new QuestStage(stage, desc));
    }
    
    public int getStage(){
        return stage;
    }
    
    public void setStage(int stage){
        this.stage = stage;
    }
    
    private int stage;
    private String name;
    private ArrayList<QuestStage> questStages = new ArrayList<>();
    
}