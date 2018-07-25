/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.util.List;
import java.io.*;
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
public class PersonTest {
    
    public PersonTest() {
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

    @Test 
    public void testPersonSex() {
        assertEquals(Person.Sex.values().length, 2);
        Person.Sex girl = Person.Sex.FEMALE;
        Person.Sex boy  = Person.Sex.MALE;
        assertEquals(girl.getName(), "Female");
        assertEquals(boy.getName(), "Male");
    }
    
    @Test
    public void testCreateRoster() {
        List<Person> result = Person.createRoster();
        assertTrue(!result.isEmpty());
    }

    @Test
    public void testComparePersonsByAge() {
        Person a = new Person("Olga", 39, Person.Sex.FEMALE);
        Person b = new Person("Viktor", 39, Person.Sex.MALE);
        Person c = new Person("Nastia", 13, Person.Sex.FEMALE);
        int ab_Result =  0;
        int ac_Result = +1;
        int cb_Result = -1;
        int result_ab = Person.comparePersonsByAge(a, b);
        int result_ac = Person.comparePersonsByAge(a, c);
        int result_cb = Person.comparePersonsByAge(c, b);
        assertEquals(ab_Result, result_ab);
        assertEquals(ac_Result, result_ac);
        assertEquals(cb_Result, result_cb);
    }

    @Test
    public void testGetName() {
        Person instance = new Person("Olga", 39, Person.Sex.FEMALE);
        String expResult = "Olga";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAge() {
        Person instance = new Person("Olga", 39, Person.Sex.FEMALE);
        int expResult = 39;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGender() {
        Person instance = new Person("Olga", 39, Person.Sex.FEMALE);
        Person.Sex expResult = Person.Sex.FEMALE;
        Person.Sex result = instance.getGender();
        assertEquals(expResult, result);
        
        instance = new Person("Viktor", 39, Person.Sex.MALE);
        expResult = Person.Sex.MALE;
        result = instance.getGender();
        assertEquals(expResult, result);
    }
    
    @Test 
    public void testSystemOutStream() {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        
        PrintStream originOut = System.out;
        System.setOut(new PrintStream(outStream));
        
        String result = "Just a string for write into out stream.";
        System.out.print(result);
        assertEquals(result, outStream.toString());
        
        System.setOut(originOut);
    }
}
