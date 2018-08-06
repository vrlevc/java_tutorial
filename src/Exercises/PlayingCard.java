/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

/**
 *
 * @author lva
 */
public class PlayingCard implements Card {

    private final Rank rank;
    private final Suit suit;
    
    public PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    @Override
    public Rank getRank() {
        return rank;
    }
    
    @Override
    public Suit getSuit() {
        return suit;
    }
    
    @Override
    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }
    
    public int hashCode() {
        return ((suit.value()-1)*13)+rank.value();
    }
    
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}
