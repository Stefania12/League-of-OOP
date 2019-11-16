package main;

public class Main {
    public static void main(String[] args) {
        GameInputLoader loader = new GameInputLoader("C:\\Users\\stefa\\OneDrive\\Desktop\\League of OOP\\test.txt");
        Game game = loader.makeGame();
        System.out.println(game);
    }
}
