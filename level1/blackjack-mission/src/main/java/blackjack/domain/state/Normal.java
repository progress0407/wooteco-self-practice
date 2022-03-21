package blackjack.domain.state;

import static blackjack.domain.state.StateContainer.BUST;
import static blackjack.view.constant.Command.STAY;

import blackjack.domain.card.Hand;
import blackjack.view.constant.Command;

public class Normal extends Playing {

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

    public void nextState(Hand hand, Command command) {
        if (command == STAY) {
            hand.setState(BUST);
        }
    }
}
