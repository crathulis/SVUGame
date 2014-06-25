/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author craig.reese
 */
public class PlayerSprite {
    
    private Animation animation;
    private String playerType;
    private SpriteSheet SpriteSheet;

    public PlayerSprite() {
    }

    public PlayerSprite(Animation animation, String playerType) {
        this.animation = animation;
        this.playerType = playerType;
    }

    public SpriteSheet getSpriteSheet() {
        return SpriteSheet;
    }

    public void setSpriteSheet(SpriteSheet SpriteSheet) {
        this.SpriteSheet = SpriteSheet;
    }
    
    

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
    
    
    
}
