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
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class CartesianPlane extends JPanel {

	final double spacing = 50;

	public CartesianPlane() {


		setBackground(Color.WHITE);
	}

	private void lines(Graphics2D g2, double x1, double y1, double x2, double y2) {

		g2.draw(new Line2D.Double(x1, y1, x2, y2));
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);

		final double width = getWidth();
		final double height = getHeight();

		final double xaxis = width / 2.0;
		final double yaxis = height / 2.0;
		final double x1 = 0;
		final double y1 = 0;
		final double x2 = width;
		final double y2 = height;

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1));

		for (double x = spacing; x < width; x += spacing) {

			lines(g2, xaxis + x, y1, xaxis + x, y2);
			lines(g2, xaxis - x, y1, xaxis - x, y2);
		}

		for (double y = spacing; y < height; y += spacing) {

			lines(g2, x1, yaxis + y, x2, yaxis + y);
			lines(g2, x1, yaxis - y, x2, yaxis - y);
		}

		g.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));

		g2.draw(new Line2D.Double(x1, yaxis, x2, yaxis));
		g2.draw(new Line2D.Double(xaxis, y1, xaxis, y2));

	}

	public static void main(String args[]) {
                
		JFrame window = new JFrame("Cartesian Plane");
		window.add(new CartesianPlane());
		window.setSize(400, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}