package slotmachine.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;
import slotmachine.model.slots.LineNum;

@SuppressWarnings("serial")

public class DialogBoxPlaceBet extends JFrame {

	// creates a dialog box using Jframe for create bet

	// Declared variables used in the dialog box display
	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	private JTextField bet1Text;
	private JTextField bet2Text;
	private JTextField bet3Text;
	private JTextField bet4Text;
	private JTextField bet5Text;

	private String betString1;
	private String betString2;
	private String betString3;
	private String betString4;
	private String betString5;

	int bet1;
	int bet2;
	int bet3;
	int bet4;
	int bet5;

	private ActionListener listener;

	// constructor which creates the dialog box

	public DialogBoxPlaceBet(SlotMachine model, CallBack cb) {

		// create the Jpanel and give it no set layout

		insideFrame = new JPanel();
		insideFrameCenter = new JPanel();
		insideFrameCenter.setLayout(null);

		listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int throwChecker = 0;
				int dialogBoxChecker = 0;

				betString1 = bet1Text.getText();
				betString2 = bet2Text.getText();
				betString3 = bet3Text.getText();
				betString4 = bet4Text.getText();
				betString5 = bet5Text.getText();

				try {
					// on submit closes the dialog box and sets the bets values to storage also
					// prints them for ease of use
					if (!betString1.equals("")) {
						try {

							bet1 = Integer.parseInt(bet1Text.getText());
							model.placeBet(bet1, LineNum.LINE1);

						} catch (Exception e) {

							if (throwChecker == 0) {
								throwChecker = 1;
								dialogBoxChecker = 1;
								if (e.toString() == "java.lang.NullPointerException") {
									JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
											JOptionPane.DEFAULT_OPTION);
								} else {
									JOptionPane.showConfirmDialog(null, e.getMessage(), "Error",
											JOptionPane.DEFAULT_OPTION);
								}
							}
						}
					}

					if (!betString2.equals("")) {
						try {
							bet2 = Integer.parseInt(bet2Text.getText());
							model.placeBet(bet2, LineNum.LINE2);

						} catch (Exception e) {
							if (throwChecker == 0) {
								throwChecker = 1;
								dialogBoxChecker = 1;
								if (e.toString() == "java.lang.NullPointerException") {
									JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
											JOptionPane.DEFAULT_OPTION);
								} else {
									JOptionPane.showConfirmDialog(null, e.getMessage(), "Error",
											JOptionPane.DEFAULT_OPTION);
								}
							}
						}
					}

					if (!betString3.equals("")) {
						try {
							bet3 = Integer.parseInt(bet3Text.getText());
							model.placeBet(bet3, LineNum.LINE3);

						} catch (Exception e) {
							if (throwChecker == 0) {
								throwChecker = 1;
								dialogBoxChecker = 1;
								if (e.toString() == "java.lang.NullPointerException") {
									JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
											JOptionPane.DEFAULT_OPTION);
								} else {
									JOptionPane.showConfirmDialog(null, e.getMessage(), "Error",
											JOptionPane.DEFAULT_OPTION);
								}
							}
						}
					}

					if (!betString4.equals("")) {
						try {
							bet4 = Integer.parseInt(bet4Text.getText());
							model.placeBet(bet4, LineNum.LINE4);

						} catch (Exception e) {
							if (throwChecker == 0) {
								throwChecker = 1;
								dialogBoxChecker = 1;
								if (e.toString() == "java.lang.NullPointerException") {
									JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
											JOptionPane.DEFAULT_OPTION);
								} else {
									JOptionPane.showConfirmDialog(null, e.getMessage(), "Error",
											JOptionPane.DEFAULT_OPTION);
								}
							}
						}
					}

					if (!betString5.equals("")) {
						try {
							bet5 = Integer.parseInt(bet5Text.getText());
							model.placeBet(bet5, LineNum.LINE5);

						} catch (Exception e) {
							if (throwChecker == 0) {
								throwChecker = 1;
								dialogBoxChecker = 1;
								if (e.toString() == "java.lang.NullPointerException") {
									JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
											JOptionPane.DEFAULT_OPTION);
								} else {
									JOptionPane.showConfirmDialog(null, e.getMessage(), "Error",
											JOptionPane.DEFAULT_OPTION);
								}
							}
						}
					}

					// allows dialog box to reopen
					if (dialogBoxChecker == 1) {
						throw new IllegalArgumentException();
					}

					// removes dialog box
					DialogBoxPlaceBet.dialog.setVisible(false);

				} catch (Exception e) {

				}
			}
		};

		// create a Jdialog from the panel object

		dialog = new JDialog(this, "Place Bet", true);
		dialog.setLayout(new BorderLayout());
		dialog.setResizable(false);

		// create the button objects and name them

		JButton buttonCancel = new JButton("Cancel");
		JButton buttonEnter = new JButton(" Enter ");

		try {
			buttonEnter.addActionListener(listener);
		} catch (Exception e) {
			buttonEnter.addActionListener(listener);
		}

		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DialogBoxPlaceBet.dialog.setVisible(false);
			}
		});

		// add the event listeners to the buttons which just prints output atm.

		// create the structure for the inside of the dialog box

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);
		insideFrame.add(buttonCancel, BorderLayout.CENTER);
		insideFrame.add(buttonEnter, BorderLayout.CENTER);

		// below all of the labels and text fields are added and set to their correct
		// placement inside the box

		JLabel line1 = new JLabel("Line 1:");
		line1.setBounds(10, 20, 80, 25);
		insideFrameCenter.add(line1);

		bet1Text = new JTextField(5);
		bet1Text.setBounds(100, 20, 165, 25);
		insideFrameCenter.add(bet1Text);

		JLabel line2 = new JLabel("Line 2:");
		line2.setBounds(10, 60, 80, 25);
		insideFrameCenter.add(line2);

		bet2Text = new JTextField(5);
		bet2Text.setBounds(100, 60, 165, 25);
		insideFrameCenter.add(bet2Text);

		JLabel line3 = new JLabel("Line 3:");
		line3.setBounds(10, 100, 80, 25);
		insideFrameCenter.add(line3);

		bet3Text = new JTextField(5);
		bet3Text.setBounds(100, 100, 165, 25);
		insideFrameCenter.add(bet3Text);

		JLabel line4 = new JLabel("Line 4:");
		line4.setBounds(10, 140, 80, 25);
		insideFrameCenter.add(line4);

		bet4Text = new JTextField(5);
		bet4Text.setBounds(100, 140, 165, 25);
		insideFrameCenter.add(bet4Text);

		JLabel line5 = new JLabel("Line 5:");
		line5.setBounds(10, 180, 80, 25);
		insideFrameCenter.add(line5);

		bet5Text = new JTextField(5);
		bet5Text.setBounds(100, 180, 165, 25);
		insideFrameCenter.add(bet5Text);

		dialog.setLocationRelativeTo(null);
		dialog.setSize(300, 300);
		dialog.setVisible(true);

	}

}