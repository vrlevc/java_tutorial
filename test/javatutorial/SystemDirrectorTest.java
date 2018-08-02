/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.*;

/**
 *
 * @author lva
 */
public class SystemDirrectorTest {
    
    public SystemDirrectorTest() {
    }
    
    /**
     * Test of Computer method, of class SystemDirrector.
     */
    @Test
    public void testSubsystemAnotation() {
        System.out.println("Test Subsystem Anotation");
        for (Method m : SystemDirrector.class.getMethods()) {
            Boolean subsystem = m.getName().equals("Alarm")     ||
                                m.getName().equals("Allocator") ||
                                m.getName().equals("Computer");
            String testResult = subsystem ? " [@Subsystem]" : "";
            System.out.println(" -> Tested function : " + m.getName() + testResult);
            assertEquals(subsystem, m.isAnnotationPresent( Subsystem.class ) );
        }
    }

}
