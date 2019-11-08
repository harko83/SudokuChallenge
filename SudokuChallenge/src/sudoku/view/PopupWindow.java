package sudoku.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PopupWindow {
	private JButton button;
	private Container container;
	private GridBagConstraints c;
	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	
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
		
		addImg();
		addInfo();
		addInput();
		addButtons();
		frame.pack();
		frame.revalidate();
	}
	
	public void createPoupupWindow() {
//		BufferedImage myPicture;
//		try {
//			myPicture = ImageIO.read(new File("src/sudoku/images/question.jpg"));
//			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//			c.weightx = 0;
//			c.weighty = 0;
//			c.gridx = 0;
//			c.gridy = 0;
//			container.add(picLabel);
//		} catch (IOException e) {
//			System.err.println("Couldn't open file.");
//			e.printStackTrace();
//		}
	}
	
	private void addImg() {
		label = new JLabel("Image");
		label.setBorder(new LineBorder(Color.BLACK, 1));
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 6;
		c.gridwidth = 6;
		c.fill = GridBagConstraints.BOTH;

		container.add(label, c);		
	}
	
	private void addInfo() {
		label = new JLabel("Jeu du Sudoku");
		label.setBorder(new LineBorder(Color.BLACK, 1));
		c.gridx = 8;
		c.gridy = 1;
//		c.weightx = 16;
//		c.weighty = 3;
		c.gridheight = 1;
		c.gridwidth = 10;
//		c.fill = GridBagConstraints.HORIZONTAL;
		container.add(label, c);
		
		label = new JLabel("Version");
		label.setBorder(new LineBorder(Color.BLACK, 1));
		c.gridx = 10;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 6;
//		c.fill = GridBagConstraints.HORIZONTAL;
		container.add(label, c);
	}
	
	private void addInput() {
		label = new JLabel("Entrez une chiffre desiré ");
		label.setBorder(new LineBorder(Color.BLACK, 1));
		c.gridx = 3;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = 10;
//		c.fill = GridBagConstraints.BOTH;
		container.add(label, c);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK, 1));
		c.gridx = 14;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = 3;
//		c.fill = GridBagConstraints.BOTH;
		container.add(textField, c);
	}
	
	private void addButtons() {
		button = new JButton("Accepter");
		c.gridx = 8;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 3;
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.weightx = 10;
//		c.weighty = 18;
		container.add(button, c);
		
		button = new JButton("Refuser");
		c.gridx = 12;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 3;
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.weightx = 22;
//		c.weighty = 18;
		container.add(button, c);
	}
	
	public static void main(String[] args) {
		new PopupWindow();
	}
}
