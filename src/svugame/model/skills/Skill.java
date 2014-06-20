package svugame.model.skills;

import svugame.model.entity.Entity;

/**
 *
 * @author Lab Admin
 */
public class Skill {
    
    private SkillModel model;
    private Entity owner;
    private int points;
    
    public Skill() {
    }
    
    public Skill(Entity owner, int skillId){
        this(owner, skillId, 0);
    }

    public Skill(Entity owner, int skillId, int level){
        this.owner = owner;
        this.points = level;
        this.model = SkillFactory.getModel(skillId);
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
        return (int)Math.round(attribAverage + (points==0?-25:points));
    }

    
}
