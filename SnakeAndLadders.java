public class SnakeAndLadders {
	//Static Constants
	static final int NO_PLAY=0;
	static final int LADDER=1;
	static final int SNAKE=2;
	
	public static void main(String[] args) {
		//variables
		int position = 0;
		int diceThrowCount = 0;
		
		while(position<100)
		{
			int diceThrow = (int)(Math.ceil(Math.random()*10)%6)+1;
			diceThrowCount++;
			int option = (int)(Math.ceil(Math.random()*10)%3);
			switch (option) {
				case NO_PLAY:
					System.out.println("No Play.. :-| Player Position :"+position);
					break;
				case LADDER:
					position += diceThrow;
					if(position>100) {
						position -= diceThrow;
					}
					System.out.println("Ladder! :-) Player Position :"+position);
					break;
				case SNAKE:
					position -= diceThrow;
					if(position < 0) {
						position = 0;
					}
					System.out.println("Snake! :-( Player Position :"+position);
					break;
				default:
					break;
			}//end switch
		}//end while
		System.out.println("No of times dice was cast: "+diceThrowCount);
		System.out.println("Player moved to position: "+position+" and won");
	}

}
