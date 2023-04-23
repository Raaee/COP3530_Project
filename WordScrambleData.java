/* 
* This is a class that provides a list of words to be used in the Word Scramble game. 
* It includes methods to retrieve the list of words, display them to the user, randomly 
* select words to be scrambled, and scramble the words. The class also includes an inner 
* Input class that generates random numbers for word selection and scrambling.
*/

import java.util.ArrayList;
import java.util.List;

public class WordScrambleData {

    public Input input = new Input();

    private String[] words = { "sunshine", "elephant", "bicycle", "telephone", "chocolate",
            "computer", "mountain", "butterfly", "rainbow", "guitar",
            "bigmatic", "quagmire", "funny", "bright", "debt", "inevitable", "paradox",
            "magnanimous", "enfarious", "disseminate", "frivolous", "luminous", "pernicious" };

    public String[] GetWordList() {
        return words;
    }

    public void ShowWords(List<String> words) {
        System.out.println("--------------");
        for (int i = 0; i < words.size(); i++) {
            System.out.println((i + 1) + ". " + words.get(i));
        }
    }

    public List<String> AddWords(int amtWords) {
        List<String> wordsToGuess = new ArrayList<>();

        for (int i = 0; i < amtWords; i++) {
            int randomIndx = input.GetRandomNum(0, GetWordList().length - 1);
            wordsToGuess.add(GetWordList()[randomIndx]);
        }
        return wordsToGuess;
    }

    public List<String> ScrambleWords(List<String> words) {
        List<String> scrambledWords = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            char[] chars = words.get(i).toCharArray();

            for (int n = 0; n < chars.length; n++) {
                int ranIndx = input.GetRandomNum(0, chars.length - 1);
                char temp = chars[i];
                chars[i] = chars[ranIndx];
                chars[ranIndx] = temp;
            }
            scrambledWords.add(new String(chars));
        }
        return scrambledWords;
    }

}