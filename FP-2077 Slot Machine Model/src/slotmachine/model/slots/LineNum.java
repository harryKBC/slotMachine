package slotmachine.model.slots;

public enum LineNum {
	LINE1(1),//center center center
	LINE2(2),//top top top
	LINE3(3),//bottom bottom bottom
	LINE4(4),//top center bottom
	LINE5(5);//bottom center top
	
	private int count;
	
	//lineNum set count function
	private LineNum(int count)
	{		
		this.count = count;
	}	
	
	//value of lineNum function - not used in assignment - count not find use for it.
	static LineNum valueOf​(java.lang.String name) {
		if(name == null||name =="") {
			throw new NullPointerException("input must not be null");
		}
		if(name =="") {
			throw new IllegalArgumentException("Enum input incorrect");
		}
		for(int i =0; i<=name.length()-1; i++) {			
			char savedChar = name.charAt(i);						
			if(!Character.isLetter(savedChar)) {
				throw new IllegalArgumentException("Enum input incorrect");
			}
		}		
		if(name=="LINE1") {
			return LineNum.LINE1;
		}
		if(name=="LINE2") {
			return LineNum.LINE2;
		}
		if(name=="LINE3") {
			return LineNum.LINE3;
		}
		if(name=="LINE4") {
			return LineNum.LINE4;
		}	
		return LineNum.LINE5;
		
	}
	
	/*
	public static LineNum[] values() {
		for (LineNum c : LineNum.values())
		   return c;
	}
*/
}
