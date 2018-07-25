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
public enum Rank {
    DEUCE   ("2"), 
    THREE   ("3"), 
    FOUR    ("4"), 
    FIVE    ("5"), 
    SIX     ("6"), 
    SEVEN   ("7"),
    EIGHT   ("8"), 
    NINE    ("9"), 
    TEN     ("10"), 
    JACK    ("Jack"), 
    QUEEN   ("Queen"), 
    KING    ("King"), 
    ACE     ("Ace");
    
    private String name;
    Rank(String name) { this.name = name; }

    public String toString() { return name; }
}
