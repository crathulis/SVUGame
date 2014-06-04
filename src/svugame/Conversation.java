/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame;

import java.util.ArrayList;

/**
 *
 * @author craig.reese
 */
public class Conversation {
    
    ConvoPart start;
   // ConvoPart a;
    ConvoPart b;
    ConvoPart c;
    ConvoPart d1;
    ConvoPart d2;
    
    String[] pointer;
    
    ArrayList convoList = new ArrayList();
    
    public Conversation()
    {
         start = new ConvoPart("a","Where am I?",new String[]{"b"});
         convoList.add(start);
        b = new ConvoPart("b","How did i get here?",new String[]{"c"});
        convoList.add(b);
        c = new ConvoPart("c","My head sure does hurt.",new String[]{"d1","d2"});
        convoList.add(b);
        d1 = new ConvoPart("d1","Maybe I should just sit here and wait.",new String[]{"e"});
        convoList.add(d1);
        d2 = new ConvoPart("d2","I'm going to have a look around",new String[]{"f"});
        convoList.add(d2);
        pointer = new String[]{"start"};
    }
    
    public ConvoPart getText(String id)
    {
        for(int i =0;i<convoList.size();i++)
        {
            ConvoPart p = (ConvoPart) convoList.get(i);
            if(p.id.equals(id))
            {
                return p;
            }
        }
        return null;
    }
    
    
    
}
