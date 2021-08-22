package slotmachine.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import slotmachine.controller.CallBack;
import slotmachine.controller.DisplayBet;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar implements PropertyChangeListener {

	private JButton spin;
	private JButton placeBet;
	private JButton cashOut;
	private ActionListener listenerCashOut;
	private ActionListener spinWheelsListener;

	// spin variables
	private int turns;
	private int time;

	// creates the tool bar and adds 3 buttons as required in the spec. Theses have
	// keyboard focus and have not been given hotkeys. The design of the program is
	// to allow the user to have hotkeys to access the menu items and the arrow keys
	// to use the tool bar.

	public ToolBar(SlotMachine model, CallBack cb) {
		cb.addPropertyChangeListener(this);
		spin = new JButton("Spin");
		placeBet = new JButton("Place Bet");
		cashOut = new JButton("Cash Out");

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
		listenerCashOut = new ActionListener() {

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

		// runs the display bet class
		placeBet.addActionListener(new DisplayBet(model, cb));
		add(cashOut);
		add(placeBet);
		add(spin);

		spin.addActionListener(spinWheelsListener);

		cashOut.addActionListener(listenerCashOut);

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getPropertyName().equals("hideSpin")) {
			spin.setVisible(false);
			cashOut.setVisible(false);
			placeBet.setVisible(false);
		}
		if (arg0.getPropertyName().equals("showSpin")) {
			spin.setVisible(true);
			cashOut.setVisible(true);
			placeBet.setVisible(true);
		}
		if (arg0.getPropertyName().equals("spinControllerTurns")) {
			turns = (int) arg0.getNewValue();
		}
		if (arg0.getPropertyName().equals("spinControllerSpeed")) {
			time = (int) arg0.getNewValue();
		}
	}
}
