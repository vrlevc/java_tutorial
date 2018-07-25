/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.util.LinkedList;
import java.util.List;


public class Person {

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
    
    private String name;
    private int age;
    private Sex gender;
    
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
}
