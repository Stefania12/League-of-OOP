package characters.angels.types;

import characters.angels.Angel;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import util.Pair;

public class TheDoomer extends Angel {
    public TheDoomer(Pair<Integer, Integer> coordinates) {
        super("TheDoomer", "helped", coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(0, 0, 0, 0, false);
        initializeXp(0, 0, 0, 0);
    }

    @Override
    public void executeActionOn(Knight hero) {

    }

    @Override
    public void executeActionOn(Pyromancer hero) {

    }

    @Override
    public void executeActionOn(Rogue hero) {

    }

    @Override
    public void executeActionOn(Wizard hero) {

    }
}
