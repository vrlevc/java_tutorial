/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import java.util.Arrays;

/**
 *
 * @author lva
 */
public class Deck {
    
    private static Card[] cards = new Card[52];
    
    // 52 cards deck initialization
    static {
        int i = 0;
        for ( Suit suit : Suit.values() ) {
            for ( Rank rank : Rank.values() ) {
                cards[i++] = new Card(rank, suit);
            }
        }
    }       
    
}
