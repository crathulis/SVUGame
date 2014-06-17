package svugame.model.action;

/**
 *
 * @author Alan
 */
public interface ActionConstants {
    
    // direct effects
    public static final int RESULTS_NONE = 0;
    public static final int RESULTS_DAMAGE_HP = 1;
    public static final int RESULTS_DAMAGE_SP = 2;
    public static final int RESULTS_DOT_HP = 3;
    public static final int RESULTS_DOT_SP = 4;
    public static final int RESULTS_BLOCK = 5;
    public static final int RESULTS_SPRINT = 6;
    public static final int RESULTS_DODGE = 7;
    public static final int RESULTS_RESIST = 8;
    public static final int RESULTS_HEAL = 9;
    public static final int RESULTS_PERSUADE = 10;
    public static final int RESULTS_INTIMIDATE = 11;
    public static final int RESULTS_INSPIRE = 12;
    public static final int RESUTLS_HAGGLE = 13;
    public static final int RESULTS_SNEAK = 14;
    public static final int RESULTS_ESCAPE = 15;
    public static final int RESULTS_UNLOCK = 16;
    public static final int RESULTS_PICKPOCKET = 17;
    public static final int RESULTS_UNTRAP = 18;
    
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
    public static final int RESULTS_BUFF_OHTH = 203; // (AGI & DEX) Thrust*
    public static final int RESULTS_BUFF_OHSL = 204; //(AGI & DEX) Swing (dot)*
    public static final int RESULTS_BUFF_OHWH = 205; // (AGI & DEX) Whirlwind (multiple enemies)*
    public static final int RESULTS_BUFF_THCH = 206; // (STR & CHA) Chop*
    public static final int RESULTS_BUFF_THSU = 207; // (STR & CHA) Sunder (dot)*
    public static final int RESULTS_BUFF_THCL = 208; // (STR & CHA) Cleave (residual damage)*
    public static final int RESULTS_BUFF_CQST = 209; // (AGI & PER) Stab*
    public static final int RESULTS_BUFF_CQCU = 210; // (AGI & PER) Slash (dot)*
    public static final int RESULTS_BUFF_CQSL = 211; // Close Quarters (AGI & PER) Disarm (loss of weapon)*
    public static final int RESULTS_BUFF_PRPI = 212; //Projectile weapons (END & DEX) Pierce*
    public static final int RESULTS_BUFF_PRPU = 213; //Projectile weapons (END & DEX) Puncture (dot)*
    public static final int RESULTS_BUFF_PRSK = 214; //Projectile weapons (END & DEX) Precision (stun)*
    public static final int RESULTS_BUFF_SHIE = 215; // (AGI & DEX)
    public static final int RESULTS_BUFF_SPRI = 216; //Sprint (END & FOC)*
    public static final int RESULTS_BUFF_DODG = 217; // Dodge (AGI & INT)
    public static final int RESULTS_BUFF_RESI = 218; //Resist Magic (END & WIS)
    public static final int RESULTS_BUFF_FAID = 219; // (END & INT)*
    public static final int RESULTS_BUFF_PERS = 220; // Persuade (CHA & INT)
    public static final int RESULTS_BUFF_INTI = 221; // Intimidate (CHA & STR)
    public static final int RESULTS_BUFF_INSP = 222; // Inspire (CHA & FOC)
    public static final int RESULTS_BUFF_HAGG = 223; // Haggle (CHA & WIS)
    public static final int RESULTS_BUFF_SNEA = 224; // Sneak (PER & FOC)*
    public static final int RESULTS_BUFF_ESCA = 225; //Escape (AGI & PER)*
    public static final int RESULTS_BUFF_PLOC = 226; // Pick Lock (DEX & INT)
    public static final int RESULTS_BUFF_PPOC = 227; // Pick Pocket (CHA & FOC)
    public static final int RESULTS_BUFF_DISA = 228; // Disarm Trap (DEX & INT)
    public static final int RESULTS_BUFF_FEAR = 229; // Fear (INT & PER)*
    public static final int RESULTS_BUFF_BRAV = 230; // Bravery (WIS & CHA)*
    public static final int RESULTS_BUFF_SMIS = 231; // Stone Missile (WIS & STR)*
    public static final int RESULTS_BUFF_RSLI = 232; // Rock Slide(WIS & STR)*
    public static final int RESULTS_BUFF_FBOL = 233; // Fire bolt(INT & AGI)*
    public static final int RESULTS_BUFF_FBAL = 234; // Fireball(INT & AGI)*
    public static final int RESULTS_BUFF_ISPH = 235; // Ice Sphere(WIS & DEX)*
    public static final int RESULTS_BUFF_WCAN = 236; // Water Cannon(WIS & DEX)*
    public static final int RESULTS_BUFF_LIGH = 237; // Lightning(FOC & DEX)*
    public static final int RESULTS_BUFF_CLIG = 238; // Chain Lightning(FOC & DEX)*
    public static final int RESULTS_BUFF_EART = 239; // Earthquake(WIS & STR)*
    public static final int RESULTS_BUFF_TORN = 240; // Tornado(INT & STR)*
    public static final int RESULTS_BUFF_TSUN = 241; // Tsunami(FOC & STR)*
    public static final int RESULTS_BUFF_BLIN = 242; // Blind (causes miss) (WIS & CHA)*
    public static final int RESULTS_BUFF_HAST = 243; // Haste (WIS & AGI)*
    public static final int RESULTS_BUFF_SHEL = 244; // Shell (FOC & END)*
    public static final int RESULTS_BUFF_HEAL = 245; // Heal (INT & STR)*
    public static final int RESULTS_BUFF_MTRI = 246; // Mind Trick (WIS & CHA)
    public static final int RESULTS_BUFF_INVI = 247; // Invisibility (INT & END)*
    public static final int RESULTS_BUFF_TELE = 248; // Teleport (FOC & END)*
    public static final int RESULTS_BUFF_KNOC = 249; // unlock (FOC & PER)
    public static final int RESULTS_BUFF_DTRA = 250; // Disable Trap (INT & PER)
    
