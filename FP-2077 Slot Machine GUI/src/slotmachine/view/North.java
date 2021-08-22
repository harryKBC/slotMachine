package slotmachine.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import slotmachine.controller.CallBack;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class North extends JPanel{
	
	North(SlotMachine model, CallBack cb){
		
		//this north component was used to store the top half of the slot machine
		//with 3 areas divided into north south and center and a preset preferred Size
		
		setLayout(new BorderLayout());
		
		this.setPreferredSize(new Dimension(200,200));
		add(new Player(model,cb),BorderLayout.NORTH);
		add(new StatusBar(model, cb),BorderLayout.CENTER);
		add(new Bets(model, cb),BorderLayout.SOUTH);
		
		
	}

}
