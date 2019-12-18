package util;

/**
 * Implements generic pair.
 *
 * @param <A> key type
 * @param <B> value type
 */
public class Pair<A, B> {
    private final A key;
    private final B value;

    /**
     * Initialize pair.
     *
     * @param key   key
     * @param value value
     */
    public Pair(final A key, final B value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns key.
     *
     * @return key
     */
    public A getKey() {
        return key;
    }

    /**
     * Returns value.
     *
     * @return value
     */
    public B getValue() {
        return value;
    }

    /**
     * Returns info of the pair.
     * @return (key, value) string
     */
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    /**
     * Checks equality with an object.
     * @param obj   object to check equality with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Pair) {
            Pair p = (Pair) obj;
            return p.key.equals(key) && p.value.equals(value);
        }
        return false;
    }

    /**
     * Returns hashcode of pair.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return ((Integer) (key.hashCode() + value.hashCode())).hashCode();
    }
}
