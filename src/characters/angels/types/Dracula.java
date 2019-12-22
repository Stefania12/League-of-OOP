package characters.angels.types;

import characters.angels.Angel;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;

public class Dracula extends Angel {
    public Dracula(Pair<Integer, Integer> coordinates) {
        super("Dracula", "helped", coordinates);
        initializeDamageModifiers(Constants.DRACULA_KNIGHT_MODIFIER,
                Constants.DRACULA_PYROMANCER_MODIFIER, Constants.DRACULA_ROGUE_MODIFIER,
                Constants.DRACULA_WIZARD_MODIFIER);
        initializeLife(Constants.DRACULA_KNIGHT_HP, Constants.DRACULA_PYROMANCER_HP,
                Constants.DRACULA_ROGUE_HP, Constants.DRACULA_WIZARD_HP, false);
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
