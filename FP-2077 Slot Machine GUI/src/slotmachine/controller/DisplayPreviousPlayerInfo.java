package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;

import slotmachine.model.SlotMachine;
import slotmachine.view.DialogBoxPreviousPlayerInfo;

public class DisplayPreviousPlayerInfo implements ActionListener, PropertyChangeListener {

	// event which runs DialogBoxPlayer allows us to split up the actionPerformed
	// and gives more flexibility with the class.
	// @Override
	SlotMachine model;
	CallBack cb;
	int counterImage;
	int counterSpin;

	// win amounts
	String line1lastWinChecker;
	String line2lastWinChecker;
	String line3lastWinChecker;
	String line4lastWinChecker;
	String line5lastWinChecker;

	String line1SecondlastWinChecker;
	String line2SecondlastWinChecker;
	String line3SecondlastWinChecker;
	String line4SecondlastWinChecker;
	String line5SecondlastWinChecker;

	String line1ThirdlastWinChecker;
	String line2ThirdlastWinChecker;
	String line3ThirdlastWinChecker;
	String line4ThirdlastWinChecker;
	String line5ThirdlastWinChecker;

	// bets placed
	Boolean line1lastBetPlaced;
	Boolean line2lastBetPlaced;
	Boolean line3lastBetPlaced;
	Boolean line4lastBetPlaced;
	Boolean line5lastBetPlaced;

	Boolean line1SecondlastBetPlaced;
	Boolean line2SecondlastBetPlaced;
	Boolean line3SecondlastBetPlaced;
	Boolean line4SecondlastBetPlaced;
	Boolean line5SecondlastBetPlaced;

	Boolean line1ThirdlastBetPlaced;
	Boolean line2ThirdlastBetPlaced;
	Boolean line3ThirdlastBetPlaced;
	Boolean line4ThirdlastBetPlaced;
	Boolean line5ThirdlastBetPlaced;

	// images
	private ImageIcon spinOneImage1;
	private ImageIcon spinOneImage2;
	private ImageIcon spinOneImage3;

	private ImageIcon spinOneImage4;
	private ImageIcon spinOneImage5;
	private ImageIcon spinOneImage6;

	private ImageIcon spinOneImage7;
	private ImageIcon spinOneImage8;
	private ImageIcon spinOneImage9;

	private ImageIcon spinTwoImage1;
	private ImageIcon spinTwoImage2;
	private ImageIcon spinTwoImage3;

	private ImageIcon spinTwoImage4;
	private ImageIcon spinTwoImage5;
	private ImageIcon spinTwoImage6;

	private ImageIcon spinTwoImage7;
	private ImageIcon spinTwoImage8;
	private ImageIcon spinTwoImage9;

	private ImageIcon spinThreeImage1;
	private ImageIcon spinThreeImage2;
	private ImageIcon spinThreeImage3;

	private ImageIcon spinThreeImage4;
	private ImageIcon spinThreeImage5;
	private ImageIcon spinThreeImage6;

	private ImageIcon spinThreeImage7;
	private ImageIcon spinThreeImage8;
	private ImageIcon spinThreeImage9;

	public DisplayPreviousPlayerInfo(SlotMachine model, CallBack cb) {
		counterImage = 1;
		counterSpin = 1;
		cb.addPropertyChangeListener(this);
		this.model = model;
		this.cb = cb;

		line1lastBetPlaced = false;
		line2lastBetPlaced = false;
		line3lastBetPlaced = false;
		line4lastBetPlaced = false;
		line5lastBetPlaced = false;

		line1SecondlastBetPlaced = false;
		line2SecondlastBetPlaced = false;
		line3SecondlastBetPlaced = false;
		line4SecondlastBetPlaced = false;
		line5SecondlastBetPlaced = false;

		line1ThirdlastBetPlaced = false;
		line2ThirdlastBetPlaced = false;
		line3ThirdlastBetPlaced = false;
		line4ThirdlastBetPlaced = false;
		line5ThirdlastBetPlaced = false;

		// setting all value holders to negative numbers as the bets will never return a
		// number below 0

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new DialogBoxPreviousPlayerInfo(model, cb, spinOneImage1, spinOneImage2, spinOneImage3, spinOneImage4,
				spinOneImage5, spinOneImage6, spinOneImage7, spinOneImage8, spinOneImage9, spinTwoImage1, spinTwoImage2,
				spinTwoImage3, spinTwoImage4, spinTwoImage5, spinTwoImage6, spinTwoImage7, spinTwoImage8, spinTwoImage9,
				spinThreeImage1, spinThreeImage2, spinThreeImage3, spinThreeImage4, spinThreeImage5, spinThreeImage6,
				spinThreeImage7, spinThreeImage8, spinThreeImage9, /* --- */ line1lastWinChecker, line2lastWinChecker,
				line3lastWinChecker, line4lastWinChecker, line5lastWinChecker, line1SecondlastWinChecker,
				line2SecondlastWinChecker, line3SecondlastWinChecker, line4SecondlastWinChecker,
				line5SecondlastWinChecker, line1ThirdlastWinChecker, line2ThirdlastWinChecker, line3ThirdlastWinChecker,
				line4ThirdlastWinChecker, line5ThirdlastWinChecker /*---*/, line1lastBetPlaced, line2lastBetPlaced,
				line3lastBetPlaced, line4lastBetPlaced, line5lastBetPlaced, line1SecondlastBetPlaced,
				line2SecondlastBetPlaced, line3SecondlastBetPlaced, line4SecondlastBetPlaced, line5SecondlastBetPlaced,
				line1ThirdlastBetPlaced, line2ThirdlastBetPlaced, line3ThirdlastBetPlaced, line4ThirdlastBetPlaced,
				line5ThirdlastBetPlaced);

	}

