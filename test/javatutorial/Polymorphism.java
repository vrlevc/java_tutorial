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

/**
 *
 * @author vitya
 */
public class Polymorphism {
    
    public Polymorphism() {
    }
    
    class Bicycle {
        
        private int cadence, speed, gear;
        
        public Bicycle(int startCadence, int startSpeed, int startGear) {
            this.cadence = startCadence;
            this.speed = startSpeed;
            this.gear = startGear;
        }
        
        public String description() {
            String info = "Bike is " + "in gear " + this.gear
                        + " with a cadence of " + this.cadence +
                          " and travelling at a speed of " + this.speed + ".";
            return info;
        }
    }
    
    class MountainBike extends Bicycle {
        
        private String suspension;
        
        public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType){
            super(startCadence, startSpeed, startGear);
            this.suspension = suspensionType;
        }
        
        public String description() {
            String info = "The " + "MountainBike has a " + this.suspension + " suspension.";
            return super.description() + "\n" + info;
        }
    }
    
    class RoadBike extends Bicycle {
        
        private int tireWidth;

        public RoadBike(int startCadence, int startSpeed, int startGear, int newTireWidth){
            super(startCadence, startSpeed, startGear);
            this.tireWidth = newTireWidth;
        }
        
        public String description() {
            String info = "The RoadBike" + " has " + this.tireWidth + " MM tires.";
            return super.description() + "\n" + info;
        }
    }
    
    
    @Test
    public void hello() {
        
        Bicycle bike01, bike02, bike03;

        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);

        assertEquals(
            "Bike is in gear 1 with a cadence of 20 and travelling at a speed of 10.",
            bike01.description() );
        
        assertEquals(
            "Bike is in gear 5 with a cadence of 20 and travelling at a speed of 10.\n" + 
            "The MountainBike has a Dual suspension.",
            bike02.description());

        assertEquals(
            "Bike is in gear 8 with a cadence of 40 and travelling at a speed of 20.\n" +
            "The RoadBike has 23 MM tires.",
            bike03.description() );
        
    }
}
