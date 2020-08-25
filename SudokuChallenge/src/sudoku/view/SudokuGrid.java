package sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SudokuGrid extends JPanel {
	private JTextField[][] grid;

	public void displayResult(int[][] testBool/* , int[][] matriceSoluce */) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (testBool[i][j] == 0) {
					grid[i][j].setForeground(Color.RED);
				}
//				grid[i][j].setText(String.valueOf(matriceSoluce[i][j]));
			}
		}
	}

	public void displaySoluce(int[][] matriceSoluce) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				grid[i][j].setText(String.valueOf(matriceSoluce[i][j]));
			}
		}
	}

	public int[][] getIntGrid() {
		int[][] intGrid = new int[dimension][dimension];
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
//				grid[x][y] = new JTextField();
				String cellFilled = grid[x][y].getText();
				if (!cellFilled.equalsIgnoreCase(" ")) {
					intGrid[x][y] = Integer.parseInt(cellFilled);
				} else
					intGrid[x][y] = 0;

			}

		}
		return intGrid;
	}

	public JTextField[][] getGrid() {
		return grid;
	}

	// private JPanel[][] minigrids;
//	private Point point = new Point();
//	private int[][] arr;
	private int dimension;
	private int miniGridDimension;
	private JTextField cellChosen = new JTextField();
	private boolean[][] indices;
	private boolean indice;

	public SudokuGrid(int dimension) {
		this.dimension = dimension;
		miniGridDimension = (int) (Math.sqrt((double) dimension));
		this.setLayout(new GridLayout(miniGridDimension, miniGridDimension));
		this.addGrid(dimension);
//		this.grid = new JTextField[dimension][dimension];
//		this.setArr(new int[dimension][dimension]);
//		this.dimension = dimension;
//		this.minigrids = new JPanel[dimension / 3][dimension / 3];

	}

	public void addGrid(int dimension) {
		JPanel[][] minigrids = new JPanel[miniGridDimension][miniGridDimension];
		for (int i = 0; i < miniGridDimension; i++) {
			for (int j = 0; j < miniGridDimension; j++) {
				minigrids[i][j] = new JPanel();
				minigrids[i][j].setLayout((new GridLayout(miniGridDimension, miniGridDimension)));
				minigrids[i][j].setBorder(new LineBorder(Color.BLACK, 2));
				this.add(minigrids[i][j]);
			}
		}
		this.grid = new JTextField[dimension][dimension];
		Font font = new Font("Verdana", Font.PLAIN, 50);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Dimension fieldDimension = new Dimension(60, 60);
		for (int x = 0; x < dimension; ++x) {
			for (int y = 0; y < dimension; ++y) {
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
				grid[x][y] = field;
				minigrids[x / miniGridDimension][y / miniGridDimension].add(field);
				field.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						cellChosen.setBackground(Color.WHITE);
						setCellChosen(field);
//						cellChosen = field;
//						cellChoosen = cellFiedls.indexOf(e.getSource());

						for (int k = 0; k < dimension; k++) {
							for (int l = 0; l < dimension; l++) {
								if (e.getSource() == grid[k][l]) {
									indice = indices[k][l];
//									point.setLocation(k, l);
//									if (!grid[(int) point.getX()][(int) point.getY()].getText().equalsIgnoreCase(" ")) {
									if (indice) {
										cellChosen.setBackground(Color.WHITE);
									} else {

										cellChosen.setBackground(Color.MAGENTA);
										new Flybox();
									} /*
										 * else { // indice = false; // }
										 */
									System.out.println(k + "   " + l);

								}
							}
						}

					}

				});

			}
		}
	}

//	public JTextField[][] getGrid() {
//		return grid;
//	}

	public void setGrid(int[][] gridRowColumn) {
		indices = new boolean[dimension][dimension];
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
//				grid[x][y] = new JTextField();
				int input = gridRowColumn[x][y];
				if (input == 0) {
					this.grid[x][y].setText(" ");
					this.grid[x][y].setForeground(Color.GRAY);

					indices[x][y] = false;
				} else {
					this.grid[x][y].setForeground(Color.BLACK);
					this.grid[x][y].setText(String.valueOf(input));
					indices[x][y] = true;
				}
			}

		}
	}

	public JTextField getCellChosen() {
		return cellChosen;
	}

	public boolean isIndice() {
		// TODO Auto-generated method stub
		return indice;
	}

	public void setCellChosen(JTextField field) {

		if (cellChosen != null) {
			cellChosen.setBackground(Color.WHITE);
		}
//		if (indice != true) {
		this.cellChosen = field;
//		}
	}

}
