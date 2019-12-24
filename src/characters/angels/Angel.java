package characters.angels;

import characters.EventType;
import characters.Observable;
import characters.Observer;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import util.Pair;

import java.util.ArrayList;

public abstract class Angel implements AngelInterface {
    private String type;
    private EventType action;
    private Pair<Integer, Integer> coordinates;
    private float knightDamageModifier;
    private float pyromancerDamageModifier;
    private float rogueDamageModifier;
    private float wizardDamageModifier;
    private int knightHp;
    private int pyromancerHp;
    private int rogueHp;
    private int wizardHp;
    private boolean revival;
    private int knightXp;
    private int pyromancerXp;
    private int rogueXp;
    private int wizardXp;
    private ArrayList<Observer> observers;

    protected Angel(final String angelType, final EventType angelAction, final Pair<Integer, Integer> angelCoordinates) {
        type = angelType;
        action = angelAction;
        coordinates = angelCoordinates;
        observers = new ArrayList<>();
    }

    protected void initializeDamageModifiers(final float knightModifier, final float pyromancerModifier, final float rogueModifier, final float wizardModifier) {
        knightDamageModifier = knightModifier;
        pyromancerDamageModifier = pyromancerModifier;
        rogueDamageModifier = rogueModifier;
        wizardDamageModifier = wizardModifier;
    }

    protected void initializeLife(final int hpKnight, final int hpPyromancer, final int hpRougue, final int hpWizard, final boolean revivalAction) {
        knightHp = hpKnight;
        pyromancerHp = hpPyromancer;
        rogueHp = hpRougue;
        wizardHp = hpWizard;
        revival = revivalAction;
    }

    protected void initializeXp(final int xpKnight, final int xpPyromancer, final int xpRogue, final int xpWizard) {
        knightXp = xpKnight;
        pyromancerXp = xpPyromancer;
        rogueXp = xpRogue;
        wizardXp = xpWizard;
    }

    public String getType() {
        return type;
    }

    public EventType getAction() {
        return action;
    }

    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    protected float getKnightDamageModifier() {
        return knightDamageModifier;
    }

    protected float getPyromancerDamageModifier() {
        return pyromancerDamageModifier;
    }

    protected float getRogueDamageModifier() {
        return rogueDamageModifier;
    }

    protected float getWizardDamageModifier() {
        return wizardDamageModifier;
    }

    protected int getKnightHp() {
        return knightHp;
    }

    protected int getPyromancerHp() {
        return pyromancerHp;
    }

    protected int getRogueHp() {
        return rogueHp;
    }

    protected int getWizardHp() {
        return wizardHp;
    }

    protected boolean getRevival() {
        return revival;
    }

    @Override
    public AngelEffect getEffectOn(Knight hero) {
        return new AngelEffect(knightDamageModifier, knightHp, revival, knightXp);
    }

    @Override
    public AngelEffect getEffectOn(Pyromancer hero) {
        return new AngelEffect(pyromancerDamageModifier, pyromancerHp, revival, pyromancerXp);
    }

    @Override
    public AngelEffect getEffectOn(Rogue hero) {
        return new AngelEffect(rogueDamageModifier, rogueHp, revival, rogueXp);
    }

    @Override
    public AngelEffect getEffectOn(Wizard hero) {
        return new AngelEffect(wizardDamageModifier, wizardHp, revival, wizardXp);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(Observable obj1, EventType event, Observable obj2) {
        for (Observer o : observers) {
            o.update(obj1, event, obj2);
        }
    }
}
