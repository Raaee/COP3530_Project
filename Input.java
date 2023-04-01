import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * This file is used to keep all methods that are repeated used throughout the project. 
 * This is to prevent repition of code and to keep things organized.
 */

public class Input {
    private static Scanner sc = new Scanner(System.in);

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

    public boolean PlayAgain() {
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

}
