/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatutorial;

/**
 *
 * @author lva
 */
public class AboutClass {
    
    // -----------------------------
    // Constants
    
    static final double PI = 3.141_592_653_589_793;
    
    // -----------------------------
    // Using this with a Constructor 
    
    public class Circle {
        public int x, y, r;
        public Circle() {
            this(0, 0, 0);                      // !!!!!
        }
        public Circle(int x, int y)
        {
            this(x, y, 0);                      // !!!!!
        }           
        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    
    // -----------------------------
    // Static Initialization Blocks
    
    public static String entityName;
    private static int entityInitialNumber;
    
    static {
        entityName = "Init in static block";
        entityInitialNumber = 50; 
    }
 
    // -----------------------------
    // Initializing Instance Members
    
    protected String objectType;
    private String objectAlias;
    
    {
        objectType = "Dynamicaly initializen for object";
        objectAlias = "Initialized for object";
    }
}
