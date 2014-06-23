/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.engine.state;

import HelperClasses.PlayerSprite;
import HelperClasses.Position;
import HelperClasses.StatAllocation;
import java.awt.Font;
import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author craig.reese
 */
public class CharCreation extends GameStateBase implements ComponentListener {

    Font font = new Font("Verdana", Font.BOLD, 23);
    TrueTypeFont ttf = new TrueTypeFont(font, true);
    TextField txtName;
    Image background;
    Image generate;
    Image random;
    Image done;
    boolean femaleChose = true;
    Animation activeSprite = new Animation();

    private MouseOverArea[] areas = new MouseOverArea[21];

    String[] buttons1 = {"str", "agi", "end", "per", "dex"};
    String[] buttons2 = {"cha", "int", "wis", "foc"};

    ArrayList<StatAllocation> stats = new ArrayList();

    String[] playerTypes = {"healer", "mage", "ninja", "ranger", "warrior"};

    ArrayList<PlayerSprite> female = new ArrayList();
    ArrayList<PlayerSprite> male = new ArrayList();

    public CharCreation(ClientBase theClient, StateBase theState) {
        super(theClient, theState);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        gc.setShowFPS(false);
        background = new Image("data/charSelectMain.png");
        txtName = new TextField(gc, ttf, 148, 27, 320, 27, new ComponentListener() {
            public void componentActivated(AbstractComponent source) {
                System.out.println("Entered1: ");
                txtName.setFocus(true);
            }
        });
        txtName.setMaxLength(18);
        generate = new Image("data/generatename.png");
        random = new Image("data/randomize.png");
        done = new Image("data/done.png");
        areas[0] = new MouseOverArea(gc, generate, 530, 8, this);
        areas[1] = new MouseOverArea(gc, random, 503, 245, this);
        areas[2] = new MouseOverArea(gc, done, 321, 533, this);

        int i = 3;
        int y = 305;
        for (String s : buttons1) {
            Image im = new Image("data/left.png");
            areas[i] = new MouseOverArea(gc, im, 204, y, this);
            y = y + 38;
            i++;
        }

        int i2 = 8;
        int y2 = 305;
        for (String s : buttons1) {
            Image im = new Image("data/right.png");
            areas[i2] = new MouseOverArea(gc, im, 324, y2, this);
            y2 = y2 + 38;
            i2++;
        }

        int i3 = 13;
        int y3 = 300;
        for (String s : buttons2) {
            Image im = new Image("data/left.png");
            areas[i3] = new MouseOverArea(gc, im, 630, y3, this);
            y3 = y3 + 38;
            i3++;
        }

        int i4 = 17;
        int y4 = 300;
        for (String s : buttons2) {
            Image im = new Image("data/right.png");
            areas[i4] = new MouseOverArea(gc, im, 745, y4, this);
            y4 = y4 + 38;
            i4++;
        }

        for (String s : playerTypes) {
            SpriteSheet spritesheet = new SpriteSheet("data/" + s + "_f.png", 32, 36);
            Image[] movementDown = {spritesheet.getSprite(0, 2), spritesheet.getSprite(1, 2), spritesheet.getSprite(2, 2), spritesheet.getSprite(1, 2)};
            int[] duration = {300, 300, 300, 300};
            Animation down = new Animation(movementDown, duration, false);
            PlayerSprite ps = new PlayerSprite(down, s + "_f");
            female.add(ps);
        }

        for (String s : playerTypes) {
            SpriteSheet spritesheet = new SpriteSheet("data/" + s + "_m.png", 32, 36);
            Image[] movementDown = {spritesheet.getSprite(0, 2), spritesheet.getSprite(1, 2), spritesheet.getSprite(2, 2), spritesheet.getSprite(1, 2)};
            int[] duration = {300, 300, 300, 300};
            Animation down = new Animation(movementDown, duration, false);
            PlayerSprite ps = new PlayerSprite(down, s + "_m");
            male.add(ps);
        }

        activeSprite = female.get(0).getAnimation();

        int y5 = 305;
        for (String s : buttons1) {
            StatAllocation stat = new StatAllocation(10, s, new Position(258, y5));
            stats.add(stat);
            y5 = y5 + 38;
        }

        int y6 = 300;
        for (String s : buttons2) {
            StatAllocation stat = new StatAllocation(10, s, new Position(688, y6));
            stats.add(stat);
            y6 = y6 + 38;
        }

        StatAllocation stat = new StatAllocation(10, "remaining", new Position(422, 258));
        stats.add(stat);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {

        background.draw(0, 0);
        txtName.render(gc, grphcs);

        for (int i = 0; i < areas.length; i++) {
            areas[i].render(gc, grphcs);
        }

        for (StatAllocation stat : stats) {
            ttf.drawString(stat.getPosition().getX(), stat.getPosition().getY(), Integer.toString(stat.getStat()));
        }

        if (femaleChose == true) {
            ttf.drawString(170, 94, "X", Color.white);
            int x = 94;
            grphcs.scale(2, 2);
            for (PlayerSprite ps : female) {
                ps.getAnimation().draw(x, 80);
                x = x + 36;
            }
        } else {
            ttf.drawString(360, 93, "X", Color.white);
            int x = 94;
            grphcs.scale(2, 2);
            for (PlayerSprite ps : male) {
                ps.getAnimation().draw(x, 80);
                x = x + 36;
            }
        }
        grphcs.scale(.5f, .5f);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        activeSprite.update(i);
        Input input = gc.getInput();

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            // System.out.println(input.getMouseX() + ":" + input.getMouseY());
            if (input.getMouseX() >= 161 && input.getMouseX() < 190 && input.getMouseY() >= 95 && input.getMouseY() < 120) {
                //choose female
                femaleChose = true;
                activeSprite = female.get(0).getAnimation();
            }
            if (input.getMouseX() >= 355 && input.getMouseX() < 383 && input.getMouseY() >= 95 && input.getMouseY() < 120) {
                //choose male
                femaleChose = false;
                activeSprite = male.get(0).getAnimation();
            }
            if (input.getMouseX() >= 189 && input.getMouseX() < 245 && input.getMouseY() >= 161 && input.getMouseY() < 229) {
                if (femaleChose == true) {
                    activeSprite = female.get(0).getAnimation();
                } else {
                    activeSprite = male.get(0).getAnimation();
                }
            }
            if (input.getMouseX() >= 259 && input.getMouseX() < 318 && input.getMouseY() >= 161 && input.getMouseY() < 229) {
                if (femaleChose == true) {
                    activeSprite = female.get(1).getAnimation();
                } else {
                    activeSprite = male.get(1).getAnimation();
                }
            }
            if (input.getMouseX() >= 331 && input.getMouseX() < 389 && input.getMouseY() >= 161 && input.getMouseY() < 229) {
                if (femaleChose == true) {
                    activeSprite = female.get(2).getAnimation();
                } else {
                    activeSprite = male.get(2).getAnimation();
                }
            }
            if (input.getMouseX() >= 403 && input.getMouseX() < 459 && input.getMouseY() >= 161 && input.getMouseY() < 229) {
                if (femaleChose == true) {
                    activeSprite = female.get(3).getAnimation();
                } else {
                    activeSprite = male.get(3).getAnimation();
                }
            }
            if (input.getMouseX() >= 472 && input.getMouseX() < 530 && input.getMouseY() >= 161 && input.getMouseY() < 229) {
                if (femaleChose == true) {
                    activeSprite = female.get(4).getAnimation();
                } else {
                    activeSprite = male.get(4).getAnimation();
                }
            }
        }

    }

