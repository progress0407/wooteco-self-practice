package blackjack.domain.state;

import static blackjack.domain.state.StateContainer.BUST;

import blackjack.domain.card.Hand;

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
