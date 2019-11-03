package sudoku.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class SudokuMenu {
	public JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu  menu = new JMenu("Menu");
		
		JMenu newGame = new JMenu("New Game");
		menu.add(newGame);
		
		newGame.add(new JMenuItem("Level 1"));
		newGame.add(new JMenuItem("Level 2"));
		newGame.add(new JMenuItem("Level 3"));
		newGame.add(new JMenuItem("Level 4"));
		newGame.add(new JMenuItem("Level 5"));

		menu.add(new JMenuItem("Restart"));
		menu.add(new JMenuItem("Score"));
		menu.addSeparator();
		
		
		JMenuItem exit = menu.add(new JMenuItem("Exit"));
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		
		JMenu help = new JMenu("Help");
		
		menuBar.add(menu);
		menuBar.add(help);
		
		return menuBar;
	}
}