    private StatAllocation GetStatAllocation(String statName) {
        for (StatAllocation stat : stats) {
            if (stat.getStatName().equals(statName)) {
                return stat;
            }
        }
        return null;
    }

    @Override
    public void componentActivated(AbstractComponent source) {
        // String[] buttons1 = {"str", "agi", "end", "per", "dex"};
        //String[] buttons2 = {"cha", "int", "wis", "foc"};
        StatAllocation remaining = GetStatAllocation("remaining");
        System.out.println("ACTIVL : " + source);
        if (source == areas[3]) {
            StatAllocation stat = GetStatAllocation("str");

            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);

                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[4]) {
            StatAllocation stat = GetStatAllocation("agi");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[5]) {
            StatAllocation stat = GetStatAllocation("end");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[6]) {
            StatAllocation stat = GetStatAllocation("per");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[7]) {
            StatAllocation stat = GetStatAllocation("dex");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[8]) {
            StatAllocation stat = GetStatAllocation("str");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }
        if (source == areas[9]) {
            StatAllocation stat = GetStatAllocation("agi");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }
        if (source == areas[10]) {
            StatAllocation stat = GetStatAllocation("end");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }
        if (source == areas[11]) {
            StatAllocation stat = GetStatAllocation("per");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }
        if (source == areas[12]) {
            StatAllocation stat = GetStatAllocation("dex");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }

        if (source == areas[13]) {
            StatAllocation stat = GetStatAllocation("cha");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[14]) {
            StatAllocation stat = GetStatAllocation("int");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[15]) {
            StatAllocation stat = GetStatAllocation("wis");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }
        if (source == areas[16]) {
            StatAllocation stat = GetStatAllocation("foc");
            if (stat.getStat() - 1 >= 10) {
                stat.setStat(stat.getStat() - 1);
                remaining.setStat(remaining.getStat() + 1);
            }
        }

        if (source == areas[17]) {
            StatAllocation stat = GetStatAllocation("cha");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }
        if (source == areas[18]) {
            StatAllocation stat = GetStatAllocation("int");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }
        if (source == areas[19]) {
            StatAllocation stat = GetStatAllocation("wis");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }
        if (source == areas[20]) {
            StatAllocation stat = GetStatAllocation("foc");
            if (remaining.getStat() - 1 >= 0) {
                stat.setStat(stat.getStat() + 1);
                remaining.setStat(remaining.getStat() - 1);
            }
        }

        for (int i = 0; i < 21; i++) {
            if (source == areas[i]) {
                System.out.println("Option " + (i + 1) + " pressed!");
            }
        }

    }

    @Override
    public int getID() {
        return 11;
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

}
