package blackjack.view;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

import blackjack.domain.card.Card;
import blackjack.participant.Dealer;
import blackjack.participant.Player;
import java.util.List;

public class OutputView {

    private static String playerCardsMessage(Player player) {
        return player.cards().stream()
                .map(Card::name)
                .collect(joining(", "));
    }

    public static void printInitCards(Dealer dealer, List<Player> players) {
        out.printf("%s: %s\n", dealer.getName(), dealer.openOneCard().name());
        for (Player player : players) {
            String playerCards = playerCardsMessage(player);
            out.printf("%s: %s\n", player.getName(), playerCards);
        }
    }

    public static void printPlayerCards(Player player) {
        // pobi카드: 2하트, 8스페이드, A클로버
        out.println(player.getName() + "카드: " + playerCardsMessage(player));
    }
}
