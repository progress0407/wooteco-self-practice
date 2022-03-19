package blackjack.state;

import static blackjack.state.StateContainer.BUST;

import blackjack.Hand;

public class Normal extends UnFinished {

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
}
