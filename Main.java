/*
 * This is the main menu class. This file holds main and is the class that displays and manages the 3
 * type of games available to play.
 */
public class Main {

    // Game Instance Variables:
    // add to this as more games are made . . .
    private static Womble womble = new Womble();
    private static RockPaperScissors rps = new RockPaperScissors();
    private static FortuneTeller fortune = new FortuneTeller();
    private static Battleships bships = new Battleships();
    private static BlackJack blackJack = new BlackJack();

    // Main Menu Variables:
    private static Main Instance = new Main();
    private static Input input = new Input();

    public static void main(String[] args) throws InterruptedException {
        MainMenu();
    }

    // Separate MainMenu method is used to allow the main menu to be displayed when
    // the player wishes
    // to return to the main menu:
    public static void MainMenu() throws InterruptedException {
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
        System.out.println("4. Battleships");
        System.out.println("5. Blackjack");

    }

    // Method that starts the actual game based on the player's choice:
    public static void StartGame(int choice) throws InterruptedException {
        switch (choice) {
            case 1 -> rps.PlayGame();
            case 2 -> fortune.PlayGame();
            case 3 -> womble.PlayGame();
            case 4 -> bships.PlayGame();
            case 5 -> blackJack.PlayGame();
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