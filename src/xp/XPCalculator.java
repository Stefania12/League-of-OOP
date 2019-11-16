package xp;

import common.Constants;
import heroes.Hero;

public final class XPCalculator {
    private static int getWinXP(Hero winner, Hero loser) {
        int c1 = Constants.WIN_XP_CONSTANT, c2 = Constants.WIN_XP_MULTIPLIER;
        return winner.getXP() + Math.max(0, c1 - (winner.getLevel() - loser.getLevel()) * c2);
    }

    private static int getLevelUpXP(Hero hero) {
        return Constants.LEVEL_UP_CONSTANT + hero.getLevel() * Constants.LEVEL_UP_MULTIPLIER;
    }
}
