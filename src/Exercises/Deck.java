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
    
    private Card[] cards;
    
    // 52 cards deck
    {
        cards = new Card[52];
        for (int suit=0; suit<Card.SUITS.length; ++suit) {
            for (int rank=0; rank<Card.RANKS.length; ++rank) {
                cards[suit*Card.RANKS.length+rank] = new Card(suit, rank);
            }
        }
    }       
    
    public Card[] getCards() {
        return cards;
    }
}
