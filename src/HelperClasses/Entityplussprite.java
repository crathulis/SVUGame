/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

import org.newdawn.slick.Image;
import svugame.model.entity.Entity;

/**
 *
 * @author craig.reese
 */
public class Entityplussprite {
    
    Image image;
    Entity entity;
    Position position;

    public Entityplussprite(Image image, Entity entity,Position pos) {
        this.image = image;
        this.entity = entity;
        this.position = pos;
    }
    
    

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    
    
}
