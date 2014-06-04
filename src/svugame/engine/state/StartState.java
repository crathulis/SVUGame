/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
public class StartState extends BasicGameState{
    
    private int ID = 4;
    private TiledMap currentMap;
    private int tempx;
    private int tempy;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/start.tmx");
        currentMap = startMap;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        currentMap.render(0, 0);
    }
    

    @Override
    public void update(GameContainer gc, final StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        //input.addMouseListener(sbg);
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            System.out.println(input.getMouseX() +":"+ input.getMouseY());
            if( input.getMouseX()>=16 && input.getMouseX() < 143 && input.getMouseY()>=32 && input.getMouseY() <48){
                //currently just goes back to world but needs to go to new state to start new game.
                    sbg.enterState(1, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
                }
            if( input.getMouseX()>=16 && input.getMouseX() < 143 && input.getMouseY()>=64 && input.getMouseY() <95){
                    //need code to load a saved game
                    //sbg.enterState(1, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
                }
            if( input.getMouseX()>=48 && input.getMouseX() < 111 && input.getMouseY()>=112 && input.getMouseY() <127){
                //exits game
                    gc.exit();
                }
        }
//                
    }
    
}
