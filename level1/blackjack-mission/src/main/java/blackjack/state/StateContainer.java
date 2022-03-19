package blackjack.state;

abstract public class StateContainer {

    public static final Bust BUST = new Bust();
    public static final Ready READY = new Ready();
    public static final Normal NORMAL = new Normal();
    public static final Blackjack BLACKJACK = new Blackjack();
}
