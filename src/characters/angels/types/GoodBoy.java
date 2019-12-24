package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import common.Constants;
import util.Pair;

public class GoodBoy extends Angel {
    public GoodBoy(Pair<Integer, Integer> coordinates) {
        super("GoodBoy", EventType.HELP, coordinates);
        initializeDamageModifiers(Constants.GOODBOY_KNIGHT_MODIFIER,
                Constants.GOODBOY_PYROMANCER_MODIFIER, Constants.GOODBOY_ROGUE_MODIFIER,
                Constants.GOODBOY_WIZARD_MODIFIER);
        initializeLife(Constants.GOODBOY_KNIGHT_HP, Constants.GOODBOY_PYROMANCER_HP,
                Constants.GOODBOY_ROGUE_HP, Constants.GOODBOY_WIZARD_HP, false);
        initializeXp(0, 0, 0, 0);
    }

}
