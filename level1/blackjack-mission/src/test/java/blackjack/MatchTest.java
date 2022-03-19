package blackjack;

import static blackjack.utils.DeckCreationUtils.createMockDeck;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import blackjack.participant.Dealer;
import blackjack.participant.Player;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MatchTest {

    @Nested
    @DisplayName("플레이어가 배팅금액 만원으로")
    static class PlayerWith10000 {

        private Dealer dealer = new Dealer();
        private Player player;

        {
            player = new Player("user a");
            player.placeBet(10_000);
        }

        @Test
        @DisplayName("이길 경우 수익은 10000 원이다")
        void test1() {
            dealer.receiveCards(new Card(10));
            dealer.receiveCards(new Card(8));

            player.receiveCards(new Card(10));
            player.receiveCards(new Card(9));

            Match match = Match.from(dealer, List.of(player));

            Integer dealerReturn = match.getDealerReturn();
            Collection<Integer> playerReturns = match.getPlayerReturn().values();

            assertThat(dealerReturn).isEqualTo(-10_000);
            assertThat(playerReturns).contains(10_000);
        }

        @Test
        @DisplayName("블랙잭으로 이길 경우 수익은 15000 원이다")
        void test2() {
            dealer.receiveCards(createMockDeck(10, 8));
            player.receiveCards(createMockDeck(10, 11));

            Match match = Match.from(dealer, List.of(player));

            Integer dealerReturn = match.getDealerReturn();
            Collection<Integer> playerReturns = match.getPlayerReturn().values();

            assertThat(dealerReturn).isEqualTo(-15_000);
            assertThat(playerReturns).contains(15_000);
        }

        @Test
        @DisplayName("질 경우 수익은 -10000 원이다")
        void test3() {
            dealer.receiveCards(createMockDeck(10, 9));
            player.receiveCards(createMockDeck(10, 8));

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
