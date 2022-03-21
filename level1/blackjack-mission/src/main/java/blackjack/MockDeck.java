package blackjack;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import java.util.ArrayDeque;
import java.util.List;

public class MockDeck extends Deck {

    public MockDeck(Card... cards) {
        super(new ArrayDeque<>(List.of(cards)));
    }
}
