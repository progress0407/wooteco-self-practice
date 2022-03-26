package blackjack.domain.card;

import static blackjack.domain.state.StateContainer.READY;

import blackjack.service.MatchResult;
import blackjack.domain.state.Finished;
import blackjack.domain.state.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private State state = READY;
    private int score = 0;
    private List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public int score() {
        if (hasAce()) {
            return sumIncludingAce();
        }

        return cardScoreTotal();
    }

    private int cardScoreTotal() {
        return cards.stream()
                .mapToInt(Card::score)
                .sum();
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }

    private int sumIncludingAce() {
        int cardScoreTotal = cardScoreTotal();
        int aceHighScore = cardScoreTotal + (11 - 1);

        if (aceHighScore <= 21) {
            return aceHighScore;
        }
        return cardScoreTotal;
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

    public Card peekOneCard() {
        return cards.get(0);
    }

    public void setStateRunning() {
        state.setStateRunning(this);
    }

    public void setStateStop() {
        state.setStateStop(this);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
