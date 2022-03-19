package blackjack;

import static blackjack.state.StateContainer.READY;

import blackjack.state.Finished;
import blackjack.state.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private State state = READY;
    private final List<Card> cards = new ArrayList<>();

    public int score() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveCards(Deck deck) {
        int receiveTimes = state.receiveTimes();
        for (int n = 0; n < receiveTimes; n++) {
            cards.add(deck.drawCard());
        }
        nextState();
    }

    public void nextState() {
        state.nextState(this);
    }

    public boolean isFinished() {
        return state instanceof Finished;
    }

    public boolean isNotFinished() {
        return !(state instanceof Finished);
    }

    public State state() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public MatchResult match(Hand dealerHand) {
        return MatchResult.from(this, dealerHand);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
