package blackjack.utils;

import static blackjack.domain.card.Suit.CLOVER;

import blackjack.domain.card.Card;
import blackjack.MockDeck;
import blackjack.domain.card.Denomination;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreationUtils {

    public static Card createCard(Denomination denomination) {
        return new Card(denomination, CLOVER);
    }

    public static List<Card> createCards(Denomination... denominations) {
        List<Card> cards = new ArrayList<>();;
        for (Denomination denomination : denominations) {
            cards.add(new Card(denomination, CLOVER));
        }
        return cards;
    }

    public static MockDeck createMockDeck(Denomination... denominations) {

        Card[] cards = Arrays.stream(denominations)
                .map(denomination -> new Card(denomination, CLOVER))
                .toArray(Card[]::new);

        return new MockDeck(cards);
    }
}
