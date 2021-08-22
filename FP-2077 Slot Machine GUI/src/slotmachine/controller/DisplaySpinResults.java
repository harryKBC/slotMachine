package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import slotmachine.model.SlotMachine;
import slotmachine.view.DialogBoxSpinResults;

public class DisplaySpinResults implements ActionListener, PropertyChangeListener {

	// event which runs DialogBoxPlayer allows us to split up the actionPerformed
	// and gives more flexibility with the class.

	// @Override
	SlotMachine model;
	CallBack cb;
	String spinResults;
	String result1;
	String result2;
	String result3;
	String result4;
	String result5;

	String amountWon1;
	String amountWon2;
	String amountWon3;
	String amountWon4;
	String amountWon5;

	// constructor presets the values to show when no spin has occurred

	public DisplaySpinResults(SlotMachine model, CallBack cb) {

		cb.addPropertyChangeListener(this);
		spinResults = "no previous spin has occured";
		this.model = model;
		this.cb = cb;

		result1 = "no result for line 1 Please follow the prompts.";
		result2 = "no result for line 2 Please follow the prompts.";
		result3 = "no result for line 3 Please follow the prompts.";
		result4 = "no result for line 4 Please follow the prompts.";
		result5 = "no result for line 5 Please follow the prompts.";

		amountWon1 = "0";
		amountWon2 = "0";
		amountWon3 = "0";
		amountWon4 = "0";
		amountWon5 = "0";

	}

	// action sends collected results into the dialogbox for display
	@Override
	public void actionPerformed(ActionEvent e) {
		new DialogBoxSpinResults(model, result1, result2, result3, result4, result5, amountWon1, amountWon2, amountWon3,
				amountWon4, amountWon5);

	}

	// property change events collecting the values updating the class
	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getPropertyName().equals("spinResultSlotLine")) {
			if (evt.getOldValue().equals(1)) {
				result1 = (String) evt.getNewValue();

			}
		}

		if (evt.getPropertyName().equals("winAmount")) {
			if (evt.getOldValue().equals(1)) {
				amountWon1 = (String) evt.getNewValue();

			}
		}

		if (evt.getPropertyName().equals("spinResultSlotLine")) {
			if (evt.getOldValue().equals(2)) {

				result2 = (String) evt.getNewValue();

			}

		}

		if (evt.getPropertyName().equals("winAmount")) {
			if (evt.getOldValue().equals(2)) {
				amountWon2 = (String) evt.getNewValue();

			}
		}

		if (evt.getPropertyName().equals("spinResultSlotLine")) {
			if (evt.getOldValue().equals(3)) {

				result3 = (String) evt.getNewValue();

			}

		}

		if (evt.getPropertyName().equals("winAmount")) {
			if (evt.getOldValue().equals(3)) {
				amountWon3 = (String) evt.getNewValue();

			}
		}

		if (evt.getPropertyName().equals("spinResultSlotLine")) {
			if (evt.getOldValue().equals(4)) {

				result4 = (String) evt.getNewValue();

			}

		}

		if (evt.getPropertyName().equals("winAmount")) {
			if (evt.getOldValue().equals(4)) {
				amountWon4 = (String) evt.getNewValue();

			}
		}

		if (evt.getPropertyName().equals("spinResultSlotLine")) {
			if (evt.getOldValue().equals(5)) {

				result5 = (String) evt.getNewValue();

			}

		}

		if (evt.getPropertyName().equals("winAmount")) {
			if (evt.getOldValue().equals(5)) {
				amountWon5 = (String) evt.getNewValue();

			}
		}

	}

}
