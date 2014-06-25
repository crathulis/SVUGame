/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.engine.state;

import HelperClasses.TurnMade;
import java.awt.Font;
import javax.swing.JButton;
import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Display;
import mdes.slick.sui.event.ActionEvent;
import mdes.slick.sui.event.ActionListener;
import mdes.slick.sui.layout.RowLayout;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
import svugame.SVUGame;
import svugame.model.BattleManager;
import svugame.model.entity.Entity;
import svugame.model.entity.Party;

/**
 *
 * @author craig.reese
 */
public class Battle extends GameStateBase<GameData, States> {

    private int ID = 2;
    private TiledMap currentMap;
    Music battleMusic;
    private Display display;
    Container content;
    Container content2;
    Button btn = new Button("No where");
    Button btn2 = new Button("No what");
    Container secondGroup = new Container();
    Container thirdGroup = new Container();
    BattleManager battlemanager = new BattleManager();

    public Battle(SVUGame aThis, States states) {
        super(aThis, states);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        battleMusic = new Music("data/Boss_Battle_Loop_2.ogg");
        battleMusic.loop();

        GameData theGameData = getClient().getGameData();
        //get party and add to the roster
        Party goodguys = new Party();
        Entity bernard = new Entity("Bernard", true, 20);
        goodguys.add(theGameData.player.getEntity());
        goodguys.add(bernard);

        Entity wolf1 = new Entity("Wolf", true, 10);
        Entity wolf2 = new Entity("Wolf", true, 10);
        Entity wolf3 = new Entity("Wolf", true, 10);
        Party mobParty = new Party();
        mobParty.add(wolf1);
        mobParty.add(wolf2);
        mobParty.add(wolf3);

        battlemanager.setGroms(mobParty);
        battlemanager.setParty(goodguys);

        //TODO: here we need to get our actors and do our intial draw on the field.
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
        battleMusic.stop();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/BattleMap.tmx");
        //TiledMap map2 = new TiledMap("data/map2.tmx");

        //TODO: build world map that has tile data for each sectional map, then parse world map to get map data.
        currentMap = startMap;

        //display = new Display(gc);
        display = new Display(gc);
        content = new Container();
        content.setSize(800, 140); //sets panel size
        content.setLocation(0, 460); //sets panel loc relative to parent (display)
        content.setOpaque(true); //ensures that the background is drawn
        Color color = new Color(160, 160, 232);
        content.setBackground(color); //sets the background color
        content.setZIndex(0);

//        content2 = new Container();
//        content2.setSize(140, 600); //sets panel size
//        content2.setLocation(660, 0); //sets panel loc relative to parent (display)
//        content2.setOpaque(true); //ensures that the background is drawn
//        //Color color = new Color(160, 160, 232);
//        content2.setBackground(color);
//        display.add(content2);
        Container base = new Container();
        base.setSize(85, 130);
        base.setLocation(5, 465);
        base.setOpaque(true);
        base.setBackground(Color.black);
        RowLayout layout = new RowLayout(false, RowLayout.LEFT, RowLayout.CENTER);
        base.setLayout(layout);
        base.setZIndex(1);

        display.add(base);

        String[] row1 = new String[]{"Magical", "Inventory", "Physical", "Flee", "Attack"};
        int i = 0;

        for (final String s : row1) {

            Button tempButton = new Button(s);
            System.out.println(s + " " + i);
            tempButton.setSize(10, base.getHeight() / 5);

            tempButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    renderSecondSet(s);
                }
            });

            tempButton.setBorderRendered(false);
            tempButton.setOpaque(true);
            tempButton.setBackground(Color.cyan);  //TODO: FIX ME
            tempButton.pack();
            tempButton.setWidth(85);
            base.add(tempButton, i);
            i++;
        }

        secondGroup.setSize(165, 130);
        secondGroup.setLocation(100, 465);
        secondGroup.setOpaque(true);
        secondGroup.setBackground(Color.black);
        RowLayout layout2 = new RowLayout(false, RowLayout.LEFT, RowLayout.CENTER);
        secondGroup.setLayout(layout2);
        secondGroup.setZIndex(1);
        display.add(secondGroup);

        /*
         thirdGroup.setSize(85, 130);
         thirdGroup.setLocation(195, 465);
         thirdGroup.setOpaque(true);
         thirdGroup.setBackground(Color.black);
         RowLayout layout3 = new RowLayout(false, RowLayout.LEFT, RowLayout.CENTER);
         thirdGroup.setLayout(layout3);
         thirdGroup.setZIndex(1);
         display.add(thirdGroup);
         */
        display.add(content);
    }

    private void renderSecondSet(String choice) {

        secondGroup.removeAll();
        /*
         secondGroup.setSize(85, 130);
         secondGroup.setLocation(100, 465);
         secondGroup.setOpaque(true);
         secondGroup.setBackground(Color.black);
         RowLayout layout = new RowLayout(false, RowLayout.LEFT, RowLayout.CENTER);
         secondGroup.setLayout(layout);
         secondGroup.setZIndex(1);
         display.add(secondGroup);
         //display.reinit();
         //display.ensureZOrder();
         //display.add(content);
         */
        switch (choice) {
            case "Physical": {
                String[] row1 = new String[]{"One-Handed", "Two-Handed", "Close Quarters", "Projectile Weapons"};

                for (final String s : row1) {

                    Button tempButton = new Button(s);

                    tempButton.setSize(10, secondGroup.getHeight() / 5);

                    tempButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            renderThirdSet(s);
                        }
                    });

                    tempButton.setBorderRendered(false);
                    tempButton.setOpaque(true);
                    tempButton.setBackground(Color.cyan);  //TODO: FIX ME
                    tempButton.pack();
                    tempButton.setWidth(secondGroup.getWidth());
                    secondGroup.add(tempButton);
                }
                display.add(secondGroup);
                break;
            }
            case "Magical": {
                String[] row1 = new String[]{"Single-Target", "Multi-Target", "Buff / Debuff"};

                for (final String s : row1) {

                    Button tempButton = new Button(s);

                    tempButton.setSize(10, secondGroup.getHeight() / 5);

                    tempButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            renderThirdSet(s);
                        }
                    });

                    tempButton.setBorderRendered(false);
                    tempButton.setOpaque(true);
                    tempButton.setBackground(Color.cyan);  //TODO: FIX ME
                    tempButton.pack();
                    tempButton.setWidth(secondGroup.getWidth());
                    secondGroup.add(tempButton);
                }
                display.add(secondGroup);
                break;
            }
            case "Flee": {
                secondGroup.removeAll();
                display.add(secondGroup);
                break;
            }
            case "Inventory": {
                secondGroup.removeAll();
                display.add(secondGroup);
                break;
            }
            case "Attack": {
                secondGroup.removeAll();
                display.add(secondGroup);
                break;
            }
        }

    }

    private void renderThirdSet(String choice) {
        switch (choice) {
            case "Physical": {
                String[] row1 = new String[]{"Musical", "Weapon", "Buffs"};

                for (final String s : row1) {

                    Button tempButton = new Button(s);

                    tempButton.setSize(10, secondGroup.getHeight() / 5);

                    tempButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            renderThirdSet(s);
                        }
                    });

                    tempButton.setBorderRendered(false);
                    tempButton.setOpaque(true);
                    tempButton.setBackground(Color.cyan);  //TODO: FIX ME
                    tempButton.pack();
                    tempButton.setWidth(85);
                    secondGroup.add(tempButton);
                }
                display.add(secondGroup);
                break;
            }
            case "Magical": {
                String[] row1 = new String[]{"Elemental", "Control", "Buffs"};

                for (final String s : row1) {

                    Button tempButton = new Button(s);

                    tempButton.setSize(10, secondGroup.getHeight() / 5);

                    tempButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            renderThirdSet(s);
                        }
                    });

                    tempButton.setBorderRendered(false);
                    tempButton.setOpaque(true);
                    tempButton.setBackground(Color.cyan);  //TODO: FIX ME
                    tempButton.pack();
                    tempButton.setWidth(85);
                    secondGroup.add(tempButton);
                }
                display.add(secondGroup);
                break;
            }

        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.scale((float) 1.85, (float) 2);
        currentMap.render(0, 0);
        //sprite.draw((int) playerx, (int) playery);

        //if (this.convoActive == true) {
        grphcs.scale(.51f, .5f);
        display.render(gc, grphcs);
        // }
    }
    
    private void AnimateAction(TurnMade turnamde)
    {
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        while (battlemanager.IsGameActive()) {
            TurnMade turnmade = battlemanager.nextTurn(null, null, null);
            if(turnmade.getAction() == null)
            {
                //here we need to pause for input ... somehow
            }
            else
            {
                //turnmade has data that we need the ui to display
            }

            Input input = gc.getInput();
            if (input.isKeyDown(Input.KEY_0)) {
                sbg.enterState(8, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
            } else if (input.isKeyDown(Input.KEY_9)) {
                battleMusic.stop();
                Music winMusic = new Music("data/6 Open Surge score jingle - AA.ogg");
                winMusic.play();
            }
            if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
                gc.exit();
            }
            if (gc.getInput().isKeyPressed(Input.KEY_3)) {
                menus(gc);
            }

            display.update(gc, i);
        }
        if(battlemanager.IsGameActive()==false)
        {
            //battle is over, display the screen on who won
        }
    }

    private void menus(GameContainer gc) throws SlickException {
        content.removeAll();

        Font f = new Font("Serif", Font.BOLD, 10);
        UnicodeFont ufont = new UnicodeFont(f, f.getSize(), f.isBold(), f.isItalic());
        ufont.addAsciiGlyphs();
        ufont.addGlyphs(16, 16);
        ufont.getEffects().add(new ColorEffect(java.awt.Color.BLACK));
        ufont.loadGlyphs();
        btn.setFont(ufont);
        btn.pack();
        content.add(btn);

        btn2.setFont(ufont);
        btn2.pack();
        content.add(btn2);
        btn.setLocation(((content.getWidth() - btn.getWidth()) / 2) + 1, 10);
        btn2.setLocation(((content.getWidth() - btn2.getWidth()) / 2) + 1, 60);
        //btn.setEnabled(true);

        display.add(content);
        System.out.println("new Test");
        System.out.println(content.getSize());
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

}
