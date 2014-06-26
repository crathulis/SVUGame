/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame;

import java.awt.Color;
import org.lwjgl.*;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.tiled.TiledMap;
import svugame.engine.state.ArenaState;
import svugame.engine.state.Battle;
import svugame.engine.state.CharCreation;
import svugame.engine.state.ClientBase;
import svugame.engine.state.GameData;
import svugame.engine.state.Map;
import svugame.engine.state.NewOverworld;
import svugame.engine.state.NewStart;
import svugame.engine.state.Overworld;
import svugame.engine.state.PauseState;
import svugame.engine.state.States;

/**
 *
 * @author craig.reese
 */
public class SVUGame extends ClientBase<GameData> { 

   

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new ScalableGame(new SVUGame("SVU Game"), 800   , 600, false)); 
        //AppGameContainer app = new AppGameContainer(new ScalableGame(new SVUGame("SVU Game"), 160, 160, true));

//making our game area stretch so it's not crazy tiny
        //app.setDisplayMode(160, 160, false);
        app.setDisplayMode(800, 600, false);  //final size of container
        app.setTargetFrameRate(60);
        app.start();
    }

    public SVUGame(String title) {
        super(title,new GameData());
          
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
       addState(new NewOverworld(this, States.NewOverworld));
        addState(new Battle(this,States.Battle));
        //addState(new Overworld());
        addState(new Map(this, States.Map));
        addState(new NewStart(this,States.NewStart));
        addState(new PauseState());
        addState(new City1());
        addState(new CharCreation(this,States.CharCreation));
        addState(new ArenaState(this,States.ArenaState));
       enterState(10); 
    }
    
    

    

}
