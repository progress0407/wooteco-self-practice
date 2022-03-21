package blackjack.participant;

import blackjack.domain.card.Card;

public class Dealer extends Participant{

    public Dealer() {
        super("딜러");
    }

    public Card openOneCard() {
        return super.hand.peekOneCard();
    }
}
