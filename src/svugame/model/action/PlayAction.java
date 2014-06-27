package svugame.model.action;

import java.util.ArrayList;
import svugame.model.Dice;
import svugame.model.Thing;
import static svugame.model.action.ActionConstants.RESULTS_NONE;
import static svugame.model.action.ActionConstants.RESULTS_PLAY;
import svugame.model.entity.Entity;
import svugame.model.entity.Party;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.SKILL_PLAY;

/**
 *
 * @author Alan
 */
public class PlayAction extends Action implements ItemConstants {

    public PlayAction(Entity actor, int skillId) {
        super(actor, SKILL_PLAY);
    }

    public PlayAction(Entity actor, int skillId, Thing dobj) {
        super(actor, SKILL_PLAY, dobj);
    }

    public PlayAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, SKILL_PLAY, dobj, iobj);
    }

    @Override
    public boolean isPossible() {
        // actor must have enough spirit to complete action
        if (actor.getSpirit()<(actor.getSkill(skillId).getModel().getSpirit())){
            return false;
        }
        // actor must be carrying an instrument in one of their hands
        if (actor.getItemInSlot(ITEM_SLOT_RHAND).getType() != ITEM_TYPE_INSTRUMENT
                && actor.getItemInSlot(ITEM_SLOT_LHAND).getType() != ITEM_TYPE_INSTRUMENT) {
            return false;
        }
        // the dobj must be an entity or a party of entities
        if (!(dobj instanceof Entity) && !(dobj instanceof Party)) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Effect> apply() {
        ArrayList<Effect> results = new ArrayList<>();
        int successChance = actor.getSkillValue(skillId);
        if (Dice.roll("1d100") <= successChance) {
            results.add(new Effect(RESULTS_PLAY, 1));
            //TODO: decide on the effect of playing an instrument
        } else {
            results.add(new Effect(RESULTS_NONE));
        }
        return results;
    }

}
