package blackjack;

import static java.lang.System.out;

import blackjack.state.Finished;
import blackjack.state.State;
import blackjack.state.StateContainer;
import java.util.ArrayList;
import java.util.List;

public class Hand {

    private State state = StateContainer.READY;
    private final List<Card> cards = new ArrayList<>();

    public int score() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    public void receiveCards(Deck deck) {
        int receiveTimes = state.receiveTimes();
        for (int n = 0; n < receiveTimes; n++) {
            Card card = deck.drawCard();
            out.println(card + "를 넣었습니다 !");
            cards.add(card);
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
}
