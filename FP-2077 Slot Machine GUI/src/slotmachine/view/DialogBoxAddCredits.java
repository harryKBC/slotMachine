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

import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class DialogBoxAddCredits extends JFrame {

	// class DialogBoxPlayer which extends Jframe

	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	private JTextField creditsText;

	private ActionListener listener;
	// constructs the object

	public DialogBoxAddCredits(SlotMachine model) {

		// okay button event listener made into variable.
		listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					int credits = Integer.parseInt(creditsText.getText());
					model.addCredits(credits);

					DialogBoxAddCredits.dialog.setVisible(false);
				} catch (Exception e) {
					if (e.toString() == "java.lang.NullPointerException") {
						JOptionPane.showConfirmDialog(null, "Please register a player", "Error",
								JOptionPane.DEFAULT_OPTION);
					} else {
						JOptionPane.showConfirmDialog(null, e.getMessage(), "Error", JOptionPane.DEFAULT_OPTION);
					}

				}
			}
		};

		// set inside panels

		insideFrame = new JPanel();
		insideFrameCenter = new JPanel();
		insideFrameCenter.setLayout(null);

		// set this panel as a JDialog and give it a borderlayout

		dialog = new JDialog(this, "Add Credits", true);
		dialog.setLayout(new BorderLayout());
		dialog.setResizable(false);

		// create the Buttons and name them in the JButton constructor

		JButton buttonCancel = new JButton("Cancel");
		JButton buttonEnter = new JButton(" Enter ");

		// add the event listeners to the buttons which just prints output atm.

		try {
			buttonEnter.addActionListener(listener);
		} catch (Exception e) {
			buttonEnter.addActionListener(listener);
		}

		// close event for button
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				DialogBoxAddCredits.dialog.setVisible(false);
			}
		});

		// creates the layout and design for Jdialog display below

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);
		insideFrame.add(buttonCancel, BorderLayout.CENTER);
		insideFrame.add(buttonEnter, BorderLayout.CENTER);

		JLabel credits = new JLabel("Enter Credits:");
		credits.setBounds(10, 35, 80, 25);
		insideFrameCenter.add(credits);

		creditsText = new JTextField(5);
		creditsText.setBounds(100, 35, 165, 25);
		insideFrameCenter.add(creditsText);

		dialog.setLocationRelativeTo(null);
		dialog.setSize(300, 160);
		dialog.setVisible(true);

	}

}