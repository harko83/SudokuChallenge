package sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SudokuGrid {
	private JTextField[][] grid;

	private int dimension;
	
	public SudokuGrid(int dimension) {
		this.grid = new JTextField[dimension][dimension];
		this.dimension = dimension;
		
		Font font = new Font("Verdana", Font.PLAIN , 50);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Dimension fieldDimension = new Dimension(60, 60);

		for (int i = 0; i < this.dimension; ++i) {
			for (int j = 0; j < this.dimension; ++j) {
				JTextField field = new JTextField();
				field.setFont(font);
				field.setHorizontalAlignment(JTextField.CENTER);
				field.setBorder(border);
				field.setPreferredSize(fieldDimension);
//				field.setEditable(false);
				if (i % 2 == 0) {
					field.setBackground(Color.LIGHT_GRAY);					
				}
				grid[i][j] = field;
			}
		}
		
	}
	
	public JTextField[][] getGrid() {
		return grid;
	}

}
