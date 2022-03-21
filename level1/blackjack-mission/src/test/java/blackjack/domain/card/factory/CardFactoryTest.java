package blackjack.domain.card.factory;

import static java.lang.System.out;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardFactoryTest {

    @Test
    @DisplayName("카드를 52장 생성한다")
    void card_generate() {
    	List<Card> cards = CardFactory.createBlackjackDeck();

        Assertions.assertThat(cards.size()).isEqualTo(52);
    }
}
