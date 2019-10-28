/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

/**
 *
 * @author Nipuna
 */
public class Decibels {

    static double calculateDistances(double strength) {
        return Math.sqrt(Math.pow(10, (strength / (float) 10)));
    }

    public static void main(String args[]) {
        double minValue = Double.MAX_VALUE;
        double arr[] = {0.0, 2.00, 1.14, 1.41, 1.91, 2.00, 2.24, 2.29, 2.81, 2.83, 3.00, 3.16};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<minValue && arr[i]!=0){
            minValue = arr[i];
            }
        }
        
        for(int i=0;i<arr.length;i++){
        arr[i] = arr[i]/(float)minValue;
        arr[i] = Math.round(arr[i]*100.0)/100.0;
        }
        
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
