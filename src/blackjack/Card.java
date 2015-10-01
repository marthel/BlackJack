/**
 * Objects of this class represents cards in a deck (of cards). A card is
 * immutable, i.e. once created its rank or suit cannot be changed.
 */
package blackjack;

import java.lang.*;
import java.util.*;

public class Card {

    /**
     * @param rank 1 = Ace, 2 = 2, ...
     * @param suit 1 = spades, 2 = hearts, 3 = diamonds, 4 = clubs
     */
    public Card(int rank, int suit) throws IllegalArgumentException {
        if (rank < 1 || rank > 13) {
            throw new IllegalArgumentException("Bad rank argument");
        } else if (suit < 1 || suit > 4) {
            throw new IllegalArgumentException("Bad suit argument");
        }
        this.rank = rank;
        this.suit = suit;

    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public boolean equals(Card other) {
        return this.rank == other.rank && this.suit == other.suit;
    }

    @Override
    public String toString() {
        String info = rankTab[rank - 1] + " of " + suitTab[suit - 1];
        return info;
    }

    private final int rank, suit;

    // Tables for converting rank & suit to text (why static?)
    private static final String[] rankTab = {
        "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King"
    };

    private static final String[] suitTab = {
        "spades", "hearts", "clubs", "diamonds"
    };
}
