package abilities;

import characters.heroes.Hero;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import map.Map;
import map.terrain.TerrainInterface;

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
    private float knightDamageMultiplier;
    private float pyromancerDamageMultiplier;
    private float rogueDamageMultiplier;
    private float wizardDamageMultiplier;

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

    protected void initializeDamageMultipliers(final float knightMultiplier,
                                               final float pyromancerMultiplier,
                                               final float rogueMultiplier,
                                               final float wizardMultiplier) {
        knightDamageMultiplier = knightMultiplier;
        pyromancerDamageMultiplier = pyromancerMultiplier;
        rogueDamageMultiplier = rogueMultiplier;
        wizardDamageMultiplier = wizardMultiplier;
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
        TerrainInterface terrain = Map.getInstance().getTerrainAt(this.getOwner().getCoordinates());
        return terrain.getTerrainMultiplierOf(owner);
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return knightDamageMultiplier;
    }

    public void changeRaceDamageMultiplier(final Knight hero, final float amount) {
        knightDamageMultiplier += amount;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return pyromancerDamageMultiplier;
    }

    public void changeRaceDamageMultiplier(final Pyromancer hero, final float amount) {
        pyromancerDamageMultiplier += amount;
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return rogueDamageMultiplier;
    }

    public void changeRaceDamageMultiplier(final Rogue hero, final float amount) {
        rogueDamageMultiplier += amount;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return wizardDamageMultiplier;
    }

    public void changeRaceDamageMultiplier(final Wizard hero, final float amount) {
        wizardDamageMultiplier += amount;
    }

    /**
     * Calculate ability parameters when attacking a hero.
     *
     * @param hero hero to attack
     * @return ability parameters
     */
    public abstract AbilityParameters getAbilityParametersOn(Hero hero);
}
