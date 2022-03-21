package blackjack.domain.card.factory;

import blackjack.domain.card.Card;
import java.util.List;
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
