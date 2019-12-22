package characters.angels;

import characters.angels.types.DamageAngel;
import characters.angels.types.DarkAngel;
import common.Constants;
import util.Pair;

import static java.lang.System.exit;

public final class AngelFactory {
    private static AngelFactory instance;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public Angel createAngel(final String type, final Pair<Integer, Integer> coordinates) {
        Angel angel = null;
        switch (type) {
            case Constants.DAMAGE_ANGEL:
                angel = new DamageAngel(coordinates);
                break;
            case Constants.DARK_ANGEL:
                angel = new DarkAngel(coordinates);
                break;
            default:
                System.out.println("Unknown angel!");
                exit(1);
        }
        return angel;
    }
}
