package sudoku.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class SudokuFrameJtextfield extends JFrame implements ActionListener {
	JPanel mainpane = (JPanel) this.getContentPane();
//	int rowChoosen = 0;
//	int columnChoosen = 0;
////	JButton[] numberBtns = new JButton[9];
	List<JButton> numberBtns = new ArrayList<JButton>();
	List<JTextField> cellFiedls = new ArrayList<JTextField>();
	boolean isIndice;
	int cellChoosen = -1;
//	JTable gridTable;

	public SudokuFrameJtextfield() {
		super("Jeu du sudoku");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(900, 900);
		this.setLocationRelativeTo(null);
		this.setJMenuBar(createMenuBar());
		mainpane.add(this.createGridPane(), BorderLayout.CENTER);
		mainpane.add(this.createGamePane(), BorderLayout.SOUTH);
		this.setVisible(true);
	}

	private JPanel createGamePane() {
		JPanel gamePane = new JPanel();
		gamePane.setLayout(new BorderLayout());
		gamePane.add(createNumberPane(), BorderLayout.NORTH);
		gamePane.add(createActionPane(), BorderLayout.SOUTH);
		gamePane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() / 5));
//		gamePane.setVisible(true);
		return gamePane;
	}

	private JPanel createActionPane() {
		JPanel actionPane = new JPanel();
		actionPane.setLayout(new GridLayout(1, 5));
		JButton restBtn = new JButton("Restart");
		restBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton finishBtn = new JButton("Finish");
		finishBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton checkRulesBtn = new JButton("Check rules");

		checkRulesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton chekSolutionhBtn = new JButton("Check solution");

		chekSolutionhBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton getSolutionhBtn = new JButton("Get solution");

		getSolutionhBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		actionPane.add(checkRulesBtn);
		actionPane.add(chekSolutionhBtn);
		actionPane.add(getSolutionhBtn);
		actionPane.add(finishBtn);
		actionPane.add(restBtn);
		return actionPane;
	}

	private JPanel createNumberPane() {
		JPanel numberPane = new JPanel();
		numberPane.setLayout(new GridLayout(1, 9));
		for (int i = 0; i < 9; i++) {
			numberBtns.add(new JButton(String.valueOf(i + 1)));
			numberBtns.get(i).addActionListener(this);
			numberPane.add(numberBtns.get(i));
		}
		return numberPane;
	}

	private JPanel createGridPane() {
		JPanel gridPane = new JPanel();
		gridPane.setLayout(new GridLayout(9, 9));
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cellChoosen = cellFiedls.indexOf(e.getSource());
				if (!cellFiedls.get(cellChoosen).getText().equalsIgnoreCase("0")) {
					isIndice = true;
					JOptionPane.showInputDialog("Vous aves cliqu� sur un indice. Cette case n'est pas modifiable");
				} else {
					isIndice = false;
				}
//				cellChoosen = new Point(calcRowIndex(i), calcColumnIndex(i));
			}
		};
		for (int i = 0; i < 81; i++) {
			JTextField cell = new JTextField(String.valueOf(0));
			cell.setHorizontalAlignment(JTextField.CENTER);
			cell.setEditable(false);
			cell.addMouseListener(mouseAdapter);

//				private int calcColumnIndex(int i) {
//					if (i % 9 != 0) {
//						return i + 1 / 9;
//					}
//					return ((i + 1) / 9 - 1);
//				}
//
//				private int calcRowIndex(int i) {
//					if (i % 9 != 0) {
//						return (i + 1) % 9 - 1;
//					}
//					return 8;
//				}

			cellFiedls.add(cell);
			gridPane.add(cell);
		}
		colorDisplay();

		// gridTable.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				JTable target = (JTable) e.getSource();
