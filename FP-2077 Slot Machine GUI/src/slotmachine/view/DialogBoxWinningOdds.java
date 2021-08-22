package slotmachine.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DialogBoxWinningOdds extends JFrame {

	// class DialogBoxPlayer which extends Jframe

	// Declared variables used in the class
	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	private JLabel titleLabelOne;
	private JLabel titleLabelTwo;
	private JLabel titleLabelThree;
	private JLabel titleLabelFour;
	private JLabel titleLabelFive;
	private JLabel titleLabelSix;
	private JLabel titleLabelSeven;
	private JLabel titleLabelEight;
	private JLabel titleLabelNine;
	private JLabel titleLabelTen;
	private JLabel titleLabelEleven;
	private JLabel titleLabelTwelve;
	private JLabel titleLabelThirteen;
	private JLabel titleLabelFourteen;
	private JLabel titleLabelFifteen;
	private JLabel titleLabelSixteen;
	private JLabel titleLabelSeventeen;
	private JLabel titleLabelEightteen;
	private JLabel titleLabelNineteen;
	private JLabel titleLabelTwenty;
	private JLabel titleLabelTwentyone;
	private JLabel titleLabelTwentytwo;
	private JLabel titleLabelTwentythree;
	private JLabel titleLabelTwentyfour;
	private JLabel titleLabel;

	// constructs the object

	public DialogBoxWinningOdds(ImageIcon line1Image1, ImageIcon line1Image2, ImageIcon line1Image3,
			ImageIcon line2Image1, ImageIcon line2Image2, ImageIcon line2Image3, ImageIcon line3Image1,
			ImageIcon line3Image2, ImageIcon line3Image3, ImageIcon line4Image1, ImageIcon line4Image2,
			ImageIcon line4Image3, ImageIcon line5Image1, ImageIcon line5Image2, ImageIcon line5Image3,
			ImageIcon line6Image1, ImageIcon line6Image2, ImageIcon line6Image3) {

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

				DialogBoxWinningOdds.dialog.setVisible(false);
			}
		});

		// creates the layout and design for Jdialog display below

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);

		// adding JLabels
		titleLabel = new JLabel("Possible winning combos");
		titleLabelOne = new JLabel(line1Image1);
		titleLabelTwo = new JLabel(line1Image2);
		titleLabelThree = new JLabel(line1Image3);
		titleLabelFour = new JLabel("=  x4");
		/// --------
		titleLabelFive = new JLabel(line2Image1);
		titleLabelSix = new JLabel(line2Image2);
		titleLabelSeven = new JLabel(line2Image3);
		titleLabelEight = new JLabel("=  x1");
		/// --------
		titleLabelNine = new JLabel(line3Image1);
		titleLabelTen = new JLabel(line3Image2);
		titleLabelEleven = new JLabel(line3Image3);
		titleLabelTwelve = new JLabel("=  x3");
		/// --------
		titleLabelThirteen = new JLabel(line4Image1);
		titleLabelFourteen = new JLabel(line4Image2);
		titleLabelFifteen = new JLabel(line4Image3);
		titleLabelSixteen = new JLabel("=  x2");
		/// --------
		titleLabelSeventeen = new JLabel(line5Image1);
		titleLabelEightteen = new JLabel(line5Image2);
		titleLabelNineteen = new JLabel(line5Image3);
		titleLabelTwenty = new JLabel("=  x5");
		/// --------
		titleLabelTwentyone = new JLabel(line6Image1);
		titleLabelTwentytwo = new JLabel(line6Image2);
		titleLabelTwentythree = new JLabel(line6Image3);
		titleLabelTwentyfour = new JLabel("=  x4");

		// setting bounds for labels
		titleLabel.setBounds(25, 10, 200, 20);
		titleLabelTwo.setBounds(10, 50, 50, 20);
		titleLabelOne.setBounds(50, 50, 50, 20);
		titleLabelThree.setBounds(90, 50, 50, 20);
		titleLabelFour.setBounds(140, 50, 50, 20);
		//// --------
		titleLabelFive.setBounds(10, 90, 50, 20);
		titleLabelSix.setBounds(50, 90, 50, 20);
		titleLabelSeven.setBounds(90, 90, 50, 20);
		titleLabelEight.setBounds(140, 90, 50, 20);
		//// --------
		titleLabelNine.setBounds(10, 130, 50, 20);
		titleLabelTen.setBounds(50, 130, 50, 20);
		titleLabelEleven.setBounds(90, 130, 50, 20);
		titleLabelTwelve.setBounds(140, 130, 50, 20);
		//// --------
		titleLabelThirteen.setBounds(10, 170, 50, 20);
		titleLabelFourteen.setBounds(50, 170, 50, 20);
		titleLabelFifteen.setBounds(90, 170, 50, 20);
		titleLabelSixteen.setBounds(140, 170, 50, 20);
		//// --------
		titleLabelSeventeen.setBounds(10, 210, 50, 20);
		titleLabelEightteen.setBounds(50, 210, 50, 20);
		titleLabelNineteen.setBounds(90, 210, 50, 20);
		titleLabelTwenty.setBounds(140, 210, 50, 20);
		//// --------
		titleLabelTwentyone.setBounds(10, 250, 50, 20);
		titleLabelTwentytwo.setBounds(50, 250, 50, 20);
		titleLabelTwentythree.setBounds(90, 250, 50, 20);
		titleLabelTwentyfour.setBounds(140, 250, 50, 20);

		// adding labels
		insideFrameCenter.add(titleLabel);
		insideFrameCenter.add(titleLabelOne);
		insideFrameCenter.add(titleLabelTwo);
		insideFrameCenter.add(titleLabelThree);
		insideFrameCenter.add(titleLabelFour);
		//// -----
		insideFrameCenter.add(titleLabelFive);
		insideFrameCenter.add(titleLabelSix);
		insideFrameCenter.add(titleLabelSeven);
		insideFrameCenter.add(titleLabelEight);
		//// -----
		insideFrameCenter.add(titleLabelNine);
		insideFrameCenter.add(titleLabelTen);
		insideFrameCenter.add(titleLabelEleven);
		insideFrameCenter.add(titleLabelTwelve);
		//// -----
		insideFrameCenter.add(titleLabelThirteen);
		insideFrameCenter.add(titleLabelFourteen);
		insideFrameCenter.add(titleLabelFifteen);
		insideFrameCenter.add(titleLabelSixteen);
		//// -----
		insideFrameCenter.add(titleLabelSeventeen);
		insideFrameCenter.add(titleLabelEightteen);
		insideFrameCenter.add(titleLabelNineteen);
		insideFrameCenter.add(titleLabelTwenty);
		//// -----
		insideFrameCenter.add(titleLabelTwentyone);
		insideFrameCenter.add(titleLabelTwentytwo);
		insideFrameCenter.add(titleLabelTwentythree);
		insideFrameCenter.add(titleLabelTwentyfour);

		insideFrame.add(buttonCancel, BorderLayout.CENTER);

		dialog.setLocationRelativeTo(null);
		dialog.setSize(200, 380);
		dialog.setVisible(true);

	}

}