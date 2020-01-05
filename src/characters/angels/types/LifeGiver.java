package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import common.Constants;
import util.Pair;

public final class LifeGiver extends Angel {
    public LifeGiver(final Pair<Integer, Integer> coordinates) {
        super("LifeGiver", EventType.HELP, coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(Constants.LIFEGIVER_KNIGHT_HP,
                Constants.LIFEGIVER_PYROMANCER_HP, Constants.LIFEGIVER_ROGUE_HP,
                Constants.LIFEGIVER_WIZARD_HP, false);
        initializeXp(0, 0, 0, 0);
    }
}
