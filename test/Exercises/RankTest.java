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
        Rank[] expResult = new Rank[] { Rank.DEUCE, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX,
                                        Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK,
                                        Rank.QUEEN, Rank.KING, Rank.ACE 
                                      };
        
        Rank[] result = Rank.values();
        assertArrayEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Rank.
     */
    @Test
    public void testValueOf() {
        String name = null;
        Rank expResult = null;
        Rank result = null;
        
        name = "DEUCE";
        expResult = Rank.DEUCE;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);

        name = "THREE";
        expResult = Rank.THREE;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "FOUR";
        expResult = Rank.FOUR;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "FIVE";
        expResult = Rank.FIVE;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "SIX";
        expResult = Rank.SIX;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "SEVEN";
        expResult = Rank.SEVEN;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "EIGHT";
        expResult = Rank.EIGHT;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "NINE";
        expResult = Rank.NINE;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "TEN";
        expResult = Rank.TEN;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "JACK";
        expResult = Rank.JACK;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "QUEEN";
        expResult = Rank.QUEEN;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "KING";
        expResult = Rank.KING;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
        
        name = "ACE";
        expResult = Rank.ACE;
        result = Rank.valueOf(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of valueOf method, of class Rank.
     */
    @Test
    public void testToString() {
        assertEquals(Rank.DEUCE.toString()  , "2");
        assertEquals(Rank.THREE.toString()  , "3");
        assertEquals(Rank.FOUR.toString()   , "4");
        assertEquals(Rank.FIVE.toString()   , "5");
        assertEquals(Rank.SIX.toString()    , "6");
        assertEquals(Rank.SEVEN.toString()  , "7");
        assertEquals(Rank.EIGHT.toString()  , "8");
        assertEquals(Rank.NINE.toString()   , "9");
        assertEquals(Rank.TEN.toString()    , "10");
        assertEquals(Rank.JACK.toString()   , "Jack");
        assertEquals(Rank.QUEEN.toString()  , "Queen");
        assertEquals(Rank.KING.toString()   , "King");
        assertEquals(Rank.ACE.toString()    , "Ace");
    }
}
