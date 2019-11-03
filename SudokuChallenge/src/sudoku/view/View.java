package sudoku.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class View {
	
	public View() {
		SudokuFrame frame = new SudokuFrame("Jeu du sudoku", 900, 900);
		
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout(2, 2));
		container.setBackground(Color.LIGHT_GRAY);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
		
		SudokuMenu menu = new SudokuMenu();
		frame.setJMenuBar(menu.createMenu());
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK, 3));
		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout());
		container.add(topPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new LineBorder(Color.BLACK, 3));
		centerPanel.setBackground(Color.ORANGE);
		centerPanel.setLayout(new FlowLayout());
		container.add(centerPanel, BorderLayout.CENTER);
		
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new LineBorder(Color.BLACK, 3));
		bottomPanel.setBackground(Color.ORANGE);
		bottomPanel.setLayout(new FlowLayout());
		container.add(bottomPanel, BorderLayout.SOUTH);

		SudokuButton button = new SudokuButton(bottomPanel);
		
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
		gridPanel.setBackground(Color.BLACK);
		gridPanel.setLayout(new GridLayout(3, 3, 3, 3));
		centerPanel.add(gridPanel);
		
		SudokuGrid sudokuGrid = new SudokuGrid(9);		
		JTextField[][] grid = sudokuGrid.getGrid();
		for (int i = 0; i < 9; i++) {
			JPanel miniGridPanel = new JPanel();
			miniGridPanel.setLayout(new GridLayout(3, 3));
			
			for (int j = 0; j < 9; j++) {
				miniGridPanel.add(grid[i][j]);
			}
			gridPanel.add(miniGridPanel);
		}
		
		frame.revalidate();
	}
	
	
	
//	SudokuFrameJtextfield sudokuFrameJtextfield = new SudokuFrameJtextfield();
}
