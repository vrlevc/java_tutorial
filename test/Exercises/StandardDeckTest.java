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
        assertNotEquals(0, instance.size());
        
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
        assertNotNull(result);
        assertFalse(result.isEmpty());
        
        List<Card> cards = new ArrayList<>();
        cards.add(new PlayingCard(Card.Rank.ACE, Card.Suit.CLUBS));
        cards.add(new PlayingCard(Card.Rank.ACE, Card.Suit.DIAMONDS));
        cards.add(new PlayingCard(Card.Rank.DEUCE, Card.Suit.CLUBS));
        StandardDeck deckFromCards = new StandardDeck(cards);
        List<Card> deckCards = deckFromCards.getCards();
        assertEquals(deckCards, cards);
    }

    /**
     * Test of addCard method, of class StandardDeck.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card card = new PlayingCard(Card.Rank.ACE, Card.Suit.SPADES);
        StandardDeck instance = new StandardDeck(new ArrayList<>());
        
        assertFalse(instance.getCards().contains(card));
        instance.addCard(card);
        assertTrue(instance.getCards().contains(card));
    }

    /**
     * Test of addCards method, of class StandardDeck.
     */
    @Test
    public void testAddCards() {
        System.out.println("addCards");
        Card cardA = new PlayingCard(Card.Rank.ACE, Card.Suit.SPADES);
        Card cardB = new PlayingCard(Card.Rank.JACK, Card.Suit.DIAMONDS);
        Card cardC = new PlayingCard(Card.Rank.QUEEN, Card.Suit.CLUBS);
        List<Card> cards = new ArrayList<>();
        cards.add(cardA);
        cards.add(cardB);
        cards.add(cardC);
        StandardDeck instance = new StandardDeck(new ArrayList<>());
        
        assertFalse(instance.getCards().contains(cardA));
        assertFalse(instance.getCards().contains(cardB));
        assertFalse(instance.getCards().contains(cardC));
        instance.addCards(cards);
        assertTrue(instance.getCards().contains(cardA));
        assertTrue(instance.getCards().contains(cardB));
        assertTrue(instance.getCards().contains(cardC));
    }

    /**
     * Test of addDeck method, of class StandardDeck.
     */
    @Test
    public void testAddDeck() {
        System.out.println("addDeck");
        
        List<Card> cards = new ArrayList<>();
        cards.add(new PlayingCard(Card.Rank.ACE, Card.Suit.SPADES));
        cards.add(new PlayingCard(Card.Rank.JACK, Card.Suit.DIAMONDS));
        cards.add(new PlayingCard(Card.Rank.QUEEN, Card.Suit.CLUBS));
        Deck deckA = new StandardDeck(cards);
        
        cards = new ArrayList<>();
        cards.add(new PlayingCard(Card.Rank.EIGHT, Card.Suit.SPADES));
        cards.add(new PlayingCard(Card.Rank.FIVE, Card.Suit.CLUBS));
        cards.add(new PlayingCard(Card.Rank.SIX, Card.Suit.HEARTS));
        Deck deckB = new StandardDeck(cards);
        
        StandardDeck instance = new StandardDeck(new ArrayList<>());
        assertTrue(instance.size() == 0);
        instance.addDeck(deckA);
        assertEquals(deckA.getCards(), instance.getCards());
        instance.addDeck(deckB);
        deckA.addCards(deckB.getCards());
        assertEquals(deckA.getCards(), instance.getCards());
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
    
    @Test
    public void testSortByClass() {
        StandardDeck deck = new StandardDeck();
        deck.shuffle();
        deck.sort( new SortByRankThenSuit() );
    }
    
    @Test
    public void testSortByLambda() {
        StandardDeck deck = new StandardDeck();
        
        deck.shuffle();
        deck.sort( 
            (firstCard, secondCard) -> 
                firstCard.getRank().value() - secondCard.getRank().value() );
        
        deck.shuffle();
        deck.sort( Comparator.comparing((card) -> card.getRank()) );
        
        deck.shuffle();
        deck.sort( Comparator.comparing(Card::getRank) );
    }
    
    @Test
    public void testSortByTwoDim() {
        StandardDeck deck = new StandardDeck();
        
        deck.shuffle();
        deck.sort(
            (firstCard, secondCard) -> {
                int compare =
                    firstCard.getRank().value() - secondCard.getRank().value();
                if (compare != 0)
                    return compare;
                else
                    return firstCard.getSuit().value() - secondCard.getSuit().value();
            }      
        ); 
        
        deck.shuffle();
        deck.sort( 
            Comparator
                .comparing(Card::getRank)
                .thenComparing( Comparator.comparing(Card::getSuit) ) );
        
        
        deck.sort( 
            Comparator
                .comparing(Card::getRank)
                    .reversed()
                    .thenComparing( Comparator.comparing(Card::getSuit) ) );
    }    
}
