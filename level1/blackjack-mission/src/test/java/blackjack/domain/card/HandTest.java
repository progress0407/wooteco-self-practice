package blackjack.domain.card;

import static blackjack.domain.card.Denomination.ACE;
import static blackjack.domain.card.Denomination.JACK;
import static blackjack.domain.card.Denomination.NINE;
import static blackjack.utils.CreationUtils.createCards;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandTest {

    @ParameterizedTest
    @MethodSource("supplyCardScore")
    @DisplayName("카드의 합계를 계산한다")
    void test(List<Card> cards) {
        Hand hand = new Hand(cards);
        Assertions.assertThat(hand.score()).isEqualTo(21);
    }

    public static Stream<Arguments> supplyCardScore() {
        return Stream.of(
                Arguments.of(createCards(ACE, JACK)),
                Arguments.of(createCards(ACE, ACE, NINE))
        );
    }
}
