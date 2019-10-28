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
public class logValues {

    public static void main(String[] args) {
        double[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double data[][] = {{0.3, 55}, {0.4, 59}, {0.5, 60}, {0.6, 62}, {0.7, 66}, {0.8, 68}, {0.9, 69}, {1, 71}, {2, 74}, {3, 79}, {4, 81}, {5, 83}, {6, 84}, {7, 85}, {8, 86}, {9, 87}, {10, 88}};
        double c = 0.0;
        for (int i = 0; i < data.length; i++) {
            c = (double) data[i][0] / Math.sqrt(Math.pow(10, data[i][1] / (double) 10));
            System.out.println(c);
        }

        /*
        for(double d:val){
            System.out.println(20*Math.log10(d));
        }
        System.out.println("negative values");
        
        for (double d : val) {
            System.out.println(Math.log(d));
        }
        
        System.out.println(Math.pow(10, (70.3/(20*0.88))));*/
    }
}
