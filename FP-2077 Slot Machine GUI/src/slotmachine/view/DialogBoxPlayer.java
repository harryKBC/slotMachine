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
public class DialogBoxPlayer extends JFrame {

	// class DialogBoxPlayer which extends Jframe

	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	private JTextField idText;
	private JTextField nameText;
	private JTextField creditsText;
	private int credits;
	private int counter;

	private ActionListener listener;
	// constructs the object

	public DialogBoxPlayer(SlotMachine model) {

		// okay button event listener made into variable.
		listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					counter = 0;
					String id = idText.getText();
					String name = nameText.getText();
					try {
						credits = Integer.parseInt(creditsText.getText());
					} catch (Exception e) {
						counter = 1;
						JOptionPane.showConfirmDialog(null, "data must be entered and credits input as an int", "Error",
								JOptionPane.DEFAULT_OPTION);
						throw new IllegalStateException();
					}
					model.registerPlayer(id, name, credits);
					DialogBoxPlayer.dialog.setVisible(false);

				} catch (Exception e) {
					if (counter == 0) {
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

		dialog = new JDialog(this, "Add Player", true);
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

				DialogBoxPlayer.dialog.setVisible(false);
			}
		});

		// creates the layout and design for Jdialog display below

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);
		insideFrame.add(buttonCancel, BorderLayout.CENTER);
		insideFrame.add(buttonEnter, BorderLayout.CENTER);

		JLabel id = new JLabel("Enter ID:");
		id.setBounds(10, 20, 80, 25);
		insideFrameCenter.add(id);

		idText = new JTextField(5);
		idText.setBounds(100, 20, 165, 25);
		insideFrameCenter.add(idText);

		JLabel name = new JLabel("Enter Name:");
		name.setBounds(10, 60, 80, 25);
		insideFrameCenter.add(name);

		nameText = new JTextField(5);
		nameText.setBounds(100, 60, 165, 25);
		insideFrameCenter.add(nameText);

		JLabel credits = new JLabel("Enter Credits:");
		credits.setBounds(10, 100, 80, 25);
		insideFrameCenter.add(credits);

		creditsText = new JTextField(5);
		creditsText.setBounds(100, 100, 165, 25);
		insideFrameCenter.add(creditsText);

		dialog.setLocationRelativeTo(null);
		dialog.setSize(300, 220);
		dialog.setVisible(true);

	}

}
