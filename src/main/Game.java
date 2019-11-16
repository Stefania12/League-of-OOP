package main;

import heroes.Hero;
import heroes.HeroFactory;
import javafx.util.Pair;
import map.Map;

import java.util.ArrayList;

public class Game {
    private final Map map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> heroMovements;

    public Game(final ArrayList<String> lands, final ArrayList<String> heroTypes,
                final ArrayList<Pair<Integer, Integer>> heroCoordinates, final ArrayList<String> movements) {
        map = new Map(lands);
        heroes = new ArrayList<>();
        for (int i = 0; i < heroTypes.size(); i++) {
            heroes.add(HeroFactory.getInstance().getHero(heroTypes.get(i), heroCoordinates.get(i)));
        }
        heroMovements = movements;
    }

    public ArrayList<String> getLands() {
        return map.getLands();
    }

    @Override
    public String toString() {
        String str = map.toString();
        for (Hero h : heroes) {
            str += " " + h.toString();
        }
        for (String s : heroMovements) {
            str += " " + s;
        }
        return str;
    }
}
