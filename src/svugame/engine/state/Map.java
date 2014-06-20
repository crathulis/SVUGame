/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author craig.reese
 */
public class Map extends BasicGameState{
    TiledMap startMap;
    float scalex=0f;
    float scaley=0f;

    @Override
    public int getID() {
        return 9;
        
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        startMap = new TiledMap("data/WorldMap.tmx");
        float x = startMap.getWidth() *32;
        float y = startMap.getHeight() * 32;
        scalex = 800/x;
        scaley = 600/y;
        System.out.println("scalex: " + scalex + " scaley: " + scaley);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.scale(scalex, scaley);
        startMap.render(0, 0,0,0,startMap.getWidth(),startMap.getHeight());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_M)) {
            sbg.enterState(8);
        }
    }
    
}
