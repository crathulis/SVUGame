/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Alan
 */
public class PauseState extends BasicGameState{
    
    private int ID = 5;
    private TiledMap currentMap;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/paused.tmx");
        currentMap = startMap;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        currentMap.render(0, 0);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_P)) {
            //need to find way to know what the previous state was.
           sbg.enterState(1, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
           //sbg.getContainer().getGraphics().setBackground(Color.yellow);
        }
    }
    
}
