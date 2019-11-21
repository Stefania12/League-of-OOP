package main;

import fileio.implementations.FileReader;
import general.Pair;
import map.Map;

import java.util.ArrayList;

final class GameInputLoader {
    private ArrayList<String> lands;
    private ArrayList<String> heroTypes;
    private ArrayList<Pair<Integer, Integer>> heroCoordinates;
    private ArrayList<String> movements;

    GameInputLoader(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            int lines = fileReader.nextInt();
            int coloumns = fileReader.nextInt();
            lands = new ArrayList<>();

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


    Game makeGame() {
        return new Game(lands, heroTypes, heroCoordinates, movements);
    }
}
