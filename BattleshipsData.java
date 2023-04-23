import java.util.HashMap;
/*
 * This is class utilizes HashMaps to create and manage the game board of the Battleships class.
 * It includes methods to create the game board, display it, place ships on it, and print padded values. 
 * It also keeps track of the number of ships present in the game and the number of hits required to win the game.
 */
public class BattleshipsData {

    private Input input = new Input();
    private final int BOARD_SIZE = 10;
    private HashMap<String, String> board_withShips;
    private HashMap<String, String> bareBoard;
    private HashMap<Integer, Integer> amtShipsOnBoard;
    private final String hit = "x";
    private final String miss = "~";
    private int amtHitsToWin = 0;
    private int amtMoves = 0;
    private String boardSpaceValue;

    public void CreateBoard(String value) {
        boardSpaceValue = value;
        board_withShips = new HashMap<>();
        bareBoard = new HashMap<>();
        amtShipsOnBoard = new HashMap<>();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (char c = 'A'; c < 'A' + BOARD_SIZE; c++) {
                board_withShips.put(c + Integer.toString(i), value);
                bareBoard.put(c + Integer.toString(i), value);
            }
        }
        for (int i = 1; i <= 5; i++) {
            amtShipsOnBoard.put(i, 0);
        }
    }

    public void DisplayGameBoard(boolean boardWithShips) {
        int cellWidth = 5;

        // Displays Numbers
        PrintPaddedValue(cellWidth, "X");
        for (int i = 0; i < BOARD_SIZE; i++) {
            PrintPaddedValue(cellWidth, Integer.toString(i));
        }
        System.out.println("\n");

        // Displays Letters and Board Info
        for (char c = 'A'; c < 'A' + BOARD_SIZE; c++) {
            PrintPaddedValue(cellWidth, Character.toString(c));
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (boardWithShips) {
                    PrintPaddedValue(cellWidth, board_withShips.get(c + Integer.toString(i)));
                } else {
                    PrintPaddedValue(cellWidth, bareBoard.get(c + Integer.toString(i)));
                }
            }
            System.out.println("\n");
        }
    }

    public void DisplayShipsOnBattlefield() {
        System.out.println("\nAmount of ships present in the battlefield:");
        System.out.println("----------------");
        for (int key : amtShipsOnBoard.keySet()) {
            System.out.println("Ship Size " + key + ":   " +
                    amtShipsOnBoard.get(key));
        }
    }

    public void PrintPaddedValue(int cellWidth, String cellValue) {
        System.out.print(String.format("%" + cellWidth + "s", cellValue));
    }

    public void PlaceShips(int numShips) {
        int[] shipSizes = { 1, 2, 3, 4, 5 };

        for (int i = 0; i < numShips; i++) {
            boolean validPos = true;

            // Variables:
            char randomLetter = input.GetRandomChar('A', 'J');
            int randIndx = input.GetRandomNum(0, shipSizes.length - 1);
            int shipSize = shipSizes[randIndx];

            int row = GetRowNumber(randomLetter);
            int col = input.GetRandomNum(0, BOARD_SIZE);
            int direction = input.GetRandomNum(0, 1);

            if (direction == 0) { // Horizontal direction
                if (col + shipSize > BOARD_SIZE) {
                    validPos = false;
                } else {
                    for (int n = col; n < col + shipSize; n++) {

                        // Check current space
                        if (!board_withShips.get(Character.toString(randomLetter) + Integer.toString(n))
                                .equals(boardSpaceValue)) {
                            validPos = false;
                            break;
                        }
                        // Checks if spaces to the left are valid
                        if (n > 0
                                && !board_withShips.get(Character.toString(randomLetter) + Integer.toString(n - 1))
                                        .equals(boardSpaceValue)) {
                            validPos = false;
                            break;
                        }
                        // Check if spaces to the right are valid
                        if (n < BOARD_SIZE - 1
                                && !board_withShips.get(Character.toString(randomLetter) + Integer.toString(n + 1))
                                        .equals(boardSpaceValue)) {
                            validPos = false;
                            break;
                        }
                    }
                }
                if (validPos) {
                    for (int q = col; q < col + shipSize; q++) {
                        board_withShips.put(Character.toString(randomLetter) + Integer.toString(q),
                                Integer.toString(shipSize));
                    }
                    amtShipsOnBoard.put(shipSize, amtShipsOnBoard.get(shipSize) + 1);
                    amtHitsToWin += shipSize;
                }

            } else if (direction == 1) { // Vertical direction
                if (row + shipSize > BOARD_SIZE) {
                    validPos = false;
                } else {
                    for (int o = row; o < row + shipSize; o++) {
                        for (int c = 0; c < BOARD_SIZE; c++) {
                            if (!board_withShips.get(Character.toString((char) ('A' + c)) + Integer.toString(o))
                                    .equals(boardSpaceValue)) {
                                validPos = false;
                                break;
                            }
                        }
                    }
                    if (validPos) {
                        for (int x = row; x < row + shipSize; x++) {
                            board_withShips.put(Character.toString((char) ('A' + x)) + Integer.toString(col),
                                    Integer.toString(shipSize));
                        }
                        amtShipsOnBoard.put(shipSize, amtShipsOnBoard.get(shipSize) + 1);
                        amtHitsToWin += shipSize;
                    }
                }
            }
            if (!validPos) {
                i--;
                validPos = true;
            }
        }
    }

    public int GetRowNumber(char letter) {
        int rowNumber = -1;
        if (letter >= 'A' && letter <= 'J') {
            rowNumber = letter - 'A';
        }
        return rowNumber;
    }

    public void CheckPosition(char row, int col) {
        if (!board_withShips.get(Character.toString(row) + Integer.toString(col)).equals(boardSpaceValue)) {
            bareBoard.put(Character.toString(row) + Integer.toString(col), hit);
            System.out.println("Hit! ~ *");
            amtHitsToWin--;
            amtMoves++;
        } else {
            bareBoard.put(Character.toString(row) + Integer.toString(col), miss);
            System.out.println("x ~ Miss.");
            amtMoves++;
        }
    }

    public int GetAmtHitsToWin() {
        return amtHitsToWin;
    }

    public int GetAmtMoves() {
        return amtMoves;
    }

    public void SetAmtMoves(int n) {
        amtMoves = n;
    }
}
