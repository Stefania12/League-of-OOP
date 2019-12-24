package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import characters.angels.AngelEffect;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import util.Pair;

public class TheDoomer extends Angel {
    public TheDoomer(Pair<Integer, Integer> coordinates) {
        super("TheDoomer", EventType.HIT, coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(0, 0, 0, 0, false);
        initializeXp(0, 0, 0, 0);
    }

    @Override
    public AngelEffect getEffectOn(Knight hero) {
        return new AngelEffect(0, -hero.getHP(), false, 0);
    }

    @Override
    public AngelEffect getEffectOn(Pyromancer hero) {
        return new AngelEffect(0, -hero.getHP(), false, 0);
    }

    @Override
    public AngelEffect getEffectOn(Rogue hero) {
        return new AngelEffect(0, -hero.getHP(), false, 0);
    }

    @Override
    public AngelEffect getEffectOn(Wizard hero) {
        return new AngelEffect(0, -hero.getHP(), false, 0);
    }
}
