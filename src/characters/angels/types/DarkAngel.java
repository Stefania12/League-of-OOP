package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import common.Constants;
import util.Pair;

public final class DarkAngel extends Angel {
    public DarkAngel(final Pair<Integer, Integer> coordinates) {
        super("DarkAngel", EventType.HIT, coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(Constants.DARK_ANGEL_KNIGHT_HP,
                Constants.DARK_ANGEL_PYROMANCER_HP, Constants.DARK_ANGEL_ROGUE_HP,
                Constants.DARK_ANGEL_WIZARD_HP, false);
        initializeXp(0, 0, 0, 0);
    }
}
