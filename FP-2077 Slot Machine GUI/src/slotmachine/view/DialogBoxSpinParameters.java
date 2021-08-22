package slotmachine.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class DialogBoxSpinParameters extends JFrame {

	// class DialogBoxPlayer which extends Jframe

	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	private JLabel titleLabelOne;
	private JLabel titleLabelTwo;

	// constructs the object

	public DialogBoxSpinParameters(SlotMachine model, CallBack cb, int time, int turns) {

		// set inside panels

		insideFrame = new JPanel();
		insideFrameCenter = new JPanel();
		insideFrameCenter.setLayout(null);

		// set this panel as a JDialog and give it a borderlayout

		dialog = new JDialog(this, "Spin Parameters", true);
		dialog.setLayout(new BorderLayout());
		dialog.setResizable(false);

		// create the Buttons and name them in the JButton constructor

		JButton buttonCancel = new JButton("Done");

		// add the event listeners to the buttons which just prints output atm.

		// close event for button
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				DialogBoxSpinParameters.dialog.setVisible(false);
			}
		});

		// radio buttons for selecting the turns.
		JRadioButton quickSpin = new JRadioButton("Quick / 5");
		quickSpin.addActionListener(e -> {
			cb.spinControllerTurns(5);
		});

		JRadioButton shortSpin = new JRadioButton("Short / 10");
		shortSpin.addActionListener(e -> {
			cb.spinControllerTurns(10);
		});

		JRadioButton defaultSpin = new JRadioButton("Default / 20");
		defaultSpin.addActionListener(e -> {

		});

		JRadioButton longSpin = new JRadioButton("Long / 50");
		longSpin.addActionListener(e -> {
			cb.spinControllerTurns(50);
		});

		// radio buttons for selecting the spin speed.
		JRadioButton quickSpinSpeed = new JRadioButton("Quick / 50 ms");
		quickSpinSpeed.addActionListener(e -> {
			cb.spinControllerSpeed(5);
		});

		JRadioButton shortSpinSpeed = new JRadioButton("Default/ 100 ms");
		shortSpinSpeed.addActionListener(e -> {
			cb.spinControllerSpeed(10);
		});

		JRadioButton defaultSpinSpeed = new JRadioButton("Short / 250 ms");
		defaultSpinSpeed.addActionListener(e -> {
			cb.spinControllerSpeed(20);
		});

		JRadioButton longSpinSpeed = new JRadioButton("Long / 1000 ms");
		longSpinSpeed.addActionListener(e -> {
			cb.spinControllerSpeed(50);
		});

		// creates the new group of radio buttons
		ButtonGroup groupTwo = new ButtonGroup();
		groupTwo.add(quickSpinSpeed);
		groupTwo.add(shortSpinSpeed);
		groupTwo.add(defaultSpinSpeed);
		groupTwo.add(longSpinSpeed);

		// creates the new group of radio buttons
		ButtonGroup groupOne = new ButtonGroup();
		groupOne.add(quickSpin);
		groupOne.add(shortSpin);
		groupOne.add(defaultSpin);
		groupOne.add(longSpin);

		// creates the layout and design for Jdialog display below

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);

		titleLabelOne = new JLabel("| Number of Turns |");
		titleLabelTwo = new JLabel("|   Turn Delay    |");

		// setting bounds for radio buttons groupTwo

		quickSpinSpeed.setBounds(225, 100, 120, 20);
		shortSpinSpeed.setBounds(225, 125, 120, 20);
		defaultSpinSpeed.setBounds(225, 150, 120, 20);
		longSpinSpeed.setBounds(225, 175, 120, 20);

		// setting bounds for radio buttons groupOne

		quickSpin.setBounds(50, 100, 100, 20);
		shortSpin.setBounds(50, 125, 100, 20);
		defaultSpin.setBounds(50, 150, 100, 20);
		longSpin.setBounds(50, 175, 100, 20);

		// setting bounds for labels
		titleLabelTwo.setBounds(225, 50, 400, 20);
		titleLabelOne.setBounds(50, 50, 400, 20);

		// adding radio buttons groupOne
		insideFrameCenter.add(quickSpin);
		insideFrameCenter.add(shortSpin);
		insideFrameCenter.add(defaultSpin);
		insideFrameCenter.add(longSpin);

		// adding radio buttons groupTwo
		insideFrameCenter.add(quickSpinSpeed);
		insideFrameCenter.add(shortSpinSpeed);
		insideFrameCenter.add(defaultSpinSpeed);
		insideFrameCenter.add(longSpinSpeed);

		// setting value
		if (time == 50) {
			quickSpinSpeed.setSelected(true);
		} else if (time == 100) {
			shortSpinSpeed.setSelected(true);
		} else if (time == 250) {
			defaultSpinSpeed.setSelected(true);
		} else if (time == 1000) {
			longSpinSpeed.setSelected(true);
		}

		if (turns == 5) {
			quickSpin.setSelected(true);
		} else if (turns == 10) {
			shortSpin.setSelected(true);
		} else if (turns == 20) {
			defaultSpin.setSelected(true);
		} else if (turns == 50) {
			longSpin.setSelected(true);
		}

		// adding labels
		insideFrameCenter.add(titleLabelOne);
		insideFrameCenter.add(titleLabelTwo);

		insideFrame.add(buttonCancel, BorderLayout.CENTER);

		dialog.setLocationRelativeTo(null);
		dialog.setSize(400, 310);
		dialog.setVisible(true);

	}

}
