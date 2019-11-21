package main;

import abilities.AbilityParameters;
import heroes.Hero;
import javafx.util.Pair;
import xp.XPManager;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Fight {

    static int getEnemyToFightWith(final int heroId, ArrayList<Hero> heroes) {
        for (int i = heroId + 1; i < heroes.size(); i++) {
            if (heroes.get(i).isAlive() && heroes.get(i).getCoordinates().equals(heroes.get(heroId).getCoordinates())) {
                return i;
            }
        }
        return -1;
    }

    private static int getFinalBasicDamageOf(AbilityParameters abilityParameters) {
        int basicDamage = abilityParameters.getBasicDamage();
        float raceMultiplier = abilityParameters.getRaceMultiplier();
        float terrainMultiplier = abilityParameters.getTerrainMultiplier();
        return Math.round(Math.round(basicDamage * terrainMultiplier) * raceMultiplier);
    }

    private static int getFinalOvertimeDamageOf(AbilityParameters abilityParameters) {
        int overtimeDamage = abilityParameters.getOvertimeDamage();
        float raceMultiplier = abilityParameters.getRaceMultiplier();
        float terrainMultiplier = abilityParameters.getTerrainMultiplier();
        return Math.round(Math.round(overtimeDamage * terrainMultiplier) * raceMultiplier);
    }

    private static void addEffectsOfAbilityToHero(AbilityParameters abilityParameters, Hero hero) {
        int currentRoundDamage, overtimeDamage, roundsDamage, roundsIncapacitation;
        currentRoundDamage = getFinalBasicDamageOf(abilityParameters);
        overtimeDamage = getFinalOvertimeDamageOf(abilityParameters);
        roundsDamage = abilityParameters.getOvertimeDamageRounds();
        roundsIncapacitation = abilityParameters.getIncapacitationRounds();

        hero.addDamageTaken(currentRoundDamage);
        hero.addIncapacitaion(roundsIncapacitation);
        hero.addOvertimeDamage(new Pair<>(overtimeDamage, roundsDamage));
    }

    public static void fight(Hero hero1, Hero hero2) {
        hero1.computeAttacksOn(hero2);
        hero2.computeAttacksOn(hero1);

        LinkedList<AbilityParameters> attack1, attack2;
        attack1 = hero1.getAttacks();
        attack2 = hero2.getAttacks();

        for (AbilityParameters i : attack1) {
            addEffectsOfAbilityToHero(i, hero2);
        }

        for (AbilityParameters i : attack2) {
            addEffectsOfAbilityToHero(i, hero1);
        }

        hero1.takeDamage();
        hero2.takeDamage();

        XPManager.updateXPAfterFight(hero1, hero2);
    }
}
