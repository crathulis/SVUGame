/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import HelperClasses.Position;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author craig.reese
 */
public class Player {
    
    Entity entity;
    Position pos;
    SpriteSheet spritesheet;

    public Player() {
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public SpriteSheet getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(SpriteSheet spritesheet) {
        this.spritesheet = spritesheet;
    }
    
    
    
}
