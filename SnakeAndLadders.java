public class SnakeAndLadders {
	//Static Constants
	static final int NO_PLAY=0;
	static final int LADDER=1;
	static final int SNAKE=2;
	static final int PLAYER_1_TURN=1;
	static final int PLAYER_2_TURN=2;
		
	private static int returnPositionAfterLadder(int diceThrow,int position,int playerTurn) {
		position += diceThrow;
		if(position>100) {
			position -= diceThrow;
		}
		System.out.println("Ladder! :-) Player " +playerTurn +" Position :"+position);
		return position;
	}

	private static int returnPositionAfterSnake(int diceThrow,int position,int playerTurn) {
		position -= diceThrow;
		if(position<0) {
			position = 0;
		}
		System.out.println("Snake! :-( Player " +playerTurn +" Position :"+position);
		return position;
	}

	public static void main(String[] args) {
		//variables
		int player1Position = 0;
		int player2Position = 0;
		int diceThrowCount = 0;
		int turn = PLAYER_2_TURN;
		boolean ladderFlag=false;

		while(player1Position<100 && player2Position<100)
		{
			if(ladderFlag)
				ladderFlag=false;
			else {
				if(turn==PLAYER_1_TURN)
					turn=PLAYER_2_TURN;
				else
					turn=PLAYER_1_TURN;
			}
			int diceThrow = (int)(Math.ceil(Math.random()*10)%6)+1;
			diceThrowCount++;
			int option = (int)(Math.ceil(Math.random()*10)%3);
			switch (option) {
				case NO_PLAY:

					if(turn==PLAYER_1_TURN)
						System.out.println("No Play.. :-| Player 1 Position :"+player1Position);
					else
						System.out.println("No Play.. :-| Player 2 Position :"+player2Position);
					break;

				case LADDER:

					ladderFlag=true;
					if(turn==PLAYER_1_TURN)
						player1Position = returnPositionAfterLadder(diceThrow, player1Position, PLAYER_1_TURN);
					else
						player2Position = returnPositionAfterLadder(diceThrow, player2Position, PLAYER_2_TURN);
					break;

				case SNAKE:

					if(turn==PLAYER_1_TURN)
						player1Position = returnPositionAfterSnake(diceThrow, player1Position, PLAYER_1_TURN);
					else
						player2Position = returnPositionAfterSnake(diceThrow, player2Position, PLAYER_2_TURN);
					break;
				default:
					break;

			}//end switch
		}//end while
		System.out.println("No of times dice was cast: "+diceThrowCount);
		if(player1Position==100)
			System.out.println("Player 1 won!!");
		else
			System.out.println("Player 2 won!!");
	}
}
