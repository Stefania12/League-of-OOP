package common;

public final class Constants {
    public static final float FIREBLAST_ROGUE_MULTIPLIER = 0.8f;

    public static final float PERCENTAGE = 100.0f;
    public static final float FIREBLAST_ROGUE_MULTIPLIER = 0.8f;
    // XP and level up details
    public static final int INITIAL_XP = 0;
    public static final int INITIAL_LEVEL = 0;
    public static final int WIN_XP_CONSTANT = 200;
    public static final int WIN_XP_MULTIPLIER = 40;
    public static final int LEVEL_UP_CONSTANT = 250;
    public static final int LEVEL_UP_MULTIPLIER = 50;

    // Hero types
    public static final char KNIGHT = 'K';
    public static final char PYROMANCER = 'P';
    public static final char ROGUE = 'R';
    public static final char WIZARD = 'W';

    // Hero HP details
    public static final int PYROMANCER_INITIAL_HP = 500;
    public static final int PYROMANCER_HP_PER_LEVEL = 50;

    public static final int KNIGHT_INITIAL_HP = 900;
    public static final int KNIGHT_HP_PER_LEVEL = 80;

    public static final int ROGUE_INITIAL_HP = 600;
    public static final int ROGUE_HP_PER_LEVEL = 40;

    public static final int WIZARD_INITIAL_HP = 400;
    public static final int WIZARD_HP_PER_LEVEL = 30;

    // Terrain bonus damage multipliers
    public static final float KNIGHT_BONUS_DAMAGE_MULTIPLIER = 1.15f;
    public static final float PYROMANCER_BONUS_DAMAGE_MULTIPLIER = 1.25f;
    public static final float WIZARD_BONUS_DAMAGE_MULTIPLIER = 1.10f;
    public static final float ROGUE_BONUS_DAMAGE_MULTIPLIER = 1.15f;

    // Terrain types
    public static final char LAND = 'L';
    public static final char VOLCANIC = 'V';
    public static final char DESERT = 'D';
    public static final char WOODS = 'W';

    // Fireblast details
    public static final int FIREBLAST_BASE_DAMAGE = 350;
    public static final int FIREBLAST_DAMAGE_PER_LEVEL = 50;
    public static final float FIREBLAST_KNIGHT_MULTIPLIER = 1.2f;
    public static final float FIREBLAST_PYROMANCER_MULTIPLIER = 0.9f;
    public static final float FIREBLAST_WIZARD_MULTIPLIER = 1.05f;
    public static final float IGNITE_ROGUE_MULTIPLIER = 0.8f;


    // Ignite details
    public static final int IGNITE_BASE_DAMAGE = 150;
    public static final int IGNITE_DAMAGE_PER_LEVEL = 20;
    public static final int IGNITE_ROUNDS = 2;
    public static final int IGNITE_DAMAGE_PER_ROUND = 50;
    public static final int IGNITE_ROUND_DAMAGE_PER_LEVEL = 30;
    public static final float IGNITE_KNIGHT_MULTIPLIER = 1.2f;
    public static final float IGNITE_PYROMANCER_MULTIPLIER = 0.9f;
    public static final float IGNITE_WIZARD_MULTIPLIER = 1.05f;
    public static final float EXECUTE_ROGUE_MULTIPLIER = 1.15f;

    // Execute details
    public static final int EXECUTE_BASE_DAMAGE = 200;
    public static final int EXECUTE_DAMAGE_PER_LEVEL = 30;
    public static final int EXECUTE_INITIAL_HP_PERCENTAGE = 20;
    public static final int EXECUTE_HP_PERCENTAGE_PER_LEVEL = 1;
    public static final int EXECUTE_MAX_HP_PERCENTAGE = 40;
    public static final float EXECUTE_KNIGHT_MULTIPLIER = 1.0f;
    public static final float EXECUTE_PYROMANCER_MULTIPLIER = 1.1f;
    public static final float EXECUTE_WIZARD_MULTIPLIER = 0.8f;
    public static final float SLAM_ROGUE_MULTIPLIER = 0.8f;

    // Slam details
    public static final int SLAM_BASE_DAMAGE = 100;
    public static final int SLAM_DAMAGE_PER_LEVEL = 40;
    public static final int SLAM_INCAPACITATION_ROUNDS = 1;
    public static final float SLAM_KNIGHT_MULTIPLIER = 1.2f;
    public static final float SLAM_PYROMANCER_MULTIPLIER = 0.9f;
    public static final float SLAM_WIZARD_MULTIPLIER = 1.05f;
    public static final float DRAIN_ROGUE_MULTIPLIER = 0.8f;

    // Drain details
    public static final int DRAIN_BASE_DAMAGE_PERCENTAGE = 20;
    public static final int DRAIN_DAMAGE_PERCENTAGE_PER_LEVEL = 5;
    public static final float DRAIN_BASE_HP_CONSTANT = 0.3f;
    public static final float DRAIN_KNIGHT_MULTIPLIER = 1.2f;
    public static final float DRAIN_PYROMANCER_MULTIPLIER = 0.9f;
    public static final float DRAIN_WIZARD_MULTIPLIER = 1.05f;
    public static final float DEFLECT_ROGUE_MULTIPLIER = 1.2f;

    // Deflect details
    public static final int DEFLECT_BASE_DAMAGE_PERCENTAGE = 35;
    public static final int DEFLECT_DAMAGE_PERCENTAGE_PER_LEVEL = 2;
    public static final int DEFLECT_DAMAGE_MAX_PERCENTAGE = 70;
    public static final float DEFLECT_KNIGHT_MULTIPLIER = 1.4f;
    public static final float DEFLECT_PYROMANCER_MULTIPLIER = 1.3f;
    public static final float DEFLECT_WIZARD_MULTIPLIER = 0f;
    public static final float BACKSTAB_ROGUE_MULTIPLIER = 1.2f;

