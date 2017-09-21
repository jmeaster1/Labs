import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// String tttboard[][] = new String[][] {
		// {"*", "*", "*"},
		// {"*", "*", "*"},
		// {"*", "*", "*"}
		// };

		// declaring and initializing a new 3x3 array
		String tttboard[][] = new String[3][3];

		// putting "*" in each spot using a nested for loop
		for (int i = 0; i < tttboard.length; i++) {
			for (int j = 0; j < tttboard.length; j++) {
				tttboard[i][j] = "*";
			}
		}

		int counter = 1;

		System.out.println("What mark would you like to use (X or O)?");
		String mark = keyboard.next();// saves player 1's mark

		do {
			System.out.println("What is the X coordinate of your move?");
			int x = keyboard.nextInt();

			System.out.println("What is the Y coordinate of your move?");
			int y = keyboard.nextInt();

			if (tttboard[x][y].equals("*")) {
				tttboard[x][y] = mark;// first move entered as long as they choose a box that contains a "*" and not
										// the opponent's mark.
				if (mark.equalsIgnoreCase("x")) {
					mark = "o";// ensures that player 1 and player 2 cannot choose the same mark.

				} else {
					mark = "x";

				}

				counter++;// counts the number of turns taken

			} else {

				System.out.println("Illegal move please choose again.");
			}

			System.out.println("amount of turns: " + counter);

			for (int i = 0; i < tttboard.length; i++) {// display the board
				for (int j = 0; j < tttboard.length; j++) {
					System.out.print(tttboard[i][j] + " ");
				}
				System.out.println();
			}
		} while (!checkForWinner(tttboard) && counter < 10);// There can only be a max of 9 turns in a game
	}

	public static boolean checkForWinner(String[][] tttboard) {
		boolean haveWinner = false;
		String winner = " ";
		// horizontal row check for winner strategy
		for (int row = 0; row < 3; row++) {
			if (tttboard[row][0].equals(tttboard[row][1]) && tttboard[row][1].equals(tttboard[row][2])
					&& !tttboard[row][0].equals("*")) {
				haveWinner = true;
				winner = tttboard[row][0];
				break;
			}
			// vertical row check for winner strategy
		}
		for (int col = 0; col < 3; col++) {
			if (tttboard[0][col].equals(tttboard[1][col]) && tttboard[1][col].equals(tttboard[2][col])
					&& !tttboard[0][col].equals("*")) {
				haveWinner = true;
				winner = tttboard[0][col];
				break;
			}
		} // diagonal 1 check
		if (tttboard[0][0].equals(tttboard[1][1]) && tttboard[1][1].equals(tttboard[2][2])
				&& !tttboard[1][1].equals("*")) {
			haveWinner = true;
			winner = tttboard[1][1];

		} // diagonal 2 check
		if (tttboard[0][2].equals(tttboard[1][1]) && tttboard[1][1].equals(tttboard[2][0])
				&& !tttboard[1][1].equals("*")) {
			haveWinner = true;
			winner = tttboard[1][1];

		} // congratulates the winner
		if (haveWinner) {
			System.out.println("The winner is: " + winner + "!");
		}
		return haveWinner;
	}

}
