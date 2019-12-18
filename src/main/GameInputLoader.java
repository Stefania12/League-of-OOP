package main;

import fileio.implementations.FileReader;
import map.Map;
import util.Pair;

import java.util.ArrayList;

/**
 * Reads input from file and creates a game.
 */
final class GameInputLoader {
    private ArrayList<String> heroTypes;
    private ArrayList<Pair<Integer, Integer>> heroCoordinates;
    private ArrayList<String> movements;

    /**
     * Retrieve information from input file.
     *
     * @param fileName file path
     */
    GameInputLoader(final String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            int lines = fileReader.nextInt();
            int coloumns = fileReader.nextInt();

            ArrayList<String> lands = new ArrayList<>();
            for (int i = 0; i < lines; i++) {
                lands.add(fileReader.nextWord());
            }

            Map.getInstance().initLands(lands);

            int numHeroes = fileReader.nextInt();
            heroTypes = new ArrayList<>();
            heroCoordinates = new ArrayList<>();

            for (int i = 0; i < numHeroes; i++) {
                heroTypes.add(fileReader.nextWord());
                heroCoordinates.add(new Pair<>(fileReader.nextInt(), fileReader.nextInt()));
            }

            int rounds = fileReader.nextInt();
            movements = new ArrayList<>();
            for (int i = 0; i < rounds; i++) {
                movements.add(fileReader.nextWord());
            }

            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a game with its attributes.
     *
     * @return new game
     */
    Game makeGame() {
        return new Game(heroTypes, heroCoordinates, movements);
    }
}
