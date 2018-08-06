/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitya
 */
public class PlayingCardTest {
    
    public PlayingCardTest() {
    }

    /**
     * Test of getRank method, of class PlayingCard.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        PlayingCard instance = new PlayingCard(Card.Rank.ACE, Card.Suit.SPADES);
        Card.Rank expResult = Card.Rank.ACE;
        Card.Rank result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class PlayingCard.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        PlayingCard instance = new PlayingCard(Card.Rank.ACE, Card.Suit.SPADES);
        Card.Suit expResult = Card.Suit.SPADES;
        Card.Suit result = instance.getSuit();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PlayingCard.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PlayingCard instance = new PlayingCard(Card.Rank.ACE, Card.Suit.SPADES);
        String expResult = Card.Rank.ACE.toString() + " of " + Card.Suit.SPADES.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
