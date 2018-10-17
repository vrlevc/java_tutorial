/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitya
 */
public class CharSequenceDemoTest {
    
    public CharSequenceDemoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Helper function for test main functionality.
     * @param max
     * @return 
     */
    private static int random(int max) {
        return (int) Math.round(Math.random() * (max+1));
    }
    
    /**
     * Integration test case for all methods:
     */
    @Test
    public void testMain() {
        System.out.println("-- CharSequenceDemo  --");
        
        CharSequenceDemo s =
            new CharSequenceDemo("Write a class that implements the CharSequence interface found in the java.lang package.");

        //exercise charAt() and length()
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
        
        System.out.println("");

        //exercise subSequence() and length();
        int start = random(s.length() - 1);
        int end = random(s.length() - 1 - start) + start;
        System.out.println(s.subSequence(start, end));

        //exercise toString();
        System.out.println(s);
        
        System.out.println("-- ----------------  --");
    }
    
    /**
     * Test of length method, of class CharSequenceDemo.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        String testData = "Test String";
        CharSequenceDemo instance = new CharSequenceDemo(testData);
        int expResult = testData.length();
        int result = instance.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of charAt method, of class CharSequenceDemo.
     */
    @Test
    public void testCharAt() {
        System.out.println("charAt");
        String testData = "Test String";
        int index = 2;
        CharSequenceDemo instance = new CharSequenceDemo(testData);
        char expResult = 'i';
        char result = instance.charAt(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of subSequence method, of class CharSequenceDemo.
     */
    @Test
    public void testSubSequence() {
        System.out.println("subSequence");
        String testData = "Test String";
        String expData  = "gnirtS tseT";
        int start = 1;
        int end = 5;
        CharSequenceDemo instance = new CharSequenceDemo(testData);
        CharSequence expResult = expData.subSequence(start+1, end+1);
        CharSequence result = instance.subSequence(start, end);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of toString method, of class CharSequenceDemo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String testData = "Test String";
        CharSequenceDemo instance = new CharSequenceDemo(testData);
        String expResult = "gnirtS tseT";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
