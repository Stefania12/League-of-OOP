package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import common.Constants;
import util.Pair;

public final class Dracula extends Angel {
    public Dracula(final Pair<Integer, Integer> coordinates) {
        super("Dracula", EventType.HIT, coordinates);
        initializeDamageModifiers(Constants.DRACULA_KNIGHT_MODIFIER,
                Constants.DRACULA_PYROMANCER_MODIFIER, Constants.DRACULA_ROGUE_MODIFIER,
                Constants.DRACULA_WIZARD_MODIFIER);
        initializeLife(Constants.DRACULA_KNIGHT_HP, Constants.DRACULA_PYROMANCER_HP,
                Constants.DRACULA_ROGUE_HP, Constants.DRACULA_WIZARD_HP, false);
        initializeXp(0, 0, 0, 0);
    }
}
