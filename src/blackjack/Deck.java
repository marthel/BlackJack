/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.lang.*;
import java.util.*;

/**
 *
 * @author Marthin
 */
public class Deck {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Card> theCards;

    public Deck() {
        theCards = new ArrayList();
        fill();
    }

    public int getNoOfCards() {
        return theCards.size();
    }

    public Card dealCard() throws NoSuchCardException{
        if (theCards.isEmpty()) {
            throw new NoSuchCardException("No more cards to deal ",0);
        }
        return theCards.remove(0);
    }

    public void shuffleCards() {
        Collections.shuffle(theCards);
    }

    public void fill() {
        theCards.clear();
        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 13; i++) {
                theCards.add(new Card(i, j));
            }
        }
    }
    public void clearDeck() {
        theCards.clear();
    }

    public void sortByRank() {
        Collections.sort(theCards, new RankComparator());
    }

    public void sortBySuit() {
        Collections.sort(theCards, new SuitComparator());
    }

    @Override
    public String toString() {
        String s = "[ ";
        for (Card theCard : theCards) {
            s += theCard.toString() + ",";
        }
        s += " ]";
        return s;
    }
}
