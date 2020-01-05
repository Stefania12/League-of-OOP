package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import common.Constants;
import util.Pair;

public final class DamageAngel extends Angel {
    public DamageAngel(final Pair<Integer, Integer> coordinates) {
        super("DamageAngel", EventType.HELP, coordinates);
        initializeDamageModifiers(Constants.DMG_ANGEL_KNIGHT_MODIFIER,
                Constants.DMG_ANGEL_PYROMANCER_MODIFIER, Constants.DMG_ANGEL_ROGUE_MODIFIER,
                Constants.DMG_ANGEL_WIZARD_MODIFIER);
        initializeLife(0, 0, 0, 0, false);
        initializeXp(0, 0, 0, 0);
    }
}
