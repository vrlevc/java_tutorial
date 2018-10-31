/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lva
 */
public class OverridingAndHidingMethodsTest {
    
    private OutStream outStream = null;
    
    public OverridingAndHidingMethodsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        outStream = new OutStream();
    }
    
    @After
    public void tearDown() {
        outStream.restorOrigin();
        outStream = null;
    }

    @Test
    public void testStaticMethods() {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;

        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
        
        assertEquals(
            "The static method in Animal\n" +    
            "The instance method in Cat\n", 
            outStream.getString());
    }
}





























