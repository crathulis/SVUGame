/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.items;

import java.util.ArrayList;
import java.util.Collections;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import svugame.model.skills.SkillModel;

/**
 *
 * @author Kevin
 */
@XmlRootElement(namespace = "items")

public class ItemList {
    
    public ItemList(){        
    }
    
    public ItemList(ArrayList<ItemModel> itemList){
        this.itemList = itemList;
    }
    
    public ItemModel getItemModelById(int skillId) {
        if(!sorted){
            Collections.sort(itemList);
            sorted = true;
        }
        return itemList.get(skillId);
    }
    
    public ItemModel getItemModelByName(String name){
        for(ItemModel im : itemList){
            if(im.getName().equals(name)){
                return im;
            }
        }
        return itemList.get(0);
    }
    
    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "itemList")
    // XmlElement sets the name of the entities
    @XmlElement(name = "item")
    private ArrayList<ItemModel> itemList;
    private boolean sorted = false;
   
}
