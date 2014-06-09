package svugame.model.entity;

/**
 * Attributes describe the capabilities of a player. They range between 1 and
 * 100. Attributes can be effected by items, environment, situation, etc. The
 * base value is the unmodified value of the attribute. The current value allows
 * attributes to be increased or decreased by items, spells, etc. The
 * attributeIndex is defined in AttributeConstants.
 * @author Lab Admin
 */
public class Attribute implements AttributeConstants {
    
    private final int index;
    private int baseValue;
    private int curValue;

    /**
     * Create a new attribute representing one of the nine attributes for
     * characters.
     * @param attribIndex the attribute index as defined in AttributeConstants.
     * @param baseValue the baseValue for the attribute.
     * @param curValue the currentValue for the attribute.
     */
    public Attribute(int attribIndex, int baseValue, int curValue) {
        this.index = attribIndex;
        this.baseValue = baseValue;
        this.curValue = curValue;
    }

    /**
     * Get the name of the attribute, such as 'strength', or 'wisdom'.
     * @return the attribute name.
     */
    public String getName() {
        return ATTRIB_NAMES[index];
    }

    /**
     * Get the index for the attribute. This is a value between 0 and 8.
     * @return the attribute's index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get the base (unmodified) value of the attribute. This does not change
     * once the attribute is created.
     * @return the attribute's base value.
     */
    public int getBaseValue() {
        return baseValue;
    }

    /**
     * Get the current (possibly modified) value of an attribute.
     * @return the attribute's current value.
     */
    public int getCurValue() {
        return curValue;
    }

    /**
     * Set the attribute's current value to the new value specified.
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
    
    
    
}
