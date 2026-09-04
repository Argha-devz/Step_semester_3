package string.assigment_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0, rounds = 5;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("--------------------------------------------");

        for (int i = 1; i <= rounds; i++) {
            String computerMove = moves[random.nextInt(moves.length)];
            // Predefined or simulated move for demo:
            String playerMove = moves[random.nextInt(moves.length)];

            String result = playRound(playerMove, computerMove);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Round " + i + " | Player: " + playerMove + ", Computer: " + computerMove + " | " + result);
        }

        double winPercentage = ((double) wins / rounds) * 100;
        System.out.println("\nFinal Summary (after " + rounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}