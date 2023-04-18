import java.util.Queue;
import java.util.Scanner;

public class BlackJack extends PlayerBJK {
    private Input input = new Input();
    private Scanner sc = new Scanner(System.in);

    private int playerTotal = 0, dealerTotal = 0;

    public void PrintHands() {
        System.out.println("Dealer Hand: " + GetDealerHand());
        System.out.println("Player Hand: " + GetPlayerHand());
    }

    public void PlayGame() {
        PrintHands();
        AddTotal("dealer");
        AddTotal("player");

        System.out.println("\nDealer Total: " + dealerTotal);
        System.out.println("Player Total: " + playerTotal);

    }

    public void AddTotal(String whichHand) {
        whichHand = whichHand.toUpperCase();
        switch (whichHand) {
            case "PLAYER" -> playerTotal = WhichTotal(GetPlayerHand(), playerTotal);
            case "DEALER" -> dealerTotal = WhichTotal(GetDealerHand(), dealerTotal);
        }
    }

    public int WhichTotal(Queue<Card> hand, int total) {
        for (Card card : hand) {
            if (card.GetRank().equalsIgnoreCase("Ace") && total < 10) {
                total += 11;
            } else if (card.GetRank().equalsIgnoreCase("Ace") && total > 1) {
                total += 1;
            } else {
                total += card.GetRankValue(card.GetRank());
            }
        }
        return total;
    }

}