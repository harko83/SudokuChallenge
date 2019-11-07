package sudoku.controller;

import java.util.Arrays;
//test
public class Controller {
	private int matriceSoluce[][]; //matrice résolu
	private int matrice[][]; // matrice joueur
	
	
	private int matriceBlock[][];
	private int matriceVerite[][]; //matrice vrai-faux
	private int matriceJoueurReco[][]; // matrice recommencer la partie

	/// // /> Début déclaration variables d'instances </

	private int nbColon; // Nombre de collones /> Nombre de blocks orizontales
	private int nbLign; // Nombre de lignes /> Nombre de blocks verticaux

	private int dimMatriceX; // Nombre de cellules orizontales
	private int dimMatriceY; // Nombre de cellules verticales

	private int nbCasesMatrice; // Nombre de case de la matrice

	private int nbBlockX; // Nombre de blocks horizontaux
	private int nbBlockY; // Nombre de blocks verticaux
	private int nbBlocktotal; // Nombre de blocks totaux

	private int nbChiffreBlock; // Nombre de chiffres par block

	//private int nivDifficulte; // Niveau difficulté de la partie

	private int nbCaseVisible; // Nombre de cases présenté au début de la partie

	//// /// // /> Refflechir pour déclaration matrice globale, et matrice à trouver

	/// // /> Fin déclaration variables d'instances </

	/// // /> Début déclaration constructeurs </
	
	// Constructeur surchargé à utiliser par la vue
	public Controller(int nbColon, int nbLign, int nivDifficulte) {

		this.nbColon = nbColon;
		this.nbLign = nbLign;
		//this.nivDifficulte = nivDifficulte;
		initiVariablesInstance();
		this.matrice = new int[dimMatriceX][dimMatriceY];

		if (nivDifficulte != 0) {			
			generate(nbColon, nbLign, nivDifficulte);			
		}
	}
	
	public void generate (int nbColon, int nbLign, int nivDifficulte) {
		masterGenerationGrille();
		selectDiffculty(nivDifficulte);
		matriceTestBool(matrice, matriceSoluce);
	}
	
	/// // /> Fin déclaration constructeurs </

	/**
	 * Méthode initiVariablesInstance()
	 * 
	 * Objectif : Initialisation des variables d'instances
	 */
	private void initiVariablesInstance() {

		this.dimMatriceX = this.nbColon * this.nbColon; // Calcul de nombre de cellules horizontales
		this.dimMatriceY = this.nbLign * this.nbLign; // Calcul de nombre de cellules verticales

		this.nbCasesMatrice = this.dimMatriceX * this.dimMatriceY; // Calcul de nombre de cases dans la matrice

		this.nbBlockX = this.nbColon; // Calcul du nombre de blocks horisontaux dans la matrice
		this.nbBlockY = this.nbLign; // Calcul du nombre de blocks verticaux dans la matrice
		this.nbBlocktotal = this.nbBlockX * this.nbBlockY; // Calcul du nombre de blocks dans la matrice

		this.nbChiffreBlock = this.nbColon * this.nbLign; // Calcul du nombre de chiffres par block
		
		this.matriceVerite = new int [dimMatriceX][dimMatriceY];

	}

	/**
	 * Fonction : generationGrille() Objectif : Construire un tableau de la taille
	 * de la matrice
	 * 
	 * @return Tableau vide de la taille de la matrice
	 */
	private int[][] generationGrille() {
		// Créer un tableau de la dimention de la matrice
		int matrice[][] = new int[this.dimMatriceX][this.dimMatriceY]; 

		return matrice;
	}

	/**
	 * Fonction : generationGrilleZero() Objectif : Construire un tableau de la
	 * taille de la matrice et l'initialiser à zéro
	 * 
	 * @return Tableau initialisé à zéro de la taille de la matrice
	 */
	public int[][] genrerationGrilleZero() {

		int matriceZero[][] = generationGrille(); // Créer un tableau de la dimention de la matrice

		for (int i = 0; i < this.dimMatriceX; i++) {

			for (int j = 0; j < this.dimMatriceY; j++) {

				matriceZero[i][j] = 0;
			}
		}
		return matriceZero; // Retourne la matrice initialisée à zéro
	}

