package svugame.model.action;

import svugame.model.Dice;
import svugame.model.Thing;
import svugame.model.entity.Entity;
import static svugame.model.items.ItemConstants.ITEM_SLOT_LHAND;
import static svugame.model.items.ItemConstants.ITEM_SLOT_RHAND;
import static svugame.model.items.ItemConstants.ITEM_SLOT_TORSO;
import static svugame.model.items.ItemConstants.ITEM_TYPE_ARMOR;
import static svugame.model.items.ItemConstants.ITEM_TYPE_SHIELD;

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

    @Override
    public boolean success() {
        double agilityChance = actor.getAgility() / 25.0;
        double skillChance = actor.getSkillValue(skillId);
        int successChance = (int) Math.round(agilityChance + skillChance);
        boolean hit = (Dice.roll("1d100") <= successChance);
        Entity target = (Entity) dobj;
        boolean dodge = Dice.roll("1d100") <= target.getAgility() - skillChance;
        if (!hit) {
            System.out.println(actor.getName() + " missed.");
            return false;
        } else if (dodge) {
            System.out.println(target.getName() + " dodged.");
            return false;
        } else {
            System.out.println(actor.getName() + " thrusts the "
                    + actor.getItemInSlot(ITEM_SLOT_RHAND).getName()
                    + " into " + target.getName());
            return true;
        }
    }

    @Override
    public int resultType() {
        return ActionConstants.RESULTS_DAMAGE_HP;
    }

    @Override
    public int resultAmount() {
        double strengthFactor = actor.getStrength() / 25.0;
        double skillFactor = actor.getSkillValue(skillId);
        double weaponDamage = actor.getItemInSlot(ITEM_SLOT_RHAND).getDamage()
                * actor.getLevel();
        int maxDamage = (int) Math.round((strengthFactor + skillFactor) * weaponDamage);
        int damage = Dice.roll(actor.getLevel() + "d" + maxDamage);
        Entity target = ((Entity) dobj);
        int shieldAbsorb = 0;
        if (target.getItemInSlot(ITEM_SLOT_LHAND).getType() == ITEM_TYPE_SHIELD) {
            int shieldPower = target.getItemInSlot(ITEM_SLOT_LHAND).getDamage();
            int maxDamageAbsorb = (int) Math.round(shieldPower * target.getLevel());
            shieldAbsorb = Dice.roll(target.getLevel() + "d" + maxDamageAbsorb);
            System.out.println(target.getName() + " blocks " + shieldAbsorb
                    + " points of damage with their shield.");
        }
        int armorAbsorb = 0;
        if (target.getItemInSlot(ITEM_SLOT_TORSO).getType() == ITEM_TYPE_ARMOR) {
            int armorPower = target.getItemInSlot(ITEM_SLOT_TORSO).getDamage();
            int maxArmorAbsorb = (int) Math.round(armorPower * target.getLevel());
            armorAbsorb = Dice.roll(target.getLevel() + "d" + maxArmorAbsorb);
            System.out.println(target.getName() + "'s armor absorbs " + armorAbsorb
                    + " points of damage.");
        }
        System.out.println(actor.getName() + " hits for " + (damage - shieldAbsorb - armorAbsorb) + " damage.");
        return Math.max(0,damage-shieldAbsorb-armorAbsorb);
    }

}
