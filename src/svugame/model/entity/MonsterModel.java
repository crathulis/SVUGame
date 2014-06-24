/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kevin
 */
@XmlType(propOrder = { "name", "id", "strength", "agility", "endurance", "perception", 
    "dexterity", "charisma", "intelligence", "wisdom", "focus", "exp",
    "skill1", "id1", "skill2", "id2", "skill3", "id3", "level", "armour", "weapon"})

public class MonsterModel implements Comparable{
    
    public MonsterModel(){
        
    }
    
    public MonsterModel(String name, int id, int strength, int agility, int endurance, int perception, int dexterity,
            int charisma, int intelligence, int wisdom, int focus, int exp,
            String skill1, int id1, String skill2, int id2,
            String skill3, int id3, int level, String armour, String weapon){
        this.name = name;
        this.id = id;
        this.strength = strength;
        this.agility = agility;
        this.endurance = endurance;
        this.perception = perception;
        this.dexterity = dexterity;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.focus = focus;
        this.exp = exp;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.id1 = id1;
        this.id2 =id2;
        this.id3 = id3;
        this.level = level;
        this.armour = armour;
        this.weapon = weapon;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int str) {
        this.strength = str;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agi) {
        this.agility = agi;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int end) {
        this.endurance = end;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int per) {
        this.perception = per;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dex) {
        this.dexterity = dex;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int cha) {
        this.charisma = cha;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intel) {
        this.intelligence = intel;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wis) {
        this.wisdom = wis;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int foc) {
        this.focus = foc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getArmour() {
        return armour;
    }

    public void setArmour(String armour) {
        this.armour = armour;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    
    public String toString(){
        return getName();
    }
    
    private String name;
    private int id;
    private int strength, agility, endurance, perception, dexterity, charisma, intelligence, wisdom, focus;
    private int exp;
    private String skill1, skill2, skill3;
    private int id1, id2, id3, level;
    private String armour, weapon;
    
    @Override
    public int compareTo(Object o) {
        if ((o == null) || (!(o instanceof MonsterModel))) {
            return 1;
        }
        return this.id - ((MonsterModel) o).getId();
    }
}
