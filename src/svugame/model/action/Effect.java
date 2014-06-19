/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

/**
 *
 * @author Alan
 */
public class Effect {
    
    private int result;
    private int amount;
    private int duration;
    
    public Effect(int result){
        this(result, 0, 0);
    }

    public Effect(int result, int amount) {
        this(result, amount, 0);
    }

    public Effect(int result, int amount, int duration) {
        this.result = result;
        this.amount = amount;
        this.duration = duration;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
    
}
