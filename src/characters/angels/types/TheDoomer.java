package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import characters.angels.AngelEffect;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import util.Pair;

public final class TheDoomer extends Angel {
    public TheDoomer(final Pair<Integer, Integer> coordinates) {
        super("TheDoomer", EventType.HIT, coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(0, 0, 0, 0, false);
        initializeXp(0, 0, 0, 0);
    }

    @Override
    public AngelEffect getEffectOn(final Knight hero) {
        if (canHaveEffectOn(hero)) {
            notifyObservers(this, getAction(), hero);
            return new AngelEffect(0, -hero.getHP(), false, 0);
        }
        return new AngelEffect(0, 0, false, 0);
    }

    @Override
    public AngelEffect getEffectOn(final Pyromancer hero) {
        if (canHaveEffectOn(hero)) {
            notifyObservers(this, getAction(), hero);
            return new AngelEffect(0, -hero.getHP(), false, 0);
        }
        return new AngelEffect(0, 0, false, 0);
    }

    @Override
    public AngelEffect getEffectOn(final Rogue hero) {
        if (canHaveEffectOn(hero)) {
            notifyObservers(this, getAction(), hero);
            return new AngelEffect(0, -hero.getHP(), false, 0);
        }
        return new AngelEffect(0, 0, false, 0);
    }

    @Override
    public AngelEffect getEffectOn(final Wizard hero) {
        if (canHaveEffectOn(hero)) {
            notifyObservers(this, getAction(), hero);
            return new AngelEffect(0, -hero.getHP(), false, 0);
        }
        return new AngelEffect(0, 0, false, 0);
    }
}
