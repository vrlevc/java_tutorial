/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import java.util.*;

public interface Deck {

    Deck deckFactory();    
    int size();
    List<Card> getCards();
    void addCard(Card card);
    void addCards(List<Card> cards);
    void addDeck(Deck deck);
    void sort();
    void sort(Comparator<Card> c);    
    void shuffle();
    String deckToString();
    
    Map<Integer, Deck> deal(int players, int numberOfCards)
            throws IllegalArgumentException;
    
}
