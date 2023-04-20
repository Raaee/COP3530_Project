import java.util.Queue;
/*
 *    summary
 */
public class BlackJack extends PlayerBJK {
    private Input input = new Input();

    private boolean playerWon = false, dealerWon = false, playAgain = true, bust = false;
    private boolean canPlay = true, push = false;

    public void PlayGame() throws InterruptedException {
        do {
            ResetGame();
            System.out.println("\n~~ Welcome to a game of Blackjack! ~~");
            PrintRules();
            System.out.print("Starting Game");
            input.Delay("...", 500);
            StartGame();

            while (canPlay && !bust && !playerWon && !dealerWon) {
                PrintHands();
                EvaluateInput();
            }

            if (bust || playerWon || dealerWon || push) {
                PrintHands();
                WinningMessage();
                playAgain = input.PlayAgain();
            }
        } while (playAgain);
    }

    public void StartGame() {
        System.out.println(" ");
        CreateDealerHand();
        CreatePlayerHand();
    }

    public void WinningMessage() {
        if (playerWon) {
            System.out.println("\nCongrats! You Win ~ *");
        } else if (dealerWon || bust) {
            System.out.println("\nDealer wins.");
        } else if (push) {
            System.out.println("\nTie.");
        }
    }

    public void ResetGame() {
        SetDealerTotal(0);
        SetPlayerTotal(0);
        dealerWon = false;
        playerWon = false;
        bust = false;
        playAgain = true;
        canPlay = true;
        MakeDeck();
    }

    public void PrintHands() {
        PrintDealerHand();
        System.out.println("Total: " + GetDealerTotal());
        PrintPlayerHand();
        System.out.println("Total: " + GetPlayerTotal());
    }

    public void EvaluateTotal() {
        if (GetPlayerTotal() == 21) {
            playerWon = true;
        }
        if (GetPlayerTotal() > 21) {
            dealerWon = true;
        }
        if (GetDealerTotal() > 21) {
            playerWon = true;
        }
        if (GetDealerTotal() == 21) {
            dealerWon = true;
        }
        if (!canPlay && GetPlayerTotal() == GetDealerTotal()) {
            push = true;
            playerWon = false;
            dealerWon = false;
        } else if (!canPlay && GetPlayerTotal() > GetDealerTotal()) {
            playerWon = true;
        } else if (!canPlay && GetPlayerTotal() < GetDealerTotal()) {
            dealerWon = true;
        }

    }

    public void EvaluateInput() throws InterruptedException {
        if (canPlay) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("3. Print Rules");

            switch (input.ChoiceInput(1, 3)) {
                case 1 -> {
                    AddPlayerCard();
                    EvaluateTotal();
                    System.out.println(" ");
                }
                case 2 -> {
                    canPlay = false;
                    DealerTurn();
                }
                case 3 -> PrintRules();
            }
        }
    }

    public void DealerTurn() throws InterruptedException {
        RevealHoleCard();
        if (!dealerWon && !(GetDealerTotal() == 21)) {
            while (GetDealerTotal() < 17) {
                AddDealerCard();
            }
            EvaluateTotal();
        } else {
            return;
        }
    }

    public void RevealHoleCard() throws InterruptedException {
        System.out.print("\nRevealing Dealer Hole Card");
        input.Delay("...", 400);
        System.out.print("Hole Card: ");
        System.out.println(GetHoleCard());
        AddHoleCard();
        System.out.println("Dealer's Total: " + GetDealerTotal());
        EvaluateTotal();
        input.Delay("   ", 200);
    }

    public int WhichTotal(Queue<Card> hand, int total) {
        for (Card card : hand) {
            if (card.GetRank().equalsIgnoreCase("Ace") && total < 10) {
                total += 11;
            } else if (card.GetRank().equalsIgnoreCase("Ace") && total > 1) {
                total += 1;
            } else {
                total += card.GetRankValue(card.GetRank(), total);
            }
        }
        return total;
    }

    public void PrintRules() {
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("> This is a game of 21. You will be playing against the dealer.");
        System.out.println("> You will be dealt cards and your goal is to get to 21 without going over.");

        System.out.println("\n> At the beginning of the game, you will be delt 2 cards.");
        System.out.println("> The dealer will also be dealt 2 cards; however, one card is a hole card.");
        System.out.println("> The hole card is not revealed until after you have stood.");
        System.out.println("> During the game, you can 'hit' to receive another card or 'stand' to keep your hand.");
        System.out.println("> After you have stood, the hole card is revealed.");
        System.out.println("> If the dealer's hand + the hole card is a blackjack (21), they win.");
        System.out.println("> However, if it is not a blackjack, the dealer will hit.");
        System.out.println("> First player to 21 or closest to 21: wins.");

        System.out.println(" ");
        System.out.println("> Face cards (Jack, Queen, King) are worth 10.");
        System.out.println("> Aces are worth 1 or 11.");
        System.out.println("> Number cards keep their values.");

        System.out.println("\nGood Luck!\n");
    }
}