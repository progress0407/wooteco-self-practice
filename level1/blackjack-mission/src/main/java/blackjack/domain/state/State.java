package blackjack.domain.state;

import blackjack.domain.card.Hand;

public interface State {

    int receiveTimes();

    void nextState(Hand hand);
}
