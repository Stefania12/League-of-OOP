package main;

import abilities.AbilityParameters;
import characters.heroes.Hero;
import util.Pair;
import xp.XPManager;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Implements fighting logic.
 */
final class Fight {

    private Fight() {
    }

    /**
     * Finds an enemy to fight with current hero, with a bigger id.
     *
     * @param heroId current hero id
     * @param heroes list of characters.heroes
     * @return id of enemy to fight
     */
    static int getEnemyToFightWith(final int heroId, final ArrayList<Hero> heroes) {
        if (!heroes.get(heroId).isAlive()) {
            return -1;
        }
        for (int i = heroId + 1; i < heroes.size(); i++) {
            Pair<Integer, Integer> coord = heroes.get(i).getCoordinates();
            if (heroes.get(i).isAlive() && coord.equals(heroes.get(heroId).getCoordinates())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calculates final damage in current round.
     *
     * @param abilityParameters ability parameters
     * @return final damage in current round
     */
    private static int getFinalBasicDamageOf(final AbilityParameters abilityParameters) {
        int basicDamage = abilityParameters.getBasicDamage();
        float raceMultiplier = abilityParameters.getRaceMultiplier();
        float terrainMultiplier = abilityParameters.getTerrainMultiplier();
        return Math.round(Math.round(basicDamage * terrainMultiplier) * raceMultiplier);
    }

    /**
     * Calculates final overtime damage per round.
     * @param abilityParameters ability parameters
     * @return final overtime damage per round
     */
    private static int getFinalOvertimeDamageOf(final AbilityParameters abilityParameters) {
        int overtimeDamage = abilityParameters.getOvertimeDamage();
        float raceMultiplier = abilityParameters.getRaceMultiplier();
        float terrainMultiplier = abilityParameters.getTerrainMultiplier();
        return Math.round(Math.round(overtimeDamage * terrainMultiplier) * raceMultiplier);
    }

    /**
     * Adds effects of ability to a hero.
     * @param abilityParameters     ability parameters
     * @param hero                  hero to be affected by ability
     */
    private static void addEffectsOfAbilityToHero(final AbilityParameters abilityParameters,
                                                  final Hero hero) {
        int currentRoundDamage, overtimeDamage, overtimeRounds, roundsIncapacitation;
        currentRoundDamage = getFinalBasicDamageOf(abilityParameters);
        overtimeDamage = getFinalOvertimeDamageOf(abilityParameters);
        overtimeRounds = abilityParameters.getOvertimeDamageRounds();
        roundsIncapacitation = abilityParameters.getIncapacitationRounds();

        hero.addDamageTaken(currentRoundDamage);

        if (roundsIncapacitation != 0) {
            hero.addIncapacitation(roundsIncapacitation);
        }

        if (overtimeDamage != 0) {
            hero.addOvertimeDamage(new Pair<>(overtimeDamage, overtimeRounds));
        }
    }

    /**
     * Implements fighting between two characters.heroes, hero1 having priority in attack computing.
     * @param hero1     hero that attacks first
     * @param hero2     hero that attacks second
     */
    static void fight(final Hero hero1, final Hero hero2) {
        hero1.setEnemy(hero2);
        hero2.setEnemy(hero1);

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
