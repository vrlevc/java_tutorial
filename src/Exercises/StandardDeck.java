/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author lva
 */
public class StandardDeck implements Deck {
    
    private List<Card> entireDeck;
    
    public StandardDeck(List<Card> existingList) {
        this.entireDeck = existingList;
    }
    
    public StandardDeck() {
        this.entireDeck = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                this.entireDeck.add(new PlayingCard(r, s));
            }
        }
    }
    
    @Override
    public Deck deckFactory() {
        return new StandardDeck(new ArrayList<Card>());
    }
    
    @Override
    public int size() {
        return entireDeck.size();
    }

    @Override
    public List<Card> getCards() {
        return entireDeck;
    }

    @Override
    public void addCard(Card card) {
        entireDeck.add(card);
    }

    @Override
    public void addCards(List<Card> cards) {
        entireDeck.addAll(cards);
    }

    @Override
    public void addDeck(Deck deck) {
        List<Card> listToAdd = deck.getCards();
        entireDeck.addAll(listToAdd);
    }
    
    @Override
    public void sort() {
        Collections.sort(entireDeck);
    }

    @Override
    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(entireDeck);
    }

    @Override
    public String deckToString() {
        return this.entireDeck
                .stream()
                .map(Card::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public Map<Integer, Deck> deal(int players, int numberOfCards) 
            throws IllegalArgumentException 
    {
        int cardsDealt = players * numberOfCards;
        int sizeOfDeck = entireDeck.size();
        if (cardsDealt > sizeOfDeck) {
            throw new IllegalArgumentException(
                "Number of players (" + players +
                ") times number of cards to e dealt (" + numberOfCards +
                ") is greater then the number of cards in the deck (" +
                sizeOfDeck + ").");
        }
        
        Map<Integer, List<Card>> dealtDeck = entireDeck
                .stream()
                .collect(
                    Collectors.groupingBy(
                        card -> {
                            int cardIndex = entireDeck.indexOf(card);
                            if (cardIndex >= cardsDealt) return (players + 1);
                            else return (cardIndex % players) + 1;
                        }));
        
        // Convert Map<Integer, List<Card>> to Map<Integer, Deck>
        Map<Integer, Deck> mapToReturn = new HashMap<>();
        
        for (int i = 1; i <= (players + 1); i++) {
            Deck currectDeck = deckFactory();
            currectDeck.addCards(dealtDeck.get(i));
            mapToReturn.put(i, currectDeck);
        }
        return mapToReturn;
    }
    
}
