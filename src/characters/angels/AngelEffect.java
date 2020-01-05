package characters.angels;

public final class AngelEffect {
    private float damageModifier;
    private int hp;
    private boolean revival;
    private int xp;

    public AngelEffect(final float modifier, final int hpAmount,
                       final boolean revivalEffect, final int xpAmount) {
        damageModifier = modifier;
        hp = hpAmount;
        revival = revivalEffect;
        xp = xpAmount;
    }

    public float getDamageModifier() {
        return damageModifier;
    }

    public int getHp() {
        return hp;
    }

    public boolean getRevival() {
        return revival;
    }

    public int getXp() {
        return xp;
    }
}
