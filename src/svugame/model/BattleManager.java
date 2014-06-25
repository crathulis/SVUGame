/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model;

import HelperClasses.TurnMade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import svugame.model.action.Action;
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
    int turn = 1;
    int rosterActivePlayer = 0;

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

    public BattleManager() {

    }

    public void StartBattle() {
        turn = 1;
        createRoster();
        orderRoster();

    }

    public TurnMade nextTurn(Entity actor, ArrayList<Entity> target, Action action) {
        //this method is about running a turn
        //we need to get the next actor
        
        if (IsNPC(roster.get(rosterActivePlayer))) {
            //it's an npc, lets do their turn
            Entity target1 = new Entity("Wolf", true, 10);  //temp
            ArrayList<Entity> groupoftargets = new ArrayList();
            groupoftargets.add(target1);
           // Action thisaction = new Action();
            
            //1. npc needs to get a random action it's able to do
            //2. npc needs to get a target based on said action (aoe or single target)
            //3. npc trys action against target(s)
            //4. model records results
            
            
            if(rosterActivePlayer == roster.size())
            {
                //we're at the end of a turn
                orderRoster();
                rosterActivePlayer = 0;
                turn++;
                
                
            }
            //after npc's turn, we need to add one to the rosterActivePlayer
            Entity oldplayer = roster.get(rosterActivePlayer);
            rosterActivePlayer++;
            
            return new TurnMade(oldplayer,groupoftargets,null); //last part shouldnt be null
        }
        else if(!IsNPC(roster.get(rosterActivePlayer))&& actor == null)
        {
            //we return the active PC char so we can load their skills
            Entity player = roster.get(rosterActivePlayer);
            return new TurnMade(player,null,null); 
        }
        
            //we have received information to have a player character act, so lets have them take their turn
            //1. use action against argets
            //2. model updates changes.
            //3. return null since we made this action.
        
        
        return null; 
    }
    
    public boolean IsGameActive(){
        if(party.getHealth() == 0 || groms.getHealth() == 0)
        {
            return false;
        }
        return true;
        
    }

    private boolean IsNPC(Entity entity) {
        boolean isnpc = false;
        for (Entity en : groms.getMembers()) {
            if (en == entity) {
                isnpc = true;
            }
        }
        return isnpc;
    }

    private void createRoster() {
        roster.addAll(party.getMembers());
        roster.addAll(groms.getMembers());
    }

    private void orderRoster() {
        Collections.sort(roster, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return o1.getInitiative() - o2.getInitiative();
            }
        });
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public void setGroms(Party groms) {
        this.groms = groms;
    }

}
