package svugame.model.entity;

import java.util.ArrayList;
import svugame.model.action.Modifiable;
import svugame.model.action.Modifier;

/**
 * Attributes describe the capabilities of a player. They range between 1 and
 * 100. Attributes can be effected by items, environment, situation, etc. The
 * base value is the unmodified value of the attribute. The current value allows
 * attributes to be increased or decreased by items, spells, etc. The
 * attributeIndex is defined in AttributeConstants.
 *
 * @author Lab Admin
 */
public class Attribute implements AttributeConstants, Modifiable {

    private final int index;
    private int baseValue;
    private int curValue;
    private ArrayList<Modifier> mods;

    /**
     * Create a new attribute representing one of the nine attributes for
     * characters.
     *
     * @param attribIndex the attribute index as defined in AttributeConstants.
     * @param baseValue the baseValue for the attribute.
     * @param curValue the currentValue for the attribute.
     */
    public Attribute(int attribIndex, int baseValue, int curValue) {
        this.index = attribIndex;
        this.baseValue = baseValue;
        this.curValue = curValue;
        this.mods = new ArrayList<Modifier>();
    }

    /**
     * Get the name of the attribute, such as 'strength', or 'wisdom'.
     *
     * @return the attribute name.
     */
    public String getName() {
        return ATTRIB_NAMES[index];
    }

    /**
     * Get the index for the attribute. This is a value between 0 and 8.
     *
     * @return the attribute's index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the base (unmodified) value of the attribute. This does not change
     * once the attribute is created.
     *
     * @return the attribute's base value.
     */
    public int getBaseValue() {
        return baseValue;
    }

    /**
     * Sets the base value of the attribute to the specified value.
     *
     * @param value the new base value of the attribute.
     */
    public void setBaseValue(int value) {
        baseValue = value;
    }

    /**
     * Get the current (possibly modified) value of an attribute.
     *
     * @return the attribute's current value.
     */
    public int getCurValue() {
        return curValue;
    }

    /**
     * Set the attribute's current value to the new value specified.
     *
     * @param curValue the new attribute value.
     */
    public void setCurValue(int curValue) {
        this.curValue = curValue;
    }

    /**
     * Reset the current value of the attribute to its base value.
     */
    public void resetCurValue() {
        curValue = baseValue;
    }

    @Override
    public ArrayList<Modifier> getMods() {
        return mods;
    }

    @Override
    public void setMods(ArrayList<Modifier> mods) {
        this.mods = mods;
    }

    @Override
    public void addMods(Modifier mod) {
        mods.add(mod);
    }

    @Override
    public void update() {
        for (Modifier mod : mods) {
            if (mod.getDuration() > 0) {
                mod.setDuration(mod.getDuration() - 1);
                if (mod.isAdditive()) {
                    mod.setTotal(mod.getTotal() + mod.getAmount());
                    curValue += mod.getAmount();
                }
            } else if (mod.getDuration() <= 0) {
                if (mod.isTemporary()) {
                    curValue -= mod.getTotal();
                }
                mods.remove(mod);
            }
        }

    }

    @Override
    public void dispell() {
        for (Modifier mod : mods) {
            if (mod.isDispellable()) {
                if(mod.isTemporary()){
                    curValue -= mod.getTotal();
                }
                mods.remove(mod);
            }
        }
    }

}
