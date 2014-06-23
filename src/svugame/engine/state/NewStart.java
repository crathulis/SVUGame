/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author craig.reese
 */
public class NewStart extends GameStateBase implements ComponentListener{
    
    Image logo;
    Image newgame;
    Image continuegame;
    Image options;
    Image quit;
    Image newgameroll;
    Image continuegameroll;
    Image optionsroll;
    Image quitroll;
    int logox;
    int newgamex;
    int continuex;
    int optionsx;
    int quitx;
    private MouseOverArea[] areas = new MouseOverArea[4];
    private StateBasedGame sbg;

    public NewStart(ClientBase theClient, StateBase theState) {
        super(theClient, theState);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
        logo = new Image("data/SVULogo.png");
        newgame = new Image("data/newgame.png");
        continuegame = new Image("data/loadgame.png");
        options = new Image("data/options.png");
        quit = new Image("data/quitgame.png");
        newgameroll = new Image("data/newgameglow.png");
        continuegameroll = new Image("data/loadgameglow.png");
        optionsroll = new Image("data/optionsglow.png");
        quitroll = new Image("data/quitgameglow.png");
        int logowidth = logo.getWidth();
        logox = (gc.getWidth()-logowidth)/2;
        newgamex = (gc.getWidth()-newgame.getWidth())/2;
        continuex = (gc.getWidth()-continuegame.getWidth())/2;
        optionsx = (gc.getWidth()-options.getWidth())/2;
        quitx = (gc.getWidth()-quit.getWidth())/2;
        areas[0] = new MouseOverArea(gc,newgame,newgamex,300,this);
        areas[0].setMouseOverImage(newgameroll);
        areas[1] = new MouseOverArea(gc,continuegame,continuex,350,this);
        areas[1].setMouseOverImage(continuegameroll);
        areas[2] = new MouseOverArea(gc,options,optionsx,400,this);
        areas[2].setMouseOverImage(optionsroll);
        areas[3] = new MouseOverArea(gc,quit,quitx,450,this);
        areas[3].setMouseOverImage(quitroll);
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        logo.draw(logox, 100);
        for(int i = 0;i<areas.length;i++)
        {
            areas[i].render(gc, grphcs);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
    }
    
    public void componentActivated(AbstractComponent source) {
		System.out.println("ACTIVL : "+source);
                if(source == areas[0])
                {
                    sbg.enterState(11);
                }
		for (int i=0;i<4;i++) {
			if (source == areas[i]) {
				System.out.println("Option "+(i+1)+" pressed!");
			}
		}
		
	}

    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void keyPressed(int i, char c) {
    }

    @Override
    public void keyReleased(int i, char c) {
    }

    @Override
    public void controllerLeftPressed(int i) {
    }

    @Override
    public void controllerLeftReleased(int i) {
    }

    @Override
    public void controllerRightPressed(int i) {
    }

    @Override
    public void controllerRightReleased(int i) {
    }

    @Override
    public void controllerUpPressed(int i) {
    }

    @Override
    public void controllerUpReleased(int i) {
    }

    @Override
    public void controllerDownPressed(int i) {
    }

    @Override
    public void controllerDownReleased(int i) {
    }

    @Override
    public void controllerButtonPressed(int i, int i1) {
    }

    @Override
    public void controllerButtonReleased(int i, int i1) {
    }
    
    @Override
    public int getID() {
        return 10;
    }
    
}