	// adding the lines bets have been placed on to the place holders resetting at 3
	// spins
	// the propertyChange implements a counter which allows the function to know
	// which spin it is out out of 3 to be moved in to
	// the dialogbox for display
	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (counterImage <= 9) {

			if (evt.getPropertyName().equals("image1")) {
				spinOneImage1 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image2")) {
				spinOneImage2 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image3")) {
				spinOneImage3 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image4")) {
				spinOneImage4 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image5")) {
				spinOneImage5 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image6")) {
				spinOneImage6 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image7")) {
				spinOneImage7 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image8")) {
				spinOneImage8 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image9")) {
				spinOneImage9 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}

		}

		if (counterImage >= 10 && counterImage <= 19) {

			if (evt.getPropertyName().equals("image1")) {
				spinTwoImage1 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image2")) {
				spinTwoImage2 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image3")) {
				spinTwoImage3 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image4")) {
				spinTwoImage4 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image5")) {
				spinTwoImage5 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image6")) {
				spinTwoImage6 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image7")) {
				spinTwoImage7 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image8")) {
				spinTwoImage8 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (counterImage != 10) {
				if (evt.getPropertyName().equals("image9")) {
					spinTwoImage9 = (ImageIcon) evt.getNewValue();

					counterImage++;
				}
			}

		}

		if (counterImage >= 19 && counterImage <= 28) {

			if (evt.getPropertyName().equals("image1")) {
				spinThreeImage1 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image2")) {
				spinThreeImage2 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image3")) {
				spinThreeImage3 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image4")) {
				spinThreeImage4 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image5")) {
				spinThreeImage5 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image6")) {
				spinThreeImage6 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image7")) {
				spinThreeImage7 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (evt.getPropertyName().equals("image8")) {
				spinThreeImage8 = (ImageIcon) evt.getNewValue();

				counterImage++;
			}
			if (counterImage != 19) {
				if (evt.getPropertyName().equals("image9")) {
					spinThreeImage9 = (ImageIcon) evt.getNewValue();

					counterImage++;

				}
			}
			if (counterImage == 29) {
				counterImage = 1;
			}

		}

		// getting the amount won for the bets

		if (evt.getPropertyName().equals("winAmount") && evt.getOldValue().equals(1)) {

			if (counterSpin <= 5) {
				line1lastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line1SecondlastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line1ThirdlastWinChecker = (String) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("winAmount") && evt.getOldValue().equals(2)) {

			if (counterSpin <= 5) {
				line2lastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line2SecondlastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line2ThirdlastWinChecker = (String) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("winAmount") && evt.getOldValue().equals(3)) {

			if (counterSpin <= 5) {
				line3lastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line3SecondlastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line3ThirdlastWinChecker = (String) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("winAmount") && evt.getOldValue().equals(4)) {

			if (counterSpin <= 5) {
				line4lastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line4SecondlastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line4ThirdlastWinChecker = (String) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("winAmount") && evt.getOldValue().equals(5)) {

			if (counterSpin <= 5) {
				line5lastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line5SecondlastWinChecker = (String) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line5ThirdlastWinChecker = (String) evt.getNewValue();

			}

		}

		// check which lines the bets were made on

		if (evt.getPropertyName().equals("betPlaced") && evt.getOldValue().equals(1)) {

			if (counterSpin <= 5) {
				line1lastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line1SecondlastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line1ThirdlastBetPlaced = (Boolean) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("betPlaced") && evt.getOldValue().equals(2)) {

			if (counterSpin <= 5) {
				line2lastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line2SecondlastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line2ThirdlastBetPlaced = (Boolean) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("betPlaced") && evt.getOldValue().equals(3)) {

			if (counterSpin <= 5) {
				line3lastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line3SecondlastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line3ThirdlastBetPlaced = (Boolean) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("betPlaced") && evt.getOldValue().equals(4)) {

			if (counterSpin <= 5) {
				line4lastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line4SecondlastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line4ThirdlastBetPlaced = (Boolean) evt.getNewValue();

			}

		}
		if (evt.getPropertyName().equals("betPlaced") && evt.getOldValue().equals(5)) {

			if (counterSpin <= 5) {
				line5lastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 5 && counterSpin <= 10) {
				line5SecondlastBetPlaced = (Boolean) evt.getNewValue();

			}
			if (counterSpin > 10 && counterSpin <= 15) {
				line5ThirdlastBetPlaced = (Boolean) evt.getNewValue();

			}

		}

		// reseting the spins when the player spins 3 times
		if (evt.getPropertyName().equals("counter")) {
			counterSpin++;
			if (counterSpin == 16) {
				counterSpin = 1;
			}
		}
	}

}