	/**
	 * Fonction : geneTabCorrespondanceBlockMatrice() Objectif : Etablie une
	 * correspondance entre les blocks et la matrice
	 * 
	 * @return tableau à deux dimensions La première dimension corresponds au nombre
	 *         de block La deuxième dimension corresponds au coordonnées de début et
	 *         de fin du block dans la matrice : [1]-> x de début; [2]-> y de début;
	 *         [3]-> x de fin; [4]-> y de fin.
	 */
	private int[][] geneTabCorrespondanceBlockMatrice() {

//			/**
//			 * Création d'un tableau à deux dimensions :
//			 * La première dimension corresponds au nombre de block
//			 * La deuxième dimension corresponds au coordonnées de début et de fin du block dans la matrice : 
//			 * [1]-> x de début; [2]-> y de début; [3]-> x de fin; [4]-> y de fin.
//			 */
		int matriceBlock[][] = new int[this.nbBlocktotal][4];

		int intervalColon = this.nbColon; // Pour test
		int intervalLign = this.nbLign; // Pour test

		int k = 0; // Compteur pour indice de tableau

		for (int j = 0; j < this.nbBlockY; j++) {

			for (int i = 0; i < this.nbBlockX; i++) {

				matriceBlock[k][0] = i * intervalColon; // X Debut
				matriceBlock[k][1] = j * intervalLign; // Y Debut
				matriceBlock[k][2] = i * intervalColon + intervalColon - 1; // X Fin
				matriceBlock[k][3] = j * intervalLign + intervalLign - 1; // Y Fin

				k++;
			}
		}
		return matriceBlock;
	}

	private boolean genererMatriceAleatoire(int matrice[][], int matriceBlock[][]) {

		int chriffre = 0;

		for (int i = 0; i < this.nbChiffreBlock; i++) {
			chriffre++; // Chiffre à remplir dans les cases Block -> ensuite à modifier par i + 1 pour
						// le rajouter dans la matrice

			int l = 0; // A vérifier -> numéro de block

			for (int numBlock = 0; numBlock < nbBlocktotal; numBlock++) {
				l++;

				int compteur = 0;
				
				int[] tabXY = RandomXY();
				int xCoorHorizontal = matriceBlock[l - 1][0] + tabXY[0];
				int yCoorVertical = matriceBlock[l - 1][1] + tabXY[1];

				while (!verifValidGeneration(matrice, matriceBlock, numBlock, chriffre, xCoorHorizontal, yCoorVertical)) {
					compteur++;
					tabXY = RandomXY();
					xCoorHorizontal = matriceBlock[l - 1][0] + tabXY[0];
					yCoorVertical = matriceBlock[l - 1][1] + tabXY[1];
					if (compteur > 100)
						return false;
				}

				matrice[xCoorHorizontal][yCoorVertical] = chriffre;

			}

		}
		/**
		 * Pour afficher la matrice remplie
		 */
		for (int[] row : matrice)
			System.out.println(Arrays.toString(row));

		clonateMatrice(matrice);

		return true;
	}

	/**
	 * Fonction RandomXY()
	 * 
	 * @return un tableau avec X et Y
	 */
	private int[] RandomXY() {

		int Tab[] = new int[2];

		Tab[0] = Random(this.nbColon);
		Tab[1] = Random(this.nbLign);

		return Tab;
	}

	/**
	 * Fonction : Randomint (int valeurMax) Objectif : Retourner un chiffre au
	 * hasard entre 0 et la valeur max -1
	 * 
	 * @return Retourne un int entre 0 et le nombre passé en paramettre
	 */
	private int Random(int valeurMax) {
		int Random = (int) (Math.random() * valeurMax);

		return Random;
	}

	public boolean verifValidGeneration(int matrice[][], int matriceBlock[][], int numBlock, int chiffre,
			int xCoorHorizontal, int yCoorVertical) {

		boolean isValide = true;

		if (isValide)
			isValide = verifBlockDejaSaisi(matrice, xCoorHorizontal, yCoorVertical);

		if (isValide)
			isValide = verifChiffreBlock(matrice, matriceBlock, numBlock, chiffre);

		if (isValide)
			isValide = verifChiffreLigne(matrice, yCoorVertical, chiffre);

		if (isValide)
			isValide = verifChriffreColon(matrice, xCoorHorizontal, chiffre);

		return isValide;
	}

