package characters.angels.types;

import characters.angels.Angel;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;

public class LifeGiver extends Angel {
    public LifeGiver(Pair<Integer, Integer> coordinates) {
        super("LifeGiver", "helped", coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(Constants.LIFEGIVER_KNIGHT_HP,
                Constants.LIFEGIVER_PYROMANCER_HP, Constants.LIFEGIVER_ROGUE_HP,
                Constants.LIFEGIVER_WIZARD_HP, false);
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
