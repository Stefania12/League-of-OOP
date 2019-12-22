package characters.angels.types;

import characters.angels.Angel;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;

public class SmallAngel extends Angel {
    public SmallAngel(Pair<Integer, Integer> coordinates) {
        super("SmallAngel", "helped", coordinates);
        initializeDamageModifiers(Constants.SMALL_ANGEL_KNIGHT_MODIFIER,
                Constants.SMALL_ANGEL_PYROMANCER_MODIFIER, Constants.SMALL_ANGEL_ROGUE_MODIFIER,
                Constants.SMALL_ANGEL_WIZARD_MODIFIER);
        initializeLife(Constants.SMALL_ANGEL_KNIGHT_HP, Constants.SMALL_ANGEL_PYROMANCER_HP,
                Constants.SMALL_ANGEL_KNIGHT_HP, Constants.SMALL_ANGEL_WIZARD_HP, false);
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
