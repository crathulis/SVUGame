/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame;

import java.awt.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.lwjgl.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author craig.reese
 */
public class SVUGame extends StateBasedGame { 

   

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new ScalableGame(new SVUGame("SVU Game"), 160, 160, true));  //making our game area stretch so it's not crazy tiny
        //app.setDisplayMode(160, 160, false);
        app.setDisplayMode(800, 600, false);  //final size of container
        app.setTargetFrameRate(60);
        app.start();
    }

    public SVUGame(String title) {
        super(title);
        addState(new Overworld());
        addState(new Battle());
        addState(new StartState());
        addState(new PauseState());
        addState(new City1());
       // enterState(1);  
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    

}
