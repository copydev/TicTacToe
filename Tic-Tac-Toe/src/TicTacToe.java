import java.util.Scanner;

//Manager Class
public class TicTacToe {

	private Player player1, player2;
	private Board board;
	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startGame();
	}

	public void startGame() {
		Scanner s = new Scanner(System.in);
		// Players input

		System.out.println("Welcome to Tic-Tac-Toe Game");

		player1 = takePlayerInput(1);

		player2 = takePlayerInput(2);

		while (player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Symbol Already Taken. Pick Another Symbol");
			char symbol = s.nextLine().charAt(0);
			player2.setSymbol(symbol);
		}

		// Create board
		board = new Board(player1.getSymbol(), player2.getSymbol());

		// Conduct the game
		boolean player1Turn = true;
		int status = 5;
		while (status == Board.INCOMPLETE || status == Board.INVALID) {
			if (player1Turn) {
				System.out.println("Player 1 - " + player1.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player1.getSymbol(), x, y);
				if (status != Board.INVALID) {
					player1Turn = false;
					board.print();
				}
				else{
					System.out.println("Invalid Move !! Try Again !!");
				}

			} else {
				System.out.println("Player 2 - " + player2.getName() + "'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				status = board.move(player2.getSymbol(), x, y);
				if (status != Board.INVALID) {
					player1Turn = true;
					board.print();
				}
				else{
					System.out.println("Invalid Move !! Try Again !!");
				}

			}

		}
		if(status ==Board.PLAYER_1_WINS){
			System.out.println("Player 1 "+player1.getName()+" wins!!");
		}
		else if(status == Board.PLAYER_2_WINS){
			System.out.println("Player 2 "+player2.getName()+" wins!!");
		}
		else{
			System.out.println("Draw!!");
		}

	}

	private Player takePlayerInput(int num) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Player " + num + " name: ");
		String playerName = scn.nextLine();
		System.out.println("Enter Player " + num + " symbol: ");
		char symbol = scn.nextLine().charAt(0);
		Player p = new Player(playerName, symbol);
		return p;
	}

}
