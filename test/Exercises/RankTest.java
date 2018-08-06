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
 * @author lva
 */
public class RankTest {
    
    public RankTest() {
    }
    
    /**
     * Test of values method, of class Rank.
     */
    @Test
    public void testValues() {
        Card.Rank[] expResult 
            = new Card.Rank[] { 
                Card.Rank.DEUCE, Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FIVE, Card.Rank.SIX,
                Card.Rank.SEVEN, Card.Rank.EIGHT, Card.Rank.NINE, Card.Rank.TEN, Card.Rank.JACK,
                Card.Rank.QUEEN, Card.Rank.KING, Card.Rank.ACE 
            };
        
        Card.Rank[] result = Card.Rank.values();
        assertArrayEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Rank.
     */
    @Test
    public void testValueOf() {
        String name = null;
        Card.Rank expResult = null;
        Card.Rank result = null;
        
        name = "DEUCE";
        expResult = Card.Rank.DEUCE;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);

        name = "THREE";
        expResult = Card.Rank.THREE;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "FOUR";
        expResult = Card.Rank.FOUR;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "FIVE";
        expResult = Card.Rank.FIVE;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "SIX";
        expResult = Card.Rank.SIX;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "SEVEN";
        expResult = Card.Rank.SEVEN;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "EIGHT";
        expResult = Card.Rank.EIGHT;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "NINE";
        expResult = Card.Rank.NINE;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "TEN";
        expResult = Card.Rank.TEN;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "JACK";
        expResult = Card.Rank.JACK;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "QUEEN";
        expResult = Card.Rank.QUEEN;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "KING";
        expResult = Card.Rank.KING;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "ACE";
        expResult = Card.Rank.ACE;
        result = Card.Rank.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of valueOf method, of class Rank.
     */
    @Test
    public void testToString() {
        assertEquals("DEUCE",   Card.Rank.DEUCE.toString());
        assertEquals("THREE",   Card.Rank.THREE.toString());
        assertEquals("FOUR",    Card.Rank.FOUR.toString());
        assertEquals("FIVE",    Card.Rank.FIVE.toString());
        assertEquals("SIX",     Card.Rank.SIX.toString());
        assertEquals("SEVEN",   Card.Rank.SEVEN.toString());
        assertEquals("EIGHT",   Card.Rank.EIGHT.toString());
        assertEquals("NINE",    Card.Rank.NINE.toString());
        assertEquals("TEN",     Card.Rank.TEN.toString());
        assertEquals("JACK",    Card.Rank.JACK.toString());
        assertEquals("QUEEN",   Card.Rank.QUEEN.toString());
        assertEquals("KING",    Card.Rank.KING.toString());
        assertEquals("ACE",     Card.Rank.ACE.toString());
    }
    
    @Test
    public void testValue() {
        assertEquals( 2, Card.Rank.DEUCE.value());
        assertEquals( 3, Card.Rank.THREE.value());
        assertEquals( 4, Card.Rank.FOUR.value() );
        assertEquals( 5, Card.Rank.FIVE.value() );
        assertEquals( 6, Card.Rank.SIX.value()  );
        assertEquals( 7, Card.Rank.SEVEN.value());
        assertEquals( 8, Card.Rank.EIGHT.value());
        assertEquals( 9, Card.Rank.NINE.value() );
        assertEquals(10, Card.Rank.TEN.value()  );
        assertEquals(11, Card.Rank.JACK.value() );
        assertEquals(12, Card.Rank.QUEEN.value());
        assertEquals(13, Card.Rank.KING.value() );
        assertEquals(14, Card.Rank.ACE.value()  );
    }
    
    @Test
    public void testText() {
        assertEquals("Two", Card.Rank.DEUCE.text());
        assertEquals("Three", Card.Rank.THREE.text());
        assertEquals("Four", Card.Rank.FOUR.text() );
        assertEquals("Five", Card.Rank.FIVE.text() );
        assertEquals("Six", Card.Rank.SIX.text()  );
        assertEquals("Seven", Card.Rank.SEVEN.text());
        assertEquals("Eight", Card.Rank.EIGHT.text());
        assertEquals("Nine", Card.Rank.NINE.text() );
        assertEquals("Ten", Card.Rank.TEN.text()  );
        assertEquals("Jack", Card.Rank.JACK.text() );
        assertEquals("Quin", Card.Rank.QUEEN.text());
        assertEquals("King", Card.Rank.KING.text() );
        assertEquals("Ace", Card.Rank.ACE.text()  );
    }
}
