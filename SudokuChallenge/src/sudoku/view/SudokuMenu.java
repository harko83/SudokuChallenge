package sudoku.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import sudoku.controller.Controller;

public class SudokuMenu {

	public JMenuBar createMenu(SudokuGrid sudokuGrid, Controller controller) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu newGame = new JMenu("New Game");

		menu.add(newGame);

		// Choix du niveaux
		JMenuItem easy = newGame.add(new JMenuItem("Easy"));
		easy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.generate(3, 3, 1);
				sudokuGrid.setGrid(controller.getMatrice());
			}
		});
		JMenuItem medium = newGame.add(new JMenuItem("Medium"));
		medium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.generate(3, 3, 2);
				sudokuGrid.setGrid(controller.getMatrice());
			}
		});
		JMenuItem hard = newGame.add(new JMenuItem("Hard"));
		hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.generate(3, 3, 3);
				sudokuGrid.setGrid(controller.getMatrice());
			}
		});
		JMenuItem expert = newGame.add(new JMenuItem("Expert"));
		expert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.generate(3, 3, 4);
				sudokuGrid.setGrid(controller.getMatrice());
			}
		});
		JMenuItem master = newGame.add(new JMenuItem("Master"));
		master.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.generate(3, 3, 5);
				sudokuGrid.setGrid(controller.getMatrice());
			}
		});

		JMenuItem restart = menu.add(new JMenuItem("Restart"));
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sudokuGrid.setGrid(controller.getMatrice());

			}
		});

		menu.addSeparator();

		// Quitter le jeux
		JMenuItem exit = menu.add(new JMenuItem("Exit"));
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

		menuBar.add(menu);

		return menuBar;
	}

}
