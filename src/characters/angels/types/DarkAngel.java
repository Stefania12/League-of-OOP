package characters.angels.types;

import characters.angels.Angel;
import common.Constants;
import util.Pair;

public class DarkAngel extends Angel {
    public DarkAngel(Pair<Integer, Integer> coordinates) {
        super("DarkAngel", "helped", coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(Constants.DARK_ANGEL_KNIGHT_HP,
                Constants.DARK_ANGEL_PYROMANCER_HP, Constants.DARK_ANGEL_ROGUE_HP,
                Constants.DARK_ANGEL_WIZARD_HP, false);
        initializeXp(0, 0, 0, 0);
    }

}
