package blackjack;

import java.util.ArrayDeque;
import java.util.List;

public class MockDeck extends Deck {

    public MockDeck(Card... cards) {
        super(new ArrayDeque<>(List.of(cards)));
    }
}
