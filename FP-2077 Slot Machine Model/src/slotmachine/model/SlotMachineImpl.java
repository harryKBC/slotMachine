package slotmachine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import slotmachine.model.slots.LineNum;
import slotmachine.model.slots.SlotLine;
import slotmachine.model.slots.SpinResult;
import slotmachine.model.slots.SpinResultImpl;
import slotmachine.model.slots.Wheel;
import slotmachine.model.slots.WheelImpl;
import slotmachine.model.slots.WinSettings;
import slotmachine.model.slots.WinSettingsImpl;
import slotmachine.view.GameCallback;

public class SlotMachineImpl implements SlotMachine {

	// variables declaration for slotMachineImpl class
	private WinSettings winSettings;
	private PlayerImpl player;
	private ArrayList<GameCallback> gameCallbackCollection = new ArrayList<GameCallback>();
	private List<Integer> slotLineCollection = new ArrayList<Integer>();

	private Wheel wheel1;
	private Wheel wheel2;
	private Wheel wheel3;
	private SpinResult spinResluts;
	boolean betChecker = true;
	boolean checker = true;
	int previousAmount = 0;

	// no argument constructor used to build the slotMachineImpl
	public SlotMachineImpl() {
		winSettings = new WinSettingsImpl();
		wheel1 = WheelImpl.createWheel​(1);
		wheel2 = WheelImpl.createWheel​(2);
		wheel3 = WheelImpl.createWheel​(3);

		// setting values of the bet collection to 0
		for (int i = 0; i <= LineNum.values().length - 1; i++) {
			slotLineCollection.add(i, 0);
		}
	}

	// argument constructor used to build the slotMachineImpl
	public SlotMachineImpl(Wheel wheel1, Wheel wheel2, Wheel wheel3, WinSettings winSettings) {
		winSettings = new WinSettingsImpl();
		wheel1 = WheelImpl.createWheel​(1);
		wheel2 = WheelImpl.createWheel​(2);
		wheel3 = WheelImpl.createWheel​(3);

		// setting values of the bet collection to 0
		for (int i = 0; i <= LineNum.values().length - 1; i++) {
			slotLineCollection.add(i, 0);
		}
	}

	// adds a game call back to the game callback
	@Override
	public int addCallback(GameCallback callback) {

		gameCallbackCollection.add(callback);

		return gameCallbackCollection.size();
	}

	// removes a game call back to the game callback
	@Override
	public int removeCallback(GameCallback callback) {
		gameCallbackCollection.remove(callback);
		return gameCallbackCollection.size();
	}

	// this function creates a new player using the PlayerImpl constructor and saves
	// it to the slotmachine notifying callback
	@Override
	public Player registerPlayer(String id, String name, int initialCredits) {
		if (player != null) {
			throw new IllegalStateException("Please cashout before adding new player");
		}
		player = new PlayerImpl(id, name, initialCredits);
		for (GameCallback x : gameCallbackCollection) {
			x.registerPlayer(player);
		}
		return player;
	}

	// this function cashes out the player by setting the previous player to the
	// current player, checking if player == null
	// notifying all cash out callbacks then resetting the player bet collection to
	// 0, followed by setting the player no null.
	// the previous amount is reset to 0
	// returning the previousPlayer

	@Override
	public Player cashOut() throws java.lang.IllegalStateException {
		Player previousPlayer = player;
		if (player.equals(null)) {
			throw new IllegalStateException("No Player is registered");
		}

		for (GameCallback x : gameCallbackCollection) {
			x.cashOutPlayer(player);
		}

		for (int i = 0; i <= LineNum.values().length - 1; i++) {
			slotLineCollection.set(i, 0);
		}
		previousAmount = 0;
		player = null;

		return previousPlayer;
	}

	// this function simply adds input credits to the player, but first checking if
	// the player exists and if the input credits
	// are greater than 0. The function then calls all the callbacks for add credits
	@Override
	public void addCredits(int credits) throws IllegalStateException, IllegalArgumentException {
		if (player == null) {
			throw new IllegalStateException("No Player is registered");
		}
		if (credits < 0) {
			throw new IllegalArgumentException("credits cannot be lower than 0");
		}
		player.addCredits(credits);
		for (GameCallback x : gameCallbackCollection) {
			x.addCredits(player, credits);
		}
	}

