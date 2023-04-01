import java.util.Scanner;
/*
 * This is a word guessing game. Based off of the NewYork Time's Web game, Wordle.
 * Player attempts to guess a word within 6 tries of receiving letter position feedback.
 */

public class Womble {

    private Scanner sc = new Scanner(System.in);
    private String playerGuess;
    private String output = "";

    private Input input = new Input();
    private WombleWordsData wombleWordsData = new WombleWordsData();
    private String[] wordsToGuess;
    private String correctWord;

    private boolean won;
    private boolean playAgain;

    private int tries = 6;

    // Acts as the "main" method for this game class:
    public void PlayGame() {
        do {
            ResetGame();

            System.out.println("\n~~ Welcome to a game of Womble! ~~");
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
            playAgain = input.PlayAgain();

        } while (playAgain);
    }

    public void EndingMessage() {
        if (won) {
            System.out.println("Correct! You Won. ~ *\n");
        } else {
            System.out.println("\nUh oh! You ran out of tries.");
            System.out.println("The correct word was: " + correctWord + "\n");
        }
    }

    public void PrintOutput() {
        System.out.println("\n" + output);
    }

    public void AssignWordToGuess() {
        int indx = input.GetRandomNum(0, wordsToGuess.length - 1);
        correctWord = wordsToGuess[indx];
    }

    public void ResetOutput() {
        output = "";
    }

    // Method that receives the player's guess and evaluates whether or not it is a
    // valid input:
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

    // Method that checks if the player's guess exists in the correct word:
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

    // Displays difficulty selection menu and assigns a difficulty according to the
    // input:
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

    public void ResetGame() {
        tries = 6;
        playerGuess = " ";
        playAgain = false;
        won = false;
    }

    public void PrintRules() {
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("> Guess the word by inputting guesses.");
        System.out.println("> The winning word is a 5-letter word.");
        System.out.println("> Guesses must be 5-letter words.");
        System.out.println("> You will have 6 attempts to guess the correct word.");
        System.out.println("> Letters outputted within a [ ] mean the letter exists in the word, but");
        System.out.println("    it is in the wrong spot.");
        System.out.println("> Letters that have been replaced by an X mean they do not exist in the word.");
        System.out.println("> Letters that do not change, mean they are in the correct spot.");
        System.out.println("> If the word is not guessed, within the 6 attempts, you lose.");

        System.out.println("Good Luck!\n");
    }

}
