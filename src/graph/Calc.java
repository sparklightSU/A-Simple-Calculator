package graph;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import javax.*;

public class Calc extends JPanel{
	
	
	private JFrame frame;
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("Calculator Panel");
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFxIsBleu = new JLabel("f(x) is bleu");
		lblFxIsBleu.setForeground(Color.BLUE);
		lblFxIsBleu.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFxIsBleu.setBounds(12, 13, 100, 30);
		frame.getContentPane().add(lblFxIsBleu);
		
		JLabel lblFxIsRed = new JLabel("f'(x) is red");
		lblFxIsRed.setForeground(Color.RED);
		lblFxIsRed.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFxIsRed.setBounds(12, 56, 100, 30);
		frame.getContentPane().add(lblFxIsRed);
		
		JLabel lblFxIsGren = new JLabel("f''(x) is gren");
		lblFxIsGren.setForeground(Color.GREEN);
		lblFxIsGren.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFxIsGren.setBounds(12, 99, 100, 30);
		frame.getContentPane().add(lblFxIsGren);
	}
	
	public void paintComponent(Graphics g) {
		g.drawLine(200, 200, 400, 200);
	}
}
