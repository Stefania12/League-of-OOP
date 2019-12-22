package characters.angels;

import characters.angels.types.*;
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
            case Constants.DRACULA:
                angel = new Dracula(coordinates);
                break;
            case Constants.GOOD_BOY:
                angel = new GoodBoy(coordinates);
                break;
            case Constants.LEVEL_UP_ANGEL:
                angel = new LevelUpAngel(coordinates);
                break;
            case Constants.LIFE_GIVER:
                angel = new LifeGiver(coordinates);
                break;
            case Constants.SMALL_ANGEL:
                angel = new SmallAngel(coordinates);
                break;
            case Constants.SPAWNER:
                angel = new Spawner(coordinates);
                break;
            case Constants.DOOMER:
                angel = new TheDoomer(coordinates);
                break;
            case Constants.XP_ANGEL:
                angel = new XPAngel(coordinates);
                break;
            default:
                System.out.println("Unknown angel!");
                exit(1);
        }
        return angel;
    }
}
