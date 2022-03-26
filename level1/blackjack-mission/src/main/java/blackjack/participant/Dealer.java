package blackjack.participant;

import blackjack.domain.card.Card;

public class Dealer extends Participant{

    public Dealer() {
        super("딜러");
    }

    public Card openOneCard() {
        return super.hand.peekOneCard();
    }

    @Override
    public boolean isFinished() {
        return state().isFinished() || dealerCardReceiveCondition();
    }

    private boolean dealerCardReceiveCondition() {
        return score() >= 17;
    }

    public void nextState() {
        if (dealerCardReceiveCondition()) {
            hand.setStateStop();
        }
        hand.nextState();
    }
}
