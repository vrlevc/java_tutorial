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
public class LocalClass {
    
    static String regularExpression = "[^0-9]";
    
    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
        
        int numberLength = 10; // effectively final - never changed
        
        // Local class
        
        class PhoneNumber {
            
            String formattedPhoneNumber = null;
            
            PhoneNumber(String phoneNumber) {
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                formattedPhoneNumber = currentNumber.length()==numberLength ? currentNumber : null;
            }
            
            public String getNumber() {
                return formattedPhoneNumber;
            }
                
            public void printOriginalNumbers() { // Asscess to function params
                System.out.println("Original numbers are "+phoneNumber1+" and "+phoneNumber2);
            }
        }
        
        PhoneNumber number1 = new PhoneNumber(phoneNumber1);
        PhoneNumber number2 = new PhoneNumber(phoneNumber2);
        
        number1.printOriginalNumbers();
        
        if (number1.getNumber() == null) 
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + number1.getNumber());
        
        if (number2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + number2.getNumber());
    }
    
}
