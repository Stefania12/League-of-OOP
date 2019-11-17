package map;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import java.util.HashMap;

public final class LandModifierFactory {
    private static LandModifierFactory instance = null;
    private static HashMap<Character, Float> knightBonus;
    private static HashMap<Character, Float> pyromancerBonus;
    private static HashMap<Character, Float> rogueBonus;
    private static HashMap<Character, Float> wizardBonus;

    private LandModifierFactory() {
        knightBonus = new HashMap<>();
        knightBonus.put('L', Constants.KNIGHT_BONUS_DAMAGE_MULTIPLIER);
        knightBonus.put('W', 0f);
        knightBonus.put('D', 0f);
        knightBonus.put('V', 0f);

        pyromancerBonus = new HashMap<>();
        pyromancerBonus.put('V', Constants.PYROMANCER_BONUS_DAMAGE_MULTIPLIER);
        pyromancerBonus.put('L', 0f);
        pyromancerBonus.put('D', 0f);
        pyromancerBonus.put('W', 0f);

        rogueBonus = new HashMap<>();
        rogueBonus.put('W', Constants.ROGUE_BONUS_DAMAGE_MULTIPLIER);
        rogueBonus.put('L', 0f);
        rogueBonus.put('D', 0f);
        rogueBonus.put('V', 0f);

        wizardBonus = new HashMap<>();
        wizardBonus.put('D', Constants.WIZARD_BONUS_DAMAGE_MULTIPLIER);
        wizardBonus.put('L', 0f);
        wizardBonus.put('W', 0f);
        wizardBonus.put('V', 0f);
    }

    public static float getDamageBonusMultiplier(Knight hero) {
        int x = hero.getCoordinates().getKey(), y = hero.getCoordinates().getValue();
        return knightBonus.get(Map.getInstance().getTerrainAt(x, y));
    }

    public static float getDamageBonusMultiplier(Rogue hero) {
        int x = hero.getCoordinates().getKey(), y = hero.getCoordinates().getValue();
        return rogueBonus.get(Map.getInstance().getTerrainAt(x, y));
    }

    public static float getDamageBonusMultiplier(Wizard hero) {
        int x = hero.getCoordinates().getKey(), y = hero.getCoordinates().getValue();
        return wizardBonus.get(Map.getInstance().getTerrainAt(x, y));
    }

    public static float getDamageBonusMultiplier(Pyromancer hero) {
        int x = hero.getCoordinates().getKey(), y = hero.getCoordinates().getValue();
        return pyromancerBonus.get(Map.getInstance().getTerrainAt(x, y));
    }

    public LandModifierFactory getInstance() {
        if (instance == null) {
            instance = new LandModifierFactory();
        }
        return instance;
    }
}
