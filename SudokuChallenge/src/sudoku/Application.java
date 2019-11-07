package sudoku;

import sudoku.controller.Controller;
import sudoku.view.View;

public class Application {	
	
	public static void main(String[] args) {

		Controller controller = new Controller(3, 3, 0);
		
		new View(controller);
	}
}
