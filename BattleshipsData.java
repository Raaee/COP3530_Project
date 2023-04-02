import java.util.HashMap;
import java.util.List;

public class BattleshipsData {

    private Input input = new Input();
    private final int BOARD_SIZE = 10;
    private HashMap<String, List<String>> board;

    public void CreateBoard(String value) {
        board = new HashMap<>();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (char c = 'A'; c < 'A' + BOARD_SIZE; c++) {
                board.put(c + Integer.toString(i), value); // MUST FIX TO FIT A CHAINING HASHMAP
            }
        }
    }

    public void DisplayBoard() {
        int cellWidth = 5;

        // Displays Numbers
        PrintPaddedValue(cellWidth, "");
        for (int i = 0; i < BOARD_SIZE; i++) {
            PrintPaddedValue(cellWidth, Integer.toString(i));
        }
        System.out.println("");

        // Displays Letters and Board Info
        System.out.println(" ");
        for (char c = 'A'; c < 'A' + BOARD_SIZE; c++) {
            PrintPaddedValue(cellWidth, Character.toString(c));
            for (int i = 0; i < BOARD_SIZE; i++) {
                PrintPaddedValue(cellWidth, board.get(c + Integer.toString(i)));
            }
            System.out.println("\n");
        }
    }

    public void PrintPaddedValue(int cellWidth, String cellValue) {
        System.out.print(String.format("%" + cellWidth + "s", cellValue));
    }

    public void PlaceShips() {
        char randomLetter = input.GetRandomChar('A', 'J');
        System.out.println(randomLetter);
    }
}
