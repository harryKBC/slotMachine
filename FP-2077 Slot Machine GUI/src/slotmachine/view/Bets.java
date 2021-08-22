package slotmachine.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;
import slotmachine.model.slots.LineNum;

@SuppressWarnings("serial")
public class Bets extends JPanel implements PropertyChangeListener {

	private JLabel bet1;
	private JLabel bet2;
	private JLabel bet3;
	private JLabel bet4;
	private JLabel bet5;

	public Bets(SlotMachine model, CallBack cb) {

		cb.addPropertyChangeListener(this);

		// grid layout using 5 JLabels to display the bets on one JPanel using JLabels
		// to hold and display the Data, 5 JLabels were used.

		setLayout(new GridLayout(1, 5));
		this.setPreferredSize(new Dimension(200, 50));

		bet1 = new JLabel("Bet Line One", SwingConstants.CENTER);
		bet2 = new JLabel("Bet Line Two", SwingConstants.CENTER);
		bet3 = new JLabel("Bet Line Three", SwingConstants.CENTER);
		bet4 = new JLabel("Bet Line Four", SwingConstants.CENTER);
		bet5 = new JLabel("Bet Line Five", SwingConstants.CENTER);
		add(bet1);
		add(bet2);
		add(bet3);
		add(bet4);
		add(bet5);

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(new Color(114, 221, 247));

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		// place Bets update listener
		if (arg0.getPropertyName().equals("placeBet")) {
			if (arg0.getOldValue().equals(LineNum.LINE1)) {
				bet1.setText(String.valueOf("Bet Line One: " + arg0.getNewValue()));
			}
			if (arg0.getOldValue().equals(LineNum.LINE2)) {
				bet2.setText(String.valueOf("Bet Line Two: " + arg0.getNewValue()));
			}
			if (arg0.getOldValue().equals(LineNum.LINE3)) {
				bet3.setText(String.valueOf("Bet Line Three: " + arg0.getNewValue()));
			}
			if (arg0.getOldValue().equals(LineNum.LINE4)) {
				bet4.setText(String.valueOf("Bet Line Four: " + arg0.getNewValue()));
			}
			if (arg0.getOldValue().equals(LineNum.LINE5)) {
				bet5.setText(String.valueOf("Bet Line Five: " + arg0.getNewValue()));
			}
		}

		// cash out Bets update listener
		if (arg0.getPropertyName().equals("placeBetCashout")) {

			bet1.setText("Bet Line One");

			bet2.setText("Bet Line Two");

			bet3.setText("Bet Line Three");

			bet4.setText("Bet Line Four");

			bet5.setText("Bet Line Five");

		}

	}

}
