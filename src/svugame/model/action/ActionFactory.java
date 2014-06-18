/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svugame.model.action;

import svugame.model.Thing;
import svugame.model.entity.Entity;
import static svugame.model.skills.SkillConstants.SKILL_BLIN;
import static svugame.model.skills.SkillConstants.SKILL_BRAV;
import static svugame.model.skills.SkillConstants.SKILL_CLIG;
import static svugame.model.skills.SkillConstants.SKILL_CQCU;
import static svugame.model.skills.SkillConstants.SKILL_CQSL;
import static svugame.model.skills.SkillConstants.SKILL_CQST;
import static svugame.model.skills.SkillConstants.SKILL_DISA;
import static svugame.model.skills.SkillConstants.SKILL_DODG;
import static svugame.model.skills.SkillConstants.SKILL_DTRA;
import static svugame.model.skills.SkillConstants.SKILL_EART;
import static svugame.model.skills.SkillConstants.SKILL_ESCA;
import static svugame.model.skills.SkillConstants.SKILL_FAID;
import static svugame.model.skills.SkillConstants.SKILL_FBAL;
import static svugame.model.skills.SkillConstants.SKILL_FBOL;
import static svugame.model.skills.SkillConstants.SKILL_FEAR;
import static svugame.model.skills.SkillConstants.SKILL_HAGG;
import static svugame.model.skills.SkillConstants.SKILL_HAST;
import static svugame.model.skills.SkillConstants.SKILL_HEAL;
import static svugame.model.skills.SkillConstants.SKILL_INSP;
import static svugame.model.skills.SkillConstants.SKILL_INTI;
import static svugame.model.skills.SkillConstants.SKILL_INVI;
import static svugame.model.skills.SkillConstants.SKILL_ISPH;
import static svugame.model.skills.SkillConstants.SKILL_KNOC;
import static svugame.model.skills.SkillConstants.SKILL_LIGH;
import static svugame.model.skills.SkillConstants.SKILL_MTRI;
import static svugame.model.skills.SkillConstants.SKILL_OHSL;
import static svugame.model.skills.SkillConstants.SKILL_OHTH;
import static svugame.model.skills.SkillConstants.SKILL_OHWH;
import static svugame.model.skills.SkillConstants.SKILL_PERS;
import static svugame.model.skills.SkillConstants.SKILL_PLAY;
import static svugame.model.skills.SkillConstants.SKILL_PLOC;
import static svugame.model.skills.SkillConstants.SKILL_PPOC;
import static svugame.model.skills.SkillConstants.SKILL_PRPI;
import static svugame.model.skills.SkillConstants.SKILL_PRPU;
import static svugame.model.skills.SkillConstants.SKILL_PRSK;
import static svugame.model.skills.SkillConstants.SKILL_RESI;
import static svugame.model.skills.SkillConstants.SKILL_RSLI;
import static svugame.model.skills.SkillConstants.SKILL_SHEL;
import static svugame.model.skills.SkillConstants.SKILL_SHIE;
import static svugame.model.skills.SkillConstants.SKILL_SING;
import static svugame.model.skills.SkillConstants.SKILL_SMIS;
import static svugame.model.skills.SkillConstants.SKILL_SNEA;
import static svugame.model.skills.SkillConstants.SKILL_SPRI;
import static svugame.model.skills.SkillConstants.SKILL_TELE;
import static svugame.model.skills.SkillConstants.SKILL_THCH;
import static svugame.model.skills.SkillConstants.SKILL_THCL;
import static svugame.model.skills.SkillConstants.SKILL_THSU;
import static svugame.model.skills.SkillConstants.SKILL_TORN;
import static svugame.model.skills.SkillConstants.SKILL_TSUN;
import static svugame.model.skills.SkillConstants.SKILL_WCAN;

/**
 *
 * @author Alan
 */
public class ActionFactory {

    public static Action getInstance(Entity actor, int skillId, Thing dobj, Thing iobj) {
        switch (skillId) {
            case SKILL_PLAY:
            case SKILL_SING:
            case SKILL_OHTH:
                return new OhMeleeAction(actor, skillId, dobj, iobj);
            case SKILL_OHSL:
                return new OhMeleeAction(actor, skillId, dobj, iobj);
            case SKILL_OHWH:
                return new OhMeleeAction(actor, skillId, dobj, iobj);
            case SKILL_THCH:
            case SKILL_THSU:
            case SKILL_THCL:
            case SKILL_CQST:
            case SKILL_CQCU:
            case SKILL_CQSL:
            case SKILL_PRPI:
            case SKILL_PRPU:
            case SKILL_PRSK:
            case SKILL_SHIE:
            case SKILL_SPRI:
            case SKILL_DODG:
            case SKILL_RESI:
            case SKILL_FAID:
            case SKILL_PERS:
            case SKILL_INTI:
            case SKILL_INSP:
            case SKILL_HAGG:
            case SKILL_SNEA:
            case SKILL_ESCA:
            case SKILL_PLOC:
            case SKILL_PPOC:
            case SKILL_DISA:
            case SKILL_FEAR:
            case SKILL_BRAV:
            case SKILL_SMIS:
            case SKILL_RSLI:
            case SKILL_FBOL:
            case SKILL_FBAL:
            case SKILL_ISPH:
            case SKILL_WCAN:
            case SKILL_LIGH:
            case SKILL_CLIG:
            case SKILL_EART:
            case SKILL_TORN:
            case SKILL_TSUN:
            case SKILL_BLIN:
            case SKILL_HAST:
            case SKILL_SHEL:
            case SKILL_HEAL:
            case SKILL_MTRI:
            case SKILL_INVI:
            case SKILL_TELE:
            case SKILL_KNOC:
            case SKILL_DTRA:
            default:
                return null;
        }
    }

}
