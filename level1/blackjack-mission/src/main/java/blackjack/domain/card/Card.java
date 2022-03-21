package blackjack.domain.card;

import java.util.Objects;

public class Card {

    private Denomination denomination;
    private Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public boolean isAce() {
        return denomination == Denomination.ACE;
    }

    public String name() {
        return denomination.getName() + suit.name();
    }

    public int score() {
        return denomination.score();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "denomination=" + denomination +
                ", suit=" + suit +
                '}';
    }
}
