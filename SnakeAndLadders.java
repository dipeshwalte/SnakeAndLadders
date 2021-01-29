public class SnakeAndLadders {
	//Static Constants
	static final int NO_PLAY=0;
	static final int LADDER=1;
	static final int SNAKE=2;
	
	public static void main(String[] args) {
		
		int diceThrow = (int)(Math.ceil(Math.random()*10)%6)+1;
		int option = (int)(Math.ceil(Math.random()*10)%3);
		int position = 0;
		
		switch (option) {
			case NO_PLAY:
				
				break;
			case LADDER:
				position += diceThrow;
				break;
			case SNAKE:
				position -= diceThrow;
				break;
			default:
				break;
		}
		
		System.out.println("Player moved to position: "+position);
	}

}


