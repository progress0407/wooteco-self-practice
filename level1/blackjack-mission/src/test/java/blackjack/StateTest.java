package blackjack;

import static blackjack.utils.CreationUtils.createMockDeck;
import static org.assertj.core.api.Assertions.assertThat;

import blackjack.state.Blackjack;
import blackjack.state.Bust;
import blackjack.state.Normal;
import blackjack.state.Ready;
import blackjack.state.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StateTest {

    @Test
    void READY에서_NORMAL() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        MockDeck mockDeck = createMockDeck(5, 9);
        hand.receiveCards(mockDeck);

        assertThat(hand.state()).isInstanceOf(Normal.class);
    }

    @Test
    void READY에서_BLACKJACK() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        MockDeck mockDeck = createMockDeck(11, 10);
        hand.receiveCards(mockDeck);

        assertThat(hand.state()).isInstanceOf(Blackjack.class);
    }

    @Test
    void NORMAL에서_NORMAL() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        hand.receiveCards(createMockDeck(2, 3));
        assertThat(hand.state()).isInstanceOf(Normal.class);

        hand.receiveCards(createMockDeck(6));
        assertThat(hand.state()).isInstanceOf(Normal.class);
    }

    @Test
    void 카드가_3장일_경우_21점() {
        Hand hand = new Hand();
        State handState = hand.state();

        assertThat(handState).isInstanceOf(Ready.class);

        hand.receiveCards(new MockDeck(new Card(5), new Card(6)));

        assertThat(hand.state()).isInstanceOf(Normal.class);

        hand.receiveCards(new MockDeck(new Card(10)));

        assertThat(hand.state()).isInstanceOf(Normal.class);
        assertThat(hand.state()).isInstanceOf(Normal.class);
    }

    @Test
    void NORMAL에서_BUST() {
        Hand hand = new Hand();

        assertThat(hand.state()).isInstanceOf(Ready.class);

        MockDeck mock = createMockDeck(8, 6);
        hand.receiveCards(mock);

        assertThat(hand.state()).isInstanceOf(Normal.class);

        hand.receiveCards(createMockDeck(10));

        assertThat(hand.state()).isInstanceOf(Bust.class);
    }
}
