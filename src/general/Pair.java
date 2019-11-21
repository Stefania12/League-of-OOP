package general;

public class Pair<A, B> {
    private A key;
    private B value;

    public Pair(A key, B value) {
        this.key = key;
        this.value = value;
    }

    public A getKey() {
        return key;
    }

    public void setKey(A key) {
        this.key = key;
    }

    public B getValue() {
        return value;
    }

    public void setValue(B value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    @Override
    public int hashCode() {
        return ((Integer) (key.hashCode() + value.hashCode())).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Pair) {
            Pair p = (Pair) obj;
            return p.key.equals(key) && p.value.equals(value);
        }
        return false;
    }


}
