package characters;

public interface Observer {
    void update(Observable obj1, EventType event, Observable obj2);
}
