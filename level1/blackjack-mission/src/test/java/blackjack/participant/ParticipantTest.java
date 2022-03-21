package blackjack.participant;

import static blackjack.domain.card.Denomination.EIGHT;
import static blackjack.utils.CreationUtils.createCard;
import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    private Participant participant;

    @BeforeEach
    void setUp() {
        participant = getParticipant("user a");
    }

    private Participant getParticipant(final String name) {
        return new Participant(name) {
            @Override
            public void receiveCards(Card card) {
                super.receiveCards(card);
            }
        };
    }

    @Test
    @DisplayName("참가자는 카드를 받을 수 있다")
    void test() {
        Card card = createCard(EIGHT);
        participant.receiveCards(card);
        List<Card> findCards = participant.getHand().getCards();
        assertThat(findCards).contains(card);
    }
}
