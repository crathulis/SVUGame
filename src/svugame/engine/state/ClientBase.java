/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author craig.reese
 */
public abstract class ClientBase<T> extends StateBasedGame {

    private T gameData = null;

    public ClientBase(String name, T theGameData) {
        super(name);
        setGameData(theGameData);
    }

    private void setGameData(T theGameData) {
        gameData = theGameData;
    }

    public T getGameData(){
        return gameData;
    }

}
