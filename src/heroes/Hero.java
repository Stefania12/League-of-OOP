package heroes;

import javafx.util.Pair;

public abstract class Hero {
    protected final String type;
    protected Pair<Integer, Integer> coordinates;
    protected int HP;
    protected int XP;
    protected int level;

    public Hero(char type, Pair<Integer, Integer> coordinates) {
        this.type = String.valueOf(type);
        this.coordinates = coordinates;
        level = 0;
        XP = 0;
    }

    public Hero() {
        type = "";
    }

    @Override
    public String toString() {
        return type + " " + coordinates;
    }

    public int getHP() {
        return HP;
    }

    public int getXP() {
        return XP;
    }

    public int getLevel() {
        return level;
    }

    public void addXP(final int value) {
        XP += value;
    }

}