    // Backstab details
    public static final int BACKSTAB_BASE_DAMAGE = 200;
    public static final int BACKSTAB_DAMAGE_PER_LEVEL = 20;
    public static final int BACKSTAB_CRITICAL_HITS = 3;
    public static final float BACKSTAB_CRITICAL_PERCENTAGE = 1.5f;
    public static final float BACKSTAB_KNIGHT_MULTIPLIER = 0.9f;
    public static final float BACKSTAB_PYROMANCER_MULTIPLIER = 1.25f;
    public static final float BACKSTAB_WIZARD_MULTIPLIER = 1.25f;
    public static final float PARALYSIS_ROGUE_MULTIPLIER = 0.9f;

    // Paralysis details
    public static final int PARALYSIS_DAMAGE_PER_ROUND = 40;
    public static final int PARALYSIS_ROUND_DAMAGE_PER_LEVEL = 10;
    public static final int PARALYSIS_ROUNDS_WOODS = 6;
    public static final int PARALYSIS_ROUNDS_NOT_WOODS = 3;
    public static final float PARALYSIS_KNIGHT_MULTIPLIER = 0.8f;
    public static final float PARALYSIS_PYROMANCER_MULTIPLIER = 1.2f;
    public static final float PARALYSIS_WIZARD_MULTIPLIER = 1.25f;
    // DamageAngel details
    public static final float DMG_ANGEL_KNIGHT_MODIFIER = 0.15f;
    public static final float DMG_ANGEL_PYROMANCER_MODIFIER = 0.20f;
    public static final float DMG_ANGEL_ROGUE_MODIFIER = 0.30f;
    public static final float DMG_ANGEL_WIZARD_MODIFIER = 0.40f;
    // DarkAngel details
    public static final int DARK_ANGEL_KNIGHT_MODIFIER = -40;
    public static final int DARK_ANGEL_PYROMANCER_MODIFIER = -30;
    public static final int DARK_ANGEL_ROGUE_MODIFIER = -10;
    public static final int DARK_ANGEL_WIZARD_MODIFIER = -20;
    // Dracula details
    public static final float DRACULA_KNIGHT_MODIFIER = -0.20f;
    public static final int DRACULA_KNIGHT_HP = -60;
    public static final float DRACULA_PYROMANCER_MODIFIER = -0.30f;
    public static final int DRACULA_PYROMANCER_HP = -40;
    public static final float DRACULA_ROGUE_MODIFIER = -0.10f;
    public static final int DRACULA_ROGUE_HP = -35;
    public static final float DRACULA_WIZARD_MODIFIER = -0.40f;
    public static final int DRACULA_WIZARD_HP = -20;
    // GoodBoy details
    public static final float GOODBOY_KNIGHT_MODIFIER = 0.40f;
    public static final int GOODBOY_KNIGHT_HP = 20;
    public static final float GOODBOY_PYROMANCER_MODIFIER = 0.50f;
    public static final int GOODBOY_PYROMANCER_HP = 30;
    public static final float GOODBOY_ROGUE_MODIFIER = 0.40f;
    public static final int GOODBOY_ROGUE_HP = 40;
    public static final float GOODBOY_WIZARD_MODIFIER = 0.30f;
    public static final int GOODBOY_WIZARD_HP = 50;
    // LevelUpAngel details
    public static final float LVL_UP_ANGEL_KNIGHT_MODIFIER = 0.10f;
    public static final float LVL_UP_ANGEL_PYROMANCER_MODIFIER = 0.20f;
    public static final float LVL_UP_ANGEL_ROGUE_MODIFIER = 0.15f;
    public static final float LVL_UP_ANGEL_WIZARD_MODIFIER = 0.25f;
    // LifeGiver details
    public static final int LIFEGIVER_KNIGHT_MODIFIER = 100;
    public static final int LIFEGIVER_PYROMANCER_MODIFIER = 80;
    public static final int LIFEGIVER_ROGUE_MODIFIER = 90;
    public static final int LIFEGIVER_WIZARD_MODIFIER = 120;
    // SmallAngel details
    public static final float SMALL_ANGEL_KNIGHT_MODIFIER = 0.10f;
    public static final int SMALL_ANGEL_KNIGHT_HP = 10;
    public static final float SMALL_ANGEL_PYROMANCER_MODIFIER = 0.15f;
    public static final int SMALL_ANGEL_PYROMANCER_HP = 15;
    public static final float SMALL_ANGEL_ROGUE_MODIFIER = 0.05f;
    public static final int SMALL_ANGEL_ROGUE_HP = 20;
    public static final float SMALL_ANGEL_WIZARD_MODIFIER = 0.10f;
    public static final int SMALL_ANGEL_WIZARD_HP = 25;
    // Spawner details
    public static final int SPAWNER_KNIGHT_HP = 200;
    public static final int SPAWNER_PYROMANCER_HP = 150;
    public static final int SPAWNER_ROGUE_HP = 180;
    public static final int SPAWNER_WIZARD_HP = 120;
    // XPAngel details
    public static final int XP_ANGEL_KNIGHT_XP = 45;
    public static final int XP_ANGEL_PYROMANCER_XP = 50;
    public static final int XP_ANGEL_ROGUE_XP = 40;
    public static final int XP_ANGEL_WIZARD_XP = 60;
    private Constants() {
    }
}
