package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import common.Constants;
import util.Pair;

public class Spawner extends Angel {
    public Spawner(Pair<Integer, Integer> coordinates) {
        super("Spawner", EventType.HELP, coordinates);
        initializeDamageModifiers(0, 0, 0, 0);
        initializeLife(Constants.SPAWNER_KNIGHT_HP,
                Constants.SPAWNER_PYROMANCER_HP, Constants.SPAWNER_ROGUE_HP,
                Constants.SPAWNER_WIZARD_HP, true);
        initializeXp(0, 0, 0, 0);
    }
}
