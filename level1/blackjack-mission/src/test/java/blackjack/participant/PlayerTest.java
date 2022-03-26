package blackjack.participant;

import static blackjack.domain.card.Denomination.ACE;
import static blackjack.domain.card.Denomination.FIVE;
import static blackjack.domain.card.Denomination.SIX;
import static blackjack.domain.card.Denomination.TEN;
import static blackjack.domain.state.StateContainer.BLACKJACK;
import static blackjack.domain.state.StateContainer.READY;
import static blackjack.domain.state.StateContainer.RUNNING;
import static blackjack.domain.state.StateContainer.STOP;
import static blackjack.utils.CreationUtils.createCard;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("READY -> NORAML")
    @Test
    void test() {
        Player player = new Player("philz");

        assertThat(player.state());

        player.receiveCard(createCard(SIX));
        player.receiveCard(createCard(FIVE));

        player.setStateRunning();

        assertThat(player.state()).isEqualTo(RUNNING);
    }

    @DisplayName("READY -> BLACKJACK")
    @Test
    void test2() {
        Player player = new Player("philz");

        assertThat(player.state());

        player.receiveCard(createCard(ACE));
        player.receiveCard(createCard(TEN));

        player.setStateRunning();

        assertThat(player.state()).isEqualTo(BLACKJACK);
    }

    @DisplayName("READY -> BLACKJACK")
    @Test
    void test3() {
        Player player = new Player("philz");

        assertThat(player.state()).isEqualTo(READY);

        player.receiveCard(createCard(ACE));
        player.receiveCard(createCard(TEN));

        player.setStateRunning();

        assertThat(player.state()).isEqualTo(BLACKJACK);
    }

    @DisplayName("READY -> STOP")
    @Test
    void test4() {
        Player player = new Player("philz");

        assertThat(player.state()).isEqualTo(READY);

        player.setStateStop();

        assertThat(player.state()).isEqualTo(STOP);
    }
}
