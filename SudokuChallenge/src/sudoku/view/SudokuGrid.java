package sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SudokuGrid {
	private JTextField[][] grid;
	private Point point = new Point();
	private int[][] arr;
	private int dimension;
	private JTextField cellChosen = new JTextField();

	public SudokuGrid(int dimension) {
		this.grid = new JTextField[dimension][dimension];
		this.setArr(new int[dimension][dimension]);
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
				field.setBackground(Color.WHITE);
				field.setEditable(false);
//				if (i % 2 == 0) {
//					field.setBackground(Color.LIGHT_GRAY);
//				}
				grid[i][j] = field;

				field.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setCellChosen(field);
//						System.out.println(i * j);
						for (int k = 0; k < dimension; k++) {
							for (int l = 0; l < dimension; l++) {
								if (e.getSource() == grid[k][l]) {
									point.setLocation(k, l);
									System.out.println(k + "   " + l);

								}
							}
						}

					}
				});
			}
		}
	}

	public JTextField[][] getGrid() {
		return grid;
	}

	public JTextField getCellChosen() {
		return cellChosen;
	}

	public void setCellChosen(JTextField field) {
		if (cellChosen != null) {
			cellChosen.setBackground(Color.WHITE);
		}
		field.setBackground(Color.MAGENTA);
		this.cellChosen = field;
	}

	public int[][] getArr() {
		return arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}

}
