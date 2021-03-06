/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitya
 */
public class StringTests {

    @Test
    public void testStringPalindrome() {
        
        String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];
        
        // put original string in an array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = palindrome.charAt(i);
        }
        
        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] = tempCharArray[len - 1 - j];
        }
        
        String reversePalindrome = new String(charArray);
        
        System.out.println(palindrome);
        System.out.println(reversePalindrome);
        
        assertEquals( "doT saw I was toD", reversePalindrome );
    }
    
    @Test
    public void testValueOf() {
        
        String[] args = { "4.5", "87.2" };
        
        // convert strings to numbers
        float a = Float.valueOf(args[0]); 
        float b = Float.valueOf(args[1]);

        // do some arithmetic
        System.out.println("a + b = " +
                           (a + b));
        System.out.println("a - b = " +
                           (a - b));
        System.out.println("a * b = " +
                           (a * b));
        System.out.println("a / b = " +
                           (a / b));
        System.out.println("a % b = " +
                           (a % b));
        
    }
    
    @Test
    public void testToString() {
        
        double d = 858.48;
        String s = Double.toString(d);
        
        int dot = s.indexOf('.');
        
        System.out.format("The number %f has ", d);
        System.out.println(dot + " digits " + "before decimal point.");
        
        System.out.format("The string \"" + s + "\" has ");
        System.out.println( (s.length() - dot - 1) + " digits after decimal point.");
        
    }
    
    class Filename {
        private final String  fullPath;
        private final char    pathSeparator,
                              extensionSeparator;
        
        public Filename(String str, char sep, char ext) {
            fullPath = str;
            pathSeparator = sep;
            extensionSeparator = ext;
        }
        
        public String extension() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            return fullPath.substring(dot + 1);
        }
        
        // get file name without extension
        public String filename() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(sep + 1, dot);
        }
        
        public String path() {
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(0, sep);
        }
    }
    
    @Test
    public void testFilename() {
        
        final String FPATH = "/home/user/index.html";
        Filename myHomePage = new Filename(FPATH, '/', '.');
        
        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());
        
        assertEquals("html", myHomePage.extension());
        assertEquals("index", myHomePage.filename());
        assertEquals("/home/user", myHomePage.path());
        
    }
    
    @Test
    public void testregionMatches() {
        
        String searchMe = "Green Eggs and Ham";
        String findMe = "Eggs";
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();

        String foundIt = null;
        for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = searchMe.substring(i, i + findMeLength);
                break;
            }
        }
        if (foundIt == null)
            foundIt = "No match found.";
        
        System.out.println(foundIt);
        
        assertEquals("Eggs", foundIt);
    }
    
}


































