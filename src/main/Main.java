package main;

import heroes.Hero;

public class Main {
    public static void main(String[] args) {
        GameInputLoader loader = new GameInputLoader("C:\\Users\\stefa\\OneDrive\\Desktop\\League of OOP\\test.txt");
        Game game = loader.makeGame();
        System.out.println(game);
        game.play();
        Hero h0 = game.getHeroes().get(0), h1 = game.getHeroes().get(1);

        // h1.computeAttacksOn(h0);
        // h0.computeAttacksOn(h1);


        System.out.println(h1 + "\n" + h0);
    }
}
