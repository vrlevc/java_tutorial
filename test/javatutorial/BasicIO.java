/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author vitya
 */
public class BasicIO {

    @Test
    public void testCopyBytes() throws FileNotFoundException, IOException {
        
        try (
            FileInputStream in = new FileInputStream("xanadu.txt");
            FileOutputStream out = new FileOutputStream("outagain.txt") 
        ) {
            int c;
            while ( (c = in.read()) != -1 ) {
                out.write(c);
            }
        }
        
    }
    
    @Test
    public void testCopyBytesBuffered() throws FileNotFoundException, IOException {
        
        try (
            FileInputStream in = new FileInputStream("xanadu.txt");
            BufferedInputStream bufIN = new BufferedInputStream(in);
            FileOutputStream out = new FileOutputStream("outagain.txt");
            BufferedOutputStream bufOUT = new BufferedOutputStream(out)
        ) {
            int c;
            while ( (c = bufIN.read()) != -1 ) {
                bufOUT.write(c);
            }
            bufOUT.flush();
        }
        
    }
    
    @Test 
    public void testCopyCharacters() throws FileNotFoundException, IOException {
        
        try (
            FileReader inputStream  = new FileReader("xanadu.txt");
            FileWriter outputStream = new FileWriter("outagain.txt")
        ) {
            int c;
            while ( (c = inputStream.read()) != -1 ) {
                outputStream.write(c);
            }
            outputStream.flush();
        }        
    }
    
    @Test 
    public void testCopyCharactersBuffered() throws FileNotFoundException, IOException {
        
        try (
            FileReader inputStream  = new FileReader("xanadu.txt");
            BufferedReader bufferedInput = new BufferedReader(inputStream);
            FileWriter outputStream = new FileWriter("outagain.txt");
            BufferedWriter bufferedOutput = new BufferedWriter(outputStream)
        ) {
            int c;
            while ( (c = bufferedInput.read()) != -1 ) {
                bufferedOutput.write(c);
            }
        }        
    }
    
    @Test
    public void testCopyLines() throws FileNotFoundException, IOException {
        
        try (
            FileReader inFileStream = new FileReader("xanadu.txt");
            BufferedReader inBufferedStream = new BufferedReader(inFileStream);
            FileWriter outFileStream = new FileWriter("outagain.txt");
            PrintWriter outPrintStream = new PrintWriter(outFileStream)
        ) {
            String l;
            while ( ( l = inBufferedStream.readLine() ) != null ) {
                outPrintStream.println(l);
            }
        }
    }
    
    @Test
    public void testScanXan() throws FileNotFoundException, IOException {
        try (
            FileReader fr = new FileReader("xanadu.txt");
            BufferedReader br = new BufferedReader(fr);
            Scanner s = new Scanner(br) 
        ) {
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }
    
    @Test
    public void testScanSum() throws FileNotFoundException, IOException {
        double sum = 0;
        try (
            FileReader in = new FileReader("usnumbers.txt");
            BufferedReader source = new BufferedReader(in);
            Scanner s = new Scanner(source)
        ){
            s.useLocale(Locale.US);
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }
        }
        System.out.println("Sum is " + sum);
    }
    
    @Test
    public void testFormat() {
        System.out.format("Teh square root of %d is %f.%n", 2, Math.sqrt(2));
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        System.out.format("%f, %<+020.10f %n", Math.PI);
    }
}
