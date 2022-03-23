package blackjack.participant;

import blackjack.domain.state.State;

public class Player extends Participant {

    private int bettingAmount;

    public Player(String name) {
        super(name);
    }

    public Player(String name, int bettingAmount) {
        super(name);
        this.bettingAmount = bettingAmount;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {

        private String name;
        private int bettingAmount;

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder bettingAmount(int bettingAmount) {
            this.bettingAmount = bettingAmount;
            return this;
        }

        public Player build() {
            return new Player(name, bettingAmount);
        }
    }

    public void placeBet(int bettingAmount) {
        this.bettingAmount = bettingAmount;
    }

    public State state() {
        return super.hand.state();
    }

    public int getBettingAmount() {
        return bettingAmount;
    }
}
