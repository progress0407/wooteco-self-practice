package blackjack.domain.state;

import blackjack.domain.card.Hand;

public interface State {

    int receiveTimes();

    boolean isFinished();

    void nextState(Hand hand);

    void setStateRunning(Hand hand);

    void setStateStop(Hand hand);
}
