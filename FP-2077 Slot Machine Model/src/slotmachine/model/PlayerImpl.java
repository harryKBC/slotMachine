package slotmachine.model;



public class PlayerImpl implements Player{
	
	//Variables declared - used all caps to not interfere with constructor
	private String ID;
	private String NAME;
	private int INITIALCREDITS;
	private int CREDITS;
	private int BET;
	

	//constructor for the Player, this function also handles error checking throwing if inputs do not line up with assignment spec
	//the ID used the isLetter and isDigit to create input error checking. 
	public PlayerImpl(java.lang.String id,java.lang.String name,int initialCredits) {
		ID = id;	
		if(ID.length() != 6 ||ID==null) {
			throw new IllegalArgumentException("ID has to be 5 numbers and 1 letter long");
			
		}
		for(int i =0; i<=ID.length()-1; i++) {			
			char savedChar = ID.charAt(i);				
			if(i<5) {
				if(!Character.isDigit(savedChar)) {
					throw new IllegalArgumentException("missing first 5 numbers");				
				}
			}
			if(i==5) {
				if(!Character.isLetter(savedChar)) {
					throw new IllegalArgumentException("missing last character");
				}
			}
		}		
		NAME = name;
		if(NAME==null || NAME == "") {
			throw new IllegalArgumentException("you must enter a name");
			
		}
		for(int i =0; i<=NAME.length()-1; i++) {
			char savedChar = NAME.charAt(i);			
			if(!Character.isLetter(savedChar)) {
				throw new IllegalArgumentException("names do not have numbers in them");
			}
		}
		INITIALCREDITS = initialCredits;		
		if(INITIALCREDITS < 0) {
			throw new IllegalArgumentException("initial credits cannot be lower than 0");
		}		
		CREDITS = INITIALCREDITS;
		BET = 0;
		
	}
	
	//getter for ID
	@Override
	public String getId() {
		
		return ID;
	}

	//getter for name	
	@Override
	public String getName() {
		
		return NAME;
	}
	
	//getter for initial credits
	@Override
	public int getInitalCredits() {
		
		return INITIALCREDITS;
	}
	
	//getter for credits
	@Override
	public int getCredits() {
		
		
		return CREDITS;
	}

	//getter for credits (didn't really understand this function)
	@Override
	public int getAvailableCredits() {		
		
		return CREDITS;
	}
	
	//functions adds inputed credits to current amount of credits
	@Override
	public void addCredits(int credits) {
		CREDITS = CREDITS + credits;
		
	}

	//getter for user's bet	
	@Override
	public int getBet() {
		
		return BET;
	}
	
	//setter for user's bet
	@Override
	public void setBet(int bet) {
		BET = BET + bet;		
		CREDITS = CREDITS - bet;		
		
	}
	
	//function to rest bet return it to 0
	@Override
	public void resetBet() {
		CREDITS = (CREDITS + BET);
		BET = 0;
		
	}
	
	//function to apply winAmount to credits
	@Override
	public void applyWin(int winAmount) {
		
		CREDITS = CREDITS + winAmount;
		BET = 0;
		
		
	}
	
	//simple toString function using string format to output to logger
	@Override
	public String toString() {		
		
		return String.format("Player %s, %s, Credits %s, Bet %s, Available %s",ID, NAME, INITIALCREDITS, BET, CREDITS);
		
	}

}
