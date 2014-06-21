/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

/**
 * An effect is the result of some action. It may be instantaneous (of duration
 * 0) or last some number of updates. It may be constant (additive == false) or
 * accumulate over time (additive == true). If the effect is dispellable, it
 * can be dispelled through magic.
 * 
 * @author Alan
 */
public class Effect {
    
    private int result;
    private int amount;
    private int duration;
    private boolean additive;
    private boolean dispellable;
    
    public Effect(int result){
        this(result, 0);
    }

    public Effect(int result, int amount) {
        this(result, amount, 0);
    }
    
    public Effect(int result, int amount, int duration){
        this(result, amount, duration, false);
    }
    
    public Effect(int result, int amount, int duration, boolean additive){
        this(result, amount, duration, additive, false);
    }

    public Effect(int result, int amount, int duration, boolean additive, boolean dispellable) {
        this.result = result;
        this.amount = amount;
        this.duration = duration;
        this.additive = additive;
        this.dispellable = dispellable;
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
    
    public boolean isExpired(){
        return duration<=0;
    }

    public boolean isAdditive() {
        return additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }

    public boolean isDispellable() {
        return dispellable;
    }

    public void setDispellable(boolean dispellable) {
        this.dispellable = dispellable;
    }
    
       
}
