package heroes;

import common.Constants;
import javafx.util.Pair;

public class Rogue extends Hero {
    public Rogue(Pair<Integer, Integer> coordinates) {
        super(Constants.ROGUE, coordinates);
        HP = Constants.ROGUE_INITIAL_HP;
    }
}
