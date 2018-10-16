/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import java.util.*;

/**
 *
 * @author vitya
 */
public class SortByRankThenSuit implements Comparator<Card> {

    @Override
    public int compare(Card firstCard, Card secondCard) {
        
        int compVal =
            firstCard.getRank().value() - secondCard.getRank().value();
        if (compVal != 0)
            return compVal;
        else
            return firstCard.getSuit().value() - secondCard.getSuit().value(); 
    }
    
}
