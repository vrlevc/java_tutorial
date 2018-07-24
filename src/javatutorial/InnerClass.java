/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

public class InnerClass {
    private final static int SIZE = 100;
    private int[] arrayOfInts = new int[SIZE];
    
    {
        for (int i=0; i<SIZE; ++i) {
            arrayOfInts[i] = i * 10;
        }
    }
    
    public void printEven() {
        InnerClassIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    
    interface InnerClassIterator extends java.util.Iterator<Integer> {}
    
    // Inner class
    
    private class EvenIterator implements InnerClassIterator {
        private int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < SIZE;
        }

        @Override
        public Integer next() {
            Integer value = arrayOfInts[currentIndex];
            currentIndex += 2;
            return value;
        }
        
    }
}
