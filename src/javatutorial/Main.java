package javatutorial;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import Exercises.*;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Hello Java!!!");
        
        byte    a; //  8-bit signed
        short   b; // 16-bit signed
        int     c; // 32-bit signed
        long    d; // 64-bit signed
        float   e; // 32-bit
        double  f; // 64-bit
        boolean g; // bool
        char    h; // 16-bit Unicode character
        
        int decVal = 26;
        int hexVal = 0x1a;
        int binVal = 0b11010;
        
        float fVal = 5.5f;
        double dVal = 5.5;
        
        // *.class - Class object
        System.out.println(String.class.getCanonicalName());
        
        // using _ for numbers
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi =  3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;

        int[] intArray = { 1,2,3,4,5,6 };
        String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
        
        // java.util.Arrays
        List<String> listA  = Arrays.asList(new String[] { "strA", "strB", "strC" });
        Character[] keys = new Character[] { 'a', 'b', 'c' };
        Character[] keysCopy = Arrays.copyOf(keys, keys.length);
        
        String num = "two";
        switch (num) {
            case "one": System.out.println("Selected : one"); break;
            case "two": System.out.println("Selected : two"); break;
        }
        
        int[] loop = {1,2,3,4,5};
        for (int i : loop)
            System.out.println(i);
        
        
        // Controll access
        
        //            Class  Package  Subclass World
        // public:      YES      YES       YES   YES
        // protected:   YES      YES       YES    NO
        // ------       YES      YES        NO    NO
        // private:     YES       NO        NO    NO
        
        // Inner class
        InnerClass data = new InnerClass();
        data.printEven();

        // Local class
        LocalClass.validatePhoneNumber("123-456-7890", "456-7890");
        
        // Lamdas
        
        List<Person> roster = Person.createRoster();
        
        roster
            .stream()
            .filter(
                p ->    p.getGender() == Person.Sex.FEMALE 
                     && p.getAge() >  12            
                     && p.getAge() <= 32 )
            .map(
                p ->    p.getName())
            .forEach(
                name -> System.out.println(name));
        
        Predicate<Person> isEdult = 
                person -> 
                        person.getGender() == Person.Sex.FEMALE
                    &&  person.getAge() > 12
                    &&  person.getAge() < 33; 
        
        Function<Person, String> getName =
                person -> person.getName();
        
        Consumer<String> print = name -> System.out.println(name);
        
        roster.stream().filter(isEdult).map(getName).forEach(print);
        
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
        Arrays.sort(rosterAsArray, 
                (Person personA, Person personB) -> { 
                    if ( personA.getAge() == personB.getAge() ) return 0;
                    return (personA.getAge() < personB.getAge() ? -1 : +1); 
                } 
        );
        System.out.println("----------------------------------------------");
        for (Person p : rosterAsArray) {
            System.out.print(p.getName() + " ");
        }
        System.out.println();
        
        Arrays.sort(rosterAsArray, (pa, pb) -> Person.comparePersonsByAge(pa, pb) );
        
        Arrays.sort(rosterAsArray, Person::comparePersonsByAge);
        
        // EXERCISES
        Game.playGame();
    }
    
}
