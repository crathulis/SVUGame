/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.items;

import svugame.model.items.Item;
import java.util.ArrayList;

/**
 *
 * @author Lab Admin
 */
public class Inventory {
    
    private ArrayList<Item> items;
    
    public void addItem(Item addItem){
        items.add(addItem);
    }
    
    public Item getItem(int loc){
        return items.get(loc);
    }
    
    public void removeItem(int loc){
        items.remove(loc);
    }
    
}
