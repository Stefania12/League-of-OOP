package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import common.Constants;
import util.Pair;

public final class XPAngel extends Angel {
    public XPAngel(final Pair<Integer, Integer> coordinates) {
        super("XPAngel", EventType.HELP, coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(0, 0, 0, 0, false);
        initializeXp(Constants.XP_ANGEL_KNIGHT_XP, Constants.XP_ANGEL_PYROMANCER_XP,
                Constants.XP_ANGEL_ROGUE_XP, Constants.XP_ANGEL_WIZARD_XP);
    }
}
