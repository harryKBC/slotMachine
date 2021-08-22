package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import slotmachine.model.SlotMachine;
import slotmachine.view.DialogBoxSpinParameters;

public class DisplaySpinParameters implements ActionListener, PropertyChangeListener {

	SlotMachine model;
	CallBack cb;
	int turns;
	int time;

	// Allows the Display parameters to run the spins of the slot machine and be
	// modified and stored here.

	public DisplaySpinParameters(SlotMachine model, CallBack cb2) {
		cb2.addPropertyChangeListener(this);
		this.model = model;
		this.cb = cb2;
		time = 100;
		turns = 20;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new DialogBoxSpinParameters(model, cb, time, turns);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("spinControllerTurns")) {
			turns = (int) evt.getNewValue();

		}
		if (evt.getPropertyName().equals("spinControllerSpeed")) {
			time = (int) evt.getNewValue();

		}

	}

}
