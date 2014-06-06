package svugame.model.character;

/**
 * Attributes describe the capabilities of a player. They range between 1 and
 * 100. Attributes can be effected by items, environment, situation, etc.
 * @author Lab Admin
 */
public class Attribute implements AttributeConstants {
    
    private int index;
    private int baseValue;
    private int curValue;

    public Attribute(int attribIndex, int baseValue, int curValue) {
        this.index = attribIndex;
        this.baseValue = baseValue;
        this.curValue = curValue;
    }

    public String getName() {
        return ATTRIB_NAMES[index];
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getCurValue() {
        return curValue;
    }

    public void setCurValue(int curValue) {
        this.curValue = curValue;
    }
    
    
    
}
