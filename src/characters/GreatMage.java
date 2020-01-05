package characters;

import characters.angels.Angel;
import characters.heroes.Hero;
import util.Pair;

import java.util.ArrayList;

import static java.lang.System.exit;

public final class GreatMage implements Observer {
    private static GreatMage instance;
    private ArrayList<String> roundEvents;

    private GreatMage() {
        roundEvents = new ArrayList<>();
    }

    public static GreatMage getInstance() {
        if (instance == null) {
            instance = new GreatMage();
        }
        return instance;
    }

    public ArrayList<String> getRoundEvents() {
        return roundEvents;
    }

    public void resetRoundEvents() {
        roundEvents.clear();
    }

    @Override
    public void update(final Observable obj1, final EventType event, final Observable obj2) {
        switch (event) {
            case ANGEL_SPAWN:
                Pair<Integer, Integer> coordinates = ((Angel) obj1).getCoordinates();
                roundEvents.add("Angel " + ((Angel) obj1).getType() + " was spawned at "
                        + coordinates.getKey() + " " + coordinates.getValue());
                break;
            case KILLED_BY_ANGEL:
                roundEvents.add("Player " + ((Hero) obj1).getName() + " was killed by an angel");
                break;
            case KILLED_BY_PLAYER:
                roundEvents.add("Player " + ((Hero) obj1).getName()
                        + " was killed by " + ((Hero) obj2).getName());
                break;
            case HIT:
                roundEvents.add(((Angel) obj1).getType() + " hit " + ((Hero) obj2).getName());
                break;
            case HELP:
                roundEvents.add(((Angel) obj1).getType() + " helped " + ((Hero) obj2).getName());
                break;
            case PLAYER_REVIVAL:
                roundEvents.add("Player " + ((Hero) obj1).getName()
                        + " was brought to life by an angel");
                break;
            case LVL_UP:
                roundEvents.add(((Hero) obj1).getName()
                        + " reached level " + ((Hero) obj1).getLevel());
                break;
            default:
                System.out.println("Unknown event!");
                exit(1);
        }
    }
}