	/**
	 * Fonction : verifBlockDejaSaisi(int matrice[][], int matriceBlock[][], int
	 * numBlock)
	 * 
	 * @param matrice
	 * @param xCoorHorizontal
	 * @param yCoorVertical
	 * 
	 * @return Booleen à true si le test effectué autorise la saisie
	 */
	public boolean verifBlockDejaSaisi(int matrice[][], int xCoorHorizontal, int yCoorVertical) {

		boolean isValide = true;

		// Vérifier que la case n'est pas utilisée dans le Block
		if (matrice[xCoorHorizontal][yCoorVertical] != 0)
			isValide = false; /// // /> Vérifier la position du X et du y dans le tableau

		return isValide;
	}

	/**
	 * Fonction : verifChiffreBlock(int matrice[][], int matriceBlock[][], int
	 * numBlock, int chiffre)
	 * 
	 * Objectif : Vérifier si le chiffre n'est pas déjà présent dans le block
	 * 
	 * @param matrice
	 * @param matriceBlock
	 * @param numBlock
	 * @param chiffre
	 * 
	 * @return Booleen à true si le test effectué autorise la saisie
	 */
	public boolean verifChiffreBlock(int matrice[][], int matriceBlock[][], int numBlock, int chiffre) {

		boolean isPossible = true; /// Juste pour teste initialisation

		/*
		 * Extraction coordonnées de début et de fin du block visé sur la matrice
		 */
		int debutAxeOrisontal = matriceBlock[numBlock][0];
		int debutAxeVertical = matriceBlock[numBlock][1];
		int finAxeOrisontal = matriceBlock[numBlock][2];
		int finAxeVertical = matriceBlock[numBlock][3];

//			System.out.println("xDébut " + debutAxeOrisontal);
//			System.out.println("yDébut " + debutAxeVertical);
//			System.out.println("xFin " + finAxeOrisontal);
//			System.out.println("yfin " + finAxeVertical);

		/*
		 * Parcourrir la matrice selon les coordonnées de début et de fin du block visé,
		 * afin de vérifier que le chiffre n'est pas déjà présent
		 */
		for (int i = debutAxeOrisontal; i < finAxeOrisontal + 1; i++) {

			for (int j = debutAxeVertical; j < finAxeVertical + 1; j++) // +1 ?
			{

				if (chiffre == matrice[i][j])
					isPossible = false;
			}
		}

		return isPossible;
	}

	/**
	 * Fonction verifChiffreLigne(int matrice[][], int yCoorVertical, int chiffre)
	 * 
	 * Objectif : Vérifier si le chiffre n'est pas déjà présent sur la ligne
	 * 
	 * @param matrice
	 * @param yCoorVertical
	 * @param chiffre
	 * 
	 * @return Booleen à true si le test effectué autorise la saisie
	 */
	public boolean verifChiffreLigne(int matrice[][], int yCoorVertical, int chiffre) {

		boolean isValide = true;

		// Vérifie que le chiffre n'est pas déjà présent sur la ligne
		for (int i = 0; i < dimMatriceX; i++)

			if (chiffre == matrice[i][yCoorVertical])
				isValide = false;

		return isValide;

	}

	/**
	 * Fonction verifChriffreColon(int matrice[][], int xCoorHorizontal, int
	 * chiffre)
	 * 
	 * Objectif : Vérifier si le chiffre n'est pas déjà présent sur la ligne
	 * 
	 * @param matrice
	 * @param xCoorHorizontal
	 * @param chiffre
	 * 
	 * @return Booleen à true si le test effectué autorise la saisie
	 */
	public boolean verifChriffreColon(int matrice[][], int xCoorHorizontal, int chiffre) {

		boolean isValide = true;

		// Vérifie que le chiffre n'est pas déjà présent sur la colonne
		for (int j = 0; j < dimMatriceY; j++)

			if (chiffre == matrice[xCoorHorizontal][j])
				isValide = false;

		return isValide;

	}
	
	private void randomLocationErase(int matrice[][], int ratioDiff) {
		int cpt = 0;
		while (cpt != ratioDiff) {
			int temp [] = {Random(this.dimMatriceX),Random(this.dimMatriceY)};

			if ( matrice[temp [0]][temp [1]] != 0) {
				matrice[temp [0]][temp [1]] = 0;
				cpt++;
			}
		}

	}

