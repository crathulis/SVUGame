/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.entity;

import java.util.ArrayList;
import svugame.model.action.Modifier;

/**
 *
 * @author Lab Admin
 */
public class Stat {

    private final String name;
    private final Entity owner;
    private final int attribute;
    private int value;
    private ArrayList<Modifier> mods;

    public Stat(String name, Entity owner, int attribute) {
        this.name = name;
        this.owner = owner;
        this.attribute = attribute;
        this.value = (int) Math.round(owner.getAttribute(attribute) * owner.getLevel());
        this.mods = new ArrayList<Modifier>();
    }

    public int getBaseValue() {
        return (int) Math.round(owner.getAttribute(attribute) * owner.getLevel());
    }

    public int getCurrentValue() {
        return value;
    }

    public void setCurrentValue(int value) {
        this.value = value;
    }
    
    public int getMax(){
        return Math.max(getBaseValue(), value);
    }
    
    public double getPercent(){
        return value / getMax();
    }

    public void resetCurrentValue() {
        value = getBaseValue();
    }

    public Entity getOwner() {
        return owner;
    }

    public ArrayList<Modifier> getMods() {
        return mods;
    }

    public void setMods(ArrayList<Modifier> mods) {
        this.mods = mods;
    }

    public void addMods(Modifier mod) {
        this.mods.add(mod);
    }

    public void update() {
        for (Modifier mod : mods) {
            if (mod.getDuration() > 0) {
                mod.setDuration(mod.getDuration() - 1);
                if (mod.isAdditive()) {
                    mod.setTotal(mod.getTotal() + mod.getAmount());
                    value += mod.getAmount();
                }
            } else if (mod.getDuration() <= 0) {
                if(mod.isTemporary()){
                    value -= mod.getTotal();
                }
                mods.remove(mod);
            }
        }
    }

    public void dispell() {
        for (Modifier mod : mods) {
            if (mod.isDispellable()) {
                if(mod.isTemporary()){
                    value -= mod.getTotal();
                }
                mods.remove(mod);
            }
        }
    }

}
