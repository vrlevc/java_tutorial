/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitya
 */
public class CardTest {
    
    public CardTest() {
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Card instance = new Card(Rank.ACE, Suit.SPADES);
        Rank expResult = Rank.ACE;
        Rank result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card instance = new Card(Rank.ACE, Suit.SPADES);
        Suit expResult = Suit.SPADES;
        Suit result = instance.getSuit();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = new Card(Rank.ACE, Suit.SPADES);
        String expResult = Rank.ACE.toString() + " of " + Suit.SPADES.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
