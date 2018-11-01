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

import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author vitya
 */
public class Numbers {
    
    private final float floatVar = 3.1415f;
    private final int intVar = 256;
    private final String stringVar = "Algebra";

    
    @Test
    public void hello() {
        System.out.format("..........%n");
        System.out.printf("..........%n");
        System.out.print("..........\n");
        System.out.println("..........");
    }
    
    @Test
    public void testFormater() {
        
        System.out.format(
            "The value of " + "the float variable is " +
            "%f, while the value of the " + "integer variable is %d, " +
            "and the string is %s%n", floatVar, intVar, stringVar);
        
        int i = 461012;
        // The %d specifies that the single variable is a decimal integer. 
        // The %n is a platform-independent newline character
        System.out.format("The value of i is: %d%n", i);
        
    }
    
    @Test
    public void testLocalizedFormater() {
        
        System.out.format(
            Locale.FRANCE,
            "The value of the float " + "variable is %f, while the " +
            "value of the integer variable " + "is %d, and the string is %s%n", 
            floatVar, intVar, stringVar);
        
        System.out.format(
            Locale.ENGLISH,
            "The value of the float " + "variable is %f, while the " +
            "value of the integer variable " + "is %d, and the string is %s%n", 
            floatVar, intVar, stringVar);
        
    }
 
    @Test
    public void testFormat() {
        
    //  Converter   Flag    Explanation
    //----------------------------------------------------------------------------------------------
    //  d                   A decimal integer.
    //  f                   A float.
    //  n                   A new line character appropriate to the platform running the application. You should always use %n, rather than \n.
    //  tB                  A date & time conversion—locale-specific full name of month.
    //  td, te              A date & time conversion—2-digit day of month. td has leading zeroes as needed, te does not.
    //  ty, tY              A date & time conversion—ty = 2-digit year, tY = 4-digit year.
    //  tl                  A date & time conversion—hour in 12-hour clock.
    //  tM                  A date & time conversion—minutes in 2 digits, with leading zeroes as necessary.
    //  tp                  A date & time conversion—locale-specific am/pm (lower case).
    //  tm                  A date & time conversion—months in 2 digits, with leading zeroes as necessary.
    //  tD                  A date & time conversion—date as %tm%td%ty
    //              08      Eight characters in width, with leading zeroes as necessary.
    //              +       Includes sign, whether positive or negative.
    //              ,       Includes locale-specific grouping characters.
    //              -       Left-justified..
    //              .3      Three places after decimal point.
    //              10.3    Ten characters in width, right justified, with three places after decimal point.
        
        long n = 461012;
        System.out.format("%d%n", n);      //  -->  "461012"
        System.out.format("%08d%n", n);    //  -->  "00461012"
        System.out.format("%+8d%n", n);    //  -->  " +461012"
        System.out.format("%,8d%n", n);    //  -->  " 461,012"
        System.out.format("%+,8d%n%n", n); //  -->  "+461,012"

        double pi = Math.PI;

        System.out.format("%f%n", pi);       // -->  "3.141593"
        System.out.format("%.3f%n", pi);     // -->  "3.142"
        System.out.format("%10.3f%n", pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n", pi);  // -->  "3.142"
        System.out.format(Locale.FRANCE,
                          "%-10.4f%n%n", pi);// -->  "3,1416"

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

        System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

        System.out.format("%tD%n", c);    // -->  "05/29/06"
    }
    
    static public void customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }
    
    @Test
    public void testDecimalFormat() {
        
        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);
        
    }
    
    @Test
    public void testBasicMath() {
        double a = -191.635;
        double b = 43.74;
        int c = 16, d = 45;

        System.out.printf("The absolute value " + "of %.3f is %.3f%n", 
                          a, Math.abs(a));

        System.out.printf("The ceiling of " + "%.2f is %.0f%n", 
                          b, Math.ceil(b));

        System.out.printf("The floor of " + "%.2f is %.0f%n", 
                          b, Math.floor(b));

        System.out.printf("The rint of %.2f " + "is %.0f%n", 
                          b, Math.rint(b));

        System.out.printf("The max of %d and " + "%d is %d%n",
                          c, d, Math.max(c, d));

        System.out.printf("The min of of %d " + "and %d is %d%n",
                          c, d, Math.min(c, d));
    }
    
    @Test
    public void testExponential() {
        double x = 11.635;
        double y = 2.76;

        System.out.printf("The value of " + "e is %.4f%n",
                          Math.E);

        System.out.printf("exp(%.3f) " + "is %.3f%n",
                          x, Math.exp(x));

        System.out.printf("log(%.3f) is " + "%.3f%n",
                          x, Math.log(x));

        System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n",
                          x, y, Math.pow(x, y));

        System.out.printf("sqrt(%.3f) is " + "%.3f%n",
                          x, Math.sqrt(x));
    }
    
    
    @Test
    public void testTrigonometric() {
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);
        
        System.out.format("The value of pi " + "is %.4f%n",
                           Math.PI);

        System.out.format("The sine of %.1f " + "degrees is %.4f%n",
                          degrees, Math.sin(radians));

        System.out.format("The cosine of %.1f " + "degrees is %.4f%n",
                          degrees, Math.cos(radians));

        System.out.format("The tangent of %.1f " + "degrees is %.4f%n",
                          degrees, Math.tan(radians));

        System.out.format("The arcsine of %.4f " + "is %.4f degrees %n", 
                          Math.sin(radians), 
                          Math.toDegrees(Math.asin(Math.sin(radians))));

        System.out.format("The arccosine of %.4f " + "is %.4f degrees %n", 
                          Math.cos(radians),  
                          Math.toDegrees(Math.acos(Math.cos(radians))));

        System.out.format("The arctangent of %.4f " + "is %.4f degrees %n", 
                          Math.tan(radians), 
                          Math.toDegrees(Math.atan(Math.tan(radians))));
    }
    
    @Test
    public void testRandom() {
        
        // By multiplying the value by 10, the range of possible values becomes 0.0 <= number < 10.0.
        int number = (int)(Math.random() * 10);
        System.out.format("The random number : %d%n", number);
        
        // To generate a series of random numbers, you should create an instance of java.util.Random 
        // and invoke methods on that object to generate numbers.
        
        System.out.println("The seria of random numbers:");
        Random gen = new Random();
        for ( int i=0; i<10; i++  ) {
            number = gen.nextInt(10);
            System.out.format(" - random number : %d%n", number);
        }
    }
}






















