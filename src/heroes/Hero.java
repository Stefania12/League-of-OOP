package heroes;

import abilities.Ability;
import abilities.AbilityParameters;
import common.Constants;
import javafx.util.Pair;

import java.util.LinkedList;

public abstract class Hero implements HeroInterface {
    private final String type;
    protected LinkedList<Ability> abilities;
    private Pair<Integer, Integer> coordinates;
    private int HP;
    private int maxHP;
    private int XP;
    private int level;
    private LinkedList<AbilityParameters> attacks;
    private int incapacitationRounds;
    private LinkedList<Pair<Integer, Integer>> roundDamage;

    public Hero(char type, Pair<Integer, Integer> coordinates, final int maxHP) {
        this.type = String.valueOf(type);
        this.coordinates = coordinates;
        level = Constants.INITIAL_LEVEL;
        XP = Constants.INITIAL_XP;
        abilities = new LinkedList<>();
        this.maxHP = maxHP;
        HP = maxHP;
        attacks = new LinkedList<>();
        incapacitationRounds = 0;
        roundDamage = new LinkedList<>();
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

    public int getIncapacitationRounds() {
        return incapacitationRounds;
    }

    public LinkedList<Ability> getAbilities() {
        return abilities;
    }

    public LinkedList<AbilityParameters> getAttacks() {
        return attacks;
    }

    public String getType() {
        return type;
    }

    public LinkedList<Pair<Integer, Integer>> getRoundDamage() {
        return roundDamage;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void move(char direction) {
        Pair<Integer, Integer> offset = MovementOffsetFactory.getInstance().getOffset(direction);
        coordinates = new Pair<>(coordinates.getKey() + offset.getKey(), coordinates.getValue() + offset.getValue());
    }

    public void addXP(final int value) {
        XP += value;
    }

    public void computeAttacksOn(Hero hero) {
        for (Ability i : abilities) {
            attacks.add(i.getAbilityParametersOn(hero));
        }
    }
}
