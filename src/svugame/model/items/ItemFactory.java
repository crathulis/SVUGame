/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.items;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import static svugame.model.items.ItemConstants.NUM_ITEMS;

/**
 *
 * @author Kevin
 */
class ItemFactory {
    
    static {
        final String ITEMLIST_XML = "./data/itemset-jaxb.xml";
        try {
            JAXBContext context = JAXBContext.newInstance(ItemList.class);
            Unmarshaller um = context.createUnmarshaller();
            itemList = (ItemList) um.unmarshal(new FileReader(ITEMLIST_XML));
        } catch (JAXBException ex) {
            Logger.getLogger(ItemFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    public static ItemModel getModel(int itemId) {
        return itemList.getItemModelById(itemId);
    }
    
    public static ItemModel getModel(String name){
        return itemList.getItemModelByName(name);
    }
    
    public static void main(String [] args){
        for(int i=0;i<NUM_ITEMS;++i){
            ItemModel im = ItemFactory.getModel(i);
            System.out.println(i + ": " + im);
        }
    }
    
    private static ItemList itemList;
}
