package sudoku;

import sudoku.controller.Controller;

public class Application {

	public static void main(String[] args) {

//		int[][] arr = new int[9][9];
		/*
		 * { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0,
		 * 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0
		 * }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0,
		 * 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		 */

		Controller controller = new Controller(3, 3, 5);

//		new View(controller.getMatrice());
	}

}
