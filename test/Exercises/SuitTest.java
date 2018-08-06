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
public class SuitTest {
    
    public SuitTest() {
    }

    /**
     * Test of values method, of class Suit.
     */
    @Test
    public void testValues() {
        Card.Suit[] expResult = new Card.Suit[] { 
            Card.Suit.DIAMONDS, Card.Suit.CLUBS, 
            Card.Suit.HEARTS, Card.Suit.SPADES };
        
        Card.Suit[] result = Card.Suit.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Suit.
     */
    @Test
    public void testValueOf() {
        String name = null;
        Card.Suit expResult = null;
        Card.Suit result = null;
        
        name = "DIAMONDS";
        expResult = Card.Suit.DIAMONDS;
        result = Card.Suit.valueOf(name);
        assertEquals(expResult, result);
        
        name = "CLUBS";
        expResult = Card.Suit.CLUBS;
        result = Card.Suit.valueOf(name);
        assertEquals(expResult, result);
        
        name = "HEARTS";
        expResult = Card.Suit.HEARTS;
        result = Card.Suit.valueOf(name);
        assertEquals(expResult, result);
        
        name = "SPADES";
        expResult = Card.Suit.SPADES;
        result = Card.Suit.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Suit.
     */
    @Test
    public void testToString() {
        assertEquals("DIAMONDS" , Card.Suit.DIAMONDS.toString());
        assertEquals("CLUBS"    , Card.Suit.CLUBS.toString());
        assertEquals("HEARTS"   , Card.Suit.HEARTS.toString());
        assertEquals("SPADES"   , Card.Suit.SPADES.toString());
    }
    
}