	// this function places a bet on the first line, it calls the place bet lineNum
	// function to do so
	@Override
	public void placeBet(int amount) throws IllegalArgumentException, IllegalStateException {

		placeBet(amount, LineNum.LINE1);

	}

	// this function places a bet of input amount on input line. It first handles
	// error checking throwing errors if the conditions are met
	// It will then check if the array is empty, if it is it will set the input
	// value to the input line (this is done to provide better error checking in
	// code)
	// If the values are not null the previous value is removed and the new amount
	// is added.
	// the betChecker then checks if output is required to the callback is so the
	// callback is called
	// then the checkers are reset
	// and the total wins are added to a previousAmount for calculation on the next
	// iteration.
	@Override
	public void placeBet(int amount, LineNum line) throws IllegalArgumentException, IllegalStateException {
		if (amount < slotLineCollection.get(line.ordinal())) {
			throw new IllegalArgumentException("Bet is the same or less than current bet on this line");
		}
		if (amount > player.getAvailableCredits()) {
			throw new IllegalArgumentException("Bet is more than players Available Credits");
		}
		if (amount < 0) {
			throw new IllegalArgumentException("Bet can not be less than 0");
		}
		if (player == null) {
			throw new IllegalStateException("No Player registered");
		}
		if (slotLineCollection.toArray()[line.ordinal()] == null) {
			player.setBet(amount);
			slotLineCollection.add(line.ordinal(), amount);
		} else {
			if (slotLineCollection.get(line.ordinal()) > 0) {
				player.setBet(amount - (slotLineCollection.get(line.ordinal())));
				slotLineCollection.remove(line.ordinal());
				slotLineCollection.add(line.ordinal(), amount);
			} else {
				player.setBet(amount - previousAmount);
				slotLineCollection.remove(line.ordinal());
				slotLineCollection.add(line.ordinal(), amount);
			}

		}
		if (betChecker == true) {
			for (GameCallback x : gameCallbackCollection) {
				x.betUpdated(player, amount, line);
			}
		}
		// System.out.println(player.getCredits());
		betChecker = true;
		checker = true;
		int storageValue;
		for (int i = 0; i < slotLineCollection.size(); i++) {
			storageValue = slotLineCollection.get(i);
			previousAmount = storageValue;
		}

	}

	// this place bet function is called if a set is provided, it will loop the
	// collection and send each input to the placebet function
	// this has been done to avoid code duplication, on each loop it sets the bet
	// checker to false so the output can be sent to the correct logger.
	@Override
	public void placeBet(int amount, Set<LineNum> lines) throws IllegalArgumentException, IllegalStateException {

		for (LineNum x : lines) {
			betChecker = false;
			placeBet(amount, x);
		}
		for (GameCallback y : gameCallbackCollection) {
			y.betUpdated(player, amount, lines);
		}
	}

	// this place bet function is called if an array is provided, the array is
	// converted to a list. it will loop the collection and send each input to the
	// placebet function
	// this has been done to avoid code duplication, on each loop it sets the bet
	// checker to false so the output can be sent to the correct logger.
	@Override
	public void placeBet(int amount, LineNum... lines) throws IllegalArgumentException, IllegalStateException {

		List<LineNum> line = Arrays.asList(lines);
		for (LineNum x : line) {
			betChecker = false;
			placeBet(amount, x);
		}
		for (GameCallback y : gameCallbackCollection) {
			y.betUpdated(player, amount, line);
		}
	}

	// this function resets the bet, it sets the previous amount to 0, then resets
	// the players bet then sets the bet collection to 0
	// then places a bet with 0 to notify the output.
	@Override
	public void resetBets() {
		if (player == null) {
			throw new IllegalStateException("No Player is registered");
		}
		previousAmount = 0;
		player.resetBet();
		for (int i = 0; i <= LineNum.values().length - 1; i++) {
			slotLineCollection.set(i, 0);
		}
		placeBet(0, LineNum.LINE1, LineNum.LINE2, LineNum.LINE3, LineNum.LINE4, LineNum.LINE5);
		for (GameCallback y : gameCallbackCollection) {
			y.resetBet(player);
		}

	}

