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
        DifficultyMenu();
        AssignWordToGuess();
        do {
            System.out.println("\n---------------");
            System.out.println("Tries Left: " + tries);

            GetPlayerGuess();
            EvaluateGuess();
            PrintOutput();
            ResetOutput();

            if (won)
                tries = 0;
            else
                tries--;
        } while (tries > 0);

        EndingMessage();
    }

    public void EndingMessage() {
        if (won) {
            System.out.println("Correct! You Won.\n");
        } else {
            System.out.println("\nUh oh! You ran out of tries.");
            System.out.println("The correct word was: " + correctWord + "\n");
        }
    }

    public void PrintOutput() {
        System.out.println("\n" + output);
    }

    public void AssignWordToGuess() {
        int indx = ranGen.nextInt(wordsToGuess.length) + 0;
        correctWord = wordsToGuess[indx];
    }

    public void ResetOutput() {
        output = "";
    }

    public void EvaluateGuess() {
        for (int i = 0; i < playerGuess.length(); i++) {
            String ch = String.valueOf(playerGuess.charAt(i));

            if (playerGuess.equalsIgnoreCase(correctWord)) {
                won = true;
                return;
            } else if (playerGuess.charAt(i) == correctWord.charAt(i)) {
                output += " " + playerGuess.charAt(i) + " ";
                output = output.toUpperCase();
            } else if (playerGuess.charAt(i) != correctWord.charAt(i) && correctWord.contains(ch)) {
                String s = "[" + ch + "]";
                output += s;
                output = output.toUpperCase();
            } else if (!correctWord.contains(ch)) {
                output += " X ";
                output = output.toUpperCase();
            }
        }
    }

    public void GetPlayerGuess() {
        boolean loop;
        do {
            loop = false;
            System.out.println("\nEnter your guess:");
            playerGuess = sc.nextLine();
            if (playerGuess.length() < 5 || playerGuess.length() > 5) {
                System.out.println("Word must be 5 letters.");
                loop = true;
            }
        } while (loop);
    }

    public void DifficultyMenu() {
        String difficulty;
        boolean loop;
        do {
            loop = false;
            System.out.println("\nChoose a difficulty:");
            System.out.println("1. Easy");
            System.out.println("2. Mid");
            System.out.println("3. Hard");
            difficulty = sc.nextLine();

            if (!difficulty.equals("1") && !difficulty.equals("2") && !difficulty.equals("3")) {
                System.out.println("\nInvalid Choice.");
                loop = true;
            }

        } while (loop);

        switch (difficulty) {
            case "1" -> wordsToGuess = wombleWordsData.EasyWords();
            case "2" -> wordsToGuess = wombleWordsData.MidWords();
            case "3" -> wordsToGuess = wombleWordsData.HardWords();
        }
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
