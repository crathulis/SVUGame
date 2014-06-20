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
public class Map extends GameStateBase<GameData, States> {

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
    float scale = .5f;
    boolean[][] fog;

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

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        //grphcs.scale(scalex, scaley);
        grphcs.scale(scale, scale);
        /*
         for (int i = currentrenderx; i < currentrenderx + 25; i++) {
         for (int j = currentrendery; i < currentrendery + 18; i++) {
         if(fog[i][j] == false)
         {
         startMap.render(i, j, currentrenderx, currentrenderx, startMap.getWidth(), startMap.getHeight(), 0, false);
         startMap.render(i, j, currentrenderx, currentrenderx, startMap.getWidth(), startMap.getHeight(), 1, false);
         startMap.render(i, j, currentrenderx, currentrenderx, startMap.getWidth(), startMap.getHeight(), 2, false);
         System.out.println("no fog at: " + i+ "," + j);
         } else
         {
         startMap.render(i, j, currentrenderx, currentrenderx, startMap.getWidth(), startMap.getHeight(), 3, false);
         }
         }
         }
         */
        startMap.render(0, 0, currentrenderx, currentrendery, startMap.getWidth(), startMap.getHeight());
        //startMap.render(0, 0, currentrenderx, currentrendery, startMap.getWidth(), startMap.getHeight(), 1, false);
        //startMap.render(0, 0, currentrenderx, currentrendery, startMap.getWidth(), startMap.getHeight(), 2, false);
        grphcs.scale(2, 2);
        player.draw((playerx - (currentrenderx * 32)) / 2, (playery - (currentrendery * 32)) / 2);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        player.update(i);
        counter += i;
        if (gc.getInput().isKeyPressed(Input.KEY_M)) {
            sbg.enterState(8);
        }

        if (gc.getInput().isKeyPressed(Input.KEY_C)) {
            for (int i2 = 0; i2 < startMap.getWidth(); i2++) {
                for (int j = 0; j < startMap.getHeight(); j++) {
                    
                        startMap.setTileId(i2, j, 3, 1);
                    
                }
            }
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
            int changeintx = currentrenderx - (int) tilediffx * 2;
            int changeinty = currentrendery - (int) tilediffy * 2;

            if (changeintx != currentrenderx || changeinty != currentrendery) {
                mousedownx = gc.getInput().getMouseX();
                mousedowny = gc.getInput().getMouseY();

                int possiblex = currentrenderx - (int) tilediffx * 2;
                int possibley = currentrendery - (int) tilediffy * 2;

                int xmaxcalc = (int) (possiblex + (gc.getWidth() / (32 * scale)));
                int ymaxcalc = (int) (possibley + (gc.getHeight() / (32 * scale)));

                if (xmaxcalc < startMap.getWidth() && possiblex > 0) {
                    currentrenderx = possiblex;
                }
                if (ymaxcalc < startMap.getHeight() && possibley > 0) {
                    currentrendery = possibley;
                }
                System.out.println("possiblex: " + possiblex + " calc: " + xmaxcalc + " map width: " + startMap.getWidth());

            }
            //System.out.println("mouse down");
            //}
        }
    }

    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        GameData theGameData = getClient().getGameData();
        //the positions we get from gamedata need to be where the camera is centered
        //int cameracornerx = (int)theGameData.getCameraPosition().getX()- ((gc.getWidth() / startMap.getTileHeight()) );
        //int cameracornery = (int)theGameData.getCameraPosition().getY()- ((gc.getHeight() / startMap.getTileHeight()) );
        //int cameracornerx = (int) ((int) theGameData.getPlayerPosition().getX()-(.25*gc.getWidth()))/32;
        //int cameracornery = (int) ((int) theGameData.getPlayerPosition().getY()-(.25*gc.getHeight()))/32;
        int cameracornerx = (int) (theGameData.getCameraPosition().getX() - 25 + (theGameData.getRelativePlayerPosition().getX() / 32));
        int cameracornery = (int) (theGameData.getCameraPosition().getY() - 18 + (theGameData.getRelativePlayerPosition().getY() / 32));

        currentrenderx = cameracornerx;
        currentrendery = cameracornery;

        playerx = theGameData.getPlayerPosition().getX();
        playery = theGameData.getPlayerPosition().getY();
        this.player = theGameData.getPlayerSprite();

        fog = theGameData.getFog();

        for (int i = 0; i < startMap.getWidth(); i++) {
            for (int j = 0; j < startMap.getHeight(); j++) {
                if (fog[i][j] == false) {
                    startMap.setTileId(i, j, 3, 1);
                }
            }
        }
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void mouseWheelMoved(int i) {
        if (i < 0 && scale > .15f) {
            scale = (float) (scale - .05);
            //do check to see if we scaled off of map
        } else if (i > 0 && scale < 1.25f) {
            scale = (float) (scale + .05);
        } else if (i < 0 && scale <= .15) {
            currentrenderx = 0;
            currentrendery = 0;
            scale = .15f;
            //do check to see if we scaled off of the map
        } else if (i > 0 && scale > 1.25f) {
            scale = 1.25f;
        }
        System.out.println("scale: " + scale);
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
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