    // skill debuffs
    public static final int RESULTS_HARM_PLAY = 301; // (PER & FOC) Play Instrument*
    public static final int RESULTS_HARM_SING = 302; // (END & PER) Sing Anthem*
    public static final int RESULTS_HARM_OHTH = 303; // (AGI & DEX) Thrust*
    public static final int RESULTS_HARM_OHSL = 304; //(AGI & DEX) Swing (dot)*
    public static final int RESULTS_HARM_OHWH = 305; // (AGI & DEX) Whirlwind (multiple enemies)*
    public static final int RESULTS_HARM_THCH = 306; // (STR & CHA) Chop*
    public static final int RESULTS_HARM_THSU = 307; // (STR & CHA) Sunder (dot)*
    public static final int RESULTS_HARM_THCL = 308; // (STR & CHA) Cleave (residual damage)*
    public static final int RESULTS_HARM_CQST = 309; // (AGI & PER) Stab*
    public static final int RESULTS_HARM_CQCU = 310; // (AGI & PER) Slash (dot)*
    public static final int RESULTS_HARM_CQSL = 311; // Close Quarters (AGI & PER) Disarm (loss of weapon)*
    public static final int RESULTS_HARM_PRPI = 312; //Projectile weapons (END & DEX) Pierce*
    public static final int RESULTS_HARM_PRPU = 313; //Projectile weapons (END & DEX) Puncture (dot)*
    public static final int RESULTS_HARM_PRSK = 314; //Projectile weapons (END & DEX) Precision (stun)*
    public static final int RESULTS_HARM_SHIE = 315; // (AGI & DEX)
    public static final int RESULTS_HARM_SPRI = 316; //Sprint (END & FOC)*
    public static final int RESULTS_HARM_DODG = 317; // Dodge (AGI & INT)
    public static final int RESULTS_HARM_RESI = 318; //Resist Magic (END & WIS)
    public static final int RESULTS_HARM_FAID = 319; // (END & INT)*
    public static final int RESULTS_HARM_PERS = 320; // Persuade (CHA & INT)
    public static final int RESULTS_HARM_INTI = 321; // Intimidate (CHA & STR)
    public static final int RESULTS_HARM_INSP = 322; // Inspire (CHA & FOC)
    public static final int RESULTS_HARM_HAGG = 323; // Haggle (CHA & WIS)
    public static final int RESULTS_HARM_SNEA = 324; // Sneak (PER & FOC)*
    public static final int RESULTS_HARM_ESCA = 325; //Escape (AGI & PER)*
    public static final int RESULTS_HARM_PLOC = 326; // Pick Lock (DEX & INT)
    public static final int RESULTS_HARM_PPOC = 327; // Pick Pocket (CHA & FOC)
    public static final int RESULTS_HARM_DISA = 328; // Disarm Trap (DEX & INT)
    public static final int RESULTS_HARM_FEAR = 329; // Fear (INT & PER)*
    public static final int RESULTS_HARM_BRAV = 330; // Bravery (WIS & CHA)*
    public static final int RESULTS_HARM_SMIS = 331; // Stone Missile (WIS & STR)*
    public static final int RESULTS_HARM_RSLI = 332; // Rock Slide(WIS & STR)*
    public static final int RESULTS_HARM_FBOL = 333; // Fire bolt(INT & AGI)*
    public static final int RESULTS_HARM_FBAL = 334; // Fireball(INT & AGI)*
    public static final int RESULTS_HARM_ISPH = 335; // Ice Sphere(WIS & DEX)*
    public static final int RESULTS_HARM_WCAN = 336; // Water Cannon(WIS & DEX)*
    public static final int RESULTS_HARM_LIGH = 337; // Lightning(FOC & DEX)*
    public static final int RESULTS_HARM_CLIG = 338; // Chain Lightning(FOC & DEX)*
    public static final int RESULTS_HARM_EART = 339; // Earthquake(WIS & STR)*
    public static final int RESULTS_HARM_TORN = 340; // Tornado(INT & STR)*
    public static final int RESULTS_HARM_TSUN = 341; // Tsunami(FOC & STR)*
    public static final int RESULTS_HARM_BLIN = 342; // Blind (causes miss) (WIS & CHA)*
    public static final int RESULTS_HARM_HAST = 343; // Haste (WIS & AGI)*
    public static final int RESULTS_HARM_SHEL = 344; // Shell (FOC & END)*
    public static final int RESULTS_HARM_HEAL = 345; // Heal (INT & STR)*
    public static final int RESULTS_HARM_MTRI = 346; // Mind Trick (WIS & CHA)
    public static final int RESULTS_HARM_INVI = 347; // Invisibility (INT & END)*
    public static final int RESULTS_HARM_TELE = 348; // Teleport (FOC & END)*
    public static final int RESULTS_HARM_KNOC = 349; // unlock (FOC & PER)
    public static final int RESULTS_HARM_DTRA = 350; // Disable Trap (INT & PER)

}
