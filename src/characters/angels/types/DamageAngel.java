package characters.angels.types;

import characters.angels.Angel;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;

public class DamageAngel extends Angel {
    public DamageAngel(Pair<Integer, Integer> coordinates) {
        super("DamageAngel", "helped", coordinates);
        initializeDamageModifiers(Constants.DMG_ANGEL_KNIGHT_MODIFIER,
                Constants.DMG_ANGEL_PYROMANCER_MODIFIER, Constants.DMG_ANGEL_ROGUE_MODIFIER,
                Constants.DMG_ANGEL_WIZARD_MODIFIER);
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
