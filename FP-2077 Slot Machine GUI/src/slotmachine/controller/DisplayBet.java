package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import slotmachine.model.SlotMachine;
import slotmachine.view.DialogBoxPlaceBet;

public class DisplayBet implements ActionListener {

	SlotMachine model;
	CallBack cb;

	// implements the display bet listener
	// Class to allow functionality for the on click action for DisplayBet

	public DisplayBet(SlotMachine model, CallBack cb) {
		this.model = model;
		this.cb = cb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new DialogBoxPlaceBet(model, cb);

	}

}
