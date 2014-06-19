package svugame.model.action;

/**
 *
 * @author Alan
 */
public interface ActionConstants {
    
    // direct effects
    public static final int RESULTS_NONE = 0;
    public static final int RESULTS_MISS = 1;
    public static final int RESULTS_DAMAGE_HP = 2;
    public static final int RESULTS_DAMAGE_SP = 3;
    public static final int RESULTS_DOT_HP = 4;
    public static final int RESULTS_DOT_SP = 5;
    public static final int RESULTS_BLOCK = 6;
    public static final int RESULTS_SPEED = 7;
    public static final int RESULTS_DODGE = 8;
    public static final int RESULTS_RESIST = 9;
    public static final int RESULTS_HEAL = 10;
    public static final int RESULTS_PERSUADE = 11;
    public static final int RESULTS_INTIMIDATE = 12;
    public static final int RESULTS_INSPIRE = 13;
    public static final int RESUTLS_HAGGLE = 14;
    public static final int RESULTS_SNEAK = 15;
    public static final int RESULTS_ESCAPE = 16;
    public static final int RESULTS_UNLOCK = 17;
    public static final int RESULTS_PICKPOCKET = 18;
    public static final int RESULTS_UNTRAP = 19;
    
    //spell results (Negative)
    public static final int RESULTS_BURN = 50;
    public static final int RESULTS_FREEZE = 51;
    public static final int RESULTS_SOAK = 52;
    public static final int RESULTS_SHOCK = 53;
    public static final int RESULTS_STUN = 54;
    public static final int RESULTS_SLOW = 55;
    public static final int RESULTS_DRAIN = 56;
    public static final int RESULTS_SIPHON = 57;
    public static final int RESULTS_BLIND = 58;
    public static final int RESULTS_ROOT = 59;
    public static final int RESULTS_PANIC = 60;
    public static final int RESULTS_SILENCE = 61;
    
    // spell results (Positive)
    public static final int RESULTS_HASTE = 70;
    public static final int RESULTS_SHELL = 71;
    public static final int RESULTS_SHIELD = 72;
    public static final int RESULTS_INVISIBLE = 73;
    public static final int RESULTS_RESTORE = 74;
    public static final int RESULTS_DISPELL = 75;
    
    // attribute buffs
    public static final int RESULTS_BUFF_STR = 100;
    public static final int RESULTS_BUFF_AGI = 101;
    public static final int RESULTS_BUFF_END = 102;
    public static final int RESULTS_BUFF_PER = 103;
    public static final int RESULTS_BUFF_DEX = 104;
    public static final int RESULTS_BUFF_CHA = 105;
    public static final int RESULTS_BUFF_INT = 106;
    public static final int RESULTS_BUFF_WIS = 107;
    public static final int RESULTS_BUFF_FOC = 108;
    
    // attribute debuffs
    public static final int RESULTS_HARM_STR = 110;
    public static final int RESULTS_HARM_AGI = 111;
    public static final int RESULTS_HARM_END = 112;
    public static final int RESULTS_HARM_PER = 113;
    public static final int RESULTS_HARM_DEX = 114;
    public static final int RESULTS_HARM_CHA = 115;
    public static final int RESULTS_HARM_INT = 116;
    public static final int RESULTS_HARM_WIS = 117;
    public static final int RESULTS_HARM_FOC = 118;
    
