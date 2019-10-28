/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Nipuna
 */
public class SimpleGridFrame extends javax.swing.JFrame {

    /**
     * Creates new form SimpleGridFrame
     */
    private int selected_grid[][] = {{0, 500}, {50, 500}, {100, 500}, {150, 500}, {200, 500}, {250, 500}, {300, 500}, {350, 500}, {400, 500}, {450, 500}, {500, 500},//0
    {0, 450}, {50, 450}, {150, 450}, {200, 450}, {250, 450}, {300, 450}, {350, 450}, {400, 450}, {450, 450}, {500, 450},//1
    {0, 400}, {50, 400}, {150, 400}, {200, 400}, {250, 400}, {300, 400}, {350, 400}, {400, 400}, {450, 400}, {500, 400},//2
    {0, 350}, {50, 350}, {150, 350}, {200, 350}, {250, 350}, {300, 350}, {350, 350}, {400, 350}, {450, 350}, {500, 350},//3
    {0, 300}, {50, 300}, {150, 300}, {200, 300}, {250, 300}, {300, 300}, {350, 300}, {400, 300}, {450, 300}, {500, 300},//4
    {0, 250}, {50, 250}, {150, 250}, {200, 250}, {250, 250}, {300, 250}, {350, 250}, {400, 250}, {450, 250}, {500, 250},//5
    {0, 200}, {50, 200}, {150, 200}, {200, 200}, {250, 200}, {300, 200}, {350, 200}, {400, 200}, {450, 200}, {500, 200},//6
    {0, 150}, {50, 150}, {150, 150}, {200, 150}, {250, 150}, {300, 150}, {350, 150}, {400, 150}, {450, 150}, {500, 150},//7
    {0, 100}, {50, 100}, {150, 100}, {200, 100}, {250, 100}, {300, 100}, {350, 100}, {400, 100}, {450, 100}, {500, 100},//8
    {0, 50}, {50, 50}, {150, 50}, {200, 50}, {250, 50}, {300, 50}, {350, 50}, {400, 50}, {450, 50}, {500, 50},//9
    {0, 0}, {50, 0}, {150, 0}, {200, 0}, {250, 0}, {300, 0}, {350, 0}, {400, 0}, {450, 0}, {500, 0}};//10

    //9 nodes
    private int nodeList[][] = {{0, 500}, {250, 500}, {500, 500}, {0, 250}, {250, 250}, {500, 250}, {0, 0}, {250, 0}, {500, 0}};

    /*{{20, 560}, {70, 560}, {120, 560}, {170, 560}, {220, 560}, {270, 560}, {320, 560}, {370, 560}, {420, 560}, {470, 560},//0
    {20, 515}, {70, 515}, {120, 515}, {170, 515}, {220, 515}, {270, 515}, {320, 515}, {370, 515}, {420, 515}, {470, 515},//1
    {20, 465}, {70, 465}, {120, 465}, {170, 465}, {220, 465}, {270, 465}, {320, 465}, {370, 465}, {420, 465}, {470, 465},//2
    {20, 415}, {70, 415}, {120, 415}, {170, 415}, {220, 415}, {270, 415}, {320, 415}, {370, 415}, {420, 415}, {470, 415},//3
    {20, 365}, {70, 365}, {120, 365}, {170, 365}, {220, 365}, {270, 365}, {320, 365}, {370, 365}, {420, 365}, {470, 365},//4
    {20, 315}, {70, 315}, {120, 315}, {170, 315}, {220, 315}, {270, 315}, {320, 315}, {370, 315}, {420, 315}, {470, 315},//5
    {20, 265}, {70, 265}, {120, 265}, {170, 265}, {220, 265}, {270, 265}, {320, 265}, {370, 265}, {420, 265}, {470, 265},//6
    {20, 215}, {70, 215}, {120, 215}, {170, 215}, {220, 215}, {270, 215}, {320, 215}, {370, 215}, {420, 215}, {470, 215},//7
    {20, 165}, {70, 165}, {120, 165}, {170, 165}, {220, 165}, {270, 165}, {320, 165}, {370, 165}, {420, 165}, {470, 165},//8
    {20, 115}, {70, 115}, {120, 115}, {170, 115}, {220, 115}, {270, 115}, {320, 115}, {370, 115}, {420, 115}, {470, 115},//9
    {20, 65}, {70, 65}, {120, 65}, {170, 65}, {220, 65}, {270, 65}, {320, 65}, {370, 65}, {420, 65}, {470, 65}};//10*/
    
