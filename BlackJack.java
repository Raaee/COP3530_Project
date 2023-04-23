/*
 * This is a Black Jack game with a resettable deck of cards where the player plays against the dealer. 
 * The player must try to get to 21 without going over. The game continues until the player chooses to stand, 
 * the player goes over 21, or the dealer's hand is worth at least 17. The game has a play-again feature.
 */
public class BlackJack extends PlayerBJK {
    private Input input = new Input();

    private boolean playerWon = false, dealerWon = false, playAgain = true;
    private boolean playersTurn = true, push = false;

    public void PlayGame() throws InterruptedException {
        do {
            ResetGame();
            System.out.println("\n~~ Welcome to a game of Blackjack! ~~");
            PrintRules();
            System.out.print("Starting Game");
            input.Delay("...", 500);
            StartGame();

            while (playersTurn && !playerWon && !dealerWon) {
                PrintHands();
                EvaluateInput();
            }

            if (playerWon || dealerWon || push) {
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
        } else if (dealerWon) {
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
        playAgain = true;
        playersTurn = true;
        MakeDeck();
    }

    public void PrintHands() {
        PrintDealerHand();
        System.out.println("Total: " + GetDealerTotal());
        PrintPlayerHand();
        System.out.println("Total: " + GetPlayerTotal());
    }

    public void EvaluateTotal() {
        if (GetPlayerTotal() == 21 || GetDealerTotal() > 21) {
            playerWon = true;
        }
        if (GetPlayerTotal() > 21 || GetDealerTotal() == 21) {
            dealerWon = true;
        }
        if (!playersTurn && GetPlayerTotal() == GetDealerTotal()) {
            push = true;
            playerWon = false;
            dealerWon = false;
        } else if (!playersTurn && GetPlayerTotal() < GetDealerTotal()) {
            dealerWon = true;
        } else if (!playersTurn && GetPlayerTotal() > GetDealerTotal()) {
            playerWon = true;
        } 
    }

    public void EvaluateInput() throws InterruptedException {
        if (playersTurn) {
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
                    playersTurn = false;
                    DealerTurn();
                }
                case 3 -> PrintRules();
            }
        }
    }

    public void DealerTurn() throws InterruptedException {
        RevealHoleCard();
        if (!dealerWon && GetDealerTotal() != 21) {
            while (GetDealerTotal() < 17) {
                AddDealerCard();
            }
            EvaluateTotal();
        } else {
            EvaluateTotal();
        }
    }

    public void RevealHoleCard() throws InterruptedException {
        System.out.print("\nRevealing Dealer Hole Card");
        input.Delay("...", 400);
        
        System.out.print("Hole Card: ");
        System.out.println(GetHoleCard());
        AddHoleCard();
        
        System.out.println("Dealer's Total: " + GetDealerTotal());
        input.Delay("   ", 200);
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