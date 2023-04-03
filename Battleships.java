public class Battleships extends BattleshipsData {

    private Input input = new Input();
    private String playerGuess;

    public void PlayGame() {
        System.out.println("\n\t ~~ Welcome to a game of Battleship! ~~");

        CreateBoard("-");
        DifficultyMenu();
        DisplayBoard(true);

        while (GetAmtHitsToWin() > 0) {
            DisplayBoard(false);
            System.out.println("Amount hits to win: " + GetAmtHitsToWin());
            GetPlayerGuess();
            CheckPosition();
        }

    }

    public void DisplayBoard(boolean boardWithShips) {
        String spaces = "     ";
        System.out.println("\t\t" + spaces + "The Battlefield:\n");
        DisplayGameBoard(boardWithShips);
    }

    public void CheckPosition() {
        CheckPosition(playerGuess.charAt(0),
                Integer.valueOf(Character.toString(playerGuess.charAt(1))));
    }

    public void GetPlayerGuess() {
        boolean loop;
        do {
            loop = false;
            System.out.println("\nEnter location to hit:");
            System.out.print("> ");
            playerGuess = input.sc.nextLine();
            if (!playerGuess.matches("[a-zA-Z]\\d")) {
                System.out.println("Location must be a letter followed by a number.");
                loop = true;
            }
        } while (loop);
        playerGuess = playerGuess.toUpperCase();
    }

    public void DifficultyMenu() {
        switch (input.DifficultyMenu()) {
            case "1" -> PlaceShips(10);
            case "2" -> PlaceShips(7);
            case "3" -> PlaceShips(4);
        }
    }

    public void PrintRules() {
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("> To guess a location to hit, use \"A0\" formatting");
    }

}