package characters.angels.types;

import characters.EventType;
import characters.angels.Angel;
import characters.angels.AngelEffect;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import util.Pair;
import xp.XPManager;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final Pair<Integer, Integer> coordinates) {
        super("LevelUpAngel", EventType.HELP, coordinates);
        super.initializeDamageModifiers(Constants.LVL_UP_ANGEL_KNIGHT_MODIFIER,
                Constants.LVL_UP_ANGEL_PYROMANCER_MODIFIER, Constants.LVL_UP_ANGEL_ROGUE_MODIFIER,
                Constants.LVL_UP_ANGEL_WIZARD_MODIFIER);
        super.initializeLife(0, 0, 0, 0, false);
        initializeXp(0, 0, 0, 0);
    }

    @Override
    public AngelEffect getEffectOn(final Knight hero) {
        return new AngelEffect(getKnightDamageModifier(), getKnightHp(),
                getRevival(), XPManager.getXpNeededForLevelUp(hero));
    }

    @Override
    public AngelEffect getEffectOn(final Pyromancer hero) {
        return new AngelEffect(getPyromancerDamageModifier(), getPyromancerHp(),
                getRevival(), XPManager.getXpNeededForLevelUp(hero));
    }

    @Override
    public AngelEffect getEffectOn(final Rogue hero) {
        return new AngelEffect(getRogueDamageModifier(), getRogueHp(),
                getRevival(), XPManager.getXpNeededForLevelUp(hero));
    }

    @Override
    public AngelEffect getEffectOn(final Wizard hero) {
        return new AngelEffect(getWizardDamageModifier(), getWizardHp(),
                getRevival(), XPManager.getXpNeededForLevelUp(hero));
    }
}
