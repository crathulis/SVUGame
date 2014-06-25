package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.SKILL_THRUST;

/**
 *
 * @author Alan
 */
public class ThChopAction extends ThMeleeAction {

    public ThChopAction(Entity actor, int skillId) {
        super(actor, skillId);
    }

    public ThChopAction(Entity actor, int skillId, Thing dobj) {
        super(actor, skillId, dobj);
    }

    public ThChopAction(Entity actor, int skillId, Thing dobj, Thing iobj) {
        super(actor, skillId, dobj, iobj);
    }

    @Override
    protected void addMoreEffects() {
    }

}
