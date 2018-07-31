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
        Suit[] expResult = new Suit[] { Suit.DIAMONDS, Suit.CLUBS, Suit.HEARTS, Suit.SPADES };
        Suit[] result = Suit.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Suit.
     */
    @Test
    public void testValueOf() {
        String name = null;
        Suit expResult = null;
        Suit result = null;
        
        name = "DIAMONDS";
        expResult = Suit.DIAMONDS;
        result = Suit.valueOf(name);
        assertEquals(expResult, result);
        
        name = "CLUBS";
        expResult = Suit.CLUBS;
        result = Suit.valueOf(name);
        assertEquals(expResult, result);
        
        name = "HEARTS";
        expResult = Suit.HEARTS;
        result = Suit.valueOf(name);
        assertEquals(expResult, result);
        
        name = "SPADES";
        expResult = Suit.SPADES;
        result = Suit.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Suit.
     */
    @Test
    public void testToString() {
        assertEquals(Suit.DIAMONDS.toString(), "Diamonds");
        assertEquals(Suit.CLUBS.toString()   , "Clubs"   );
        assertEquals(Suit.HEARTS.toString()  , "Hearts"  );
        assertEquals(Suit.SPADES.toString()  , "Spades"  );
    }
    
}
