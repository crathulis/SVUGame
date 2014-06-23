
package svugame.model.action;

/**
 * An Modifier is put on a stat, attribute, or skill as the result of some
 * action. Instantaneous effects are handled in the apply method of the action
 * instance. Modifiers model effects that have a particular duration. Modifiers
 * handle the case where the effect is constant (additive == false) and also
 * cases where the effect is cumulative over time (additive == true). If the
 * effect is dispellable, it can be dispelled through magic.
 * 
 */
public class Modifier {

    private final Action source;
    private final int amount;
    private int duration;
    private int total;
    private final boolean additive;
    private final boolean temporary;
    private final boolean dispellable;

    public Modifier(Action source, int amount, int duration, int total, boolean additive, boolean temporary, boolean dispellable) {
        this.source = source;
        this.amount = amount;
        this.duration = duration;
        this.total = total;
        this.additive = additive;
        this.temporary = temporary;
        this.dispellable = dispellable;
    }

    public Action getSource() {
        return source;
    }

    public int getAmount() {
        return amount;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isAdditive() {
        return additive;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public boolean isDispellable() {
        return dispellable;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    

}
