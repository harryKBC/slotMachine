package slotmachine.model.slots;


import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class WheelImpl implements Wheel {

	//declare variables, as wheel number, size of wheel and the array collection
	private   int wheelNumm;
	private   int wheelSize;
	private   List<SlotItem>wheelList;
	
	
	public static Wheel createWheel​(int wheelNum) {		
		
		// creates a new wheel object from the wheelImpl class then sets the size of that to 0 and the number to the input number
		WheelImpl retWheel = new WheelImpl();	
			retWheel.wheelSize = 0;			
			retWheel.wheelNumm = wheelNum;
			
		//create an array called allSlots containing all the values from the slot Item enum
			SlotItem[] allSlots = SlotItem.values();
			
		// java collections for each loop which dynamically gets the size of wheel from the enum data
			for(SlotItem i:allSlots) {			
				retWheel.wheelSize += i.getCount();	
			}
			
		//creates a new slotItem array, then that array is changed to an arrayList		
			SlotItem[] slotItemList = new SlotItem[retWheel.wheelSize];			
			retWheel.wheelList = Arrays.asList(slotItemList);	
			int slotNum = 0;			
			
		//loops that set the values of our retWheel wheelList to the correct amount of slots, eg cherry will be set 5 times.
			for(SlotItem i : allSlots) {
				for(int j=0; j<i.getCount(); j++) {			
					retWheel.wheelList.set(slotNum, i);
					slotNum++;
				}
			}
			
		//collections api method that will randomize each created wheel
			Collections.shuffle(retWheel.wheelList);		
			
		
		// returning the wheel
		return retWheel;	
			
		
	}
	
	@Override
	public SlotItem getTopSlot() {
		
		return wheelList.get(2);
	}

	@Override
	public SlotItem getCentreSlot() {
		// TODO Auto-generated method stub
		return wheelList.get(1);
	}

	@Override
	public SlotItem getBottomSlot() {
		// TODO Auto-generated method stub
		return wheelList.get(0);
	}

	@Override
	public Wheel nextSlot() {
		
		//create a new list of Slot Items to the dynamic size of the previously returned wheel
		SlotItem[] newWheelListList = new SlotItem[wheelSize];
		
		//loop the size of the wheel and set the new wheel list to the position of the old wheel list but moving 1 position up.
		for(int i=0; i< wheelSize; i++) {
			newWheelListList[i] = wheelList.get((i+1)%wheelSize);			
		}
		
		//convert the newWheelListList to an array list and set it to the wheel list then return the updated object
		wheelList = Arrays.asList(newWheelListList);
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == Integer.valueOf(wheelNumm)) {
			return true;
		}
		
		return false;
	}
	
	
	public java.lang.String toString(){
		
		
		return String.format("Wheel #%s : %-10s /%-10s /%-10s", this.wheelNumm,this.getTopSlot(),this.getCentreSlot(),this.getBottomSlot());
		
		
	}
	
	

}
