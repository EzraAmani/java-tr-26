package Excercises.javase012.game;

public class Game {
    private static int totalScore = 0;

    public static class Player {
        private String name;
        private int playerScore;

        public Player(String name) {
            this.name = name;
            this.playerScore = 0;
        }

        public void addScore(int points) {
            playerScore += points;
            totalScore += points;
        }

        public int getPlayerScore() {
            return playerScore;
        }

        public String getName() {
            return name;
        }
    }

    public static int getTotalScore() {
        return totalScore;
    }

    public static void resetTotalScore() {
        totalScore = 0;
    }
}
