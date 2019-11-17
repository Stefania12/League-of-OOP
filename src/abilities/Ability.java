package abilities;

import heroes.Hero;

public abstract class Ability {
    protected final Hero owner;
    protected final int baseDamage;
    protected final int damagePerLevel;
    protected final int rounds;
    protected final int damagePerRound;
    protected final int roundDamagePerLevel;

    protected Ability(final Hero hero, final int baseDamage, final int damagePerLevel, final int rounds, final int damagePerRound, final int roundDamagePerLevel) {
        this.baseDamage = baseDamage;
        this.damagePerLevel = damagePerLevel;
        this.rounds = rounds;
        this.damagePerRound = damagePerRound;
        this.roundDamagePerLevel = roundDamagePerLevel;
        owner = hero;
    }
}