	private int[][] selectDiffculty(int nivDifficulte) {
		
		//this.nivDifficulte = nivDifficulte;
		int indice;
		
		switch (nivDifficulte) {
		//jouer sur nbChiffreBlock pour gérer la diffculté petit = facile
		case 1:
			indice = 6;		
			break;			
		case 2:
			indice = 5;		
			break;			
		case 3:
			indice = 4;		
			break;
		case 4:
			indice = 3;
			break;			
		case 5:
			indice = 2;
			break;
		default:
			indice = 2;
		}
		
		nbCaseVisible= (((dimMatriceX+dimMatriceY)/2)*indice);

		randomLocationErase(matrice,nbCasesMatrice-(nbCaseVisible));
		System.out.println(">>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");
		for (int[] row : matrice)
			System.out.println(Arrays.toString(row));	
		System.out.println(">>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");
		
//		for (int[] row : matriceSoluce)
//			System.out.println(Arrays.toString(row));	
		createMatriceReco(matrice);
		return matrice;
		
	}

	private int[][] clonateMatrice(int matrice[][]) {
		this.matriceSoluce = new int[matrice.length][];
		for (int i = 0; i < matrice.length; i++) {
			this.matriceSoluce[i] = new int[matrice[i].length];
			System.arraycopy(matrice[i], 0, matriceSoluce[i], 0, matrice[i].length);
		}
		return matriceSoluce;
	}
	
	private int[][] createMatriceReco(int matrice[][]) {
		this.matriceJoueurReco = new int[matrice.length][];
		for (int i = 0; i < matrice.length; i++) {
			this.matriceJoueurReco[i] = new int[matrice[i].length];
			System.arraycopy(matrice[i], 0, matriceJoueurReco[i], 0, matrice[i].length);
			
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (int[] row : matriceJoueurReco)
			System.out.println(Arrays.toString(row));
		return matriceJoueurReco;
	}
	
	public int[][] matriceTestBool(int matrice[][], int matriceSoluce[][]) {
		
		for (int i = 0; i < this.dimMatriceX; i++) {
			
			for (int j = 0; j < dimMatriceY; j++) {
				
					matriceVerite[i][j] = (matriceSoluce[i][j]==matrice[i][j] ? 1 : 0);	
			}
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (int[] row : matriceVerite)
			System.out.println(Arrays.toString(row));
		
		return matriceVerite;
	}
	
	
	public void masterGenerationGrille() {
		//initiVariablesInstance();
//		this.matrice = genrerationGrilleZero();
		/**
		 * Pour tester : affiche la matrice de coordonnées de blocks
		 */
		this.matriceBlock = geneTabCorrespondanceBlockMatrice();

		boolean estMatriceGenenree = genererMatriceAleatoire(this.matrice, this.matriceBlock);
		while (!estMatriceGenenree) {
			this.matrice = genrerationGrilleZero();
			estMatriceGenenree = genererMatriceAleatoire(this.matrice, this.matriceBlock);
		}

	}
	
	public int[][] getMatriceSoluce() {
		return matriceSoluce;
	}


	public void setMatriceSoluce(int[][] matriceSoluce) {
		this.matriceSoluce = matriceSoluce;
	}


	public int[][] getMatrice() {
		return matrice;
	}


	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
	}


	public int[][] getMatriceVerite() {
		return matriceVerite;
	}


	public void setMatriceVerite(int[][] matriceVerite) {
		this.matriceVerite = matriceVerite;
	}


	public int[][] getMatriceJoueurReco() {
		return matriceJoueurReco;
	}


	public void setMatriceJoueurReco(int[][] matriceJoueurReco) {
		this.matriceJoueurReco = matriceJoueurReco;
	}
}

/// exemple de déclaration de méthode pour javadoc
/**
 * description de la méthode. explication supplémentaire si nécessaire
 * 
 * @return description de la valeur de retour
 * @param arg1 description du 1er argument : : :
 * @param argN description du Neme argument
 * @exception Exception1 description de la première exception : : :
 * @exception ExceptionN description de la Neme exception
 * 
 * @see UneAutreClasse#UneAutreMethode
 * @author Jean-Christophe;
 */