package characters.angels;

public class AngelEffects {
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

    public AngelEffects() {
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

    public float getKnightDamageModifier() {
        return knightDamageModifier;
    }

    public float getPyromancerDamageModifier() {
        return pyromancerDamageModifier;
    }

    public float getRogueDamageModifier() {
        return rogueDamageModifier;
    }

    public float getWizardDamageModifier() {
        return wizardDamageModifier;
    }

    public int getKnightHp() {
        return knightHp;
    }

    public int getPyromancerHp() {
        return pyromancerHp;
    }

    public int getRogueHp() {
        return rogueHp;
    }

    public int getWizardHp() {
        return wizardHp;
    }

    public boolean isRevival() {
        return revival;
    }

    public int getKnightXp() {
        return knightXp;
    }

    public int getPyromancerXp() {
        return pyromancerXp;
    }

    public int getRogueXp() {
        return rogueXp;
    }

    public int getWizardXp() {
        return wizardXp;
    }
}
