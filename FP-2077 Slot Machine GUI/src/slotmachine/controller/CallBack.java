package slotmachine.controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;

import javax.swing.ImageIcon;

import slotmachine.model.Player;
import slotmachine.model.PlayerImpl;
import slotmachine.model.slots.LineNum;
import slotmachine.model.slots.SlotLine;
import slotmachine.model.slots.SpinResult;
import slotmachine.model.slots.Wheel;
import slotmachine.view.GameCallback;

//change to UI callback
public class CallBack implements GameCallback {

	// the callback properties that will be triggered by the model

	final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	int line = 1;

	// register player allows the players details to be displayed to the GUI
	@Override
	public void registerPlayer(Player player) {

		this.pcs.firePropertyChange("playerID", null, player.getId());
		this.pcs.firePropertyChange("playerName", null, player.getName());
		this.pcs.firePropertyChange("playerInitialCredits", null, player.getInitalCredits());
		this.pcs.firePropertyChange("playerBet", null, player.getBet());
		this.pcs.firePropertyChange("playerAvailableCredits", null, player.getAvailableCredits());
		this.pcs.firePropertyChange("statusUpdateOne", null, null);

	}

	// the cash out player function allows the players displayed data to be removed
	// from display and reset within the GUI
	@Override
	public void cashOutPlayer(Player player) {
		this.pcs.firePropertyChange("playerIDCashout", null, player.getId());
		this.pcs.firePropertyChange("playerNameCashout", null, player.getName());
		this.pcs.firePropertyChange("playerInitialCreditsCashout", null, player.getInitalCredits());
		this.pcs.firePropertyChange("playerBetCashout", null, player.getBet());
		this.pcs.firePropertyChange("playerAvailableCreditsCashout", null, player.getAvailableCredits());
		this.pcs.firePropertyChange("placeBetCashout", null, null);
		this.pcs.firePropertyChange("statusPlaceBetCashout", null, null);

	}

	// the add credits function will update the players available credits when
	// called
	@Override
	public void addCredits(Player player, int credits) {
		this.pcs.firePropertyChange("addCredits", null, player.getCredits());

	}

	// the bet update function will update the GUI with the appropriate betline when
	// called from the model
	@Override
	public void betUpdated(Player player, int amount, LineNum line) {

		if (line.equals(LineNum.LINE1)) {
			this.pcs.firePropertyChange("placeBet", line, amount);
		}
		if (line.equals(LineNum.LINE2)) {
			this.pcs.firePropertyChange("placeBet", line, amount);
		}
		if (line.equals(LineNum.LINE3)) {
			this.pcs.firePropertyChange("placeBet", line, amount);
		}
		if (line.equals(LineNum.LINE4)) {
			this.pcs.firePropertyChange("placeBet", line, amount);
		}
		if (line.equals(LineNum.LINE5)) {
			this.pcs.firePropertyChange("placeBet", line, amount);
		}

		this.pcs.firePropertyChange("playerBetUpdate", null, player.getBet());
		this.pcs.firePropertyChange("playerAvailableCreditsUpdate", null, player.getAvailableCredits());

	}

	// was not needed for completion of the GUI
	@Override
	public void betUpdated(Player player, int amount, Collection<LineNum> lines) {
		// TODO Auto-generated method stub

	}

	// Suppressing warding as a custom equals function has been built, program wont
	// crash.
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void turnWheel(Wheel wheel, int turnNum) {

		// wheel 1
		if (wheel.equals(Integer.valueOf(1))) {

			this.pcs.firePropertyChange("wheelOneTopSlot", turnNum, wheel.getTopSlot());
			this.pcs.firePropertyChange("wheelOneCenterSlot", turnNum, wheel.getCentreSlot());
			this.pcs.firePropertyChange("wheelOneBottomSlot", turnNum, wheel.getBottomSlot());
		}

		// wheel 2
		if (wheel.equals(Integer.valueOf(2))) {
			this.pcs.firePropertyChange("wheelTwoTopSlot", turnNum, wheel.getTopSlot());
			this.pcs.firePropertyChange("wheelTwoCenterSlot", turnNum, wheel.getCentreSlot());
			this.pcs.firePropertyChange("wheelTwoBottomSlot", turnNum, wheel.getBottomSlot());
		}

		// wheel 2
		if (wheel.equals(Integer.valueOf(3))) {
			this.pcs.firePropertyChange("wheelThreeTopSlot", turnNum, wheel.getTopSlot());
			this.pcs.firePropertyChange("wheelThreeCenterSlot", turnNum, wheel.getCentreSlot());
			this.pcs.firePropertyChange("wheelThreeBottomSlot", turnNum, wheel.getBottomSlot());
		}

		this.pcs.firePropertyChange("hideSpin", null, null);

	}

