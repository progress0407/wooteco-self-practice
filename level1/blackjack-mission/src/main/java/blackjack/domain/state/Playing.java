package blackjack.domain.state;

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
}