    private double[] sortedProcessedArr={
            0.00,1.00,1.14,1.41,1.91,2.00,2.24,2.29,2.81,2.83,3.00,3.16,
            3.60,3.61,4.00,4.12,4.24,4.41,4.47,4.97,5.00,5.10,5.25,5.39,
            5.66,5.83,6.00,6.08,6.32,6.40,6.71,7.00,7.07,7.21,7.28,7.62,
            7.81,8.00,8.05,8.06,8.25,8.49,8.54,8.60,8.64,8.66,8.94,9.00,
            9.06,9.22,9.43,9.49,9.85,9.90,10.00,10.05,10.20,10.30,10.44,10.49,
            10.63,10.77,10.82,11.18,11.31,11.40,11.66,11.80,11.81,12.04,
            12.21,12.73,12.81,13.45,14.00,14.14};
    private int xMouse1, yMouse1, xMouse2, yMouse2, xMouse3, yMouse3, xMouse4, yMouse4;
    private int count = 0;
    private Timer t;
    private double node0, node1, node2, node3, node4, node5, node6, node7, node8;
    private int minStrength, minIndex, minSum, minSumIndex;
    private int sum1, sum2, sum3, sum4;
    private int specialNodes[] = new int[4];
    private int specialNodesSelector[] = new int[4];
    private double averageRatioArray[] = new double[9];
    private int averageArray[] = new int[4];
    private double pointX, pointY, pointZ;

