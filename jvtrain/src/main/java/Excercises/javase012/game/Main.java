package Excercises.javase012.game;

public class Main {
    public static void main(String[] args) {
        Game.Player player1 = new Game.Player("Alice");
        Game.Player player2 = new Game.Player("Bob");

        player1.addScore(10);
        player2.addScore(5);

        System.out.println(player1.getName() + ": " + player1.getPlayerScore());
        System.out.println(player2.getName() + ": " + player2.getPlayerScore());
        System.out.println("Total score: " + Game.getTotalScore());
    }
}
