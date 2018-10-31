/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author lva
 */
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
