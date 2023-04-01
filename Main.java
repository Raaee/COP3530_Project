public class Main {

    // Game Instance Variables:
    // add to this as more games are made . . .
    private static Womble womble = new Womble();
    private static RockPaperScissors rps = new RockPaperScissors();

    // Main Menu Variables:
    private static Main Instance = new Main();
    private static Input input = new Input();

    private Main() {

    }

    public static Main Instance() {
        if (Instance == null) {
            Instance = new Main();
        }
        return Instance;
    }

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        PrintMenu();
        StartGame(input.ChoiceInput(1, 5));
    }

    public static void PrintMenu() {
        System.out.println("\nMain Menu");
        System.out.println("--------------");
        System.out.println("1. Rock Paper Scissors");
        System.out.println("2. Womble");
        System.out.println("3. ---");
        System.out.println("4. ---");
        System.out.println("5. ---");

    }

    public static void StartGame(int choice) {
        switch (choice) {
            case 1 -> rps.PlayGame();
            case 2 -> womble.PlayGame();
            case 3 -> System.out.println("Game in progress...");
            case 4 -> System.out.println("Game in progress...");
            case 5 -> System.out.println("Game in progress...");
        }
    }
}