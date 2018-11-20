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
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
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
            BufferedInputStream bufIN = new BufferedInputStream(new FileInputStream("xanadu.txt"));
            BufferedOutputStream bufOUT = new BufferedOutputStream(new FileOutputStream("outagain.txt"))
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
            BufferedReader bufferedInput = new BufferedReader(new FileReader("xanadu.txt"));
            BufferedWriter bufferedOutput = new BufferedWriter(new FileWriter("outagain.txt"))
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
            BufferedReader inBufferedStream = new BufferedReader(new FileReader("xanadu.txt"));
            PrintWriter outPrintStream = new PrintWriter(new FileWriter("outagain.txt"))
        ) {
            String l;
            while ( ( l = inBufferedStream.readLine() ) != null ) {
                outPrintStream.println(l);
            }
        }
    }
    
    @Test
    public void testScanXan() throws FileNotFoundException, IOException {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")))) {
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
    }
    
    @Test
    public void testScanSum() throws FileNotFoundException, IOException {
        double sum = 0;
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")))){
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
    
    @Test
    public void testConsole() {
        Console c = System.console();
        if (c == null) {
            System.out.println("No console.");
        }
        assertNotNull(c);
        
        String login = c.readLine("Enter your login: ");
        char [] oldPassword = c.readPassword("Enter your old password: ");

        if (verify(login, oldPassword)) {
            boolean noMatch;
            do {
                char [] newPassword1 = c.readPassword("Enter your new password: ");
                char [] newPassword2 = c.readPassword("Enter new password again: ");
                noMatch = ! Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwords don't match. Try again.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);
        }

        Arrays.fill(oldPassword, ' ');
    }
    
    // Dummy change method.
    static boolean verify(String login, char[] password) {
        // This method always returns
        // true in this example.
        // Modify this method to verify
        // password according to your rules.
        return true;
    }

    // Dummy change method.
    static void change(String login, char[] password) {
        // Modify this method to change
        // password according to your rules.
    }
    
    //----------------------------------------------------------------------------------------------
    // DATA STREAMS
    
    static final String dataFile  = "invoicedata";
        
    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = {
        "Java T-shirt",
        "Java Mug",
        "Duke Juggling Dolls",
        "Java Pin",
        "Java Key Chain"
    };
    
    public static void createInvoice() throws IOException {
        try (DataOutputStream out = 
                new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dataFile))))
        {
            for (int i=0; i<prices.length; i++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        }
    }
    
    public static void printInvoice() throws IOException {
        double total = 0;
        try (DataInputStream in = 
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream(dataFile))))
        {
            double price;
            int unit;
            String desc;
            while (true) {
                price = in.readDouble();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d units of %s as $%.2f %n", unit, desc, price);
                total += unit * price;
            }
        } catch (EOFException e) { }
        System.out.format("For a TOTAL of: $%.2f %n", total);
    }
    
    @Test 
    public void testCreateInvoice() throws IOException {
        createInvoice();
    }
    
    @Test
    public void testPrintInvoice() throws IOException {
        printInvoice();
    }
    
    //----------------------------------------------------------------------------------------------
    // OBJECT STREAMS
    
    static final String dataFileObj  = "invoicedataObj";
    static final BigDecimal[] pricesObj = { 
        new BigDecimal("19.99"), 
        new BigDecimal("9.99"),
        new BigDecimal("15.99"),
        new BigDecimal("3.99"),
        new BigDecimal("4.99") 
    };
    
    public static void createInvoiceObj() throws IOException {
       try (ObjectOutputStream out = 
                new ObjectOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream(dataFileObj))))
        {
            out.writeObject(Calendar.getInstance());
            for (int i=0; i<prices.length; i++) {
                out.writeObject(pricesObj[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } 
    }
    
    public static void printInvoiceObj() throws IOException, ClassNotFoundException {
        BigDecimal total = new BigDecimal(0);
        try (ObjectInputStream in = 
                new ObjectInputStream(
                    new BufferedInputStream(
                        new FileInputStream(dataFileObj))))
        {
            BigDecimal price;
            int unit;
            String desc;
            
            Calendar date = (Calendar) in.readObject();
            System.out.format ("On %tA, %<tB %<te, %<tY:%n", date);
            
            while (true) {
                price = (BigDecimal) in.readObject();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d units of %s as $%.2f %n", unit, desc, price);
                total = total.add(price.multiply(new BigDecimal(unit)));
            }
        } catch (EOFException e) { }
        System.out.format("For a TOTAL of: $%.2f %n", total);
    }
    
    @Test 
    public void testCreateInvoiceObj() throws IOException {
        createInvoiceObj();
    }
    
    @Test
    public void testPrintInvoiceObj() throws IOException, ClassNotFoundException {
        printInvoiceObj();
    }
}
