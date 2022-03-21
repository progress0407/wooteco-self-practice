package blackjack.view;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

import blackjack.domain.card.Card;
import blackjack.participant.Dealer;
import blackjack.participant.Player;
import java.util.List;

public class OutputView {

    public static void printInitCards(Dealer dealer, List<Player> players) {
        out.printf("%s: %s\n", dealer.getName(), dealer.openOneCard().name());
        for (Player player : players) {
            String playerCards = player.cards().stream()
                    .map(Card::name)
                    .collect(joining(", "));
            out.printf("%s: %s\n", player.getName(), playerCards);
        }
    }
}
