/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

import org.newdawn.slick.Animation;

/**
 *
 * @author craig.reese
 */
public class PlayerSprite {
    
    private Animation animation;
    private String playerType;

    public PlayerSprite() {
    }

    public PlayerSprite(Animation animation, String playerType) {
        this.animation = animation;
        this.playerType = playerType;
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
