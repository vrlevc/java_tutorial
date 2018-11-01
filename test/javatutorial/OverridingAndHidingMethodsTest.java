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

    //-------------------------------------------------------------------------------------------
    
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
    
    //-------------------------------------------------------------------------------------------
    // Instance methods are preferred over interface default methods.
    
    interface Flyer {
        default public String identifyMyself() {
            return "I am able to fly.";
        }
    }
    interface Mythical {
        default public String identifyMyself() {
            return "I am a mythical creature.";
        }
    }
    
    @Test 
    public void testInterfaceMethods_A() {
        
        class Horse {
            public String identifyMyself() {
                return "I am a horse.";
            }
        }
        
        class Pegasus extends Horse implements Flyer, Mythical {
        }  
        
        Pegasus myApp = new Pegasus();
        assertEquals("I am a horse.", myApp.identifyMyself());        
    }
    
    //-------------------------------------------------------------------------------------------
    // Methods that are already overridden by other candidates are ignored. 
    // This circumstance can arise when supertypes share a common ancestor.
    
    public interface AnimalB {
        default public String identifyMyself() {
            return "I am an animal.";
        }
    }
    public interface EggLayer extends AnimalB {
        default public String identifyMyself() {
            return "I am able to lay eggs.";
        }
    }
    public interface FireBreather extends AnimalB { }
    
    @Test 
    public void testInterfaceMethods_B() {
        
        class Dragon implements EggLayer, FireBreather {}
        
        Dragon myApp = new Dragon();
        assertEquals("I am able to lay eggs.", myApp.identifyMyself());
    }
    
    // If two or more independently defined default methods conflict, 
    // or a default method conflicts with an abstract method, 
    // then the Java compiler produces a compiler error. 
    
    public interface OperateCarC {
        default public String startEngine() {
            return "Operate Car starts engine.";
        }
    }
    public interface FlyCarC {
        default public String startEngine() {
            return "Fly Car starts engine.";
        }
    }
    
    // You must explicitly override the supertype methods.
    
    public class FlyingCar implements OperateCarC, FlyCarC {
        public String startEngine() {
            String fc = FlyCarC.super.startEngine();
            String oc = OperateCarC.super.startEngine();
            return fc + oc;
        }
    }
    
    @Test 
    public void testInterfaceMethods_C() {
        FlyingCar car = new FlyingCar();
        assertEquals( "Fly Car starts engine."+"Operate Car starts engine.", car.startEngine() );
    }
    
    // Inherited instance methods from classes can override abstract interface methods.
    
    public interface MammalD {
        String identifyMyself();
    }
    public class HorseD {
        public String identifyMyself() {
            return "I am a horse.";
        }
    }
    public class MustangD extends HorseD implements MammalD {
    }
    
    @Test
    public void testInterfaceMethods_D() {
        MustangD myApp = new MustangD();
        assertEquals( "I am a horse.", myApp.identifyMyself() );
    }

}





























