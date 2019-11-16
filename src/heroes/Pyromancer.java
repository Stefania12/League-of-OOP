package heroes;

import common.Constants;
import javafx.util.Pair;

public class Pyromancer extends Hero {
    public Pyromancer(Pair<Integer, Integer> coordinates) {
        super(Constants.PYROMANCER, coordinates);
        HP = Constants.PYROMANCER_INITIAL_HP;
    }
}
