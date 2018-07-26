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
    
    class OutStream {
        private final PrintStream originOutStream ;
        private final ByteArrayOutputStream currentOutStream;
        OutStream() {
            originOutStream = System.out;
            currentOutStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(currentOutStream));
        }
        void restorOrigin() {
            System.setOut(originOutStream);
        }
        void reset() {
            currentOutStream.reset();
        }
        String getString() {
            return currentOutStream.toString();
        }
    }
    
    private OutStream outStream = null;
    private List<Person> roster = null;
    
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
        outStream = new OutStream();
        roster = Person.createRoster();
    }
    
    @After
    public void tearDown() {
        outStream.restorOrigin();
        outStream = null;
        roster = null;
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
        String result = "Just a string for write into out stream.";
        System.out.print(result);
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testPrintPerson() {
        String result = "Mr. Vitya is 39\n";
        Person vitya = new Person("Vitya", 39, Person.Sex.MALE);
        vitya.printPerson();
        assertEquals(result, outStream.getString());
        
        outStream.reset();
        
        result = "Ms. Olga is 39\n";
        Person olga = new Person("Olga", 39, Person.Sex.FEMALE);
        olga.printPerson();
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testPrintPersonsOlderThan() {
        String result = "Mr. Vitya is 38\n" +
                        "Ms. Olga is 38\n"  +
                        "Mr. Ivan is 35\n"  +
                        "Ms. Helen is 61\n" +
                        "Mr. Tolik is 62\n";        
        Person.printPersonsOlderThan(roster, 30);
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testPrintPersonsWithinAgeRange() {
        String result = "Mr. Vitya is 38\n" +
                        "Ms. Olga is 38\n"  +
                        "Mr. Ivan is 35\n";     
        Person.printPersonsWithinAgeRange(roster, 30, 50);
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testSearchCriterisByLocalClass() {
        String result = "Ms. Olga is 38\n"   +
                        "Ms. Nastia is 13\n" +
                        "Ms. Alina is 29\n"  +
                        "Ms. Diana is 29\n";
        
        class CheckPersonEligibleForSelectiveService implements Person.CheckPerson 
        {
            @Override
            public boolean test(Person person) {
                return     person.getGender() == Person.Sex.FEMALE
                        && person.getAge()    >= 10
                        && person.getAge()    <= 50;
            }
        }
        
        Person.printPersons(roster, new CheckPersonEligibleForSelectiveService());
        
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testSearchCriterisByAnonymosClass() {
        String result = "Ms. Olga is 38\n"   +
                        "Ms. Nastia is 13\n" +
                        "Ms. Alina is 29\n"  +
                        "Ms. Diana is 29\n";
        
        Person.printPersons(roster, new Person.CheckPerson() {
            @Override
            public boolean test(Person person) {
                return     person.getGender() == Person.Sex.FEMALE
                        && person.getAge()    >= 10
                        && person.getAge()    <= 50;
            }
        });
        
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testSearchCriterisByLambdaExpression() {
        String result = "Ms. Olga is 38\n"   +
                        "Ms. Nastia is 13\n" +
                        "Ms. Alina is 29\n"  +
                        "Ms. Diana is 29\n";
        
        Person.printPersons(roster, 
                (Person person) -> 
                       person.getGender() == Person.Sex.FEMALE
                    && person.getAge()    >= 10
                    && person.getAge()    <= 50
        );
        
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testSearchUseStandardFunctionalInterfacesWithLambdaExpressions() {
        String result = "Ms. Olga is 38\n"   +
                        "Ms. Nastia is 13\n" +
                        "Ms. Alina is 29\n"  +
                        "Ms. Diana is 29\n";
        
        Person.printPersonsWithPredicate(roster,
            person -> 
                   person.getGender() == Person.Sex.FEMALE
                && person.getAge() >= 10
                && person.getAge() <= 50
        ); 
        
        assertEquals(result, outStream.getString());
    }
}
