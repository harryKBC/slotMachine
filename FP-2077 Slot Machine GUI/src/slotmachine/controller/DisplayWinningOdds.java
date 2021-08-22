package slotmachine.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import slotmachine.view.DialogBoxWinningOdds;

public class DisplayWinningOdds implements ActionListener {

	// Image icons declared

	private ImageIcon line1Image1;
	private ImageIcon line1Image2;
	private ImageIcon line1Image3;

	private ImageIcon line2Image1;
	private ImageIcon line2Image2;
	private ImageIcon line2Image3;

	private ImageIcon line3Image1;
	private ImageIcon line3Image2;
	private ImageIcon line3Image3;

	private ImageIcon line4Image1;
	private ImageIcon line4Image2;
	private ImageIcon line4Image3;

	private ImageIcon line5Image1;
	private ImageIcon line5Image2;
	private ImageIcon line5Image3;

	private ImageIcon line6Image1;
	private ImageIcon line6Image2;
	private ImageIcon line6Image3;

	// displayed winning odds, images are resized and formated.

	public DisplayWinningOdds() {
		line1Image1 = new ImageIcon("images/icons8-7-30.png");
		line1Image2 = new ImageIcon("images/icons8-7-30.png");
		line1Image3 = new ImageIcon("images/icons8-circled-3-c-52.png");

		line2Image1 = new ImageIcon("images/icons8-one-free-24.png");
		line2Image2 = new ImageIcon("images/icons8-one-free-24.png");
		line2Image3 = new ImageIcon("images/icons8-5-key-30.png");

		line3Image1 = new ImageIcon("images/icons8-silver-bars-48.png");
		line3Image2 = new ImageIcon("images/icons8-circled-3-c-52.png");
		line3Image3 = new ImageIcon("images/icons8-cherry-48.png");

		line4Image1 = new ImageIcon("images/icons8-circled-3-c-52.png");
		line4Image2 = new ImageIcon("images/icons8-circled-3-c-52.png");
		line4Image3 = new ImageIcon("images/icons8-one-free-24.png");

		line5Image1 = new ImageIcon("images/icons8-gold-bars-48.png");
		line5Image2 = new ImageIcon("images/icons8-lemon-64.png");
		line5Image3 = new ImageIcon("images/icons8-7-30.png");

		line6Image1 = new ImageIcon("images/icons8-circled-3-c-52.png");
		line6Image2 = new ImageIcon("images/icons8-circled-3-c-52.png");
		line6Image3 = new ImageIcon("images/icons8-circled-3-c-52.png");

		// scaling images to the same size

		Image image1 = line1Image1.getImage();

		Image ModImage1 = image1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line1Image1 = new ImageIcon(ModImage1);

		//////// ------------

		Image image2 = line1Image2.getImage();

		Image ModImage2 = image2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line1Image2 = new ImageIcon(ModImage2);

		//////// ------------

		Image image3 = line1Image3.getImage();

		Image ModImage3 = image3.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line1Image3 = new ImageIcon(ModImage3);

		//////// ------------

		Image image4 = line2Image1.getImage();

		Image ModImage4 = image4.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line2Image1 = new ImageIcon(ModImage4);

		//////// ------------

		Image image5 = line2Image2.getImage();

		Image ModImage5 = image5.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line2Image2 = new ImageIcon(ModImage5);

		//////// ------------

		Image image6 = line2Image3.getImage();

		Image ModImage6 = image6.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line2Image3 = new ImageIcon(ModImage6);

		//// ------

		Image image7 = line3Image1.getImage();

		Image ModImage7 = image7.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line3Image1 = new ImageIcon(ModImage7);

		//////// ------------

		Image image8 = line3Image2.getImage();

		Image ModImage8 = image8.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line3Image2 = new ImageIcon(ModImage8);

		//////// ------------

		Image image9 = line4Image1.getImage();

		Image ModImage9 = image9.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line4Image1 = new ImageIcon(ModImage9);

		//////// ------------

		Image image10 = line4Image2.getImage();

		Image ModImage10 = image10.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line4Image2 = new ImageIcon(ModImage10);

		//////// ------------

		Image image11 = line4Image3.getImage();

		Image ModImage11 = image11.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line4Image3 = new ImageIcon(ModImage11);

		//////// ------------

		Image image12 = line5Image1.getImage();

		Image ModImage12 = image12.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line5Image1 = new ImageIcon(ModImage12);

		//////// ------------

		Image image13 = line5Image2.getImage();

		Image ModImage13 = image13.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line5Image2 = new ImageIcon(ModImage13);

		//////// ------------

		Image image14 = line5Image3.getImage();

		Image ModImage14 = image14.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line5Image3 = new ImageIcon(ModImage14);

		//////// ------------

		Image image15 = line6Image1.getImage();

		Image ModImage15 = image15.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line6Image1 = new ImageIcon(ModImage15);

		//////// ------------

		Image image16 = line6Image2.getImage();

		Image ModImage16 = image16.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line6Image2 = new ImageIcon(ModImage16);

		//////// ------------

		Image image17 = line6Image3.getImage();

		Image ModImage17 = image17.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		line6Image3 = new ImageIcon(ModImage17);

	}

	// action to send formatted images to dialog box when opened
	@Override
	public void actionPerformed(ActionEvent e) {

		new DialogBoxWinningOdds(line1Image1, line1Image2, line1Image3, line2Image1, line2Image2, line2Image3,
				line3Image1, line3Image2, line3Image3, line4Image1, line4Image2, line4Image3, line5Image1, line5Image2,
				line5Image3, line6Image1, line6Image2, line6Image3);

	}

}