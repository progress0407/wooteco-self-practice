package blackjack.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.Hand;
import java.rmi.MarshalException;
import java.util.List;

abstract public class Participant {
    private final String name;
    protected final Hand hand = new Hand();

    public Participant(String name) {
        this.name = name;
    }

    public void receiveCard(Card card) {
        hand.receiveCard(card);
    }

    public void receiveCardsByDeck(Deck deck) {
        hand.receiveCards(deck);
    }

    public Hand getHand() {
        return hand;
    }

    public List<Card> cards() {
        return hand.getCards();
    }

    public String getName() {
        return name;
    }

    public void nextState() {
        hand.nextState();
    }
}
