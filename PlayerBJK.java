/*
 *    This class is for the player, where it creates the player hand and gets the player's total.
 */

import java.util.LinkedList;
import java.util.Queue;
public class PlayerBJK extends Dealer {
    private int total = 0;
    private Queue<Card> playerHand;

    public PlayerBJK() {

    }

    public void CreatePlayerHand() {
        playerHand = new LinkedList<>();
        AddPlayerCard();
        AddPlayerCard();
        System.out.println(" ");
    }

    public void AddPlayerCard() {
        Card newCard = GetDeck().GetDeckCards().pop();
        playerHand.add(newCard);
        total += newCard.GetRankValue(newCard.GetRank(), total);
        System.out.println("Card given: [" + newCard.toString() + "]");
    }

    public Queue<Card> GetPlayerHand() {
        return playerHand;
    }

    public void ClearPlayerHand() {
        playerHand.clear();
    }

    public void PrintPlayerHand() {
        System.out.println("\nYour Hand: ");
        System.out.println("--------------");
        System.out.println(GetPlayerHand());
    }

    public int GetPlayerTotal() {
        return total;
    }

    public void SetPlayerTotal(int newTotal) {
        total = newTotal;
    }

}