package abilities;

import heroes.Hero;

public abstract class Ability implements AbilityInterface {
    private final Hero owner;
    private final int baseDamage;
    private final int damagePerLevel;
    private final int priority;
    private final int damagePerRound;
    private final int roundDamagePerLevel;
    private final int rounds;
    private final int incapacitationRounds;

    protected Ability(final int priority, final Hero hero, final int baseDamage, final int incapacitationRounds, final int damagePerLevel, final int rounds, final int damagePerRound, final int roundDamagePerLevel) {
        this.priority = priority;
        this.baseDamage = baseDamage;
        this.incapacitationRounds = incapacitationRounds;
        this.damagePerLevel = damagePerLevel;
        this.rounds = rounds;
        this.damagePerRound = damagePerRound;
        this.roundDamagePerLevel = roundDamagePerLevel;
        owner = hero;
    }

    public Hero getOwner() {
        return owner;
    }

    public int getPriority() {
        return priority;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getIncapacitationRounds() {
        return incapacitationRounds;
    }

    public int getDamagePerLevel() {
        return damagePerLevel;
    }

    public int getRounds() {
        return rounds;
    }

    public int getDamagePerRound() {
        return damagePerRound;
    }

    public int getRoundDamagePerLevel() {
        return roundDamagePerLevel;
    }

    public float getTerrainMultiplier() {
        return owner.getTerrainBonusDamageMultiplier();
    }

    public int getBasicDamageOn(Hero hero) {
        return baseDamage + damagePerLevel * owner.getLevel();
    }

    public int getRoundDamage() {
        return damagePerRound + roundDamagePerLevel * owner.getLevel();
    }
}
