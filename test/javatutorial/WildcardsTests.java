/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitya
 */
public class WildcardsTests {
    
    // Upper Bounded Wildcards
    
    double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n: list) {
            sum += n.doubleValue();
        }
        return sum;
    }
    
    @Test
    public void testSumOfList() {
        
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
        
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
        
    }
    
    // Unbounded Wildcards
    
    void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
    
    @Test
    public void testPrintList() {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }
    
    // Lower Bounded Wildcards
    
    void addNumbers(List<? super Integer> list) {
        // Works for List<Object>, List<Number>, List<Integer>
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
    
    
    
}
