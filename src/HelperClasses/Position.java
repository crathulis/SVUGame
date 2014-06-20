/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HelperClasses;

/**
 *
 * @author craig.reese
 */
public class Position {
    private float x;
    private float y;
    
    public Position(float playerx,float playery)
    {
        this.x = playerx;
        this.y = playery;
        
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    
    
}
