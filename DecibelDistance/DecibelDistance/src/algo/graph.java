/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import java.awt.*;
import java.text.*;
import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.time.*;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

/**
 *
 * @author Nipuna
 */
public class graph extends ApplicationFrame {

    public static void main(String args[]) {
        double distances_and_RSSI[][] = {{0.3, 55}, {0.4, 59}, {0.5, 60}, {0.6, 62}, {0.7, 66}, {0.8, 68}, {0.9, 69}, {1, 71}, {2, 74}, {3, 79}, {4, 81}, {5, 83}, {6, 84}, {7, 85}, {8, 86}, {9, 87}, {10, 88}};
        double lower_and_upper_ranges[][] = {{51, 58}, {54, 63}, {55, 65}, {57, 76}, {61, 69}, {63, 73}, {67, 72}, {67, 75}, {70, 80}, {73, 87}, {75, 88}, {77, 90}, {78, 89}, {78, 89}, {79, 92}, {81, 92}, {82, 93}};
        graph chart = new graph("Chart");
        chart.pack();
        chart.setVisible(true);
    }

    public graph(String title) {
        super(title);
        double data[][] = {{0.3, 55}, {0.4, 59}, {0.5, 60}, {0.6, 62}, {0.7, 66}, {0.8, 68}, {0.9, 69}, {1, 71}, {2, 74}, {3, 79}, {4, 81}, {5, 83}, {6, 84}, {7, 85}, {8, 86}, {9, 87}, {10, 88}};
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries(1, data);
        JFreeChart chart = ChartFactory.createXYLineChart(title, title, title, dataset);
        /*
        TimeSeries s1 = new TimeSeries("Power", Day.class);
        s1.add(new Day(15, 12, 2009), 150);
        s1.add(new Day(16, 12, 2009), 200);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        dataset.setDomainIsPointsInTime(true);*/
        /*
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Decibel Graph",
                "distance",
                "decibel",
                dataset,
                true,
                true,
                false
        );*/
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        setContentPane(chartPanel);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));
    }
}
