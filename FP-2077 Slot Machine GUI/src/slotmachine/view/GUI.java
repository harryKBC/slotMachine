package slotmachine.view;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class GUI extends JFrame implements PropertyChangeListener {

	// this class is the body of the main Jframe It calls upon all of the other
	// classes to implement the GUI.
	public GUI(SlotMachine model, CallBack cb) {

		cb.addPropertyChangeListener(this);
		pack();
		setTitle("FP-2077 Slot Machine GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(800, 800);
		setLocationRelativeTo(null);

		// jmenuBar
		setJMenuBar(new MenuBar(model, cb));

		// ToolBar
		add(new ToolBar(model, cb), BorderLayout.SOUTH);

		// contains BETS, STATUS and PLAYER
		add(new North(model, cb), BorderLayout.NORTH);

		// contains wheels
		add(new Wheels(model, cb), BorderLayout.CENTER);

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if (arg0.getPropertyName().equals("playerName")) {

		}

	}

}
