/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.engine.state;

/**
 *
 * @author craig.reese
 */
public enum States implements StateBase{
NewOverworld(8),
Map(9),
CharCreation(11),
NewStart(10)

;
    private int value;
    States(int theValue){
        value = theValue;
    }

    @Override
    public int getValue() {
        return value;
    }
    
}
