package blackjack.participant;

import blackjack.Card;
import java.util.List;
import org.assertj.core.api.Assertions;
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
        Card card = new Card(4);
        participant.receiveCards(card);
        List<Card> findCards = participant.getHand().getCards();
        Assertions.assertThat(findCards).contains(card);
    }

}
