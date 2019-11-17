package heroes;

import abilities.Ability;
import common.Constants;
import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Hero {
    protected final String type;
    protected Pair<Integer, Integer> coordinates;
    protected int HP;
    protected int maxHP;
    protected int XP;
    protected int level;
    protected ArrayList<Ability> abilities;

    public Hero(char type, Pair<Integer, Integer> coordinates) {
        this.type = String.valueOf(type);
        this.coordinates = coordinates;
        level = Constants.INITIAL_LEVEL;
        XP = Constants.INITIAL_XP;
        abilities = new ArrayList<>();
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

    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void addXP(final int value) {
        XP += value;
    }

}
