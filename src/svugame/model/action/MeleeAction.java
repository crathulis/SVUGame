package svugame.model.action;

import java.util.ArrayList;
import svugame.model.Dice;
import svugame.model.Thing;
import static svugame.model.action.ActionConstants.RESULTS_ARMOR;
import static svugame.model.action.ActionConstants.RESULTS_BLOCK;
import static svugame.model.action.ActionConstants.RESULTS_DAMAGE_HP;
import static svugame.model.action.ActionConstants.RESULTS_DODGE;
import static svugame.model.action.ActionConstants.RESULTS_MISS;
import static svugame.model.action.ActionConstants.RESULTS_NONE;
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
    public ArrayList<Effect> apply() {
        ArrayList<Effect> results = new ArrayList<>();
        if(!isPossible()){
            results.add(new Effect(RESULTS_NONE));
            return results;
        }
        double agilityChance = actor.getAgility() / 25.0;
        double skillFactor = actor.getSkillValue(skillId);
        int successChance = (int) Math.round(agilityChance + skillFactor);
        boolean hit = (Dice.roll("1d100") <= successChance);
        Entity target = (Entity) dobj;
        boolean dodge = Dice.roll("1d100") <= target.getAgility() - skillFactor;
        if (!hit) {
            System.out.println(actor.getName() + " missed.");
            results.add(new Effect(RESULTS_MISS));
            return results;
        } else if (dodge) {
            System.out.println(target.getName() + " dodged.");
            results.add(new Effect(RESULTS_DODGE));
            return results;
        } else {
            double strengthFactor = actor.getStrength() / 25.0;
            double weaponDamage = actor.getItemInSlot(ITEM_SLOT_RHAND).getDamage()
                    * actor.getLevel();
            int maxDamage = (int) Math.round((strengthFactor + skillFactor) * weaponDamage);
            int damage = Dice.roll(actor.getLevel() + "d" + maxDamage);
            System.out.println(actor.getName() + " hits the "
                    + target.getName() + " with the "
                    + actor.getItemInSlot(ITEM_SLOT_RHAND).getName());
            int shieldAbsorb = 0;
            if (target.getItemInSlot(ITEM_SLOT_LHAND).getType() == ITEM_TYPE_SHIELD) {
                int shieldPower = target.getItemInSlot(ITEM_SLOT_LHAND).getDamage();
                int maxDamageAbsorb = (int) Math.round(shieldPower * target.getLevel());
                shieldAbsorb = Dice.roll(target.getLevel() + "d" + maxDamageAbsorb);
                System.out.println(target.getName() + " blocks " + shieldAbsorb
                        + " points of damage with their shield.");
                results.add(new Effect(RESULTS_BLOCK,shieldAbsorb));
            }
            int armorAbsorb = 0;
            if (target.getItemInSlot(ITEM_SLOT_TORSO).getType() == ITEM_TYPE_ARMOR) {
                int armorPower = target.getItemInSlot(ITEM_SLOT_TORSO).getDamage();
                int maxArmorAbsorb = (int) Math.round(armorPower * target.getLevel());
                armorAbsorb = Dice.roll(target.getLevel() + "d" + maxArmorAbsorb);
                System.out.println(target.getName() + "'s armor absorbs " + armorAbsorb
                        + " points of damage.");
                results.add(new Effect(RESULTS_ARMOR,armorAbsorb));
            }
            int finalDamage = Math.max(0, damage - shieldAbsorb - armorAbsorb);
            results.add(new Effect(RESULTS_DAMAGE_HP, finalDamage));
            target.setHealth(target.getHealth()-finalDamage);
            return results;
        }
    }

}
