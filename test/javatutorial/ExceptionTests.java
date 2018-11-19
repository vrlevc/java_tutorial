/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author vitya
 */
public class ExceptionTests {

    class ListOfNumbers {
        
        private final List<Integer> list;
        private static final int SIZE = 10;
        
        public ListOfNumbers() {
            list = new ArrayList<>(SIZE);
            for (int i=0; i<SIZE; i++) {
                list.add(i);
            }
        }
        
        public void writeList() {
            PrintWriter out = null;
            
            // The FileWriter constructor throws IOException, which must be caught.
            try {
                System.out.println("Entered try statement");
                out = new PrintWriter(new FileWriter("OutFile.txt")); // IOException - checked exception
            
                for (int i = 0; i < SIZE; i++) {
                    // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                    out.println("Value at: " + i + " = " + list.get(i)); // IndexOutOfBoundsException - unchecked exception
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("IndexOutOfBoundsException: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Caught IOException: " + e.getMessage());
            } finally {
                if (out != null) {
                    System.out.println("Closing PrintWriter");
                    out.close(); 
                } else {
                    System.out.println("PrintWriter not open");
                }
            }
            
            /*
                catch (IOException|SQLException ex) { // ex - implicitly final
                    logger.log(ex);
                    throw ex;
                }
            */
            
            out.close();
        }
        
        // try-with :
        
        String readFirstLineFromFile(String path) throws IOException {
            try (BufferedReader br =
                           new BufferedReader(new FileReader(path))) {
                return br.readLine();
            }
            
        /*
            BufferedReader br = new BufferedReader(new FileReader(path));
            try {
                return br.readLine();
            } finally {
                if (br != null) br.close();
            }
        */
        }
    }
    
    public static void writeToFileZipFileContents(String zipFileName, String outputFileName) throws java.io.IOException {

        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);

        // Open zip file and create output file with 
        // try-with-resources statement

        try (
            java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
            java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((java.util.zip.ZipEntry)entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

}




















