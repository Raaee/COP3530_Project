import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static Scanner sc = new Scanner(System.in);
    private static String playerChoice, computerChoice;
    private static int playerChoiceNum, computerChoiceNum;
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
        switch (playerChoice) {
            case "Rock":
                playerChoiceNum = 0;
                break;
            case "Paper":
                playerChoiceNum = 1;
                break;
            case "Scissors":
                playerChoiceNum = 2;
                break;
        }
    }

    public void AssignCompChoice() {
        switch (GetRandomNum(0, 2)) {
            case 0:
                computerChoice = "Rock";
                computerChoiceNum = 0;
                break;
            case 1:
                computerChoice = "Paper";
                computerChoiceNum = 1;
                break;
            case 2:
                computerChoice = "Scissors";
                computerChoiceNum = 2;
                break;
        }
    }

    public void CheckForWinner() {
        /**
         * Rock > scissors ; 0 > 2
         * Paper > rock ; 1 > 0
         * Scissors > paper ; 2 > 1
         */
        if ()
    }

    public void PlayGame() {
        System.out.println("\nWelcome to a game of Rock Paper Scissors!");
        System.out.println("You will player against us for a chance to win. Highest of three wins!");
        GetPlayerChoice();
        AssignCompChoice();
    }

}
