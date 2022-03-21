package blackjack.domain.state;

import blackjack.domain.card.Hand;

public class Ready extends Playing {

    @Override
    public int receiveTimes() {
        return 2;
    }

    @Override
    public void nextState(Hand hand) {
        if (hand.score() == 21) {
            hand.setState(StateContainer.BLACKJACK);
            return;
        }
        hand.setState(StateContainer.NORMAL);
    }
}
