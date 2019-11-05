package sudoku.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SudokuFrame extends JFrame {

	public SudokuFrame(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JPanel createActionPane() {
		JPanel actionPane = new JPanel();
		actionPane.setLayout(new GridLayout(1, 5));
		JButton restBtn = new JButton("Restart");
		restBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton finishBtn = new JButton("Finish");
		finishBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton checkRulesBtn = new JButton("Check rules");

		checkRulesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton chekSolutionhBtn = new JButton("Check solution");

		chekSolutionhBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton getSolutionhBtn = new JButton("Get solution");

		getSolutionhBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		actionPane.add(checkRulesBtn);
		actionPane.add(chekSolutionhBtn);
		actionPane.add(getSolutionhBtn);
		actionPane.add(finishBtn);
		actionPane.add(restBtn);
		return actionPane;
	}

}
