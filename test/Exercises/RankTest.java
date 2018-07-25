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
 * @author lva
 */
public class RankTest {
    
    public RankTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
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
