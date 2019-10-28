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
public class GFCD {

    static double gcd(double a, double b) {
       if (a < b) 
            return gcd(b, a); 
       
        // base case 
        if (Math.abs(b) < 0.001) 
            return a; 
       
        else
            return (gcd(b, a -  
                   Math.floor(a / b) * b)); 
    }

    static double findGCD(double arr[], int n) {
        double result = arr[0];
        for (int i = 1; i < n; i++) {
            result = gcd(arr[i], result);
        }

        return result;
    }

    public static void main(String args[]) {
        double arr[] = {8.54,4.24,3.61,8.25,3.61,2.83,10.63,7.62,7.28};
        double arr1[] = {0.00, 5.00, 10.00, 5.00, 7.07, 11.18, 10.00, 11.18, 14.14};
        double arr2[]={10.0, 51.0, 100.5, 40.0, 64.0, 107.7, 90.0, 103.0, 134.5};
        int n = arr2.length;
        System.out.printf("%.2f\n",findGCD(arr2, n));
    }
}
