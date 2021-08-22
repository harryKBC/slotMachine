package slotmachine.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;
import slotmachine.model.slots.SlotItem;

@SuppressWarnings("serial")
public class Wheels extends JPanel implements PropertyChangeListener {

	CallBack cb;

	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	private ImageIcon image6;
	private ImageIcon image7;
	private ImageIcon image8;
	private ImageIcon image9;

	private Image imageOne;
	private Image imageTwo;
	private Image imageThree;
	private Image imageFour;
	private Image imageFive;
	private Image imageSix;
	private Image imageSeven;
	private Image imageEight;
	private Image imageNine;

	// image string names

	private String one;
	private String three;
	private String five;
	private String seven;
	private String lemon;
	private String lime;
	private String berry;
	private String cherry;
	private String melon;
	private String silver;
	private String gold;

	private int imageHeight1;
	private int imageWidth1;

	private int LastNumber1;
	private int LastNumber2;

	private int height;
	private int width;

	// variables for turning of the wheel

	// Wheel class was created in a single JPanel then using the PaintComonent() the
	// images were drawn at custom locatios using the a ratio created
	// using the parent Jpanel the gain measurements.

	@Override
	public void paintComponent(Graphics g) {

		// the height and width were calculated here using a % to allow them to scale
		// correctly with the panel

		// image 1
		int height1 = getHeight();
		double percentageHeight1 = height1 * 0.78;

		int width1 = getWidth();
		double percentageWidth1 = width1 * 0.78;

		super.paintComponent(g);
		int height12 = height1 / 10;
		int width12 = width1 / 10;

		// this if statement was used to check if the screen was increasing or
		// decreasing in size if it increases the size of the images increase and if it
		// decreases
		// the size of the images decrease. all of the images in the class use this this
		// calculation.

		if (height1 > height) {

			if (height12 > LastNumber1) {
				imageHeight1 = (imageHeight1 + 1);
			}

			if (height12 < LastNumber1) {
				imageHeight1 = (imageHeight1 - 1);
			}
		}
		if (width1 > width) {
			if (width12 > LastNumber2) {
				imageWidth1 = (imageWidth1 + 1);
			}
			if (width12 < LastNumber2) {
				imageWidth1 = (imageWidth1 - 1);
			}
		}
		LastNumber1 = height12;
		LastNumber2 = width12;

		imageOne = image1.getImage();

		Image ModImage = imageOne.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image11 = new ImageIcon(ModImage);

		image11.paintIcon(this, g, ((int) percentageWidth1), ((int) percentageHeight1));

		// this is where the second image is created, it is printed at a higher height
		// than the last but same x location

		// image 2
		double height2 = getHeight();
		double percentageHeight2 = height2 * 0.48;

		double width2 = getWidth();
		double percentageWidth2 = width2 * 0.78;

		imageTwo = image2.getImage();

		Image ModImageTwo = imageTwo.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image22 = new ImageIcon(ModImageTwo);

		image22.paintIcon(this, g, ((int) percentageWidth2), ((int) percentageHeight2));

		// this is where the second image is created, it is printed at a higher height
		// than the last but same x location

		// image 3
		double height3 = getHeight();
		double percentageHeight3 = height3 * 0.18;

		double width3 = getWidth();
		double percentageWidth3 = width3 * 0.78;

		imageThree = image3.getImage();

		Image ModImageThree = imageThree.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image33 = new ImageIcon(ModImageThree);

		image33.paintIcon(this, g, ((int) percentageWidth3), ((int) percentageHeight3));

		// image 4 has been give a different x location this time, to move it along the
		// x axis of the JPanel.

		// image 4
		double height4 = getHeight();
		double percentageHeight4 = height4 * 0.78;

		double width4 = getWidth();
		double percentageWidth4 = width4 * 0.48;

		imageFour = image4.getImage();

		Image ModImageFour = imageFour.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image44 = new ImageIcon(ModImageFour);

		image44.paintIcon(this, g, ((int) percentageWidth4), ((int) percentageHeight4));

		// the process of this is repeated for all 9 of the images generating the final
		// collection of images.

		// image 5
		double height5 = getHeight();
		double percentageHeight5 = height5 * 0.48;

		double width5 = getWidth();
		double percentageWidth5 = width5 * 0.48;

		imageFive = image5.getImage();

		Image ModImageFive = imageFive.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image55 = new ImageIcon(ModImageFive);

		image55.paintIcon(this, g, ((int) percentageWidth5), ((int) percentageHeight5));

		// image 6
		double height6 = getHeight();
		double percentageHeight6 = height6 * 0.18;

		double width6 = getWidth();
		double percentageWidth6 = width6 * 0.48;

		imageSix = image6.getImage();

		Image ModImageSix = imageSix.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image66 = new ImageIcon(ModImageSix);

		image66.paintIcon(this, g, ((int) percentageWidth6), ((int) percentageHeight6));

		// image 7
		double height7 = getHeight();
		double percentageHeight7 = height7 * 0.78;

		double width7 = getWidth();
		double percentageWidth7 = width7 * 0.18;

		imageSeven = image7.getImage();

		Image ModImageSeven = imageSeven.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image77 = new ImageIcon(ModImageSeven);

		image77.paintIcon(this, g, ((int) percentageWidth7), ((int) percentageHeight7));

		// image 8
		double height8 = getHeight();
		double percentageHeight8 = height8 * 0.48;

		double width8 = getWidth();
		double percentageWidth8 = width8 * 0.18;

		imageEight = image8.getImage();

		Image ModImageEight = imageEight.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image88 = new ImageIcon(ModImageEight);

		image88.paintIcon(this, g, ((int) percentageWidth8), ((int) percentageHeight8));

		// image 9
		double height9 = getHeight();
		double percentageHeight9 = height9 * 0.18;

		double width9 = getWidth();
		double percentageWidth9 = width9 * 0.18;

		imageNine = image9.getImage();

		Image ModImageNine = imageNine.getScaledInstance(imageWidth1, imageHeight1, Image.SCALE_SMOOTH);

		ImageIcon image99 = new ImageIcon(ModImageNine);

		image99.paintIcon(this, g, ((int) percentageWidth9), ((int) percentageHeight9));

	}

