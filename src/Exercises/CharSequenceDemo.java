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
        if (start < 0) {
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end > s.length()) {
            throw new StringIndexOutOfBoundsException(end);
        }
        if (start > end) {
            throw new StringIndexOutOfBoundsException(start - end);
        }
        StringBuilder sub = 
            new StringBuilder(s.subSequence(fromEnd(end), fromEnd(start)));
        return sub.reverse();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder(this.s);
        return s.reverse().toString();
    }
    
}
