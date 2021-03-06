/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.action;

import java.util.ArrayList;
import svugame.model.Dice;
import svugame.model.Thing;
import static svugame.model.action.ActionConstants.RESULTS_ARMOR;
import static svugame.model.action.ActionConstants.RESULTS_BLOCK;
import static svugame.model.action.ActionConstants.RESULTS_DAMAGE_HP;
import static svugame.model.action.ActionConstants.RESULTS_DODGE;
import static svugame.model.action.ActionConstants.RESULTS_MISS;
import svugame.model.entity.Entity;
import static svugame.model.items.ItemConstants.ITEM_SLOT_LHAND;
import static svugame.model.items.ItemConstants.ITEM_SLOT_RHAND;
import static svugame.model.items.ItemConstants.ITEM_SLOT_TORSO;
import static svugame.model.items.ItemConstants.ITEM_TYPE_RG_WEAPON;
import static svugame.model.items.ItemConstants.ITEM_TYPE_SHIELD;
import svugame.model.items.Items;
import static svugame.model.skills.SkillConstants.SKILL_SHIELD;

/**
 *
 * @author Lab Admin
 */
public abstract class RangedAction extends Action {

    public RangedAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public RangedAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public RangedAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    @Override
    public boolean isPossible() {
        // actor must have enough spirit to complete action
        if (actor.getSpirit()<(actor.getSkill(skillId).getModel().getSpirit())){
            return false;
        }
        // ranged actions require a target (dobj)
        if (dobj == null) {
            return false;
        }
        // actor must be holding a two-handed ranged weapon in the right hand
        if (actor.getItemInSlot(ITEM_SLOT_RHAND).getType() != ITEM_TYPE_RG_WEAPON) {
            return false;
        }
        // dobj must be an entity
        if (!(dobj instanceof Entity)) {
            return false;
        }
        return true;
    }

    protected boolean isHit() {
        double dexterityChance = (actor.getDexterity() / 25.0) * 100.0;
        int successChance = (int) Math.round(dexterityChance + actor.getSkillValue(skillId));
        return (Dice.roll("1d100") <= successChance);
    }

    protected boolean isDodge() {
        int dodgeChance = Math.min(100, (int) Math.round((((Entity) dobj).getAgility() / (double) actor.getSkillValue(skillId)) * 100.0));
        return Dice.roll("1d100") < dodgeChance;
    }

    protected int getBaseDamage() {
        double strengthFactor = (actor.getStrength() / 25.0) * 100.0;
        double weaponDamage = actor.getItemInSlot(ITEM_SLOT_RHAND).getDamage();
        int maxDamage = (int) Math.round(((strengthFactor + actor.getSkillValue(skillId)) / 100.0) * weaponDamage);
        return Dice.roll(actor.getLevelStep() + "d" + maxDamage);
    }

    protected int getShieldAbsorb() {
        Entity target = (Entity) dobj;
         if (target.getItemInSlot(ITEM_SLOT_LHAND) != null) {
        if (target.getItemInSlot(ITEM_SLOT_LHAND).getType() == ITEM_TYPE_SHIELD) {
            double agilityFactor = (target.getAgility() / 25.0) * 100.0;
            int shieldDamage = target.getItemInSlot(ITEM_SLOT_LHAND).getDamage();
            int maxShield = (int) Math.round((agilityFactor + target.getSkillValue(SKILL_SHIELD)) * shieldDamage);
            int shieldAbsorb = Dice.roll(target.getLevelStep() + "d" + maxShield);
            if (shieldAbsorb > 0) {
                System.out.println(target.getName() + " blocks " + shieldAbsorb
                        + " points of damage with their shield.");
                results.add(new Effect(RESULTS_BLOCK, shieldAbsorb));
            }
            return shieldAbsorb;
        }
         }
        return 0;
    }

    protected int getArmorAbsorb() {
        Entity target = (Entity) dobj;
        if (Items.isArmor(target.getItemInSlot(ITEM_SLOT_TORSO))) {
            int armorPower = target.getItemInSlot(ITEM_SLOT_TORSO).getDamage();
            int maxArmorAbsorb = (int) Math.round(armorPower * target.getLevel());
            int armorAbsorb = Dice.roll("1d" + maxArmorAbsorb);
            System.out.println(target.getName() + "'s armor absorbs " + armorAbsorb
                    + " points of damage.");
            results.add(new Effect(RESULTS_ARMOR, armorAbsorb));
            return armorAbsorb;
        }
        return 0;
    }

    protected int getFinalDamage() {
        int baseDamage = getBaseDamage();
        int shieldAbsorb = getShieldAbsorb();
        int armorAbsorb = getArmorAbsorb();
        return Math.max(0, baseDamage - shieldAbsorb - armorAbsorb);
    }

    protected abstract void addMoreEffects();

    @Override
    public ArrayList<Effect> apply() {
        results = new ArrayList<>();
        if (!isPossible()) {
            System.out.println(actor.getName() + " can't attack " + ((Entity) dobj).getName());
            //results.add(new Effect(RESULTS_NONE));
            return results;
        } else if (!isHit()) {
            actor.setSpirit(actor.getSpirit()-actor.getSkill(skillId).getModel().getSpirit());
            System.out.println(actor.getName() + " missed " + ((Entity) dobj).getName());
            results.add(new Effect(RESULTS_MISS));
            return results;
        } else if (isDodge()) {
            actor.setSpirit(actor.getSpirit()-actor.getSkill(skillId).getModel().getSpirit());
            System.out.println(((Entity) dobj).getName() + " dodged.");
            results.add(new Effect(RESULTS_DODGE));
            return results;
        } else {
            actor.setSpirit(actor.getSpirit()-actor.getSkill(skillId).getModel().getSpirit());
            Entity target = ((Entity) dobj);
            int finalDamage = getFinalDamage();
            if (finalDamage > 0) {
                System.out.println(actor.getName() + " hits the "
                        + target.getName() + " with the "
                        + actor.getItemInSlot(ITEM_SLOT_RHAND).getName()
                        + " for " + finalDamage + " damage.");
                results.add(new Effect(RESULTS_DAMAGE_HP, finalDamage));
                target.setHealth(target.getHealth() - finalDamage);
                if(target.getHealth()<0)
                {
                    target.setHealth(0);
                }
                addMoreEffects();
            }
            return results;
        }
    }

}
