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
public class StandardDeck {
    
    private static PlayingCard[] cards = new PlayingCard[52];
    
    // 52 cards deck initialization
    static {
        int i = 0;
        for ( Card.Suit suit : Card.Suit.values() ) {
            for ( Card.Rank rank : Card.Rank.values() ) {
                cards[i++] = new PlayingCard(rank, suit);
            }
        }
    }       
    
}