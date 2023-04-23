/* 
 * This is a word scramble game that uses ArrayLists to store words and their scrambled versions. 
 * The player has to unscramble the word and the game keeps track of the score. 
 * It includes methods to handle different aspects of the game and a menu system for difficulty selection.
 */

import java.util.ArrayList;
import java.util.List;

public class WordScramble extends WordScrambleData {

    private String playerGuess;
    private List<String> wordsToGuess = new ArrayList<>();
    private List<String> scrambledWords = new ArrayList<>();
    private int amtWordsLeft = 0;
    private boolean playAgain;

    public void PlayGame() throws InterruptedException {
        do {
            playAgain = true;
            System.out.println("\n\t ~~ Welcome to a game of Word Scramble! ~~");
            PrintRules();
            SelectDifficulty();

            System.out.print("\nAcquiring words");
            input.Delay("...", 500);
            amtWordsLeft = wordsToGuess.size();
            scrambledWords = ScrambleWords(wordsToGuess);

            do {
                StartGame();
            } while (amtWordsLeft > 0);

            ShowWords(scrambledWords);
            System.out.println("\n\nCongrats! You Won ~ *");

            playAgain = input.PlayAgain();
        } while (playAgain);
    }

    public void StartGame() {
        System.out.println("\n");
        System.out.println("Words Left: " + amtWordsLeft);
        // ShowWords(wordsToGuess); // DEBUG
        ShowWords(scrambledWords);
        EvaluateGuess();
    }

    public void EvaluateGuess() {
        boolean loop;
        int index;
        String wordGuessing;

        do {
            index = 0;
            loop = false;
            System.out.println("\nEnter Guess: Format >>(1 myguess)");
            playerGuess = input.sc.nextLine();
            playerGuess = playerGuess.replaceAll("\\s", "");

            if (playerGuess.equalsIgnoreCase("Rules") || playerGuess.contains("rules")) {
                loop = false;
            } else {
                if (Character.isDigit(playerGuess.charAt(0))) {
                    index = Integer.parseInt(String.valueOf(playerGuess.charAt(0)));
                }
                if (!(playerGuess.matches("\\d+.+"))) {
                    System.out.println("x ~ Incorrect Formatting.");
                    loop = true;
                }
                if (index < 1 || index > wordsToGuess.size()) {
                    System.out.println("x ~ That is not a valid word number.");
                    loop = true;
                }
            }
        } while (loop);

        playerGuess = playerGuess.toUpperCase();
        switch (playerGuess) {
            case "RULES" -> PrintRules();
            default -> {
                index -= 1;
                wordGuessing = wordsToGuess.get(index);
                playerGuess = playerGuess.substring((playerGuess.charAt(1) == ' ') ? 2 : 1, playerGuess.length());

                if (playerGuess.equalsIgnoreCase(wordGuessing)) {
                    System.out.println("Correct!");
                    scrambledWords.set(index, wordsToGuess.get(index) + " ~");
                    amtWordsLeft--;
                } else {
                    System.out.println("Try Again");
                }
            }
        }
    }

    public void SelectDifficulty() {
        switch (input.DifficultyMenu()) {
            case "1" -> wordsToGuess = AddWords(2);
            case "2" -> wordsToGuess = AddWords(4);
            case "3" -> wordsToGuess = AddWords(6);
        }
    }

    public void PrintRules() {
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("> You will be given a set of words with its letters scrambled.");
        System.out.println("> The goal is to guess the correct words by descrambling the letters.");

        System.out.println("\n> To guess a specific word, indicate the number and your guess.");
        System.out.println("> Input example: (1 myguess) OR (1myguess)");
        System.out.println("** If at anytime you wish to see the rules again, type in \"Rules\" **");
        System.out.println("Good luck!");
    }

}