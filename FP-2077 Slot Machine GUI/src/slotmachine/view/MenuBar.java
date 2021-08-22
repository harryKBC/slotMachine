package slotmachine.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import slotmachine.controller.CallBack;
import slotmachine.controller.DisplayAbout;
import slotmachine.controller.DisplayAddCredits;
import slotmachine.controller.DisplayBet;
import slotmachine.controller.DisplayPlayer;
import slotmachine.controller.DisplayPreviousPlayerInfo;
import slotmachine.controller.DisplaySpinParameters;
import slotmachine.controller.DisplaySpinResults;
import slotmachine.controller.DisplayWinningOdds;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements ActionListener, PropertyChangeListener {

	// this is the Jmenu bar, it is a class which extends menu bar allowing us to
	// have access to its methods. It also implements
	// action listener which allows us to access its functionalities.

	private ActionListener listener;
	private ActionListener listenerResetBet;
	private ActionListener spinWheelsListener;

	// spin variables
	private int turns;
	private int time;

	JMenu itemOne;
	JMenu itemTwo;
	JMenu itemThree;

	public MenuBar(SlotMachine model, CallBack cb) {

		// beow we create each Jmenu items and sub menu items, we then tag them with a
		// keystroke, and set it as the accelerator, then link
		// the accelerator to the action which runs the class Display about, this is
		// repeated for all the associated classes

		cb.addPropertyChangeListener(this);

		// setting the default turns
		turns = 20;
		time = 100;

		// listener to handle spin wheel functionality
		spinWheelsListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new Thread() {
					@Override
					public void run() {
						try {

							model.spinToWin(turns, time);
						} catch (Exception e) {
							if (e.toString() == "java.lang.NullPointerException") {
								JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
										JOptionPane.DEFAULT_OPTION);
							} else {
								JOptionPane.showConfirmDialog(null, e.getMessage(), "Error",
										JOptionPane.DEFAULT_OPTION);
							}
						}
					}
				}.start();
			}
		};

		// listener to handle cash out functionality
		listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.cashOut();
				} catch (Exception e) {
					if (e.toString() == "java.lang.NullPointerException") {
						JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
								JOptionPane.DEFAULT_OPTION);
					} else {
						JOptionPane.showConfirmDialog(null, e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION);
					}
				}
			}
		};

		listenerResetBet = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.resetBets();
				} catch (Exception e) {
					if (e.toString() == "java.lang.NullPointerException") {
						JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
								JOptionPane.DEFAULT_OPTION);
					} else {
						JOptionPane.showConfirmDialog(null, e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION);
					}
				}
			}
		};

		itemOne = new JMenu("File");
		add(itemOne);

		JMenuItem item2 = new JMenuItem("About Us");
		itemOne.add(item2);

		item2.addActionListener(this);
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
		item2.addActionListener(new DisplayAbout());

		// Displays about add player, place bet and cash out

		itemTwo = new JMenu("Game");
		add(itemTwo);
		JMenuItem item3 = new JMenuItem("Spin");
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
		item3.addActionListener(spinWheelsListener);
		itemTwo.add(item3);

		JMenuItem item4 = new JMenuItem("Add Player");
		itemTwo.add(item4);
		item4.addActionListener(this);
		item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0));
		item4.addActionListener(new DisplayPlayer(model));

		JMenuItem item10 = new JMenuItem("Add Credits");
		itemTwo.add(item10);
		item10.addActionListener(this);
		item10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, 0));
		item10.addActionListener(new DisplayAddCredits(model));

		JMenuItem item6 = new JMenuItem("Place Bet");
		item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0));
		itemTwo.add(item6);
		item6.addActionListener(new DisplayBet(model, cb));

		JMenuItem item7 = new JMenuItem("Cash Out");
		item7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0));
		item7.addActionListener(listener);
		itemTwo.add(item7);

		JMenuItem item11 = new JMenuItem("Reset Bets");
		item11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0));
		item11.addActionListener(listenerResetBet);
		itemTwo.add(item11);

		JMenuItem item12 = new JMenuItem("last Results");
		item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0));
		item12.addActionListener(new DisplaySpinResults(model, cb));
		itemTwo.add(item12);

		// adds the exit button to system to allow the user to exit the program by
		// pressing escape

		itemThree = new JMenu("System");

		JMenuItem item1 = new JMenuItem("Previous machine spins");
		itemThree.add(item1);
		item1.addActionListener(this);
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0));
		item1.addActionListener(new DisplayPreviousPlayerInfo(model, cb));

		JMenuItem item13 = new JMenuItem("Winning odds");
		item13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0));
		item13.addActionListener(new DisplayWinningOdds());
		itemThree.add(item13);

		JMenuItem item14 = new JMenuItem("Spin parameters");
		item14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
		item14.addActionListener(new DisplaySpinParameters(model, cb));
		itemThree.add(item14);

		add(itemThree);
		JMenuItem item8 = new JMenuItem("Exit");
		item8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		itemThree.add(item8);
		item8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
	}

	// no action required
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		if (arg0.getPropertyName().equals("hideSpin")) {
			itemTwo.setVisible(false);

		}
		if (arg0.getPropertyName().equals("showSpin")) {
			itemTwo.setVisible(true);
		}
		if (arg0.getPropertyName().equals("spinControllerTurns")) {
			turns = (int) arg0.getNewValue();
		}
		if (arg0.getPropertyName().equals("spinControllerSpeed")) {
			time = (int) arg0.getNewValue();
		}

	}

}
