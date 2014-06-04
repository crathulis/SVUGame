/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame;

import java.awt.Font;
import java.awt.GridLayout;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import mdes.slick.sui.*;
import mdes.slick.sui.layout.LayoutManager;
import mdes.slick.sui.layout.RowLayout;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.CombinedTransition;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.RotateTransition;
import org.newdawn.slick.state.transition.VerticalSplitTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author craig.reese
 */
public class Overworld extends BasicGameState {  //public class Overworld extends BasicGameState

    private int ID = 1;
    private TiledMap currentMap;
    private Animation sprite, up, down, left, right;
    private float playerx = 64f, playery = 64f;
    private boolean[][] blocked;
    private static final int SIZE = 16;//size of our tiles
    Music music;
    private Display display;
    Container content;
    Boolean convoActive = false;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //this is our starting map
        TiledMap startMap = new TiledMap("data/map1.tmx");
        //TiledMap map2 = new TiledMap("data/map2.tmx");

        //TODO: build world map that has tile data for each sectional map, then parse world map to get map data.
        currentMap = startMap;

        //we're animating 2 steps here
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

        //now we build what can be walked on.
        buildBlockArray();

        //******* Start test for gui *********//
        display = new Display(gc);

        content = new Container();
        content.setSize(160, 60); //sets panel size
        content.setLocation(0, 100); //sets panel loc relative to parent (display)
        content.setOpaque(true); //ensures that the background is drawn
        content.setBackground(Color.lightGray); //sets the background color

        RowLayout layout = new RowLayout(true, RowLayout.LEFT, RowLayout.CENTER);
        content.setLayout(layout);
        //GridLayout test = new GridLayout(1,5);
        // content.setLayout(test);

       // LayoutManager mng
        /*
         Button btn = new Button("No where");
         Font f = new Font("Serif", Font.BOLD, 10);
         UnicodeFont ufont = new UnicodeFont(f, f.getSize(), f.isBold(), f.isItalic());
         ufont.addAsciiGlyphs();
         ufont.addGlyphs(16, 16);
         ufont.getEffects().add(new ColorEffect(java.awt.Color.BLACK));
         ufont.loadGlyphs();
         btn.setFont(ufont);
         btn.pack(); //pack the button to the text
         content.add(btn);

         */
        //Label label = new Label("Where am I?");
        String startString = "Press Enter to continue conversation";
        convoActive = true;

        displayLabel(startString, content);

    }

    private void displayLabel(String s, Container c) {
        int totalLetters = s.length();
        //sleep(1000);
        //TODO: add wipes for old content
        Label label = new Label(s);
        label.setForeground(Color.white); //sets the foreground (text) color
        label.pack(); //pack the label with the current text, font and padding
        label.setHeight(10); //set same size between the two components
        c.add(label); //add the label to this display so it can be rendered
        display.add(c);
        /*
         for (int i = 0; i < totalLetters; i++) {
         Label label = new Label(s.substring(0, i));
         label.setForeground(Color.white); //sets the foreground (text) color
         label.pack(); //pack the label with the current text, font and padding
         label.setHeight(10); //set same size between the two components
         c.add(label); //add the label to this display so it can be rendered
         display.add(c);
         // sleep(1000);
         }
         */
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        music = new Music("data/Distraught_Princess_0.ogg");
        music.loop();
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
        music.stop();
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
        currentMap.render(0, 0);
        sprite.draw((int) playerx, (int) playery);

        display.render(gc, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        Input input = gc.getInput();
        double speed = .03; // this is how fast our char can move .03 is good
        boolean collision = true;

        if (input.isKeyDown(Input.KEY_UP)) {
            sprite = up;

            if (!isBlocked((playerx), (float) (playery - i * speed), sbg)) {
                collision = false;
            }
            if (collision == false) {
                sprite.update(i);
                playery -= i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            sprite = down;

            if (!isBlocked((playerx), (float) (playery + 6 + i * speed), sbg)) {
                collision = false;
            }
            if (collision == false) {
                sprite.update(i);
                playery += i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            sprite = left;

            if (!isBlocked((float) (playerx - 3 - i * speed), playery + 6, sbg)) {
                collision = false;
            }

            if (playerx + 7 < 0) {
                //we've reached the right edge of the screen
                transition("left");
            }

            if (collision == false) {
                sprite.update(i);
                playerx -= i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            sprite = right;
            if (playerx + 9 > currentMap.getWidth() * SIZE) {
                //we've reached the right edge of the screen
                transition("right");
            }
            if (!isBlocked((float) (playerx + 3 + i * speed), playery + 6, sbg)) {
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
            sbg.enterState(4, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        }

        display.update(gc, i);
        if (input.isKeyDown(Input.KEY_SPACE)) {
            //removes displayed message
            display.removeAll();
        }
        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            gc.exit();
        }

        if (convoActive == true) {
            if (input.isKeyDown(Input.KEY_ENTER)) {
                //we're in a dialogue, we need to advance the dialogue options
                //when a user presses enter, we need to find which dialogue option they are on and 
                //pass that to the dialogue handler (ExecuteDialogue)
                ConversationTest convo = new ConversationTest();
                ArrayList convos = convo.GetNext(null);
            }
        }
    }
    
    private ConvoPart ExecuteDialogue(ConvoPart part)
    {
        return null;
        
    }

    private void transition(String direction) throws SlickException {
        //TODO: add searching for correct layer
        int tileID = currentMap.getTileId((int) playerx / 16, (int) playery / 16, 0);
        if (direction.equals("right")) {
            String value = currentMap.getTileProperty(tileID, "transitionr", "false");
            currentMap = new TiledMap("data/" + value + ".tmx");
            //rebuild blocking
            buildBlockArray();
            //now we move our character on the new map
            playerx = 1;
        }

        if (direction.equals("left")) {
            String value = currentMap.getTileProperty(tileID, "transitionl", "false");
            currentMap = new TiledMap("data/" + value + ".tmx");
            //rebuild blocking
            buildBlockArray();
            //now we move our character on the new map
            playerx = 150;
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
