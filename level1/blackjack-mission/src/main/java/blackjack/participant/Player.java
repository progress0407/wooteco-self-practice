package blackjack.participant;

public class Player extends Participant {

    private int bettingAmount;

    public Player(String name) {
        super(name);
    }

    public void placeBet(int bettingAmount) {
        this.bettingAmount = bettingAmount;
    }

    public int getBettingAmount() {
        return bettingAmount;
    }
}
