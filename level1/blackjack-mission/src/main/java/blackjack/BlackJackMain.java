package blackjack;

import blackjack.controller.BlackjackGame;

public class BlackJackMain {
    public static void main(final String... args) {
        BlackjackGame blackJackGame = new BlackjackGame();
        blackJackGame.run();
    }
}
