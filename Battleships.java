public class Battleships extends BattleshipsData {

    private Input input = new Input();
    private String playerGuess;

    public void PlayGame() {
        System.out.println("\n\t ~~ Welcome to a game of Battleship! ~~");

        CreateBoard("=");
        PrintRules();
        DifficultyMenu();
        // DisplayBoard(true); // TEMP FOR DEBUGGING

        while (GetAmtHitsToWin() > 0) {
            DisplayBoard(false);
            DisplayShipsOnBattlefield();
            System.out.println("\nAmount hits to win: " + GetAmtHitsToWin());
            System.out.println("Total moves made: " + GetAmtMoves());
            GetPlayerGuess();
        }
        if (GetAmtHitsToWin() < 1) {
            String spaces = "     ";
            DisplayBoard(false);
            System.out.println("\t\t" + spaces + "Congrats! You won! ~ *\n\n");
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
            if (!playerGuess.matches("[a-jA-J]\\d") && !playerGuess.equalsIgnoreCase("Rules")) {
                System.out.println("~~ Location must be a letter followed by a number. ~~");
                System.out.println("~~ Letter must be within the board coordinates. ~~");
                loop = true;
            }
        } while (loop);
        playerGuess = playerGuess.toUpperCase();

        switch (playerGuess) {
            case "RULES" -> PrintRules();
            default -> CheckPosition();
        }
    }

    public void DifficultyMenu() {
        switch (input.DifficultyMenu()) {
            case "1" -> PlaceShips(10);
            case "2" -> PlaceShips(7);
            case "3" -> PlaceShips(1);
        }
    }

    public void PrintRules() {
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("> You will guess the location of ships in the battlefield.");
        System.out.println("> To guess a location to hit, use \"A0\" formatting");
        System.out.println("> Spaces with a \"-\" mean it has not been guessed.");
        System.out.println("> Spaces that have been replaced by a \"~\" mean there is no ship in that location");
        System.out.println("> Spaces replaced by an \"x\" mean a ship has been hit.");
        System.out.println("> Hit all ship points to win.");
        System.out.println("** If at anytime you wish to see the rules again, type in \"Rules\" **\n");
    }

}