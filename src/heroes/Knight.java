package heroes;

import common.Constants;
import javafx.util.Pair;

public class Knight extends Hero {
    public Knight(Pair<Integer, Integer> coordinates) {
        super(Constants.KNIGHT, coordinates);
        HP = Constants.KNIGHT_INITIAL_HP;
    }
}