	// this function spins the wheel based off the users input for turn and delay.
	// It will check if a bet has been placed on any of the lines
	// if so it will throw. It will then call the Spin function and catch the spin
	// results and then apply them using the applySpinResults function
	// finally returning the spin results
	@Override
	public SpinResult spinToWin(int turns, int delay) throws IllegalArgumentException, IllegalStateException {
		int storageValueSpin = 0;
		for (int i = 0; i < slotLineCollection.size(); i++) {
			storageValueSpin = storageValueSpin + slotLineCollection.get(i);
		}
		if (storageValueSpin == 0) {
			throw new IllegalStateException("No bet has been placed");
		}

		spinResluts = spin(turns, delay);
		applySpinResult(spinResluts);
		resetBets();
		return spinResluts;
	}

	// The spin function will spin the wheel. First it will check if the inputs are
	// correct, if not it will throw. Inside a try catch
	// to use the Thread.sleep functionality. Each wheel will spin the required
	// Percentile rounding to the larger number to allow for
	// each wheel to spin at least once. On each turn the Turn wheel function is
	// called from WheelImpl.
	// after all this the game callback is called for spin results notifying the
	// logger and the spinResults are returned
	@Override
	public SpinResult spin(int turns, int delay) throws IllegalArgumentException {
		if (delay > 2000) {
			throw new IllegalArgumentException("delay can not be over 2000ms");
		} else if (turns < 1) {
			throw new IllegalArgumentException("Can not turn 0 times");
		}
		try {
			for (int i = 1; i <= turns; i++) {
				if (i <= turns) {
					wheel1.nextSlot();
					for (GameCallback x : gameCallbackCollection) {
						x.turnWheel(wheel1, i);
						;
					}
				}
				if (i <= Math.ceil(turns * 0.66)) {
					wheel2.nextSlot();
					for (GameCallback x : gameCallbackCollection) {
						x.turnWheel(wheel2, i);
						;
					}
				}
				if (i <= Math.ceil(turns * 0.33)) {
					wheel3.nextSlot();
					for (GameCallback x : gameCallbackCollection) {
						x.turnWheel(wheel3, i);
						;
					}
				}
				Thread.sleep(delay);
			}
		} catch (Exception e) {
		}
		spinResluts = new SpinResultImpl(wheel1, wheel2, wheel3);
		for (GameCallback x : gameCallbackCollection) {
			x.spinComplete(spinResluts);
		}
		return spinResluts;
	}

	// The applySpinResults function takes the spinResults and creates an iterator
	// for them. The it the function then checks if a player
	// exists. inside the while loop which will loop while values exist inside the
	// collection, we check if a bet has been placed, we get the win odds.
	// The function then calls the lineResult callback which sends each variable to
	// the logger with the bet being multiplied inside the function call.
	// The win is then applied to the player, the Bets are rest and the betTotal
	// callback is called followed by the Total wins being returned.
	@Override
	public int applySpinResult(SpinResult spinResult) {

		int totalWin = 0;
		int counter = 0;
		boolean equalsChecker;

		Iterator<SlotLine> it = spinResult.iterator();
		if (player.equals(null)) {
			throw new IllegalStateException("No Player registered");
		}
		while (it.hasNext()) {

			equalsChecker = slotLineCollection.get(counter) > 0 ? true : false;
			SlotLine t = it.next();
			totalWin = totalWin + (slotLineCollection.get(counter) * winSettings.getWinOdds(t));

			for (GameCallback x : gameCallbackCollection) {

				x.lineResult(player, equalsChecker, (slotLineCollection.get(counter) * winSettings.getWinOdds(t)), t);

			}
			counter++;
		}
		player.applyWin(totalWin);

		for (GameCallback x : gameCallbackCollection) {
			x.betTotals(player, totalWin);
		}
		return totalWin;
	}

	public WinSettings getWinSettings() {
		return winSettings;
	}

}