    // skill buffs
    public static final int RESULTS_BUFF_PLAY = 201; // (PER & FOC) Play Instrument*
    public static final int RESULTS_BUFF_SING = 202; // (END & PER) Sing Anthem*
    public static final int RESULTS_BUFF_THRUST = 203; // (AGI & DEX) Thrust*
    public static final int RESULTS_BUFF_SWING = 204; //(AGI & DEX) Swing (dot)*
    public static final int RESULTS_BUFF_WHIRL = 205; // (AGI & DEX) Whirlwind (multiple enemies)*
    public static final int RESULTS_BUFF_CHOP = 206; // (STR & CHA) Chop*
    public static final int RESULTS_BUFF_SUNDER = 207; // (STR & CHA) Sunder (dot)*
    public static final int RESULTS_BUFF_CLEAVE = 208; // (STR & CHA) Cleave (residual damage)*
    public static final int RESULTS_BUFF_STAB = 209; // (AGI & PER) Stab*
    public static final int RESULTS_BUFF_SLASH = 210; // (AGI & PER) Slash (dot)*
    public static final int RESULTS_BUFF_CRIPPLE = 211; // Close Quarters (AGI & PER) Disarm (loss of weapon)*
    public static final int RESULTS_BUFF_PIERCE = 212; // Projectile weapons (END & DEX) Pierce*
    public static final int RESULTS_BUFF_PUNCTURE = 213; // Projectile weapons (END & DEX) Puncture (dot)*
    public static final int RESULTS_BUFF_SKEWER = 214; // Projectile weapons (END & DEX) Precision (stun)*
    public static final int RESULTS_BUFF_SHIELD = 215; // (AGI & DEX)
    public static final int RESULTS_BUFF_SPEED = 216; // Sprint (END & FOC)*
    public static final int RESULTS_BUFF_DODGE = 217; // Dodge (AGI & INT)
    public static final int RESULTS_BUFF_RESIST = 218; // Resist Magic (END & WIS)
    public static final int RESULTS_BUFF_AID = 219; // (END & INT)*
    public static final int RESULTS_BUFF_PERSUADE = 220; // Persuade (CHA & INT)
    public static final int RESULTS_BUFF_INTIMIDATE = 221; // Intimidate (CHA & STR)
    public static final int RESULTS_BUFF_INSPIRE = 222; // Inspire (CHA & FOC)
    public static final int RESULTS_BUFF_HAGGLE = 223; // Haggle (CHA & WIS)
    public static final int RESULTS_BUFF_SNEAK = 224; // Sneak (PER & FOC)*
    public static final int RESULTS_BUFF_ESCAPE = 225; // Escape (AGI & PER)*
    public static final int RESULTS_BUFF_LOCKPICK = 226; // Pick Lock (DEX & INT)
    public static final int RESULTS_BUFF_PICKPOCKET = 227; // Pick Pocket (CHA & FOC)
    public static final int RESULTS_BUFF_DISABLE = 228; // Disarm Trap (DEX & INT)
    public static final int RESULTS_BUFF_FEAR = 229; // Fear (INT & PER)*
    public static final int RESULTS_BUFF_BRAVERY = 230; // Bravery (WIS & CHA)*
    public static final int RESULTS_BUFF_MISSILE = 231; // Stone Missile (WIS & STR)*
    public static final int RESULTS_BUFF_ROCKSLIDE = 232; // Rock Slide(WIS & STR)*
    public static final int RESULTS_BUFF_FIREBOLT = 233; // Fire bolt(INT & AGI)*
    public static final int RESULTS_BUFF_FIREBALL = 234; // Fireball(INT & AGI)*
    public static final int RESULTS_BUFF_ICICLE = 235; // Ice Sphere(WIS & DEX)*
    public static final int RESULTS_BUFF_GYSER = 236; // Water Cannon(WIS & DEX)*
    public static final int RESULTS_BUFF_SHOCK = 237; // Lightning(FOC & DEX)*
    public static final int RESULTS_BUFF_LIGHTNING = 238; // Chain Lightning(FOC & DEX)*
    public static final int RESULTS_BUFF_EARTHQUAKE = 239; // Earthquake(WIS & STR)*
    public static final int RESULTS_BUFF_TORNADO = 240; // Tornado(INT & STR)*
    public static final int RESULTS_BUFF_TSUNAMI = 241; // Tsunami(FOC & STR)*
    public static final int RESULTS_BUFF_BLIND = 242; // Blind (causes miss) (WIS & CHA)*
    public static final int RESULTS_BUFF_HASTE = 243; // Haste (WIS & AGI)*
    public static final int RESULTS_BUFF_SHELL = 244; // Shell (FOC & END)*
    public static final int RESULTS_BUFF_HEAL = 245; // Heal (INT & STR)*
    public static final int RESULTS_BUFF_CONFUSE = 246; // Mind Trick (WIS & CHA)
    public static final int RESULTS_BUFF_INVISIBLE = 247; // Invisibility (INT & END)*
    public static final int RESULTS_BUFF_TELEPORT = 248; // Teleport (FOC & END)*
    public static final int RESULTS_BUFF_KNOCK = 249; // unlock (FOC & PER)
    public static final int RESULTS_BUFF_DISARM = 250; // Disable Trap (INT & PER)
    
