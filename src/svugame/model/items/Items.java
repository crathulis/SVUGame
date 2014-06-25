/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.items;


/**
 *
 * @author Lab Admin
 */
public class Items implements ItemConstants {
    
    public static boolean isArmor(Item item){
        if(item==null) return false;
        return  item.getType() == ITEM_TYPE_ARMOR_CLOTH ||
                item.getType() == ITEM_TYPE_ARMOR_LEATHER ||
                item.getType() == ITEM_TYPE_ARMOR_CHAIN ||
                item.getType() == ITEM_TYPE_ARMOR_SCALE ||
                item.getType() == ITEM_TYPE_ARMOR_PLATE;
    }
    
}
