package blackjack.domain.state;

import blackjack.domain.card.Hand;

public abstract class Finished implements State {

    @Override
    public int receiveTimes() {
        return 0;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void nextState(Hand hand) {
    }
}
