package blackjack.domain.state;

import static blackjack.domain.state.StateContainer.RUNNING;

import blackjack.domain.card.Hand;

public abstract class Playing implements State {

    @Override
    public int receiveTimes() {
        return 0;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void nextState(Hand hand) {

    }

    @Override
    public void setStateRunning(Hand hand) {

    }
}
