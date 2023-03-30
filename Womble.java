import java.util.Random;
import java.util.Scanner;

public class Womble {

    private static Random ranGen = new Random();
    private static Scanner sc = new Scanner(System.in);
    private static String playerGuess;
    private static String output = "";

    private static WombleWordsData wombleWordsData = new WombleWordsData();
    private static String[] wordsToGuess;
    private static String correctWord;

    private static boolean won = false;

    private static int tries = 6;

    public void PlayGame() {
        System.out.println("\nWelcome to a game of Womble!");
        PrintRules();
        // DifficultyMenu();
        // AssignWordToGuess();
        do {
            System.out.println("\n---------------");
            System.out.println("Tries Left: " + tries);

            // GetPlayerGuess();
            // EvaluateGuess();
            // PrintOutput();
            // ResetOutput();

            if (won)
                tries = 0;
            else
                tries--;
        } while (tries > 0);

        // EndingMessage();
    }

    public void PrintRules() {
        /*
         * [X] means the letter exists in the word but is in the wrong spot
         * X means the letter does not exist in the word
         * if the letter does not get replaced, means it is in the correct spot in the
         * word
         * 
         * player will have 6 attempts to guess the word.
         */
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("> Guess the word by inputting guesses.");
        System.out.println("> You will have 6 attempts to guess the correct word.");
        System.out.println("> Letters outputted within a [ ] mean the letter exists in the word, but");
        System.out.println("    it is in the wrong spot.");
        System.out.println("> Letters that have been replaced by an X mean they do not exist in the word.");
        System.out.println("> Letters that do not change, mean they are in the correct spot.");
        System.out.println("> If the word is not guessed, within the 6 attempts, you lose.");

        System.out.println("Good Luck!\n");
    }

}
