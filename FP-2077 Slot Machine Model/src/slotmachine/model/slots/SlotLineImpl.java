package slotmachine.model.slots;

import java.util.Objects;

public class SlotLineImpl implements SlotLine {

	//variables declared
	private LineNum lineNUM;
	private SlotItem slotOne;
	private SlotItem slotTwo;
	private SlotItem slotThree;
	
	//Simple constructor for class
	public SlotLineImpl(LineNum lineNum, SlotItem slot1, SlotItem slot2, SlotItem slot3){
		lineNUM = lineNum;
		slotOne = slot1;
		slotTwo = slot2;
		slotThree = slot3;
	}
	
	//Simple getter for Line num
	@Override
	public LineNum getLineNum() {
		
		return lineNUM;
	}

	//Simple getter for slot 1
	@Override
	public SlotItem getSlot1() {
		
		return slotOne;
	}

	//Simple getter for slot 2
	@Override
	public SlotItem getSlot2() {
		
		return slotTwo;
	}

	//Simple getter for slot 3
	@Override
	public SlotItem getSlot3() {
	
		return slotThree;
	}

	//equals function checking this slotline with input slotline
	@Override
	public boolean equals(SlotLine slotLine) {		
		if(this.slotOne == slotLine.getSlot1() && 
			this.slotTwo == slotLine.getSlot2() &&
			this.slotThree == slotLine.getSlot3()) {
			return true;
			
		}
				
		return false;
	}
	
	//equals function checking this slotline with input slotline. This also makes sure input is an instance of slotline
	public boolean equals​(java.lang.Object slotLine) {
		
		if(!(slotLine instanceof SlotLine)) {
			return false;
		}
		if(equals(slotLine)==true) {
			return true;
		}
		return false;
		
	}
	
	//generate a hash code for the slotItems, lineNume not encluded
	@Override
	public int hashCode() {
		return Objects.hash(slotOne, slotTwo, slotThree);
	}
	
	//string formated to String function representing the class
	@Override
	public java.lang.String toString(){
		return String.format("Wheel #%s | %-10s|%-10s|%-10s|", getLineNum().toString(),getSlot1().toString(),getSlot2().toString(),getSlot3().toString());
		
		
	}

}
