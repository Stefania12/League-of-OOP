package heroes;

import javafx.util.Pair;

import java.util.HashMap;

public final class MovementOffsetFactory {
    private static MovementOffsetFactory instance = null;
    private HashMap<Character, Pair<Integer, Integer>> offsets;

    private MovementOffsetFactory() {
        offsets = new HashMap<>();
        offsets.put('U', new Pair<>(-1, 0));
        offsets.put('D', new Pair<>(1, 0));
        offsets.put('L', new Pair<>(0, -1));
        offsets.put('R', new Pair<>(0, 1));
        offsets.put('_', new Pair<>(0, 0));
    }

    public static MovementOffsetFactory getInstance() {
        if (instance == null) {
            instance = new MovementOffsetFactory();
        }
        return instance;
    }

    Pair<Integer, Integer> getOffset(char c) {
        return offsets.get(c);
    }
}
