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
public class BlackJack {

    private Deck deck;
    private Hand[] players;

    public BlackJack(int n) {
        deck = new Deck();
        players = new Hand[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Hand();
        }
    }

    public void startGame() {
        initGame();
        Scanner scanner = new Scanner(System.in);
        String ans;
        while (gameIsActive()) {
            for (int i = 0; i < players.length; i++) {
                if (sumOfCards(i) >= 21) {
                    break;
                }
                System.out.println("Player" + (i + 1) + "'s turn, new card? yes/no");
                ans = scanner.next();
                nextTurn(i, ans);
            }
            printCards();
        }

    }
    private boolean gameIsActive() {
        int activePlayers = players.length;
        for (int i = 0; i < players.length; i++) {
            if (sumOfCards(i) > 21) {
                activePlayers--;
            }
        }
        if (activePlayers <= 1) {
            return false;
        }
        return true;
    }

    private void nextTurn(int n, String s) {
        if ("yes".equals(s)) {
            dealCard(n);
        }
    }

    private void initGame() {
        deck.shuffleCards();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < players.length; i++) {
                dealCard(i);
            }
        }
        printCards();
    }

    private void printCards() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("player " + (i + 1) + "'s cards " + players[i].toString() + " sum of cards: " + sumOfCards(i));
        }
    }

    private void dealCard(int n) {
        players[n].addCard(deck.dealCard());
    }

    private int sumOfCards(int n) {
        int sum = 0;
        for (int i = 0; i < players[n].getNoOfCards(); i++) {
            if (players[n].getCard(i).getRank() > 10) {
                sum += 10;
            } else {
                sum += players[n].getCard(i).getRank();
            }
        }
        return sum;
    }
}
