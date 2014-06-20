/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import org.newdawn.slick.state.GameState;

/**
 *
 * @author craig.reese
 */
public abstract class GameStateBase<T, U extends StateBase> implements GameState {
    private U state;
    private ClientBase<T> client;

    public GameStateBase(ClientBase<T> theClient,U theState){
        setClient(theClient);
    }

    private void setState(U theState) {
        state = theState;
    }

    public U getState(){
        return state;
    }

    private void setClient(ClientBase<T> theClient) {
        client = theClient;
    }

    public ClientBase<T> getClient(){
        return client;
    }

    @Override
    public int getID() {
        return getState().getValue();
    }

    @Override
    public boolean isAcceptingInput() {
        return getClient().getCurrentState()==this;
    }

    /* also contains stubs for other GameState methods */
}


