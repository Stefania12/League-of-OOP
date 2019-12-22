package characters.angels.types;

import characters.angels.Angel;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;

public class GoodBoy extends Angel {
    public GoodBoy(Pair<Integer, Integer> coordinates) {
        super("GoodBoy", "helped", coordinates);
        initializeDamageModifiers(Constants.GOODBOY_KNIGHT_MODIFIER,
                Constants.GOODBOY_PYROMANCER_MODIFIER, Constants.GOODBOY_ROGUE_MODIFIER,
                Constants.GOODBOY_WIZARD_MODIFIER);
        initializeLife(Constants.GOODBOY_KNIGHT_HP, Constants.GOODBOY_PYROMANCER_HP,
                Constants.GOODBOY_ROGUE_HP, Constants.GOODBOY_WIZARD_HP, false);
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
