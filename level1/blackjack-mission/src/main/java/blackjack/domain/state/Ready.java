package blackjack.domain.state;

import static blackjack.domain.state.StateContainer.BLACKJACK;
import static blackjack.domain.state.StateContainer.RUNNING;
import static blackjack.domain.state.StateContainer.STOP;

import blackjack.domain.card.Hand;

public class Ready extends Playing {

    @Override
    public int receiveTimes() {
        return 2;
    }

    @Override
    public void nextState(Hand hand) {
        if (hand.score() == 21) {
            hand.setState(BLACKJACK);
            return;
        }
        hand.setState(RUNNING);
    }

    public void setStateRunning(Hand hand) {
        hand.setState(RUNNING);
    }

    @Override
    public void setStateStop(Hand hand) {
        hand.setState(STOP);
    }
}
