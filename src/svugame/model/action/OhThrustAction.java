package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import svugame.model.items.ItemConstants;
import static svugame.model.skills.SkillConstants.SKILL_THRUST;


/**
 *
 * @author Alan
 */
public class OhThrustAction extends OhMeleeAction {

    public OhThrustAction(Entity actor) {
        super(actor, SKILL_THRUST);
    }

    public OhThrustAction(Entity actor, Thing dobj) {
        super(actor, SKILL_THRUST, dobj);
    }

    public OhThrustAction(Entity actor, Thing dobj, Thing iobj) {
        super(actor, SKILL_THRUST, dobj, iobj);
    }

}
