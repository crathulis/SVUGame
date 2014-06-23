/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

/**
 *
 * @author craig.reese
 */
public class StatAllocation {
    
    int stat;
    String statName;
    Position position;

    public StatAllocation(int stat, String statName, Position position) {
        this.stat = stat;
        this.statName = statName;
        this.position = position;
    }

    public int getStat() {
        return stat;
    }

    public String getStatName() {
        return statName;
    }
    
    public Position getPosition(){
        return position;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
    
    
    
    
    
}
