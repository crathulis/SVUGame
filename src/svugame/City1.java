/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame;

import org.newdawn.slick.Animation;
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
import org.newdawn.slick.state.transition.RotateTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author craig.reese
 */

//test1

//kevin test 1
public class City1 extends BasicGameState {

    private int ID = 3;
    private TiledMap currentMap;
    private Animation sprite, up, down, left, right;
    private boolean[][] blocked;
     private float playerx = 64f, playery = 64f;
      private static final int SIZE = 16;//size of our tiles
      private float screenx, screeny;
      Camera camera;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/bigmap.tmx");
        currentMap = startMap;

        Image[] movementUp = {new Image("data/charUp.png"), new Image("data/charWalkUp.png")};
        Image[] movementDown = {new Image("data/charDown.png"), new Image("data/charWalkDown.png")};
        Image[] movementLeft = {new Image("data/charLeft.png"), new Image("data/charWalkLeft.png")};
        Image[] movementRight = {new Image("data/charRight.png"), new Image("data/charWalkRight.png")};
        int[] duration = {300, 300};

        up = new Animation(movementUp, duration, false);
        down = new Animation(movementDown, duration, false);
        left = new Animation(movementLeft, duration, false);
        right = new Animation(movementRight, duration, false);

        //initial way our character is facing at start of game
        sprite = down;
        
        screenx = 50;
        screeny = 80;
        
        camera = new Camera(gc,startMap);
        
        
 buildBlockArray();
    }
    
    private void buildBlockArray() {
        
        blocked = new boolean[currentMap.getWidth()][currentMap.getHeight()];
        for (int xAxis = 0; xAxis < currentMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < currentMap.getHeight(); yAxis++) {
                int tileID = currentMap.getTileId(xAxis, yAxis, 1);
                int tileID2 = currentMap.getTileId(xAxis, yAxis, 2);
                String value = currentMap.getTileProperty(tileID, "blocked", "false");
                String value2 = currentMap.getTileProperty(tileID2, "blocked", "false");
                if (value.equals("true") || value2.equals("true")) {
                    blocked[xAxis][yAxis] = true;
                }
                //TODO:  make collision better
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
       // currentMap.render(0, 0,(int)screenx,(int)screeny,10,10);
        
        camera.drawMap();
        camera.translateGraphics();
       sprite.draw( playerx,  playery);
       
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        double speed = .1; // this is how fast our char can move .03 is good
        boolean collision = true;

        if (input.isKeyDown(Input.KEY_UP)) {
            sprite = up;

            if (!isBlocked((playerx), (float) (playery - i * speed),sbg)) {
                collision = false;
            }
            if (collision == false) {
                sprite.update(i);
                playery -= i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            sprite = down;

            if (!isBlocked((playerx), (float) (playery + i * speed),sbg)) {
                collision = false;
            }
            if (collision == false) {
                sprite.update(i);
                playery += i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            sprite = left;

            if (!isBlocked((float) (playerx - i * speed), playery,sbg)) {
                collision = false;
            }

            if (playerx + 7 < 0) {
                //we've reached the right edge of the screen
               // transition("left");
            }

            if (collision == false) {
                sprite.update(i);
                playerx -= i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            sprite = right;
            if (playerx + 9 > currentMap.getWidth() * SIZE) {
                //we've reached the right edge of the screen
               // transition("right");
            }
            if (!isBlocked((float) (playerx + i * speed), playery,sbg)) {
                collision = false;
            }
            //check to see if we're at the edge of the map
            //we can see that if startx == mapsize (160)
            //look up tile, from that we can get a transition
            //System.out.println("Player: " + (playerx +9) + " | Map size: " + (currentMap.getWidth()*SIZE));

            if (collision == false) {
                sprite.update(i);
                playerx += i * speed;
            }
        }
        camera.centerOn(playerx,playery);
        if (gc.getInput().isKeyPressed(Input.KEY_0)) {
            sbg.enterState(1, new FadeOutTransition(Color.black,1000), new FadeInTransition(Color.black,1000));
        }
        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            gc.exit();
        }
        if (input.isKeyDown(Input.KEY_P)) {
            //Pause screen
            //Image test = new Image(sbg.getContainer().getHeight(),sbg.getContainer().getWidth());
            //sbg.getContainer().getGraphics().copyArea(test,sbg.getContainer().getHeight(),sbg.getContainer().getWidth());
            sbg.enterState(5, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        } else if (input.isKeyDown(Input.KEY_S)) {
            //Start screen
            sbg.enterState(4, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        }
    }

    private boolean isBlocked(float x, float y, StateBasedGame sbg) throws SlickException {
        int xBlock = (int) (x + 8) / SIZE;
        int yBlock = (int) (y + 9) / SIZE;
        //we need to see if something that is blocked can cause a transition
        //so lets see if the tile we are standing on has a transitiondoor value
        int tileID = currentMap.getTileId((int) playerx / 16, (int) playery / 16, 0);
        String value = currentMap.getTileProperty(tileID, "transitiondoor", "false");
        if (!value.equals("false")) {
            //changing this to enter a new state

            sbg.enterState(3, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));

            //currentMap = new TiledMap("data/" + value + ".tmx");
            //rebuild blocking
            //buildBlockArray();
            //now we move our character on the new map
            //playerx = 1;
            return false;
        }
        return blocked[xBlock][yBlock];
    }

}
