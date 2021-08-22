package slotmachine.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class StatusBar extends JPanel implements PropertyChangeListener {

	private JLabel status1;
	private JLabel status2;

	// creates a the status bar in the center of the north panel, which is split
	// into 2 and give a border with a 1 by 2 grid layout

	public StatusBar(SlotMachine model, CallBack cb) {

		cb.addPropertyChangeListener(this);

		setLayout(new GridLayout(1, 2));
		setBackground(new Color(247, 174, 248));

		status1 = new JLabel("Wins will show here", SwingConstants.CENTER);
		status2 = new JLabel("Please register a player", SwingConstants.CENTER);

		status1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		status2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		add(status1);
		add(status2);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getPropertyName().equals("totalWin")) {
			status1.setText("Win: " + String.valueOf(evt.getNewValue()));
		}
		if (evt.getPropertyName().equals("showSpin")) {
			status2.setText("Please place a bet / add credits");
		}
		if (evt.getPropertyName().equals("statusUpdateOne")) {
			status2.setText("Please place a bet / add credits");
		}
		if (evt.getPropertyName().equals("statusPlaceBetCashout")) {
			status2.setText("Please register a player");
			status1.setText("Wins will show here");
		}
		if (evt.getPropertyName().equals("playerBetUpdate")) {
			status2.setText("Please spin");
		}
		if (evt.getPropertyName().equals("hideSpin")) {
			status2.setText("SPINNING - goodluck :)");
		}

	}

}
