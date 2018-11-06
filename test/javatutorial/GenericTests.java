/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitya
 */
public class GenericTests {

    /**
     * A Simple Box Class
     */
    class Box_ {
        private Object object;
        
        public void set(Object object) { this.object = object; }
        public Object get() { return object; }
    }
    
    /**
     * A GenericTests Version of the Box Class.
     * @param <T> the type of the value being boxed
     */
    class Box<T> {
        // T sands for "Type"
        private T t;
        
        public void set(T t) { this.t = t; }
        public T get() { return t; }
    }
    
    // E - Element (used extensively by the Java Collections Framework)
    // K - Key
    // N - Number
    // T - Type
    // V - Value
    // S,U,V etc. - 2nd, 3rd, 4th types
    
    private static class Pair<K, V> {
        
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public void setKey(K key) { this.key = key; }
        public void setValue(V value) { this.value = value; }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
    
    // The syntax for a generic method includes a list of type parameters, 
    // inside angle brackets, which appears before the method's return type. 
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {  
        return  p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
    
    @Test
    public void testComparePairs() {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        
        boolean sameA = GenericTests.<Integer, String>compare(p1, p2);
        assertFalse(sameA);
        
        boolean sameB = GenericTests.compare(p1, p2);
        assertFalse(sameB);
    }
    
    // extends :
    // Bounded Type Parameters
    
    public <U extends Number> void inspect(U u) {
        
    }
    
    @Test
    public void testBoundedType() {
        inspect(10);
        inspect(new Integer(10));
//      inspect("some text"); // error: this is still String!
    }
    
    // Multiple Bounds
    // If one of the bounds is a class, it must be specified first.
    
    class A { /* ... */ }
    interface B { /* ... */ }
    interface C { /* ... */ }

    class D <T extends A & B & C> { /* ... */ }
//  class D <T extends B & A & C> { /* ... */ }  // compile-time error
    
    
    // GenericTests Methods and Bounded Type Parameters
    
    public interface Comparable<T> {
        public int compareTo(T o);
    }
    
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0) 
                ++count;
        return count;
    }
    
    // Type Inference and Generic Methods
    
    <U> void addBox(U u, List<Box<U>> boxes) 
    {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }
    
    <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U content = box.get();
            System.out.println("Box #" + counter + " contains [" + content.toString() + "]");
            ++counter;
        }
    }
    
    @Test
    public void testTypeInterfaceAndGenericMethods() {
        
        ArrayList<Box<Integer>> listOfIntBoxes = new ArrayList<>();
        
        this.<Integer>addBox(Integer.valueOf(10), listOfIntBoxes);
        this.addBox(Integer.valueOf(20), listOfIntBoxes);
        this.addBox(30, listOfIntBoxes);
        addBox(40, listOfIntBoxes);
        
        outputBoxes(listOfIntBoxes);
    }
}
