/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

import java.io.IOException;
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
   
   public static void printPathInfo(Path path) {
       System.out.format("toString: %s%n", path.toString());
       System.out.format("getFileName: %s%n", path.getFileName());
       System.out.format("getName(0): %s%n", path.getName(0));
       System.out.format("getNameCount: %s%n", path.getNameCount());
       System.out.format("subpath(0, 2): %s%n", path.subpath(0, 2));
       System.out.format("getParent: %s%n", path.getParent());
       System.out.format("getRoot: %s%n", path.getRoot());
   }
   
   @Test
   public void testPathInfo() {
       
       // None of these methods requires that the file corresponding
       // to the Path exists.
       
       // Microsoft Windows
       Path pathPC = Paths.get("C:\\home\\joe\\foo");
       
       // Solaris 
       Path pathSL = Paths.get("/home/joe/foo");
       
//     System.out.println("Microsoft Windows : \"c:\\home\\joe\\foo\"");
//     printPathInfo(pathPC);
       
//     System.out.println("Solaris : \"/home/joe/foo\"");
//     printPathInfo(pathSL);
       
        // Try real path 
        Path path = Paths.get("Macintosh HD/Users/vitya/JavaProjects/java_tutorial");
        printPathInfo(path);

   }
   
   @Test
   public void testNormalize() {
       
       Path pathA = Paths.get("/home/./joe/foo");
       System.out.println(pathA);
       System.out.println(pathA.normalize());
       assertEquals(pathA.normalize().toString(), "/home/joe/foo");
       
       Path pathB = Paths.get("/home/sally/../joe/foo");
       System.out.println(pathB);
       System.out.println(pathB.normalize());
       assertEquals(pathA.normalize().toString(), "/home/joe/foo");
   }
   
    @Test 
    public void testPathConverting() {
       
        Path p1 = Paths.get("/home/logfile");
        System.out.format("%s%n", p1);
        System.out.format("toUri: %s%n", p1.toUri());
        assertEquals("file:///home/logfile", p1.toUri().toString());
    
        Path path = Paths.get("README.md");
        Path fullPath = path.toAbsolutePath();
        System.out.format("%s%n", path);
        System.out.format("toAbsolutePath: %s%n", fullPath);
        
        // - If true is passed to this method and the file system supports symbolic links, 
        //   this method resolves any symbolic links in the path.
        // - If the Path is relative, it returns an absolute path.
        // - If the Path contains any redundant elements, it returns a path with those 
        //   elements removed.
        try {
            Path realPath = path.toRealPath();
            System.out.format("toRealPath: %s%n", realPath);
        } catch (NoSuchFieldError e) {
            System.err.format("%s: no such" + " file or directory%n", path);
            // Logic for case when file doesn't exist.
        } catch (IOException e) {
            System.err.format("%s%n", e);
            // Logic for other sort of file error.
        }
    }
    
    @Test
    public void testResolve() {
        
        // Solaris
        Path p1 = Paths.get("/home/joe/foo");
        // Result is /home/joe/foo/bar
        System.out.format("%s%n", p1.resolve("bar"));
        assertEquals("/home/joe/foo/bar", p1.resolve("bar").toString());
        
        // Microsoft Windows
        Path p2 = Paths.get("C:\\home\\joe\\foo");
        // Result is C:\home\joe\foo\bar
        System.out.format("%s%n", p2.resolve("bar"));
        
    }
   
    @Test 
    public void testRelativize() {
        
        Path p1 = Paths.get("joe");
        Path p2 = Paths.get("sally");
        
        // Result is ../sally
        Path p1_to_p2 = p1.relativize(p2);
        // Result is ../joe
        Path p2_to_p1 = p2.relativize(p1);
        
        assertEquals("../sally", p1_to_p2.toString());
        assertEquals("../joe", p2_to_p1.toString());
        System.out.println(p1_to_p2);
        System.out.println(p2_to_p1);
        
        Path p3 = Paths.get("home");
        Path p4 = Paths.get("home/sally/bar");
        // Result is sally/bar
        Path p3_to_p4 = p3.relativize(p4);
        // Result is ../..
        Path p4_to_p3 = p4.relativize(p3);

        assertEquals("sally/bar", p3_to_p4.toString());
        assertEquals("../..", p4_to_p3.toString());
        System.out.println(p3_to_p4);
        System.out.println(p4_to_p3);

    }
}
