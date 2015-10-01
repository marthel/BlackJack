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
public class Hand {

    private ArrayList<Card> theCards;

    public Hand() {
        theCards = new ArrayList();

    }

    public int getNoOfCards() {
        return theCards.size();
    }

    public void addCard(Card c) {
        theCards.add(c);
    }

    public Card getCard(int pos) throws NoSuchCardException{
        if (pos < 0 || pos >= theCards.size()) {
            throw new NoSuchCardException("No card at position ", pos);
        }
        return theCards.get(pos);
    }

    public Card removeCard(int pos) throws NoSuchCardException{
        if (pos < 0 || pos >= theCards.size()) {
            throw new NoSuchCardException("No card to remove at position ",pos);
        }
        return theCards.remove(pos);
    }

    public void removeAllCards() {
        theCards.clear();
    }

    public boolean removeCard(Card c) {
        return theCards.remove(c);
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
