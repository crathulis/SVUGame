/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import HelperClasses.Position;
import java.awt.Dimension;
import mdes.slick.sui.Display;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.RotateTransition;
import org.newdawn.slick.tiled.TiledMap;
import svugame.Camera;

/**
 *
 * @author alanporter
 */
public class ArenaState  extends GameStateBase{
    
    
    private TiledMap currentMap;
    private Animation sprite, up, down, left, right;
    private boolean[][] blocked;
    private float playerx = 4f, playery = 21f;
    private static final int SIZE = 32;//size of our tiles
    private float screenx, screeny;
    Boolean convoActive = false;
    private Display display;
    //Camera camera;
    SpriteSheet spritesheet;
    private Dimension renderedArea = new Dimension(0,9);  //this is where our camera will start
    

    public ArenaState(ClientBase theClient, StateBase theState) {
        super(theClient, theState);
    }

    @Override
    public int getID() {
        return 12;
    }

    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
         TiledMap startMap = new TiledMap("data/ArenaMap.tmx");
        
        currentMap = startMap;
        spritesheet = new SpriteSheet("data/ranger_f.png", 32, 36);
         Image[] movementUp = {spritesheet.getSprite(0, 0), spritesheet.getSprite(1, 0), spritesheet.getSprite(2, 0), spritesheet.getSprite(1, 0)};
        Image[] movementDown = {spritesheet.getSprite(0, 2), spritesheet.getSprite(1, 2), spritesheet.getSprite(2, 2), spritesheet.getSprite(1, 2)};
        Image[] movementLeft = {spritesheet.getSprite(0, 3), spritesheet.getSprite(1, 3), spritesheet.getSprite(2, 3), spritesheet.getSprite(1, 3)};
        Image[] movementRight = {spritesheet.getSprite(0, 1), spritesheet.getSprite(1, 1), spritesheet.getSprite(2, 1), spritesheet.getSprite(1, 1)};
        int[] duration = {300, 300, 300, 300};
        up = new Animation(movementUp, duration, false);
        down = new Animation(movementDown, duration, false);
        left = new Animation(movementLeft, duration, false);
        right = new Animation(movementRight, duration, false);
        sprite = down;
        GameData gameData = (GameData) getClient().getGameData();
        gameData.setPlayerSprite(down);
        
//        screenx = 50;
//        screeny = 80;

