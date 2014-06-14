/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package svugame.model.skills;

/**
 *
 * @author Alan
 */
public interface SkillConstants {
    
    public static final int PLAY_INSTRUMENT = 1; // (PER & FOC)*
    public static final int SING_ANTHEM = 2; // (END & PER)*
    public static final int OH_THRUST = 3; // (AGI & DEX) Thrust*
    public static final int OH_SLASH = 4; //(AGI & DEX) Swing (dot)*
    public static final int OH_WHIRLWIND = 5; // (AGI & DEX) Whirlwind (multiple enemies)*
    public static final int TH_CHOP = 6; // (STR & CHA) Chop*
    public static final int TH_SUNDER = 7; // (STR & CHA) Sunder (dot)*
    public static final int TH_CLEAVE = 8; // (STR & CHA) Cleave (residual damage)*
    public static final int CQ_STAB = 9; // (AGI & PER) Stab*
    public static final int CQ_CUT = 10; // (AGI & PER) Slash (dot)*
    public static final int CQ_SLICE = 11; // Close Quarters (AGI & PER) Disarm (loss of weapon)*
    public static final int PR_PIERCE = 12; //Projectile weapons (END & DEX) Pierce*
    public static final int PR_PUNCTURE = 13; //Projectile weapons (END & DEX) Puncture (dot)*
    public static final int PR_SKEWER = 14; //Projectile weapons (END & DEX) Precision (stun)*
    public static final int SHIELD_BLOCK = 15; // (AGI & DEX)
    public static final int SPRINT = 16; //Sprint (END & FOC)*
    public static final int DODGE = 17; // Dodge (AGI & INT)
    public static final int RESIST = 18; //Resist Magic (END & WIS)
    public static final int FIRST_AID = 19; // (END & INT)*
    public static final int PERSUADE = 20; // Persuade (CHA & INT)
    public static final int INTIMIDATE = 21; // Intimidate (CHA & STR)
    public static final int INSPIRE = 22; // Inspire (CHA & FOC)
    public static final int HAGGLE = 23; // Haggle (CHA & WIS)
    public static final int SNEAK = 24; // Sneak (PER & FOC)*
    public static final int ESCAPE = 25; //Escape (AGI & PER)*
    public static final int PICK_LOCK = 26; // Pick Lock (DEX & INT)
    public static final int PICK_POCKET = 27; // Pick Pocket (CHA & FOC)
    public static final int DISARM_TRAP = 28; // Disarm Trap (DEX & INT)
    public static final int FEAR = 29; // Fear (INT & PER)*
    public static final int BRAVERY = 30; // Bravery (WIS & CHA)*
    public static final int STONE_MISSILE = 31; // Stone Missile (WIS & STR)*
    public static final int ROCK_SLIDE = 32; // Rock Slide(WIS & STR)*
    public static final int FIRE_BOLT = 33; // Fire bolt(INT & AGI)*
    public static final int FIREBALL = 34; // Fireball(INT & AGI)*
    public static final int ICE_SPHERE = 35; // Ice Sphere(WIS & DEX)*
    public static final int WATER_CANNON = 36; // Water Cannon(WIS & DEX)*
    public static final int LIGHTNING = 37; // Lightning(FOC & DEX)*
    public static final int CHAIN_LIGHTNING = 38; // Chain Lightning(FOC & DEX)*
    public static final int EARTHQUAKE = 39; // Earthquake(WIS & STR)*
    public static final int TORNADO = 40; // Tornado(INT & STR)*
    public static final int TSUNAMI = 41; // Tsunami(FOC & STR)*
    public static final int BLIND = 42; // Blind (causes miss) (WIS & CHA)*
    public static final int HASTE = 43; // Haste (WIS & AGI)*
    public static final int SHELL = 44; // Shell (FOC & END)*
    public static final int HEAL = 45; // Heal (INT & STR)*
    public static final int MIND_TRICK = 46; // Mind Trick (WIS & CHA)
    public static final int INVISIBILITY = 47; // Invisibility (INT & END)*
    public static final int TELEPORT = 48; // Teleport (FOC & END)*
    public static final int KNOCK = 49; // unlock (FOC & PER)
    public static final int DISABLE_TRAP = 50; // Disable Trap (INT & PER)
    
    public static final int NUM_SKILLS = 50;

    
}
