package blackjack;

import java.util.Objects;

public class Card {

    private int score;

    public Card(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
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
        return score == card.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Card{" +
                "score=" + score +
                '}';
    }
}
