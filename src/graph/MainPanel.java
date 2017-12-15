package graph;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int size;
	private static double maxValue;
	
	public MainPanel(int sizePane, int maxPane){
		
		//Initialize the panel
		size = sizePane;
		maxValue = maxPane;
		setPreferredSize(new Dimension(size, size));
		setLayout(null);
		setBackground(Color.WHITE);
		
		//Declare labels to define what f, f', and f'' are
		JLabel lblFxIsBleu = new JLabel("f(x) is bleu");
		lblFxIsBleu.setForeground(Color.BLUE);
		lblFxIsBleu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFxIsBleu.setBounds(12, 13, 100, 30);
		add(lblFxIsBleu);
		
		JLabel lblFxIsRed = new JLabel("f'(x) iz ryd");
		lblFxIsRed.setForeground(Color.RED);
		lblFxIsRed.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFxIsRed.setBounds(12, 56, 100, 30);
		add(lblFxIsRed);
		
		JLabel lblFxIsGren = new JLabel("f''(x) es gren");
		lblFxIsGren.setForeground(Color.GREEN);
		lblFxIsGren.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFxIsGren.setBounds(12, 99, 100, 30);
		add(lblFxIsGren);
		}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		double x = (-maxValue), max = maxValue, ratio = size/(max*2);
		
		//Create the axes
		g2d.drawLine(size/2, 0, size/2, size);
		g2d.drawLine(0, size/2, size, size/2);
		
		//Create the ticks for dividing up both the X and Y Axes
		double[] tick = getTicks();
		int w = size/10, h = size/2, vA = 8;
		g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, size/30)); //Names the function numbers
		for(int i = 0; i < 9; i++){
			g2d.drawLine(w, h+5, w, h-5);
			if(i != 4 && vA != 4){
				if(i > 4)
					g2d.drawString(tick[i]+"", w-size/40, h+size/21);
				else
					g2d.drawString(tick[i]+"", w-size/30, h+size/21);
				if(vA > 4)
					g2d.drawString(tick[vA]+"", h-size/13, w+size/60);
				else
					g2d.drawString(tick[vA]+"", h-size/12, w+size/60);
			}
			g2d.drawLine(h+5, w, h-5, w);
			w+=size/10;
			vA--;
		}
		int xC, fxC;
		int x1 = 0, y1 = 0;
		
		//Graph of f(x)
		int radiusF = 10;
		g2d.setColor(Color.BLUE);
		for(x = -maxValue;x<=max;x+=0.001){
        	x = Math.round(x*1000)/1000.0;
        	x1 = (int)(size/2+(ratio*x));
        	y1 = (int)(size/2-(ratio*Functions.f(x)));
        	g2d.drawLine(x1,y1,x1,y1);
        	
        	//Look for holes
        	Double temp = Functions.f(x);
        	Double tempB = Functions.f(x-0.001);
        	Double tempA = Functions.f(x+0.001);
        	if(temp.isNaN() && !tempB.isNaN() && !tempA.isNaN()) {
        		xC = ((int)(size/2+(ratio*x))-(radiusF/2));
        		fxC = ((int)(size/2-(ratio*Functions.f(x-0.001)))-(radiusF/2));
        		g2d.drawArc(xC, fxC, radiusF, radiusF, 0, 360);
        	}
		}
		
		//Graph of f'(x)
		int radiusFp = 15;
		g2d.setColor(Color.RED);
		for(x = -maxValue;x<=max;x+=0.001){
        	x = Math.round(x*1000)/1000.0;
        	x1 = (int)(size/2+(ratio*x));
        	y1 = (int)(size/2-(ratio*Functions.fp(x)));
        	g2d.drawLine(x1,y1,x1,y1);
        	//Look for Crit Values
        	if(
        		(round(Functions.fp(x-0.001)) < 0 && round(Functions.fp(x+0.001)) > 0) || 
        		(round(Functions.fp(x-0.001)) > 0 && round(Functions.fp(x+0.001)) < 0)) {
        		xC = ((int)(size/2+(ratio*x))-(radiusFp/2));
        		fxC = ((int)(size/2-(ratio*Functions.f(x)))-(radiusFp/2));
        		g2d.drawArc(xC, fxC, radiusFp, radiusFp, 0, 360);
        	}
		}
		
		//Graph of f''(x)
		int radiusFpp = 20;
		g2d.setColor(Color.GREEN);
		for(x = -maxValue;x<=max;x+=0.001){
        	x = Math.round(x*1000)/1000.0;
        	x1 = (int)(size/2+(ratio*x));
        	y1 = (int)(size/2-(ratio*Functions.fpp(x)));
        	g2d.drawLine(x1,y1,x1,y1);
        	//Look for Inflection Values
        	if(
        		(round(Functions.fpp(x-0.001)) < 0 && round(Functions.fpp(x+0.001)) > 0) || 
        		(round(Functions.fpp(x-0.001)) > 0 && round(Functions.fpp(x+0.001)) < 0)) {
        		xC = ((int)(size/2+(ratio*x))-(radiusFpp/2));
        		fxC = ((int)(size/2-(ratio*Functions.f(x)))-(radiusFpp/2));
        		g2d.drawArc(xC, fxC, radiusFpp, radiusFpp, 0, 360);
        	}
		}
		
	}
	//Array to get the "ticks"
	//This is accomplished by the maxValue and divvying it up
	private static double[] getTicks(){
		double increment = maxValue / 5, currentTick = -1*(maxValue);
		double[] tick = new double[9];
		for(int i = 0; i < 9; i++){
			currentTick+=increment;
			tick[i] = Math.round(currentTick*100.0)/100.0;
		}
		return tick;
	}
	
	//Rounding function reduces margin of error in code
	//Very evident in both f'(x) and f''(x) functions, where if the function is 0, 
	//a change in signs can occur when there is none
	private static double round(double in) {
		return Math.floor(in*1000)/1000;
	}
}
