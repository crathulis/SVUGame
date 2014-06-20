/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.engine.state;

import org.newdawn.slick.Animation;
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
public class Map extends GameStateBase<GameData,States> {

    TiledMap startMap;
    float scalex = 0f;
    float scaley = 0f;
    float mousedownx;
    float mousedowny;
    int currentrenderx = 0;
    int currentrendery = 0;
    float counter = 0;
    float playerx;
    float playery;
    Animation player;

    public Map(ClientBase<GameData> theClient, States theState) {
        super(theClient, theState);
    }

    @Override
    public int getID() {
        return 9;

    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       
        startMap = new TiledMap("data/WorldMap.tmx");
        float x = startMap.getWidth() * 32;
        float y = startMap.getHeight() * 32;
        scalex = 800 / x;
        scaley = 600 / y;
        System.out.println("scalex: " + scalex + " scaley: " + scaley);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tileid = startMap.getTileId(i, j, 3);
                startMap.setTileId(i, j, 3, 1);
            }
        }

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        //grphcs.scale(scalex, scaley);
        grphcs.scale(.5f, .5f);
        /*
         for(int i =0;i<startMap.getWidth();i++)
         {
         for(int j =0;i<startMap.getHeight();i++)
         {
         startMap.render(i, j,0,0,startMap.getWidth(),startMap.getHeight(),0,true);
         startMap.render(i, j,0,0,startMap.getWidth(),startMap.getHeight(),1,true);
         startMap.render(i, j,0,0,startMap.getWidth(),startMap.getHeight(),2,true);
         }
         }
         */
        startMap.render(0, 0, currentrenderx, currentrendery, startMap.getWidth(), startMap.getHeight(),0,false);
        startMap.render(0, 0, currentrenderx, currentrendery, startMap.getWidth(), startMap.getHeight(),1,false);
        startMap.render(0, 0, currentrenderx, currentrendery, startMap.getWidth(), startMap.getHeight(),2,false);
        grphcs.scale(2, 2);
        player.draw(( playerx-(currentrenderx*32))/2, ( playery-(currentrendery*32))/2);
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        player.update(i);
        counter += i;
        if (gc.getInput().isKeyPressed(Input.KEY_M)) {
            sbg.enterState(8);
        }
        if (gc.getInput().isMousePressed(0)) {
            //setting initial location
            mousedownx = gc.getInput().getMouseX();
            mousedowny = gc.getInput().getMouseY();
        }
        if (gc.getInput().isMouseButtonDown(0)) {
            //as the mouse gets dragged around the container, we want to get the differeance between the starting location and the current location
            //then we devide that number by 32, then we set the rended area as such
            //if (counter > 100) {
            // counter = 0;

            float differancex = gc.getInput().getMouseX() - mousedownx;
            float differancey = gc.getInput().getMouseY() - mousedowny;
            float tilediffx = differancex / 32;
            float tilediffy = differancey / 32;
            int changeintx = currentrenderx - (int) tilediffx *2;
            int changeinty = currentrendery - (int) tilediffy*2;
            
            
            if(changeintx != currentrenderx || changeinty != currentrendery){
            mousedownx = gc.getInput().getMouseX();
            mousedowny = gc.getInput().getMouseY();
            currentrenderx = currentrenderx - (int) tilediffx *2;
            currentrendery = currentrendery - (int) tilediffy *2;
        }
            System.out.println("mouse down");
            //}
        }
    }
    
     @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
         GameData theGameData = getClient().getGameData();
         //the positions we get from gamedata need to be where the camera is centered
         //int cameracornerx = (int)theGameData.getCameraPosition().getX()- ((gc.getWidth() / startMap.getTileHeight()) );
         //int cameracornery = (int)theGameData.getCameraPosition().getY()- ((gc.getHeight() / startMap.getTileHeight()) );
         int cameracornerx = (int) ((int) theGameData.getPlayerPosition().getX()-(.25*gc.getWidth()))/32;
         int cameracornery = (int) ((int) theGameData.getPlayerPosition().getY()-(.25*gc.getHeight()))/32;
         
        currentrenderx = cameracornerx;
        currentrendery = cameracornery;
        
        playerx = theGameData.getPlayerPosition().getX();
        playery = theGameData.getPlayerPosition().getY();
        this.player = theGameData.getPlayerSprite();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
