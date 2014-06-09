/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.entity;

import svugame.model.skills.Skill;
import svugame.model.items.Inventory;
import java.util.ArrayList;
import svugame.model.items.Item;
import svugame.model.items.ItemConstants;

/**
 * The character is the super class of all living entities in the game.
 * 
 * @author Alan Whitehurst
 */
public class Entity implements AttributeConstants, ItemConstants {

    private String name;
    private boolean male;
    private int experience;
    private int health;
    private int spirit;
    private Attribute[] attributes;
    private Inventory inventory;
    private ArrayList<Skill> skills;
    private Item[] equipment;

    // TODO: location
    public Entity() {
        this("John", true, 0, 0, 0);
    }

    public Entity(String name, boolean male, int experience, int health, int spirit) {
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
    }

    /**
     * Returns the given name of a unique sentient or the name of the type of
     * non-sentient
     *
     * @return the name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the character.
     *
     * @param name the name of the character.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns true if the character is male.
     *
     * @return true if the character is male, false otherwise.
     */
    public boolean isMale() {
        return male;
    }

    /**
     * Returns true if the character is female.
     *
     * @return true if the character is female, false otherwise.
     */
    public boolean isFemale() {
        return !male;
    }

    /**
     * Sets the gender of the character
     *
     * @param male true to set the gender to male.
     */
    public void setMale(boolean male) {
        this.male = male;
    }

    /**
     * Sets the gender of the character
     *
     * @param female true to set the gender to female
     */
    public void setFemale(boolean female) {
        this.male = !female;
    }

    /**
     * Sets the gender of the character.
     *
     * @param gender true for male, false for female.
     */
    public void setGender(int gender) {
        this.male = (gender == MALE);
    }

    /**
     * Gets the current number of experience points of the character.
     *
     * @return the number of experience points.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the current number of experience points.
     *
     * @param experience the new experience point value.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Adds an amount of experience points to the character's current experience
     * point total.
     *
     * @param amount the amount of experience to add.
     * @return the new total experience points.
     */
    public int addExperience(int amount) {
        this.experience += amount;
        return this.experience;
    }

    /**
     * Get the level of the character. The level is a function of the experience
     * a character has amassed.
     *
     * @return the level of the character.
     */
    public double getLevel() {
        return Math.max(Math.pow(getExperience(), 0.275) / Math.PI, 1.0);
    }

    /**
     * Get the base health points of the character. Health is calculated from
     * the level of the character and the amount of endurance.
     * 
     * @return base health points.
     */
    public int getBaseHealth() {
        return (int) Math.round(getEndurance() * getLevel());
    }

    /**
     * Get the current health of the character.
     *
     * @return the characters health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the character's health to the given amount.
     *
     * @param health the new health value.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Reset the health of the character back to the base health amount.
     */
    public void resetHealth() {
        setHealth(getBaseHealth());
    }

    /**
     * Get the base spirit points of the character. Spirit is calculated from
     * the level of the character and the amount of focus.
     * 
     * @return base spirit points.
     */
    public int getBaseSpirit() {
        return (int) Math.round(getFocus() * getLevel());
    }

    /**
     * Get the current spirit of the character.
     *
     * @return the character's spirit.
     */
    public int getSpirit() {
        return spirit;
    }

    /**
     * Set the current spirit of the character.
     * @param spirit the new spirit value.
     */
    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    /**
     * Get the current value of an attribute by the attribute's ID. Attribute
     * IDs are defined in AttributeConstants.java.
     * 
     * @param attribNum the ID of the attribute to retrieve.
     * @return the current value of the attribute.
     */
    public int getAttribute(int attribNum) {
        return attributes[attribNum].getCurValue();
    }

    /**
     * Set the current value of an attribute by the attribute's ID. Attribute
     * IDs are defined in AttributeConstants.java.
     * 
     * @param attribNum the ID of the attribute to set.
     * @param value the new value for the attribute.
     */
    public void setAttribute(int attribNum, int value) {
        attributes[attribNum].setCurValue(value);
    }

    /**
     * Get the base value of an attribute by the attribute's ID. Attribute IDs
     * are defined in AttributeConstants.java
     * 
     * @param attribNum the ID of the attribute to retrieve.
     * @return the base value of the attribute.
     */
    public int getAttributeBase(int attribNum) {
        return attributes[attribNum].getBaseValue();
    }
    
    /**
     * Reset the current value of an attribute to the attribute's base
     * value as indicated by the attribute ID. Attribute IDs are define
     * in AttributeConstants.java
     * 
     * @param attribNum the ID of the attribute to reset.
     * @return the current value of the attribute after the reset.
     */
    public int resetAttribute(int attribNum){
        attributes[attribNum].resetCurValue();
        return attributes[attribNum].getCurValue();
    }

    /**
     * Get the current value of the strength attribute.
     * @return value of strength attribute.
     */
    public int getStrength() {
        return attributes[STR].getCurValue();
    }

    /**
     * Get the current value of the agility attribute.
     * @return value of attribute.
     */
    public int getAgility() {
        return attributes[AGI].getCurValue();
    }

    /**
     * Get the current value of the endurance attribute.
     * @return value of attribute.
     */
    public int getEndurance() {
        return attributes[END].getCurValue();
    }

    /**
     * Get the current value of the perception attribute.
     * @return value of attribute.
     */
    public int getPerception() {
        return attributes[PER].getCurValue();
    }

    /**
     * Get the current value of the dexterity attribute.
     * @return value of attribute.
     */
    public int getDexterity() {
        return attributes[DEX].getCurValue();
    }

    /**
     * Get the current value of the charisma attribute.
     * @return value of attribute.
     */
    public int getCharisma() {
        return attributes[CHA].getCurValue();
    }

    /**
     * Get the current value of the intelligence attribute.
     * @return value of attribute.
     */
    public int getIntelligence() {
        return attributes[INT].getCurValue();
    }

    /**
     * Get the current value of the wisdom attribute.
     * @return value of attribute.
     */
    public int getWisdom() {
        return attributes[WIS].getCurValue();
    }

    /**
     * Get the current value of the focus attribute.
     * @return value of attribute.
     */
    public int getFocus() {
        return attributes[FOC].getCurValue();
    }

    /**
     * Get the initiative value of the character. Initiative determines order
     * in combat and is calculated as the sum of agility and intelligence.
     * 
     * @return the initiative value.
     */
    public int getInitiative() {
        return getAgility() + getIntelligence();
    }

}
