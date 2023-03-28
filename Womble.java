import java.util.Random;
import java.util.Scanner;

public class Womble {
    
    private static Random ranGen = new Random();
    private static Scanner sc = new Scanner(System.in);
    private static String playerGuess;

    public void PlayGame() {
        System.out.println("Welcome to a game of Womble!");

    }

    public void GetPlayerGuess() {
        System.out.println("Enter your guess:");

    }
    public void PrintRules() {
        System.out.println("");
        /*
         * [X] means the letter exists in the word but is in the wrong spot
         * X means the letter does not exist in the word
         * if the letter does not get replaced, means it is in the correct spot in the word
         * 
         * player will have 6 attempts to guess the word.
         */
    }

}
