/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.engine.state;

import java.awt.Font;
import java.awt.GridLayout;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import mdes.slick.sui.*;
import mdes.slick.sui.event.ActionEvent;
import mdes.slick.sui.event.ActionListener;
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
import svugame.dialogue.ConversationManager;
import svugame.dialogue.ConversationTest;
import svugame.dialogue.Dialogue;
import svugame.model.skills.SkillList;

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
    Dialogue lastPart;
    ConversationTest convo = new ConversationTest();
    TextArea convoArea;
    ConversationManager convoMng;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/map1.tmx");
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
        sprite = down;
        buildBlockArray();
        System.out.println("test");

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
        //Graphics temp = grphcs;
        grphcs.scale(4, 4);
        currentMap.render(0, 0);
        sprite.draw((int) playerx, (int) playery);

        if (this.convoActive == true) {
            grphcs.scale(0.25f, 0.25f);
            display.render(gc, grphcs);
        }
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

            if (playerx - 7 < 0) {
                //we've reached the right edge of the screen
                transition("left");
            }

            if (collision == false) {
                sprite.update(i);
                playerx -= i * speed;
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            sprite = right;
            if (playerx + 12 > currentMap.getWidth() * SIZE) {
                //we've reached the right edge of the screen
                transition("right");
            }
            if (!isBlocked((float) (playerx + 3 + i * speed), playery + 6, sbg)) {
                collision = false;
            }
            //check to see if we're at the edge of the map
            //we can see that if startx == mapsize (160)
            //look up tile, from that we can get a transition
            System.out.println("Player: " + (playerx) + " | Map size: " + (currentMap.getWidth() * SIZE));

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
            try {
                StartConversation("ArenaBattle1", gc);
            } catch (JAXBException ex) {
                Logger.getLogger(Overworld.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (convoActive == true) {
            if (input.isKeyPressed(Input.KEY_ENTER)) {
                ExecuteDialogue();
            }
        }
    }

    private void ExecuteDialogue() throws SlickException {
        if (lastPart != null) {
            if (lastPart.getPointer()[0].equals("end")) {
                //we've reached the end of a dialog tree, lets stop here
                convoActive = false;
                display.removeAll();
                //extra stuff as warrents
                return;
            }
        }
        ArrayList convos = convo.GetNext(lastPart);
        Dialogue temp = (Dialogue) convos.get(0);
        //now we set newest convopart as lastPart
        lastPart = temp;
        //and now we write it
        System.out.println(temp.getText());
        //displayLabel(temp.getText(), content);

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

    private void StartConversation(String conversationName, GameContainer gc) throws SlickException, JAXBException {
        convoActive = true;
        convoMng = new ConversationManager(conversationName);
        //so we now can get the starters of the conversation, lets start by displaying them on the screen.
        //for now, we'll hard code it.

        /***  BUILDING THE BACKGROUND CONTAINER ***/
        display = new Display(gc);
        content = new Container();
        content.setSize(800, 140); //sets panel size
        content.setLocation(0, 460); //sets panel loc relative to parent (display)
        content.setOpaque(true); //ensures that the background is drawn
        Color color = new Color(160, 160, 232);
        content.setBackground(color); //sets the background color
        
       /*** END BUILDING BACKGROUND CONTAINER ***/
        
        //now we'll need eventually 4 items to display, those being the two portraits, the label of current convo, and the list of buttons for responces
        
        /**  ADDING THE CURRENT STARTER INFO ***/
        convoArea = new TextArea(convoMng.getCurrentString(),2,5);
        convoArea.setLocation(10, 470);
        convoArea.setSize(300, 130);
        convoArea.setBackground(color);
        convoArea.setBorderRendered(false);
        display.add(convoArea);
        /*** END ADDING THE CURRENT STARTER INFO ***/
        
        /*** ADDING THE ANSWER AREA ***/
        Container answerArea = new Container();
        answerArea.setSize(450,130);
        answerArea.setLocation(330,465);
        answerArea.setOpaque(true);
        answerArea.setBackground(Color.cyan);
        RowLayout layout = new RowLayout(false, RowLayout.LEFT, RowLayout.CENTER);
        answerArea.setLayout(layout);
        /*** END ADDING THE ANSWER AREA ***/
        
        /*** ADDING THE ANSWER BUTTONS ***/
        ArrayList<Dialogue> answerList = convoMng.getConvoList();
        for(final Dialogue dialogue : answerList)
        {
            Button btn = new Button(dialogue.getText());
            btn.setSize(450, answerArea.getHeight()/answerList.size());
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    UpdateConversation(dialogue.getId());
                }
            });
            
            btn.setBorderRendered(false);
            btn.setOpaque(true);  
            btn.setBackground(Color.cyan);  //TODO: FIX ME
            btn.pack();
           
            answerArea.add(btn);
        }
        /*** END ADDING ANSWER BUTTONS ***/
        
        display.add(answerArea);
        display.add(content);
    }
    
    private void UpdateConversation(String choice)
    {
        //here we need to move everything along, we have our choice so lets update the conversationManager
        convoMng.GetNextDialogue(choice);
       
        convoArea.setText(convoMng.getCurrentString());
        
    }

}
