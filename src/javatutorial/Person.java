/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class Person {
    
    // @interface CheckPerson
    
    interface CheckPerson {
        boolean test(Person person);
    }

    public static List<Person> createRoster() {
        List<Person> roster = new LinkedList<>();
        roster.add(new Person("Vitya",    38, Sex.MALE));
        roster.add(new Person("Olga",     38, Sex.FEMALE));
        roster.add(new Person("Nastia",   13, Sex.FEMALE));
        roster.add(new Person("Dima",     29, Sex.MALE));
        roster.add(new Person("Alina",    29, Sex.FEMALE));
        roster.add(new Person("Valentin",  1, Sex.MALE));
        roster.add(new Person("Ivan",     35, Sex.MALE));
        roster.add(new Person("Diana",    29, Sex.FEMALE));
        roster.add(new Person("Nika",      5, Sex.FEMALE));
        roster.add(new Person("Helen",    61, Sex.FEMALE));
        roster.add(new Person("Tolik",    62, Sex.MALE));
        return roster;
    }
    
    public static int comparePersonsByAge(Person a, Person b) {
        if ( a.getAge() == b.getAge() ) return 0;
        return (a.getAge() < b.getAge() ? -1 : +1);
    }
    
    public enum Sex { 
        MALE    ("Male"), 
        FEMALE  ("Female");
        private final String name;
        Sex(String name) { this.name = name; }
        public String getName() { return this.name; }
    }
    
    private final String name;
    private final int    age;
    private final Sex    gender;
    
    public Person(String name, int age, Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public Sex getGender() {
        return gender;
    }
     
    public void printPerson() {
        System.out.println((gender == Sex.MALE ? "Mr. " : "Ms. ") + name + " is " + age);
    }
    
    // Approach 1: Create Methods that Search for Presons that Match One Characteristic
    
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person person : roster) {
            if (person.getAge() >= age) {
                person.printPerson();
            }
        }
    }
    
    // Approach 2: Create More Generalized Search Methods
    
    static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person person : roster) {
            if (low <= person.getAge() && person.getAge() <= high) {
                person.printPerson();
            }
        }
    }
    
    // Approach 3: Specify Search Criteris Code in a Local Class
    // Approach 4: Specify Search Criteria Code in an Anonymous Class
    // Approach 5: Specify Search Criteria Code with a Lambda Expression
    
    static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person person : roster) {
            if (tester.test(person)) {
                person.printPerson();
            }
        }
    }
    
    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions
    
    static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person person : roster) {
            if (tester.test(person)) {
                person.printPerson();
            }
        }
    }
}
