/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.quest;

/**
 *
 * @author Jordan
 */
public class DialogueAdvancer {
    
    DialogueAdvancer(String convo, String pointer, int stageToAdvanceTo){
        this.convo = convo;
        this.pointer = pointer;
        this.stageToAdvanceTo = stageToAdvanceTo;
    }

    public String getConvo() {
        return convo;
    }
    
    public String getPointer() {
        return pointer;
    }

    public int getStageToAdvanceTo() {
        return stageToAdvanceTo;
    }
    
    private final String convo;
    private final String pointer;
    private final int stageToAdvanceTo;
    
}
