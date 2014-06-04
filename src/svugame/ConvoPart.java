/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame;

/**
 *
 * @author craig.reese
 */
public class ConvoPart {
    
    String id;
    String text;
    String[] pointer;
    
    public ConvoPart(String id, String text, String[] pointer)
    {
        this.id = id;
        this.text = text;
        this.pointer = pointer;
    }

    ConvoPart() {
        
    }
    
    
}
