package characters.heroes;

import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;

import static java.lang.System.exit;

/**
 * Provides characters.heroes based on their type.
 */
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

    /**
     * Returns a hero of a certain type.
     *
     * @param type        hero type
     * @param coordinates hero initial coordinates
     * @return hero or null if type is unknown
     */
    public Hero getHero(final String type, final Pair<Integer, Integer> coordinates) {
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