    // skill debuffs
    public static final int RESULTS_HARM_PLAY = 301; // (PER & FOC) Play Instrument*
    public static final int RESULTS_HARM_SING = 302; // (END & PER) Sing Anthem*
    public static final int RESULTS_HARM_THRUST = 303; // (AGI & DEX) Thrust*
    public static final int RESULTS_HARM_SWING = 304; //(AGI & DEX) Swing (dot)*
    public static final int RESULTS_HARM_WHIRL = 305; // (AGI & DEX) Whirlwind (multiple enemies)*
    public static final int RESULTS_HARM_CHOP = 306; // (STR & CHA) Chop*
    public static final int RESULTS_HARM_SUNDER = 307; // (STR & CHA) Sunder (dot)*
    public static final int RESULTS_HARM_CLEAVE = 308; // (STR & CHA) Cleave (residual damage)*
    public static final int RESULTS_HARM_STAB = 309; // (AGI & PER) Stab*
    public static final int RESULTS_HARM_SLASH = 310; // (AGI & PER) Slash (dot)*
    public static final int RESULTS_HARM_CRIPPLE = 311; // Close Quarters (AGI & PER) Disarm (loss of weapon)*
    public static final int RESULTS_HARM_PIERCE = 312; // Projectile weapons (END & DEX) Pierce*
    public static final int RESULTS_HARM_PUNCTURE = 313; // Projectile weapons (END & DEX) Puncture (dot)*
    public static final int RESULTS_HARM_SKEWER = 314; // Projectile weapons (END & DEX) Precision (stun)*
    public static final int RESULTS_HARM_SHIELD = 315; // (AGI & DEX)
    public static final int RESULTS_HARM_SPEED = 316; // Sprint (END & FOC)*
    public static final int RESULTS_HARM_DODGE = 317; // Dodge (AGI & INT)
    public static final int RESULTS_HARM_RESIST = 318; // Resist Magic (END & WIS)
    public static final int RESULTS_HARM_AID = 319; // (END & INT)*
    public static final int RESULTS_HARM_PERSUADE = 320; // Persuade (CHA & INT)
    public static final int RESULTS_HARM_INTIMIDATE = 321; // Intimidate (CHA & STR)
    public static final int RESULTS_HARM_INSPIRE = 322; // Inspire (CHA & FOC)
    public static final int RESULTS_HARM_HAGGLE = 323; // Haggle (CHA & WIS)
    public static final int RESULTS_HARM_SNEAK = 324; // Sneak (PER & FOC)*
    public static final int RESULTS_HARM_ESCAPE = 325; // Escape (AGI & PER)*
    public static final int RESULTS_HARM_LOCKPICK = 326; // Pick Lock (DEX & INT)
    public static final int RESULTS_HARM_PICKPOCKET = 327; // Pick Pocket (CHA & FOC)
    public static final int RESULTS_HARM_DISABLE = 328; // Disarm Trap (DEX & INT)
    public static final int RESULTS_HARM_FEAR = 329; // Fear (INT & PER)*
    public static final int RESULTS_HARM_BRAVERY = 330; // Bravery (WIS & CHA)*
    public static final int RESULTS_HARM_MISSILE = 331; // Stone Missile (WIS & STR)*
    public static final int RESULTS_HARM_ROCKSLIDE = 332; // Rock Slide(WIS & STR)*
    public static final int RESULTS_HARM_FIREBOLT = 333; // Fire bolt(INT & AGI)*
    public static final int RESULTS_HARM_FIREBALL = 334; // Fireball(INT & AGI)*
    public static final int RESULTS_HARM_ICICLE = 335; // Ice Sphere(WIS & DEX)*
    public static final int RESULTS_HARM_GYSER = 336; // Water Cannon(WIS & DEX)*
    public static final int RESULTS_HARM_SHOCK = 337; // Lightning(FOC & DEX)*
    public static final int RESULTS_HARM_LIGHTNING = 338; // Chain Lightning(FOC & DEX)*
    public static final int RESULTS_HARM_EARTHQUAKE = 339; // Earthquake(WIS & STR)*
    public static final int RESULTS_HARM_TORNADO = 340; // Tornado(INT & STR)*
    public static final int RESULTS_HARM_TSUNAMI = 341; // Tsunami(FOC & STR)*
    public static final int RESULTS_HARM_BLIND = 342; // Blind (causes miss) (WIS & CHA)*
    public static final int RESULTS_HARM_HASTE = 343; // Haste (WIS & AGI)*
    public static final int RESULTS_HARM_SHELL = 344; // Shell (FOC & END)*
    public static final int RESULTS_HARM_HEAL = 345; // Heal (INT & STR)*
    public static final int RESULTS_HARM_CONFUSE = 346; // Mind Trick (WIS & CHA)
    public static final int RESULTS_HARM_INVISIBLE = 347; // Invisibility (INT & END)*
    public static final int RESULTS_HARM_TELEPORT = 348; // Teleport (FOC & END)*
    public static final int RESULTS_HARM_KNOCK = 349; // unlock (FOC & PER)
    public static final int RESULTS_HARM_DISARM = 350; // Disable Trap (INT & PER)

}
