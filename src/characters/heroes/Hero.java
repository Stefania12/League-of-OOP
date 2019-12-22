package characters.heroes;

import abilities.Ability;
import abilities.AbilityParameters;
import common.Constants;
import util.Pair;

import java.util.LinkedList;

/**
 * Implements basic hero functionality.
 */
public abstract class Hero implements HeroInterface {
    private final String type;
    private final int fightPriority;
    private Pair<Integer, Integer> coordinates;
    private LinkedList<Ability> abilities;
    private int hp;
    private int maxHP;
    private int initialHealth;
    private int healthPerLevel;
    private int xp;
    private int level;
    private boolean alive;
    private LinkedList<AbilityParameters> attacks;
    private int damageTaken;
    private Pair<Integer, Integer> overtimeDamage;
    private int incapacitationRounds;

    /**
     * Initializes hero.
     *
     * @param priority    fight priority
     * @param type        race of hero
     * @param coordinates initial coordinates
     * @param initHp      initial hp
     * @param hpPerLevel  hp gain per level
     */
    public Hero(final HeroPriority priority, final char type,
                final Pair<Integer, Integer> coordinates, final int initHp, final int hpPerLevel) {
        this.type = String.valueOf(type);
        fightPriority = priority.ordinal();
        this.coordinates = coordinates;
        level = Constants.INITIAL_LEVEL;
        xp = Constants.INITIAL_XP;
        abilities = new LinkedList<>();
        maxHP = initHp;
        hp = maxHP;
        attacks = new LinkedList<>();
        incapacitationRounds = 0;
        damageTaken = 0;
        alive = true;
        initialHealth = initHp;
        healthPerLevel = hpPerLevel;
    }

    /**
     * Returns info needed for output printing.
     *
     * @return string with status of hero
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(type);
        builder.append(" ");
        if (!alive) {
            builder.append("dead");
        } else {
            builder.append(level).append(" ").append(xp).append(" ").append(hp).append(" ");
            builder.append(coordinates.getKey()).append(" ").append(coordinates.getValue());
        }
        return builder.toString();
    }

    /**
     * Returns the priority in a fight.
     *
     * @return fight priority
     */
    public int getFightPriority() {
        return fightPriority;
    }

    /**
     * Checks if hero is alive.
     *
     * @return true if alive, false otherwise
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Check if hero is alive and update this status.
     */
    protected void updateAliveStatus() {
        if (hp <= 0) {
            alive = false;
            hp = 0;
        } else {
            alive = true;
        }
    }

    /**
     * Returns the max hp of hero at the current level.
     *
     * @return current max hp
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * Returns the hp of hero.
     *
     * @return hp
     */
    public int getHP() {
        return hp;
    }

    protected void changeHPBy(final int amount) {
        hp = Math.max(hp + amount, 0);
    }

    /**
     * Returns the xp of hero.
     * @return xp
     */
    public int getXP() {
        return xp;
    }

    /**
     * Adds xp amount.
     *
     * @param value xp amount
     */
    public void addXP(final int value) {
        xp += value;
    }

    /**
     * Returns level of hero.
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Level up and update hp and max hp.
     */
    public void levelUp() {
        level++;
        maxHP = initialHealth + healthPerLevel * level;
        hp = maxHP;
    }

    /**
     * Returns coordinates of the hero.
     * @return pair of integer coordinates
     */
    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    /**
     * Updates coordinates based on movement type.
     *
     * @param direction direction type
     */
    public void move(final char direction) {
        if (!alive) {
            return;
        }
        Pair<Integer, Integer> offset = MovementOffsetFactory.getInstance().getOffset(direction);
        if (incapacitationRounds != 0) {
            incapacitationRounds--;
            return;
        }
        int newKey, newValue;
        newKey = coordinates.getKey() + offset.getKey();
        newValue = coordinates.getValue() + offset.getValue();
        coordinates = new Pair<>(newKey, newValue);
    }

    /**
     * Returns the number of rounds the hero is incapacitated for.
     * @return incapacitation rounds
     */
    public int getIncapacitationRounds() {
        return incapacitationRounds;
    }

    /**
     * Add incapacitation rounds.
     *
     * @param rounds incapacitation rounds
     */
    public void addIncapacitation(final int rounds) {
        if (rounds != 0) {
            incapacitationRounds = rounds;
        }
    }

    /**
     * Returns the abilities of the hero.
     * @return list of abilities.
     */
    public LinkedList<Ability> getAbilities() {
        return abilities;
    }

    /**
     * Returns the attacks the hero will use when fighting.
     * @return list of attack parameters
     */
    public LinkedList<AbilityParameters> getAttacks() {
        return attacks;
    }

    /**
     * Add overtime damage.
     *
     * @param damage overtime damage
     */
    public void addOvertimeDamage(final Pair<Integer, Integer> damage) {
        if (damage.getKey() != 0) {
            overtimeDamage = damage;
        }
    }

    /**
     * Take overtime damage if existent.
     */
    public void takeOvertimeDamage() {
        if (overtimeDamage == null) {
            return;
        }
        hp -= overtimeDamage.getKey();
        if (overtimeDamage.getValue() - 1 > 0) {
            overtimeDamage = new Pair<>(overtimeDamage.getKey(), overtimeDamage.getValue() - 1);
        } else {
            overtimeDamage = null;
        }
        this.updateAliveStatus();
    }

    /**
     * Add damage to take.
     *
     * @param amount damage amount
     */
    public void addDamageTaken(final int amount) {
        damageTaken += amount;
    }

    /**
     * Update hp and alive status based on the damage taken.
     */
    public void takeDamage() {
        hp -= damageTaken;
        damageTaken = 0;
        this.updateAliveStatus();
    }

    /**
     * Prepare attacks for fighting a hero.
     *
     * @param hero hero to fight with
     */
    public void computeAttacksOn(final Hero hero) {
        attacks.clear();
        for (Ability i : abilities) {
            attacks.add(i.getAbilityParametersOn(hero));
        }
    }
}
