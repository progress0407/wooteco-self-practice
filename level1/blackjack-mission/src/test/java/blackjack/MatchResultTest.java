package blackjack;

import static blackjack.MatchResult.BLACKJACK_WIN;
import static blackjack.MatchResult.DRAW;
import static blackjack.MatchResult.LOSE;
import static blackjack.MatchResult.ORDINARY_WIN;
import static blackjack.utils.CreationUtils.createMockDeck;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MatchResultTest {

    @Test
    @DisplayName("딜러와_플레이어_둘다_버스트이면_플레이어의_패배다")
    void test1() {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.state();

        playerHand.receiveCards(createMockDeck(10, 10));
        dealerHand.receiveCards(createMockDeck(10, 10));

        playerHand.receiveCards(createMockDeck(4));
        dealerHand.receiveCards(createMockDeck(3));

        MatchResult playerMatchResult = playerHand.match(dealerHand);

        assertThat(playerMatchResult).isEqualTo(LOSE);
    }


    @Test
    @DisplayName("딜러가 버스트이고 플레이어가 아니면 플레이어가 승리한다")
    void test2() {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.receiveCards(createMockDeck(5, 6));
        dealerHand.receiveCards(createMockDeck(10, 10));

        dealerHand.receiveCards(createMockDeck(3));

        MatchResult matchResult = playerHand.match(dealerHand);

        assertThat(matchResult).isEqualTo(ORDINARY_WIN);
    }

    @Test
    @DisplayName("딜러와 플레이어 모두 블랙잭이면 무승부이다")
    void test3() {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.receiveCards(createMockDeck(10, 11));
        dealerHand.receiveCards(createMockDeck(10, 11));

        MatchResult playerMatchResult = playerHand.match(dealerHand);

        assertThat(playerMatchResult).isEqualTo(DRAW);
    }

    @Test
    @DisplayName("플레이어만 블랙잭이면 1.5배의 수익을 얻는다")
    void test4() {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.receiveCards(createMockDeck(10, 11));
        dealerHand.receiveCards(createMockDeck(10, 8));

        MatchResult playerMatchResult = playerHand.match(dealerHand);

        assertAll(
                () -> assertThat(playerMatchResult).isEqualTo(BLACKJACK_WIN),
                () -> assertThat(playerMatchResult.earningRate()).isEqualTo(1.5)
        );
    }

    @Nested
    @DisplayName("참가자 모두 점수가 21점 미만일 때")
    static class LessThan21 {

        private Hand playerHand;
        private Hand dealerHand;

        @BeforeEach
        void setUp() {
            playerHand = new Hand();
            dealerHand = new Hand();
        }

        @Test
        @DisplayName("플레이어의 점수가 높으면 플레이어의 승리다")
        void test1() {
            playerHand.receiveCards(createMockDeck(10, 9));
            dealerHand.receiveCards(createMockDeck(10, 8));

            MatchResult playerMatchResult = playerHand.match(dealerHand);

            assertThat(playerMatchResult).isEqualTo(ORDINARY_WIN);
        }

        @Test
        @DisplayName("점수가 서로 같으면 무승부이다")
        void test2() {
            playerHand.receiveCards(createMockDeck(9, 8));
            dealerHand.receiveCards(createMockDeck(10, 7));

            MatchResult playerMatchResult = playerHand.match(dealerHand);

            assertThat(playerMatchResult).isEqualTo(DRAW);
        }

        @Test
        @DisplayName("플레이의 점수가 낮으면 패이다")
        void test3() {
            playerHand.receiveCards(createMockDeck(9, 6));
            dealerHand.receiveCards(createMockDeck(10, 7));

            MatchResult playerMatchResult = playerHand.match(dealerHand);

            assertThat(playerMatchResult).isEqualTo(LOSE);
        }
    }
}
