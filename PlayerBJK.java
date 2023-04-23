/*
 * This is a Black Jack class that uses a LinkedList and a Queue to manage the player's hand of cards. 
 * The PlayerBJK class extends the Dealer class and has methods to create the player's hand, 
 * add cards to the hand, clear the hand, print the hand, and get and set the total value of the hand.
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