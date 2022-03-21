package blackjack.domain.card.factory;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardFactory {

    private CardFactory() {
    }

    public static List<Card> createBlackjackDeck() {
        return Arrays.stream(Denomination.values())
                .flatMap(denomination -> Arrays.stream(Suit.values())
                        .map(suit -> new Card(denomination, suit)))
                .collect(Collectors.toList());
    }
}
