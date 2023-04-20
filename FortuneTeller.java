/*
 * Fortune teller game based off Magic 8 Ball. Player asks a question and receives an answer
 * that is along the lines of yes or no.
 */

 class FortuneTeller {

    private String question;
    private String whom;
    private boolean playAgain = true;
    private boolean gameOver = false;

    private Input input = new Input();

    // Acts as the "main" method for this game class:
    public void PlayGame() throws InterruptedException {

        System.out.println("\n~~ Greetings! We are your Fortune Teller ~~");
        System.out.println("\t     Ask us anything.");
        PrintRules();
        whom = QuestioningWho();

        do {
            playAgain = true;
            GetQuestion();

            if (gameOver) {
                playAgain = input.PlayAgain();
                whom = QuestioningWho();
            }
        } while (playAgain);
    }

    // Method that receives the player's question:
    public void GetQuestion() {
        boolean valid = false;
        // whom = QuestioningWho();

        while (!valid) {
            System.out.println("\nWhat is it you wish to ask " + whom + "?");
            System.out.print("> ");
            question = input.sc.nextLine();
            question = question.toUpperCase();

            switch (question) {
                case "RULES" -> PrintRules();
                default -> {
                    String[] words = question.split("\\s+");

                    if (words.length > 0 && !words[0].isEmpty()) {
                        valid = true;
                    } else {
                        System.out.println("Your silence is not a question.");
                    }
                }
            }
        }
        GiveAnswer();
    }

    // Method that displays the answer to the question:
    public void GiveAnswer() {
        String[] answers = { "Yes", "No", "Possibly", "Not soon", "Soon", "In near futures",
                "Yes", "Always", "Tomorrow", "No", "Likely not", "Yes", "Never", "No", "It is possible" };
        int randomNum = input.GetRandomNum(0, answers.length - 1);
        String answer = answers[randomNum];

        System.out.println(answer);
        gameOver = true;

    }

    // This method is used to give some variation in the messages displayed for the
    // game:
    public String QuestioningWho() {
        String[] who = { "the universe", "your future self", "your past self", "the world", "the gods",
                "your guides", "the devil themself", "your parents" };
        return who[input.GetRandomNum(0, who.length - 1)];
    }

    public void PrintRules() {
        System.out.println("\nRules:");
        System.out.println("------------");
        System.out.println("Ask a question; receive an answer.");
        System.out.println("Our words do not lie.");
        System.out.println("However, our powers limit us in communication.");
        System.out.println("We can only respond with minimal words.");
        System.out.println("** If at anytime you wish to see the rules again, type in \"Rules\" **\n");
    }

}