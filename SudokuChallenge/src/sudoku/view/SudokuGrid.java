package sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SudokuGrid {
	private JTextField[][] grid;
	private int dimension;
	private JTextField cellChosen = new JTextField();

	public SudokuGrid(int dimension) {
		this.grid = new JTextField[dimension][dimension];
		this.dimension = dimension;

		Font font = new Font("Verdana", Font.PLAIN, 50);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Dimension fieldDimension = new Dimension(60, 60);

		for (int i = 0; i < this.dimension; ++i) {
			for (int j = 0; j < this.dimension; ++j) {
				JTextField field = new JTextField();
				field.setFont(font);
				field.setHorizontalAlignment(JTextField.CENTER);
				field.setBorder(border);
				field.setPreferredSize(fieldDimension);
				field.setEditable(false);
//				if (i % 2 == 0) {
//					field.setBackground(Color.LIGHT_GRAY);
//				}

				field.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						setCellChosen(field);
//						field.setBackground(Color.MAGENTA);
//						field.setText(numChosen);
//						numChosen = null;

					}

				});

				grid[i][j] = field;
			}
		}

	}

	public JTextField[][] getGrid() {
		return grid;
	}

	public JTextField getCellChosen() {
		return cellChosen;
	}

	public void setCellChosen(JTextField cellChosen) {
		this.cellChosen = cellChosen;
	}

}
