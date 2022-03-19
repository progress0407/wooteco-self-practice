package blackjack.participant;

import blackjack.Card;
import blackjack.Deck;
import blackjack.Hand;

abstract public class Participant {
    private final String name;
    private final Hand hand = new Hand();

    public Participant(String name) {
        this.name = name;
    }

    public void receiveCards(Card card) {
        hand.receiveCard(card);
    }

    public void receiveCards(Deck deck) {
        hand.receiveCards(deck);
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}
