package sudoku.view;



	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.EventQueue;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;

	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JSeparator;
	import javax.swing.SwingConstants;

	
	public class TestPopup {

	    private JFrame mainFrame = null;

	    public TestPopup() {
	        mainFrame = new JFrame("Popup GridBagLayou");

	        /* 1- Initialisation du container. */
	        mainFrame.setLayout(new GridBagLayout());

	        /* 2- Création et initialisation d'une série de composants. */
	        JLabel photoLabel = new JLabel("Image");
	        photoLabel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1));
	        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        photoLabel.setPreferredSize(new Dimension(75, 100));

	        JLabel nomApplication = new JLabel("Sudoku de la mort !");
	        JLabel versionApplication = new JLabel("Version : Oiseaux");

	        JSeparator separator = new JSeparator();

	        JButton validerJButtonButton = new JButton("Valider");
	        JButton annulerJButtonButton = new JButton("Annuler");

	        /*3- Ajout de ces composants en spécifiant les contraintes de type GridBagConstraints. */
	        GridBagConstraints gbc = new GridBagConstraints();


	        /* b- ajout de la zone pour la photo. nous avons utilisé une étiquette pour cela. */
	        gbc.gridy = 1;
	        gbc.gridwidth = 1;
	        gbc.gridheight = 4;
	        	
	        /* Ici, nous ne voulons surement pas que le composant s'aligne sur la ligne de base. Il n'est pas censé
	        * représenté un élémént de texte mais bien une image. Nous allons donc utiliser la constance LINE_START. */
	        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
	        gbc.insets = new Insets(5, 5, 5, 0);
	        mainFrame.add(photoLabel, gbc);
	        /* ************************************************************************************** */

	        /* c- étiquette nom de l'application */
	        gbc.gridx = 1;
	        gbc.gridy = 3; 
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        /* L'étiquette avec le nom sera alignée sur la ligne de base avec le champ de saisie pour le nom. */
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
	        gbc.insets = new Insets(0, 30, 0, 0);
	        mainFrame.add(nomApplication, gbc);
	        /* ************************************************************************************** */



	        /* e- l'étiquette version de l'application */
	        gbc.gridx = 1;
	        gbc.gridy = 4;
	        		
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;	        
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
	        gbc.insets = new Insets(0, 30, 0, 0);
	        mainFrame.add(versionApplication, gbc);
	        /* ************************************************************************************** */


	        /* M- Un séparateur. */
	        gbc.gridy = 5;
	        gbc.gridx = 0;
	        gbc.gridwidth = 6;
	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(4, 4, 4, 4);
	        mainFrame.add(separator, gbc);
	        /* ************************************************************************************** */

	        /* N- Le bouton valider. */
	        gbc.gridy = 6;
	        gbc.gridx = 3;
	        gbc.gridheight = GridBagConstraints.REMAINDER; /* dernier composant de la colonne */
	        gbc.weighty = 1.;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
	        gbc.insets = new Insets(3, 0, 5, 5);
	        mainFrame.add(validerJButtonButton, gbc);
	        /* ************************************************************************************** */
	        
	        /* N- Le bouton annuler. */
	        gbc.gridy = 6;
	      	gbc.gridx = 6;        		
	        gbc.gridheight = GridBagConstraints.REMAINDER; /* dernier composant de la colonne */
	        gbc.weighty = 1.;
	        gbc.fill = GridBagConstraints.NONE;
	        gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
	        gbc.insets = new Insets(3, 0, 5, 5);
	        mainFrame.add(annulerJButtonButton, gbc);
	        /* ************************************************************************************** */

	        mainFrame.setMinimumSize(new Dimension(320, 205));
	        mainFrame.setLocationRelativeTo(null);
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public void setVisible(boolean b) {
	        mainFrame.setVisible(b);
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {

	            public void run() {
	                TestPopup pop = new TestPopup();
	                pop.setVisible(true);
	            }
	        });
	    }
	}
