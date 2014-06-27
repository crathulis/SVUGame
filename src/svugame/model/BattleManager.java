/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model;

import HelperClasses.EffEntTar;
import HelperClasses.Effectandentity;
import HelperClasses.TurnMade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Random;
import svugame.model.action.Action;
import svugame.model.action.ActionFactory;
import svugame.model.action.Effect;
import svugame.model.entity.Entity;
import svugame.model.entity.Party;
import svugame.model.skills.SkillConstants;

/**
 * Battles are divided into rounds. Rounds consist of each participant in the
 * battle taking a turn in the order of initiative.
 *
 * @author alan.whitehurst
 */
public class BattleManager {

    private ArrayList<Entity> roster = new ArrayList();
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

    public ArrayList<Integer> getAbilities(Entity entity) {
        ArrayList<Integer> actionList = new ArrayList();
        for (int i = 0; i < SkillConstants.NUM_SKILLS; i++) {
            //System.out.println("test number: " + i);
            Action npcactiontest = ActionFactory.getInstance(entity, i, groms.getMembers().get(0), null);
            if (npcactiontest != null) {
                if (npcactiontest.isPossible()) {
                    actionList.add(i);
                }
            }
        }
        return actionList;
    }

    public ArrayList<EffEntTar> nextTurn(Entity actor, Entity target, int action) {
        ArrayList<EffEntTar> effectsList = new ArrayList();
        //rosterActivePlayer = 4;
        if (actor == null) {
            //first time we've run this, so lets get the first actor and see if it's an npc
            if (!IsNPC(roster.get(rosterActivePlayer))) {
                EffEntTar eet1 = new EffEntTar(null, null, null, roster.get(rosterActivePlayer));
                effectsList.add(eet1);
                return effectsList;
            }
            while (IsNPC(roster.get(rosterActivePlayer))) {
                Entity en = roster.get(rosterActivePlayer);
                //we need to get a list of actions that this entity can do
                ArrayList<Integer> actionList = new ArrayList();
                for (int i = 0; i < SkillConstants.NUM_SKILLS; i++) {
                    //System.out.println("test number: " + i);
                    Action npcactiontest = ActionFactory.getInstance(en, i, party.getMembers().get(0), null);
                    if (npcactiontest != null) {
                        if (npcactiontest.isPossible()) {
                            actionList.add(i);
                        }
                    }
                }

                for (int i = 0; i < actionList.size(); i++) {
                    en.addSkillPoints(actionList.get(i), 50);
                }
                //for (int j = 0; j < 10; j++) {
                //get random action
                int actionnum = (int) (Math.random() * actionList.size() - 1);
                int partynum = (int) (Math.random() * party.getMembers().size() - 1);
                Action npcaction = ActionFactory.getInstance(en, actionList.get(actionnum), party.getMembers().get(partynum), null);
                ArrayList<Effect> effects = npcaction.apply();

                for (Effect eff : effects) {
                    System.out.println("actiontype: " + npcaction.toString());
                    System.out.println("Result: " + eff.getResult() + " " + eff.getAmount());
                }
                if (rosterActivePlayer + 1 >= roster.size()) {
                    rosterActivePlayer = 0;
                    turn++;
                    orderRoster();
                } else {
                    rosterActivePlayer++;
                }
                EffEntTar eet = new EffEntTar(effects, en, party.getMembers().get(partynum), roster.get(rosterActivePlayer));
                effectsList.add(eet);
                // }
                // System.out.println("END RESULTS");
            }
            return effectsList;
        }
        //the only time we get here is if we sent the info

        Action pcaction = ActionFactory.getInstance(actor, action, target, null);
        ArrayList<Effect> pceffect = pcaction.apply();
        if (rosterActivePlayer + 1 >= roster.size()) {
            rosterActivePlayer = 0;
            turn++;
            orderRoster();
        } else {
            rosterActivePlayer++;
        }
        EffEntTar eet = new EffEntTar(pceffect, actor, target, roster.get(rosterActivePlayer));
        effectsList.add(eet);

        if (!IsNPC(roster.get(rosterActivePlayer))) {

            return effectsList;
        }
        while (IsNPC(roster.get(rosterActivePlayer)) ) {  //TODO: add check here for dead players
            Entity en = roster.get(rosterActivePlayer);
            //we need to get a list of actions that this entity can do
            ArrayList<Integer> actionList = new ArrayList();
            for (int i = 0; i < SkillConstants.NUM_SKILLS; i++) {
                //System.out.println("test number: " + i);
                Action npcactiontest = ActionFactory.getInstance(en, i, party.getMembers().get(0), null);
                if (npcactiontest != null) {
                    if (npcactiontest.isPossible()) {
                        actionList.add(i);
                    }
                }
            }

            for (int i = 0; i < actionList.size(); i++) {
                en.addSkillPoints(actionList.get(i), 50);
            }
            //for (int j = 0; j < 10; j++) {
            //get random action
            int actionnum = (int) (Math.random() * actionList.size() - 1);
            int partynum = (int) (Math.random() * party.getMembers().size() - 1);
            Action npcaction = ActionFactory.getInstance(en, actionList.get(actionnum), party.getMembers().get(partynum), null);
            ArrayList<Effect> effects = npcaction.apply();

            for (Effect eff : effects) {
                System.out.println("actiontype: " + npcaction.toString());
                System.out.println("Result: " + eff.getResult() + " " + eff.getAmount());
            }
            if (rosterActivePlayer + 1 >= roster.size()) {
                rosterActivePlayer = 0;
                turn++;
                orderRoster();
            } else {
                rosterActivePlayer++;
            }
            EffEntTar eet2 = new EffEntTar(effects, en, party.getMembers().get(partynum), roster.get(rosterActivePlayer));
            effectsList.add(eet2);
            // }
            // System.out.println("END RESULTS");
        }
        return effectsList;


        /*
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
         */
    }

    public boolean IsGameActive() {
        //System.out.println("party health: "+party.getHealth() + " groms health: " + groms.getHealth());
        if (party.getHealth() <= 0 || groms.getHealth() <= 0) {
            return false;
        }
        return true;

    }

    public boolean IsNPC(Entity entity) {
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

    public Party getParty() {
        return party;
    }

    public Party getGroms() {
        return groms;
    }

}
