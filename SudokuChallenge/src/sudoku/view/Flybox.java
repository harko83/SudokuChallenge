package sudoku.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Flybox extends JFrame {
	
	private static final long serialVersionUID = 1L;

	JButton btnOk, btnCancelButton;
	GridBagConstraints gbc = new GridBagConstraints();
	
	Image img;
	
	JLabel lbJeu, lbNb, lbInstr, imgNumber;
	
	JTextField jTextField;
	
	public Flybox() {
		this.setSize(500, 250);
		this.setTitle("Entrer un chiffre");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setLayout(new GridBagLayout());
		
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		
		////////////image ////////////////
		imgNumber = new JLabel();
		imgNumber.setIcon(new ImageIcon("src\\sudoku\\view\\1.png"));
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;

	
		this.add(imgNumber, gbc);
		
		/////////////Label//////////////
		lbJeu = new JLabel("SUDOKU");
		gbc.gridwidth = 0;
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(lbJeu, gbc);
		
		lbNb = new JLabel("Version Oiseaux");
		gbc.gridwidth = 0;
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(lbNb, gbc);
		
		//this.add(new JSeparator());
		
		lbInstr = new JLabel("Veuillez entrer un chiffre : ");
		gbc.gridwidth = 0;
		gbc.gridx = 2;
		gbc.gridy = 3;
		this.add(lbInstr, gbc);
		
		//////////JTextfield/////////
		jTextField = new JTextField(" ");
		gbc.gridwidth = 0;
		gbc.gridx = 3;
		gbc.gridy = 3;
		this.add(jTextField, gbc);
		
		//////////// boutons /////////////
		btnOk = new JButton("OK");
		gbc.gridwidth = 0;
		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(btnOk, gbc);
		
		btnCancelButton = new JButton("Cancel");
		gbc.gridwidth = 0;
		gbc.gridx = 3;
		gbc.gridy = 4;
		this.add(btnCancelButton, gbc);
		
		this.setUndecorated(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
