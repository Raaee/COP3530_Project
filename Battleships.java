import java.util.HashMap;

import javax.swing.CellEditor;

public class Battleships {

    private BattleshipsData bsData = new BattleshipsData();

    public void PlayGame() {
        // CreateBoard();
        // DisplayBoard();
        PlaceShips();
    }

    public void CreateBoard() {
        bsData.CreateBoard("-");
    }

    public void DisplayBoard() {
        bsData.DisplayBoard();
    }

    public void PlaceShips() {
        bsData.PlaceShips();
    }

    public void PrintRules() {
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("> ");
    }

}