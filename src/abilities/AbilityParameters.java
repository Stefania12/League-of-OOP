package abilities;

public class AbilityParameters {
    private int priority;
    private int basicDamage;
    private int incapacitationRounds;
    private int overtimeDamage;
    private int overtimeDamageRounds;
    private float terrainMultiplier;
    private float raceMultiplier;

    public AbilityParameters(final int priority, final int basicDamage,
                             final int incapacitationRounds, final int overtimeDamage,
                             final int overtimeDamageRounds, final float terrainMultiplier,
                             final float raceMultiplier) {
        this.priority = priority;
        this.basicDamage = basicDamage;
        this.incapacitationRounds = incapacitationRounds;
        this.overtimeDamageRounds = overtimeDamageRounds;
        this.overtimeDamage = overtimeDamage;
        this.terrainMultiplier = terrainMultiplier;
        this.raceMultiplier = raceMultiplier;
    }

    public int getPriority() {
        return priority;
    }

    public int getBasicDamage() {
        return basicDamage;
    }

    public int getIncapacitationRounds() {
        return incapacitationRounds;
    }

    public int getOvertimeDamage() {
        return overtimeDamage;
    }

    public int getOvertimeDamageRounds() {
        return overtimeDamageRounds;
    }

    public float getTerrainMultiplier() {
        return terrainMultiplier;
    }

    public float getRaceMultiplier() {
        return raceMultiplier;
    }

    @Override
    public java.lang.String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("( ");
        builder.append(priority);
        builder.append(", ");
        builder.append(basicDamage);
        builder.append(", ");
        builder.append(incapacitationRounds);
        builder.append(", ");
        builder.append(overtimeDamage);
        builder.append(", ");
        builder.append(overtimeDamageRounds);
        builder.append(", ");
        builder.append(terrainMultiplier);
        builder.append(", ");
        builder.append(raceMultiplier);
        builder.append(")");
        return builder.toString();
    }
}
