/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.dialogue;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author craig.reese
 */

@XmlType(propOrder = { "id", "text", "pointer"})

public class Dialogue {
    
    private String id;
    private String text;
    private String[] prerequisites;
    private String[] pointer;
    private String[] actions;  //is this correct?
    
    public Dialogue(String id, String text, String[] pointer)
    {
        this.id = id;
        this.text = text;
        this.pointer = pointer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getPointer() {
        return pointer;
    }

    public void setPointer(String[] pointer) {
        this.pointer = pointer;
    }

    Dialogue() {
        
    }
    
    
}
