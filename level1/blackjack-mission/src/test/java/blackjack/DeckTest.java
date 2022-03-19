package blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    @DisplayName("카드를 줄 수 있다")
    void test1() {
        ArrayDeque<Card> cards = new ArrayDeque<>(List.of(new Card(4), new Card(7)));
        Deck deck = new Deck(cards);

        List<Card> findCards = new ArrayList<>();
        for (Card c : cards) {
            Card findCard = deck.drawCard();
            findCards.add(findCard);
        }

        assertThat(findCards).contains(new Card(7), new Card(4));
        assertThat(findCards).contains(new Card(7));
    }
}
