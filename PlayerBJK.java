import java.util.LinkedList;
import java.util.Queue;

/*
 * Player class can have:
- hand
- move
 */
public class PlayerBJK extends Dealer {
    private Queue<Card> playerHand;

    public PlayerBJK() {
        CreatePlayerHand();
    }

    public void CreatePlayerHand() {
        playerHand = new LinkedList<>();
        AddPlayerCard();
        AddPlayerCard();
    }

    public void AddPlayerCard() {
        playerHand.add(GetDeck().GetDeckCards().pop());
    }

    public Queue<Card> GetPlayerHand() {
        return playerHand;
    }

}