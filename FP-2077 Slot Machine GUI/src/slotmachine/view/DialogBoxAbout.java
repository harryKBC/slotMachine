package slotmachine.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DialogBoxAbout extends JFrame {

	// displays the about us dialog box

	// Declared variables
	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	// Constructs the dialogbox wit its corresponding components
	public DialogBoxAbout() {
		insideFrame = new JPanel();
		insideFrameCenter = new JPanel();
		insideFrameCenter.setLayout(new GridLayout(2, 2));

		dialog = new JDialog(this, "About Us", true);
		dialog.setLayout(new BorderLayout());

		JButton button = new JButton("Close");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DialogBoxAbout.dialog.setVisible(false);
			}
		});

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);
		dialog.setResizable(false);
		insideFrame.add(button, BorderLayout.CENTER);

		insideFrameCenter.add(new JLabel("Student Number: s3559087", SwingConstants.CENTER));
		insideFrameCenter.add(new JLabel("Student Name: Harrison Kinbacher", SwingConstants.CENTER));

		dialog.setLocationRelativeTo(null);
		dialog.setSize(300, 200);
		dialog.setVisible(true);

	}

}
