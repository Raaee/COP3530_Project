/*
 * This is the main menu class. This file holds main and is the class that displays and manages the 
 * type of games available to play.
 */
public class Main {

    // Game Instance Variables:
    // add to this as more games are made . . .
    private static Womble womble = new Womble();
    private static RockPaperScissors rps = new RockPaperScissors();

    private static FortuneTeller fortune = new FortuneTeller();

    // Main Menu Variables:
    private static Main Instance = new Main();
    private static Input input = new Input();

    public static void main(String[] args) {
        MainMenu();
    }

    // Separate MainMenu method is used to allow the main menu to be displayed when
    // the player wishes
    // to return to the main menu:
    public static void MainMenu() {
        PrintMenu();
        StartGame(input.ChoiceInput(1, 5));
    }

    // Displays Main Menu of all available games:
    public static void PrintMenu() {
        System.out.println("\nMain Menu");
        System.out.println("--------------");
        System.out.println("1. Rock Paper Scissors");
        System.out.println("2. Fortune Teller");
        System.out.println("3. Womble");
        System.out.println("4. ---");
        System.out.println("5. ---");

    }

    // Method that starts the actual game based on the player's choice:
    public static void StartGame(int choice) {
        switch (choice) {
            case 1 -> rps.PlayGame();
            case 2 -> fortune.PlayGame();
            case 3 -> womble.PlayGame();
            case 4 -> System.out.println("Game in progress...");
            case 5 -> System.out.println("Game in progress...");
        }
    }

    // Singleton Instance Stuff:
    private Main() {
    }

    public static Main Instance() {
        if (Instance == null) {
            Instance = new Main();
        }
        return Instance;
    }
}