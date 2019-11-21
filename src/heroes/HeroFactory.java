package heroes;

import common.Constants;
import general.Pair;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;

import static java.lang.System.exit;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() {
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero getHero(String type, Pair<Integer, Integer> coordinates) {
        Hero hero = null;
        switch (type.charAt(0)) {
            case Constants.KNIGHT:
                hero = new Knight(coordinates);
                break;
            case Constants.PYROMANCER:
                hero = new Pyromancer(coordinates);
                break;
            case Constants.ROGUE:
                hero = new Rogue(coordinates);
                break;
            case Constants.WIZARD:
                hero = new Wizard(coordinates);
                break;
            default:
                System.out.println("Unknown hero!");
                exit(1);
        }
        return hero;
    }
}
