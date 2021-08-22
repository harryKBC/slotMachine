package slotmachine.model.slots;

import java.util.ArrayList;
import java.util.Iterator;

public class SpinResultImpl implements SpinResult, java.lang.Iterable<SlotLine> {

	// Declared variables
	private ArrayList<SlotLine> slotLine = new ArrayList<SlotLine>();
	private String returnValue;

	// simple constructor which creates the slot lines from the wheel input and adds
	// each slotLine to the slotLine collection
	public SpinResultImpl(Wheel wheel1, Wheel wheel2, Wheel wheel3) {
		SlotLineImpl slotLine1 = new SlotLineImpl(LineNum.LINE1, wheel1.getTopSlot(), wheel2.getTopSlot(),
				wheel3.getTopSlot());
		SlotLineImpl slotLine2 = new SlotLineImpl(LineNum.LINE2, wheel1.getCentreSlot(), wheel2.getCentreSlot(),
				wheel3.getCentreSlot());
		SlotLineImpl slotLine3 = new SlotLineImpl(LineNum.LINE3, wheel1.getBottomSlot(), wheel2.getBottomSlot(),
				wheel3.getBottomSlot());
		SlotLineImpl slotLine4 = new SlotLineImpl(LineNum.LINE4, wheel1.getTopSlot(), wheel2.getCentreSlot(),
				wheel3.getBottomSlot());
		SlotLineImpl slotLine5 = new SlotLineImpl(LineNum.LINE5, wheel1.getBottomSlot(), wheel2.getCentreSlot(),
				wheel3.getTopSlot());

		slotLine.add(slotLine1);
		slotLine.add(slotLine2);
		slotLine.add(slotLine3);
		slotLine.add(slotLine4);
		slotLine.add(slotLine5);

	}

	// creates and returns an iterator
	@Override
	public Iterator<SlotLine> iterator() {
		Iterator<SlotLine> it = slotLine.iterator();
		return it;
	}

	// to string function which loops though the collection and switches the
	// position of line1 and line 2 for display, the displays the following third
	// line
	@Override
	public String toString() {

		for (int j = 0; j < slotLine.size(); j++) {
			if (j < 3) {
				if (j == 0) {
					j++;
					returnValue = String.format("Line #%d | %-10s| %-10s | %-10s |\n", j + 1,
							slotLine.get(j).getSlot1().toString(), slotLine.get(j).getSlot2().toString(),
							slotLine.get(j).getSlot3().toString());

					j--;
				}
				if (j == 1) {
					j++;
				}
				returnValue = returnValue + String.format("Line #%d | %-10s| %-10s | %-10s |\n", j + 1,
						slotLine.get(j).getSlot1().toString(), slotLine.get(j).getSlot2().toString(),
						slotLine.get(j).getSlot3().toString());

			}

		}
		return returnValue;
	}

}
