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
public class ConversationTest {

    Conversation conversation = new Conversation();
    //String[] pointer = conversation.pointer;

    public ConversationTest() {

    }

    public ArrayList GetNext(Dialogue cp) {
        //we'll return the next part of the conversation here
        //get where pointer is pointing at.
        ArrayList temp = new ArrayList();
        if (cp != null) {
            for (String s : cp.getPointer()) {
               // temp.add(conversation.getText(s));
             //at this point we have the text, now we need to update the pointers

            }
        } else {
            //if we're here, we're at the start of a conversation, get first part which should always be start
            //temp.add(conversation.start);
        }
        return temp;
    }

}
