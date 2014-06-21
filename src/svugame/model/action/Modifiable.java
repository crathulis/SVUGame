/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.action;

import java.util.ArrayList;

/**
 *
 * @author Alan
 */
public interface Modifiable {

    public ArrayList<Modifier> getMods();

    public void setMods(ArrayList<Modifier> mods);

    public void addMods(Modifier mod);

    public void update();

    public void dispell();

}
