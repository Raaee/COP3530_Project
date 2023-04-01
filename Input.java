import java.util.InputMismatchException;
import java.util.Scanner;

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

}
