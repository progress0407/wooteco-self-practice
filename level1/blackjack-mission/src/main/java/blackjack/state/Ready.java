package blackjack.state;

import static blackjack.state.StateContainer.BLACKJACK;
import static blackjack.state.StateContainer.NORMAL;

import blackjack.Hand;

public class Ready extends UnFinished {

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
        hand.setState(NORMAL);
    }
}
