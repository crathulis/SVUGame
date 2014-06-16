/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.action;

import svugame.model.Dice;
import svugame.model.entity.Entity;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.OH_THRUST;

/**
 *
 * @author Alan
 */
public class OhThrust extends Action implements ItemConstants {

    @Override
    public boolean actorCan() {
        // actor must be holding a one-handed weapon in the right hand
        if(actor.getItemInSlot(ITEM_SLOT_RHAND).getType()!=ITEM_TYPE_OH_WEAPON){
            return false;
        }
        // dobj must be an entity
        if(!(dobj instanceof Entity)){
            return false;
        }
        // dobj must not be flying or swimming
        return true;
    }

    @Override
    public boolean success() {
        double agilityChance = actor.getAgility() / 25.0;
        double skillChance = actor.getSkillValue(OH_THRUST);
        int successChance = (int)Math.round(agilityChance + skillChance);
        boolean hit = (Dice.roll("1d100")<=successChance);
        Entity target = (Entity)dobj;
        boolean dodge = Dice.roll("1d100")<=target.getAgility() - skillChance;
        if(!hit){
            System.out.println(actor.getName() + " missed.");
            return false;
        } else if(dodge){
            System.out.println(target.getName() + " dodged.");
            return false;
        } else {
            System.out.println(actor.getName() + " thrusts the " + 
                    actor.getItemInSlot(ITEM_SLOT_RHAND).getName() +
                    " into " + target.getName());
            return true;
        }
    }

    @Override
    public int resultType() {
        return ActionConstants.RESULTS_DAMAGE;
    }

    @Override
    public int resultAmount() {
        double strengthFactor = actor.getStrength() / 25.0;
        double skillFactor = actor.getSkillValue(OH_THRUST);
        double weaponDamage = actor.getItemInSlot(ITEM_SLOT_RHAND).getDamage() 
                * actor.getLevel();
        return (int)Math.round((strengthFactor + skillFactor) * weaponDamage);
        
    }
    
    
    
}
