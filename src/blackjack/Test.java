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
public class Test {

    private Deck deck;
    private Hand[] players;

    public Test(int n) {
        deck = new Deck();
        players = new Hand[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Hand();
        }
    }

    public void test() {
        System.out.println(deck.toString());
        deck.shuffleCards();
        System.out.println("*********************");
        System.out.println(deck.toString());
        System.out.println("*********************");
        deck.sortBySuit();
        System.out.println(deck.toString());
        System.out.println("*********************");
        deck.sortByRank();
        System.out.println(deck.toString());
        deck.clearDeck();
        try {
            deck.dealCard();
        } catch (NoSuchCardException e) {
            System.out.println(e.getMessage());
            deck.fill();
            System.out.println(deck.dealCard().toString());
        }
        try {
            players[0].removeCard(0);
        } catch (NoSuchCardException e) {
            System.out.println(e.getMessage());
            players[0].addCard(deck.dealCard());
            System.out.println(players[0].removeCard(0).toString());
        }
        try {
            players[0].getCard(0);
        } catch (NoSuchCardException e) {
            System.out.println(e.getMessage());
            players[0].addCard(deck.dealCard());

            System.out.println(players[0].getCard(0).toString());
        }

    }
}
