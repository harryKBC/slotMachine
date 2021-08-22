package slotmachine.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class DialogBoxPreviousPlayerInfo extends JFrame implements PropertyChangeListener {

	// class DialogBoxPlayer which extends Jframe

	private static JDialog dialog;
	private JPanel insideFrame;
	private JPanel insideFrameCenter;

	// Declaring win amount labels
	private JLabel titleWinAmountLabelOne;
	private JLabel titleWinAmountLabelTwo;
	private JLabel titleWinAmountLabelThree;
	private JLabel titleWinAmountLabelFour;
	private JLabel titleWinAmountLabelFive;
	private JLabel titleWinAmountLabelSix;
	private JLabel titleWinAmountLabelSeven;
	private JLabel titleWinAmountLabelEight;
	private JLabel titleWinAmountLabelNine;
	private JLabel titleWinAmountLabelTen;
	private JLabel titleWinAmountLabelEleven;
	private JLabel titleWinWinAmountLabelTwelve;
	private JLabel titleWininAmountLabelThirteen;
	private JLabel titleWinAmountLabelFourteen;
	private JLabel titleWinAmountLabelFifteen;

	// Declaring win labels
	private JLabel titleWinLabelOne;
	private JLabel titleWinLabelTwo;
	private JLabel titleWinLabelThree;
	private JLabel titleWinLabelFour;
	private JLabel titleWinLabelFive;
	private JLabel titleWinLabelSix;
	private JLabel titleWinLabelSeven;
	private JLabel titleWinLabelEight;
	private JLabel titleWinLabelNine;
	private JLabel titleWinLabelTen;
	private JLabel titleWinLabelEleven;
	private JLabel titleWinWinLabelTwelve;
	private JLabel titleWininLabelThirteen;
	private JLabel titleWinLabelFourteen;
	private JLabel titleWinLabelFifteen;

	// Declaring images
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
	private JLabel titleLabelTwenty;
	private JLabel titleLabelTwentyone;
	private JLabel titleLabelTwentytwo;
	private JLabel titleLabelTwentythree;
	private JLabel titleLabelTwentyfour;
	private JLabel titleLabelTwentyFive;
	private JLabel titleLabelTwentySix;
	private JLabel titleLabelTwentySeven;
	private JLabel titleLabelTwentyEight;
	private JLabel titleLabel;
	private JLabel titleLabelSecond;
	private JLabel titleLabelThird;

	// constructs the object

	public DialogBoxPreviousPlayerInfo(SlotMachine model, CallBack cb, ImageIcon spinOneImage1, ImageIcon spinOneImage2,
			ImageIcon spinOneImage3, ImageIcon spinOneImage4, ImageIcon spinOneImage5, ImageIcon spinOneImage6,
			ImageIcon spinOneImage7, ImageIcon spinOneImage8, ImageIcon spinOneImage9, ImageIcon spinTwoImage1,
			ImageIcon spinTwoImage2, ImageIcon spinTwoImage3, ImageIcon spinTwoImage4, ImageIcon spinTwoImage5,
			ImageIcon spinTwoImage6, ImageIcon spinTwoImage7, ImageIcon spinTwoImage8, ImageIcon spinTwoImage9,
			ImageIcon spinThreeImage1, ImageIcon spinThreeImage2, ImageIcon spinThreeImage3, ImageIcon spinThreeImage4,
			ImageIcon spinThreeImage5, ImageIcon spinThreeImage6, ImageIcon spinThreeImage7, ImageIcon spinThreeImage8,
			ImageIcon spinThreeImage9, String line1lastWinChecker, String line2lastWinChecker,
			String line3lastWinChecker, String line4lastWinChecker, String line5lastWinChecker,
			String line1SecondlastWinChecker, String line2SecondlastWinChecker, String line3SecondlastWinChecker,
			String line4SecondlastWinChecker, String line5SecondlastWinChecker, String line1ThirdlastWinChecker,
			String line2ThirdlastWinChecker, String line3ThirdlastWinChecker, String line4ThirdlastWinChecker,
			String line5ThirdlastWinChecker, Boolean line1lastBetPlaced, Boolean line2lastBetPlaced,
			Boolean line3lastBetPlaced, Boolean line4lastBetPlaced, Boolean line5lastBetPlaced,
			Boolean line1SecondlastBetPlaced, Boolean line2SecondlastBetPlaced, Boolean line3SecondlastBetPlaced,
			Boolean line4SecondlastBetPlaced, Boolean line5SecondlastBetPlaced, Boolean line1ThirdlastBetPlaced,
			Boolean line2ThirdlastBetPlaced, Boolean line3ThirdlastBetPlaced, Boolean line4ThirdlastBetPlaced,
			Boolean line5ThirdlastBetPlaced) {

		cb.addPropertyChangeListener(this);

		// set inside panels

		insideFrame = new JPanel();
		insideFrameCenter = new JPanel();
		insideFrameCenter.setLayout(null);

		// set this panel as a JDialog and give it a borderlayout

		dialog = new JDialog(this, "Previous Spins On Machine", true);
		dialog.setLayout(new BorderLayout());
		dialog.setResizable(false);

		// create the Buttons and name them in the JButton constructor

		JButton buttonCancel = new JButton("Close");

		// add the event listeners to the buttons which just prints output atm.

		// close event for button
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				DialogBoxPreviousPlayerInfo.dialog.setVisible(false);
			}
		});

		// creates the layout and design for Jdialog display below

		dialog.add(insideFrame, BorderLayout.SOUTH);
		dialog.add(insideFrameCenter, BorderLayout.CENTER);
		insideFrame.add(buttonCancel, BorderLayout.CENTER);

		// adding lables images
		titleLabel = new JLabel("last spin 1");
		titleLabelOne = new JLabel();
		titleLabelTwo = new JLabel();
		titleLabelThree = new JLabel();
		titleLabelFour = new JLabel();
		titleLabelFive = new JLabel();
		titleLabelSix = new JLabel();
		titleLabelSeven = new JLabel();
		titleLabelEight = new JLabel();
		titleLabelNine = new JLabel();

		titleLabelOne.setIcon(spinOneImage9);
		titleLabelTwo.setIcon(spinOneImage3);
		titleLabelThree.setIcon(spinOneImage6);
		titleLabelFour.setIcon(spinOneImage2);
		titleLabelFive.setIcon(spinOneImage5);
		titleLabelSix.setIcon(spinOneImage8);
		titleLabelSeven.setIcon(spinOneImage1);
		titleLabelEight.setIcon(spinOneImage4);
		titleLabelNine.setIcon(spinOneImage7);

		//// ------

		titleLabelSecond = new JLabel("last spin 2");
		titleLabelTen = new JLabel();
		titleLabelEleven = new JLabel();
		titleLabelTwelve = new JLabel();
		titleLabelThirteen = new JLabel();
		titleLabelFourteen = new JLabel();
		titleLabelFifteen = new JLabel();
		titleLabelSixteen = new JLabel();
		titleLabelSeventeen = new JLabel();
		titleLabelEightteen = new JLabel();

		titleLabelTen.setIcon(spinTwoImage9);
		titleLabelEleven.setIcon(spinTwoImage3);
		titleLabelTwelve.setIcon(spinTwoImage6);
		titleLabelThirteen.setIcon(spinTwoImage2);
		titleLabelFourteen.setIcon(spinTwoImage5);
		titleLabelFifteen.setIcon(spinTwoImage8);
		titleLabelSixteen.setIcon(spinTwoImage1);
		titleLabelSeventeen.setIcon(spinTwoImage4);
		titleLabelEightteen.setIcon(spinTwoImage7);

		/// --------

		titleLabelThird = new JLabel("last spin 3");
		titleLabelTwenty = new JLabel();
		titleLabelTwentyone = new JLabel();
		titleLabelTwentytwo = new JLabel();
		titleLabelTwentythree = new JLabel();
		titleLabelTwentyfour = new JLabel();
		titleLabelTwentyFive = new JLabel();
		titleLabelTwentySix = new JLabel();
		titleLabelTwentySeven = new JLabel();
		titleLabelTwentyEight = new JLabel();

		titleLabelTwenty.setIcon(spinThreeImage9);
		titleLabelTwentyone.setIcon(spinThreeImage3);
		titleLabelTwentytwo.setIcon(spinThreeImage6);
		titleLabelTwentythree.setIcon(spinThreeImage2);
		titleLabelTwentyfour.setIcon(spinThreeImage5);
		titleLabelTwentyFive.setIcon(spinThreeImage8);
		titleLabelTwentySix.setIcon(spinThreeImage1);
		titleLabelTwentySeven.setIcon(spinThreeImage4);
		titleLabelTwentyEight.setIcon(spinThreeImage7);

		// setting bounds images
		titleLabel.setBounds(290, 10, 100, 20);
		titleLabelOne.setBounds(10, 50, 50, 50);
		titleLabelTwo.setBounds(150, 50, 50, 50);
		titleLabelThree.setBounds(80, 50, 50, 50);
		titleLabelFour.setBounds(150, 120, 50, 50);
		titleLabelFive.setBounds(80, 120, 50, 50);
		titleLabelSix.setBounds(10, 120, 50, 50);
		titleLabelSeven.setBounds(150, 190, 50, 50);
		titleLabelEight.setBounds(80, 190, 50, 50);
		titleLabelNine.setBounds(10, 190, 50, 50);

		////// -----------
		titleLabelSecond.setBounds(290, 250, 100, 50);
		titleLabelTen.setBounds(10, 290, 50, 50);
		titleLabelEleven.setBounds(150, 290, 50, 50);
		titleLabelTwelve.setBounds(80, 290, 50, 50);
		titleLabelThirteen.setBounds(150, 350, 50, 50);
		titleLabelFourteen.setBounds(80, 350, 50, 50);
		titleLabelFifteen.setBounds(10, 350, 50, 50);
		titleLabelSixteen.setBounds(150, 420, 50, 50);
		titleLabelSeventeen.setBounds(80, 420, 50, 50);
		titleLabelEightteen.setBounds(10, 420, 50, 50);

		//// ----------
		titleLabelThird.setBounds(290, 490, 100, 50);
		titleLabelTwenty.setBounds(10, 530, 50, 50);
		titleLabelTwentyone.setBounds(150, 530, 50, 50);
		titleLabelTwentytwo.setBounds(80, 530, 50, 50);
		titleLabelTwentythree.setBounds(150, 600, 50, 50);
		titleLabelTwentyfour.setBounds(80, 600, 50, 50);
		titleLabelTwentyFive.setBounds(10, 600, 50, 50);
		titleLabelTwentySix.setBounds(150, 670, 50, 50);
		titleLabelTwentySeven.setBounds(80, 670, 50, 50);
		titleLabelTwentyEight.setBounds(10, 670, 50, 50);

		// adding win labels

		titleWinLabelOne = new JLabel("Bet placed line 1: " + Boolean.toString(line1lastBetPlaced));
		titleWinLabelTwo = new JLabel("Bet placed line 2: " + Boolean.toString(line2lastBetPlaced));
		titleWinLabelThree = new JLabel("Bet placed line 3: " + Boolean.toString(line3lastBetPlaced));
		titleWinLabelFour = new JLabel("Bet placed line 4: " + Boolean.toString(line4lastBetPlaced));
		titleWinLabelFive = new JLabel("Bet placed line 5: " + Boolean.toString(line5lastBetPlaced));

		//// -------

		titleWinLabelSix = new JLabel("Bet placed line 1: " + Boolean.toString(line1SecondlastBetPlaced));
		titleWinLabelSeven = new JLabel("Bet placed line 2: " + Boolean.toString(line2SecondlastBetPlaced));
		titleWinLabelEight = new JLabel("Bet placed line 3: " + Boolean.toString(line3SecondlastBetPlaced));
		titleWinLabelNine = new JLabel("Bet placed line 4: " + Boolean.toString(line4SecondlastBetPlaced));
		titleWinLabelTen = new JLabel("Bet placed line 5: " + Boolean.toString(line5SecondlastBetPlaced));

		/// ------

		titleWinLabelEleven = new JLabel("Bet placed line 1: " + Boolean.toString(line1ThirdlastBetPlaced));
		titleWinWinLabelTwelve = new JLabel("Bet placed line 2: " + Boolean.toString(line1ThirdlastBetPlaced));
		titleWininLabelThirteen = new JLabel("Bet placed line 3: " + Boolean.toString(line1ThirdlastBetPlaced));
		titleWinLabelFourteen = new JLabel("Bet placed line 4: " + Boolean.toString(line1ThirdlastBetPlaced));
		titleWinLabelFifteen = new JLabel("Bet placed line 5: " + Boolean.toString(line1ThirdlastBetPlaced));

		// adding win Amount labels

		titleWinAmountLabelOne = new JLabel("Amount won on line 1: " + line1lastWinChecker);
		titleWinAmountLabelTwo = new JLabel("Amount won on line 2: " + line2lastWinChecker);
		titleWinAmountLabelThree = new JLabel("Amount won on line 3: " + line3lastWinChecker);
		titleWinAmountLabelFour = new JLabel("Amount won on line 4: " + line4lastWinChecker);
		titleWinAmountLabelFive = new JLabel("Amount won on line 5: " + line5lastWinChecker);

		//// -------

		titleWinAmountLabelSix = new JLabel("Amount won on line 1: " + line1SecondlastWinChecker);
		titleWinAmountLabelSeven = new JLabel("Amount won on line 2: " + line2SecondlastWinChecker);
		titleWinAmountLabelEight = new JLabel("Amount won on line 3: " + line3SecondlastWinChecker);
		titleWinAmountLabelNine = new JLabel("Amount won on line 4: " + line4SecondlastWinChecker);
		titleWinAmountLabelTen = new JLabel("Amount won on line 5: " + line5SecondlastWinChecker);

		/// ------

		titleWinAmountLabelEleven = new JLabel("Amount won on line 1: " + line1ThirdlastWinChecker);
		titleWinWinAmountLabelTwelve = new JLabel("Amount won on line 2: " + line2ThirdlastWinChecker);
		titleWininAmountLabelThirteen = new JLabel("Amount won on line 3: " + line3ThirdlastWinChecker);
		titleWinAmountLabelFourteen = new JLabel("Amount won on line 4: " + line4ThirdlastWinChecker);
		titleWinAmountLabelFifteen = new JLabel("Amount won on line 5: " + line5ThirdlastWinChecker);

		// setting bounds Bet Win checkers

		titleWinAmountLabelOne.setBounds(425, 80, 200, 50);
		titleWinAmountLabelTwo.setBounds(425, 100, 200, 50);
		titleWinAmountLabelThree.setBounds(425, 120, 200, 50);
		titleWinAmountLabelFour.setBounds(425, 140, 200, 50);
		titleWinAmountLabelFive.setBounds(425, 160, 200, 50);

		/// ------

		titleWinAmountLabelSix.setBounds(425, 340, 200, 50);
		titleWinAmountLabelSeven.setBounds(425, 360, 200, 50);
		titleWinAmountLabelEight.setBounds(425, 380, 200, 50);
		titleWinAmountLabelNine.setBounds(425, 400, 200, 50);
		titleWinAmountLabelTen.setBounds(425, 420, 200, 50);

		/// ------

		titleWinAmountLabelEleven.setBounds(425, 560, 200, 50);
		titleWinWinAmountLabelTwelve.setBounds(425, 580, 200, 50);
		titleWininAmountLabelThirteen.setBounds(425, 600, 200, 50);
		titleWinAmountLabelFourteen.setBounds(425, 620, 200, 50);
		titleWinAmountLabelFifteen.setBounds(425, 640, 200, 50);

		// setting bounds Bet checkers
		titleWinLabelOne.setBounds(250, 80, 200, 50);
		titleWinLabelTwo.setBounds(250, 100, 200, 50);
		titleWinLabelThree.setBounds(250, 120, 200, 50);
		titleWinLabelFour.setBounds(250, 140, 200, 50);
		titleWinLabelFive.setBounds(250, 160, 200, 50);

		/// ------

		titleWinLabelSix.setBounds(250, 340, 200, 50);
		titleWinLabelSeven.setBounds(250, 360, 200, 50);
		titleWinLabelEight.setBounds(250, 380, 200, 50);
		titleWinLabelNine.setBounds(250, 400, 200, 50);
		titleWinLabelTen.setBounds(250, 420, 200, 50);

		/// ------

		titleWinLabelEleven.setBounds(250, 560, 200, 50);
		titleWinWinLabelTwelve.setBounds(250, 580, 200, 50);
		titleWininLabelThirteen.setBounds(250, 600, 200, 50);
		titleWinLabelFourteen.setBounds(250, 620, 200, 50);
		titleWinLabelFifteen.setBounds(250, 640, 200, 50);

		// adding lables to screen

		insideFrameCenter.add(titleWinAmountLabelOne);
		insideFrameCenter.add(titleWinAmountLabelTwo);
		insideFrameCenter.add(titleWinAmountLabelThree);
		insideFrameCenter.add(titleWinAmountLabelFour);
		insideFrameCenter.add(titleWinAmountLabelFive);

		insideFrameCenter.add(titleWinAmountLabelSix);
		insideFrameCenter.add(titleWinAmountLabelSeven);
		insideFrameCenter.add(titleWinAmountLabelEight);
		insideFrameCenter.add(titleWinAmountLabelNine);
		insideFrameCenter.add(titleWinAmountLabelTen);

		insideFrameCenter.add(titleWinAmountLabelEleven);
		insideFrameCenter.add(titleWinWinAmountLabelTwelve);
		insideFrameCenter.add(titleWininAmountLabelThirteen);
		insideFrameCenter.add(titleWinAmountLabelFourteen);
		insideFrameCenter.add(titleWinAmountLabelFifteen);

		insideFrameCenter.add(titleWinLabelOne);
		insideFrameCenter.add(titleWinLabelTwo);
		insideFrameCenter.add(titleWinLabelThree);
		insideFrameCenter.add(titleWinLabelFour);
		insideFrameCenter.add(titleWinLabelFive);

		insideFrameCenter.add(titleWinLabelSix);
		insideFrameCenter.add(titleWinLabelSeven);
		insideFrameCenter.add(titleWinLabelEight);
		insideFrameCenter.add(titleWinLabelNine);
		insideFrameCenter.add(titleWinLabelTen);

		insideFrameCenter.add(titleWinLabelEleven);
		insideFrameCenter.add(titleWinWinLabelTwelve);
		insideFrameCenter.add(titleWininLabelThirteen);
		insideFrameCenter.add(titleWinLabelFourteen);
		insideFrameCenter.add(titleWinLabelFifteen);

		insideFrameCenter.add(titleLabel);
		insideFrameCenter.add(titleLabelOne);
		insideFrameCenter.add(titleLabelTwo);
		insideFrameCenter.add(titleLabelThree);
		insideFrameCenter.add(titleLabelFour);
		insideFrameCenter.add(titleLabelFive);
		insideFrameCenter.add(titleLabelSix);
		insideFrameCenter.add(titleLabelSeven);
		insideFrameCenter.add(titleLabelEight);
		insideFrameCenter.add(titleLabelNine);
		insideFrameCenter.add(titleLabelSecond);
		insideFrameCenter.add(titleLabelTen);
		insideFrameCenter.add(titleLabelEleven);
		insideFrameCenter.add(titleLabelTwelve);
		insideFrameCenter.add(titleLabelThirteen);
		insideFrameCenter.add(titleLabelFourteen);
		insideFrameCenter.add(titleLabelFifteen);
		insideFrameCenter.add(titleLabelSixteen);
		insideFrameCenter.add(titleLabelSeventeen);
		insideFrameCenter.add(titleLabelEightteen);

		insideFrameCenter.add(titleLabelThird);
		insideFrameCenter.add(titleLabelTwenty);
		insideFrameCenter.add(titleLabelTwentyone);
		insideFrameCenter.add(titleLabelTwentytwo);
		insideFrameCenter.add(titleLabelTwentythree);
		insideFrameCenter.add(titleLabelTwentyfour);
		insideFrameCenter.add(titleLabelTwentyFive);
		insideFrameCenter.add(titleLabelTwentySix);
		insideFrameCenter.add(titleLabelTwentySeven);
		insideFrameCenter.add(titleLabelTwentyEight);

		///// -------

		dialog.setLocationRelativeTo(null);
		dialog.setSize(650, 820);
		dialog.setVisible(true);

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}

}
