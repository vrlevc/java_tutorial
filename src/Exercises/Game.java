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
public class Game {
    
    public static void playGame() {
        
        System.out.println("");
        System.out.println("*********************************************************");
        System.out.println("*********************** GAME ****************************");
        System.out.println("*********************************************************");
        
        System.out.println("Create new deck.");
        Deck deck = new Deck();
        
        System.out.println("Print cards from the deck.");
        for (Card card : deck.getCards()) {
            System.out.println(card.getRank() + " " + card.getSuit());
        }
        
    }
    
}
