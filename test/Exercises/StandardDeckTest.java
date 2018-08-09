/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
public class StandardDeckTest {
    
    public StandardDeckTest() {
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

    /**
     * Test of deckFactory method, of class StandardDeck.
     */
    @Test
    public void testDeckFactory() {
        System.out.println("deckFactory");
        StandardDeck instance = new StandardDeck();
        assertNotNull(instance);
        Deck result = instance.deckFactory();
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    /**
     * Test of size method, of class StandardDeck.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        StandardDeck instance = new StandardDeck();
        assertNotNull(instance);
        int expResult = Card.Suit.values().length * Card.Rank.values().length;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCards method, of class StandardDeck.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        StandardDeck instance = new StandardDeck();
        assertNotNull(instance);
        List<Card> result = instance.getCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class StandardDeck.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card card = null;
        StandardDeck instance = new StandardDeck();
        instance.addCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCards method, of class StandardDeck.
     */
    @Test
    public void testAddCards() {
        System.out.println("addCards");
        List<Card> cards = null;
        StandardDeck instance = new StandardDeck();
        instance.addCards(cards);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDeck method, of class StandardDeck.
     */
    @Test
    public void testAddDeck() {
        System.out.println("addDeck");
        Deck deck = null;
        StandardDeck instance = new StandardDeck();
        instance.addDeck(deck);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class StandardDeck.
     */
    @Test
    public void testSort_0args() {
        System.out.println("sort");
        StandardDeck instance = new StandardDeck();
        instance.sort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class StandardDeck.
     */
    @Test
    public void testSort_Comparator() {
        System.out.println("sort");
        Comparator<Card> c = null;
        StandardDeck instance = new StandardDeck();
        instance.sort(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class StandardDeck.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        StandardDeck instance = new StandardDeck();
        instance.shuffle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deckToString method, of class StandardDeck.
     */
    @Test
    public void testDeckToString() {
        System.out.println("deckToString");
        StandardDeck instance = new StandardDeck();
        String expResult = "";
        String result = instance.deckToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deal method, of class StandardDeck.
     */
    @Test
    public void testDeal() {
        System.out.println("deal");
        int players = 0;
        int numberOfCards = 0;
        StandardDeck instance = new StandardDeck();
        Map<Integer, Deck> expResult = null;
        Map<Integer, Deck> result = instance.deal(players, numberOfCards);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
