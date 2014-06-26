/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.items;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kevin
 */
@XmlType(propOrder = {"name", "id", "description", "type", "slot", "value", "weight", "damage"})

public class ItemModel implements Comparable{
    
    public ItemModel(){        
    }
    
    public ItemModel(int id){
        this("", id, "", 0, 0, 0, 0, 0);
    }
    
    public ItemModel(String name, int id, String description, int type, 
            int slot, int value, int weight, int damage) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.type = type;
        this.slot = slot;
        this.value = value;
        this.weight = weight;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    @Override
    public int compareTo(Object o) {
        if ((o == null) || (!(o instanceof ItemModel))) {
            return 1;
        }
        return this.id - ((ItemModel) o).getId();
    }
    
    private String name;
    private int id;
    private String description;
    private int type;
    private int slot;
    private int value;
    private int weight;
    private int damage;
}
