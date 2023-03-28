import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static Scanner sc = new Scanner(System.in);
    private static String playerChoice, computerChoice;
    private static String winner;
    private static int amtPlayerWins = 0, amtComputerWins = 0;
    private static String[] playerWins = new String[3];
    private static String[] computerWins = new String[3];

    public int GetRandomNum(int origin, int bound) {
        Random ranNum = new Random();
        return ranNum.nextInt(bound - origin + 1) + origin;
    }

    public void GetPlayerChoice() {
        do {
            System.out.println("\nChoose your weapon:");
            System.out.println("Rock, Paper, or Scissors.");
            playerChoice = sc.nextLine();

            if (!playerChoice.equalsIgnoreCase("Rock") && !playerChoice.equalsIgnoreCase("Paper")
                    && !playerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid weapon choice.");
                playerChoice = "InvalidChoice";
            }
        } while (playerChoice.equals("InvalidChoice"));
    }

    public void AssignCompChoice() {
        switch (GetRandomNum(0, 2)) {
            case 0:
                computerChoice = "Rock";
                break;
            case 1:
                computerChoice = "Paper";
                break;
            case 2:
                computerChoice = "Scissors";
                break;
        }
    }

    public boolean CheckPlay(int round) {
        /**
         * Rock > scissors ; 
         * Paper > rock ;
         * Scissors > paper ;
         */
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            winner = "Tie!";
            return true;
        } 
        else if (playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) {
            PlayerWin(round);
            return false;
        } 
        else if (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) {
            PlayerWin(round);
            return false;
        }
        else if (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper")) {
            PlayerWin(round);
            return false;
        }
        else {
            winner = "We win this round.";
            computerWins[round] = "Win";
            amtComputerWins++;
            playerWins[round] = "Lose";
            return false;
        }
    }
    public void PlayerWin(int round) {
        winner = "You win this round!";
        playerWins[round] = "Win";
        amtPlayerWins++;
        computerWins[round] = "Lose";
    }
    public void CheckWinner() {
        if (amtPlayerWins > amtComputerWins) {
            System.out.println("\nYou Win!");
        }
        else {
            System.out.println("\nWe Won! Better luck next time.");
        }
    }
    public void DisplayScores() {
        System.out.println("\nYour Game Scores:");
        for (int i = 0; i < playerWins.length; i++) {
            System.out.println("Round " + (i+1) + ": " + playerWins[i]);
        }
    }

    public void PlayGame() {
        int round = 0;
        boolean tie = false;

        System.out.println("\nWelcome to a game of Rock Paper Scissors!");
        System.out.println("You will player against us for a chance to win. Highest of three wins!");

        do {
            GetPlayerChoice();
            AssignCompChoice();
            tie = CheckPlay(round);
            round++;

            System.out.println("\nOur weapon: " + computerChoice);
            System.out.println(winner);  
            
            if (tie) {
                if (round == 1) {
                    round = 0;
                } else {
                    round--;
                }
            }
            
        } while (round < 3);

        CheckWinner();
        DisplayScores();
    }

}
