package sudoku.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Flybox extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//variables
	JButton btnOk, btnCancelButton;
	Image img;
	JLabel lbJeu, lbNb, lbInstr, imgNumber;
	JTextField jTextField;
	JSeparator jSep;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Flybox() {
		this.setSize(500, 250);
		this.setTitle("Entrer un chiffre");
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setLayout(new GridBagLayout());
		
		//gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc.fill = GridBagConstraints.BOTH;
		
		////////////image ////////////////
		imgNumber = new JLabel();
		imgNumber.setIcon(new ImageIcon("src\\sudoku\\view\\1.png"));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(imgNumber, gbc);
		
		/////////////Label//////////////
		lbJeu = new JLabel("SUDOKU");
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(lbJeu, gbc);
		
		lbNb = new JLabel("Version Oiseaux");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(lbNb, gbc);
		
		jSep = new JSeparator(SwingConstants.HORIZONTAL);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(jSep, gbc);
		
		lbInstr = new JLabel("Veuillez entrer un chiffre : ");
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(lbInstr, gbc);
		
		//////////JTextfield/////////
		jTextField = new JTextField(" ");
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(jTextField, gbc);
		
		//////////// boutons /////////////
		btnOk = new JButton("OK");
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(btnOk, gbc);
		
		btnCancelButton = new JButton("Cancel");
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.add(btnCancelButton, gbc);
		
		this.setUndecorated(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
