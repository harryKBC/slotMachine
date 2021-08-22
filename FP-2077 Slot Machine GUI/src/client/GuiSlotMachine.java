package client;

import javax.swing.SwingUtilities;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachineImpl;
import slotmachine.view.GUI;

public class GuiSlotMachine {

	public static void main(String[] args) {

		// create model
		SlotMachineImpl model = new SlotMachineImpl();
		CallBack cb = new CallBack();
		model.addCallback(cb);

		// setting up background thread (EDT)
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				// create GUI send model to GUI
				GUI gui = new GUI(model, cb);
				gui.setVisible(true);
			}
		});

		// SlotMachineTest.main(args);
	}

}
