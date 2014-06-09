/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model;

import java.util.ArrayList;
import java.util.Enumeration;
import svugame.model.entity.Entity;

/**
 * Battles are divided into rounds. Rounds consist of each participant in the
 * battle taking a turn in the order of initiative.
 *
 * @author alan.whitehurst
 */
public class BattleManager implements Enumeration<Entity> {

    private ArrayList<Entity> roster;
    private ArrayList<Entity> party;
    private ArrayList<Entity> groms;

    @Override
    public boolean hasMoreElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity nextElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
