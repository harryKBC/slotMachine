package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import slotmachine.view.DialogBoxAbout;

public class DisplayAbout implements ActionListener {

	// displays the About dialog box

	// @Override
	@Override
	public void actionPerformed(ActionEvent e) {

		new DialogBoxAbout();

	}

}
