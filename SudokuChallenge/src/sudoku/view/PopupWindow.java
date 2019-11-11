package sudoku.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PopupWindow {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Comunication");
//		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = frame.getContentPane();
		container.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		Font font = new Font("Verdana", Font.PLAIN, 10);
		
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("src/sudoku/images/question.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setBorder(new LineBorder(Color.BLACK, 1));
			c.gridx = 0;
			c.gridy = 0;
			c.gridheight = 6;
			c.gridwidth = 6;
			c.weightx = 1;
			c.weighty = 1;
//			c.anchor = GridBagConstraints.NORTHWEST;
//			c.fill = GridBagConstraints.BOTH;
			container.add(picLabel, c);
		} catch (IOException e) {
			System.err.println("Couldn't open file.");
			e.printStackTrace();
		}
		
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);
		separator.setPreferredSize(new Dimension(1,1));
		c.gridx = 6;
		c.gridy = 0;
		c.gridheight = 6;
		c.gridwidth = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.VERTICAL;
		container.add(separator, c);

		JLabel label = new JLabel("Jeu du Sudoku");
		label.setBorder(new LineBorder(Color.BLACK, 1));
		c.gridx = 7;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 10;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.NONE;
		label.setFont(font);
		container.add(label, c);

		label = new JLabel("Version");
		label.setBorder(new LineBorder(Color.BLACK, 1));
		label.setFont(font);
		c.gridx = 7;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 10;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.NONE;
		container.add(label, c);
		
		separator = new JSeparator(JSeparator.HORIZONTAL);
		separator.setPreferredSize(new Dimension(1,1));
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 17;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		container.add(separator, c);

		label = new JLabel("Entrez une chiffre desiré ");
		label.setBorder(new LineBorder(Color.BLACK, 1));
		label.setFont(font);
		c.gridx = 2;
		c.gridy = 7;
		c.gridheight = 2;
		c.gridwidth = 10;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.NONE;
		container.add(label, c);

		JTextField textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK, 1));
		c.gridx = 13;
		c.gridy = 7;
		c.gridheight = 2;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.NONE;
		container.add(textField, c);

		JButton button = new JButton("Accepter");
		c.gridx = 8;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 3;
		container.add(button, c);
		
		button = new JButton("Refuser");
		c.gridx = 12;
		c.gridy = 11;
		c.gridheight = 1;
		c.gridwidth = 3;
		container.add(button, c);
		
		frame.pack();
		frame.revalidate();
	}
}
