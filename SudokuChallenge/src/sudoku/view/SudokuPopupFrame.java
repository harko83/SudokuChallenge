package sudoku.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SudokuPopupFrame {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame("Popup dialog");
				
				frame.setSize(400, 200);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
