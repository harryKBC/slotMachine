package slotmachine.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class DialogBoxSpinResults extends JFrame {

	// to impliment this class to display the spin results in a JLabel I modified my
	// SpinResultsImpl inserting
	// HTML tags which are required for the JLabel to move to a new line.

	// Declared variables used in the dialog box
	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	JLabel lineOne;
	JLabel lineTwo;
	JLabel lineThree;
	JLabel lineFour;
	JLabel lineFive;

	// constructs and displays the dialogbox and its contents
	public DialogBoxSpinResults(SlotMachine model, String result1, String result2, String result3, String result4,
			String result5, String amountWon1, String amountWon2, String amountWon3, String amountWon4,
			String amountWon5) {

		insideFrame = new JPanel();
		insideFrameCenter = new JPanel();
		insideFrameCenter.setLayout(null);

		dialog = new JDialog(this, "Spin Results", true);
		dialog.setLayout(new BorderLayout());
		dialog.setResizable(false);

		JButton button = new JButton("Close");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DialogBoxSpinResults.dialog.setVisible(false);
			}
		});

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);
		insideFrame.add(button, BorderLayout.CENTER);

		// adding the results to the label
		lineOne = new JLabel((result1) + (" amount won: ") + (amountWon1));
		lineTwo = new JLabel((result2) + (" amount won: ") + (amountWon2));
		lineThree = new JLabel((result3) + (" amount won: ") + (amountWon3));
		lineFour = new JLabel((result4) + (" amount won: ") + (amountWon4));
		lineFive = new JLabel((result5) + (" amount won: ") + (amountWon5));

		// setting the location for the label
		lineOne.setBounds(70, 35, 400, 25);
		lineTwo.setBounds(70, 35, 400, 75);
		lineThree.setBounds(70, 35, 400, 125);
		lineFour.setBounds(70, 35, 400, 175);
		lineFive.setBounds(70, 35, 400, 225);

		// adding the labels to the panel
		insideFrameCenter.add(lineOne);
		insideFrameCenter.add(lineTwo, BorderLayout.CENTER);
		insideFrameCenter.add(lineThree, BorderLayout.CENTER);
		insideFrameCenter.add(lineFour, BorderLayout.CENTER);
		insideFrameCenter.add(lineFive, BorderLayout.CENTER);

		dialog.setLocationRelativeTo(null);
		dialog.setSize(500, 270);
		dialog.setVisible(true);

	}

}
