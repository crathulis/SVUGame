/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import static svugame.model.skills.SkillConstants.SKILL_AID;
import static svugame.model.skills.SkillConstants.SKILL_BLIND;
import static svugame.model.skills.SkillConstants.SKILL_BRAVERY;
import static svugame.model.skills.SkillConstants.SKILL_CHOP;
import static svugame.model.skills.SkillConstants.SKILL_CLEAVE;
import static svugame.model.skills.SkillConstants.SKILL_CONFUSE;
import static svugame.model.skills.SkillConstants.SKILL_CRIPPLE;
import static svugame.model.skills.SkillConstants.SKILL_DISABLE;
import static svugame.model.skills.SkillConstants.SKILL_DISARM;
import static svugame.model.skills.SkillConstants.SKILL_DODGE;
import static svugame.model.skills.SkillConstants.SKILL_EARTHQUAKE;
import static svugame.model.skills.SkillConstants.SKILL_ESCAPE;
import static svugame.model.skills.SkillConstants.SKILL_FEAR;
import static svugame.model.skills.SkillConstants.SKILL_FIREBALL;
import static svugame.model.skills.SkillConstants.SKILL_FIREBOLT;
import static svugame.model.skills.SkillConstants.SKILL_GYSER;
import static svugame.model.skills.SkillConstants.SKILL_HAGGLE;
import static svugame.model.skills.SkillConstants.SKILL_HASTE;
import static svugame.model.skills.SkillConstants.SKILL_HEAL;
import static svugame.model.skills.SkillConstants.SKILL_ICICLE;
import static svugame.model.skills.SkillConstants.SKILL_INSPIRE;
import static svugame.model.skills.SkillConstants.SKILL_INTIMIDATE;
import static svugame.model.skills.SkillConstants.SKILL_INVISIBLE;
import static svugame.model.skills.SkillConstants.SKILL_KNOCK;
import static svugame.model.skills.SkillConstants.SKILL_LIGHTNING;
import static svugame.model.skills.SkillConstants.SKILL_LOCKPICK;
import static svugame.model.skills.SkillConstants.SKILL_MISSILE;
import static svugame.model.skills.SkillConstants.SKILL_PERSUADE;
import static svugame.model.skills.SkillConstants.SKILL_PICKPOCKET;
import static svugame.model.skills.SkillConstants.SKILL_PIERCE;
import static svugame.model.skills.SkillConstants.SKILL_PLAY;
import static svugame.model.skills.SkillConstants.SKILL_PUNCTURE;
import static svugame.model.skills.SkillConstants.SKILL_RESIST;
import static svugame.model.skills.SkillConstants.SKILL_ROCKSLIDE;
import static svugame.model.skills.SkillConstants.SKILL_SHELL;
import static svugame.model.skills.SkillConstants.SKILL_SHIELD;
import static svugame.model.skills.SkillConstants.SKILL_SHOCK;
import static svugame.model.skills.SkillConstants.SKILL_SING;
import static svugame.model.skills.SkillConstants.SKILL_SKEWER;
import static svugame.model.skills.SkillConstants.SKILL_SLASH;
import static svugame.model.skills.SkillConstants.SKILL_SNEAK;
import static svugame.model.skills.SkillConstants.SKILL_SPEED;
import static svugame.model.skills.SkillConstants.SKILL_STAB;
import static svugame.model.skills.SkillConstants.SKILL_SUNDER;
import static svugame.model.skills.SkillConstants.SKILL_SWING;
import static svugame.model.skills.SkillConstants.SKILL_TELEPORT;
import static svugame.model.skills.SkillConstants.SKILL_THRUST;
import static svugame.model.skills.SkillConstants.SKILL_TORNADO;
import static svugame.model.skills.SkillConstants.SKILL_TSUNAMI;
import static svugame.model.skills.SkillConstants.SKILL_WHIRL;

/**
 *
 * @author Alan
 */
public class ActionFactory {

    public static Action getInstance(Entity actor, int skillId, Thing dobj, Thing iobj) {
        switch (skillId) {
            case SKILL_PLAY:
                return new PlayAction(actor, skillId, dobj, iobj);
            case SKILL_SING:
            case SKILL_THRUST:
                return new OhThrustAction(actor, skillId, dobj, iobj);
            case SKILL_SWING:
                return new OhSwingAction(actor, skillId, dobj, iobj);
            case SKILL_WHIRL:
                return new OhWhirlAction(actor, skillId, dobj, iobj);
            case SKILL_CHOP:
                return new ThChopAction(actor, skillId, dobj, iobj);
            case SKILL_SUNDER:
                return new ThSunderAction(actor, skillId, dobj, iobj);
            case SKILL_CLEAVE:
                return new ThCleaveAction(actor, skillId, dobj, iobj);
            case SKILL_STAB:
                return new CqStabAction(actor, skillId, dobj, iobj);
            case SKILL_SLASH:
                return new CqSlashAction(actor, skillId, dobj, iobj);
            case SKILL_CRIPPLE:
                return new CqCrippleAction(actor, skillId, dobj, iobj);
            case SKILL_PIERCE:
                return new RangedAction(actor, skillId, dobj, iobj);
            case SKILL_PUNCTURE:
                return new RangedAction(actor, skillId, dobj, iobj);
            case SKILL_SKEWER:
                return new RangedAction(actor, skillId, dobj, iobj);
            case SKILL_SHIELD: /* passive */
                return null;
            case SKILL_SPEED:
                return new SpeedAction(actor, skillId, dobj, iobj);
            case SKILL_DODGE: /* passive */
                return null;
            case SKILL_RESIST: /* passive */
                return null;
            case SKILL_AID:
            case SKILL_PERSUADE:
            case SKILL_INTIMIDATE:
            case SKILL_INSPIRE:
            case SKILL_HAGGLE:
            case SKILL_SNEAK:
            case SKILL_ESCAPE:
            case SKILL_LOCKPICK:
            case SKILL_PICKPOCKET:
            case SKILL_DISABLE:
            case SKILL_FEAR:
            case SKILL_BRAVERY:
            case SKILL_MISSILE:
            case SKILL_ROCKSLIDE:
            case SKILL_FIREBOLT:
            case SKILL_FIREBALL:
            case SKILL_ICICLE:
            case SKILL_GYSER:
            case SKILL_SHOCK:
            case SKILL_LIGHTNING:
            case SKILL_EARTHQUAKE:
            case SKILL_TORNADO:
            case SKILL_TSUNAMI:
            case SKILL_BLIND:
            case SKILL_HEAL:
            case SKILL_SHELL:
            case SKILL_CONFUSE:
            case SKILL_INVISIBLE:
            case SKILL_HASTE:
            case SKILL_TELEPORT:
            case SKILL_KNOCK:
            case SKILL_DISARM:
            default:
                return null;
        }
    }

}
