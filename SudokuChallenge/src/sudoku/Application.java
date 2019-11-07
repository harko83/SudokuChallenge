package sudoku;

import sudoku.controller.Controller;

public class Application {	
	public static void main(String[] args) {

		Controller controller = new Controller(3, 3, 0);
		
		new View(controller);
	}
}
