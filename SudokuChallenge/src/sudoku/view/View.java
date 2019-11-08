package sudoku.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import sudoku.controller.Controller;

public class View {

	public View(Controller controller) {
		SudokuFrame frame = new SudokuFrame("Jeu du sudoku", 900, 900);

		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout(2, 2));
		container.setBackground(Color.LIGHT_GRAY);
		frame.getRootPane().setBorder(new LineBorder(Color.BLACK, 3));


//		JPanel topPanel = new JPanel();
//		topPanel.setBorder(new LineBorder(Color.BLACK, 3));
//		topPanel.setBackground(Color.ORANGE);
//		topPanel.setLayout(new FlowLayout());
//		container.add(topPanel, BorderLayout.NORTH);

//		JPanel centerPanel = new JPanel();
//		centerPanel.setBorder(new LineBorder(Color.BLACK, 3));
//		centerPanel.setBackground(Color.ORANGE);
//		centerPanel.setLayout(new FlowLayout());
//		container.add(centerPanel, BorderLayout.CENTER);
		SudokuGrid sudokuGrid = new SudokuGrid(9);
		sudokuGrid.setGrid(controller.getMatrice());
		container.add(sudokuGrid);

		SudokuMenu menu = new SudokuMenu();
		frame.setJMenuBar(menu.createMenu(sudokuGrid, controller));

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new LineBorder(Color.BLACK, 3));
		bottomPanel.setBackground(Color.ORANGE);
		bottomPanel.setLayout(new GridLayout(2, 1));
		bottomPanel.add(frame.createActionPane(sudokuGrid, controller));

		SudokuNumberButton button = new SudokuNumberButton();
		button.createNumberButtons(sudokuGrid, 9);
		List<JButton> numButtons = button.getNumButtons();
		JPanel numberPanel = new JPanel();
		for (int i = 0; i < 9; i++) {
			numberPanel.add(numButtons.get(i));
		}

		bottomPanel.add(numberPanel);
		container.add(bottomPanel, BorderLayout.SOUTH);

//		JPanel gridPanel = new JPanel();
//		gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
//		gridPanel.setBackground(Color.BLACK);
//		gridPanel.setLayout(new GridLayout(3, 3, 3, 3));
//

//		JTextField[][] grid = sudokuGrid.getGrid();
//		for (int i = 0; i < 9; i++) {
//			JPanel miniGridPanel = new JPanel();
//			miniGridPanel.setLayout(new GridLayout(3, 3));
//
//			for (int j = 0; j < 9; j++) {
//				miniGridPanel.add(grid[i][j]);
//			}
//			gridPanel.add(miniGridPanel);
//		}

		frame.revalidate();
	}

//	SudokuFrameJtextfield sudokuFrameJtextfield = new SudokuFrameJtextfield();
}
