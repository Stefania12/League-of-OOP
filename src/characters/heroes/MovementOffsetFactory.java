package characters.heroes;

import util.Pair;

import java.util.HashMap;

/**
 * Provides coordinate offsets depending on movement type.
 */
final class MovementOffsetFactory {
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

    static MovementOffsetFactory getInstance() {
        if (instance == null) {
            instance = new MovementOffsetFactory();
        }
        return instance;
    }

    /**
     * Returns pair of offset for coordinates.
     *
     * @param direction movement type
     * @return coordinate offset
     */
    Pair<Integer, Integer> getOffset(final char direction) {
        return offsets.get(direction);
    }
}
