package blackjack.domain.state;

abstract public class StateContainer {

    public static final Bust BUST = new Bust();
    public static final State STOP = new Stop();
    public static final Ready READY = new Ready();
    public static final Running RUNNING = new Running();
    public static final Blackjack BLACKJACK = new Blackjack();
}
