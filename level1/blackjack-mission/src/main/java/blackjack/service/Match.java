package blackjack.service;

import blackjack.participant.Dealer;
import blackjack.participant.Player;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Match {

    private Integer dealerReturn = 0;
    private Map<String, Integer> playerReturn = new LinkedHashMap<>();

    private Match(Dealer dealer, List<Player> players) {
        makePlayersReturn(players, dealer);
        makeDealerReturn(dealer, players);
    }

    public static Match from(Dealer dealer, List<Player> players) {
        return new Match(dealer, players);
    }

    private void makePlayersReturn(List<Player> players, Dealer dealer) {
        for (Player player : players) {
            MatchResult matchResult = MatchResult.from(player.getHand(), dealer.getHand());
            double earningRate = matchResult.earningRate();
            int bettingAmount = player.getBettingAmount();
            int gamblingReturn = (int) (earningRate * bettingAmount);
            playerReturn.put(player.getName(), gamblingReturn);
        }
    }

    private void makeDealerReturn(Dealer dealer, List<Player> players) {
        this.dealerReturn = -1 * playerReturn.values()
                .stream()
                .mapToInt(e->e)
                .sum();
    }

    public Integer getDealerReturn() {
        return dealerReturn;
    }

    public Map<String, Integer> getPlayerReturn() {
        return Collections.unmodifiableMap(playerReturn);
    }
}
