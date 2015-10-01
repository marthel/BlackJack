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
public class RankComparator implements Comparator<Card> {

    @Override
    public int compare(Card a, Card b) {
        return a.getRank() - b.getRank();
    }
}
