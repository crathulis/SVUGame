/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.character;

import svugame.model.skills.Skill;
import svugame.model.items.Inventory;
import java.util.ArrayList;
import svugame.model.items.Item;
import svugame.model.items.ItemConstants;


/**
 *
 * @author Lab Admin
 */
public class Character implements AttributeConstants, ItemConstants {

    private String name;
    private boolean male;
    private int experience;
    private int health;
    private int spirit;
    private Attribute[] attributes;
    private Inventory inventory;
    private ArrayList<Skill> skills;
    private ArrayList<Feat> feats;
    private Item[] equipment;

    // TODO: location
    public Character() {
        this("John", true, 0, 0, 0);
    }

    public Character(String name, boolean male, int experience, int health, int spirit) {
        this.name = name;
        this.male = male;
        this.experience = experience;
        this.health = health;
        this.spirit = spirit;
        this.attributes = new Attribute[NUM_ATTRIB];
        for (int i = 0; i < NUM_ATTRIB; ++i) {
            attributes[i] = new Attribute(i, 0, 0);
        }
        this.inventory = new Inventory();
        this.equipment = new Item[NUM_EQUIP];
        this.skills = new ArrayList();
        this.feats = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isFemale() {
        return !male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setFemale(boolean female) {
        this.male = !female;
    }

    public void setGender(int gender) {
        this.male = (gender == MALE);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public int getAttribute(int attribNum) {
        return attributes[attribNum].getCurValue();
    }

    public void setAttribute(int attribNum, int value) {
        attributes[attribNum].setCurValue(value);
    }

    public int getAttributeBase(int attribNum) {
        return attributes[attribNum].getBaseValue();
    }

    public void setAttributeBase(int attribNum, int value) {
        attributes[attribNum].setBaseValue(value);
    }

    public int getStrength() {
        return attributes[STR].getCurValue();
    }

    public int getAgility() {
        return attributes[AGI].getCurValue();
    }

    public int getEndurance() {
        return attributes[END].getCurValue();
    }

    public int getPerception() {
        return attributes[PER].getCurValue();
    }

    public int getDexterity() {
        return attributes[DEX].getCurValue();
    }

    public int getCharisma() {
        return attributes[CHA].getCurValue();
    }

    public int getIntelligence() {
        return attributes[INT].getCurValue();
    }

    public int getWisdom() {
        return attributes[WIS].getCurValue();
    }

    public int getFocus() {
        return attributes[FOC].getCurValue();
    }

}
