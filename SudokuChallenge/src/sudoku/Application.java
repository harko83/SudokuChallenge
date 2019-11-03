package sudoku;

import sudoku.controller.Verificator;
import sudoku.view.View;

public class Application {

	public static void main(String[] args) {
		
		int[][] arr = { 
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0} 
		};

		Verificator verificator =new Verificator(arr);
		System.out.println(verificator.check(0, 0, 5));
		
		new View();
	}

}
