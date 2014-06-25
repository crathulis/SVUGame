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
import static svugame.model.items.ItemConstants.ITEM_TYPE_SHIELD;
import svugame.model.items.Items;
import static svugame.model.skills.SkillConstants.SKILL_SHIELD;

/**
 *
 * @author Alan
 */
public abstract class MeleeAction extends Action {

    public MeleeAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public MeleeAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public MeleeAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    protected boolean isHit() {
        double agilityChance = actor.getAgility() / 25.0;
        int successChance = (int) Math.round(agilityChance + actor.getSkillValue(skillId));
        return (Dice.roll("1d100") <= successChance);
    }

    protected boolean isDodge() {
        int dodgeChance = Math.min(100, (int) Math.round((((Entity) dobj).getAgility() / (double) actor.getSkillValue(skillId)) * 100));
        return Dice.roll("1d100") < dodgeChance;
    }

    protected int getBaseDamage() {
        double strengthFactor = actor.getStrength() / 25.0;
        double weaponDamage = actor.getItemInSlot(ITEM_SLOT_RHAND).getDamage();
        int maxDamage = (int) Math.round((strengthFactor + actor.getSkillValue(skillId)) * weaponDamage);
        return Dice.roll(actor.getLevel() + "d" + maxDamage);
    }

    protected int getShieldAbsorb() {
        Entity target = (Entity) dobj;
        if (target.getItemInSlot(ITEM_SLOT_LHAND).getType() == ITEM_TYPE_SHIELD) {
            double agilityFactor = target.getAgility() / 25.0;
            int shieldDamage = target.getItemInSlot(ITEM_SLOT_LHAND).getDamage();
            int maxShield = (int) Math.round((agilityFactor + target.getSkillValue(SKILL_SHIELD)) * shieldDamage);
            int shieldAbsorb = Dice.roll(((int)target.getLevel()) + "d" + maxShield);
            if (shieldAbsorb > 0) {
                System.out.println(target.getName() + " blocks " + shieldAbsorb
                        + " points of damage with their shield.");
                results.add(new Effect(RESULTS_BLOCK, shieldAbsorb));
            }
            return shieldAbsorb;
        }
        return 0;
    }

    protected int getArmorAbsorb() {
        Entity target = (Entity) dobj;
        if (Items.isArmor(target.getItemInSlot(ITEM_SLOT_TORSO))) {
            int armorPower = target.getItemInSlot(ITEM_SLOT_TORSO).getDamage();
            int maxArmorAbsorb = (int) Math.round(armorPower * target.getLevel());
            int armorAbsorb = Dice.roll(target.getLevel() + "d" + maxArmorAbsorb);
            System.out.println(target.getName() + "'s armor absorbs " + armorAbsorb
                    + " points of damage.");
            results.add(new Effect(RESULTS_ARMOR, armorAbsorb));
            return armorAbsorb;
        }
        return 0;
    }

    protected void addMoreEffects() {
    }

    @Override
    public ArrayList<Effect> apply() {
        if (!isPossible()) {
            System.out.println(actor.getName() + "can't attack " + ((Entity) dobj).getName());
            //results.add(new Effect(RESULTS_NONE));
            return results;
        } else if (!isHit()) {
            System.out.println(actor.getName() + " missed " + ((Entity) dobj).getName());
            results.add(new Effect(RESULTS_MISS));
            return results;
        } else if (isDodge()) {
            System.out.println(((Entity) dobj).getName() + " dodged.");
            results.add(new Effect(RESULTS_DODGE));
            return results;
        } else {
            Entity target = ((Entity) dobj);
            int baseDamage = getBaseDamage();
            int shieldAbsorb = getShieldAbsorb();
            int armorAbsorb = getArmorAbsorb();
            int finalDamage = Math.max(0, baseDamage - shieldAbsorb - armorAbsorb);
            if (finalDamage > 0) {
                System.out.println(actor.getName() + " hits the "
                        + target.getName() + " with the "
                        + actor.getItemInSlot(ITEM_SLOT_RHAND).getName()
                        + " for " + finalDamage + " damage.");
                results.add(new Effect(RESULTS_DAMAGE_HP, finalDamage));
                target.setHealth(target.getHealth() - finalDamage);
            }
            addMoreEffects();
            return results;
        }
    }

}
