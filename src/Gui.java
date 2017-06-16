import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {
	private static JFrame frame;
	private static JButton movie;
	private static JButton customer;
	private static JButton removeMovie;
	private static JButton updateMovie;
	private static JPanel movieP;

	
	
	private static void initialize(){
		Font font = new Font(Font.DIALOG, Font.BOLD, 30);
		
		frame = new JFrame();
		frame.setTitle("VSMS System");
		frame.setBounds(100, 100, 1300, 900);
		frame.getContentPane().setBackground(Color.orange);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		movie = new JButton("電影");
		movie.setFont(font);
		movie.setBounds(0, 0, 300, 215);
		movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movieP = new JPanel();
				movieP.setBackground(Color.YELLOW);
				movieP.setBounds(300, 0, 900, 800);
				frame.add(movieP);
				movieP.updateUI();
			}
		});
		frame.add(movie);
		
		customer = new JButton("會員");
		customer.setFont(font);
		customer.setBounds(0,215,300,215);
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movieP = new JPanel();
				movieP.setBackground(Color.BLUE);
				movieP.setBounds(300, 0, 900, 800);
				frame.add(movieP);
				movieP.updateUI();
			}
		});
		frame.add(customer);
		
		updateMovie = new JButton("更新電影");
		updateMovie.setFont(font);
		updateMovie.setBounds(0,430,300,215);
		updateMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame.add(updateMovie);
		
		removeMovie = new JButton("刪除電影");
		removeMovie.setFont(font);
		removeMovie.setBounds(0,645,300,215);
		removeMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame.add(removeMovie);
		
		frame.setVisible(true);
	}
	
	public static void main(String[]args){
		initialize();
	}
}
