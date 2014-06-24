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
@XmlType(propOrder = { "name", "strength", "agility", "endurance", "perception", 
    "dexterity", "charisma", "intelligence", "wisdom", "focus", "exp",
    "skill1", "id1", "skill2", "id2", "skill3", "id3", "level", "armour", "weapon"})

public class MonsterModel {
    
    public MonsterModel(){
        
    }
    
    public MonsterModel(String name, int str, int agi, int end, int per, int dex,
            int cha, int intel, int wis, int foc, int exp,
            String skill1, int id1, String skill2, int id2,
            String skill3, int id3, int level, String armour, String weapon){
        this.name = name;
        this.str = str;
        this.agi = agi;
        this.end = end;
        this.per = per;
        this.dex = dex;
        this.cha = cha;
        this.intel = intel;
        this.wis = wis;
        this.foc = foc;
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

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getFoc() {
        return foc;
    }

    public void setFoc(int foc) {
        this.foc = foc;
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
    
    
    
    
    private String name;
    private int str, agi, end, per, dex, cha, intel, wis, foc;
    private int exp;
    private String skill1, skill2, skill3;
    private int id1, id2, id3, level;
    private String armour, weapon;
    
}
