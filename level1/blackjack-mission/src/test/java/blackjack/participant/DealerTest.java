package blackjack.participant;

import static blackjack.domain.card.Denomination.EIGHT;
import static blackjack.domain.card.Denomination.SEVEN;
import static blackjack.domain.card.Denomination.SIX;
import static blackjack.domain.card.Denomination.TWO;
import static blackjack.domain.state.StateContainer.READY;
import static blackjack.domain.state.StateContainer.RUNNING;
import static blackjack.domain.state.StateContainer.STOP;
import static blackjack.utils.CreationUtils.createCard;
import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.state.Finished;
import blackjack.domain.state.Playing;
import blackjack.domain.state.Ready;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @DisplayName("딜러는 17점 이상이면 Finished 가 된다")
    @Test
    void test() {
        Dealer dealer = new Dealer();

        assertThat(dealer.state()).isEqualTo(READY);

        dealer.nextState();

        assertThat(dealer.state()).isEqualTo(RUNNING);

        dealer.receiveCard(createCard(EIGHT));
        dealer.receiveCard(createCard(SEVEN));
        dealer.receiveCard(createCard(TWO));

        dealer.nextState();

        assertThat(dealer.state()).isEqualTo(STOP);
        assertThat(dealer.state()).isInstanceOf(Finished.class);
    }

    @DisplayName("딜러는 16점 이상이면 Finished가 되지 않는다")
    @Test
    void test2() {
        Dealer dealer = new Dealer();

        assertThat(dealer.state()).isEqualTo(READY);

        dealer.nextState();

        assertThat(dealer.state()).isEqualTo(RUNNING);

        dealer.receiveCard(createCard(EIGHT));
        dealer.receiveCard(createCard(SIX));
        dealer.receiveCard(createCard(TWO));

        dealer.nextState();

        assertThat(dealer.state()).isEqualTo(RUNNING);
        assertThat(dealer.state()).isInstanceOf(Playing.class);
    }
}
