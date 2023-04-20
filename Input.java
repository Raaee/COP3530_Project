import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/*
 * This file is used to keep all methods that are repeatedly used throughout the project. 
 * This is to prevent repetition of code and to keep things organized.
 */
import java.util.concurrent.TimeUnit;

public class Input {
    public Scanner sc = new Scanner(System.in);

    // This method is used to validate a choice input based on the number of choices
    // there are
    // method returns the choice # that was inputted after it has been validated:
    public int ChoiceInput(int min, int max) {
        boolean valid = false;
        int choice = 0;

        while (!valid) {
            try {
                System.out.println("\nEnter Choice:");
                choice = sc.nextInt();

                if (choice >= min && choice <= max) {
                    valid = true;
                    sc.nextLine();
                } else {
                    System.out.println("That is not an option.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input.");
                sc.nextLine();
            }
        }
        return choice;
    }

    // Method used to ask the player if they would wish to play again after every
    // game:
    public boolean PlayAgain() throws InterruptedException {
        boolean playAgain = false;

        System.out.println("\nChoose an option:");
        System.out.println("1. Play Again");
        System.out.println("2. Return to Main Menu");
        System.out.println("3. Exit");
        int choice = ChoiceInput(1, 3);

        switch (choice) {
            case 1 -> playAgain = true;
            case 2 -> Main.Instance().MainMenu();
            case 3 -> {
                System.out.println("Goodbye!\n");
                System.exit(0);
            }
        }
        return playAgain;
    }

    public String DifficultyMenu() {
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
        return difficulty;
    }

    // Generates random number:
    public int GetRandomNum(int origin, int bound) {
        Random ranNum = new Random();
        return ranNum.nextInt(bound - origin + 1) + origin; // Bound and Origin are included in random num
    }

    public char GetRandomChar(char start, char end) {
        return (char) GetRandomNum((int) 'A', (int) 'J');
    }

    public boolean ReprintRules(Object playerGuess) {
        if (playerGuess.toString().equalsIgnoreCase("Rules")) {
            return true;
        } else {
            return false;
        }
    }

    // MESSAGE ** MUST ** BE A 3 CHARACTER STRING:
    public void Delay(String message, int timeoutInMiliseconds) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(timeoutInMiliseconds / 2);
        System.out.print(message.charAt(0));
        TimeUnit.MILLISECONDS.sleep(timeoutInMiliseconds);
        System.out.print(message.charAt(1));
        TimeUnit.MILLISECONDS.sleep(timeoutInMiliseconds);
        System.out.println(message.charAt(2));
        TimeUnit.MILLISECONDS.sleep(timeoutInMiliseconds);
    }

}