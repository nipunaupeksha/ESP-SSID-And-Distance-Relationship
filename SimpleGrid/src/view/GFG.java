/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Nipuna
 */
// JAVA code for finding the GCD of  
// two floating numbers. 
import java.io.*; 
  
class GFG { 
      
    // Recursive function to return gcd  
    // of a and b 
    static double gcd(double a, double b) 
    { 
        if (a < b) 
            return gcd(b, a); 
       
        // base case 
        if (Math.abs(b) < 0.001) 
            return a; 
       
        else
            return (gcd(b, a -  
                   Math.floor(a / b) * b)); 
    } 
       
    // Driver Function. 
    public static void main(String args[]) 
    { 
        double a = 0.0, b = 5.00; 
        System.out.printf("%.1f" ,gcd(a, b)); 
    } 
} 