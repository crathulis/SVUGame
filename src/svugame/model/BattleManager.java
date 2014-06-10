/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import svugame.model.entity.Entity;
import svugame.model.entity.Party;

/**
 * Battles are divided into rounds. Rounds consist of each participant in the
 * battle taking a turn in the order of initiative.
 *
 * @author alan.whitehurst
 */
public class BattleManager {

    private ArrayList<Entity> roster;
    private Party party;
    private Party groms;
    
    /**
     * Create a battle manager to manage a battle between two parties of
     * entities.
     * 
     * @param party the player and his or her followers.
     * @param groms a group of monsters.
     */
    public BattleManager(Party party, Party groms) {
        this.party = party;
        this.groms = groms;
    }
    
    private void createRoster(){
        roster.addAll(party.getMembers());
        roster.addAll(groms.getMembers());
    }
    
    private void orderRoster(){
        Collections.sort(roster, new Comparator<Entity>(){
            @Override
            public int compare(Entity o1, Entity o2) {
                return o1.getInitiative() - o2.getInitiative();
            }
        });
    }
      

}
