package xp;

import common.Constants;
import heroes.Hero;

public final class XPManager {

    private XPManager() {
    }

    private static int getWinXP(final Hero winner, final Hero loser) {
        int c1 = Constants.WIN_XP_CONSTANT, c2 = Constants.WIN_XP_MULTIPLIER;
        return Math.max(0, c1 - (winner.getLevel() - loser.getLevel()) * c2);
    }

    private static int getLevelUpXP(final Hero hero) {
        return Constants.LEVEL_UP_CONSTANT + hero.getLevel() * Constants.LEVEL_UP_MULTIPLIER;
    }

    private static int[] getAfterFightXP(final Hero hero1, final Hero hero2) {
        int[] xp = new int[2];
        if (hero1.isAlive() && !hero2.isAlive()) {
            xp[0] = getWinXP(hero1, hero2);
        } else {
            if (!hero1.isAlive() && hero2.isAlive()) {
                xp[1] = getWinXP(hero2, hero1);
            } else {
                if (!hero1.isAlive() && !hero2.isAlive()) {
                    xp[0] = getWinXP(hero1, hero2);
                    xp[1] = getWinXP(hero2, hero1);
                }
            }
        }
        return xp;
    }

    private static void updateLevelOf(final Hero hero) {
        while (hero.getXP() >= getLevelUpXP(hero)) {
            hero.levelUp();
        }
    }

    public static void updateXPAfterFight(final Hero hero1, final Hero hero2) {
        int[] xp = getAfterFightXP(hero1, hero2);
        hero1.addXP(xp[0]);
        hero2.addXP(xp[1]);

        updateLevelOf(hero1);
        updateLevelOf(hero2);
    }
}
