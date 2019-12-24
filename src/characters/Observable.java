package characters;

public interface Observable {
    void notifyObservers(Observable obj1, EventType event, Observable obj2);
}