	// the constructor used to gather the images so they are not generated during
	// run time. this is also where the background color is set and the size is set
	// to the variables.

	public Wheels(SlotMachine model, CallBack cb) {
		this.cb = cb;
		one = "images/icons8-one-free-24.png";
		three = "images/icons8-circled-3-c-52.png";

		five = "images/icons8-5-key-30.png";
		seven = "images/icons8-7-30.png";
		lemon = "images/icons8-lemon-64.png";
		lime = "images/icons8-lime-48.png";
		berry = "images/icons8-raspberry-64.png";
		cherry = "images/icons8-cherry-48.png";
		melon = "images/icons8-watermelon-64.png";
		silver = "images/icons8-silver-bars-48.png";
		gold = "images/icons8-gold-bars-48.png";

		cb.addPropertyChangeListener(this);

		setBackground(new Color(128, 147, 241));
		setSize(784, 506);
		setHeight();
		setWidth();
		image1 = new ImageIcon(berry);
		image2 = new ImageIcon(silver);
		image3 = new ImageIcon("images/icons8-7-30.png");
		image4 = new ImageIcon("images/icons8-lime-48.png");
		image5 = new ImageIcon("images/icons8-circled-3-c-52.png");
		image6 = new ImageIcon("images/icons8-gold-bars-48.png");
		image7 = new ImageIcon("images/icons8-lemon-64.png");
		image8 = new ImageIcon("images/icons8-one-free-24.png");
		image9 = new ImageIcon("images/icons8-watermelon-64.png");
		imageHeight1 = image1.getIconHeight();
		imageWidth1 = image1.getIconWidth();

	}

	public void setHeight() {
		height = getHeight();
	}

	public void setWidth() {
		width = getWidth();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		// wheel 1
		if (arg0.getPropertyName().equals("wheelOneTopSlot")) {

			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image9 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image9 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image9 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image9 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image9 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image9 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image9 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image9 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image9 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image9 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image9 = new ImageIcon(gold);
				repaint();
			}

		}
		if (arg0.getPropertyName().equals("wheelOneCenterSlot")) {
			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image8 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image8 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image8 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image8 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image8 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image8 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image8 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image8 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image8 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image8 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image8 = new ImageIcon(gold);
				repaint();
			}
		}
		if (arg0.getPropertyName().equals("wheelOneBottomSlot")) {
			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image7 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image7 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image7 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image7 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image7 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image7 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image7 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image7 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image7 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image7 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image7 = new ImageIcon(gold);
				repaint();
			}
		}

		// wheel 2
		if (arg0.getPropertyName().equals("wheelTwoTopSlot")) {

			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image6 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image6 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image6 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image6 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image6 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image6 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image6 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image6 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image6 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image6 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image6 = new ImageIcon(gold);
				repaint();
			}
		}
		if (arg0.getPropertyName().equals("wheelTwoCenterSlot")) {
			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image5 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image5 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image5 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image5 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image5 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image5 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image5 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image5 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image5 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image5 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image5 = new ImageIcon(gold);
				repaint();
			}
		}
		if (arg0.getPropertyName().equals("wheelTwoBottomSlot")) {
			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image4 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image4 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image4 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image4 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image4 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image4 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image4 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image4 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image4 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image4 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image4 = new ImageIcon(gold);
				repaint();
			}
		}

		// wheel 3
		if (arg0.getPropertyName().equals("wheelThreeTopSlot")) {

			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image3 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image3 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image3 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image3 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image3 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image3 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image3 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image3 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image3 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image3 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image3 = new ImageIcon(gold);
				repaint();
			}
		}
		if (arg0.getPropertyName().equals("wheelThreeCenterSlot")) {
			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image2 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image2 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image2 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image2 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image2 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image2 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image2 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image2 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image2 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image2 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image2 = new ImageIcon(gold);
				repaint();
			}
		}
		if (arg0.getPropertyName().equals("wheelThreeBottomSlot")) {
			if (arg0.getNewValue().equals(SlotItem.ONE)) {

				image1 = new ImageIcon(one);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.THREE)) {

				image1 = new ImageIcon(three);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.FIVE)) {

				image1 = new ImageIcon(five);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SEVEN)) {

				image1 = new ImageIcon(seven);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LEMON)) {

				image1 = new ImageIcon(lemon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.LIME)) {
				image1 = new ImageIcon(lime);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.BERRY)) {
				image1 = new ImageIcon(berry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.CHERRY)) {
				image1 = new ImageIcon(cherry);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.MELON)) {
				image1 = new ImageIcon(melon);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.SILVER)) {
				image1 = new ImageIcon(silver);
				repaint();
			}
			if (arg0.getNewValue().equals(SlotItem.GOLD)) {
				image1 = new ImageIcon(gold);
				repaint();
			}
		}

		if (arg0.getPropertyName().equals("spinCompletee")) {
			cb.updatePreviousPlayer(image1, image2, image3, image4, image5, image6, image7, image8, image9);
		}

	}
}
