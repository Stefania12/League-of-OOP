package characters.angels;

import characters.EventType;
import characters.GreatMage;
import characters.Observable;
import characters.Observer;
import characters.heroes.Hero;
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

    protected Angel(final String angelType, final EventType angelAction,
                    final Pair<Integer, Integer> angelCoordinates) {
        type = angelType;
        action = angelAction;
        coordinates = angelCoordinates;
        observers = new ArrayList<>();
        this.addObserver(GreatMage.getInstance());
        this.notifyObservers(this, EventType.ANGEL_SPAWN, null);
    }

    protected final void initializeDamageModifiers(final float knightModifier,
                                                   final float pyromancerModifier,
                                                   final float rogueModifier,
                                                   final float wizardModifier) {
        knightDamageModifier = knightModifier;
        pyromancerDamageModifier = pyromancerModifier;
        rogueDamageModifier = rogueModifier;
        wizardDamageModifier = wizardModifier;
    }

    protected final void initializeLife(final int hpKnight, final int hpPyromancer,
                                        final int hpRougue, final int hpWizard,
                                        final boolean revivalAction) {
        knightHp = hpKnight;
        pyromancerHp = hpPyromancer;
        rogueHp = hpRougue;
        wizardHp = hpWizard;
        revival = revivalAction;
    }

    protected final void initializeXp(final int xpKnight, final int xpPyromancer,
                                      final int xpRogue, final int xpWizard) {
        knightXp = xpKnight;
        pyromancerXp = xpPyromancer;
        rogueXp = xpRogue;
        wizardXp = xpWizard;
    }

    public final String getType() {
        return type;
    }

    protected final EventType getAction() {
        return action;
    }

    public final Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    protected final float getKnightDamageModifier() {
        return knightDamageModifier;
    }

    protected final float getPyromancerDamageModifier() {
        return pyromancerDamageModifier;
    }

    protected final float getRogueDamageModifier() {
        return rogueDamageModifier;
    }

    protected final float getWizardDamageModifier() {
        return wizardDamageModifier;
    }

    protected final int getKnightHp() {
        return knightHp;
    }

    protected final int getPyromancerHp() {
        return pyromancerHp;
    }

    protected final int getRogueHp() {
        return rogueHp;
    }

    protected final int getWizardHp() {
        return wizardHp;
    }

    protected final boolean getRevival() {
        return revival;
    }

    protected final boolean canHaveEffectOn(final Hero hero) {
        return ((hero.isAlive() && !revival || (revival && !hero.isAlive())));
    }

    /**
     * Visitor-type function that returns the effects on the knight race.
     *
     * @param hero hero
     * @return effects
     */
    @Override
    public AngelEffect getEffectOn(final Knight hero) {
        if (canHaveEffectOn(hero)) {
            this.notifyObservers(this, action, hero);
            return new AngelEffect(knightDamageModifier, knightHp, revival, knightXp);
        }
        return new AngelEffect(0, 0, false, 0);
    }

    /**
     * Visitor-type function that returns the effects on the pyromancer race.
     * @param hero  hero
     * @return effects
     */
    @Override
    public AngelEffect getEffectOn(final Pyromancer hero) {
        if (canHaveEffectOn(hero)) {
            this.notifyObservers(this, action, hero);
            return new AngelEffect(pyromancerDamageModifier, pyromancerHp, revival, pyromancerXp);
        }
        return new AngelEffect(0, 0, false, 0);
    }

    /**
     * Visitor-type function that returns the effects on the rogue race.
     * @param hero  hero
     * @return effects
     */
    @Override
    public AngelEffect getEffectOn(final Rogue hero) {
        if (canHaveEffectOn(hero)) {
            this.notifyObservers(this, action, hero);
            return new AngelEffect(rogueDamageModifier, rogueHp, revival, rogueXp);
        }
        return new AngelEffect(0, 0, false, 0);
    }

    /**
     * Visitor-type function that returns the effects on the wizard race.
     * @param hero  hero
     * @return effects
     */
    @Override
    public AngelEffect getEffectOn(final Wizard hero) {
        if (canHaveEffectOn(hero)) {
            this.notifyObservers(this, action, hero);
            return new AngelEffect(wizardDamageModifier, wizardHp, revival, wizardXp);
        }
        return new AngelEffect(0, 0, false, 0);
    }

    public final void addObserver(final Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifies observers about events.
     * @param obj1  observable1
     * @param event event
     * @param obj2  observable2
     */
    @Override
    public void notifyObservers(final Observable obj1, final EventType event,
                                final Observable obj2) {
        for (Observer o : observers) {
            o.update(obj1, event, obj2);
        }
    }
}
