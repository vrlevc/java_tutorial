/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

/**
 *
 * @author lva
 */
public class Card {
    
    public static int TWO = 0;
    
    public static String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" };
    public static String[] SUITS = { "clubs", "diamonds", "hearts", "spades" };
    
    private final int rank;
    private final int suit;
    
    public Card(int suit, int rank) {
        assert( 0 <= rank && rank < RANKS.length );
        assert( 0 <= suit && suit < SUITS.length );
        this.rank = rank;
        this.suit = suit;
    }
    
    public String getRank() {
        return RANKS[rank];
    }
    
    public String getSuit() {
        return SUITS[suit];
    }
}
