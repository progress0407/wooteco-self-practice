package blackjack;

import static blackjack.domain.card.Denomination.ACE;
import static blackjack.domain.card.Denomination.EIGHT;
import static blackjack.domain.card.Denomination.FIVE;
import static blackjack.domain.card.Denomination.NINE;
import static blackjack.domain.card.Denomination.SIX;
import static blackjack.domain.card.Denomination.TEN;
import static blackjack.domain.card.Denomination.THREE;
import static blackjack.domain.card.Denomination.TWO;
import static blackjack.utils.CreationUtils.createMockDeck;
import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Hand;
import blackjack.domain.card.MockDeck;
import blackjack.domain.state.Blackjack;
import blackjack.domain.state.Bust;
import blackjack.domain.state.Normal;
import blackjack.domain.state.Ready;
import blackjack.domain.state.State;
import blackjack.view.constant.Command;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class StateTest {

    @Test
    void READY에서_NORMAL() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        MockDeck mockDeck = createMockDeck(FIVE, NINE);
        hand.receiveCards(mockDeck);

        assertThat(hand.state()).isInstanceOf(Normal.class);
    }

    @Test
    void READY에서_BLACKJACK() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        MockDeck mockDeck = createMockDeck(ACE, TEN);
        hand.receiveCards(mockDeck);

        assertThat(hand.state()).isInstanceOf(Blackjack.class);
    }

    @Test
    void NORMAL에서_NORMAL() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        hand.receiveCards(createMockDeck(TWO, THREE));
        assertThat(hand.state()).isInstanceOf(Normal.class);

        hand.receiveCards(createMockDeck(SIX));
        assertThat(hand.state()).isInstanceOf(Normal.class);
    }

    @Test
    void 카드가_3장일_경우_21점() {
        Hand hand = new Hand();
        State handState = hand.state();

        assertThat(handState).isInstanceOf(Ready.class);

        hand.receiveCards(createMockDeck(FIVE, SIX));

        assertThat(hand.state()).isInstanceOf(Normal.class);

        hand.receiveCards(createMockDeck(TEN));

        assertThat(hand.state()).isInstanceOf(Normal.class);
    }

    @Test
    void NORMAL에서_BUST() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        MockDeck mock = createMockDeck(EIGHT, SIX);
        hand.receiveCards(mock);

        assertThat(hand.state()).isInstanceOf(Normal.class);

        hand.receiveCards(createMockDeck(TEN));

        assertThat(hand.state()).isInstanceOf(Bust.class);
    }

    @Test
    void test() {
        Command hit = Command.of("y");

        Hand hand = new Hand();
        State handState = hand.state();

    }
}
