/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.dialogue;

import svugame.dialogue.Dialogue;
import java.util.ArrayList;

/**
 *
 * @author craig.reese
 */
public class Conversation {
    //this class  needs to be changed.
    //a conversation needs to encompass a list of dialogues
    
    private ArrayList<Dialogue> dialogueList = new ArrayList();
    private String ConversationName;
    
    public Conversation(){
        
    }

    public ArrayList<Dialogue> getDialogueList() {
        return dialogueList;
    }

    public void setDialogueList(ArrayList<Dialogue> dialogueList) {
        this.dialogueList = dialogueList;
    }

    public String getConversationName() {
        return ConversationName;
    }

    public void setConversationName(String ConversationName) {
        this.ConversationName = ConversationName;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
}