        //camera = new Camera(gc, startMap);

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
        grphcs.scale(2, 2);
        //camera.drawMap();
        //camera.translateGraphics();
        currentMap.render(0, 0, renderedArea.width, renderedArea.height, 10, 14,false);
        sprite.draw( playerx,  playery);
        if (this.convoActive == true) {
            grphcs.scale(0.2f, 0.2f);
            display.render(gc, grphcs);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
       Input input = gc.getInput();
        double speed = .1; // this is how fast our char can move .03 is good
        boolean collision = false;
        
        //System.out.println("height: " + gc.getHeight()/32 + " width: " + gc.getWidth()/32 + "currentmapx: " + renderedArea.width + " currentmapy: " + renderedArea.height);
        
        

        if (input.isKeyDown(Input.KEY_UP)) {
            sprite = up;
            /*
             if (!isBlocked((playerx), (float) (playery - i * speed), sbg)) {
             collision = false;
             }
             */
            
            if(playery - (i*speed) < 0)
            {
                //we will transition the screen up
                System.out.println("transition up");
                transition("up",gc);
            }
            
            if (collision == false) {
                sprite.update(i);
                playery -= i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            sprite = down;
            /*
             if (!isBlocked((playerx), (float) (playery + 6 + i * speed), sbg)) {
             collision = false;
             }
             */
            if(playery + (i*speed) > 300)
            {
                //we will transition the screen up
                System.out.println("transition down");
                transition("down",gc);
            }
            
            
            if (collision == false) {
                sprite.update(i);
                playery += i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            sprite = left;
            /*
             if (!isBlocked((float) (playerx - 3 - i * speed), playery + 6, sbg)) {
             collision = false;
             }

             if (playerx - 7 < 0) {
             //we've reached the right edge of the screen
             transition("left");
             }
             */
            
            if(playerx - (i*speed) < 0)
            {
                //we will transition the screen up
                System.out.println("transition left");
                transition("left",gc);
            }
            
            if (collision == false) {
                sprite.update(i);
                playerx -= i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            sprite = right;
            /*
             if (playerx + 12 > currentMap.getWidth() * SIZE) {
             //we've reached the right edge of the screen
             transition("right");
             }
             if (!isBlocked((float) (playerx + 3 + i * speed), playery + 6, sbg)) {
             collision = false;
             }
             */
            //check to see if we're at the edge of the map
            //we can see that if startx == mapsize (160)
            //look up tile, from that we can get a transition
           if(playerx + (i*speed) > 400)
            {
                //we will transition the screen up
                System.out.println("transition right");
                transition("right",gc);
            }

            if (collision == false) {
                sprite.update(i);
                playerx += i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_0)) {
            //Battle screen
            sbg.enterState(2, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        } else if (input.isKeyDown(Input.KEY_P)) {
            //Pause screen
            //Image test = new Image(sbg.getContainer().getHeight(),sbg.getContainer().getWidth());
            //sbg.getContainer().getGraphics().copyArea(test,sbg.getContainer().getHeight(),sbg.getContainer().getWidth());
            sbg.enterState(5, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        } else if (input.isKeyDown(Input.KEY_S)) {
            //Start screen
            sbg.enterState(4, new RotateTransition(Color.black), new RotateTransition(Color.black));
        }

        // display.update(gc, i);
        if (input.isKeyDown(Input.KEY_SPACE)) {
            //removes displayed message
            display.removeAll();
        }
        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            gc.exit();
        }

        if (gc.getInput().isKeyPressed(Input.KEY_C)) {
        }
        
        if (gc.getInput().isKeyPressed(Input.KEY_M)) {
            GameData thedata = (GameData) getClient().getGameData();
            //get half of the rendered area + etc /2 for both gets middle 25, 18
            int middlex = renderedArea.width ;
            int middley = renderedArea.height ;
            thedata.setCameraPosition(new Position(middlex,middley));
            thedata.setPlayerPosition(new Position((renderedArea.width*32)+playerx,(renderedArea.height*32)+playery));
            thedata.setRelativePlayerPosition(new Position(playerx,playery));
            //thedata.setFog(fog);
            
            sbg.enterState(9);
        }
        
        

        if (convoActive == true) {
            if (input.isKeyPressed(Input.KEY_ENTER)) {
                // ExecuteDialogue();
            }
        }
    }
    
    private void transition(String direction, GameContainer gc) throws SlickException {
        //TODO: add searching for correct layer
        switch(direction)
        {
            case "right":
                int endpoint = renderedArea.width + (gc.getWidth()/32) /2;
                
                
                    renderedArea.width = endpoint;
            
                
            
            //now we move our character on the new map
            playerx = 1;
                break;
                
            case "left":
                int checkleft = renderedArea.width - ((gc.getWidth()/32) /2);
            if(checkleft >= 0)
            {
                renderedArea.width = checkleft;
            //now we move our character on the new map
            playerx = 360;
            }
            
                
                break;
                
            case "up":
                int checkup = renderedArea.height - (gc.getHeight()/32) /2;
            if(checkup >= 0)
            {
                renderedArea.height = checkup;
                playery = 260;
            }
                
                break;
                
            case "down":
                renderedArea.height += (gc.getHeight()/32) /2;
                playery = 1;
                break;
        }
       //clearFog(renderedArea.width, renderedArea.height, 12, 9);

        
    }
    
    

    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
    }

    @Override
    public void leave(GameContainer gc, StateBasedGame sbg) throws SlickException {}

    @Override
    public void mouseWheelMoved(int i) {}

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {}

    @Override
    public void mousePressed(int i, int i1, int i2) {}

    @Override
    public void mouseReleased(int i, int i1, int i2) {}

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {}
    
    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {}

    @Override
    public void setInput(Input input) {}

    @Override
    public void inputEnded() {}

    @Override
    public void inputStarted() {}

    @Override
    public void keyPressed(int i, char c) {}

    @Override
    public void keyReleased(int i, char c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerLeftPressed(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerLeftReleased(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerRightPressed(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerRightReleased(int i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerUpPressed(int i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerUpReleased(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerDownPressed(int i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerDownReleased(int i) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerButtonPressed(int i, int i1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void controllerButtonReleased(int i, int i1) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
