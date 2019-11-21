package abilities;

import heroes.Hero;

public abstract class Ability implements AbilityInterface {
    private final Hero owner;
    private final int priority;
    private final int baseDamage;
    private final int damagePerLevel;
    private final int overtimeDamage;
    private final int overtimeDamagePerLevel;
    private final int overtimeDamageRounds;
    private final int incapacitationRounds;

    protected Ability(final int priority, final Hero hero, final int baseDamage, final int incapacitationRounds, final int damagePerLevel, final int rounds, final int overtimeDamage, final int overtimeDamagePerLevel) {
        this.priority = priority;
        this.baseDamage = baseDamage;
        this.damagePerLevel = damagePerLevel;
        this.incapacitationRounds = incapacitationRounds;
        this.overtimeDamageRounds = rounds;
        this.overtimeDamage = overtimeDamage;
        this.overtimeDamagePerLevel = overtimeDamagePerLevel;
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

    public int getOvertimeDamageRounds() {
        return overtimeDamageRounds;
    }

    public int getOvertimeDamage() {
        return overtimeDamage;
    }

    public int getOvertimeDamagePerLevel() {
        return overtimeDamagePerLevel;
    }

    public float getTerrainMultiplier() {
        return owner.getTerrainBonusDamageMultiplier();
    }

    public int getBasicDamageOn(Hero hero) {
        return baseDamage + damagePerLevel * owner.getLevel();
    }

    public int getRoundDamage() {
        return overtimeDamage + overtimeDamagePerLevel * owner.getLevel();
    }
}
