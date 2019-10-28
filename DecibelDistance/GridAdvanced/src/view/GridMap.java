/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Nipuna
 */
public class GridMap extends javax.swing.JFrame {

    private String node_string;
    private Timer t;
    private int node_count = 0;

    private int START_POINT_X = 75;
    private int START_POINT_Y = 750;

    private String textArea = "";
    private int counter = 1;

    private int xMouse;
    private int yMouse;

    private double cartX;
    private double cartY;

    private JLabel[][] arr = new JLabel[25][26];
    private double[][] wifi_strengths = new double[25][26];

    private int positionX, positionY;

    /**
     * Creates new form GridMap
     */
    public GridMap() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        dont_show();
        setArray();
        //calculatePoint("AA,0 0 7.07,0 5 5,5 5 0,BB");
    }

    private void dont_show() {
        SetStrengthLabel.setVisible(false);
        SetStrengthText.setVisible(false);

        //y00
        point0000.setVisible(false);
        point0100.setVisible(false);
        point0200.setVisible(false);
        point0300.setVisible(false);
        point0400.setVisible(false);
        point0500.setVisible(false);
        point0600.setVisible(false);
        point0700.setVisible(false);
        point0800.setVisible(false);
        point0900.setVisible(false);
        point1000.setVisible(false);
        point1100.setVisible(false);
        point1200.setVisible(false);
        point1300.setVisible(false);
        point1400.setVisible(false);
        point1500.setVisible(false);
        point1600.setVisible(false);
        point1700.setVisible(false);
        point1800.setVisible(false);
        point1900.setVisible(false);
        point2000.setVisible(false);
        point2100.setVisible(false);
        point2200.setVisible(false);
        point2300.setVisible(false);
        point2400.setVisible(false);
        point2500.setVisible(false);

        //y01
        point0001.setVisible(false);
        point0101.setVisible(false);
        point0201.setVisible(false);
        point0301.setVisible(false);
        point0401.setVisible(false);
        point0501.setVisible(false);
        point0601.setVisible(false);
        point0701.setVisible(false);
        point0801.setVisible(false);
        point0901.setVisible(false);
        point1001.setVisible(false);
        point1101.setVisible(false);
        point1201.setVisible(false);
        point1301.setVisible(false);
        point1401.setVisible(false);
        point1501.setVisible(false);
        point1601.setVisible(false);
        point1701.setVisible(false);
        point1801.setVisible(false);
        point1901.setVisible(false);
        point2001.setVisible(false);
        point2101.setVisible(false);
        point2201.setVisible(false);
        point2301.setVisible(false);
        point2401.setVisible(false);
        point2501.setVisible(false);

        //y02
        point0002.setVisible(false);
        point0102.setVisible(false);
        point0202.setVisible(false);
        point0302.setVisible(false);
        point0402.setVisible(false);
        point0502.setVisible(false);
        point0602.setVisible(false);
        point0702.setVisible(false);
        point0802.setVisible(false);
        point0902.setVisible(false);
        point1002.setVisible(false);
        point1102.setVisible(false);
        point1202.setVisible(false);
        point1302.setVisible(false);
        point1402.setVisible(false);
        point1502.setVisible(false);
        point1602.setVisible(false);
        point1702.setVisible(false);
        point1802.setVisible(false);
        point1902.setVisible(false);
        point2002.setVisible(false);
        point2102.setVisible(false);
        point2202.setVisible(false);
        point2302.setVisible(false);
        point2402.setVisible(false);
        point2502.setVisible(false);

        //y03
        point0003.setVisible(false);
        point0103.setVisible(false);
        point0203.setVisible(false);
        point0303.setVisible(false);
        point0403.setVisible(false);
        point0503.setVisible(false);
        point0603.setVisible(false);
        point0703.setVisible(false);
        point0803.setVisible(false);
        point0903.setVisible(false);
        point1003.setVisible(false);
        point1103.setVisible(false);
        point1203.setVisible(false);
        point1303.setVisible(false);
        point1403.setVisible(false);
        point1503.setVisible(false);
        point1603.setVisible(false);
        point1703.setVisible(false);
        point1803.setVisible(false);
        point1903.setVisible(false);
        point2003.setVisible(false);
        point2103.setVisible(false);
        point2203.setVisible(false);
        point2303.setVisible(false);
        point2403.setVisible(false);
        point2503.setVisible(false);

        //y04
        point0004.setVisible(false);
        point0104.setVisible(false);
        point0204.setVisible(false);
        point0304.setVisible(false);
        point0404.setVisible(false);
        point0504.setVisible(false);
        point0604.setVisible(false);
        point0704.setVisible(false);
        point0804.setVisible(false);
        point0904.setVisible(false);
        point1004.setVisible(false);
        point1104.setVisible(false);
        point1204.setVisible(false);
        point1304.setVisible(false);
        point1404.setVisible(false);
        point1504.setVisible(false);
        point1604.setVisible(false);
        point1704.setVisible(false);
        point1804.setVisible(false);
        point1904.setVisible(false);
        point2004.setVisible(false);
        point2104.setVisible(false);
        point2204.setVisible(false);
        point2304.setVisible(false);
        point2404.setVisible(false);
        point2504.setVisible(false);

        //y05
        point0005.setVisible(false);
        point0105.setVisible(false);
        point0205.setVisible(false);
        point0305.setVisible(false);
        point0405.setVisible(false);
        point0505.setVisible(false);
        point0605.setVisible(false);
        point0705.setVisible(false);
        point0805.setVisible(false);
        point0905.setVisible(false);
        point1005.setVisible(false);
        point1105.setVisible(false);
        point1205.setVisible(false);
        point1305.setVisible(false);
        point1405.setVisible(false);
        point1505.setVisible(false);
        point1605.setVisible(false);
        point1705.setVisible(false);
        point1805.setVisible(false);
        point1905.setVisible(false);
        point2005.setVisible(false);
        point2105.setVisible(false);
        point2205.setVisible(false);
        point2305.setVisible(false);
        point2405.setVisible(false);
        point2505.setVisible(false);

        //y06
        point0006.setVisible(false);
        point0106.setVisible(false);
        point0206.setVisible(false);
        point0306.setVisible(false);
        point0406.setVisible(false);
        point0506.setVisible(false);
        point0606.setVisible(false);
        point0706.setVisible(false);
        point0806.setVisible(false);
        point0906.setVisible(false);
        point1006.setVisible(false);
        point1106.setVisible(false);
        point1206.setVisible(false);
        point1306.setVisible(false);
        point1406.setVisible(false);
        point1506.setVisible(false);
        point1606.setVisible(false);
        point1706.setVisible(false);
        point1806.setVisible(false);
        point1906.setVisible(false);
        point2006.setVisible(false);
        point2106.setVisible(false);
        point2206.setVisible(false);
        point2306.setVisible(false);
        point2406.setVisible(false);
        point2506.setVisible(false);

        //y07
        point0007.setVisible(false);
        point0107.setVisible(false);
        point0207.setVisible(false);
        point0307.setVisible(false);
        point0407.setVisible(false);
        point0507.setVisible(false);
        point0607.setVisible(false);
        point0707.setVisible(false);
        point0807.setVisible(false);
        point0907.setVisible(false);
        point1007.setVisible(false);
        point1107.setVisible(false);
        point1207.setVisible(false);
        point1307.setVisible(false);
        point1407.setVisible(false);
        point1507.setVisible(false);
        point1607.setVisible(false);
        point1707.setVisible(false);
        point1807.setVisible(false);
        point1907.setVisible(false);
        point2007.setVisible(false);
        point2107.setVisible(false);
        point2207.setVisible(false);
        point2307.setVisible(false);
        point2407.setVisible(false);
        point2507.setVisible(false);

        //y08
        point0008.setVisible(false);
        point0108.setVisible(false);
        point0208.setVisible(false);
        point0308.setVisible(false);
        point0408.setVisible(false);
        point0508.setVisible(false);
        point0608.setVisible(false);
        point0708.setVisible(false);
        point0808.setVisible(false);
        point0908.setVisible(false);
        point1008.setVisible(false);
        point1108.setVisible(false);
        point1208.setVisible(false);
        point1308.setVisible(false);
        point1408.setVisible(false);
        point1508.setVisible(false);
        point1608.setVisible(false);
        point1708.setVisible(false);
        point1808.setVisible(false);
        point1908.setVisible(false);
        point2008.setVisible(false);
        point2108.setVisible(false);
        point2208.setVisible(false);
        point2308.setVisible(false);
        point2408.setVisible(false);
        point2508.setVisible(false);

        //y09
        point0009.setVisible(false);
        point0109.setVisible(false);
        point0209.setVisible(false);
        point0309.setVisible(false);
        point0409.setVisible(false);
        point0509.setVisible(false);
        point0609.setVisible(false);
        point0709.setVisible(false);
        point0809.setVisible(false);
        point0909.setVisible(false);
        point1009.setVisible(false);
        point1109.setVisible(false);
        point1209.setVisible(false);
        point1309.setVisible(false);
        point1409.setVisible(false);
        point1509.setVisible(false);
        point1609.setVisible(false);
        point1709.setVisible(false);
        point1809.setVisible(false);
        point1909.setVisible(false);
        point2009.setVisible(false);
        point2109.setVisible(false);
        point2209.setVisible(false);
        point2309.setVisible(false);
        point2409.setVisible(false);
        point2509.setVisible(false);

        //y10
        point0010.setVisible(false);
        point0110.setVisible(false);
        point0210.setVisible(false);
        point0310.setVisible(false);
        point0410.setVisible(false);
        point0510.setVisible(false);
        point0610.setVisible(false);
        point0710.setVisible(false);
        point0810.setVisible(false);
        point0910.setVisible(false);
        point1010.setVisible(false);
        point1110.setVisible(false);
        point1210.setVisible(false);
        point1310.setVisible(false);
        point1410.setVisible(false);
        point1510.setVisible(false);
        point1610.setVisible(false);
        point1710.setVisible(false);
        point1810.setVisible(false);
        point1910.setVisible(false);
        point2010.setVisible(false);
        point2110.setVisible(false);
        point2210.setVisible(false);
        point2310.setVisible(false);
        point2410.setVisible(false);
        point2510.setVisible(false);

        //y11
        point0011.setVisible(false);
        point0111.setVisible(false);
        point0211.setVisible(false);
        point0311.setVisible(false);
        point0411.setVisible(false);
        point0511.setVisible(false);
        point0611.setVisible(false);
        point0711.setVisible(false);
        point0811.setVisible(false);
        point0911.setVisible(false);
        point1011.setVisible(false);
        point1111.setVisible(false);
        point1211.setVisible(false);
        point1311.setVisible(false);
        point1411.setVisible(false);
        point1511.setVisible(false);
        point1611.setVisible(false);
        point1711.setVisible(false);
        point1811.setVisible(false);
        point1911.setVisible(false);
        point2011.setVisible(false);
        point2111.setVisible(false);
        point2211.setVisible(false);
        point2311.setVisible(false);
        point2411.setVisible(false);
        point2511.setVisible(false);

        //y12
        point0012.setVisible(false);
        point0112.setVisible(false);
        point0212.setVisible(false);
        point0312.setVisible(false);
        point0412.setVisible(false);
        point0512.setVisible(false);
        point0612.setVisible(false);
        point0712.setVisible(false);
        point0812.setVisible(false);
        point0912.setVisible(false);
        point1012.setVisible(false);
        point1112.setVisible(false);
        point1212.setVisible(false);
        point1312.setVisible(false);
        point1412.setVisible(false);
        point1512.setVisible(false);
        point1612.setVisible(false);
        point1712.setVisible(false);
        point1812.setVisible(false);
        point1912.setVisible(false);
        point2012.setVisible(false);
        point2112.setVisible(false);
        point2212.setVisible(false);
        point2312.setVisible(false);
        point2412.setVisible(false);
        point2512.setVisible(false);

        //y13
        point0013.setVisible(false);
        point0113.setVisible(false);
        point0213.setVisible(false);
        point0313.setVisible(false);
        point0413.setVisible(false);
        point0513.setVisible(false);
        point0613.setVisible(false);
        point0713.setVisible(false);
        point0813.setVisible(false);
        point0913.setVisible(false);
        point1013.setVisible(false);
        point1113.setVisible(false);
        point1213.setVisible(false);
        point1313.setVisible(false);
        point1413.setVisible(false);
        point1513.setVisible(false);
        point1613.setVisible(false);
        point1713.setVisible(false);
        point1813.setVisible(false);
        point1913.setVisible(false);
        point2013.setVisible(false);
        point2113.setVisible(false);
        point2213.setVisible(false);
        point2313.setVisible(false);
        point2413.setVisible(false);
        point2513.setVisible(false);

        //y14
        point0014.setVisible(false);
        point0114.setVisible(false);
        point0214.setVisible(false);
        point0314.setVisible(false);
        point0414.setVisible(false);
        point0514.setVisible(false);
        point0614.setVisible(false);
        point0714.setVisible(false);
        point0814.setVisible(false);
        point0914.setVisible(false);
        point1014.setVisible(false);
        point1114.setVisible(false);
        point1214.setVisible(false);
        point1314.setVisible(false);
        point1414.setVisible(false);
        point1514.setVisible(false);
        point1614.setVisible(false);
        point1714.setVisible(false);
        point1814.setVisible(false);
        point1914.setVisible(false);
        point2014.setVisible(false);
        point2114.setVisible(false);
        point2214.setVisible(false);
        point2314.setVisible(false);
        point2414.setVisible(false);
        point2514.setVisible(false);

        //y15
        point0015.setVisible(false);
        point0115.setVisible(false);
        point0215.setVisible(false);
        point0315.setVisible(false);
        point0415.setVisible(false);
        point0515.setVisible(false);
        point0615.setVisible(false);
        point0715.setVisible(false);
        point0815.setVisible(false);
        point0915.setVisible(false);
        point1015.setVisible(false);
        point1115.setVisible(false);
        point1215.setVisible(false);
        point1315.setVisible(false);
        point1415.setVisible(false);
        point1515.setVisible(false);
        point1615.setVisible(false);
        point1715.setVisible(false);
        point1815.setVisible(false);
        point1915.setVisible(false);
        point2015.setVisible(false);
        point2115.setVisible(false);
        point2215.setVisible(false);
        point2315.setVisible(false);
        point2415.setVisible(false);
        point2515.setVisible(false);

        //y16
        point0016.setVisible(false);
        point0116.setVisible(false);
        point0216.setVisible(false);
        point0316.setVisible(false);
        point0416.setVisible(false);
        point0516.setVisible(false);
        point0616.setVisible(false);
        point0716.setVisible(false);
        point0816.setVisible(false);
        point0916.setVisible(false);
        point1016.setVisible(false);
        point1116.setVisible(false);
        point1216.setVisible(false);
        point1316.setVisible(false);
        point1416.setVisible(false);
        point1516.setVisible(false);
        point1616.setVisible(false);
        point1716.setVisible(false);
        point1816.setVisible(false);
        point1916.setVisible(false);
        point2016.setVisible(false);
        point2116.setVisible(false);
        point2216.setVisible(false);
        point2316.setVisible(false);
        point2416.setVisible(false);
        point2516.setVisible(false);

        //y17
        point0017.setVisible(false);
        point0117.setVisible(false);
        point0217.setVisible(false);
        point0317.setVisible(false);
        point0417.setVisible(false);
        point0517.setVisible(false);
        point0617.setVisible(false);
        point0717.setVisible(false);
        point0817.setVisible(false);
        point0917.setVisible(false);
        point1017.setVisible(false);
        point1117.setVisible(false);
        point1217.setVisible(false);
        point1317.setVisible(false);
        point1417.setVisible(false);
        point1517.setVisible(false);
        point1617.setVisible(false);
        point1717.setVisible(false);
        point1817.setVisible(false);
        point1917.setVisible(false);
        point2017.setVisible(false);
        point2117.setVisible(false);
        point2217.setVisible(false);
        point2317.setVisible(false);
        point2417.setVisible(false);
        point2517.setVisible(false);

        //y18
        point0018.setVisible(false);
        point0118.setVisible(false);
        point0218.setVisible(false);
        point0318.setVisible(false);
        point0418.setVisible(false);
        point0518.setVisible(false);
        point0618.setVisible(false);
        point0718.setVisible(false);
        point0818.setVisible(false);
        point0918.setVisible(false);
        point1018.setVisible(false);
        point1118.setVisible(false);
        point1218.setVisible(false);
        point1318.setVisible(false);
        point1418.setVisible(false);
        point1518.setVisible(false);
        point1618.setVisible(false);
        point1718.setVisible(false);
        point1818.setVisible(false);
        point1918.setVisible(false);
        point2018.setVisible(false);
        point2118.setVisible(false);
        point2218.setVisible(false);
        point2318.setVisible(false);
        point2418.setVisible(false);
        point2518.setVisible(false);

        //y19
        point0019.setVisible(false);
        point0119.setVisible(false);
        point0219.setVisible(false);
        point0319.setVisible(false);
        point0419.setVisible(false);
        point0519.setVisible(false);
        point0619.setVisible(false);
        point0719.setVisible(false);
        point0819.setVisible(false);
        point0919.setVisible(false);
        point1019.setVisible(false);
        point1119.setVisible(false);
        point1219.setVisible(false);
        point1319.setVisible(false);
        point1419.setVisible(false);
        point1519.setVisible(false);
        point1619.setVisible(false);
        point1719.setVisible(false);
        point1819.setVisible(false);
        point1919.setVisible(false);
        point2019.setVisible(false);
        point2119.setVisible(false);
        point2219.setVisible(false);
        point2319.setVisible(false);
        point2419.setVisible(false);
        point2519.setVisible(false);

        //y20
        point0020.setVisible(false);
        point0120.setVisible(false);
        point0220.setVisible(false);
        point0320.setVisible(false);
        point0420.setVisible(false);
        point0520.setVisible(false);
        point0620.setVisible(false);
        point0720.setVisible(false);
        point0820.setVisible(false);
        point0920.setVisible(false);
        point1020.setVisible(false);
        point1120.setVisible(false);
        point1220.setVisible(false);
        point1320.setVisible(false);
        point1420.setVisible(false);
        point1520.setVisible(false);
        point1620.setVisible(false);
        point1720.setVisible(false);
        point1820.setVisible(false);
        point1920.setVisible(false);
        point2020.setVisible(false);
        point2120.setVisible(false);
        point2220.setVisible(false);
        point2320.setVisible(false);
        point2420.setVisible(false);
        point2520.setVisible(false);

        //y21
        point0021.setVisible(false);
        point0121.setVisible(false);
        point0221.setVisible(false);
        point0321.setVisible(false);
        point0421.setVisible(false);
        point0521.setVisible(false);
        point0621.setVisible(false);
        point0721.setVisible(false);
        point0821.setVisible(false);
        point0921.setVisible(false);
        point1021.setVisible(false);
        point1121.setVisible(false);
        point1221.setVisible(false);
        point1321.setVisible(false);
        point1421.setVisible(false);
        point1521.setVisible(false);
        point1621.setVisible(false);
        point1721.setVisible(false);
        point1821.setVisible(false);
        point1921.setVisible(false);
        point2021.setVisible(false);
        point2121.setVisible(false);
        point2221.setVisible(false);
        point2321.setVisible(false);
        point2421.setVisible(false);
        point2521.setVisible(false);

        //y22
        point0022.setVisible(false);
        point0122.setVisible(false);
        point0222.setVisible(false);
        point0322.setVisible(false);
        point0422.setVisible(false);
        point0522.setVisible(false);
        point0622.setVisible(false);
        point0722.setVisible(false);
        point0822.setVisible(false);
        point0922.setVisible(false);
        point1022.setVisible(false);
        point1122.setVisible(false);
        point1222.setVisible(false);
        point1322.setVisible(false);
        point1422.setVisible(false);
        point1522.setVisible(false);
        point1622.setVisible(false);
        point1722.setVisible(false);
        point1822.setVisible(false);
        point1922.setVisible(false);
        point2022.setVisible(false);
        point2122.setVisible(false);
        point2222.setVisible(false);
        point2322.setVisible(false);
        point2422.setVisible(false);
        point2522.setVisible(false);

        //y23
        point0023.setVisible(false);
        point0123.setVisible(false);
        point0223.setVisible(false);
        point0323.setVisible(false);
        point0423.setVisible(false);
        point0523.setVisible(false);
        point0623.setVisible(false);
        point0723.setVisible(false);
        point0823.setVisible(false);
        point0923.setVisible(false);
        point1023.setVisible(false);
        point1123.setVisible(false);
        point1223.setVisible(false);
        point1323.setVisible(false);
        point1423.setVisible(false);
        point1523.setVisible(false);
        point1623.setVisible(false);
        point1723.setVisible(false);
        point1823.setVisible(false);
        point1923.setVisible(false);
        point2023.setVisible(false);
        point2123.setVisible(false);
        point2223.setVisible(false);
        point2323.setVisible(false);
        point2423.setVisible(false);
        point2523.setVisible(false);

        //y24
        point0024.setVisible(false);
        point0124.setVisible(false);
        point0224.setVisible(false);
        point0324.setVisible(false);
        point0424.setVisible(false);
        point0524.setVisible(false);
        point0624.setVisible(false);
        point0724.setVisible(false);
        point0824.setVisible(false);
        point0924.setVisible(false);
        point1024.setVisible(false);
        point1124.setVisible(false);
        point1224.setVisible(false);
        point1324.setVisible(false);
        point1424.setVisible(false);
        point1524.setVisible(false);
        point1624.setVisible(false);
        point1724.setVisible(false);
        point1824.setVisible(false);
        point1924.setVisible(false);
        point2024.setVisible(false);
        point2124.setVisible(false);
        point2224.setVisible(false);
        point2324.setVisible(false);
        point2424.setVisible(false);
        point2524.setVisible(false);
    }

    private void setposition(double cart_x, double cart_y) {
        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                xMouse = START_POINT_X + (int) cart_x * 25;
                yMouse = START_POINT_Y - (int) cart_y * 25;
                publish(xMouse);
                publish(yMouse);
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
                
                t = new Timer(2, new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        
                        CartLabel.setBounds(xMouse - 20, yMouse - 20, 40, 40);
                        //System.out.println(xMouse4+" "+yMouse4);
                        //CartLabel.setBounds(xMouse4 + 20, yMouse4 + 50, 40, 40);
                    }
                });
                t.start();
                t.setRepeats(false);
            }
        };

        worker.execute();
    }

    private void setArray() {
        //0
        arr[0][0] = point0000;
        arr[0][1] = point0100;
        arr[0][2] = point0200;
        arr[0][3] = point0300;
        arr[0][4] = point0400;
        arr[0][5] = point0500;
        arr[0][6] = point0600;
        arr[0][7] = point0700;
        arr[0][8] = point0800;
        arr[0][9] = point0900;
        arr[0][10] = point1000;
        arr[0][11] = point1100;
        arr[0][12] = point1200;
        arr[0][13] = point1300;
        arr[0][14] = point1400;
        arr[0][15] = point1500;
        arr[0][16] = point1600;
        arr[0][17] = point1700;
        arr[0][18] = point1800;
        arr[0][19] = point1900;
        arr[0][20] = point2000;
        arr[0][21] = point2100;
        arr[0][22] = point2200;
        arr[0][23] = point2300;
        arr[0][24] = point2400;
        arr[0][25] = point2500;

        //1
        arr[1][0] = point0001;
        arr[1][1] = point0101;
        arr[1][2] = point0201;
        arr[1][3] = point0301;
        arr[1][4] = point0401;
        arr[1][5] = point0501;
        arr[1][6] = point0601;
        arr[1][7] = point0701;
        arr[1][8] = point0801;
        arr[1][9] = point0901;
        arr[1][10] = point1001;
        arr[1][11] = point1101;
        arr[1][12] = point1201;
        arr[1][13] = point1301;
        arr[1][14] = point1401;
        arr[1][15] = point1501;
        arr[1][16] = point1601;
        arr[1][17] = point1701;
        arr[1][18] = point1801;
        arr[1][19] = point1901;
        arr[1][20] = point2001;
        arr[1][21] = point2101;
        arr[1][22] = point2201;
        arr[1][23] = point2301;
        arr[1][24] = point2401;
        arr[1][25] = point2501;

        //2
        arr[2][0] = point0002;
        arr[2][1] = point0102;
        arr[2][2] = point0202;
        arr[2][3] = point0302;
        arr[2][4] = point0402;
        arr[2][5] = point0502;
        arr[2][6] = point0602;
        arr[2][7] = point0702;
        arr[2][8] = point0802;
        arr[2][9] = point0902;
        arr[2][10] = point1002;
        arr[2][11] = point1102;
        arr[2][12] = point1202;
        arr[2][13] = point1302;
        arr[2][14] = point1402;
        arr[2][15] = point1502;
        arr[2][16] = point1602;
        arr[2][17] = point1702;
        arr[2][18] = point1802;
        arr[2][19] = point1902;
        arr[2][20] = point2002;
        arr[2][21] = point2102;
        arr[2][22] = point2202;
        arr[2][23] = point2302;
        arr[2][24] = point2402;
        arr[2][25] = point2502;

        //3
        arr[3][0] = point0003;
        arr[3][1] = point0103;
        arr[3][2] = point0203;
        arr[3][3] = point0303;
        arr[3][4] = point0403;
        arr[3][5] = point0503;
        arr[3][6] = point0603;
        arr[3][7] = point0703;
        arr[3][8] = point0803;
        arr[3][9] = point0903;
        arr[3][10] = point1003;
        arr[3][11] = point1103;
        arr[3][12] = point1203;
        arr[3][13] = point1303;
        arr[3][14] = point1403;
        arr[3][15] = point1503;
        arr[3][16] = point1603;
        arr[3][17] = point1703;
        arr[3][18] = point1803;
        arr[3][19] = point1903;
        arr[3][20] = point2003;
        arr[3][21] = point2103;
        arr[3][22] = point2203;
        arr[3][23] = point2303;
        arr[3][24] = point2403;
        arr[3][25] = point2503;

        //4
        arr[4][0] = point0004;
        arr[4][1] = point0104;
        arr[4][2] = point0204;
        arr[4][3] = point0304;
        arr[4][4] = point0404;
        arr[4][5] = point0504;
        arr[4][6] = point0604;
        arr[4][7] = point0704;
        arr[4][8] = point0804;
        arr[4][9] = point0904;
        arr[4][10] = point1004;
        arr[4][11] = point1104;
        arr[4][12] = point1204;
        arr[4][13] = point1304;
        arr[4][14] = point1404;
        arr[4][15] = point1504;
        arr[4][16] = point1604;
        arr[4][17] = point1704;
        arr[4][18] = point1804;
        arr[4][19] = point1904;
        arr[4][20] = point2004;
        arr[4][21] = point2104;
        arr[4][22] = point2204;
        arr[4][23] = point2304;
        arr[4][24] = point2404;
        arr[4][25] = point2504;

        //5
        arr[5][0] = point0005;
        arr[5][1] = point0105;
        arr[5][2] = point0205;
        arr[5][3] = point0305;
        arr[5][4] = point0405;
        arr[5][5] = point0505;
        arr[5][6] = point0605;
        arr[5][7] = point0705;
        arr[5][8] = point0805;
        arr[5][9] = point0905;
        arr[5][10] = point1005;
        arr[5][11] = point1105;
        arr[5][12] = point1205;
        arr[5][13] = point1305;
        arr[5][14] = point1405;
        arr[5][15] = point1505;
        arr[5][16] = point1605;
        arr[5][17] = point1705;
        arr[5][18] = point1805;
        arr[5][19] = point1905;
        arr[5][20] = point2005;
        arr[5][21] = point2105;
        arr[5][22] = point2205;
        arr[5][23] = point2305;
        arr[5][24] = point2405;
        arr[5][25] = point2505;

        //6
        arr[6][0] = point0006;
        arr[6][1] = point0106;
        arr[6][2] = point0206;
        arr[6][3] = point0306;
        arr[6][4] = point0406;
        arr[6][5] = point0506;
        arr[6][6] = point0606;
        arr[6][7] = point0706;
        arr[6][8] = point0806;
        arr[6][9] = point0906;
        arr[6][10] = point1006;
        arr[6][11] = point1106;
        arr[6][12] = point1206;
        arr[6][13] = point1306;
        arr[6][14] = point1406;
        arr[6][15] = point1506;
        arr[6][16] = point1606;
        arr[6][17] = point1706;
        arr[6][18] = point1806;
        arr[6][19] = point1906;
        arr[6][20] = point2006;
        arr[6][21] = point2106;
        arr[6][22] = point2206;
        arr[6][23] = point2306;
        arr[6][24] = point2406;
        arr[6][25] = point2506;

        //7
        arr[7][0] = point0007;
        arr[7][1] = point0107;
        arr[7][2] = point0207;
        arr[7][3] = point0307;
        arr[7][4] = point0407;
        arr[7][5] = point0507;
        arr[7][6] = point0607;
        arr[7][7] = point0707;
        arr[7][8] = point0807;
        arr[7][9] = point0907;
        arr[7][10] = point1007;
        arr[7][11] = point1107;
        arr[7][12] = point1207;
        arr[7][13] = point1307;
        arr[7][14] = point1407;
        arr[7][15] = point1507;
        arr[7][16] = point1607;
        arr[7][17] = point1707;
        arr[7][18] = point1807;
        arr[7][19] = point1907;
        arr[7][20] = point2007;
        arr[7][21] = point2107;
        arr[7][22] = point2207;
        arr[7][23] = point2307;
        arr[7][24] = point2407;
        arr[7][25] = point2507;

        //8
        arr[8][0] = point0008;
        arr[8][1] = point0108;
        arr[8][2] = point0208;
        arr[8][3] = point0308;
        arr[8][4] = point0408;
        arr[8][5] = point0508;
        arr[8][6] = point0608;
        arr[8][7] = point0708;
        arr[8][8] = point0808;
        arr[8][9] = point0908;
        arr[8][10] = point1008;
        arr[8][11] = point1108;
        arr[8][12] = point1208;
        arr[8][13] = point1308;
        arr[8][14] = point1408;
        arr[8][15] = point1508;
        arr[8][16] = point1608;
        arr[8][17] = point1708;
        arr[8][18] = point1808;
        arr[8][19] = point1908;
        arr[8][20] = point2008;
        arr[8][21] = point2108;
        arr[8][22] = point2208;
        arr[8][23] = point2308;
        arr[8][24] = point2408;
        arr[8][25] = point2508;

        //9
        arr[9][0] = point0009;
        arr[9][1] = point0109;
        arr[9][2] = point0209;
        arr[9][3] = point0309;
        arr[9][4] = point0409;
        arr[9][5] = point0509;
        arr[9][6] = point0609;
        arr[9][7] = point0709;
        arr[9][8] = point0809;
        arr[9][9] = point0909;
        arr[9][10] = point1009;
        arr[9][11] = point1109;
        arr[9][12] = point1209;
        arr[9][13] = point1309;
        arr[9][14] = point1409;
        arr[9][15] = point1509;
        arr[9][16] = point1609;
        arr[9][17] = point1709;
        arr[9][18] = point1809;
        arr[9][19] = point1909;
        arr[9][20] = point2009;
        arr[9][21] = point2109;
        arr[9][22] = point2209;
        arr[9][23] = point2309;
        arr[9][24] = point2409;
        arr[9][25] = point2509;

        //10
        arr[10][0] = point0010;
        arr[10][1] = point0110;
        arr[10][2] = point0210;
        arr[10][3] = point0310;
        arr[10][4] = point0410;
        arr[10][5] = point0510;
        arr[10][6] = point0610;
        arr[10][7] = point0710;
        arr[10][8] = point0810;
        arr[10][9] = point0910;
        arr[10][10] = point1010;
        arr[10][11] = point1110;
        arr[10][12] = point1210;
        arr[10][13] = point1310;
        arr[10][14] = point1410;
        arr[10][15] = point1510;
        arr[10][16] = point1610;
        arr[10][17] = point1710;
        arr[10][18] = point1810;
        arr[10][19] = point1910;
        arr[10][20] = point2010;
        arr[10][21] = point2110;
        arr[10][22] = point2210;
        arr[10][23] = point2310;
        arr[10][24] = point2410;
        arr[10][25] = point2510;

        //11
        arr[11][0] = point0011;
        arr[11][1] = point0111;
        arr[11][2] = point0211;
        arr[11][3] = point0311;
        arr[11][4] = point0411;
        arr[11][5] = point0511;
        arr[11][6] = point0611;
        arr[11][7] = point0711;
        arr[11][8] = point0811;
        arr[11][9] = point0911;
        arr[11][10] = point1011;
        arr[11][11] = point1111;
        arr[11][12] = point1211;
        arr[11][13] = point1311;
        arr[11][14] = point1411;
        arr[11][15] = point1511;
        arr[11][16] = point1611;
        arr[11][17] = point1711;
        arr[11][18] = point1811;
        arr[11][19] = point1911;
        arr[11][20] = point2011;
        arr[11][21] = point2111;
        arr[11][22] = point2211;
        arr[11][23] = point2311;
        arr[11][24] = point2411;
        arr[11][25] = point2511;

        //12
        arr[12][0] = point0012;
        arr[12][1] = point0112;
        arr[12][2] = point0212;
        arr[12][3] = point0312;
        arr[12][4] = point0412;
        arr[12][5] = point0512;
        arr[12][6] = point0612;
        arr[12][7] = point0712;
        arr[12][8] = point0812;
        arr[12][9] = point0912;
        arr[12][10] = point1012;
        arr[12][11] = point1112;
        arr[12][12] = point1212;
        arr[12][13] = point1312;
        arr[12][14] = point1412;
        arr[12][15] = point1512;
        arr[12][16] = point1612;
        arr[12][17] = point1712;
        arr[12][18] = point1812;
        arr[12][19] = point1912;
        arr[12][20] = point2012;
        arr[12][21] = point2112;
        arr[12][22] = point2212;
        arr[12][23] = point2312;
        arr[12][24] = point2412;
        arr[12][25] = point2512;

        //13
        arr[13][0] = point0013;
        arr[13][1] = point0113;
        arr[13][2] = point0213;
        arr[13][3] = point0313;
        arr[13][4] = point0413;
        arr[13][5] = point0513;
        arr[13][6] = point0613;
        arr[13][7] = point0713;
        arr[13][8] = point0813;
        arr[13][9] = point0913;
        arr[13][10] = point1013;
        arr[13][11] = point1113;
        arr[13][12] = point1213;
        arr[13][13] = point1313;
        arr[13][14] = point1413;
        arr[13][15] = point1513;
        arr[13][16] = point1613;
        arr[13][17] = point1713;
        arr[13][18] = point1813;
        arr[13][19] = point1913;
        arr[13][20] = point2013;
        arr[13][21] = point2113;
        arr[13][22] = point2213;
        arr[13][23] = point2313;
        arr[13][24] = point2413;
        arr[13][25] = point2513;

        //14
        arr[14][0] = point0014;
        arr[14][1] = point0114;
        arr[14][2] = point0214;
        arr[14][3] = point0314;
        arr[14][4] = point0414;
        arr[14][5] = point0514;
        arr[14][6] = point0614;
        arr[14][7] = point0714;
        arr[14][8] = point0814;
        arr[14][9] = point0914;
        arr[14][10] = point1014;
        arr[14][11] = point1114;
        arr[14][12] = point1214;
        arr[14][13] = point1314;
        arr[14][14] = point1414;
        arr[14][15] = point1514;
        arr[14][16] = point1614;
        arr[14][17] = point1714;
        arr[14][18] = point1814;
        arr[14][19] = point1914;
        arr[14][20] = point2014;
        arr[14][21] = point2114;
        arr[14][22] = point2214;
        arr[14][23] = point2314;
        arr[14][24] = point2414;
        arr[14][25] = point2514;

        //15
        arr[15][0] = point0015;
        arr[15][1] = point0115;
        arr[15][2] = point0215;
        arr[15][3] = point0315;
        arr[15][4] = point0415;
        arr[15][5] = point0515;
        arr[15][6] = point0615;
        arr[15][7] = point0715;
        arr[15][8] = point0815;
        arr[15][9] = point0915;
        arr[15][10] = point1015;
        arr[15][11] = point1115;
        arr[15][12] = point1215;
        arr[15][13] = point1315;
        arr[15][14] = point1415;
        arr[15][15] = point1515;
        arr[15][16] = point1615;
        arr[15][17] = point1715;
        arr[15][18] = point1815;
        arr[15][19] = point1915;
        arr[15][20] = point2015;
        arr[15][21] = point2115;
        arr[15][22] = point2215;
        arr[15][23] = point2315;
        arr[15][24] = point2415;
        arr[15][25] = point2515;

        //16
        arr[16][0] = point0016;
        arr[16][1] = point0116;
        arr[16][2] = point0216;
        arr[16][3] = point0316;
        arr[16][4] = point0416;
        arr[16][5] = point0516;
        arr[16][6] = point0616;
        arr[16][7] = point0716;
        arr[16][8] = point0816;
        arr[16][9] = point0916;
        arr[16][10] = point1016;
        arr[16][11] = point1116;
        arr[16][12] = point1216;
        arr[16][13] = point1316;
        arr[16][14] = point1416;
        arr[16][15] = point1516;
        arr[16][16] = point1616;
        arr[16][17] = point1716;
        arr[16][18] = point1816;
        arr[16][19] = point1916;
        arr[16][20] = point2016;
        arr[16][21] = point2116;
        arr[16][22] = point2216;
        arr[16][23] = point2316;
        arr[16][24] = point2416;
        arr[16][25] = point2516;

        //17
        arr[17][0] = point0017;
        arr[17][1] = point0117;
        arr[17][2] = point0217;
        arr[17][3] = point0317;
        arr[17][4] = point0417;
        arr[17][5] = point0517;
        arr[17][6] = point0617;
        arr[17][7] = point0717;
        arr[17][8] = point0817;
        arr[17][9] = point0917;
        arr[17][10] = point1017;
        arr[17][11] = point1117;
        arr[17][12] = point1217;
        arr[17][13] = point1317;
        arr[17][14] = point1417;
        arr[17][15] = point1517;
        arr[17][16] = point1617;
        arr[17][17] = point1717;
        arr[17][18] = point1817;
        arr[17][19] = point1917;
        arr[17][20] = point2017;
        arr[17][21] = point2117;
        arr[17][22] = point2217;
        arr[17][23] = point2317;
        arr[17][24] = point2417;
        arr[17][25] = point2517;

        //18
        arr[18][0] = point0018;
        arr[18][1] = point0118;
        arr[18][2] = point0218;
        arr[18][3] = point0318;
        arr[18][4] = point0418;
        arr[18][5] = point0518;
        arr[18][6] = point0618;
        arr[18][7] = point0718;
        arr[18][8] = point0818;
        arr[18][9] = point0918;
        arr[18][10] = point1018;
        arr[18][11] = point1118;
        arr[18][12] = point1218;
        arr[18][13] = point1318;
        arr[18][14] = point1418;
        arr[18][15] = point1518;
        arr[18][16] = point1618;
        arr[18][17] = point1718;
        arr[18][18] = point1818;
        arr[18][19] = point1918;
        arr[18][20] = point2018;
        arr[18][21] = point2118;
        arr[18][22] = point2218;
        arr[18][23] = point2318;
        arr[18][24] = point2418;
        arr[18][25] = point2518;

        //19
        arr[19][0] = point0019;
        arr[19][1] = point0119;
        arr[19][2] = point0219;
        arr[19][3] = point0319;
        arr[19][4] = point0419;
        arr[19][5] = point0519;
        arr[19][6] = point0619;
        arr[19][7] = point0719;
        arr[19][8] = point0819;
        arr[19][9] = point0919;
        arr[19][10] = point1019;
        arr[19][11] = point1119;
        arr[19][12] = point1219;
        arr[19][13] = point1319;
        arr[19][14] = point1419;
        arr[19][15] = point1519;
        arr[19][16] = point1619;
        arr[19][17] = point1719;
        arr[19][18] = point1819;
        arr[19][19] = point1919;
        arr[19][20] = point2019;
        arr[19][21] = point2119;
        arr[19][22] = point2219;
        arr[19][23] = point2319;
        arr[19][24] = point2419;
        arr[19][25] = point2519;

        //20
        arr[20][0] = point0020;
        arr[20][1] = point0120;
        arr[20][2] = point0220;
        arr[20][3] = point0320;
        arr[20][4] = point0420;
        arr[20][5] = point0520;
        arr[20][6] = point0620;
        arr[20][7] = point0720;
        arr[20][8] = point0820;
        arr[20][9] = point0920;
        arr[20][10] = point1020;
        arr[20][11] = point1120;
        arr[20][12] = point1220;
        arr[20][13] = point1320;
        arr[20][14] = point1420;
        arr[20][15] = point1520;
        arr[20][16] = point1620;
        arr[20][17] = point1720;
        arr[20][18] = point1820;
        arr[20][19] = point1920;
        arr[20][20] = point2020;
        arr[20][21] = point2120;
        arr[20][22] = point2220;
        arr[20][23] = point2320;
        arr[20][24] = point2420;
        arr[20][25] = point2520;

        //21
        arr[21][0] = point0021;
        arr[21][1] = point0121;
        arr[21][2] = point0221;
        arr[21][3] = point0321;
        arr[21][4] = point0421;
        arr[21][5] = point0521;
        arr[21][6] = point0621;
        arr[21][7] = point0721;
        arr[21][8] = point0821;
        arr[21][9] = point0921;
        arr[21][10] = point1021;
        arr[21][11] = point1121;
        arr[21][12] = point1221;
        arr[21][13] = point1321;
        arr[21][14] = point1421;
        arr[21][15] = point1521;
        arr[21][16] = point1621;
        arr[21][17] = point1721;
        arr[21][18] = point1821;
        arr[21][19] = point1921;
        arr[21][20] = point2021;
        arr[21][21] = point2121;
        arr[21][22] = point2221;
        arr[21][23] = point2321;
        arr[21][24] = point2421;
        arr[21][25] = point2521;

        //22
        arr[22][0] = point0022;
        arr[22][1] = point0122;
        arr[22][2] = point0222;
        arr[22][3] = point0322;
        arr[22][4] = point0422;
        arr[22][5] = point0522;
        arr[22][6] = point0622;
        arr[22][7] = point0722;
        arr[22][8] = point0822;
        arr[22][9] = point0922;
        arr[22][10] = point1022;
        arr[22][11] = point1122;
        arr[22][12] = point1222;
        arr[22][13] = point1322;
        arr[22][14] = point1422;
        arr[22][15] = point1522;
        arr[22][16] = point1622;
        arr[22][17] = point1722;
        arr[22][18] = point1822;
        arr[22][19] = point1922;
        arr[22][20] = point2022;
        arr[22][21] = point2122;
        arr[22][22] = point2222;
        arr[22][23] = point2322;
        arr[22][24] = point2422;
        arr[22][25] = point2522;

        //23
        arr[23][0] = point0023;
        arr[23][1] = point0123;
        arr[23][2] = point0223;
        arr[23][3] = point0323;
        arr[23][4] = point0423;
        arr[23][5] = point0523;
        arr[23][6] = point0623;
        arr[23][7] = point0723;
        arr[23][8] = point0823;
        arr[23][9] = point0923;
        arr[23][10] = point1023;
        arr[23][11] = point1123;
        arr[23][12] = point1223;
        arr[23][13] = point1323;
        arr[23][14] = point1423;
        arr[23][15] = point1523;
        arr[23][16] = point1623;
        arr[23][17] = point1723;
        arr[23][18] = point1823;
        arr[23][19] = point1923;
        arr[23][20] = point2023;
        arr[23][21] = point2123;
        arr[23][22] = point2223;
        arr[23][23] = point2323;
        arr[23][24] = point2423;
        arr[23][25] = point2523;

        //24
        arr[24][0] = point0024;
        arr[24][1] = point0124;
        arr[24][2] = point0224;
        arr[24][3] = point0324;
        arr[24][4] = point0424;
        arr[24][5] = point0524;
        arr[24][6] = point0624;
        arr[24][7] = point0724;
        arr[24][8] = point0824;
        arr[24][9] = point0924;
        arr[24][10] = point1024;
        arr[24][11] = point1124;
        arr[24][12] = point1224;
        arr[24][13] = point1324;
        arr[24][14] = point1424;
        arr[24][15] = point1524;
        arr[24][16] = point1624;
        arr[24][17] = point1724;
        arr[24][18] = point1824;
        arr[24][19] = point1924;
        arr[24][20] = point2024;
        arr[24][21] = point2124;
        arr[24][22] = point2224;
        arr[24][23] = point2324;
        arr[24][24] = point2424;
        arr[24][25] = point2524;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Edit or.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        point2500 = new javax.swing.JLabel();
        point2400 = new javax.swing.JLabel();
        point2300 = new javax.swing.JLabel();
        point2200 = new javax.swing.JLabel();
        point2100 = new javax.swing.JLabel();
        point2000 = new javax.swing.JLabel();
        point1900 = new javax.swing.JLabel();
        point1800 = new javax.swing.JLabel();
        point1700 = new javax.swing.JLabel();
        point1600 = new javax.swing.JLabel();
        point1500 = new javax.swing.JLabel();
        point1400 = new javax.swing.JLabel();
        point1300 = new javax.swing.JLabel();
        point1200 = new javax.swing.JLabel();
        point1100 = new javax.swing.JLabel();
        point1000 = new javax.swing.JLabel();
        point0900 = new javax.swing.JLabel();
        point0800 = new javax.swing.JLabel();
        point0700 = new javax.swing.JLabel();
        point0600 = new javax.swing.JLabel();
        point0500 = new javax.swing.JLabel();
        point0400 = new javax.swing.JLabel();
        point0300 = new javax.swing.JLabel();
        point0200 = new javax.swing.JLabel();
        point0100 = new javax.swing.JLabel();
        point0000 = new javax.swing.JLabel();
        point2501 = new javax.swing.JLabel();
        point2401 = new javax.swing.JLabel();
        point2301 = new javax.swing.JLabel();
        point2201 = new javax.swing.JLabel();
        point2101 = new javax.swing.JLabel();
        point2001 = new javax.swing.JLabel();
        point1901 = new javax.swing.JLabel();
        point1801 = new javax.swing.JLabel();
        point1701 = new javax.swing.JLabel();
        point1601 = new javax.swing.JLabel();
        point1501 = new javax.swing.JLabel();
        point1401 = new javax.swing.JLabel();
        point1301 = new javax.swing.JLabel();
        point1201 = new javax.swing.JLabel();
        point1101 = new javax.swing.JLabel();
        point1001 = new javax.swing.JLabel();
        point0901 = new javax.swing.JLabel();
        point0801 = new javax.swing.JLabel();
        point0701 = new javax.swing.JLabel();
        point0601 = new javax.swing.JLabel();
        point0501 = new javax.swing.JLabel();
        point0401 = new javax.swing.JLabel();
        point0301 = new javax.swing.JLabel();
        point0201 = new javax.swing.JLabel();
        point0101 = new javax.swing.JLabel();
        point0001 = new javax.swing.JLabel();
        point2502 = new javax.swing.JLabel();
        point2402 = new javax.swing.JLabel();
        point2302 = new javax.swing.JLabel();
        point2202 = new javax.swing.JLabel();
        point2102 = new javax.swing.JLabel();
        point2002 = new javax.swing.JLabel();
        point1902 = new javax.swing.JLabel();
        point1802 = new javax.swing.JLabel();
        point1702 = new javax.swing.JLabel();
        point1602 = new javax.swing.JLabel();
        point1502 = new javax.swing.JLabel();
        point1402 = new javax.swing.JLabel();
        point1302 = new javax.swing.JLabel();
        point1202 = new javax.swing.JLabel();
        point1102 = new javax.swing.JLabel();
        point1002 = new javax.swing.JLabel();
        point0902 = new javax.swing.JLabel();
        point0802 = new javax.swing.JLabel();
        point0702 = new javax.swing.JLabel();
        point0602 = new javax.swing.JLabel();
        point0502 = new javax.swing.JLabel();
        point0402 = new javax.swing.JLabel();
        point0302 = new javax.swing.JLabel();
        point0202 = new javax.swing.JLabel();
        point0102 = new javax.swing.JLabel();
        point0002 = new javax.swing.JLabel();
        point2503 = new javax.swing.JLabel();
        point2403 = new javax.swing.JLabel();
        point2303 = new javax.swing.JLabel();
        point2203 = new javax.swing.JLabel();
        point2103 = new javax.swing.JLabel();
        point2003 = new javax.swing.JLabel();
        point1903 = new javax.swing.JLabel();
        point1803 = new javax.swing.JLabel();
        point1703 = new javax.swing.JLabel();
        point1603 = new javax.swing.JLabel();
        point1503 = new javax.swing.JLabel();
        point1403 = new javax.swing.JLabel();
        point1303 = new javax.swing.JLabel();
        point1203 = new javax.swing.JLabel();
        point1103 = new javax.swing.JLabel();
        point1003 = new javax.swing.JLabel();
        point0903 = new javax.swing.JLabel();
        point0803 = new javax.swing.JLabel();
        point0703 = new javax.swing.JLabel();
        point0603 = new javax.swing.JLabel();
        point0503 = new javax.swing.JLabel();
        point0403 = new javax.swing.JLabel();
        point0303 = new javax.swing.JLabel();
        point0203 = new javax.swing.JLabel();
        point0103 = new javax.swing.JLabel();
        point0003 = new javax.swing.JLabel();
        point2504 = new javax.swing.JLabel();
        point2404 = new javax.swing.JLabel();
        point2304 = new javax.swing.JLabel();
        point2204 = new javax.swing.JLabel();
        point2104 = new javax.swing.JLabel();
        point2004 = new javax.swing.JLabel();
        point1904 = new javax.swing.JLabel();
        point1804 = new javax.swing.JLabel();
        point1704 = new javax.swing.JLabel();
        point1604 = new javax.swing.JLabel();
        point1504 = new javax.swing.JLabel();
        point1404 = new javax.swing.JLabel();
        point1304 = new javax.swing.JLabel();
        point1204 = new javax.swing.JLabel();
        point1104 = new javax.swing.JLabel();
        point1004 = new javax.swing.JLabel();
        point0904 = new javax.swing.JLabel();
        point0804 = new javax.swing.JLabel();
        point0704 = new javax.swing.JLabel();
        point0604 = new javax.swing.JLabel();
        point0504 = new javax.swing.JLabel();
        point0404 = new javax.swing.JLabel();
        point0304 = new javax.swing.JLabel();
        point0204 = new javax.swing.JLabel();
        point0104 = new javax.swing.JLabel();
        point2505 = new javax.swing.JLabel();
        point2405 = new javax.swing.JLabel();
        point2305 = new javax.swing.JLabel();
        point2205 = new javax.swing.JLabel();
        point2105 = new javax.swing.JLabel();
        point2005 = new javax.swing.JLabel();
        point1905 = new javax.swing.JLabel();
        point1805 = new javax.swing.JLabel();
        point1705 = new javax.swing.JLabel();
        point1605 = new javax.swing.JLabel();
        point1505 = new javax.swing.JLabel();
        point1405 = new javax.swing.JLabel();
        point1305 = new javax.swing.JLabel();
        point1205 = new javax.swing.JLabel();
        point1105 = new javax.swing.JLabel();
        point1005 = new javax.swing.JLabel();
        point0905 = new javax.swing.JLabel();
        point0805 = new javax.swing.JLabel();
        point0705 = new javax.swing.JLabel();
        point0605 = new javax.swing.JLabel();
        point0505 = new javax.swing.JLabel();
        point0405 = new javax.swing.JLabel();
        point0305 = new javax.swing.JLabel();
        point0205 = new javax.swing.JLabel();
        point0105 = new javax.swing.JLabel();
        point0005 = new javax.swing.JLabel();
        point0004 = new javax.swing.JLabel();
        point2506 = new javax.swing.JLabel();
        point2406 = new javax.swing.JLabel();
        point2306 = new javax.swing.JLabel();
        point2206 = new javax.swing.JLabel();
        point2106 = new javax.swing.JLabel();
        point2006 = new javax.swing.JLabel();
        point1906 = new javax.swing.JLabel();
        point1806 = new javax.swing.JLabel();
        point1706 = new javax.swing.JLabel();
        point1606 = new javax.swing.JLabel();
        point1506 = new javax.swing.JLabel();
        point1406 = new javax.swing.JLabel();
        point1306 = new javax.swing.JLabel();
        point1206 = new javax.swing.JLabel();
        point1106 = new javax.swing.JLabel();
        point1006 = new javax.swing.JLabel();
        point0906 = new javax.swing.JLabel();
        point0806 = new javax.swing.JLabel();
        point0706 = new javax.swing.JLabel();
        point0606 = new javax.swing.JLabel();
        point0506 = new javax.swing.JLabel();
        point0406 = new javax.swing.JLabel();
        point0306 = new javax.swing.JLabel();
        point0206 = new javax.swing.JLabel();
        point0106 = new javax.swing.JLabel();
        point0006 = new javax.swing.JLabel();
        point2507 = new javax.swing.JLabel();
        point2407 = new javax.swing.JLabel();
        point2307 = new javax.swing.JLabel();
        point2207 = new javax.swing.JLabel();
        point2107 = new javax.swing.JLabel();
        point2007 = new javax.swing.JLabel();
        point1907 = new javax.swing.JLabel();
        point1807 = new javax.swing.JLabel();
        point1707 = new javax.swing.JLabel();
        point1607 = new javax.swing.JLabel();
        point1507 = new javax.swing.JLabel();
        point1407 = new javax.swing.JLabel();
        point1307 = new javax.swing.JLabel();
        point1207 = new javax.swing.JLabel();
        point1107 = new javax.swing.JLabel();
        point1007 = new javax.swing.JLabel();
        point0907 = new javax.swing.JLabel();
        point0807 = new javax.swing.JLabel();
        point0707 = new javax.swing.JLabel();
        point0607 = new javax.swing.JLabel();
        point0507 = new javax.swing.JLabel();
        point0407 = new javax.swing.JLabel();
        point0307 = new javax.swing.JLabel();
        point0207 = new javax.swing.JLabel();
        point0107 = new javax.swing.JLabel();
        point0007 = new javax.swing.JLabel();
        point2508 = new javax.swing.JLabel();
        point2408 = new javax.swing.JLabel();
        point2308 = new javax.swing.JLabel();
        point2208 = new javax.swing.JLabel();
        point2108 = new javax.swing.JLabel();
        point2008 = new javax.swing.JLabel();
        point1908 = new javax.swing.JLabel();
        point1808 = new javax.swing.JLabel();
        point1708 = new javax.swing.JLabel();
        point1608 = new javax.swing.JLabel();
        point1508 = new javax.swing.JLabel();
        point1408 = new javax.swing.JLabel();
        point1308 = new javax.swing.JLabel();
        point1208 = new javax.swing.JLabel();
        point1108 = new javax.swing.JLabel();
        point1008 = new javax.swing.JLabel();
        point0908 = new javax.swing.JLabel();
        point0808 = new javax.swing.JLabel();
        point0708 = new javax.swing.JLabel();
        point0608 = new javax.swing.JLabel();
        point0508 = new javax.swing.JLabel();
        point0408 = new javax.swing.JLabel();
        point0308 = new javax.swing.JLabel();
        point0208 = new javax.swing.JLabel();
        point0108 = new javax.swing.JLabel();
        point0008 = new javax.swing.JLabel();
        point2509 = new javax.swing.JLabel();
        point2409 = new javax.swing.JLabel();
        point2309 = new javax.swing.JLabel();
        point2209 = new javax.swing.JLabel();
        point2109 = new javax.swing.JLabel();
        point2009 = new javax.swing.JLabel();
        point1909 = new javax.swing.JLabel();
        point1809 = new javax.swing.JLabel();
        point1709 = new javax.swing.JLabel();
        point1609 = new javax.swing.JLabel();
        point1509 = new javax.swing.JLabel();
        point1409 = new javax.swing.JLabel();
        point1309 = new javax.swing.JLabel();
        point1209 = new javax.swing.JLabel();
        point1109 = new javax.swing.JLabel();
        point1009 = new javax.swing.JLabel();
        point0909 = new javax.swing.JLabel();
        point0809 = new javax.swing.JLabel();
        point0709 = new javax.swing.JLabel();
        point0609 = new javax.swing.JLabel();
        point0509 = new javax.swing.JLabel();
        point0409 = new javax.swing.JLabel();
        point0309 = new javax.swing.JLabel();
        point0209 = new javax.swing.JLabel();
        point0109 = new javax.swing.JLabel();
        point0009 = new javax.swing.JLabel();
        point2510 = new javax.swing.JLabel();
        point2410 = new javax.swing.JLabel();
        point2310 = new javax.swing.JLabel();
        point2210 = new javax.swing.JLabel();
        point2110 = new javax.swing.JLabel();
        point2010 = new javax.swing.JLabel();
        point1910 = new javax.swing.JLabel();
        point1810 = new javax.swing.JLabel();
        point1710 = new javax.swing.JLabel();
        point1610 = new javax.swing.JLabel();
        point1510 = new javax.swing.JLabel();
        point1410 = new javax.swing.JLabel();
        point1310 = new javax.swing.JLabel();
        point1210 = new javax.swing.JLabel();
        point1110 = new javax.swing.JLabel();
        point1010 = new javax.swing.JLabel();
        point0910 = new javax.swing.JLabel();
        point0810 = new javax.swing.JLabel();
        point0710 = new javax.swing.JLabel();
        point0610 = new javax.swing.JLabel();
        point0510 = new javax.swing.JLabel();
        point0410 = new javax.swing.JLabel();
        point0310 = new javax.swing.JLabel();
        point0210 = new javax.swing.JLabel();
        point0110 = new javax.swing.JLabel();
        point0010 = new javax.swing.JLabel();
        point2511 = new javax.swing.JLabel();
        point2411 = new javax.swing.JLabel();
        point2311 = new javax.swing.JLabel();
        point2211 = new javax.swing.JLabel();
        point2111 = new javax.swing.JLabel();
        point2011 = new javax.swing.JLabel();
        point1911 = new javax.swing.JLabel();
        point1811 = new javax.swing.JLabel();
        point1711 = new javax.swing.JLabel();
        point1611 = new javax.swing.JLabel();
        point1511 = new javax.swing.JLabel();
        point1411 = new javax.swing.JLabel();
        point1311 = new javax.swing.JLabel();
        point1211 = new javax.swing.JLabel();
        point1111 = new javax.swing.JLabel();
        point1011 = new javax.swing.JLabel();
        point0911 = new javax.swing.JLabel();
        point0811 = new javax.swing.JLabel();
        point0711 = new javax.swing.JLabel();
        point0611 = new javax.swing.JLabel();
        point0511 = new javax.swing.JLabel();
        point0411 = new javax.swing.JLabel();
        point0311 = new javax.swing.JLabel();
        point0211 = new javax.swing.JLabel();
        point0111 = new javax.swing.JLabel();
        point0011 = new javax.swing.JLabel();
        point2512 = new javax.swing.JLabel();
        point2412 = new javax.swing.JLabel();
        point2312 = new javax.swing.JLabel();
        point2212 = new javax.swing.JLabel();
        point2112 = new javax.swing.JLabel();
        point2012 = new javax.swing.JLabel();
        point1912 = new javax.swing.JLabel();
        point1812 = new javax.swing.JLabel();
        point1712 = new javax.swing.JLabel();
        point1612 = new javax.swing.JLabel();
        point1512 = new javax.swing.JLabel();
        point1412 = new javax.swing.JLabel();
        point1312 = new javax.swing.JLabel();
        point1212 = new javax.swing.JLabel();
        point1112 = new javax.swing.JLabel();
        point1012 = new javax.swing.JLabel();
        point0912 = new javax.swing.JLabel();
        point0812 = new javax.swing.JLabel();
        point0712 = new javax.swing.JLabel();
        point0612 = new javax.swing.JLabel();
        point0512 = new javax.swing.JLabel();
        point0412 = new javax.swing.JLabel();
        point0312 = new javax.swing.JLabel();
        point0212 = new javax.swing.JLabel();
        point0112 = new javax.swing.JLabel();
        point0012 = new javax.swing.JLabel();
        point2513 = new javax.swing.JLabel();
        point2413 = new javax.swing.JLabel();
        point2313 = new javax.swing.JLabel();
        point2213 = new javax.swing.JLabel();
        point2113 = new javax.swing.JLabel();
        point2013 = new javax.swing.JLabel();
        point1913 = new javax.swing.JLabel();
        point1813 = new javax.swing.JLabel();
        point1713 = new javax.swing.JLabel();
        point1613 = new javax.swing.JLabel();
        point1513 = new javax.swing.JLabel();
        point1413 = new javax.swing.JLabel();
        point1313 = new javax.swing.JLabel();
        point1213 = new javax.swing.JLabel();
        point1113 = new javax.swing.JLabel();
        point1013 = new javax.swing.JLabel();
        point0913 = new javax.swing.JLabel();
        point0813 = new javax.swing.JLabel();
        point0713 = new javax.swing.JLabel();
        point0613 = new javax.swing.JLabel();
        point0513 = new javax.swing.JLabel();
        point0413 = new javax.swing.JLabel();
        point0313 = new javax.swing.JLabel();
        point0213 = new javax.swing.JLabel();
        point0113 = new javax.swing.JLabel();
        point0013 = new javax.swing.JLabel();
        point2514 = new javax.swing.JLabel();
        point2414 = new javax.swing.JLabel();
        point2314 = new javax.swing.JLabel();
        point2214 = new javax.swing.JLabel();
        point2114 = new javax.swing.JLabel();
        point2014 = new javax.swing.JLabel();
        point1914 = new javax.swing.JLabel();
        point1814 = new javax.swing.JLabel();
        point1714 = new javax.swing.JLabel();
        point1614 = new javax.swing.JLabel();
        point1514 = new javax.swing.JLabel();
        point1414 = new javax.swing.JLabel();
        point1314 = new javax.swing.JLabel();
        point1214 = new javax.swing.JLabel();
        point1114 = new javax.swing.JLabel();
        point1014 = new javax.swing.JLabel();
        point0914 = new javax.swing.JLabel();
        point0814 = new javax.swing.JLabel();
        point0714 = new javax.swing.JLabel();
        point0614 = new javax.swing.JLabel();
        point0514 = new javax.swing.JLabel();
        point0414 = new javax.swing.JLabel();
        point0314 = new javax.swing.JLabel();
        point0214 = new javax.swing.JLabel();
        point0114 = new javax.swing.JLabel();
        point0014 = new javax.swing.JLabel();
        point2515 = new javax.swing.JLabel();
        point2415 = new javax.swing.JLabel();
        point2315 = new javax.swing.JLabel();
        point2215 = new javax.swing.JLabel();
        point2115 = new javax.swing.JLabel();
        point2015 = new javax.swing.JLabel();
        point1915 = new javax.swing.JLabel();
        point1815 = new javax.swing.JLabel();
        point1715 = new javax.swing.JLabel();
        point1615 = new javax.swing.JLabel();
        point1515 = new javax.swing.JLabel();
        point1415 = new javax.swing.JLabel();
        point1315 = new javax.swing.JLabel();
        point1215 = new javax.swing.JLabel();
        point1115 = new javax.swing.JLabel();
        point1015 = new javax.swing.JLabel();
        point0915 = new javax.swing.JLabel();
        point0815 = new javax.swing.JLabel();
        point0715 = new javax.swing.JLabel();
        point0615 = new javax.swing.JLabel();
        point0515 = new javax.swing.JLabel();
        point0415 = new javax.swing.JLabel();
        point0315 = new javax.swing.JLabel();
        point0215 = new javax.swing.JLabel();
        point0115 = new javax.swing.JLabel();
        point0015 = new javax.swing.JLabel();
        point2516 = new javax.swing.JLabel();
        point2416 = new javax.swing.JLabel();
        point2316 = new javax.swing.JLabel();
        point2216 = new javax.swing.JLabel();
        point2116 = new javax.swing.JLabel();
        point2016 = new javax.swing.JLabel();
        point1916 = new javax.swing.JLabel();
        point1816 = new javax.swing.JLabel();
        point1716 = new javax.swing.JLabel();
        point1616 = new javax.swing.JLabel();
        point1516 = new javax.swing.JLabel();
        point1416 = new javax.swing.JLabel();
        point1316 = new javax.swing.JLabel();
        point1216 = new javax.swing.JLabel();
        point1116 = new javax.swing.JLabel();
        point1016 = new javax.swing.JLabel();
        point0916 = new javax.swing.JLabel();
        point0816 = new javax.swing.JLabel();
        point0716 = new javax.swing.JLabel();
        point0616 = new javax.swing.JLabel();
        point0516 = new javax.swing.JLabel();
        point0416 = new javax.swing.JLabel();
        point0316 = new javax.swing.JLabel();
        point0216 = new javax.swing.JLabel();
        point0116 = new javax.swing.JLabel();
        point0016 = new javax.swing.JLabel();
        point2517 = new javax.swing.JLabel();
        point2417 = new javax.swing.JLabel();
        point2317 = new javax.swing.JLabel();
        point2217 = new javax.swing.JLabel();
        point2117 = new javax.swing.JLabel();
        point2017 = new javax.swing.JLabel();
        point1917 = new javax.swing.JLabel();
        point1817 = new javax.swing.JLabel();
        point1717 = new javax.swing.JLabel();
        point1617 = new javax.swing.JLabel();
        point1517 = new javax.swing.JLabel();
        point1417 = new javax.swing.JLabel();
        point1317 = new javax.swing.JLabel();
        point1217 = new javax.swing.JLabel();
        point1117 = new javax.swing.JLabel();
        point1017 = new javax.swing.JLabel();
        point0917 = new javax.swing.JLabel();
        point0817 = new javax.swing.JLabel();
        point0717 = new javax.swing.JLabel();
        point0617 = new javax.swing.JLabel();
        point0517 = new javax.swing.JLabel();
        point0417 = new javax.swing.JLabel();
        point0317 = new javax.swing.JLabel();
        point0217 = new javax.swing.JLabel();
        point0117 = new javax.swing.JLabel();
        point0017 = new javax.swing.JLabel();
        point2518 = new javax.swing.JLabel();
        point2418 = new javax.swing.JLabel();
        point2318 = new javax.swing.JLabel();
        point2218 = new javax.swing.JLabel();
        point2118 = new javax.swing.JLabel();
        point2018 = new javax.swing.JLabel();
        point1918 = new javax.swing.JLabel();
        point1818 = new javax.swing.JLabel();
        point1718 = new javax.swing.JLabel();
        point1618 = new javax.swing.JLabel();
        point1518 = new javax.swing.JLabel();
        point1418 = new javax.swing.JLabel();
        point1318 = new javax.swing.JLabel();
        point1218 = new javax.swing.JLabel();
        point1118 = new javax.swing.JLabel();
        point1018 = new javax.swing.JLabel();
        point0918 = new javax.swing.JLabel();
        point0818 = new javax.swing.JLabel();
        point0718 = new javax.swing.JLabel();
        point0618 = new javax.swing.JLabel();
        point0518 = new javax.swing.JLabel();
        point0418 = new javax.swing.JLabel();
        point0318 = new javax.swing.JLabel();
        point0218 = new javax.swing.JLabel();
        point0118 = new javax.swing.JLabel();
        point0018 = new javax.swing.JLabel();
        point2519 = new javax.swing.JLabel();
        point2419 = new javax.swing.JLabel();
        point2319 = new javax.swing.JLabel();
        point2219 = new javax.swing.JLabel();
        point2119 = new javax.swing.JLabel();
        point2019 = new javax.swing.JLabel();
        point1919 = new javax.swing.JLabel();
        point1819 = new javax.swing.JLabel();
        point1719 = new javax.swing.JLabel();
        point1619 = new javax.swing.JLabel();
        point1519 = new javax.swing.JLabel();
        point1419 = new javax.swing.JLabel();
        point1319 = new javax.swing.JLabel();
        point1219 = new javax.swing.JLabel();
        point1119 = new javax.swing.JLabel();
        point1019 = new javax.swing.JLabel();
        point0919 = new javax.swing.JLabel();
        point0819 = new javax.swing.JLabel();
        point0719 = new javax.swing.JLabel();
        point0619 = new javax.swing.JLabel();
        point0519 = new javax.swing.JLabel();
        point0419 = new javax.swing.JLabel();
        point0319 = new javax.swing.JLabel();
        point0219 = new javax.swing.JLabel();
        point0119 = new javax.swing.JLabel();
        point0019 = new javax.swing.JLabel();
        point2520 = new javax.swing.JLabel();
        point2420 = new javax.swing.JLabel();
        point2320 = new javax.swing.JLabel();
        point2220 = new javax.swing.JLabel();
        point2120 = new javax.swing.JLabel();
        point2020 = new javax.swing.JLabel();
        point1920 = new javax.swing.JLabel();
        point1820 = new javax.swing.JLabel();
        point1720 = new javax.swing.JLabel();
        point1620 = new javax.swing.JLabel();
        point1520 = new javax.swing.JLabel();
        point1420 = new javax.swing.JLabel();
        point1320 = new javax.swing.JLabel();
        point1220 = new javax.swing.JLabel();
        point1120 = new javax.swing.JLabel();
        point1020 = new javax.swing.JLabel();
        point0920 = new javax.swing.JLabel();
        point0820 = new javax.swing.JLabel();
        point0720 = new javax.swing.JLabel();
        point0620 = new javax.swing.JLabel();
        point0520 = new javax.swing.JLabel();
        point0420 = new javax.swing.JLabel();
        point0320 = new javax.swing.JLabel();
        point0220 = new javax.swing.JLabel();
        point0120 = new javax.swing.JLabel();
        point0020 = new javax.swing.JLabel();
        point2521 = new javax.swing.JLabel();
        point2421 = new javax.swing.JLabel();
        point2321 = new javax.swing.JLabel();
        point2221 = new javax.swing.JLabel();
        point2121 = new javax.swing.JLabel();
        point2021 = new javax.swing.JLabel();
        point1921 = new javax.swing.JLabel();
        point1821 = new javax.swing.JLabel();
        point1721 = new javax.swing.JLabel();
        point1621 = new javax.swing.JLabel();
        point1521 = new javax.swing.JLabel();
        point1421 = new javax.swing.JLabel();
        point1321 = new javax.swing.JLabel();
        point1221 = new javax.swing.JLabel();
        point1121 = new javax.swing.JLabel();
        point1021 = new javax.swing.JLabel();
        point0921 = new javax.swing.JLabel();
        point0821 = new javax.swing.JLabel();
        point0721 = new javax.swing.JLabel();
        point0621 = new javax.swing.JLabel();
        point0521 = new javax.swing.JLabel();
        point0421 = new javax.swing.JLabel();
        point0321 = new javax.swing.JLabel();
        point0221 = new javax.swing.JLabel();
        point0121 = new javax.swing.JLabel();
        point0021 = new javax.swing.JLabel();
        point2522 = new javax.swing.JLabel();
        point2422 = new javax.swing.JLabel();
        point2322 = new javax.swing.JLabel();
        point2222 = new javax.swing.JLabel();
        point2122 = new javax.swing.JLabel();
        point2022 = new javax.swing.JLabel();
        point1922 = new javax.swing.JLabel();
        point1822 = new javax.swing.JLabel();
        point1722 = new javax.swing.JLabel();
        point1622 = new javax.swing.JLabel();
        point1522 = new javax.swing.JLabel();
        point1422 = new javax.swing.JLabel();
        point1322 = new javax.swing.JLabel();
        point1222 = new javax.swing.JLabel();
        point1122 = new javax.swing.JLabel();
        point1022 = new javax.swing.JLabel();
        point0922 = new javax.swing.JLabel();
        point0822 = new javax.swing.JLabel();
        point0722 = new javax.swing.JLabel();
        point0622 = new javax.swing.JLabel();
        point0522 = new javax.swing.JLabel();
        point0422 = new javax.swing.JLabel();
        point0322 = new javax.swing.JLabel();
        point0222 = new javax.swing.JLabel();
        point0122 = new javax.swing.JLabel();
        point0022 = new javax.swing.JLabel();
        point2523 = new javax.swing.JLabel();
        point2423 = new javax.swing.JLabel();
        point2323 = new javax.swing.JLabel();
        point2223 = new javax.swing.JLabel();
        point2123 = new javax.swing.JLabel();
        point2023 = new javax.swing.JLabel();
        point1923 = new javax.swing.JLabel();
        point1823 = new javax.swing.JLabel();
        point1723 = new javax.swing.JLabel();
        point1623 = new javax.swing.JLabel();
        point1523 = new javax.swing.JLabel();
        point1423 = new javax.swing.JLabel();
        point1323 = new javax.swing.JLabel();
        point1223 = new javax.swing.JLabel();
        point1123 = new javax.swing.JLabel();
        point1023 = new javax.swing.JLabel();
        point0923 = new javax.swing.JLabel();
        point0823 = new javax.swing.JLabel();
        point0723 = new javax.swing.JLabel();
        point0623 = new javax.swing.JLabel();
        point0523 = new javax.swing.JLabel();
        point0423 = new javax.swing.JLabel();
        point0323 = new javax.swing.JLabel();
        point0223 = new javax.swing.JLabel();
        point0123 = new javax.swing.JLabel();
        point0023 = new javax.swing.JLabel();
        point2524 = new javax.swing.JLabel();
        point2424 = new javax.swing.JLabel();
        point2324 = new javax.swing.JLabel();
        point2224 = new javax.swing.JLabel();
        point2124 = new javax.swing.JLabel();
        point2024 = new javax.swing.JLabel();
        point1924 = new javax.swing.JLabel();
        point1824 = new javax.swing.JLabel();
        point1724 = new javax.swing.JLabel();
        point1624 = new javax.swing.JLabel();
        point1524 = new javax.swing.JLabel();
        point1424 = new javax.swing.JLabel();
        point1324 = new javax.swing.JLabel();
        point1224 = new javax.swing.JLabel();
        point1124 = new javax.swing.JLabel();
        point1024 = new javax.swing.JLabel();
        point0924 = new javax.swing.JLabel();
        point0824 = new javax.swing.JLabel();
        point0724 = new javax.swing.JLabel();
        point0624 = new javax.swing.JLabel();
        point0524 = new javax.swing.JLabel();
        point0424 = new javax.swing.JLabel();
        point0324 = new javax.swing.JLabel();
        point0224 = new javax.swing.JLabel();
        point0124 = new javax.swing.JLabel();
        point0024 = new javax.swing.JLabel();
        FindPositionLabel = new javax.swing.JLabel();
        SetStrengthText = new javax.swing.JTextField();
        SetStrengthLabel = new javax.swing.JLabel();
        WarningLabel = new javax.swing.JLabel();
        CartLabel = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        MapLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        point2500.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2500.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2500, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 735, 30, 30));

        point2400.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2400.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2400, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 735, 30, 30));

        point2300.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2300.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2300, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 735, 30, 30));

        point2200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2200, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 735, 30, 30));

        point2100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2100, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 735, 30, 30));

        point2000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2000, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 735, 30, 30));

        point1900.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1900.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1900, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 735, 30, 30));

        point1800.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1800.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1800, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 735, 30, 30));

        point1700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1700.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1700, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 735, 30, 30));

        point1600.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1600.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1600, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 735, 30, 30));

        point1500.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1500.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1500, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 735, 30, 30));

        point1400.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1400.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1400, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 735, 30, 30));

        point1300.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1300.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1300, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 735, 30, 30));

        point1200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1200, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 735, 30, 30));

        point1100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1100, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 735, 30, 30));

        point1000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1000, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 735, 30, 30));

        point0900.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0900.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0900, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 735, 30, 30));

        point0800.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0800.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0800, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 735, 30, 30));

        point0700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0700.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0700, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 735, 30, 30));

        point0600.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0600.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0600, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 735, 30, 30));

        point0500.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0500.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0500, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 735, 30, 30));

        point0400.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0400.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0400, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 735, 30, 30));

        point0300.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0300.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0300, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 735, 30, 30));

        point0200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0200, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 735, 30, 30));

        point0100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0100, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 735, 30, 30));

        point0000.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        point0000.setToolTipText("point0000");
        getContentPane().add(point0000, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 735, 30, 30));

        point2501.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2501.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2501, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 710, 30, 30));

        point2401.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2401.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2401, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 710, 30, 30));

        point2301.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2301.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2301, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 710, 30, 30));

        point2201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2201, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 710, 30, 30));

        point2101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2101, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 710, 30, 30));

        point2001.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2001.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2001, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 710, 30, 30));

        point1901.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1901.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1901, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 710, 30, 30));

        point1801.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1801.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1801, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 710, 30, 30));

        point1701.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1701.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1701, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 710, 30, 30));

        point1601.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1601.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1601, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 710, 30, 30));

        point1501.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1501.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1501, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 710, 30, 30));

        point1401.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1401.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1401, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 710, 30, 30));

        point1301.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1301.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1301, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 710, 30, 30));

        point1201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1201, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 710, 30, 30));

        point1101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1101, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 710, 30, 30));

        point1001.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1001.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1001, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 710, 30, 30));

        point0901.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0901.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0901, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 710, 30, 30));

        point0801.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0801.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0801, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 710, 30, 30));

        point0701.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0701.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0701, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 710, 30, 30));

        point0601.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0601.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0601, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 30, 30));

        point0501.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0501.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0501, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 710, 30, 30));

        point0401.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0401.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0401, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 710, 30, 30));

        point0301.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0301.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0301, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 710, 30, 30));

        point0201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0201, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 710, 30, 30));

        point0101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0101, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 710, 30, 30));

        point0001.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0001.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0001, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 710, 30, 30));

        point2502.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2502.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2502, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 685, 30, 30));

        point2402.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2402.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2402, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 685, 30, 30));

        point2302.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2302.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2302, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 685, 30, 30));

        point2202.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2202, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 685, 30, 30));

        point2102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2102, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 685, 30, 30));

        point2002.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2002.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2002, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 685, 30, 30));

        point1902.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1902.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1902, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 685, 30, 30));

        point1802.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1802.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1802, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 685, 30, 30));

        point1702.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1702.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1702, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 685, 30, 30));

        point1602.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1602.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1602, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 685, 30, 30));

        point1502.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1502.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1502, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 685, 30, 30));

        point1402.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1402.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1402, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 685, 30, 30));

        point1302.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1302.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1302, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 685, 30, 30));

        point1202.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1202, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 685, 30, 30));

        point1102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1102, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 685, 30, 30));

        point1002.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1002.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1002, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 685, 30, 30));

        point0902.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0902.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0902, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 685, 30, 30));

        point0802.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0802.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0802, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 685, 30, 30));

        point0702.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0702.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0702, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 685, 30, 30));

        point0602.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0602.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0602, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 685, 30, 30));

        point0502.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0502.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0502, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 685, 30, 30));

        point0402.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0402.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0402, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 685, 30, 30));

        point0302.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0302.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0302, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 685, 30, 30));

        point0202.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0202, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 685, 30, 30));

        point0102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0102, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 685, 30, 30));

        point0002.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0002.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0002, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 685, 30, 30));

        point2503.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2503.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2503, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 660, 30, 30));

        point2403.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2403.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2403, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 30, 30));

        point2303.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2303.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2303, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 660, 30, 30));

        point2203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2203, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 660, 30, 30));

        point2103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2103, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 660, 30, 30));

        point2003.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2003.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2003, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, 30, 30));

        point1903.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1903.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1903, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 660, 30, 30));

        point1803.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1803.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1803, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 660, 30, 30));

        point1703.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1703.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1703, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 660, 30, 30));

        point1603.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1603.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1603, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 30, 30));

        point1503.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1503.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1503, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 660, 30, 30));

        point1403.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1403.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1403, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 660, 30, 30));

        point1303.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1303.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1303, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 660, 30, 30));

        point1203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1203, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 660, 30, 30));

        point1103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1103, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 660, 30, 30));

        point1003.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1003.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1003, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 660, 30, 30));

        point0903.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0903.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0903, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 660, 30, 30));

        point0803.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0803.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0803, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 660, 30, 30));

        point0703.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0703.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0703, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 660, 30, 30));

        point0603.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0603.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0603, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 30, 30));

        point0503.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0503.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0503, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 660, 30, 30));

        point0403.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0403.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0403, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, 30, 30));

        point0303.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0303.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0303, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 660, 30, 30));

        point0203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0203, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 660, 30, 30));

        point0103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0103, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 660, 30, 30));

        point0003.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0003.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0003, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 660, 30, 30));

        point2504.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2504.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2504, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 635, 30, 30));

        point2404.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2404.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2404, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 635, 30, 30));

        point2304.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2304.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2304, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 635, 30, 30));

        point2204.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2204, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 635, 30, 30));

        point2104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2104, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 635, 30, 30));

        point2004.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2004.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2004, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 635, 30, 30));

        point1904.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1904.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1904, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 635, 30, 30));

        point1804.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1804.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1804, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 635, 30, 30));

        point1704.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1704.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1704, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 635, 30, 30));

        point1604.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1604.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1604, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 635, 30, 30));

        point1504.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1504.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1504, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 635, 30, 30));

        point1404.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1404.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1404, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 635, 30, 30));

        point1304.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1304.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1304, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 635, 30, 30));

        point1204.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1204, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 635, 30, 30));

        point1104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1104, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 635, 30, 30));

        point1004.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1004.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1004, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 635, 30, 30));

        point0904.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0904.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0904, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 635, 30, 30));

        point0804.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0804.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0804, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 635, 30, 30));

        point0704.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0704.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0704, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 635, 30, 30));

        point0604.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0604.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0604, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 635, 30, 30));

        point0504.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0504.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0504, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 635, 30, 30));

        point0404.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0404.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0404, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 635, 30, 30));

        point0304.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0304.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0304, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 635, 30, 30));

        point0204.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0204, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 635, 30, 30));

        point0104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0104, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 635, 30, 30));

        point2505.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2505.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2505, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 610, 30, 30));

        point2405.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2405.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2405, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, 30, 30));

        point2305.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2305.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2305, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 610, 30, 30));

        point2205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2205, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, 30, 30));

        point2105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2105, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 610, 30, 30));

        point2005.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2005.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2005, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 30, 30));

        point1905.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1905.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1905, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 610, 30, 30));

        point1805.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1805.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1805, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 30, 30));

        point1705.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1705.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1705, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 610, 30, 30));

        point1605.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1605.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1605, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 610, 30, 30));

        point1505.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1505.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1505, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 610, 30, 30));

        point1405.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1405.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1405, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 30, 30));

        point1305.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1305.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1305, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 610, 30, 30));

        point1205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1205, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 610, 30, 30));

        point1105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1105, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 610, 30, 30));

        point1005.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1005.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1005, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 30, 30));

        point0905.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0905.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0905, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 610, 30, 30));

        point0805.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0805.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0805, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 30, 30));

        point0705.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0705.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0705, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 610, 30, 30));

        point0605.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0605.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0605, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 30, 30));

        point0505.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0505.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0505, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 610, 30, 30));

        point0405.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0405.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0405, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, 30, 30));

        point0305.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0305.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0305, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 610, 30, 30));

        point0205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0205, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 30, 30));

        point0105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0105, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 610, 30, 30));

        point0005.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0005.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0005, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 30, 30));

        point0004.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0004.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0004, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 635, 30, 30));

        point2506.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2506.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2506, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 585, 30, 30));

        point2406.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2406.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2406, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 585, 30, 30));

        point2306.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2306.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2306, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 585, 30, 30));

        point2206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2206, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 585, 30, 30));

        point2106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2106, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 585, 30, 30));

        point2006.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2006.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2006, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 585, 30, 30));

        point1906.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1906.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1906, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 585, 30, 30));

        point1806.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1806.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1806, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 585, 30, 30));

        point1706.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1706.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1706, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 585, 30, 30));

        point1606.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1606.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1606, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 585, 30, 30));

        point1506.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1506.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1506, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 585, 30, 30));

        point1406.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1406.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1406, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 585, 30, 30));

        point1306.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1306.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1306, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 585, 30, 30));

        point1206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1206, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 585, 30, 30));

        point1106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1106, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 585, 30, 30));

        point1006.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1006.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1006, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 585, 30, 30));

        point0906.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0906.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0906, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 585, 30, 30));

        point0806.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0806.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0806, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 585, 30, 30));

        point0706.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0706.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0706, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 585, 30, 30));

        point0606.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0606.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0606, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 585, 30, 30));

        point0506.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0506.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0506, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 585, 30, 30));

        point0406.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0406.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0406, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 585, 30, 30));

        point0306.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0306.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0306, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 585, 30, 30));

        point0206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0206, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 585, 30, 30));

        point0106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0106, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 585, 30, 30));

        point0006.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0006.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0006, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 585, 30, 30));

        point2507.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2507.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2507, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 560, 30, 30));

        point2407.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2407.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2407, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 30, 30));

        point2307.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2307, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 560, 30, 30));

        point2207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2207, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 560, 30, 30));

        point2107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2107, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 560, 30, 30));

        point2007.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2007.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2007, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 30, 30));

        point1907.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1907.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1907, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 560, 30, 30));

        point1807.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1807.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1807, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 30, 30));

        point1707.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1707.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1707, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 560, 30, 30));

        point1607.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1607.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1607, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 560, 30, 30));

        point1507.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1507.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1507, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 560, 30, 30));

        point1407.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1407.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1407, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 30, 30));

        point1307.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1307, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 560, 30, 30));

        point1207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1207, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 30, 30));

        point1107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1107, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 560, 30, 30));

        point1007.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1007.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1007, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 30, 30));

        point0907.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0907.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0907, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 560, 30, 30));

        point0807.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0807.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0807, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, 30, 30));

        point0707.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0707.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0707, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 560, 30, 30));

        point0607.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0607.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0607, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 30, 30));

        point0507.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0507.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0507, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 560, 30, 30));

        point0407.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0407.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0407, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 30, 30));

        point0307.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0307.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0307, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 560, 30, 30));

        point0207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0207, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 30, 30));

        point0107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0107, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 560, 30, 30));

        point0007.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0007.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0007, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 30, 30));

        point2508.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2508.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2508, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 535, 30, 30));

        point2408.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2408.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2408, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 535, 30, 30));

        point2308.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2308.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2308, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 535, 30, 30));

        point2208.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2208.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2208, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 535, 30, 30));

        point2108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2108, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 535, 30, 30));

        point2008.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2008.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2008, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 535, 30, 30));

        point1908.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1908.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1908, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 535, 30, 30));

        point1808.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1808.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1808, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 535, 30, 30));

        point1708.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1708.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1708, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 535, 30, 30));

        point1608.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1608.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1608, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 535, 30, 30));

        point1508.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1508.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1508, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 535, 30, 30));

        point1408.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1408.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1408, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 535, 30, 30));

        point1308.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1308.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1308, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 535, 30, 30));

        point1208.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1208.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1208, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 535, 30, 30));

        point1108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1108, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 535, 30, 30));

        point1008.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1008.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1008, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 535, 30, 30));

        point0908.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0908.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0908, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 535, 30, 30));

        point0808.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0808.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0808, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 535, 30, 30));

        point0708.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0708.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0708, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 535, 30, 30));

        point0608.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0608.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0608, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 535, 30, 30));

        point0508.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0508.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0508, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 535, 30, 30));

        point0408.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0408.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0408, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 535, 30, 30));

        point0308.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0308.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0308, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 535, 30, 30));

        point0208.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0208.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0208, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 535, 30, 30));

        point0108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0108, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 535, 30, 30));

        point0008.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0008.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0008, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 535, 30, 30));

        point2509.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2509.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2509, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 510, 30, 30));

        point2409.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2409.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2409, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, 30, 30));

        point2309.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2309.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2309, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 510, 30, 30));

        point2209.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2209, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 30, 30));

        point2109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2109, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 510, 30, 30));

        point2009.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2009.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2009, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 30, 30));

        point1909.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1909.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1909, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 510, 30, 30));

        point1809.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1809.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1809, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 30, 30));

        point1709.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1709.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1709, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 510, 30, 30));

        point1609.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1609.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1609, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 30, 30));

        point1509.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1509.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1509, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 510, 30, 30));

        point1409.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1409.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1409, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 30, 30));

        point1309.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1309.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1309, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 510, 30, 30));

        point1209.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1209, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 30, 30));

        point1109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1109, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 510, 30, 30));

        point1009.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1009.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1009, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 30, 30));

        point0909.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0909.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0909, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 510, 30, 30));

        point0809.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0809.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0809, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 30, 30));

        point0709.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0709.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0709, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 510, 30, 30));

        point0609.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0609.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0609, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 30, 30));

        point0509.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0509.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0509, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 510, 30, 30));

        point0409.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0409.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0409, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 30, 30));

        point0309.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0309.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0309, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 510, 30, 30));

        point0209.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0209, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 30, 30));

        point0109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0109, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 510, 30, 30));

        point0009.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0009.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0009, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 30, 30));

        point2510.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2510.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2510, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 485, 30, 30));

        point2410.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2410.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2410, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 485, 30, 30));

        point2310.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2310.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2310, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 485, 30, 30));

        point2210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2210, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 485, 30, 30));

        point2110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2110, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 485, 30, 30));

        point2010.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2010.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2010, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 485, 30, 30));

        point1910.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1910.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1910, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 485, 30, 30));

        point1810.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1810.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1810, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 485, 30, 30));

        point1710.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1710.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1710, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 485, 30, 30));

        point1610.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1610.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1610, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 485, 30, 30));

        point1510.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1510.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1510, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 485, 30, 30));

        point1410.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1410.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1410, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 485, 30, 30));

        point1310.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1310.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1310, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 485, 30, 30));

        point1210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1210, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 485, 30, 30));

        point1110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1110, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 485, 30, 30));

        point1010.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1010.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1010, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 485, 30, 30));

        point0910.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0910.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        point0910.setToolTipText("");
        getContentPane().add(point0910, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 485, 30, 30));

        point0810.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0810.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0810, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 485, 30, 30));

        point0710.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0710.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0710, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 485, 30, 30));

        point0610.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0610.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0610, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 485, 30, 30));

        point0510.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0510.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0510, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 485, 30, 30));

        point0410.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0410.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0410, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 485, 30, 30));

        point0310.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0310.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0310, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 485, 30, 30));

        point0210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0210, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 485, 30, 30));

        point0110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0110, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 485, 30, 30));

        point0010.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0010.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0010, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 485, 30, 30));

        point2511.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2511.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2511, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 460, 30, 30));

        point2411.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2411.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2411, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 30, 30));

        point2311.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2311.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2311, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 460, 30, 30));

        point2211.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2211, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, 30, 30));

        point2111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2111, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 460, 30, 30));

        point2011.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2011.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2011, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 30, 30));

        point1911.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1911.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1911, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 460, 30, 30));

        point1811.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1811.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1811, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 30, 30));

        point1711.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1711.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1711, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 460, 30, 30));

        point1611.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1611.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1611, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 30, 30));

        point1511.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1511.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1511, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 460, 30, 30));

        point1411.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1411.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1411, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 30, 30));

        point1311.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1311.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1311, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 460, 30, 30));

        point1211.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1211, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 30, 30));

        point1111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1111, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 460, 30, 30));

        point1011.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1011.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1011, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 30, 30));

        point0911.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0911.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0911, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 460, 30, 30));

        point0811.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0811.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0811, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 30, 30));

        point0711.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0711.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0711, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 460, 30, 30));

        point0611.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0611.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0611, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 30, 30));

        point0511.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0511.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0511, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 460, 30, 30));

        point0411.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0411.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0411, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 30, 30));

        point0311.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0311.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0311, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 460, 30, 30));

        point0211.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0211, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 30, 30));

        point0111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0111, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 460, 30, 30));

        point0011.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0011.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0011, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 30, 30));

        point2512.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2512.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2512, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 435, 30, 30));

        point2412.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2412.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2412, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 435, 30, 30));

        point2312.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2312.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2312, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 435, 30, 30));

        point2212.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2212, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 435, 30, 30));

        point2112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2112, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 435, 30, 30));

        point2012.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2012.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2012, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 435, 30, 30));

        point1912.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1912.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1912, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 435, 30, 30));

        point1812.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1812.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1812, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 435, 30, 30));

        point1712.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1712.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1712, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 435, 30, 30));

        point1612.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1612.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1612, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 435, 30, 30));

        point1512.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1512.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1512, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 435, 30, 30));

        point1412.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1412.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1412, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 435, 30, 30));

        point1312.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1312.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1312, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 435, 30, 30));

        point1212.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1212, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 435, 30, 30));

        point1112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1112, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 435, 30, 30));

        point1012.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1012.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1012, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 435, 30, 30));

        point0912.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0912.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0912, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 435, 30, 30));

        point0812.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0812.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0812, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 435, 30, 30));

        point0712.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0712.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0712, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 435, 30, 30));

        point0612.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0612.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0612, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 435, 30, 30));

        point0512.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0512.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0512, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 435, 30, 30));

        point0412.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0412.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0412, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 435, 30, 30));

        point0312.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0312.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0312, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 435, 30, 30));

        point0212.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0212, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 435, 30, 30));

        point0112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0112, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 435, 30, 30));

        point0012.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0012.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0012, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 435, 30, 30));

        point2513.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2513.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2513, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 410, 30, 30));

        point2413.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2413.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2413, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 30, 30));

        point2313.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2313.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2313, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 410, 30, 30));

        point2213.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2213, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 30, 30));

        point2113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2113, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 410, 30, 30));

        point2013.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2013.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2013, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 30, 30));

        point1913.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1913.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1913, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 410, 30, 30));

        point1813.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1813.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1813, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 30, 30));

        point1713.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1713.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1713, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 410, 30, 30));

        point1613.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1613.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1613, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 30, 30));

        point1513.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1513.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1513, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 410, 30, 30));

        point1413.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1413.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1413, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 30, 30));

        point1313.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1313.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1313, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 410, 30, 30));

        point1213.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1213, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 30, 30));

        point1113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1113, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 410, 30, 30));

        point1013.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1013.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1013, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 30, 30));

        point0913.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0913.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0913, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 410, 30, 30));

        point0813.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0813.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0813, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 30, 30));

        point0713.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0713.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0713, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 410, 30, 30));

        point0613.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0613.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0613, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 30, 30));

        point0513.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0513.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0513, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 410, 30, 30));

        point0413.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0413.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0413, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 30, 30));

        point0313.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0313.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0313, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 410, 30, 30));

        point0213.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0213, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 30, 30));

        point0113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0113, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 410, 30, 30));

        point0013.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0013.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0013, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 30, 30));

        point2514.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2514.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2514, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 385, 30, 30));

        point2414.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2414.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2414, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 385, 30, 30));

        point2314.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2314.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2314, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 385, 30, 30));

        point2214.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2214, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 385, 30, 30));

        point2114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2114, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 385, 30, 30));

        point2014.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2014.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2014, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 385, 30, 30));

        point1914.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1914.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1914, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 385, 30, 30));

        point1814.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1814.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1814, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 385, 30, 30));

        point1714.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1714.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1714, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 385, 30, 30));

        point1614.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1614.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1614, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 385, 30, 30));

        point1514.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1514.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1514, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 385, 30, 30));

        point1414.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1414.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1414, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 385, 30, 30));

        point1314.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1314.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1314, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 385, 30, 30));

        point1214.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1214, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 385, 30, 30));

        point1114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1114, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 385, 30, 30));

        point1014.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1014.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1014, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 385, 30, 30));

        point0914.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0914.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0914, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 385, 30, 30));

        point0814.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0814.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0814, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 385, 30, 30));

        point0714.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0714.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0714, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 385, 30, 30));

        point0614.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0614.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0614, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 385, 30, 30));

        point0514.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0514.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0514, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 385, 30, 30));

        point0414.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0414.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0414, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 385, 30, 30));

        point0314.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0314.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0314, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 385, 30, 30));

        point0214.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0214, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 385, 30, 30));

        point0114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0114, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 385, 30, 30));

        point0014.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0014.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0014, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 385, 30, 30));

        point2515.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2515.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2515, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 360, 30, 30));

        point2415.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2415.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2415, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 30, 30));

        point2315.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2315.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2315, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 360, 30, 30));

        point2215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2215, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 30, 30));

        point2115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2115, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 360, 30, 30));

        point2015.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2015.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2015, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 30, 30));

        point1915.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1915.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1915, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 360, 30, 30));

        point1815.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1815.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1815, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 30, 30));

        point1715.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1715.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1715, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 360, 30, 30));

        point1615.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1615.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1615, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 30, 30));

        point1515.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1515.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1515, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 360, 30, 30));

        point1415.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1415.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1415, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 30, 30));

        point1315.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1315.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1315, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 360, 30, 30));

        point1215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1215, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 30, 30));

        point1115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1115, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 360, 30, 30));

        point1015.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1015.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1015, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 30, 30));

        point0915.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0915.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0915, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 360, 30, 30));

        point0815.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0815.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0815, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 30, 30));

        point0715.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0715.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0715, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 360, 30, 30));

        point0615.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0615.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0615, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 30, 30));

        point0515.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0515.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0515, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 360, 30, 30));

        point0415.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0415.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0415, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 30, 30));

        point0315.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0315.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0315, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 360, 30, 30));

        point0215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0215, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 30, 30));

        point0115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0115, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 360, 30, 30));

        point0015.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0015.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0015, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 30, 30));

        point2516.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2516.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2516, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 335, 30, 30));

        point2416.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2416.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2416, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 335, 30, 30));

        point2316.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2316.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2316, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 335, 30, 30));

        point2216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2216, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 335, 30, 30));

        point2116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2116, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 335, 30, 30));

        point2016.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2016.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2016, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 335, 30, 30));

        point1916.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1916.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1916, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 335, 30, 30));

        point1816.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1816.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1816, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 335, 30, 30));

        point1716.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1716.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1716, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 335, 30, 30));

        point1616.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1616.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1616, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 335, 30, 30));

        point1516.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1516.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1516, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 335, 30, 30));

        point1416.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1416.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1416, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 335, 30, 30));

        point1316.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1316.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1316, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 335, 30, 30));

        point1216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1216, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 335, 30, 30));

        point1116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1116, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 335, 30, 30));

        point1016.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1016.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1016, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 335, 30, 30));

        point0916.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0916.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0916, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 335, 30, 30));

        point0816.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0816.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0816, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 335, 30, 30));

        point0716.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0716.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0716, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 335, 30, 30));

        point0616.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0616.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0616, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 335, 30, 30));

        point0516.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0516.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0516, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 335, 30, 30));

        point0416.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0416.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0416, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 335, 30, 30));

        point0316.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0316.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0316, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 335, 30, 30));

        point0216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0216, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 335, 30, 30));

        point0116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0116, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 335, 30, 30));

        point0016.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0016.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0016, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 335, 30, 30));

        point2517.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2517.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2517, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 310, 30, 30));

        point2417.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2417.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2417, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 30, 30));

        point2317.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2317.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2317, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 310, 30, 30));

        point2217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2217, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 30, 30));

        point2117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2117, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 310, 30, 30));

        point2017.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2017.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2017, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 30, 30));

        point1917.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1917.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1917, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 310, 30, 30));

        point1817.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1817.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1817, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 30, 30));

        point1717.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1717.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1717, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 310, 30, 30));

        point1617.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1617.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1617, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 30, 30));

        point1517.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1517.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1517, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 310, 30, 30));

        point1417.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1417.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1417, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 30, 30));

        point1317.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1317.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1317, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 310, 30, 30));

        point1217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1217, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 30, 30));

        point1117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1117, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 310, 30, 30));

        point1017.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1017.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1017, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 30, 30));

        point0917.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0917.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0917, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 310, 30, 30));

        point0817.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0817.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0817, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 30, 30));

        point0717.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0717.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0717, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 310, 30, 30));

        point0617.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0617.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0617, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 30, 30));

        point0517.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0517.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0517, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 310, 30, 30));

        point0417.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0417.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0417, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 30, 30));

        point0317.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0317.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0317, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 310, 30, 30));

        point0217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0217, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 30, 30));

        point0117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0117, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 310, 30, 30));

        point0017.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0017.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0017, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 30, 30));

        point2518.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2518.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2518, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 285, 30, 30));

        point2418.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2418.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2418, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 285, 30, 30));

        point2318.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2318, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 285, 30, 30));

        point2218.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2218, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 285, 30, 30));

        point2118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2118, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 285, 30, 30));

        point2018.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2018.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2018, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 285, 30, 30));

        point1918.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1918.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1918, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 285, 30, 30));

        point1818.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1818.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1818, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 285, 30, 30));

        point1718.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1718.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1718, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 285, 30, 30));

        point1618.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1618.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1618, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 285, 30, 30));

        point1518.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1518.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1518, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 285, 30, 30));

        point1418.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1418.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1418, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 285, 30, 30));

        point1318.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1318, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 285, 30, 30));

        point1218.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1218, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 285, 30, 30));

        point1118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1118, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 285, 30, 30));

        point1018.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1018.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1018, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 285, 30, 30));

        point0918.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0918.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0918, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 285, 30, 30));

        point0818.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0818.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0818, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 285, 30, 30));

        point0718.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0718.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0718, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 285, 30, 30));

        point0618.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0618.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0618, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 285, 30, 30));

        point0518.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0518.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0518, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 285, 30, 30));

        point0418.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0418.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0418, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 285, 30, 30));

        point0318.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0318.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0318, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 285, 30, 30));

        point0218.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0218, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 285, 30, 30));

        point0118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0118, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 285, 30, 30));

        point0018.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0018.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0018, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 285, 30, 30));

        point2519.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2519.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2519, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 260, 30, 30));

        point2419.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2419.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2419, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 30, 30));

        point2319.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2319.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2319, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 260, 30, 30));

        point2219.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2219, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 30, 30));

        point2119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2119, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 260, 30, 30));

        point2019.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2019.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2019, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 30, 30));

        point1919.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1919.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1919, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 260, 30, 30));

        point1819.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1819.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1819, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 30, 30));

        point1719.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1719.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1719, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 260, 30, 30));

        point1619.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1619.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1619, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 30, 30));

        point1519.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1519.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1519, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 260, 30, 30));

        point1419.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1419.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1419, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 30, 30));

        point1319.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1319.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1319, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 260, 30, 30));

        point1219.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1219, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 30, 30));

        point1119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1119, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 260, 30, 30));

        point1019.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1019.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1019, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 30, 30));

        point0919.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0919.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0919, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 260, 30, 30));

        point0819.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0819.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0819, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 30, 30));

        point0719.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0719.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0719, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 260, 30, 30));

        point0619.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0619.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0619, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 30, 30));

        point0519.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0519.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0519, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 260, 30, 30));

        point0419.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0419.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0419, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 30, 30));

        point0319.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0319.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0319, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 260, 30, 30));

        point0219.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0219, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 30, 30));

        point0119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0119, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 260, 30, 30));

        point0019.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0019.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0019, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 30, 30));

        point2520.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2520.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2520, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 235, 30, 30));

        point2420.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2420.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2420, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 235, 30, 30));

        point2320.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2320.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2320, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 235, 30, 30));

        point2220.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2220, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 235, 30, 30));

        point2120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2120, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 235, 30, 30));

        point2020.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2020.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2020, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 235, 30, 30));

        point1920.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1920.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1920, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 235, 30, 30));

        point1820.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1820.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1820, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 235, 30, 30));

        point1720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1720.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1720, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 235, 30, 30));

        point1620.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1620.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1620, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 235, 30, 30));

        point1520.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1520.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1520, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 235, 30, 30));

        point1420.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1420.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1420, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 235, 30, 30));

        point1320.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1320.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1320, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 235, 30, 30));

        point1220.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1220, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 235, 30, 30));

        point1120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1120, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 235, 30, 30));

        point1020.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1020.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1020, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 235, 30, 30));

        point0920.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0920.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0920, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 235, 30, 30));

        point0820.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0820.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0820, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 235, 30, 30));

        point0720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0720.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0720, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 235, 30, 30));

        point0620.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0620.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0620, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 235, 30, 30));

        point0520.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0520.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0520, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 235, 30, 30));

        point0420.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0420.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0420, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 235, 30, 30));

        point0320.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0320.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0320, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 235, 30, 30));

        point0220.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0220, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 235, 30, 30));

        point0120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0120, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 235, 30, 30));

        point0020.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0020.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0020, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 235, 30, 30));

        point2521.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2521.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2521, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 210, 30, 30));

        point2421.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2421.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2421, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 30, 30));

        point2321.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2321.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2321, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 210, 30, 30));

        point2221.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2221, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 30, 30));

        point2121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2121, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 210, 30, 30));

        point2021.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2021.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2021, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 30, 30));

        point1921.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1921.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1921, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 210, 30, 30));

        point1821.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1821.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1821, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 30, 30));

        point1721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1721.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1721, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 210, 30, 30));

        point1621.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1621.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1621, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 30, 30));

        point1521.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1521.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1521, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 210, 30, 30));

        point1421.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1421.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1421, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 30, 30));

        point1321.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1321.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1321, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 210, 30, 30));

        point1221.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1221, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 30, 30));

        point1121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1121, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 210, 30, 30));

        point1021.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1021.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1021, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 30, 30));

        point0921.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0921.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0921, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 210, 30, 30));

        point0821.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0821.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0821, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 30, 30));

        point0721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0721.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0721, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 210, 30, 30));

        point0621.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0621.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0621, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 30, 30));

        point0521.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0521.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0521, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 210, 30, 30));

        point0421.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0421.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0421, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 30, 30));

        point0321.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0321.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0321, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 210, 30, 30));

        point0221.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0221, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 30, 30));

        point0121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0121, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 210, 30, 30));

        point0021.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0021.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0021, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 30, 30));

        point2522.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2522.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2522, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 180, 30, 30));

        point2422.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2422.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2422, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 30, 30));

        point2322.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2322.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2322, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 180, 30, 30));

        point2222.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2222, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 30, 30));

        point2122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2122, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 180, 30, 30));

        point2022.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2022.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2022, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 30, 30));

        point1922.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1922.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1922, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 180, 30, 30));

        point1822.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1822.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1822, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 30, 30));

        point1722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1722.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1722, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 180, 30, 30));

        point1622.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1622.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1622, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 30, 30));

        point1522.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1522.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1522, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 180, 30, 30));

        point1422.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1422.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1422, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 30, 30));

        point1322.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1322.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1322, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 180, 30, 30));

        point1222.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1222, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 30, 30));

        point1122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1122, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 180, 30, 30));

        point1022.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1022.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1022, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 30, 30));

        point0922.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0922.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0922, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 180, 30, 30));

        point0822.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0822.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0822, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 30, 30));

        point0722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0722.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0722, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 180, 30, 30));

        point0622.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0622.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0622, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 30, 30));

        point0522.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0522.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0522, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 180, 30, 30));

        point0422.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0422.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0422, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 30, 30));

        point0322.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0322.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0322, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 180, 30, 30));

        point0222.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0222, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 30, 30));

        point0122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0122, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 180, 30, 30));

        point0022.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0022.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0022, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 30, 30));

        point2523.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2523.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2523, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 160, 30, 30));

        point2423.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2423.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2423, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 30, 30));

        point2323.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2323.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2323, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 160, 30, 30));

        point2223.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2223, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 30, 30));

        point2123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2123, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 160, 30, 30));

        point2023.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2023.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2023, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 30, 30));

        point1923.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1923.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1923, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 160, 30, 30));

        point1823.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1823.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1823, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 30, 30));

        point1723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1723.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1723, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 160, 30, 30));

        point1623.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1623.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1623, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 30, 30));

        point1523.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1523.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1523, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 160, 30, 30));

        point1423.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1423.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1423, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 30, 30));

        point1323.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1323.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1323, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 160, 30, 30));

        point1223.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1223, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 30, 30));

        point1123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1123, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 160, 30, 30));

        point1023.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1023.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1023, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 30, 30));

        point0923.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0923.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0923, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 160, 30, 30));

        point0823.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0823.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0823, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 30, 30));

        point0723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0723.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0723, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 160, 30, 30));

        point0623.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0623.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0623, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 30, 30));

        point0523.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0523.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0523, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 160, 30, 30));

        point0423.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0423.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0423, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 30, 30));

        point0323.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0323.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0323, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 160, 30, 30));

        point0223.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0223, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 30, 30));

        point0123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0123, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 160, 30, 30));

        point0023.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0023.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0023, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 30, 30));

        point2524.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2524.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2524, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 135, 30, 30));

        point2424.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2424.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2424, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 135, 30, 30));

        point2324.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2324.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2324, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 135, 30, 30));

        point2224.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2224, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 135, 30, 30));

        point2124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2124, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 135, 30, 30));

        point2024.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point2024.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point2024, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 135, 30, 30));

        point1924.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1924.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1924, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 135, 30, 30));

        point1824.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1824.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1824, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 135, 30, 30));

        point1724.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1724.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1724, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 135, 30, 30));

        point1624.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1624.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1624, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 135, 30, 30));

        point1524.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1524.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1524, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 135, 30, 30));

        point1424.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1424.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1424, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 135, 30, 30));

        point1324.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1324.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1324, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 135, 30, 30));

        point1224.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1224, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 135, 30, 30));

        point1124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1124, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 135, 30, 30));

        point1024.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point1024.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point1024, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 135, 30, 30));

        point0924.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0924.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0924, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 135, 30, 30));

        point0824.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0824.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0824, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 135, 30, 30));

        point0724.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0724.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0724, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 135, 30, 30));

        point0624.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0624.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0624, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 135, 30, 30));

        point0524.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0524.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0524, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 135, 30, 30));

        point0424.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0424.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0424, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 135, 30, 30));

        point0324.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0324.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0324, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 135, 30, 30));

        point0224.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0224, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 135, 30, 30));

        point0124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0124, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 135, 30, 30));

        point0024.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        point0024.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nodedot.png"))); // NOI18N
        getContentPane().add(point0024, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 135, 30, 30));

        FindPositionLabel.setFont(new java.awt.Font("Raleway", 0, 24)); // NOI18N
        FindPositionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FindPositionLabel.setText("find");
        FindPositionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FindPositionLabel.setOpaque(true);
        FindPositionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FindPositionLabelMouseClicked(evt);
            }
        });
        getContentPane().add(FindPositionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 730, 120, 40));

        SetStrengthText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SetStrengthText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SetStrengthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetStrengthTextActionPerformed(evt);
            }
        });
        SetStrengthText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SetStrengthTextKeyPressed(evt);
            }
        });
        getContentPane().add(SetStrengthText, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 190, 100, 30));

        SetStrengthLabel.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        SetStrengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SetStrengthLabel.setText("set strength ");
        getContentPane().add(SetStrengthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 140, 30));

        WarningLabel.setBackground(new java.awt.Color(255, 0, 51));
        WarningLabel.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        WarningLabel.setForeground(new java.awt.Color(255, 0, 51));
        WarningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(WarningLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 220, 30));

        CartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CartLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cartdot.png"))); // NOI18N
        getContentPane().add(CartLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        ScrollPane.setViewportView(jTextArea1);

        getContentPane().add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 180, 350));

        MapLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gridmap.png"))); // NOI18N
        MapLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MapLabelMouseClicked(evt);
            }
        });
        getContentPane().add(MapLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MapLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapLabelMouseClicked
        if (SetStrengthLabel.isVisible() == false && SetStrengthText.isVisible() == false) {
            int mouseX = evt.getX();
            int mouseY = evt.getY();
            //System.out.println(mouseX + " " + mouseY);
            boolean posX_validation = false;
            boolean posY_validation = false;
            positionX = mouseX - START_POINT_X;
            if (positionX % 25 <= 3) {
                positionX /= 25;
                posX_validation = true;
            } else if (positionX % 25 >= 21) {
                positionX /= 25;
                positionX += 1;
                posX_validation = true;
            }
            positionY = START_POINT_Y - mouseY;
            if (positionY % 25 <= 3) {
                positionY /= 25;
                posY_validation = true;
            } else if (positionY % 25 >= 21) {
                positionY /= 25;
                positionY += 1;
                posY_validation = true;
            }
            //System.out.println(positionX + " " + positionY + " " + posX_validation + " " + posY_validation);
            if (posX_validation == true && posY_validation == true) {
                if (arr[positionY][positionX].isVisible() == false) {
                    arr[positionY][positionX].setVisible(true);
                    textArea += "Node" + counter + " : (" + positionX + "," + positionY + ")\n";
                    counter++;

                    SetStrengthLabel.setVisible(true);
                    SetStrengthText.setVisible(true);
                } else {
                    arr[positionY][positionX].setVisible(false);
                    CartLabel.setVisible(false);
                    wifi_strengths[positionY][positionX] = 0;
                    counter = 1;
                    textArea = "";
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[i].length; j++) {
                            if (arr[i][j].isVisible() == true) {
                                textArea += "Node" + counter + " : (" + j + "," + i + ")\n";
                                textArea += "Strength: " + wifi_strengths[i][j] + "\n\n";
                                counter++;
                            }
                        }
                    }
                    jTextArea1.setText(textArea);
                    SetStrengthLabel.setVisible(false);
                    SetStrengthText.setVisible(false);
                }
            }
        } else {
            WarningLabel.setText("set strenghts to continue");
        }

    }//GEN-LAST:event_MapLabelMouseClicked

    private void FindPositionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FindPositionLabelMouseClicked
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].isVisible() == true) {
                    count += 1;
                }
            }
        }

        if (count >= 3) {
            String strengths = "AA,";
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j].isVisible() == true) {
                        strengths += j + " " + i + " " + wifi_strengths[i][j] + ",";
                    }
                }
            }
            strengths += "BB";
            calculatePoint(strengths);
            System.out.println("Ater showing:"+strengths);
        } else {
            WarningLabel.setText("Invalid number of nodes");
            WarningLabel.setVisible(true);
        }
    }//GEN-LAST:event_FindPositionLabelMouseClicked

    private void SetStrengthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetStrengthTextActionPerformed

    }//GEN-LAST:event_SetStrengthTextActionPerformed

    private void SetStrengthTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SetStrengthTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && SetStrengthText.getText().length() > 0) {

            double temporaryHolder = Double.parseDouble(SetStrengthText.getText());
            if (temporaryHolder >= 10 && temporaryHolder < 100) {
                temporaryHolder = temporaryHolder / (double) 10;
            } else if (temporaryHolder >= 100 && temporaryHolder <= 999) {
                temporaryHolder = temporaryHolder / (double) 100;
            }

            wifi_strengths[positionY][positionX] = temporaryHolder;
            textArea += "Strength: " + SetStrengthText.getText() + "\n\n";
            SetStrengthLabel.setVisible(false);
            SetStrengthText.setText("");
            SetStrengthText.setVisible(false);
            WarningLabel.setVisible(false);
            jTextArea1.setText(textArea);
        }
    }//GEN-LAST:event_SetStrengthTextKeyPressed

    private void calculatePoint(String str) {
        //assuming the string is of type AA,......,BB
        //node is coming like xxx yyy rr
        //xxx - x coordinate
        //yyy - y coordinate
        //rr - radius
        String raw_values[] = str.split(",");
        int numberOfNodes = raw_values.length - 2;
        System.out.println(numberOfNodes);
        double[] raw_distances = new double[numberOfNodes];
        int x_coordinates[] = new int[numberOfNodes];
        int y_coordinates[] = new int[numberOfNodes];

        for (int i = 0; i < raw_distances.length; i++) {
            System.out.println(raw_values[i + 1]);
            String temp[] = raw_values[i + 1].split(" ");
            raw_distances[i] = Double.parseDouble(temp[2]);
            x_coordinates[i] = Integer.parseInt(temp[0]);
            y_coordinates[i] = Integer.parseInt(temp[1]);
        }

        int min_raw_value_index_1 = raw_distances.length;
        int min_raw_value_index_2 = raw_distances.length;
        int min_raw_value_index_3 = raw_distances.length;

        double min_raw_value_1 = Double.MAX_VALUE;
        double min_raw_value_2 = Double.MAX_VALUE;
        double min_raw_value_3 = Double.MAX_VALUE;

        for (int i = 0; i < raw_distances.length; i++) {
            if (min_raw_value_1 > raw_distances[i]) {
                min_raw_value_1 = raw_distances[i];
                min_raw_value_index_1 = i;
            }
        }

        for (int i = 0; i < raw_distances.length; i++) {
            if (min_raw_value_2 > raw_distances[i] && i != min_raw_value_index_1) {
                min_raw_value_index_2 = i;
                min_raw_value_2 = raw_distances[i];
            }
        }

        for (int i = 0; i < raw_distances.length; i++) {
            if (min_raw_value_3 > raw_distances[i] && i != min_raw_value_index_1 && i != min_raw_value_index_2) {
                min_raw_value_index_3 = i;
                min_raw_value_3 = raw_distances[i];
            }
        }

        double point_x1, point_x2, point_x3;
        double point_y1, point_y2, point_y3;
        double radius_1, radius_2, radius_3;
        double cons_1, cons_2, cons_3;

        double cart_x = 0, cart_y = 0;

        point_x1 = x_coordinates[min_raw_value_index_1];
        point_x2 = x_coordinates[min_raw_value_index_2];
        point_x3 = x_coordinates[min_raw_value_index_3];

        point_y1 = y_coordinates[min_raw_value_index_1];
        point_y2 = y_coordinates[min_raw_value_index_2];
        point_y3 = y_coordinates[min_raw_value_index_3];

        radius_1 = min_raw_value_1;
        radius_2 = min_raw_value_2;
        radius_3 = min_raw_value_3;

        cons_1 = Math.pow(point_x1, 2) + Math.pow(point_y1, 2) - Math.pow(radius_1, 2);
        cons_2 = Math.pow(point_x2, 2) + Math.pow(point_y2, 2) - Math.pow(radius_2, 2);
        cons_3 = Math.pow(point_x3, 2) + Math.pow(point_y3, 2) - Math.pow(radius_3, 2);

        System.out.println("pointX: " + point_x1 + " " + point_x2 + " " + point_x3);
        System.out.println("pointY: " + point_y1 + " " + point_y2 + " " + point_y3);
        System.out.println("radii: " + radius_1 + " " + radius_2 + " " + radius_3);
        System.out.println("cons: " + cons_1 + " " + cons_2 + " " + cons_3);

        double A = ((-2 * point_x1) + (2 * point_x2));
        double B = ((-2 * point_y1) + (2 * point_y2));
        double C = Math.pow(radius_1, 2) - Math.pow(radius_2, 2) - Math.pow(point_x1, 2) + Math.pow(point_x2, 2) - Math.pow(point_y1, 2) + Math.pow(point_y2, 2);
        double D = ((-2 * point_x2) + (2 * point_x3));
        double E = ((-2 * point_y2) + (2 * point_y3));
        double F = Math.pow(radius_2, 2) - Math.pow(radius_3, 2) - Math.pow(point_x2, 2) + Math.pow(point_x3, 2) - Math.pow(point_y2, 2) + Math.pow(point_y3, 2);

        cart_x = (C * E - F * B) / (double) (E * A - B * D);
        cart_y = (C * D - A * F) / (double) (B * D - A * E);

        cart_x = Math.round(cart_x);
        cart_y = Math.round(cart_y);

        cartX = cart_x;
        cartY = cart_y;

        /*
        if ((point_x1 - point_x2) == 0 && (point_y1 - point_y3 != 0) && (point_x1 - point_x3) != 0 && (point_y1 - point_y2) != 0) {
            cart_y = (((cons_1 - cons_3) / (double) (point_x1 - point_x3)) / ((point_y1 - point_y3) / (double) 2 * (point_x1 - point_x3)));
        } else if ((point_x1 - point_x3) == 0 && (point_y1 - point_y2 != 0) && (point_x1 - point_x2) != 0 && (point_y1 - point_y3) != 0) {
            cart_y = (((cons_1 - cons_2) / (double) (point_x1 - point_x2)) / ((point_y1 - point_y2) / (double) 2 * (point_x1 - point_x2)));
        } else if ((point_x1 - point_x2) != 0 && (point_x1 - point_x3) != 0 && (point_y1 - point_y2) == 0 && (point_y1 - point_y3) != 0) {
            cart_y = ((((cons_1 - cons_2) / (double) (point_x1 - point_x2)) - ((cons_1 - cons_3) / (double) (point_x1 - point_x3))) / ((double) -2 * (((point_y1 - point_y3) / (double) (point_x1 - point_x3)))));
        } else if ((point_x1 - point_x2) != 0 && (point_x1 - point_x3) != 0 && (point_y1 - point_y2) != 0 && (point_y1 - point_y3) == 0) {
            cart_y = ((((cons_1 - cons_2) / (double) (point_x1 - point_x2)) - ((cons_1 - cons_3) / (double) (point_x1 - point_x3))) / ((double) 2 * (((point_y1 - point_y2) / (double) (point_x1 - point_x2)))));
        } else if ((point_x1 - point_x2) != 0 && (point_x1 - point_x3) != 0 && (point_y1 - point_y2) != 0 && (point_y1 - point_y3) != 0) {
            cart_y = ((((cons_1 - cons_2) / (double) (point_x1 - point_x2)) - ((cons_1 - cons_3) / (double) (point_x1 - point_x3))) / ((double) 2 * (((point_y1 - point_y2) / (double) (point_x1 - point_x2)) - ((point_y1 - point_y3) / (double) (point_x1 - point_x3)))));
        } else {
            cart_y = ((((cons_1 - cons_2) / (double) (point_x1 - point_x2)) - ((cons_1 - cons_3) / (double) (point_x1 - point_x3))) / ((double) 2 * (((point_y1 - point_y2) / (double) (point_x1 - point_x2)) - ((point_y1 - point_y3) / (double) (point_x1 - point_x3)))));
        }

        if ((point_y1 - point_y2) != 0 && (point_y1 - point_y3) != 0 && (point_x1 - point_x2) != 0 && (point_x1 - point_x3) == 0) {
            cart_x = ((((cons_1 - cons_2) / (double) (point_y1 - point_y2)) - ((cons_1 - cons_3) / (double) (point_y1 - point_y3))) / ((double) 2 * (((point_x1 - point_x2) / (double) (point_y1 - point_y2)))));
        } else if ((point_y1 - point_y2) != 0 && (point_y1 - point_y3) != 0 && (point_x1 - point_x2) == 0 && (point_x1 - point_x3) != 0) {
            cart_x = ((((cons_1 - cons_2) / (double) (point_y1 - point_y2)) - ((cons_1 - cons_3) / (double) (point_y1 - point_y3))) / ((double) -2 * (((point_x1 - point_x3) / (double) (point_y1 - point_y3)))));
        } else if ((point_y1 - point_y2) != 0 && (point_y1 - point_y3) == 0 && (point_x1 - point_x2) != 0 && (point_x1 - point_x3) != 0) {
            cart_x = (((cons_1 - cons_2) / (double) (point_y1 - point_y2)) / ((double) 2 * (((point_x1 - point_x2) / (double) (point_y1 - point_y2)) - ((point_x1 - point_x3) / (double) (point_y1 - point_y3)))));
        } else if ((point_y1 - point_y2) == 0 && (point_y1 - point_y3) != 0 && (point_x1 - point_x2) != 0 && (point_x1 - point_x3) != 0) {
            cart_x = (-((cons_1 - cons_3) / (double) (point_y1 - point_y3)) / ((double) 2 * (((point_x1 - point_x2) / (double) (point_y1 - point_y2)) - ((point_x1 - point_x3) / (double) (point_y1 - point_y3)))));
        } else if ((point_y1 - point_y2) != 0 && (point_y1 - point_y3) != 0 && (point_x1 - point_x2) != 0 && (point_x1 - point_x3) != 0) {
            cart_x = ((((cons_1 - cons_2) / (double) (point_y1 - point_y2)) - ((cons_1 - cons_3) / (double) (point_y1 - point_y3))) / ((double) 2 * (((point_x1 - point_x2) / (double) (point_y1 - point_y2)) - ((point_x1 - point_x3) / (double) (point_y1 - point_y3)))));
        } else {
            cart_x = ((((cons_1 - cons_2) / (double) (point_y1 - point_y2)) - ((cons_1 - cons_3) / (double) (point_y1 - point_y3))) / ((double) 2 * (((point_x1 - point_x2) / (double) (point_y1 - point_y2)) - ((point_x1 - point_x3) / (double) (point_y1 - point_y3)))));
        }

        if (cart_x < 0) {
            cart_x = -cart_x;
        }
        if (cart_y < 0) {
            cart_y = -cart_y;
        }*/
        System.out.println("cart_x: " + cart_x + " cart_y: " + cart_y);
        CartLabel.setVisible(true);
        setposition(cartX, cartY);
    }

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
            java.util.logging.Logger.getLogger(GridMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GridMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GridMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GridMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GridMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CartLabel;
    private javax.swing.JLabel FindPositionLabel;
    private javax.swing.JLabel MapLabel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JLabel SetStrengthLabel;
    private javax.swing.JTextField SetStrengthText;
    private javax.swing.JLabel WarningLabel;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel point0000;
    private javax.swing.JLabel point0001;
    private javax.swing.JLabel point0002;
    private javax.swing.JLabel point0003;
    private javax.swing.JLabel point0004;
    private javax.swing.JLabel point0005;
    private javax.swing.JLabel point0006;
    private javax.swing.JLabel point0007;
    private javax.swing.JLabel point0008;
    private javax.swing.JLabel point0009;
    private javax.swing.JLabel point0010;
    private javax.swing.JLabel point0011;
    private javax.swing.JLabel point0012;
    private javax.swing.JLabel point0013;
    private javax.swing.JLabel point0014;
    private javax.swing.JLabel point0015;
    private javax.swing.JLabel point0016;
    private javax.swing.JLabel point0017;
    private javax.swing.JLabel point0018;
    private javax.swing.JLabel point0019;
    private javax.swing.JLabel point0020;
    private javax.swing.JLabel point0021;
    private javax.swing.JLabel point0022;
    private javax.swing.JLabel point0023;
    private javax.swing.JLabel point0024;
    private javax.swing.JLabel point0100;
    private javax.swing.JLabel point0101;
    private javax.swing.JLabel point0102;
    private javax.swing.JLabel point0103;
    private javax.swing.JLabel point0104;
    private javax.swing.JLabel point0105;
    private javax.swing.JLabel point0106;
    private javax.swing.JLabel point0107;
    private javax.swing.JLabel point0108;
    private javax.swing.JLabel point0109;
    private javax.swing.JLabel point0110;
    private javax.swing.JLabel point0111;
    private javax.swing.JLabel point0112;
    private javax.swing.JLabel point0113;
    private javax.swing.JLabel point0114;
    private javax.swing.JLabel point0115;
    private javax.swing.JLabel point0116;
    private javax.swing.JLabel point0117;
    private javax.swing.JLabel point0118;
    private javax.swing.JLabel point0119;
    private javax.swing.JLabel point0120;
    private javax.swing.JLabel point0121;
    private javax.swing.JLabel point0122;
    private javax.swing.JLabel point0123;
    private javax.swing.JLabel point0124;
    private javax.swing.JLabel point0200;
    private javax.swing.JLabel point0201;
    private javax.swing.JLabel point0202;
    private javax.swing.JLabel point0203;
    private javax.swing.JLabel point0204;
    private javax.swing.JLabel point0205;
    private javax.swing.JLabel point0206;
    private javax.swing.JLabel point0207;
    private javax.swing.JLabel point0208;
    private javax.swing.JLabel point0209;
    private javax.swing.JLabel point0210;
    private javax.swing.JLabel point0211;
    private javax.swing.JLabel point0212;
    private javax.swing.JLabel point0213;
    private javax.swing.JLabel point0214;
    private javax.swing.JLabel point0215;
    private javax.swing.JLabel point0216;
    private javax.swing.JLabel point0217;
    private javax.swing.JLabel point0218;
    private javax.swing.JLabel point0219;
    private javax.swing.JLabel point0220;
    private javax.swing.JLabel point0221;
    private javax.swing.JLabel point0222;
    private javax.swing.JLabel point0223;
    private javax.swing.JLabel point0224;
    private javax.swing.JLabel point0300;
    private javax.swing.JLabel point0301;
    private javax.swing.JLabel point0302;
    private javax.swing.JLabel point0303;
    private javax.swing.JLabel point0304;
    private javax.swing.JLabel point0305;
    private javax.swing.JLabel point0306;
    private javax.swing.JLabel point0307;
    private javax.swing.JLabel point0308;
    private javax.swing.JLabel point0309;
    private javax.swing.JLabel point0310;
    private javax.swing.JLabel point0311;
    private javax.swing.JLabel point0312;
    private javax.swing.JLabel point0313;
    private javax.swing.JLabel point0314;
    private javax.swing.JLabel point0315;
    private javax.swing.JLabel point0316;
    private javax.swing.JLabel point0317;
    private javax.swing.JLabel point0318;
    private javax.swing.JLabel point0319;
    private javax.swing.JLabel point0320;
    private javax.swing.JLabel point0321;
    private javax.swing.JLabel point0322;
    private javax.swing.JLabel point0323;
    private javax.swing.JLabel point0324;
    private javax.swing.JLabel point0400;
    private javax.swing.JLabel point0401;
    private javax.swing.JLabel point0402;
    private javax.swing.JLabel point0403;
    private javax.swing.JLabel point0404;
    private javax.swing.JLabel point0405;
    private javax.swing.JLabel point0406;
    private javax.swing.JLabel point0407;
    private javax.swing.JLabel point0408;
    private javax.swing.JLabel point0409;
    private javax.swing.JLabel point0410;
    private javax.swing.JLabel point0411;
    private javax.swing.JLabel point0412;
    private javax.swing.JLabel point0413;
    private javax.swing.JLabel point0414;
    private javax.swing.JLabel point0415;
    private javax.swing.JLabel point0416;
    private javax.swing.JLabel point0417;
    private javax.swing.JLabel point0418;
    private javax.swing.JLabel point0419;
    private javax.swing.JLabel point0420;
    private javax.swing.JLabel point0421;
    private javax.swing.JLabel point0422;
    private javax.swing.JLabel point0423;
    private javax.swing.JLabel point0424;
    private javax.swing.JLabel point0500;
    private javax.swing.JLabel point0501;
    private javax.swing.JLabel point0502;
    private javax.swing.JLabel point0503;
    private javax.swing.JLabel point0504;
    private javax.swing.JLabel point0505;
    private javax.swing.JLabel point0506;
    private javax.swing.JLabel point0507;
    private javax.swing.JLabel point0508;
    private javax.swing.JLabel point0509;
    private javax.swing.JLabel point0510;
    private javax.swing.JLabel point0511;
    private javax.swing.JLabel point0512;
    private javax.swing.JLabel point0513;
    private javax.swing.JLabel point0514;
    private javax.swing.JLabel point0515;
    private javax.swing.JLabel point0516;
    private javax.swing.JLabel point0517;
    private javax.swing.JLabel point0518;
    private javax.swing.JLabel point0519;
    private javax.swing.JLabel point0520;
    private javax.swing.JLabel point0521;
    private javax.swing.JLabel point0522;
    private javax.swing.JLabel point0523;
    private javax.swing.JLabel point0524;
    private javax.swing.JLabel point0600;
    private javax.swing.JLabel point0601;
    private javax.swing.JLabel point0602;
    private javax.swing.JLabel point0603;
    private javax.swing.JLabel point0604;
    private javax.swing.JLabel point0605;
    private javax.swing.JLabel point0606;
    private javax.swing.JLabel point0607;
    private javax.swing.JLabel point0608;
    private javax.swing.JLabel point0609;
    private javax.swing.JLabel point0610;
    private javax.swing.JLabel point0611;
    private javax.swing.JLabel point0612;
    private javax.swing.JLabel point0613;
    private javax.swing.JLabel point0614;
    private javax.swing.JLabel point0615;
    private javax.swing.JLabel point0616;
    private javax.swing.JLabel point0617;
    private javax.swing.JLabel point0618;
    private javax.swing.JLabel point0619;
    private javax.swing.JLabel point0620;
    private javax.swing.JLabel point0621;
    private javax.swing.JLabel point0622;
    private javax.swing.JLabel point0623;
    private javax.swing.JLabel point0624;
    private javax.swing.JLabel point0700;
    private javax.swing.JLabel point0701;
    private javax.swing.JLabel point0702;
    private javax.swing.JLabel point0703;
    private javax.swing.JLabel point0704;
    private javax.swing.JLabel point0705;
    private javax.swing.JLabel point0706;
    private javax.swing.JLabel point0707;
    private javax.swing.JLabel point0708;
    private javax.swing.JLabel point0709;
    private javax.swing.JLabel point0710;
    private javax.swing.JLabel point0711;
    private javax.swing.JLabel point0712;
    private javax.swing.JLabel point0713;
    private javax.swing.JLabel point0714;
    private javax.swing.JLabel point0715;
    private javax.swing.JLabel point0716;
    private javax.swing.JLabel point0717;
    private javax.swing.JLabel point0718;
    private javax.swing.JLabel point0719;
    private javax.swing.JLabel point0720;
    private javax.swing.JLabel point0721;
    private javax.swing.JLabel point0722;
    private javax.swing.JLabel point0723;
    private javax.swing.JLabel point0724;
    private javax.swing.JLabel point0800;
    private javax.swing.JLabel point0801;
    private javax.swing.JLabel point0802;
    private javax.swing.JLabel point0803;
    private javax.swing.JLabel point0804;
    private javax.swing.JLabel point0805;
    private javax.swing.JLabel point0806;
    private javax.swing.JLabel point0807;
    private javax.swing.JLabel point0808;
    private javax.swing.JLabel point0809;
    private javax.swing.JLabel point0810;
    private javax.swing.JLabel point0811;
    private javax.swing.JLabel point0812;
    private javax.swing.JLabel point0813;
    private javax.swing.JLabel point0814;
    private javax.swing.JLabel point0815;
    private javax.swing.JLabel point0816;
    private javax.swing.JLabel point0817;
    private javax.swing.JLabel point0818;
    private javax.swing.JLabel point0819;
    private javax.swing.JLabel point0820;
    private javax.swing.JLabel point0821;
    private javax.swing.JLabel point0822;
    private javax.swing.JLabel point0823;
    private javax.swing.JLabel point0824;
    private javax.swing.JLabel point0900;
    private javax.swing.JLabel point0901;
    private javax.swing.JLabel point0902;
    private javax.swing.JLabel point0903;
    private javax.swing.JLabel point0904;
    private javax.swing.JLabel point0905;
    private javax.swing.JLabel point0906;
    private javax.swing.JLabel point0907;
    private javax.swing.JLabel point0908;
    private javax.swing.JLabel point0909;
    private javax.swing.JLabel point0910;
    private javax.swing.JLabel point0911;
    private javax.swing.JLabel point0912;
    private javax.swing.JLabel point0913;
    private javax.swing.JLabel point0914;
    private javax.swing.JLabel point0915;
    private javax.swing.JLabel point0916;
    private javax.swing.JLabel point0917;
    private javax.swing.JLabel point0918;
    private javax.swing.JLabel point0919;
    private javax.swing.JLabel point0920;
    private javax.swing.JLabel point0921;
    private javax.swing.JLabel point0922;
    private javax.swing.JLabel point0923;
    private javax.swing.JLabel point0924;
    private javax.swing.JLabel point1000;
    private javax.swing.JLabel point1001;
    private javax.swing.JLabel point1002;
    private javax.swing.JLabel point1003;
    private javax.swing.JLabel point1004;
    private javax.swing.JLabel point1005;
    private javax.swing.JLabel point1006;
    private javax.swing.JLabel point1007;
    private javax.swing.JLabel point1008;
    private javax.swing.JLabel point1009;
    private javax.swing.JLabel point1010;
    private javax.swing.JLabel point1011;
    private javax.swing.JLabel point1012;
    private javax.swing.JLabel point1013;
    private javax.swing.JLabel point1014;
    private javax.swing.JLabel point1015;
    private javax.swing.JLabel point1016;
    private javax.swing.JLabel point1017;
    private javax.swing.JLabel point1018;
    private javax.swing.JLabel point1019;
    private javax.swing.JLabel point1020;
    private javax.swing.JLabel point1021;
    private javax.swing.JLabel point1022;
    private javax.swing.JLabel point1023;
    private javax.swing.JLabel point1024;
    private javax.swing.JLabel point1100;
    private javax.swing.JLabel point1101;
    private javax.swing.JLabel point1102;
    private javax.swing.JLabel point1103;
    private javax.swing.JLabel point1104;
    private javax.swing.JLabel point1105;
    private javax.swing.JLabel point1106;
    private javax.swing.JLabel point1107;
    private javax.swing.JLabel point1108;
    private javax.swing.JLabel point1109;
    private javax.swing.JLabel point1110;
    private javax.swing.JLabel point1111;
    private javax.swing.JLabel point1112;
    private javax.swing.JLabel point1113;
    private javax.swing.JLabel point1114;
    private javax.swing.JLabel point1115;
    private javax.swing.JLabel point1116;
    private javax.swing.JLabel point1117;
    private javax.swing.JLabel point1118;
    private javax.swing.JLabel point1119;
    private javax.swing.JLabel point1120;
    private javax.swing.JLabel point1121;
    private javax.swing.JLabel point1122;
    private javax.swing.JLabel point1123;
    private javax.swing.JLabel point1124;
    private javax.swing.JLabel point1200;
    private javax.swing.JLabel point1201;
    private javax.swing.JLabel point1202;
    private javax.swing.JLabel point1203;
    private javax.swing.JLabel point1204;
    private javax.swing.JLabel point1205;
    private javax.swing.JLabel point1206;
    private javax.swing.JLabel point1207;
    private javax.swing.JLabel point1208;
    private javax.swing.JLabel point1209;
    private javax.swing.JLabel point1210;
    private javax.swing.JLabel point1211;
    private javax.swing.JLabel point1212;
    private javax.swing.JLabel point1213;
    private javax.swing.JLabel point1214;
    private javax.swing.JLabel point1215;
    private javax.swing.JLabel point1216;
    private javax.swing.JLabel point1217;
    private javax.swing.JLabel point1218;
    private javax.swing.JLabel point1219;
    private javax.swing.JLabel point1220;
    private javax.swing.JLabel point1221;
    private javax.swing.JLabel point1222;
    private javax.swing.JLabel point1223;
    private javax.swing.JLabel point1224;
    private javax.swing.JLabel point1300;
    private javax.swing.JLabel point1301;
    private javax.swing.JLabel point1302;
    private javax.swing.JLabel point1303;
    private javax.swing.JLabel point1304;
    private javax.swing.JLabel point1305;
    private javax.swing.JLabel point1306;
    private javax.swing.JLabel point1307;
    private javax.swing.JLabel point1308;
    private javax.swing.JLabel point1309;
    private javax.swing.JLabel point1310;
    private javax.swing.JLabel point1311;
    private javax.swing.JLabel point1312;
    private javax.swing.JLabel point1313;
    private javax.swing.JLabel point1314;
    private javax.swing.JLabel point1315;
    private javax.swing.JLabel point1316;
    private javax.swing.JLabel point1317;
    private javax.swing.JLabel point1318;
    private javax.swing.JLabel point1319;
    private javax.swing.JLabel point1320;
    private javax.swing.JLabel point1321;
    private javax.swing.JLabel point1322;
    private javax.swing.JLabel point1323;
    private javax.swing.JLabel point1324;
    private javax.swing.JLabel point1400;
    private javax.swing.JLabel point1401;
    private javax.swing.JLabel point1402;
    private javax.swing.JLabel point1403;
    private javax.swing.JLabel point1404;
    private javax.swing.JLabel point1405;
    private javax.swing.JLabel point1406;
    private javax.swing.JLabel point1407;
    private javax.swing.JLabel point1408;
    private javax.swing.JLabel point1409;
    private javax.swing.JLabel point1410;
    private javax.swing.JLabel point1411;
    private javax.swing.JLabel point1412;
    private javax.swing.JLabel point1413;
    private javax.swing.JLabel point1414;
    private javax.swing.JLabel point1415;
    private javax.swing.JLabel point1416;
    private javax.swing.JLabel point1417;
    private javax.swing.JLabel point1418;
    private javax.swing.JLabel point1419;
    private javax.swing.JLabel point1420;
    private javax.swing.JLabel point1421;
    private javax.swing.JLabel point1422;
    private javax.swing.JLabel point1423;
    private javax.swing.JLabel point1424;
    private javax.swing.JLabel point1500;
    private javax.swing.JLabel point1501;
    private javax.swing.JLabel point1502;
    private javax.swing.JLabel point1503;
    private javax.swing.JLabel point1504;
    private javax.swing.JLabel point1505;
    private javax.swing.JLabel point1506;
    private javax.swing.JLabel point1507;
    private javax.swing.JLabel point1508;
    private javax.swing.JLabel point1509;
    private javax.swing.JLabel point1510;
    private javax.swing.JLabel point1511;
    private javax.swing.JLabel point1512;
    private javax.swing.JLabel point1513;
    private javax.swing.JLabel point1514;
    private javax.swing.JLabel point1515;
    private javax.swing.JLabel point1516;
    private javax.swing.JLabel point1517;
    private javax.swing.JLabel point1518;
    private javax.swing.JLabel point1519;
    private javax.swing.JLabel point1520;
    private javax.swing.JLabel point1521;
    private javax.swing.JLabel point1522;
    private javax.swing.JLabel point1523;
    private javax.swing.JLabel point1524;
    private javax.swing.JLabel point1600;
    private javax.swing.JLabel point1601;
    private javax.swing.JLabel point1602;
    private javax.swing.JLabel point1603;
    private javax.swing.JLabel point1604;
    private javax.swing.JLabel point1605;
    private javax.swing.JLabel point1606;
    private javax.swing.JLabel point1607;
    private javax.swing.JLabel point1608;
    private javax.swing.JLabel point1609;
    private javax.swing.JLabel point1610;
    private javax.swing.JLabel point1611;
    private javax.swing.JLabel point1612;
    private javax.swing.JLabel point1613;
    private javax.swing.JLabel point1614;
    private javax.swing.JLabel point1615;
    private javax.swing.JLabel point1616;
    private javax.swing.JLabel point1617;
    private javax.swing.JLabel point1618;
    private javax.swing.JLabel point1619;
    private javax.swing.JLabel point1620;
    private javax.swing.JLabel point1621;
    private javax.swing.JLabel point1622;
    private javax.swing.JLabel point1623;
    private javax.swing.JLabel point1624;
    private javax.swing.JLabel point1700;
    private javax.swing.JLabel point1701;
    private javax.swing.JLabel point1702;
    private javax.swing.JLabel point1703;
    private javax.swing.JLabel point1704;
    private javax.swing.JLabel point1705;
    private javax.swing.JLabel point1706;
    private javax.swing.JLabel point1707;
    private javax.swing.JLabel point1708;
    private javax.swing.JLabel point1709;
    private javax.swing.JLabel point1710;
    private javax.swing.JLabel point1711;
    private javax.swing.JLabel point1712;
    private javax.swing.JLabel point1713;
    private javax.swing.JLabel point1714;
    private javax.swing.JLabel point1715;
    private javax.swing.JLabel point1716;
    private javax.swing.JLabel point1717;
    private javax.swing.JLabel point1718;
    private javax.swing.JLabel point1719;
    private javax.swing.JLabel point1720;
    private javax.swing.JLabel point1721;
    private javax.swing.JLabel point1722;
    private javax.swing.JLabel point1723;
    private javax.swing.JLabel point1724;
    private javax.swing.JLabel point1800;
    private javax.swing.JLabel point1801;
    private javax.swing.JLabel point1802;
    private javax.swing.JLabel point1803;
    private javax.swing.JLabel point1804;
    private javax.swing.JLabel point1805;
    private javax.swing.JLabel point1806;
    private javax.swing.JLabel point1807;
    private javax.swing.JLabel point1808;
    private javax.swing.JLabel point1809;
    private javax.swing.JLabel point1810;
    private javax.swing.JLabel point1811;
    private javax.swing.JLabel point1812;
    private javax.swing.JLabel point1813;
    private javax.swing.JLabel point1814;
    private javax.swing.JLabel point1815;
    private javax.swing.JLabel point1816;
    private javax.swing.JLabel point1817;
    private javax.swing.JLabel point1818;
    private javax.swing.JLabel point1819;
    private javax.swing.JLabel point1820;
    private javax.swing.JLabel point1821;
    private javax.swing.JLabel point1822;
    private javax.swing.JLabel point1823;
    private javax.swing.JLabel point1824;
    private javax.swing.JLabel point1900;
    private javax.swing.JLabel point1901;
    private javax.swing.JLabel point1902;
    private javax.swing.JLabel point1903;
    private javax.swing.JLabel point1904;
    private javax.swing.JLabel point1905;
    private javax.swing.JLabel point1906;
    private javax.swing.JLabel point1907;
    private javax.swing.JLabel point1908;
    private javax.swing.JLabel point1909;
    private javax.swing.JLabel point1910;
    private javax.swing.JLabel point1911;
    private javax.swing.JLabel point1912;
    private javax.swing.JLabel point1913;
    private javax.swing.JLabel point1914;
    private javax.swing.JLabel point1915;
    private javax.swing.JLabel point1916;
    private javax.swing.JLabel point1917;
    private javax.swing.JLabel point1918;
    private javax.swing.JLabel point1919;
    private javax.swing.JLabel point1920;
    private javax.swing.JLabel point1921;
    private javax.swing.JLabel point1922;
    private javax.swing.JLabel point1923;
    private javax.swing.JLabel point1924;
    private javax.swing.JLabel point2000;
    private javax.swing.JLabel point2001;
    private javax.swing.JLabel point2002;
    private javax.swing.JLabel point2003;
    private javax.swing.JLabel point2004;
    private javax.swing.JLabel point2005;
    private javax.swing.JLabel point2006;
    private javax.swing.JLabel point2007;
    private javax.swing.JLabel point2008;
    private javax.swing.JLabel point2009;
    private javax.swing.JLabel point2010;
    private javax.swing.JLabel point2011;
    private javax.swing.JLabel point2012;
    private javax.swing.JLabel point2013;
    private javax.swing.JLabel point2014;
    private javax.swing.JLabel point2015;
    private javax.swing.JLabel point2016;
    private javax.swing.JLabel point2017;
    private javax.swing.JLabel point2018;
    private javax.swing.JLabel point2019;
    private javax.swing.JLabel point2020;
    private javax.swing.JLabel point2021;
    private javax.swing.JLabel point2022;
    private javax.swing.JLabel point2023;
    private javax.swing.JLabel point2024;
    private javax.swing.JLabel point2100;
    private javax.swing.JLabel point2101;
    private javax.swing.JLabel point2102;
    private javax.swing.JLabel point2103;
    private javax.swing.JLabel point2104;
    private javax.swing.JLabel point2105;
    private javax.swing.JLabel point2106;
    private javax.swing.JLabel point2107;
    private javax.swing.JLabel point2108;
    private javax.swing.JLabel point2109;
    private javax.swing.JLabel point2110;
    private javax.swing.JLabel point2111;
    private javax.swing.JLabel point2112;
    private javax.swing.JLabel point2113;
    private javax.swing.JLabel point2114;
    private javax.swing.JLabel point2115;
    private javax.swing.JLabel point2116;
    private javax.swing.JLabel point2117;
    private javax.swing.JLabel point2118;
    private javax.swing.JLabel point2119;
    private javax.swing.JLabel point2120;
    private javax.swing.JLabel point2121;
    private javax.swing.JLabel point2122;
    private javax.swing.JLabel point2123;
    private javax.swing.JLabel point2124;
    private javax.swing.JLabel point2200;
    private javax.swing.JLabel point2201;
    private javax.swing.JLabel point2202;
    private javax.swing.JLabel point2203;
    private javax.swing.JLabel point2204;
    private javax.swing.JLabel point2205;
    private javax.swing.JLabel point2206;
    private javax.swing.JLabel point2207;
    private javax.swing.JLabel point2208;
    private javax.swing.JLabel point2209;
    private javax.swing.JLabel point2210;
    private javax.swing.JLabel point2211;
    private javax.swing.JLabel point2212;
    private javax.swing.JLabel point2213;
    private javax.swing.JLabel point2214;
    private javax.swing.JLabel point2215;
    private javax.swing.JLabel point2216;
    private javax.swing.JLabel point2217;
    private javax.swing.JLabel point2218;
    private javax.swing.JLabel point2219;
    private javax.swing.JLabel point2220;
    private javax.swing.JLabel point2221;
    private javax.swing.JLabel point2222;
    private javax.swing.JLabel point2223;
    private javax.swing.JLabel point2224;
    private javax.swing.JLabel point2300;
    private javax.swing.JLabel point2301;
    private javax.swing.JLabel point2302;
    private javax.swing.JLabel point2303;
    private javax.swing.JLabel point2304;
    private javax.swing.JLabel point2305;
    private javax.swing.JLabel point2306;
    private javax.swing.JLabel point2307;
    private javax.swing.JLabel point2308;
    private javax.swing.JLabel point2309;
    private javax.swing.JLabel point2310;
    private javax.swing.JLabel point2311;
    private javax.swing.JLabel point2312;
    private javax.swing.JLabel point2313;
    private javax.swing.JLabel point2314;
    private javax.swing.JLabel point2315;
    private javax.swing.JLabel point2316;
    private javax.swing.JLabel point2317;
    private javax.swing.JLabel point2318;
    private javax.swing.JLabel point2319;
    private javax.swing.JLabel point2320;
    private javax.swing.JLabel point2321;
    private javax.swing.JLabel point2322;
    private javax.swing.JLabel point2323;
    private javax.swing.JLabel point2324;
    private javax.swing.JLabel point2400;
    private javax.swing.JLabel point2401;
    private javax.swing.JLabel point2402;
    private javax.swing.JLabel point2403;
    private javax.swing.JLabel point2404;
    private javax.swing.JLabel point2405;
    private javax.swing.JLabel point2406;
    private javax.swing.JLabel point2407;
    private javax.swing.JLabel point2408;
    private javax.swing.JLabel point2409;
    private javax.swing.JLabel point2410;
    private javax.swing.JLabel point2411;
    private javax.swing.JLabel point2412;
    private javax.swing.JLabel point2413;
    private javax.swing.JLabel point2414;
    private javax.swing.JLabel point2415;
    private javax.swing.JLabel point2416;
    private javax.swing.JLabel point2417;
    private javax.swing.JLabel point2418;
    private javax.swing.JLabel point2419;
    private javax.swing.JLabel point2420;
    private javax.swing.JLabel point2421;
    private javax.swing.JLabel point2422;
    private javax.swing.JLabel point2423;
    private javax.swing.JLabel point2424;
    private javax.swing.JLabel point2500;
    private javax.swing.JLabel point2501;
    private javax.swing.JLabel point2502;
    private javax.swing.JLabel point2503;
    private javax.swing.JLabel point2504;
    private javax.swing.JLabel point2505;
    private javax.swing.JLabel point2506;
    private javax.swing.JLabel point2507;
    private javax.swing.JLabel point2508;
    private javax.swing.JLabel point2509;
    private javax.swing.JLabel point2510;
    private javax.swing.JLabel point2511;
    private javax.swing.JLabel point2512;
    private javax.swing.JLabel point2513;
    private javax.swing.JLabel point2514;
    private javax.swing.JLabel point2515;
    private javax.swing.JLabel point2516;
    private javax.swing.JLabel point2517;
    private javax.swing.JLabel point2518;
    private javax.swing.JLabel point2519;
    private javax.swing.JLabel point2520;
    private javax.swing.JLabel point2521;
    private javax.swing.JLabel point2522;
    private javax.swing.JLabel point2523;
    private javax.swing.JLabel point2524;
    // End of variables declaration//GEN-END:variables
}
