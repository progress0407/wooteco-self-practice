package blackjack;

import static blackjack.domain.state.StateContainer.BLACKJACK;
import static blackjack.domain.state.StateContainer.BUST;

import blackjack.domain.card.Hand;
import java.util.Arrays;
import java.util.function.BiPredicate;

public enum MatchResult {

    BLACKJACK_WIN(1.5, MatchResult::blackJackWinCondition),
    ORDINARY_WIN(1, MatchResult::normalWinCondition),
    DRAW(0, MatchResult::drawCondition),
    LOSE(-1, MatchResult::loseCondition);

    public static final String NOT_FOUND_CONDITION_EXCEPTION_MESSAGE = "[ERROR] 존재하지 않는 경우입니다";

    private final double earningRate;
    private final BiPredicate<Hand, Hand> condition;

    MatchResult(double earningRate, BiPredicate<Hand, Hand> condition) {
        this.earningRate = earningRate;
        this.condition = condition;
    }

    private static boolean blackJackWinCondition(Hand player, Hand dealer) {
        return player.state() == BLACKJACK && dealer.state() != BLACKJACK;
    }

    private static boolean normalWinCondition(Hand player, Hand dealer) {
        return normalWinSubConditionFirst(player, dealer) ||
                normalWinSubConditionSecond(player, dealer);
    }

    private static boolean normalWinSubConditionFirst(Hand player, Hand dealer) {
        return player.isNotFinished() &&
                dealer.isNotFinished() &&
                player.score() > dealer.score();
    }

    private static boolean normalWinSubConditionSecond(Hand player, Hand dealer) {
        return dealer.state() == BUST && player.state() != BUST;
    }

    private static boolean drawCondition(Hand player, Hand dealer) {
        return (player.state() == BLACKJACK && dealer.state() == BLACKJACK) ||
                player.score() == dealer.score();
    }

    private static boolean loseCondition(Hand player, Hand dealer) {
        return player.state() == BUST ||
                (player.isNotFinished() && dealer.isNotFinished() && player.score() < dealer.score());
    }

    public static MatchResult from(Hand player, Hand dealer) {
        return Arrays.stream(values())
                .filter(matchResult -> matchResult.condition.test(player, dealer))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CONDITION_EXCEPTION_MESSAGE));
    }

    public double earningRate() {
        return earningRate;
    }
}
