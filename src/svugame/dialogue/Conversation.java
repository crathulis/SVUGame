/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.dialogue;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author craig.reese
 */


//@XmlType(propOrder = {"conversationName", "dialogueList"})
@XmlRootElement(namespace = "ConversationList")

public class Conversation {
    //this class  needs to be changed.
    //a conversation needs to encompass a list of dialogues
    
    private ArrayList<Dialogue> dialogueList = new ArrayList();
    private String conversationName;
    
    public Conversation(){
        
    }

    public ArrayList<Dialogue> getDialogueList() {
        return dialogueList;
    }

    @XmlElementWrapper(name = "dialogueList")
    @XmlElement(name = "dialogue")
    public void setDialogueList(ArrayList<Dialogue> dialogueList) {
        this.dialogueList = dialogueList;
    }

    public String getConversationName() {
        return conversationName;
    }

    @XmlAttribute
    public void setConversationName(String ConversationName) {
        this.conversationName = ConversationName;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
}
