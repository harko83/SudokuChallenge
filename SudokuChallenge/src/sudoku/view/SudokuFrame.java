package sudoku.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SudokuFrame extends JFrame{
	
	public SudokuFrame(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}
