package main;

import fileio.implementations.FileWriter;
import general.Pair;
import heroes.Hero;
import heroes.HeroFactory;
import map.Map;

import java.util.ArrayList;

class Game {
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
        //System.out.println("Round " + idx + ":");
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).move(heroMovements.get(idx).charAt(i));
            heroes.get(i).takeOvertimeDamage();
            // System.out.println(heroes.get(i).toString());
        }
        int enemyId;
        for (int i = 0; i < heroes.size() - 1; i++) {
            enemyId = Fight.getEnemyToFightWith(i, heroes);
            if (enemyId != -1) {
                if (heroes.get(i).getFightPriority() < heroes.get(enemyId).getFightPriority()) {
                    Fight.fight(heroes.get(i), heroes.get(enemyId));
                } else {
                    Fight.fight(heroes.get(enemyId), heroes.get(i));
                }
            }
        }
    }

    void play() {
        for (int i = 0; i < heroMovements.size(); i++) {
            this.round(i);
        }
    }

    void printOutput(String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            for (Hero i : heroes) {
                fileWriter.writeWord(i.toString());
                fileWriter.writeNewLine();
            }
            fileWriter.writeNewLine();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
