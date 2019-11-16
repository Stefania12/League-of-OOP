package heroes;

import common.Constants;
import javafx.util.Pair;

public class Wizard extends Hero {
    public Wizard(Pair<Integer, Integer> coordinates) {
        super(Constants.WIZARD, coordinates);
        HP = Constants.WIZARD_INITIAL_HP;
    }
}
