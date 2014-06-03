/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.character;

import svugame.model.skills.Skill;
import svugame.model.items.Inventory;
import java.util.ArrayList;

/**
 *
 * @author Lab Admin
 */
public class Character implements AttributeConstants {

    

    private String name;
    private boolean male;
    private int experience;
    private int health;
    private int spirit;
    private ArrayList<Attribute> attributes;
    private Inventory inventory;
    private ArrayList<Skill> skills;
    private ArrayList<Feat> feats;

    // TODO: location
    public Character() {
        this("John", true, 0, 100, 100);
    }

    public Character(String name, boolean male, int experience, int health, int spirit) {
        this.name = name;
        this.male = male;
        this.experience = experience;
        this.health = health;
        this.spirit = spirit;
        this.attributes = new ArrayList(6);
        this.inventory = new Inventory();
        this.skills = new ArrayList();
        this.feats = new ArrayList();
    }

}
