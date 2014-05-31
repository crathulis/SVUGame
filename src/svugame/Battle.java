/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author craig.reese
 */
public class Battle extends BasicGameState {
    
     private int ID = 2;
    private TiledMap currentMap;
    Music battleMusic;

    @Override
    public int getID() {
       return ID;
    }
    
    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException
    {
        battleMusic = new Music("data/Boss_Battle_Loop_2.ogg");
        battleMusic.loop();
    }
    
    @Override
    public void leave(GameContainer container, StateBasedGame game)
    {
        battleMusic.stop();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/forestBattle.tmx");
        //TiledMap map2 = new TiledMap("data/map2.tmx");

        //TODO: build world map that has tile data for each sectional map, then parse world map to get map data.
        currentMap = startMap;
        
        //adding music
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        currentMap.render(0, 0);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_0)) {
           sbg.enterState(1, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
        } else if(input.isKeyDown(Input.KEY_9)) {
            battleMusic.stop();
             Music winMusic = new Music("data/6 Open Surge score jingle - AA.ogg");
             winMusic.play();
        }
        
    }
    
}
