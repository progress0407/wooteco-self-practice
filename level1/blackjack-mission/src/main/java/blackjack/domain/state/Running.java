package blackjack.domain.state;

import static blackjack.domain.state.StateContainer.BUST;
import static blackjack.domain.state.StateContainer.RUNNING;
import static blackjack.domain.state.StateContainer.STOP;

import blackjack.domain.card.Hand;

public class Running extends Playing {

    @Override
    public int receiveTimes() {
        return 1;
    }

    @Override
    public void nextState(Hand hand) {
        if (21 < hand.score()) {
            hand.setState(BUST);
        }
    }

    @Override
    public void setStateRunning(Hand hand) {
        hand.setState(RUNNING);
    }

    @Override
    public void setStateStop(Hand hand) {
        hand.setState(STOP);
    }
}
