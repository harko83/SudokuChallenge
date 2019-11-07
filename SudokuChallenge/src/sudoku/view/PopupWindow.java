package sudoku.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PopupWindow {
	private JFrame frame;
	private Container container;
	private GridBagConstraints c;
	
	public PopupWindow() {
		frame = new JFrame("Comunication");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
//		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = frame.getContentPane();
		container.setBackground(Color.LIGHT_GRAY);
		container.setLayout(new GridBagLayout());

		c = new GridBagConstraints();
	}
	
	public void createPoupupWindow() {



		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("src/sudoku/images/question.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			c.weightx = 10;
			c.weighty = 10;
			c.gridx = 0;
			c.gridy = 0;
			container.add(picLabel);
		} catch (IOException e) {
			System.err.println("Couldn't open file.");
			e.printStackTrace();
		}
		
		
		
		
		JButton button;
		button = new JButton("Accepter");
		c.weightx = 2;
		c.weighty = 10;
		c.gridx = 10;
		c.gridy = 18;
		container.add(button, c);
		
		button = new JButton("Refuser");
		c.weightx = 2;
		c.weighty = 10;
		c.gridx = 22;
		c.gridy = 18;
		container.add(button, c);

		frame.pack();
		frame.revalidate();
	}
	
	public static void main(String[] args) {
		new PopupWindow().createPoupupWindow();
		
		
	}
}
