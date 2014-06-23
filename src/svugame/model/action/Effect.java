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
    
    
    public Effect(int result){
        this(result, 0);
    }

    public Effect(int result, int amount) {
        this.result = result;
        this.amount = amount;
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

}
