/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.engine.state;

import java.awt.Font;
import javax.swing.JButton;
import mdes.slick.sui.Button;
import mdes.slick.sui.Container;
import mdes.slick.sui.Display;
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

/**
 *
 * @author craig.reese
 */
public class Battle extends BasicGameState {

    private int ID = 2;
    private TiledMap currentMap;
    Music battleMusic;
    private Display display;
    Container content;
    Button btn = new Button("No where");
    Button btn2 = new Button("No what");

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        battleMusic = new Music("data/Boss_Battle_Loop_2.ogg");
        battleMusic.loop();
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) {
        battleMusic.stop();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        TiledMap startMap = new TiledMap("data/forestBattle.tmx");
        //TiledMap map2 = new TiledMap("data/map2.tmx");

        //TODO: build world map that has tile data for each sectional map, then parse world map to get map data.
        currentMap = startMap;

        display = new Display(gc);

        content = new Container();
        content.setSize(60, 160); //sets panel size
        content.setLocation(100, 0); //sets panel loc relative to parent (display)
        content.setOpaque(true); //ensures that the background is drawn
        content.setBackground(Color.lightGray); //sets the background color

        RowLayout layout = new RowLayout(true, RowLayout.LEFT, RowLayout.CENTER);
        content.setLayout(layout);
        content.setVisible(true);
        //adding music
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        currentMap.render(0, 0);
        display.render(gc, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_0)) {
            sbg.enterState(1, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
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
        
        //need listener to know when button is pressed then add new button
//        if(btn){
//            content.removeAll();
//        }
        
        display.update(gc, i);
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
        btn.setLocation(((content.getWidth()-btn.getWidth())/2)+1,10);
        btn2.setLocation(((content.getWidth()-btn2.getWidth())/2)+1, 60);
        //btn.setEnabled(true);
        
        
        
        display.add(content);
        System.out.println("new Test");
        System.out.println(content.getSize());
    }

}
