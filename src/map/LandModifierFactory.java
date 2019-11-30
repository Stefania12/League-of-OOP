package map;

import common.Constants;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;

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
        knightBonus.put('W', 1.0f);
        knightBonus.put('D', 1.0f);
        knightBonus.put('V', 1.0f);

        pyromancerBonus = new HashMap<>();
        pyromancerBonus.put('V', Constants.PYROMANCER_BONUS_DAMAGE_MULTIPLIER);
        pyromancerBonus.put('L', 1.0f);
        pyromancerBonus.put('D', 1.0f);
        pyromancerBonus.put('W', 1.0f);

        rogueBonus = new HashMap<>();
        rogueBonus.put('W', Constants.ROGUE_BONUS_DAMAGE_MULTIPLIER);
        rogueBonus.put('L', 1.0f);
        rogueBonus.put('D', 1.0f);
        rogueBonus.put('V', 1.0f);

        wizardBonus = new HashMap<>();
        wizardBonus.put('D', Constants.WIZARD_BONUS_DAMAGE_MULTIPLIER);
        wizardBonus.put('L', 1.0f);
        wizardBonus.put('W', 1.0f);
        wizardBonus.put('V', 1.0f);
    }

    public static LandModifierFactory getInstance() {
        if (instance == null) {
            instance = new LandModifierFactory();
        }
        return instance;
    }

    public float getDamageBonusMultiplier(Knight hero) {
        return knightBonus.get(Map.getInstance().getTerrainAt(hero.getCoordinates()).getType());
    }

    public float getDamageBonusMultiplier(Rogue hero) {
        return rogueBonus.get(Map.getInstance().getTerrainAt(hero.getCoordinates()).getType());
    }

    public float getDamageBonusMultiplier(Wizard hero) {
        return wizardBonus.get(Map.getInstance().getTerrainAt(hero.getCoordinates()).getType());
    }

    public float getDamageBonusMultiplier(Pyromancer hero) {
        return pyromancerBonus.get(Map.getInstance().getTerrainAt(hero.getCoordinates()).getType());
    }
}
