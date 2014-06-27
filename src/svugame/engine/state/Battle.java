/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.engine.state;

import HelperClasses.EffEntTar;
import HelperClasses.Entityplussprite;
import HelperClasses.Position;
import HelperClasses.TurnMade;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Display;
import mdes.slick.sui.event.ActionEvent;
import mdes.slick.sui.event.ActionListener;
import mdes.slick.sui.layout.RowLayout;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
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
import svugame.model.items.Item;
import static svugame.model.items.ItemConstants.ITEM_SLOT_RHAND;
import static svugame.model.items.ItemConstants.ITEM_TYPE_OH_WEAPON;
import static svugame.model.items.ItemConstants.ITEM_TYPE_RG_WEAPON;

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
    boolean startpause = false;
    boolean timerdone = false;
    int timer = 5000;
    SpriteSheet spritesheet;
    ArrayList<Entityplussprite> badguysprites = new ArrayList();
    ArrayList<Entityplussprite> goodguysprites = new ArrayList();
    Entity activePC;
    int delta = 0;
    int animationtimer = 3000;
    private boolean animate = false;
    private ArrayList<EffEntTar> eet;
    private EffEntTar currenteffenttar;
    private int effenttarposition = 0;
    private int animationdurationright = 90;
    private int animationdurationleft = 90;
    private int currentanimation = 0;
    boolean targeting = false;
    private int currentchosenaction = 0;

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
        GameData theGameData = getClient().getGameData();
        Party goodguys = new Party();
        Entity bernard = new Entity("Bernard", true, 20);
        Entity bernard2 = new Entity("Bernardina", false, 20);
        Entity bernard3 = new Entity("Ser Bernardo", true, 20);
        Item item11 = new Item();
        item11.setName("ranged weapon");
        item11.setDamage(2);
        item11.setSlot(ITEM_SLOT_RHAND);
        item11.setType(ITEM_TYPE_RG_WEAPON);
        Item[] testarray = new Item[512];
        testarray[1] = item11;
        bernard.setEquipment(testarray);
        bernard.setHealth(20000);
        Item item22 = new Item();
        item22.setName("melee weapon");
        item22.setDamage(2);
        item22.setSlot(ITEM_SLOT_RHAND);
        item22.setType(ITEM_TYPE_OH_WEAPON);
        Item[] testarray2 = new Item[512];
        testarray2[1] = item22;
        bernard2.setEquipment(testarray2);
        bernard2.setHealth(20000);
        Item item33 = new Item();
        item33.setName("melee weapon");
        item33.setDamage(2);
        item33.setSlot(ITEM_SLOT_RHAND);
        item33.setType(ITEM_TYPE_OH_WEAPON);
        Item[] testarray3 = new Item[512];
        testarray3[1] = item33;
        bernard3.setEquipment(testarray3);
        bernard3.setHealth(20000);
        bernard.setParty(goodguys);
        bernard2.setParty(goodguys);
        bernard3.setParty(goodguys);
        goodguys.add(bernard);
        goodguys.add(bernard2);
        goodguys.add(bernard3);

        for (Entity en : goodguys.getMembers()) {
            for (int i = 0; i < 9; i++) {
                en.setAttribute(i, 10);
            }
        }
        Entity wolf1 = new Entity("Wolf1", true, 10);
        Item item1 = new Item();
        item1.setName("ranged weapon");
        item1.setDamage(2);
        item1.setSlot(ITEM_SLOT_RHAND);
        item1.setType(ITEM_TYPE_RG_WEAPON);
        Item[] testarray4 = new Item[512];
        testarray4[1] = item1;
        wolf1.setEquipment(testarray4);
        Entity wolf2 = new Entity("Wolf2", true, 10);
        Item item2 = new Item();
        item2.setName("melee weapon");
        item2.setDamage(2);
        item2.setSlot(ITEM_SLOT_RHAND);
        item2.setType(ITEM_TYPE_OH_WEAPON);
        Item[] testarray5 = new Item[512];
        testarray5[1] = item2;
        wolf2.setEquipment(testarray5);
        Entity wolf3 = new Entity("Wolf3", true, 10);
        Item item3 = new Item();
        item3.setName("melee weapon");
        item3.setDamage(2);
        item3.setSlot(ITEM_SLOT_RHAND);
        item3.setType(ITEM_TYPE_OH_WEAPON);
        Item[] testarray6 = new Item[512];
        testarray6[1] = item3;
        wolf3.setEquipment(testarray6);
        System.out.println("finished setting items");
        Party mobParty = new Party();
        wolf1.setParty(mobParty);
        wolf2.setParty(mobParty);
        wolf3.setParty(mobParty);
        mobParty.add(wolf1);
        mobParty.add(wolf2);
        mobParty.add(wolf3);
        battlemanager.setGroms(mobParty);
        battlemanager.setParty(goodguys);
        System.out.println("Start of timer");
        spritesheet = new SpriteSheet("data/DungeonCrawl_ProjectUtumnoTileset.png", 32, 32);
        SpriteSheet spritesheet1 = new SpriteSheet("data/ranger_f.png", 32, 36);
        SpriteSheet spritesheet2 = new SpriteSheet("data/ninja_m.png", 32, 36);
        SpriteSheet spritesheet3 = new SpriteSheet("data/warrior_f.png", 32, 36);
        float x = 11f * 32f;
        float y = 48;
        Party party = battlemanager.getParty();
        Image im1 = spritesheet1.getSprite(0, 3);
        goodguysprites.add(new Entityplussprite(im1, party.getMembers().get(0), new Position(x, y)));
        y = y + 64;
        Image im2 = spritesheet2.getSprite(0, 3);
        goodguysprites.add(new Entityplussprite(im2, party.getMembers().get(1), new Position(x, y)));
        y = y + 64;
        Image im3 = spritesheet3.getSprite(0, 3);
        goodguysprites.add(new Entityplussprite(im3, party.getMembers().get(2), new Position(x, y)));
        Party groms = battlemanager.getGroms();
        float x2 = 64;
        float y2 = 48;
        for (Entity en : groms.getMembers()) {
            Image im = spritesheet.getSprite(2, 4);
            Entityplussprite eps = new Entityplussprite(im, en, new Position(x2, y2));
            badguysprites.add(eps);
            y2 = y2 + 64;
        }
        battlemanager.StartBattle();
        ArrayList<EffEntTar> eet = battlemanager.nextTurn(null, null, 0);
        if (eet.get(0).getActor() == null) {
            this.eet = eet;
             currenteffenttar = eet.get(0);
            SetActiveActor(eet.get(0).getNextPC());
        } else {
            AnimateEffects(eet);
        }

    }

    private void AnimateEffects(ArrayList<EffEntTar> eet) {
        this.eet = eet;
        currenteffenttar = eet.get(0);
        animate = true;
        EffEntTar lastone = eet.get(eet.size() - 1);
        for (Entityplussprite ens : goodguysprites) {
            if (ens.getEntity() == lastone.getNextPC()) {
                ens.setPosition(new Position(ens.getPosition().getX() - 64f, ens.getPosition().getY()));
            }
        }

    }

    private void SetActiveActor(Entity ent) {
        for (Entityplussprite ens : goodguysprites) {
            if (ens.getEntity() == currenteffenttar.getNextPC()) {
                ens.setPosition(new Position(ens.getPosition().getX() - 64f, ens.getPosition().getY()));
            }
        }

    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
        battleMusic.stop();
    }

    @Override
    public void init(final GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/Arena BattleMap.tmx");
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
                    renderSecondSet(s, gc);
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

    private void renderSecondSet(String choice, final GameContainer gc) {

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
                ArrayList<Integer> usableAbilities = battlemanager.getAbilities(this.currenteffenttar.getNextPC());
                //String[] row1 = new String[]{"One-Handed", "Two-Handed", "Close Quarters", "Projectile Weapons"};

                for (final int s : usableAbilities) {

                    Button tempButton = new Button(Integer.toString(s));

                    tempButton.setSize(10, secondGroup.getHeight() / 5);

                    tempButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                // Cursor cursor = new Cursor("data/Target.ani");
                                gc.setMouseCursor("data/Target.png", 16, 16);
                                targeting = true;
                                currentchosenaction = s;
                                // gc.setmou
                            } catch (SlickException ex) {
                                Logger.getLogger(Battle.class.getName()).log(Level.SEVERE, null, ex);
                            }
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

        for (Entityplussprite eps : goodguysprites) {
            if (eps.getEntity().getHealth() > 0) {

                grphcs.setColor(Color.red);
                grphcs.drawRect(eps.getPosition().getX(), eps.getPosition().getY() + 37, 32, 5);
                grphcs.setColor(Color.green);
                float basehealth = eps.getEntity().getBaseHealth();
                float basehealthandextrahealth = basehealth + 20000;
                float health = eps.getEntity().getHealth() / basehealthandextrahealth;
                //System.out.println(eps.getEntity().getName() + " Health: %: "+health);
                grphcs.fillRect(eps.getPosition().getX(), eps.getPosition().getY() + 37, health * 32, 5);
                grphcs.setColor(Color.red);
                grphcs.drawRect(eps.getPosition().getX(), eps.getPosition().getY() + 44, 32, 5);
                grphcs.setColor(Color.blue);
                grphcs.fillRect(eps.getPosition().getX(), eps.getPosition().getY() + 44, eps.getEntity().getSpirit() / eps.getEntity().getBaseSpirit() * 32, 5);
                eps.getImage().draw(eps.getPosition().getX(), eps.getPosition().getY());
            }

        }

        for (Entityplussprite eps : badguysprites) {
            if (eps.getEntity().getHealth() > 0) {
                grphcs.setColor(Color.red);
                grphcs.drawRect(eps.getPosition().getX(), eps.getPosition().getY() + 37, 32, 5);
                grphcs.setColor(Color.green);
                grphcs.fillRect(eps.getPosition().getX(), eps.getPosition().getY() + 37, eps.getEntity().getHealth() / eps.getEntity().getBaseHealth() * 32, 5);
                grphcs.setColor(Color.red);
                grphcs.drawRect(eps.getPosition().getX(), eps.getPosition().getY() + 44, 32, 5);
                grphcs.setColor(Color.blue);
                grphcs.fillRect(eps.getPosition().getX(), eps.getPosition().getY() + 44, eps.getEntity().getSpirit() / eps.getEntity().getBaseSpirit() * 32, 5);
                eps.getImage().getFlippedCopy(true, false).draw(eps.getPosition().getX(), eps.getPosition().getY());
            }

        }

        grphcs.scale(.51f, .5f);
        display.render(gc, grphcs);
        // }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        //delta = i;
        Input input = gc.getInput();
        //if (input.isKeyDown(Input.KEY_0)) {
        //    sbg.enterState(8, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        //} 
        if (input.isKeyDown(Input.KEY_9)) {
            battleMusic.stop();
            Music winMusic = new Music("data/6 Open Surge score jingle - AA.ogg");
            winMusic.play();
        }
        //if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
        //    gc.exit();
        //}
        //if (gc.getInput().isKeyPressed(Input.KEY_3)) {
        //    menus(gc);
        //}
        if (battlemanager.IsGameActive()) {
            display.update(gc, i);
            if (startpause == true) {
                timer -= i;
            }
            if (timer <= 0 && startpause == true) {
                startpause = false;
                System.out.println("end of timer");
                timerdone = true;
            }

            if (targeting == true) {
                if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                    //iterate through all active chars and see if it was clicked
                    System.out.println(input.getMouseX() + ":" + input.getMouseY());
                    for (Entityplussprite eps : badguysprites) {
                        System.out.println("x: " + eps.getPosition().getX() + " y:" + eps.getPosition().getY());
                        if (input.getMouseX() / 1.85 >= eps.getPosition().getX() && input.getMouseX() / 1.85 < (eps.getPosition().getX() + 32) && input.getMouseY() / 2 >= eps.getPosition().getY() && input.getMouseY() / 2 < (eps.getPosition().getY() + 32)) {
                        //this is the one that they are choosing
                            //so lets change the mouse cursor back
                            System.out.println("starting new turn: "+currenteffenttar.getNextPC().getName()+" is attacking " + eps.getEntity().getName());
                            gc.setDefaultMouseCursor();
                            ArrayList<EffEntTar> eet = battlemanager.nextTurn(currenteffenttar.getNextPC(), eps.getEntity(), currentchosenaction);
                            AnimateEffects(eet);
                        }
                    }

                }
            }

            if (animate == true) {
                //for (EffEntTar effenttar : eet) {
                if (battlemanager.IsNPC(currenteffenttar.getActor())) {
                    //animate to the right
                    Entityplussprite entityplussprite = null;
                    for (Entityplussprite ens : badguysprites) {
                         if (ens.getEntity().getName().equals(currenteffenttar.getActor().getName())) {
                            entityplussprite = ens;
                        }
                    }
                    if (animationdurationright > 0) {
                        animationdurationright--;
                    }

                    if (animationdurationright > 0) {
                        float math = 64f / 90;
                        float newx = entityplussprite.getPosition().getX() + math;
                        entityplussprite.setPosition(new Position(newx, entityplussprite.getPosition().getY()));
                        //System.out.println("animating: " + entityplussprite.getEntity().getName() + " at pos: " + entityplussprite.getPosition().getX() + ":" + entityplussprite.getPosition().getY());

                        //System.out.println("x: " + entityplussprite.getPosition().getX() + " newx: " + newx);
                    } else if (animationdurationleft > 0) {
                        float math = 64f / 90;
                        float newx = entityplussprite.getPosition().getX() - math;
                        entityplussprite.setPosition(new Position(newx, entityplussprite.getPosition().getY()));
                        animationdurationleft--;
                    }
                    //System.out.println("right: " + animationdurationright + " left: " + animationdurationleft);
                    if (animationdurationright == 0 && animationdurationleft == 0) {
                        if (effenttarposition + 1 < eet.size()) {
                            effenttarposition++;
                            this.currenteffenttar = eet.get(effenttarposition);
                            animationdurationright = 90;
                            animationdurationleft = 90;
                            System.out.println("animating again");
                        } else {
                            animate = false;
                            animationdurationright = 90;
                            animationdurationleft = 90;
                            effenttarposition = 0;
                            renderSecondSet("physical", gc);
                            //entityplussprite.setPosition(new Position(entityplussprite.getPosition().getX() + 64f, entityplussprite.getPosition().getY()));
                        }
                    }
                //for (int i = deltamark; i < deltamark + 1500; i++) {
                    //    entityplussprite.setPosition(new Position(entityplussprite.getPosition().getX() - (64 / 1500), entityplussprite.getPosition().getY()));
                    //}
                } else {
                    //animate to the left
                    Entityplussprite entityplussprite = null;
                    for (Entityplussprite ens : goodguysprites) {
                        if (ens.getEntity().getName().equals(currenteffenttar.getActor().getName())) {
                            entityplussprite = ens;
                        }
                    }
                    if (animationdurationright > 0) {
                        animationdurationright--;
                    }

                    if (animationdurationright > 0) {
                        float math = 64f / 90;
                        float newx = entityplussprite.getPosition().getX() - math;
                        entityplussprite.setPosition(new Position(newx, entityplussprite.getPosition().getY()));
                        //System.out.println("animating: " + entityplussprite.getEntity().getName() + " at pos: " + entityplussprite.getPosition().getX() + ":" + entityplussprite.getPosition().getY());
                        // System.out.println("x: " + entityplussprite.getPosition().getX() + " newx: " + newx);
                    } else if (animationdurationleft > 0) {
                        float math = 64f / 90;
                        float newx = entityplussprite.getPosition().getX() + math;
                        entityplussprite.setPosition(new Position(newx, entityplussprite.getPosition().getY()));
                        animationdurationleft--;
                    }
                    //System.out.println("right: " + animationdurationright + " left: " + animationdurationleft);
                    if (animationdurationright == 0 && animationdurationleft == 0) {
                        if (effenttarposition + 1 < eet.size()) {
                            effenttarposition++;
                            this.currenteffenttar = eet.get(effenttarposition);
                            animationdurationright = 90;
                            animationdurationleft = 90;
                            System.out.println("animating again");
                        } else {
                            animate = false;
                            animationdurationright = 90;
                            animationdurationleft = 90;
                            effenttarposition = 0;
                            entityplussprite.setPosition(new Position(entityplussprite.getPosition().getX() + 64f, entityplussprite.getPosition().getY()));
                            renderSecondSet("physical", gc);
                        }
                    }
                }
                //}

            }
        }
        if(!battlemanager.IsGameActive())
        {
            Music winMusic = new Music("data/6 Open Surge score jingle - AA.ogg");
            winMusic.play();
            JOptionPane.showMessageDialog(null, "Battle is over");
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
