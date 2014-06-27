/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model;

import java.util.Random;

/**
 *
 * @author Alan
 */
public class Dice {
    
    public static int roll(String spec){
        String [] parts = spec.split("d");
        int numDice = (int)Double.parseDouble(parts[0]);
        int maxDice = (int)Double.parseDouble(parts[1]);
        int result = 0;
        for(int i=0;i<numDice;++i){
            int roll = rgen.nextInt(maxDice)+1;
            result += roll;
        }
        return result;
    }
    
    private static final Random rgen = new Random();
    
    public static final void main(String [] args){
        String spec = "3d8";
        int total=0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<100;++i){
            int roll = Dice.roll(spec);
            if(roll<min) min = roll;
            if(roll>max) max = roll;
            System.out.println("Roll " + spec + ": " + roll);
            total += roll;
        }
        System.out.println("Average = " + total / 100.0 + ", min = " + min + ", max = " + max);
    }
}
