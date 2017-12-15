package graph;

import java.awt.*;
import java.util.Scanner;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args){
		System.out.println("Clavicle \n" 
							+ "ver. 4.2.0 \n"
							+ "Everyone worked on this project equally \n"
							+ "Not one person did the project by him/herself alone \n"
							+ "This code was definitely not stolen online \n"
							+ "by Aneesh Iyer and Max Ho \n");
		JFrame frame = new JFrame("Clavicle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//just in case some tweaking of graph is needed
		int panelSize = 500;
		int xMaxValue = 5;
		MainPanel mainPanel = new MainPanel(panelSize,xMaxValue);
		frame.add(mainPanel);

		frame.pack();
		frame.setVisible(true);
		
		//initialize(frame, panel);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		System.out.println("If a graph of a function is not showing, it is because there is a function overlap \n");
		
		//Integration test
		System.out.println("Integrate? Y/N");
		Scanner sc = new Scanner(System.in);
		String yesOrNo = sc.next();
		if (yesOrNo.toLowerCase().equals("y")) {
			System.out.print("From: ");
			double a = sc.nextDouble();
			System.out.print("To: ");
			double b = sc.nextDouble();
			System.out.print("Integral from " + a + " to " + b + ": ");
			System.out.println(Functions.integral(a, b));
			System.out.print("Using the Fundamental Theorem of Calculus: "); // This is different from above, uses FTC (0,a)
			//and (0,b) instead from direct (a,b)
			System.out.println(Functions.FTC(a, b));
			System.out.println("Disclaimer: integral function isn't exactly the most accurate. Numbers may be off.");
		}
		else System.out.println(
				yesOrNo.toLowerCase().equals("n")?
				"Understandable have a nice day":
				"I'll take that as a no."
				);
		sc.close();
	}
	
	public static double function(double x) {
		return Math.sqrt(x)/x;
		/* FUNCTIONS:
		 * ln(x): Math.log(x)
		 * log(x): Math.log10(x)
		 * log_a(x): logBase(x,a)
		 * ***PS: the log_a(x) function was coded by me using that definiton of a log
		 * sin(x): Math.sin(x)
		 * cos(x): Math.cos(x)
		 * tan(x): Math.tan(x)
		 * x^a: Math.pow(x,a)
		 * e: Math.E
		 * pi: Math.PI
		 * infinity: no
		 * i: don't do this to me please
		 */
	}
	
	
	//just in case if this is needed
	public static double logBase(double x, double a) {
		return Math.log(x)/Math.log(a);
	}
}