/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

import HelperClasses.Position;
import mdes.slick.sui.Dimension;
import org.newdawn.slick.Animation;
import svugame.model.entity.Player;

/**
 *
 * @author craig.reese
 */
public class GameData {
    private Position cameraPosition = new Position(0,0);
    private Position playerPosition = new Position(0,0);
    private Position relativePlayerPosition = new Position(0,0);
    private boolean[][] fog;
    private Animation playerSprite;
    Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    

    public Position getRelativePlayerPosition() {
        return relativePlayerPosition;
    }

    public void setRelativePlayerPosition(Position relativePlayerPosition) {
        this.relativePlayerPosition = relativePlayerPosition;
    }

    
    
    public Animation getPlayerSprite() {
        return playerSprite;
    }

    public void setPlayerSprite(Animation playerSprite) {
        this.playerSprite = playerSprite;
    }

    public Position getCameraPosition() {
        return cameraPosition;
    }

    public void setCameraPosition(Position cameraPosition) {
        this.cameraPosition = cameraPosition;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    
    
    

    public boolean[][] getFog() {
        return fog;
    }

    public void setFog(boolean[][] fogofware) {
        this.fog = fogofware;
    }
    
    
    
    
}
