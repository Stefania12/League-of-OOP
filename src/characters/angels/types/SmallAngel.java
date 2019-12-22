package characters.angels.types;

import characters.angels.Angel;
import common.Constants;
import util.Pair;

public class SmallAngel extends Angel {
    public SmallAngel(Pair<Integer, Integer> coordinates) {
        super("SmallAngel", "helped", coordinates);
        initializeDamageModifiers(Constants.SMALL_ANGEL_KNIGHT_MODIFIER,
                Constants.SMALL_ANGEL_PYROMANCER_MODIFIER, Constants.SMALL_ANGEL_ROGUE_MODIFIER,
                Constants.SMALL_ANGEL_WIZARD_MODIFIER);
        initializeLife(Constants.SMALL_ANGEL_KNIGHT_HP, Constants.SMALL_ANGEL_PYROMANCER_HP,
                Constants.SMALL_ANGEL_ROGUE_HP, Constants.SMALL_ANGEL_WIZARD_HP, false);
        initializeXp(0, 0, 0, 0);

    }

}
