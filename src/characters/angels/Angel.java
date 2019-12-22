package characters.angels;

import util.Pair;

public abstract class Angel implements AngelInterface {
    private String type;
    private String action;
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

    protected Angel(final String angelType, final String angelAction, final Pair<Integer, Integer> angelCoordinates) {
        type = angelType;
        action = angelAction;
        coordinates = angelCoordinates;
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
}
