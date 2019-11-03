package sudoku.controller;

public class Verificator {
	// Tableau pour sudoku
	private int[][] arr;
	// Nombre de grilles en tout
	private int grids;
	// Nombre de grilles sur la ligne
	private int gridsInLine;

	// Constructeur
	public Verificator(int[][] arr) {
		// Définir tableau
		this.arr = arr;
		// Définir nombre de grilles en tout
		this.grids = arr.length;
		// Définir nombre de grilles sur la ligne
		this.gridsInLine = (int) Math.sqrt((double) grids);
	}

	/*
	 * La méthode qui cherche un nombre dans la grille, horizontal et verticale
	 * lignes
	 */
	public boolean check(int horisontalLine, int verticalLine, int input) {
		
		if (checkInHorisontalLine(verticalLine, input) == false) {
			if (checkInVerticalLine(horisontalLine, input) == false) {
				return checkInGrid(horisontalLine, verticalLine, input);
			}
		}
		return true;
	}

	/*
	 * La méthode qui cherche un nombre dans une grille en fonction des paramètres
	 * spécifiés
	 */
	private boolean checkInGrid(int horisontalLine, int verticalLine, int input) {
		// Définir la grille en fonction des coordonnées spécifiées
		int grid = defineGrid(horisontalLine, verticalLine);

		// Vérifier si le numéro existe dans la grille spécifié
		for (int i = 0; i < grids; i++) {
			if (arr[grid][i] == input) {
				System.out.println("integer is in grid N-" + grid);
				return true;
			}
		}
		return false;
	}

	/*
	 * La méthode qui cherche un nombre dans une ligne verticale en fonction des
	 * paramètres spécifiés
	 */
	private boolean checkInVerticalLine(int horisontalLine, int input) {
		// Définition d'une grille traversée par la ligne verticale
		int verticalGrid = getGridInLine(horisontalLine);

		// L'emplacement de la cellule dans la grille
		int cell = 0;
		if (horisontalLine > gridsInLine) {
			cell = horisontalLine - verticalGrid * gridsInLine;
		} else {
			cell = horisontalLine;
		}

		// Mouvement sur les grilles traversées par la ligne
		for (int i = 0; i < gridsInLine; i++) {
			// Mouvement sur les cellules traversées par la ligne
			for (int j = 0; j < gridsInLine; j++) {
				// Vérification si chiffre specifié est present
				if (arr[verticalGrid][cell] == input) {
					System.out.printf("integer is in vertical line, grid - %d, cell - %d\n", verticalGrid, cell);
					return true;
				}
				// Déterminer la prochaine cellule
				cell = (cell + gridsInLine) % grids;
			}
			// Déterminer la prochaine grille
			verticalGrid = (verticalGrid + gridsInLine) % grids;
		}
		return false;
	}

	/*
	 * La méthode qui cherche un nombre dans une ligne horisontale en fonction des
	 * paramètres spécifiés
	 */
	private boolean checkInHorisontalLine(int verticalLine, int input) {
		// Définition d'une grille traversée par la ligne horisontale
		int horisontalGrid = getGridInLine(verticalLine);
		if (horisontalGrid > 0) {
			horisontalGrid *= gridsInLine;
		}

		// L'emplacement de la cellule dans la grille
		int cell = 0;
		if (verticalLine >= gridsInLine) {
			cell = (verticalLine % gridsInLine) * gridsInLine;
		} else {
			cell = verticalLine * gridsInLine;
		}

		// Stockage temporel pour cellule
		int tempCell = cell;

		// Mouvement sur les grilles traversées par la ligne
		for (int i = 0; i < gridsInLine; i++) {
			// Mouvement sur les cellules traversées par la ligne
			for (int j = 0; j < gridsInLine; j++) {
				// Vérification si chiffre specifié est present
				if (arr[horisontalGrid][cell] == input) {
					System.out.printf("integer is in horisontal line, grid - %d, cell - %d\n", horisontalGrid, cell);
					return true;
				}
				// Déterminer la prochaine cellule
				cell++;
			}
			// Déterminer la prochaine grille
			horisontalGrid++;

			cell = tempCell;
		}
		return false;
	}

	/*
	 * La méthode qui trouve la grille par les coordonnées données
	 */
	private int defineGrid(int horisontal, int vertical) {
		int x = getGridInLine(horisontal);
		int y = getGridInLine(vertical);

		System.out.printf("Grid is %d\n	Horisontal - %d\n	Vertical - %d\n", y * gridsInLine + x, x, y);

		return y * gridsInLine + x;
	}

	/*
	 * La méthode qui trouve la grille sur la ligne défini
	 */
	private int getGridInLine(int line) {
		if (line >= gridsInLine) {
			line -= gridsInLine;
			return 1 + getGridInLine(line);
		}
		return 0;
	}
}
