package characters.angels.types;

import characters.angels.Angel;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(Pair<Integer, Integer> coordinates) {
        super("LevelUpAngel", "helped", coordinates);
        super.initializeDamageModifiers(Constants.LVL_UP_ANGEL_KNIGHT_MODIFIER,
                Constants.LVL_UP_ANGEL_PYROMANCER_MODIFIER, Constants.LVL_UP_ANGEL_ROGUE_MODIFIER,
                Constants.LVL_UP_ANGEL_WIZARD_MODIFIER);
        super.initializeLife(0, 0, 0, 0, false);
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
