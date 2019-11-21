package xp;

import common.Constants;
import heroes.Hero;

public final class XPManager {
    private static int getWinXP(Hero winner, Hero loser) {
        int c1 = Constants.WIN_XP_CONSTANT, c2 = Constants.WIN_XP_MULTIPLIER;
        return winner.getXP() + Math.max(0, c1 - (winner.getLevel() - loser.getLevel()) * c2);
    }

    private static int getLevelUpXP(Hero hero) {
        return Constants.LEVEL_UP_CONSTANT + hero.getLevel() * Constants.LEVEL_UP_MULTIPLIER;
    }

    private static int[] getAfterFightXP(Hero hero1, Hero hero2) {
        int[] XP = new int[2];
        if (hero1.isAlive() && !hero2.isAlive()) {
            XP[0] = getWinXP(hero1, hero2);
        } else {
            if (!hero1.isAlive() && hero2.isAlive()) {
                XP[1] = getWinXP(hero2, hero1);
            } else {
                if (!hero1.isAlive() && !hero2.isAlive()) {
                    XP[0] = getWinXP(hero1, hero2);
                    XP[1] = getWinXP(hero2, hero1);
                }
            }
        }
        return XP;
    }

    private static void updateLevelOf(Hero hero) {
        while (hero.getXP() > getLevelUpXP(hero)) {
            hero.levelUp();
        }
    }

    public static void updateXPAfterFight(Hero hero1, Hero hero2) {
        int[] XP = getAfterFightXP(hero1, hero2);
        hero1.addXP(XP[0]);
        hero2.addXP(XP[1]);

        updateLevelOf(hero1);
        updateLevelOf(hero2);
    }
}
