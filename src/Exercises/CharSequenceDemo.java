/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

/**
 *
 * @author vitya
 */
public class CharSequenceDemo implements CharSequence {

    private String s;
    
    public CharSequenceDemo(String s) {
        this.s = s;
    }
    
    private int fromEnd(int index) {
        return ( s.length() - 1 ) - index;
    }
    
    @Override
    public int length() {
        return s.length();
    }

    @Override
    public char charAt(int index) {
        if ( index < 0 || index >= s.length() ) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return s.charAt( fromEnd(index) );
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        
    }
    
}
