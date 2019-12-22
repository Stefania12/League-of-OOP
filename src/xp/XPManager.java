package xp;

import characters.heroes.Hero;
import common.Constants;

/**
 * Utility class for xp management.
 */
public final class XPManager {

    private XPManager() {
    }

    /**
     * Calculates xp amount a hero gains when winning a fight against another.
     *
     * @param winner winner
     * @param loser  loser
     * @return winner xp
     */
    private static int getWinXP(final Hero winner, final Hero loser) {
        int c1 = Constants.WIN_XP_CONSTANT, c2 = Constants.WIN_XP_MULTIPLIER;
        return Math.max(0, c1 - (winner.getLevel() - loser.getLevel()) * c2);
    }

    /**
     * Calculates xp threshold for leveling up.
     *
     * @param hero hero
     * @return xp threshold for leveling up
     */
    private static int getLevelUpXP(final Hero hero) {
        return Constants.LEVEL_UP_CONSTANT + hero.getLevel() * Constants.LEVEL_UP_MULTIPLIER;
    }


    /**
     * Calculates xp characters.heroes gain after fighting.
     * @param hero1     hero1
     * @param hero2     hero2
     * @return array of two elements storing xp for hero1 and hero2
     */
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

    /**
     * Updates level of hero.
     * @param hero  hero
     */
    private static void updateLevelOf(final Hero hero) {
        while (hero.getXP() >= getLevelUpXP(hero)) {
            hero.levelUp();
        }
    }

    /**
     * Updates xp of characters.heroes after fight.
     * @param hero1 hero1
     * @param hero2 hero2
     */
    public static void updateXPAfterFight(final Hero hero1, final Hero hero2) {
        int[] xp = getAfterFightXP(hero1, hero2);
        hero1.addXP(xp[0]);
        hero2.addXP(xp[1]);

        updateLevelOf(hero1);
        updateLevelOf(hero2);
    }

    public static int getXpNeededForLevelUp(final Hero hero) {
        return getLevelUpXP(hero) - hero.getXP();
    }
}
