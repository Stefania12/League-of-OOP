package main;

import characters.EventType;
import characters.GreatMage;
import characters.angels.Angel;
import characters.angels.AngelFactory;
import characters.heroes.Hero;
import characters.heroes.HeroFactory;
import fileio.implementations.FileWriter;
import util.Pair;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Implements game logic.
 */
class Game {
    private int rounds;
    private ArrayList<Hero> heroes;
    private ArrayList<String> heroMovements;
    private ArrayList<ArrayList<Pair<String, Pair<Integer, Integer>>>> angelsEachRound; // (angelType, coordinates) pairs
    private ArrayList<ArrayList<String>> eventsEachRound;

    /**
     * Initialize game.
     *
     * @param heroTypes       hero types
     * @param heroCoordinates hero initial coordinates
     * @param movements       hero movement directions
     */
    Game(final ArrayList<String> heroTypes,
         final ArrayList<Pair<Integer, Integer>> heroCoordinates,
         final ArrayList<String> movements, final ArrayList<ArrayList<String>> angelsPerRound) {
        heroes = new ArrayList<>();
        for (int i = 0; i < heroTypes.size(); i++) {
            heroes.add(HeroFactory.getInstance().getHero(heroTypes.get(i), heroCoordinates.get(i)));
            heroes.get(i).addObserver(GreatMage.getInstance());
            heroes.get(i).setId(i);
        }
        heroMovements = movements;
        rounds = movements.size();

        angelsEachRound = new ArrayList<>();
        for (int i = 0; i < angelsPerRound.size(); i++) {
            angelsEachRound.add(new ArrayList<>());
            for (String s : angelsPerRound.get(i)) {
                String[] words = s.split(",");
                angelsEachRound.get(i).add(new Pair<>(words[0], new Pair<>(Integer.parseInt(words[1]), Integer.parseInt(words[2]))));
            }
        }

        eventsEachRound = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            eventsEachRound.add(new ArrayList<>());
        }
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
            if (heroes.get(i).isAlive()) {
                heroes.get(i).applyStrategy();
                heroes.get(i).move(heroMovements.get(idx).charAt(i));
                heroes.get(i).takeOvertimeDamage();
            }
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
        for (Pair<String, Pair<Integer, Integer>> i : angelsEachRound.get(idx)) {
            Angel angel = AngelFactory.getInstance().createAngel(i.getKey(), i.getValue());
            angel.addObserver(GreatMage.getInstance());
            angel.notifyObservers(angel, EventType.ANGEL_SPAWN, null);

            for (Hero h : heroes) {
                if (i.getValue().equals(h.getCoordinates())) {
                    h.receiveEffectOfAngel(angel);
                }
            }
        }
    }

    /**
     * Plays game.
     */
    void play() {
        for (int i = 0; i < rounds; i++) {
            this.round(i);
            GreatMage mage = GreatMage.getInstance();
            for (String s : mage.getRoundEvents()) {
                eventsEachRound.get(i).add(s);
            }
            mage.resetRoundEvents();
        }
    }


    private void printEvents(FileWriter fileWriter) throws IOException {
        for (int i = 0; i < rounds; i++) {
            fileWriter.writeWord("~~ Round " + (i + 1) + " ~~\n");
            for (String s : eventsEachRound.get(i)) {
                fileWriter.writeWord(s);
                fileWriter.writeWord("\n");
            }
            fileWriter.writeWord("\n");
        }
    }

    /**
     * Prints output.
     * @param outputFile    output path
     */
    void printOutput(final String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            printEvents(fileWriter);
            fileWriter.writeWord("~~ Results ~~\n");
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
