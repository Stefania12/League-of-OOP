package heroes;

import javafx.util.Pair;

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
        return new Hero(type, coordinates);
    }
}
