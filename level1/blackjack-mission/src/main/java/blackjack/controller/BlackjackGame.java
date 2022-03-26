package blackjack.controller;

import static blackjack.constant.Command.HIT;
import static blackjack.constant.Command.STAY;
import static java.util.stream.Collectors.toList;

import blackjack.constant.Command;
import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.factory.CardFactory;
import blackjack.participant.Dealer;
import blackjack.participant.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BlackjackGame {

    public void run() {

        Dealer dealer = new Dealer();
        List<String> names = InputView.inputNames();
        Map<String, Integer> bettingPlayers = inputBettingAmount(names);
        List<Player> players = createPlayers(bettingPlayers);

        List<Card> blackjackCards = CardFactory.createBlackjackDeck();
        Deck deck = new Deck(blackjackCards);
        deck.shuffle();

        initTwoCard(dealer, players, deck);

        // while
        for (Player player : players) {
            Command command = STAY;
            while (!player.isFinished() && HIT == (command = InputView.moreCard(player.getName()))) {
                player.receiveCard(deck.drawCard());
                player.nextState();
                OutputView.printPlayerCards(player);
            }
            if (command == STAY) {
                player.setStateStop();
            }
        }

        while (!dealer.isFinished()) {
            dealer.receiveCard(deck.drawCard());
            dealer.nextState();
        }
    }

    private void initTwoCard(Dealer dealer, List<Player> players, Deck deck) {
        initDealerTwoCard(dealer, deck);
        initPlayerTwoCard(players, deck);
        OutputView.printInitCards(dealer, players);
    }

    private void initPlayerTwoCard(List<Player> players, Deck deck) {
        for (Player player : players) {
            player.receiveCard(deck.drawCard());
            player.receiveCard(deck.drawCard());
            player.nextState();
        }
    }

    private void initDealerTwoCard(Dealer dealer, Deck deck) {
        dealer.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        dealer.nextState();
    }

    private Map<String, Integer> inputBettingAmount(List<String> names) {
        Map<String, Integer> bettingPlayers = new HashMap<>();
        for (String name : names) {
            int bettingAmount = InputView.inputBettingAmount(name);
            bettingPlayers.put(name, bettingAmount);
        }
        return bettingPlayers;
    }

    private List<Player> createPlayers(Map<String, Integer> bettingPlayers) {
        return bettingPlayers.keySet()
                .stream()
                .map(playerName -> Player.builder()
                        .name(playerName)
                        .bettingAmount(bettingPlayers.get(playerName))
                        .build())
                .collect(toList());
    }
}
