package blackjack.domain.card;

import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void test() {
        Card card = new Card(Denomination.JACK, Suit.CLOVER);
        System.out.println("card = " + card.name());
        System.out.println("card.getScore() = " + card.score());
    }
}
