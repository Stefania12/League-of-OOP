package abilities;

import heroes.Hero;
import map.Map;
import map.terrain.Terrain;

/**
 * Implements basic ability functionality.
 */
public abstract class Ability implements AbilityInterface {
    private Hero owner;
    private final int priority;
    private final int baseDamage;
    private final int damagePerLevel;
    private final int overtimeDamage;
    private final int overtimeDamagePerLevel;
    private final int overtimeDamageRounds;
    private final int incapacitationRounds;

    /**
     * Initialize ability.
     *
     * @param priority               priority
     * @param baseDamage             base damage
     * @param incapacitationRounds   number of rounds with incapacitation
     * @param damagePerLevel         damage per level
     * @param rounds                 number of rounds of overtime damage
     * @param overtimeDamage         overtime damage per round
     * @param overtimeDamagePerLevel overtime damage gain per level
     */
    protected Ability(final int priority, final int baseDamage, final int incapacitationRounds,
                      final int damagePerLevel, final int rounds, final int overtimeDamage,
                      final int overtimeDamagePerLevel) {
        this.priority = priority;
        this.baseDamage = baseDamage;
        this.damagePerLevel = damagePerLevel;
        this.incapacitationRounds = incapacitationRounds;
        this.overtimeDamageRounds = rounds;
        this.overtimeDamage = overtimeDamage;
        this.overtimeDamagePerLevel = overtimeDamagePerLevel;
    }

    /**
     * Returns owner.
     *
     * @return owner hero
     */
    protected Hero getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param hero owner
     */
    protected void setOwner(final Hero hero) {
        owner = hero;
    }

    /**
     * Returns priority.
     *
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns value of the basic damage on a hero if it depends on it.
     *
     * @param hero hero to attack
     * @return basic damage on hero
     */
    protected int getBasicDamageOn(final Hero hero) {
        return baseDamage + damagePerLevel * owner.getLevel();
    }

    /**
     * Returns number of rounds of incapacitation.
     *
     * @return incapacitation rounds
     */
    protected int getIncapacitationRounds() {
        return incapacitationRounds;
    }

    /**
     * Returns number of rounds for overtime damage.
     *
     * @return overtime damage rounds
     */
    protected int getOvertimeDamageRounds() {
        return overtimeDamageRounds;
    }

    /**
     * Returns total overtime damage per round.
     *
     * @return total overtime damage per round
     */
    protected int getTotalOvertimeDamage() {
        return overtimeDamage + overtimeDamagePerLevel * owner.getLevel();
    }

    /**
     * Returns terrain multiplier of owner.
     * @return terrain multiplier
     */
    public float getTerrainMultiplier() {
        Terrain terrain = Map.getInstance().getTerrainAt(this.getOwner().getCoordinates());
        return terrain.getTerrainMultiplierOf(owner);
    }
}
