import java.util.ArrayList;
import java.util.List;

/* 
 * This is a word scramble game. 
 */

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


    
}
