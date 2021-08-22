package slotmachine.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class Player extends JPanel implements PropertyChangeListener {

	private JLabel nameLabel;
	private JLabel initialCredits;
	private JLabel currentCredits;
	private JLabel totalBet;

	public Player(SlotMachine model, CallBack cb) {

		cb.addPropertyChangeListener(this);

		// Player Panel set in a grid layout with each section holding a single JLabel
		setBackground(new Color(114, 221, 247));
		setLayout(new GridLayout(1, 5));
		this.setPreferredSize(new Dimension(50, 50));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(new JLabel(new ImageIcon("images/icons8-face-smile-64.png"), SwingConstants.CENTER));

		// name Label

		nameLabel = new JLabel();
		nameLabel.setText("Player Name");
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		add(nameLabel);

		// Initial credits label

		initialCredits = new JLabel();
		initialCredits.setText("Initial Credits");
		initialCredits.setHorizontalAlignment(JLabel.CENTER);
		add(initialCredits);

		// current Credits Label

		currentCredits = new JLabel();
		currentCredits.setText("Current Credits");
		currentCredits.setHorizontalAlignment(JLabel.CENTER);
		add(currentCredits);

		// total bet Label

		totalBet = new JLabel();
		totalBet.setText("Total Bet");
		totalBet.setHorizontalAlignment(JLabel.CENTER);
		add(totalBet);

		// add(new JLabel(nameLabel,SwingConstants.CENTER));

	}

	// getter for name label
	public JLabel getNameLabel() {

		return nameLabel;
	}

	// getter for initial credits
	public JLabel getinitialCredits() {

		return initialCredits;
	}

	// getter for currentCredits
	public JLabel getcurrentCredits() {

		return currentCredits;
	}

	// getter for totalBet
	public JLabel gettotalBet() {

		return totalBet;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		// register new player name
		if (arg0.getPropertyName().equals("playerName")) {
			nameLabel.setText("Player: " + (String) arg0.getNewValue());
		}

		// register new initialCredits
		if (arg0.getPropertyName().equals("playerInitialCredits")) {
			initialCredits.setText("Initial Credits: " + String.valueOf(arg0.getNewValue()));
		}

		// register player bet
		if (arg0.getPropertyName().equals("playerBet")) {
			totalBet.setText("Bet: " + String.valueOf(arg0.getNewValue()));
		}

		// register Player Available credits
		if (arg0.getPropertyName().equals("playerAvailableCredits")) {
			currentCredits.setText("Available Credits: " + String.valueOf(arg0.getNewValue()));
		}

		// update credits when new credits added
		if (arg0.getPropertyName().equals("addCredits")) {
			currentCredits.setText("Available Credits: " + String.valueOf(arg0.getNewValue()));
		}

		// updates the player bet
		if (arg0.getPropertyName().equals("playerBetUpdate")) {

			// betInt += storageBetInt;
			totalBet.setText("Total Bet: " + (int) arg0.getNewValue());
		}

		// Available credits update
		if (arg0.getPropertyName().equals("playerAvailableCreditsUpdate")) {
			currentCredits.setText("Available Credits: " + String.valueOf(arg0.getNewValue()));
		}

		// cash out new player name
		if (arg0.getPropertyName().equals("playerAvailableCreditsCashout")) {
			currentCredits.setText("Available Credits");
		}

		// cash out new player name
		if (arg0.getPropertyName().equals("playerNameCashout")) {
			nameLabel.setText("Player");
		}

		// cash out new initialCredits
		if (arg0.getPropertyName().equals("playerInitialCreditsCashout")) {
			initialCredits.setText("Initial Credits");
		}

		// cash out player bet
		if (arg0.getPropertyName().equals("playerBetCashout")) {
			totalBet.setText("Bet");
		}

		// cash out Player Available credits
		if (arg0.getPropertyName().equals("winningCredits")) {
			currentCredits.setText("Available Credits: " + String.valueOf(arg0.getNewValue()));
		}

	}

}
