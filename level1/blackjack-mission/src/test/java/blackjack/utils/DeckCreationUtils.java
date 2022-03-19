package blackjack.utils;

import blackjack.Card;
import blackjack.MockDeck;
import java.util.Arrays;

public class DeckCreationUtils {

    public static MockDeck createMockDeck(int... scores) {

        Card[] cards = Arrays.stream(scores)
                .boxed()
                .map(score -> new Card(score))
                .toArray(Card[]::new);

        return new MockDeck(cards);
    }
}
