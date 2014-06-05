/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.dialogue;

/**
 *
 * @author craig.reese
 */
public class Dialogue {
    
    public String id;
    public String text;
    public String[] pointer;
    
    public Dialogue(String id, String text, String[] pointer)
    {
        this.id = id;
        this.text = text;
        this.pointer = pointer;
    }

    Dialogue() {
        
    }
    
    
}
