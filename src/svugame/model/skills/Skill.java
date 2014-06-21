package svugame.model.skills;

import java.util.ArrayList;
import svugame.model.action.Modifiable;
import svugame.model.action.Modifier;
import svugame.model.entity.Entity;

/**
 *
 * @author Lab Admin
 */
public class Skill implements Modifiable {
    
    private SkillModel model;
    private Entity owner;
    private int points;
    private int modTotal;
    private ArrayList<Modifier> mods;
    
    public Skill() {
    }
    
    public Skill(Entity owner, int skillId){
        this(owner, skillId, 0);
    }

    public Skill(Entity owner, int skillId, int level){
        this.owner = owner;
        this.points = level;
        this.model = SkillFactory.getModel(skillId);
        modTotal = 0;
        mods = new ArrayList<Modifier>();
    }

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int level) {
        this.points = level;
    }
    
    public void addPoints(int points){
        this.points += points;
    }
    
    public int getLevel(){
        int attrib1Value = owner.getAttribute(model.getAttrib1());
        int attrib2Value = owner.getAttribute(model.getAttrib2());
        double attribAverage = (attrib1Value + attrib2Value) / 2.0;
        int level = (int)Math.round(attribAverage + (points==0?-25:points));
        return level + modTotal;
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
        this.mods.add(mod);
    }

    @Override
    public void update() {
        for (Modifier mod : mods) {
            if (mod.getDuration() > 0) {
                mod.setDuration(mod.getDuration() - 1);
                if (mod.isAdditive()) {
                    mod.setTotal(mod.getTotal() + mod.getAmount());
                    modTotal += mod.getAmount();
                }
            } else if (mod.getDuration() <= 0) {
                if (mod.isTemporary()) {
                    modTotal -= mod.getTotal();
                }
                mods.remove(mod);
            }
        }}

    @Override
    public void dispell() {
        for (Modifier mod : mods) {
            if (mod.isDispellable()) {
                if(mod.isTemporary()){
                    modTotal -= mod.getTotal();
                }
                mods.remove(mod);
            }
        }}

    
}
