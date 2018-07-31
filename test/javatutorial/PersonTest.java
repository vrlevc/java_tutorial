/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.util.List;
import java.io.*;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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
    
    @Test
    public void testLamdas() {
        String resultExpected = "Olga Nastia Alina Diana ";
        
        roster
            .stream()
            .filter(
                p ->    p.getGender() == Person.Sex.FEMALE 
                     && p.getAge() >= 10            
                     && p.getAge() <= 50 )
            .map(
                p ->    p.getName())
            .forEach(
                name -> System.out.print(name + " "));
        
        assertEquals(resultExpected, outStream.getString());
    }
        
    @Test
    public void testLamdasFunction() {
        String resultExpected = "Olga Nastia Alina Diana ";
        
        Predicate<Person> isEdult = 
                person -> 
                        person.getGender() == Person.Sex.FEMALE
                    &&  person.getAge() >= 10
                    &&  person.getAge() <= 50; 
        
        Function<Person, String> getName =
                person -> person.getName();
        
        Consumer<String> print = name -> System.out.print(name + " ");
        
        roster.stream().filter(isEdult).map(getName).forEach(print);
        
        assertEquals(resultExpected, outStream.getString());
    }
    
    @Test
    public void testArraySortLamda() {
        String result  = "Valentin:1 Nika:5 Nastia:13 Dima:29 Alina:29 "
                       + "Diana:29 Ivan:35 Vitya:38 Olga:38 Helen:61 Tolik:62 ";
        
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
        
        Arrays.sort(rosterAsArray, 
                (Person personA, Person personB) -> { 
                    if ( personA.getAge() == personB.getAge() ) return 0;
                    return (personA.getAge() < personB.getAge() ? -1 : +1); 
                } 
        );
        
        for(Person p : rosterAsArray)
            System.out.print( p.getName() + ":" + p.getAge() + " " );
        
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testArraySortLambdaClassFunction() {
        String result  = "Valentin:1 Nika:5 Nastia:13 Dima:29 Alina:29 "
                       + "Diana:29 Ivan:35 Vitya:38 Olga:38 Helen:61 Tolik:62 ";
        
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
        
        Arrays.sort(rosterAsArray, (pa, pb) -> Person.comparePersonsByAge(pa, pb) );
        
        for(Person p : rosterAsArray)
            System.out.print( p.getName() + ":" + p.getAge() + " " );
        
        assertEquals(result, outStream.getString());
    }
    
    @Test
    public void testArraySortClassFunction() {
        String result  = "Valentin:1 Nika:5 Nastia:13 Dima:29 Alina:29 "
                       + "Diana:29 Ivan:35 Vitya:38 Olga:38 Helen:61 Tolik:62 ";
        
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
        
        Arrays.sort(rosterAsArray, Person::comparePersonsByAge);
        
        for(Person p : rosterAsArray)
            System.out.print( p.getName() + ":" + p.getAge() + " " );
        
        assertEquals(result, outStream.getString());
    }
}
