import java.util.Stack;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// Dealer class can have:
//     - card
//     - deck
//     - dealer moves

/*
 * Hashmap, stack n queue for card deck
 */
public class Dealer {
    private Input input = new Input();
    private Deck deck;
    private Queue<Card> dealerHand;

    public Dealer() {
        deck = new Deck();
        deck.ShuffleDeck();
        CreateDealerHand();
    }

    public void CreateDealerHand() {
        dealerHand = new LinkedList<>();
        AddDealerCard();
    }

    public void AddDealerCard() {
        dealerHand.add(deck.GetDeckCards().pop());
    }

    public Deck GetDeck() {
        return deck;
    }

    public Queue<Card> GetDealerHand() {
        return dealerHand;
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

    public int GetRankValue(String rank) {
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
            default -> value = 0;
        }
        return value;
    }
}