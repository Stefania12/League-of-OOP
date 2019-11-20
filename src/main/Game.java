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

    Game(final ArrayList<String> lands, final ArrayList<String> heroTypes,
         final ArrayList<Pair<Integer, Integer>> heroCoordinates, final ArrayList<String> movements) {
        map = Map.getInstance();
        heroes = new ArrayList<>();
        for (int i = 0; i < heroTypes.size(); i++) {
            heroes.add(HeroFactory.getInstance().getHero(heroTypes.get(i), heroCoordinates.get(i)));
        }
        heroMovements = movements;
    }

    public ArrayList<String> getLands() {
        return map.getLands();
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
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

    private void round(int idx) {
        System.out.println("Round " + idx + ":");
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).move(heroMovements.get(idx).charAt(i));
            System.out.println(heroes.get(i).toString());
        }
    }

    public void play() {
        for (int i = 0; i < heroMovements.size(); i++) {
            this.round(i);
        }
    }
}
