package abilities;

/**
 * Holds ability parameters.
 */
public class AbilityParameters {
    private int priority;
    private int basicDamage;
    private int incapacitationRounds;
    private int overtimeDamage;
    private int overtimeDamageRounds;
    private float terrainMultiplier;
    private float raceMultiplier;

    /**
     * Initializes parameters.
     *
     * @param priority             priority
     * @param basicDamage          basic damage
     * @param incapacitationRounds incapacitation rounds
     * @param overtimeDamage       overtime damage
     * @param overtimeDamageRounds overtime damage rounds
     * @param terrainMultiplier    terrain multiplier
     * @param raceMultiplier       race multiplier
     */
    public AbilityParameters(final int priority, final int basicDamage,
                             final int incapacitationRounds, final int overtimeDamage,
                             final int overtimeDamageRounds, final float terrainMultiplier,
                             final float raceMultiplier) {
        this.priority = priority;
        this.basicDamage = basicDamage;
        this.incapacitationRounds = incapacitationRounds;
        this.overtimeDamageRounds = overtimeDamageRounds;
        this.overtimeDamage = overtimeDamage;
        this.terrainMultiplier = terrainMultiplier;
        this.raceMultiplier = raceMultiplier;
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
     * Returns basic damage.
     *
     * @return basic damage
     */
    public int getBasicDamage() {
        return basicDamage;
    }

    /**
     * Returns incapacitation rounds.
     * @return incapacitation rounds
     */
    public int getIncapacitationRounds() {
        return incapacitationRounds;
    }

    /**
     * Returns overtime damage.
     * @return overtime damage
     */
    public int getOvertimeDamage() {
        return overtimeDamage;
    }

    /**
     * Returns overtime damage rounds.
     * @return overtime damage rounds
     */
    public int getOvertimeDamageRounds() {
        return overtimeDamageRounds;
    }

    /**
     * Returns terrain multiplier.
     * @return terrain multiplier
     */
    public float getTerrainMultiplier() {
        return terrainMultiplier;
    }

    /**
     * Returns race multiplier.
     * @return race multiplier
     */
    public float getRaceMultiplier() {
        return raceMultiplier;
    }

    /**
     * Returns info about the ability parameters.
     * @return ability parameters as string
     */
    @Override
    public java.lang.String toString() {
        return "( " + priority + ", " + basicDamage + ", " + incapacitationRounds + ", "
                + overtimeDamage + ", " + overtimeDamageRounds + ", " + terrainMultiplier + ", "
                + raceMultiplier + " )";
    }
}
