package heroes;

import abilities.Ability;
import abilities.AbilityParameters;
import common.Constants;
import javafx.util.Pair;

import java.util.LinkedList;

public abstract class Hero implements HeroInterface {
    private final String type;
    private final int fightPriority;
    private Pair<Integer, Integer> coordinates;
    protected LinkedList<Ability> abilities;
    private int HP;
    private int maxHP;
    private int XP;
    private int level;
    private boolean alive;
    private LinkedList<AbilityParameters> attacks;
    private int damageTaken;
    private Pair<Integer, Integer> overtimeDamage;
    private int incapacitationRounds;

    public Hero(HeroPriority priority, char type, Pair<Integer, Integer> coordinates, final int maxHP) {
        this.type = String.valueOf(type);
        fightPriority = priority.ordinal();
        this.coordinates = coordinates;
        level = Constants.INITIAL_LEVEL;
        XP = Constants.INITIAL_XP;
        abilities = new LinkedList<>();
        this.maxHP = maxHP;
        HP = maxHP;
        attacks = new LinkedList<>();
        incapacitationRounds = 0;
        damageTaken = 0;
        alive = true;
    }

    @Override
    public String toString() {
        return type + " " + coordinates + " " + alive + " maxHP: " + maxHP + " HP: " + HP + " XP: " + XP + " level: " + level;
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

    public void addIncapacitaion(final int rounds) {
        incapacitationRounds = rounds;
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

    public Pair<Integer, Integer> getOvertimeDamage() {
        return overtimeDamage;
    }

    public void addOvertimeDamage(Pair<Integer, Integer> damage) {
        overtimeDamage = damage;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getPriority() {
        return fightPriority;
    }

    public int getFightPriority() {
        return fightPriority;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void addDamageTaken(int amount) {
        damageTaken += amount;
    }

    public void resetDamageTaken() {
        damageTaken = 0;
    }

    public void move(char direction) {
        Pair<Integer, Integer> offset = MovementOffsetFactory.getInstance().getOffset(direction);
        if (incapacitationRounds != 0) {
            incapacitationRounds--;
            return;
        }
        coordinates = new Pair<>(coordinates.getKey() + offset.getKey(), coordinates.getValue() + offset.getValue());
    }

    public void addXP(final int value) {
        XP += value;
    }

    public void computeAttacksOn(Hero hero) {
        attacks.clear();
        for (Ability i : abilities) {
            attacks.add(i.getAbilityParametersOn(hero));
        }
    }

    public void clearAttacks() {
        attacks.clear();
    }

    public void updateAliveStatus() {
        if (HP <= 0) {
            alive = false;
            HP = 0;
        }
    }

    public void takeDamage() {
        HP -= damageTaken;
        damageTaken = 0;
        this.updateAliveStatus();
    }

    public void takeOvertimeDamage() {
        if (overtimeDamage == null) {
            return;
        }
        HP -= overtimeDamage.getKey();
        if (overtimeDamage.getValue() - 1 > 0) {
            overtimeDamage = new Pair<>(overtimeDamage.getKey(), overtimeDamage.getValue() - 1);
        } else {
            overtimeDamage = null;
        }
        this.updateAliveStatus();
    }
}
