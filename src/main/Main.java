package main;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        GameInputLoader loader = new GameInputLoader(args[0]);
        Game game = loader.makeGame();
        game.play();
        game.printOutput(args[1]);
    }
}
