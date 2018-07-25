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
public enum Suit {
    DIAMONDS ("Diamonds"),
    CLUBS    ("Clubs"), 
    HEARTS   ("Hearts"), 
    SPADES   ("Spades"); 
    
    private final String name;
    Suit(String name) { this.name = name; }
    
    public String toString() { return name; }
}
