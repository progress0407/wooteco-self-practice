package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Deck {

    private List<Card> cards;

    public Deck(Queue<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
