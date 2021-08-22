package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import slotmachine.model.SlotMachine;
import slotmachine.view.DialogBoxPlayer;

public class DisplayPlayer implements ActionListener {

	// event which runs DialogBoxPlayer allows us to split up the actionPerformed
	// and gives more flexibility with the class.

	// @Override
	SlotMachine model;

	public DisplayPlayer(SlotMachine model) {
		this.model = model;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new DialogBoxPlayer(model);
	}

}
