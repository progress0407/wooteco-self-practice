package blackjack;

import static blackjack.utils.CreationUtils.createCard;
import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.Denomination;
import blackjack.utils.CreationUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    @DisplayName("카드를 줄 수 있다")
    void test1() {

        ArrayDeque<Card> cards = new ArrayDeque<>(List.of(createCard(Denomination.FOUR), createCard(Denomination.SEVEN)));
        Deck deck = new Deck(cards);

        List<Card> findCards = new ArrayList<>();
        for (Card c : cards) {
            Card findCard = deck.drawCard();
            findCards.add(findCard);
        }

        assertThat(findCards).contains(createCard(Denomination.FOUR), createCard(Denomination.SEVEN));
    }
}
