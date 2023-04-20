import java.util.Stack;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 *    SUMMARY OF CLASS GOES HERE
 */
public class Dealer {
    private Deck deck;
    private Queue<Card> dealerHand;
    private Card holeCard;
    private int total = 0;

    public Dealer() {
        MakeDeck();
    }

    public void MakeDeck() {
        deck = new Deck();
        deck.ShuffleDeck();
    }

    public void CreateDealerHand() {
        dealerHand = new LinkedList<>();
        AddDealerCard();
        holeCard = deck.GetDeckCards().pop();
    }

    public void AddDealerCard() {
        Card newCard = deck.GetDeckCards().pop();
        dealerHand.add(newCard);
        total += newCard.GetRankValue(newCard.GetRank(), total);
    }

    public void AddHoleCard() {
        dealerHand.add(holeCard);
        total += holeCard.GetRankValue(holeCard.GetRank(), total);
    }

    public Deck GetDeck() {
        return deck;
    }

    public Queue<Card> GetDealerHand() {
        return dealerHand;
    }

    public void PrintDealerHand() {
        System.out.println("Dealer's Hand: ");
        System.out.println("--------------");
        System.out.println(GetDealerHand());
    }

    public int GetDealerTotal() {
        return total;
    }

    public void SetDealerTotal(int newTotal) {
        total = newTotal;
    }

    public void ClearDealerHand() {
        dealerHand.clear();
    }

    public String GetHoleCard() {
        return "[" + holeCard.toString() + "]";
    }
}

class Deck {
    private Stack<Card> deck;

    public Deck() {
        deck = new Stack<>();
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                deck.push(card);
            }
        }
    }

    public void ShuffleDeck() {
        Collections.shuffle(deck);
    }

    public Stack<Card> GetDeckCards() {
        return deck;
    }

    public String toString() {
        String s = "Deck{ ";
        for (Card card : deck) {
            s += card + ", ";
        }
        s += " }";
        return s;
    }
}

class Card {
    // There are 52 cards in a deck:
    private String rank; // number or name
    private String suit; // symbol
    /*
     * > Clubs
     * > Diamonds
     * > Hearts
     * > Spades
     */

    public Card(String cardSuit, String cardRank) {
        rank = cardRank;
        suit = cardSuit;
    }

    public Card() {
        rank = "noRank";
        suit = "noSuit";
    }

    public String GetRank() {
        return rank;
    }

    public String GetSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public int GetRankValue(String rank, int total) {
        int value;
        switch (rank) {
            case "2" -> value = 2;
            case "3" -> value = 3;
            case "4" -> value = 4;
            case "5" -> value = 5;
            case "6" -> value = 6;
            case "7" -> value = 7;
            case "8" -> value = 8;
            case "9" -> value = 9;
            case "10" -> value = 10;
            case "Jack", "Queen", "King" -> value = 10;
            case "Ace" -> {
                if (total <= 10) {
                    value = 11;
                } else {
                    value = 1;
                }
            }
            default -> value = 0;
        }
        return value;
    }
}