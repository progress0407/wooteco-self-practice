package blackjack.state;

import blackjack.Hand;

public interface State {

    int receiveTimes();

    void nextState(Hand hand);
}
