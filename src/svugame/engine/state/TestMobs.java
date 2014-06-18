/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.engine.state;

import svugame.model.entity.Entity;
import svugame.model.entity.Party;

/**
 *
 * @author Student
 */
public class TestMobs {
    
    public TestMobs(){
        createEnemyParty();
        createPlayerParty();
    }
    
    public Party getEnemyParty(){
        return mobParty;
    }
    
    public Party getPlayerParty(){
        return playerParty;
    }
    
    private void createEnemyParty(){
        wolf1 = new Entity("Wolf", true, 10);
        wolf2 = new Entity("Wolf", true, 10);
        wolf3 = new Entity("Wolf", true, 10);
        mobParty = new Party();
        mobParty.add(wolf1);
        mobParty.add(wolf2);
        mobParty.add(wolf3);
    }
    
    private void createPlayerParty(){
        player = new Entity("Player", true, 20);
        bernard =  new Entity("Bernard", true, 20);
        playerParty = new Party();
        playerParty.add(player);
        playerParty.add(bernard);
    }
    
    private Party mobParty;
    private Party playerParty;
    private Entity wolf1;
    private Entity wolf2;
    private Entity wolf3;
    private Entity player;
    private Entity bernard;
}