    public SimpleGridFrame() {
        initComponents();
        dotPointer.setVisible(false);
        blackDot.setVisible(false);
        jTextArea1.setEditable(false);
        setTitle("Grid Mapper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void setposition() {
        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                publish(xMouse1);
                publish(yMouse1);
                return true;
            }

            protected void done() {
                boolean status;
                try {
                    status = get();
                } catch (InterruptedException e) {
                } catch (ExecutionException e) {
                }
            }

            @Override
            protected void process(List<Integer> chunks) {
                int mostRecentValue = chunks.get(chunks.size() - 1);
                dotPointer.setVisible(false);
                blackDot.setVisible(false);
                dotPointer.setVisible(true);
                blackDot.setVisible(true);
                t = new Timer(2, new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        dotPointer.setBounds(xMouse3 + 10, yMouse3 + 50, 40, 40);
                        //System.out.println(xMouse4+" "+yMouse4);
                        blackDot.setBounds(xMouse4 + 20, yMouse4 + 50, 40, 40);
                    }
                });
                t.start();
                t.setRepeats(false);
            }
        };

        worker.execute();
    }

    private void findDistances() {
        node0 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 0), 2) + Math.pow(Math.abs(yMouse2 - 0), 2));
        node1 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 5), 2) + Math.pow(Math.abs(yMouse2 - 0), 2));
        node2 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 10), 2) + Math.pow(Math.abs(yMouse2 - 0), 2));
        node3 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 0), 2) + Math.pow(Math.abs(yMouse2 - 5), 2));
        node4 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 5), 2) + Math.pow(Math.abs(yMouse2 - 5), 2));
        node5 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 10), 2) + Math.pow(Math.abs(yMouse2 - 5), 2));
        node6 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 0), 2) + Math.pow(Math.abs(yMouse2 - 10), 2));
        node7 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 5), 2) + Math.pow(Math.abs(yMouse2 - 10), 2));
        node8 = Math.sqrt(Math.pow(Math.abs(xMouse2 - 10), 2) + Math.pow(Math.abs(yMouse2 - 10), 2));

        String display = " node0: " + String.format("%.2f", node0) + "\n node1: "
                + String.format("%.2f", node1) + "\n node2: "
                + String.format("%.2f", node2) + "\n node3: "
                + String.format("%.2f", node3) + "\n node4: "
                + String.format("%.2f", node4) + "\n node5: "
                + String.format("%.2f", node5) + "\n node6: "
                + String.format("%.2f", node6) + "\n node7: "
                + String.format("%.2f", node7) + "\n node8: "
                + String.format("%.2f", node8);
        //System.out.println(display);
        jTextArea1.setText(display);
        String str = "AA,90,72,76,72,28,44,76,36,42,BB";
        calculatePoint(str);

    }

    //to find the point
    private void calculatePoint(String str) {
        String strengths[] = str.split(",");

        int wifi_strengths[] = new int[9];
        for (int i = 0; i < 9; i++) {
            if (strengths[i + 1].trim().equals("**")) {
                wifi_strengths[i] = 99;
            } else {
                wifi_strengths[i] = Integer.parseInt(strengths[i + 1]);
            }
        }

        minStrength = wifi_strengths[0];
        minIndex = 0;
        for (int i = 0; i < wifi_strengths.length; i++) {
            if (minStrength > wifi_strengths[i]) {
                minStrength = wifi_strengths[i];
                minIndex = i;
            }
        }

        /*
        System.out.println("minStrength: "+minStrength);
        System.out.println("minIndex: "+minIndex);
         */
        sum1 = wifi_strengths[0] + wifi_strengths[1] + wifi_strengths[3] + wifi_strengths[4];
        sum2 = wifi_strengths[1] + wifi_strengths[2] + wifi_strengths[4] + wifi_strengths[5];
        sum3 = wifi_strengths[3] + wifi_strengths[4] + wifi_strengths[6] + wifi_strengths[7];
        sum4 = wifi_strengths[4] + wifi_strengths[5] + wifi_strengths[7] + wifi_strengths[8];

        //checks the cell which has the minimum value
        boolean square01 = false, square02 = false, square03 = false, square04 = false;
        if (minIndex == 0 || minIndex == 1 || minIndex == 3 || minIndex == 4) {
            square01 = true;
        }
        if (minIndex == 1 || minIndex == 2 || minIndex == 4 || minIndex == 5) {
            square02 = true;
        }
        if (minIndex == 3 || minIndex == 4 || minIndex == 6 || minIndex == 7) {
            square03 = true;
        }
        if (minIndex == 4 || minIndex == 5 || minIndex == 7 || minIndex == 8) {
            square04 = true;
        }

        //includes in all four cells
        if (square01 && square02 && square03 && square04) {
            int sumArray[] = {sum1, sum2, sum3, sum4};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
            //includes in three cells
        } else if (square01 && square02 && square03 && !square04) {
            int sumArray[] = {sum1, sum2, sum3, 400};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (square01 && square02 && !square03 && square04) {
            int sumArray[] = {sum1, sum2, 400, sum4};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (square01 && !square02 && square03 && square04) {
            int sumArray[] = {sum1, 400, sum3, sum4};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (!square01 && square02 && square03 && square04) {
            int sumArray[] = {400, sum2, sum3, sum4};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
            //includes in two cells
        } else if (square01 && square02 && !square03 && !square04) {
            int sumArray[] = {sum1, sum2, 400, 400};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (square01 && !square02 && square03 && !square04) {
            int sumArray[] = {sum1, 400, sum3, 400};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (!square01 && square02 && square03 && !square04) {
            int sumArray[] = {400, sum2, sum3, 400};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (square01 && !square02 && !square03 && square04) {
            int sumArray[] = {sum1, 400, 400, sum4};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (!square01 && square02 && !square03 && square04) {
            int sumArray[] = {400, sum2, 400, sum4};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
        } else if (!square01 && !square02 && square03 && square04) {
            int sumArray[] = {400, 400, sum3, sum4};
            minSum = sum1;
            minSumIndex = 1;
            for (int i = 0; i < sumArray.length; i++) {
                if (sumArray[i] < minSum) {
                    minSum = sumArray[i];
                    minSumIndex = i + 1;
                }
            }
            //include in one cell
        } else if (square01 && !square02 && !square03 && !square04) {
            minSum = sum1;
            minSumIndex = 1;
        } else if (!square01 && square02 && !square03 && !square04) {
            minSum = sum2;
            minSumIndex = 2;
        } else if (!square01 && !square02 && square03 && !square04) {
            minSum = sum3;
            minSumIndex = 3;
        } else if (!square01 && !square02 && !square03 && square04) {
            minSum = sum4;
            minSumIndex = 4;
        }

        //find the strengths of the nodes which contain the minimum index and minimum sum
        if (minSumIndex == 1) {
            specialNodes[0] = wifi_strengths[0];
            specialNodes[1] = wifi_strengths[1];
            specialNodes[2] = wifi_strengths[3];
            specialNodes[3] = wifi_strengths[4];

            specialNodesSelector[0] = wifi_strengths[0];
            specialNodesSelector[1] = wifi_strengths[1];
            specialNodesSelector[2] = wifi_strengths[3];
            specialNodesSelector[3] = wifi_strengths[4];
            //System.out.println("minSumIndex: "+minSumIndex);
        } else if (minSumIndex == 2) {
            specialNodes[0] = wifi_strengths[1];
            specialNodes[1] = wifi_strengths[2];
            specialNodes[2] = wifi_strengths[4];
            specialNodes[3] = wifi_strengths[5];

            specialNodesSelector[0] = wifi_strengths[1];
            specialNodesSelector[1] = wifi_strengths[2];
            specialNodesSelector[2] = wifi_strengths[4];
            specialNodesSelector[3] = wifi_strengths[5];
            //System.out.println("minSumIndex: "+minSumIndex);
        } else if (minSumIndex == 3) {
            specialNodes[0] = wifi_strengths[3];
            specialNodes[1] = wifi_strengths[4];
            specialNodes[2] = wifi_strengths[6];
            specialNodes[3] = wifi_strengths[7];

            specialNodesSelector[0] = wifi_strengths[3];
            specialNodesSelector[1] = wifi_strengths[4];
            specialNodesSelector[2] = wifi_strengths[6];
            specialNodesSelector[3] = wifi_strengths[7];
            //System.out.println("minSumIndex: "+minSumIndex);
        } else if (minSumIndex == 4) {
            specialNodes[0] = wifi_strengths[4];
            specialNodes[1] = wifi_strengths[5];
            specialNodes[2] = wifi_strengths[7];
            specialNodes[3] = wifi_strengths[8];

            specialNodesSelector[0] = wifi_strengths[4];
            specialNodesSelector[1] = wifi_strengths[5];
            specialNodesSelector[2] = wifi_strengths[7];
            specialNodesSelector[3] = wifi_strengths[8];
            //System.out.println("minSumIndex: "+minSumIndex);
        }

        //find the minimum three nodes
        int minStrengthFromSpecialNodes01 = specialNodesSelector[0];
        int minStrengthIndexFromSpecialNodes01 = 0;

        for (int i = 0; i < specialNodesSelector.length; i++) {
            if (minStrengthFromSpecialNodes01 > specialNodesSelector[i]) {
                minStrengthFromSpecialNodes01 = specialNodesSelector[i];
                minStrengthIndexFromSpecialNodes01 = i;
            }
        }

        specialNodesSelector[minStrengthIndexFromSpecialNodes01] = 100;
        int minStrengthFromSpecialNodes02 = specialNodesSelector[0];
        int minStrengthIndexFromSpecialNodes02 = 0;

        for (int i = 0; i < specialNodesSelector.length; i++) {
            if (minStrengthFromSpecialNodes02 > specialNodesSelector[i]) {
                minStrengthFromSpecialNodes02 = specialNodesSelector[i];
                minStrengthIndexFromSpecialNodes02 = i;
            }
        }

        specialNodesSelector[minStrengthIndexFromSpecialNodes02] = 100;
        int minStrengthFromSpecialNodes03 = specialNodesSelector[0];
        int minStrengthIndexFromSpecialNodes03 = 0;

        for (int i = 0; i < specialNodesSelector.length; i++) {
            if (minStrengthFromSpecialNodes03 > specialNodesSelector[i]) {
                minStrengthFromSpecialNodes03 = specialNodesSelector[i];
                minStrengthIndexFromSpecialNodes03 = i;
            }
        }

        specialNodesSelector[minStrengthIndexFromSpecialNodes03] = 100;

        /*2 3
          0 1*/ //original grid
        /*7 9
          0 2*/ //transformed grid  
        int point01 = minStrengthIndexFromSpecialNodes01;
        int point02 = minStrengthIndexFromSpecialNodes02;
        int point03 = minStrengthIndexFromSpecialNodes03;

        int p01 = minStrengthIndexFromSpecialNodes01;
        int p02 = minStrengthIndexFromSpecialNodes02;
        int p03 = minStrengthIndexFromSpecialNodes03;

        //reinitializing points
        //point01
        if (point01 == 0) {
            point01 = 0;
        } else if (point01 == 1) {
            point01 = 2;
        } else if (point01 == 2) {
            point01 = 7;
        } else if (point01 == 3) {
            point01 = 9;
        }

        //point02
        if (point02 == 0) {
            point02 = 0;
        } else if (point02 == 1) {
            point02 = 2;
        } else if (point02 == 2) {
            point02 = 7;
        } else if (point02 == 3) {
            point02 = 9;
        }

        //point03
        if (point03 == 0) {
            point03 = 0;
        } else if (point03 == 1) {
            point03 = 2;
        } else if (point03 == 2) {
            point03 = 7;
        } else if (point03 == 3) {
            point03 = 9;
        }

        /*2 3
          0 1*/ //original grid
        /*7 9
          0 2*/ //transformed grid 
        /*first make the position variables null*/
        pointX = 0;
        pointY = 0;
        pointZ = 0;

        //pointX
        if (point01 == (point02 + 2)) {
            pointX = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250;
            pointX = -pointX;
        } else if (point01 == (point02 - 2)) {
            pointX = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250;
        } else if (point01 == (point03 + 2)) {
            pointX = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250;
            pointX = -pointX;
        } else if (point01 == (point03 - 2)) {
            pointX = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250;
        }

        //pointY
        if (point01 == (point02 + 7)) {
            pointY = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250;
        } else if (point01 == (point02 - 7)) {
            pointY = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250;
            pointY = -pointY;
        } else if (point01 == (point03 + 7)) {
            pointY = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250;
        } else if (point01 == (point03 - 7)) {
            pointY = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250;
            pointY = -pointY;
        }

        //pointZ
        if (point01 == (point02 + 5)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250 * Math.sqrt(2);
        } else if (point01 == (point02 - 5)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250 * Math.sqrt(2);
            pointZ = -pointZ;
        } else if (point01 == (point02 + 9)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250 * Math.sqrt(2);
        } else if (point01 == (point02 - 9)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p02])) * 250 * Math.sqrt(2);
            pointZ = -pointZ;
        } else if (point01 == (point03 + 5)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250 * Math.sqrt(2);
        } else if (point01 == (point03 - 5)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250 * Math.sqrt(2);
            pointZ = -pointZ;
        } else if (point01 == (point03 + 9)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250 * Math.sqrt(2);
        } else if (point01 == (point03 - 9)) {
            pointZ = (specialNodes[p01] / (float) (specialNodes[p01] + specialNodes[p03])) * 250 * Math.sqrt(2);
            pointZ = -pointZ;
        }

        if (pointZ == 0) {
            if (pointX > 0) {
                xMouse4 = nodeList[minIndex][0] - 10 + (int) pointX;
            } else if (pointX < 0) {
                xMouse4 = nodeList[minIndex][0] + 10 + (int) pointX;
            }

            if (pointY < 0) {
                yMouse4 = nodeList[minIndex][1] + 10 + (int) pointY;
            } else if (pointY > 0) {
                yMouse4 = nodeList[minIndex][1] - 10 + (int) pointY;
            }
        } else {
            if (pointX == 0) {
                if (pointZ < 0) {
                    xMouse4 = nodeList[minIndex][0] - (int) (pointZ * Math.cos(Math.PI / 4));
                } else if (pointZ > 0) {
                    xMouse4 = nodeList[minIndex][0] - (int) (pointZ * Math.cos(Math.PI / 4));
                }
                if (pointY < 0) {
                    yMouse4 = nodeList[minIndex][1] + 10 + (int) pointY;
                } else if (pointY > 0) {
                    yMouse4 = nodeList[minIndex][1] - 10 + (int) pointY;
                }
            } else if (pointY == 0) {
                if (pointZ < 0) {
                    yMouse4 = nodeList[minIndex][1] + (int) (pointZ * Math.cos(Math.PI / 4));

                } else if (pointZ > 0) {
                    yMouse4 = nodeList[minIndex][1] + (int) (pointZ * Math.cos(Math.PI / 4));
                }
                if (pointX > 0) {
                    xMouse4 = nodeList[minIndex][0] - 10 + (int) pointX;
                } else if (pointX < 0) {
                    xMouse4 = nodeList[minIndex][0] + 10 + (int) pointX;
                }
            }
        }
        System.out.println("Minimum: " + minIndex);
        System.out.println("xMouse3: " + xMouse3 + " yMouse3: " + yMouse3);
        System.out.println("xMouse4: " + xMouse4 + " yMouse4: " + yMouse4);
        /*
        for(int i:specialNodes){
            System.out.println("nodes: "+i);
        }*/
        System.out.println("pointX: " + pointX + " pointY: " + pointY + " pointZ: " + pointZ);

        //average the values taken from the minimum sum square
        for (int i = 0; i < specialNodes.length; i++) {
            averageArray[i] = averageValues(specialNodes[i]);
        }
    }

    /*as we get the relative values we have to classify them */
    private int averageValues(int val) {
        if (0 <= val && val <= 4) {
            val = 2;
        } else if (5 <= val && val <= 9) {
            val = 7;
        } else if (10 <= val && val <= 14) {
            val = 12;
        } else if (15 <= val && val <= 19) {
            val = 17;
        } else if (20 <= val && val <= 24) {
            val = 22;
        } else if (25 <= val && val <= 29) {
            val = 27;
        } else if (30 <= val && val <= 34) {
            val = 32;
        } else if (35 <= val && val <= 39) {
            val = 37;
        } else if (40 <= val && val <= 44) {
            val = 42;
        } else if (45 <= val && val <= 49) {
            val = 47;
        } else if (50 <= val && val <= 54) {
            val = 52;
        } else if (55 <= val && val <= 59) {
            val = 57;
        } else if (60 <= val && val <= 64) {
            val = 62;
        } else if (65 <= val && val <= 69) {
            val = 67;
        } else if (70 <= val && val <= 74) {
            val = 72;
        } else if (75 <= val && val <= 79) {
            val = 77;
        } else if (80 <= val && val <= 84) {
            val = 82;
        } else if (85 <= val && val <= 89) {
            val = 87;
        } else if (90 <= val && val <= 94) {
            val = 92;
        } else if (95 <= val && val <= 99) {
            val = 97;
        }
        return val;
    }

    /**/
    private double averageRatioValueSetter(double val) {
        
        return val;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        XAxis = new javax.swing.JSeparator();
        YAxis = new javax.swing.JSeparator();
        blackDot = new javax.swing.JLabel();
        dotPointer = new javax.swing.JLabel();
        Map = new javax.swing.JLabel();
        x0y10 = new javax.swing.JLabel();
        x0y1 = new javax.swing.JLabel();
        x0y2 = new javax.swing.JLabel();
        x0y3 = new javax.swing.JLabel();
        x0y4 = new javax.swing.JLabel();
        x0y5 = new javax.swing.JLabel();
        x0y6 = new javax.swing.JLabel();
        x0y7 = new javax.swing.JLabel();
        x0y8 = new javax.swing.JLabel();
        x0y9 = new javax.swing.JLabel();
        x10y0 = new javax.swing.JLabel();
        x9y0 = new javax.swing.JLabel();
        x8y0 = new javax.swing.JLabel();
        x7y0 = new javax.swing.JLabel();
        x6y0 = new javax.swing.JLabel();
        x5y0 = new javax.swing.JLabel();
        x4y0 = new javax.swing.JLabel();
        x3y0 = new javax.swing.JLabel();
        x2y0 = new javax.swing.JLabel();
        x1y0 = new javax.swing.JLabel();
        x0y0 = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        viewPosition = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        XAxis.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(XAxis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 580, -1));

        YAxis.setForeground(new java.awt.Color(0, 0, 0));
        YAxis.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(YAxis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 10, 540));

        blackDot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackdot.png"))); // NOI18N
        getContentPane().add(blackDot, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        dotPointer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dotPointer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reddot16.png"))); // NOI18N
        getContentPane().add(dotPointer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, 20));

        Map.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gridlines02.png"))); // NOI18N
        Map.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MapMouseClicked(evt);
            }
        });
        getContentPane().add(Map, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 72, -1, -1));

        x0y10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y10.setText("10");
        getContentPane().add(x0y10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 40, -1));

        x0y1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y1.setText("1");
        getContentPane().add(x0y1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 40, -1));

        x0y2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y2.setText("2");
        getContentPane().add(x0y2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 40, -1));

        x0y3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y3.setText("3");
        getContentPane().add(x0y3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 40, -1));

        x0y4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y4.setText("4");
        getContentPane().add(x0y4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 365, 40, -1));

        x0y5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y5.setText("5");
        getContentPane().add(x0y5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 40, -1));

        x0y6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y6.setText("6");
        getContentPane().add(x0y6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 40, -1));

        x0y7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y7.setText("7");
        getContentPane().add(x0y7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 215, 40, -1));

        x0y8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y8.setText("8");
        getContentPane().add(x0y8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, 40, -1));

        x0y9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y9.setText("9");
        getContentPane().add(x0y9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 40, -1));

        x10y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x10y0.setText("10");
        getContentPane().add(x10y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, 40, -1));

        x9y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x9y0.setText("9");
        getContentPane().add(x9y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, 40, -1));

        x8y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x8y0.setText("8");
        getContentPane().add(x8y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 40, -1));

        x7y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x7y0.setText("7");
        getContentPane().add(x7y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 40, -1));

        x6y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x6y0.setText("6");
        getContentPane().add(x6y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 40, -1));

        x5y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x5y0.setText("5");
        getContentPane().add(x5y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 40, -1));

        x4y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x4y0.setText("4");
        getContentPane().add(x4y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 40, -1));

        x3y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x3y0.setText("3");
        getContentPane().add(x3y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 40, -1));

        x2y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x2y0.setText("2");
        getContentPane().add(x2y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 40, -1));

        x1y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x1y0.setText("1");
        getContentPane().add(x1y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 40, -1));

        x0y0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x0y0.setText("0");
        getContentPane().add(x0y0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 40, -1));

        positionLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        positionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        positionLabel.setText("Position");
        getContentPane().add(positionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 140, 110, -1));

        viewPosition.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(viewPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 90, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 160, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapMouseClicked
        xMouse1 = evt.getX();
        yMouse1 = evt.getY();
        xMouse3 = xMouse1;
        yMouse3 = yMouse1;

        boolean xOk = false;
        boolean yOk = false;

        yMouse1 -= 500;
        yMouse1 = yMouse1 < 0 ? -yMouse1 : yMouse1;

        if (xMouse1 % 50 < 10) {
            xMouse2 = xMouse1 / 50;
            xOk = true;
        } else if ((xMouse1 % 50) > 40 && (xMouse1 / 50) != 10) {
            xMouse2 = xMouse1 / 50 + 1;
            xOk = true;
        }

        if (yMouse1 % 50 < 10) {
            yMouse2 = yMouse1 / 50;
            yOk = true;
        } else if (yMouse1 % 50 > 40 && (yMouse1 / 50) != 10) {
            yMouse2 = yMouse1 / 50 + 1;
            yOk = true;
        }

        if (xOk == true && yOk == true) {
            viewPosition.setText(xMouse2 + "," + yMouse2);
            setposition();
            findDistances();
        }
    }//GEN-LAST:event_MapMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimpleGridFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimpleGridFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimpleGridFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimpleGridFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleGridFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Map;
    private javax.swing.JSeparator XAxis;
    private javax.swing.JSeparator YAxis;
    private javax.swing.JLabel blackDot;
    private javax.swing.JLabel dotPointer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JLabel viewPosition;
    private javax.swing.JLabel x0y0;
    private javax.swing.JLabel x0y1;
    private javax.swing.JLabel x0y10;
    private javax.swing.JLabel x0y2;
    private javax.swing.JLabel x0y3;
    private javax.swing.JLabel x0y4;
    private javax.swing.JLabel x0y5;
    private javax.swing.JLabel x0y6;
    private javax.swing.JLabel x0y7;
    private javax.swing.JLabel x0y8;
    private javax.swing.JLabel x0y9;
    private javax.swing.JLabel x10y0;
    private javax.swing.JLabel x1y0;
    private javax.swing.JLabel x2y0;
    private javax.swing.JLabel x3y0;
    private javax.swing.JLabel x4y0;
    private javax.swing.JLabel x5y0;
    private javax.swing.JLabel x6y0;
    private javax.swing.JLabel x7y0;
    private javax.swing.JLabel x8y0;
    private javax.swing.JLabel x9y0;
    // End of variables declaration//GEN-END:variables
}