	// updates GUI when a spin on the model has been complete
	@Override
	public void spinComplete(SpinResult spinResult) {

		this.pcs.firePropertyChange("showSpin", null, null);
		this.pcs.firePropertyChange("spinCompletee", null, null);

	}

	// will update the GUI with the appropriate individual line result from each
	// spin.
	@Override
	public void lineResult(Player player, boolean hasBet, int lineOutcome, SlotLine slotLine) {

		for (int j = 0; j <= 4; j++) {
			if (line == 1) {

				this.pcs.firePropertyChange("spinResultSlotLine", 1, slotLine.toString());
				this.pcs.firePropertyChange("winAmount", 1, Integer.toString(lineOutcome));
				this.pcs.firePropertyChange("betPlaced", 1, hasBet);

				line++;
				break;
			}

			if (line == 2) {

				this.pcs.firePropertyChange("spinResultSlotLine", 2, slotLine.toString());
				this.pcs.firePropertyChange("winAmount", 2, Integer.toString(lineOutcome));
				this.pcs.firePropertyChange("betPlaced", 2, hasBet);
				line++;
				break;
			}

			if (line == 3) {

				this.pcs.firePropertyChange("spinResultSlotLine", 3, slotLine.toString());
				this.pcs.firePropertyChange("winAmount", 3, Integer.toString(lineOutcome));
				this.pcs.firePropertyChange("betPlaced", 3, hasBet);
				line++;
				break;
			}

			if (line == 4) {

				this.pcs.firePropertyChange("spinResultSlotLine", 4, slotLine.toString());
				this.pcs.firePropertyChange("winAmount", 4, Integer.toString(lineOutcome));
				this.pcs.firePropertyChange("betPlaced", 4, hasBet);
				line++;
				break;
			}

			if (line == 5) {

				this.pcs.firePropertyChange("spinResultSlotLine", 5, slotLine.toString());
				this.pcs.firePropertyChange("winAmount", 5, Integer.toString(lineOutcome));
				this.pcs.firePropertyChange("betPlaced", 5, hasBet);
				line = 1;
				break;
			}

		}
		this.pcs.firePropertyChange("counter", null, null);

	}

	// updates the GUI from the model and allows the total bet the update
	@Override
	public void betTotals(Player player, int total) {

		this.pcs.firePropertyChange("winningCredits", null, player.getCredits());
		this.pcs.firePropertyChange("totalWin", null, total);

	}

	// this function will be called once the bets are reset being called from the
	// model
	@Override
	public void resetBet(PlayerImpl player) {
		this.pcs.firePropertyChange("playerAvailableCreditsUpdate", null, player.getAvailableCredits());
		this.pcs.firePropertyChange("playerBetCashout", null, null);
		this.pcs.firePropertyChange("placeBetCashout", null, null);

	}

	// callback for updating spin turn amount
	public void spinControllerTurns(int i) {
		if (i == 5) {
			this.pcs.firePropertyChange("spinControllerTurns", null, 5);
		}
		if (i == 10) {
			this.pcs.firePropertyChange("spinControllerTurns", null, 10);
		}
		if (i == 20) {
			this.pcs.firePropertyChange("spinControllerTurns", null, 20);
		}
		if (i == 50) {
			this.pcs.firePropertyChange("spinControllerTurns", null, 50);
		}

	}

	// callback for updating turn speed
	public void spinControllerSpeed(int i) {
		if (i == 5) {
			this.pcs.firePropertyChange("spinControllerSpeed", null, 50);
		}
		if (i == 10) {
			this.pcs.firePropertyChange("spinControllerSpeed", null, 100);
		}
		if (i == 20) {
			this.pcs.firePropertyChange("spinControllerSpeed", null, 250);
		}
		if (i == 50) {
			this.pcs.firePropertyChange("spinControllerSpeed", null, 1000);
		}

	}

	// callback for updating previous player
	public void updatePreviousPlayer(ImageIcon image1, ImageIcon image2, ImageIcon image3, ImageIcon image4,
			ImageIcon image5, ImageIcon image6, ImageIcon image7, ImageIcon image8, ImageIcon image9) {

		this.pcs.firePropertyChange("image1", null, image1);
		this.pcs.firePropertyChange("image2", null, image2);
		this.pcs.firePropertyChange("image3", null, image3);
		this.pcs.firePropertyChange("image4", null, image4);
		this.pcs.firePropertyChange("image5", null, image5);
		this.pcs.firePropertyChange("image6", null, image6);
		this.pcs.firePropertyChange("image7", null, image7);
		this.pcs.firePropertyChange("image8", null, image8);
		this.pcs.firePropertyChange("image9", null, image9);

	}

	// extra function used for reseting the bets to zero
	public void betTotalsReset() {
		this.pcs.firePropertyChange("setToZero", 0, 0);

	}

	// property change lister functions
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);

	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);

	}

}
