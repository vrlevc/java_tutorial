/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitya
 */
public class FileIO {
   
   @Test
   public void testCreatePath() {
       Path p1 = Paths.get("/tmp/foo");
       Path p2 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
       
       // Paths.get is a:
       Path p4 = FileSystems.getDefault().getPath("/users/sally");
       
       // Creating /u/joe/logs/foo.log assuming your home directory is /u/joe, 
       // or C:\joe\logs\foo.log if you are on Windows.
       Path p5 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");
   }
   
   
   
}
