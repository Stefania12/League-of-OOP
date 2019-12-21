package main;

import characters.heroes.Hero;
import characters.heroes.HeroFactory;
import fileio.implementations.FileWriter;
import util.Pair;

import java.util.ArrayList;

/**
 * Implements game logic.
 */
class Game {
    private ArrayList<Hero> heroes;
    private ArrayList<String> heroMovements;

    /**
     * Initialize game.
     *
     * @param heroTypes       hero types
     * @param heroCoordinates hero initial coordinates
     * @param movements       hero movement directions
     */
    Game(final ArrayList<String> heroTypes,
         final ArrayList<Pair<Integer, Integer>> heroCoordinates,
         final ArrayList<String> movements) {
        heroes = new ArrayList<>();
        for (int i = 0; i < heroTypes.size(); i++) {
            heroes.add(HeroFactory.getInstance().getHero(heroTypes.get(i), heroCoordinates.get(i)));
        }
        heroMovements = movements;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    /**
     * Implements a game round.
     *
     * @param idx index of round
     */
    private void round(final int idx) {
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).move(heroMovements.get(idx).charAt(i));
            heroes.get(i).takeOvertimeDamage();
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

    /**
     * Plays game.
     */
    void play() {
        for (int i = 0; i < heroMovements.size(); i++) {
            this.round(i);
        }
    }

    /**
     * Prints output.
     * @param outputFile    output path
     */
    void printOutput(final String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            for (Hero i : heroes) {
                fileWriter.writeWord(i.toString());
                fileWriter.writeWord("\n");
            }
            fileWriter.writeWord("\n");
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
