package blackjack.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.Hand;
import blackjack.domain.state.State;
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

    abstract public void nextState();

    public void setStateStop() {
        hand.setStateStop();
    }

    public State state() {
        return hand.state();
    }

    public int score() {
        return hand.score();
    }

    abstract public boolean isFinished();

    public List<Card> cards() {
        return hand.getCards();
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}
