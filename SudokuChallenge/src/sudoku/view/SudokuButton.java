package sudoku.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SudokuButton {
	public SudokuButton(JPanel jPanel) {
		
		Dimension numButtonDimension = new Dimension(60, 30);
		
		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton("" + i);
			button.setPreferredSize(numButtonDimension);
			jPanel.add(button);
		}
//		JButton b1 = new JButton("1");
//		JButton b2 = new JButton("2");
//		JButton b3 = new JButton("3");
//		JButton b4 = new JButton("4");
//		JButton b5 = new JButton("5");
//		JButton b6 = new JButton("6");
//		JButton b7 = new JButton("7");
//		JButton b8 = new JButton("8");
//		JButton b9 = new JButton("9");
	}
}
