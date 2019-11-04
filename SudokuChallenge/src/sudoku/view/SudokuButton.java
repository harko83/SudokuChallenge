package sudoku.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class SudokuButton {
	private List<JButton> numButtons = new ArrayList<JButton>();

	public void createNumberButtons(SudokuGrid sudokuGrid, int dimension) {

		Dimension numButtonDimension = new Dimension(60, 30);

		for (int i = 0; i < dimension; i++) {
			JButton button = new JButton(String.valueOf(i + 1));
			button.setPreferredSize(numButtonDimension);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int numBtn = numButtons.indexOf((JButton) e.getSource());
					sudokuGrid.getCellChosen().setText(String.valueOf(numBtn + 1));
					int input = Integer.parseInt(sudokuGrid.getCellChosen().getText());

//					Verificator verificator = new Verificator(sudokuGrid.getArr());
//					verificator.check(horisontalLine, verticalLine, input);

				}
			});
			numButtons.add(button);
		}
	}

	public void createActionButtons() {

	}

	public List<JButton> getNumButtons() {
		return numButtons;
	}
}