//				rowChoosen = target.getSelectedRow();
//				columnChoosen = target.getSelectedColumn();
//				if (String.valueOf(gridTable.getValueAt(rowChoosen, columnChoosen)) == null) {
//					cellChoosen = new Point(rowChoosen, columnChoosen);
//				}
////				else
////					System.out.println("Vous ne pouvez pas modifier cette case");
////				System.out.println(
////						" Vous avez cliqu� sur la cellule : ligne n� " + rowChoosen + " colonne n�" + columnChoosen);
//			}
//		});
//
//		int c = 0;
//		for (int x = 0; x < 9; x++) {
//			for (int y = 0; y < 9; y++) {
//				gridTable.setValueAt(String.valueOf(c), x, y);
//				c++;
//			}
//		}
////		gridTable.setCellSelectionEnabled(false);
//		gridTable.setLocation(300, 20);
////		gridPane.setLayout(new GridLayout(9, 9));
//		gridPane.add(gridTable);
		return gridPane;
	}

	private void colorDisplay() {
		List<JTextField> grayCells = new ArrayList<JTextField>();
		grayCells.add(cellFiedls.get(0));
		grayCells.add(cellFiedls.get(1));
		grayCells.add(cellFiedls.get(2));
		grayCells.add(cellFiedls.get(9));
		grayCells.add(cellFiedls.get(10));
		grayCells.add(cellFiedls.get(11));
		grayCells.add(cellFiedls.get(18));
		grayCells.add(cellFiedls.get(19));
		grayCells.add(cellFiedls.get(20));
		grayCells.add(cellFiedls.get(30));
		grayCells.add(cellFiedls.get(31));
		grayCells.add(cellFiedls.get(32));
		grayCells.add(cellFiedls.get(39));
		grayCells.add(cellFiedls.get(40));
		grayCells.add(cellFiedls.get(41));
		grayCells.add(cellFiedls.get(48));
		grayCells.add(cellFiedls.get(49));
		grayCells.add(cellFiedls.get(50));
		grayCells.add(cellFiedls.get(6));
		grayCells.add(cellFiedls.get(7));
		grayCells.add(cellFiedls.get(8));
		grayCells.add(cellFiedls.get(15));
		grayCells.add(cellFiedls.get(16));
		grayCells.add(cellFiedls.get(17));
		grayCells.add(cellFiedls.get(24));
		grayCells.add(cellFiedls.get(25));
		grayCells.add(cellFiedls.get(26));
		grayCells.add(cellFiedls.get(54));
		grayCells.add(cellFiedls.get(55));
		grayCells.add(cellFiedls.get(56));
		grayCells.add(cellFiedls.get(63));
		grayCells.add(cellFiedls.get(64));
		grayCells.add(cellFiedls.get(65));
		grayCells.add(cellFiedls.get(72));
		grayCells.add(cellFiedls.get(73));
		grayCells.add(cellFiedls.get(74));
		grayCells.add(cellFiedls.get(60));
		grayCells.add(cellFiedls.get(61));
		grayCells.add(cellFiedls.get(62));
		grayCells.add(cellFiedls.get(69));
		grayCells.add(cellFiedls.get(70));
		grayCells.add(cellFiedls.get(71));
		grayCells.add(cellFiedls.get(78));
		grayCells.add(cellFiedls.get(79));
		grayCells.add(cellFiedls.get(80));
		for (int i = 0; i < grayCells.size(); i++) {
			grayCells.get(i).setBackground(Color.LIGHT_GRAY);
		}
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("New");
		menu.add(actNew1);
		menu.add(actNew2);
		menu.add(actNew3);
		menu.add(actNew4);
		menu.add(actNew5);
		JMenu help = new JMenu("Help");
		menuBar.add(menu);
		menuBar.add(help);
		return menuBar;
	}

	private AbstractAction actNew1 = new AbstractAction() {
		{
			putValue(NAME, "Level 1");
			putValue(MNEMONIC_KEY, KeyEvent.VK_1);
			putValue(SHORT_DESCRIPTION, "New Game1...(Ctrl+1)");
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Level 1");
//			JOptionPane.showInternalOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue);
		}
	};
	private AbstractAction actNew2 = new AbstractAction() {
		{
			putValue(NAME, "Level 2");
			putValue(MNEMONIC_KEY, KeyEvent.VK_2);
			putValue(SHORT_DESCRIPTION, "New Game2...(Ctrl+2)");
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Level 2");
		}
	};

	private AbstractAction actNew3 = new AbstractAction() {
		{
			putValue(NAME, "Level 3");
			putValue(MNEMONIC_KEY, KeyEvent.VK_3);
			putValue(SHORT_DESCRIPTION, "New Game3...(Ctrl+3)");
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Level 3");
		}
	};
	private AbstractAction actNew4 = new AbstractAction() {
		{
			putValue(NAME, "Level 4");
			putValue(MNEMONIC_KEY, KeyEvent.VK_4);
			putValue(SHORT_DESCRIPTION, "New Game...(Ctrl+4)");
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_4, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Level 4");
		}
	};
	private AbstractAction actNew5 = new AbstractAction() {
		{
			putValue(NAME, "Level 5");
			putValue(MNEMONIC_KEY, KeyEvent.VK_5);
			putValue(SHORT_DESCRIPTION, "New Game...(Ctrl+2)");
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_5, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Level 5");
		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		int numBtn = numberBtns.indexOf((JButton) e.getSource());
		if (!isIndice) {
			cellFiedls.get(cellChoosen).setText(String.valueOf(numBtn + 1));
			for (JTextField cell : cellFiedls)
				System.out.println(cell.getText());
//			gridTable.setValueAt(String.valueOf(numBtn + 1), cellChoosen.x, cellChoosen.y);
		} else
			JOptionPane.showMessageDialog(null, "Choisissez d'abord une case");
	}

//	public static void main(String[] args) {
//		new SudokuFrameJtextfield();
//	}
}
