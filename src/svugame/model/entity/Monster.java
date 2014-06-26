/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.entity;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */


public abstract class Monster extends Entity{
    
    public MonsterModel model;
    private ArrayList<Integer> attackId;
    
    
    public Monster(MonsterModel model){
        
        super(model.getName(), true, model.getExp());
        this.model = model;
        super.setAttribute(STR, model.getStrength());
        super.setAttribute(AGI, model.getAgility());
        super.setAttribute(END, model.getEndurance());
        super.setAttribute(PER, model.getPerception());
        super.setAttribute(DEX, model.getDexterity());
        super.setAttribute(CHA, model.getCharisma());
        super.setAttribute(INT, model.getIntelligence());
        super.setAttribute(WIS, model.getWisdom());
        super.setAttribute(FOC, model.getFocus());        
        
        modSkill(model.getSkill1(), model.getId1(), model.getLevel());
        modSkill(model.getSkill2(), model.getId2(), model.getLevel());
        modSkill(model.getSkill3(), model.getId3(), model.getLevel());
    }
    
    public void modSkill(String name, int skillId, int level){
        super.addSkillPoints(skillId, level);
        super.getSkill(skillId).setName(name);
        attackId.add(skillId);
    }
    
    public Integer getSkillId(int loc){
        return attackId.get(loc);
    }
    
    public int attackNum(){
        return attackId.size();
    }
    
    public int getMonsterId(){
        return model.getId();
    }
    
}
