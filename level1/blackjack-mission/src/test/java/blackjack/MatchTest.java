package blackjack;

import static blackjack.domain.card.Denomination.ACE;
import static blackjack.domain.card.Denomination.EIGHT;
import static blackjack.domain.card.Denomination.JACK;
import static blackjack.domain.card.Denomination.NINE;
import static blackjack.domain.card.Denomination.QUEEN;
import static blackjack.domain.card.Denomination.TEN;
import static blackjack.utils.CreationUtils.createCard;
import static blackjack.utils.CreationUtils.createMockDeck;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import blackjack.participant.Dealer;
import blackjack.participant.Player;
import blackjack.service.Match;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MatchTest {

    @Nested
    @DisplayName("플레이어가 배팅금액 만원으로")
    class PlayerWith10000 {

        private Dealer dealer = new Dealer();
        private Player player;

        {
            player = new Player("user a");
            player.placeBet(10_000);
        }

        @Test
        @DisplayName("이길 경우 수익은 10000 원이다")
        void test1() {
            dealer.receiveCard(createCard(JACK));
            dealer.receiveCard(createCard(EIGHT));

            player.receiveCard(createCard(QUEEN));
            player.receiveCard(createCard(NINE));

            Match match = Match.from(dealer, List.of(player));

            Integer dealerReturn = match.getDealerReturn();
            Collection<Integer> playerReturns = match.getPlayerReturn().values();

            assertThat(dealerReturn).isEqualTo(-10_000);
            assertThat(playerReturns).contains(10_000);
        }

        @Test
        @DisplayName("블랙잭으로 이길 경우 수익은 15000 원이다")
        void test2() {
            dealer.receiveCardsByDeck(createMockDeck(JACK, EIGHT));
            player.receiveCardsByDeck(createMockDeck(QUEEN, ACE));

            Match match = Match.from(dealer, List.of(player));

            Integer dealerReturn = match.getDealerReturn();
            Collection<Integer> playerReturns = match.getPlayerReturn().values();

            assertThat(dealerReturn).isEqualTo(-15_000);
            assertThat(playerReturns).contains(15_000);
        }

        @Test
        @DisplayName("질 경우 수익은 -10000 원이다")
        void test3() {
            dealer.receiveCardsByDeck(createMockDeck(TEN, NINE));
            player.receiveCardsByDeck(createMockDeck(JACK, EIGHT));

            Match match = Match.from(dealer, List.of(player));

            Integer dealerReturn = match.getDealerReturn();
            Collection<Integer> playerReturns = match.getPlayerReturn().values();

            assertAll(
                    () -> assertThat(dealerReturn).isEqualTo(10_000),
                    () -> assertThat(playerReturns).contains(-10_000)
            );
        }
    }
}
