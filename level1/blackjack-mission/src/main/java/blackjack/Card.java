package blackjack;

public class Card {

    private int score;

    public Card(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Card{" +
                "score=" + score +
                '}';
    }
}
