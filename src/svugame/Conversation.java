/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame;

import svugame.dialogue.Dialogue;
import java.util.ArrayList;

/**
 *
 * @author craig.reese
 */
public class Conversation {
    
    Dialogue start;
   // ConvoPart a;
    Dialogue b;
    Dialogue c;
    Dialogue d1;
    Dialogue d2;
    
    String[] pointer;
    
    ArrayList convoList = new ArrayList();
    
    public Conversation()
    {
         start = new Dialogue("a","Where am I?",new String[]{"b"});
         convoList.add(start);
        b = new Dialogue("b","How did i get here?",new String[]{"c"});
        convoList.add(b);
        c = new Dialogue("c","My head sure does hurt.",new String[]{"d1","d2"});
        convoList.add(c);
        d1 = new Dialogue("d1","Maybe I should just sit here and wait.",new String[]{"end"});
        convoList.add(d1);
        d2 = new Dialogue("d2","I'm going to have a look around",new String[]{"end"});
        convoList.add(d2);
        pointer = new String[]{"start"};
    }
    
    public Dialogue getText(String id)
    {
        for(int i =0;i<convoList.size();i++)
        {
            Dialogue p = (Dialogue) convoList.get(i);
            if(p.id.equals(id))
            {
                return p;
            }
        }
        return null;
    }
    
    
    
}
