import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		option: while (true) {
			System.out.println("Would you like to (e)ncrypt or (d)ecrypt your word?");

			String choice = keyboard.next();

			switch (choice) {
			case "e":

				encryptWord(keyboard);

				break;
			case "d":

				decryptWord(keyboard);

				break;
			default:
				System.out.println("Invalid entry");
				continue option;
			}
			break;
		}

	}

	public static String getInput(Scanner keyboard) {
		System.out.println("What is your word?");
		keyboard.nextLine();
		String w1 = keyboard.nextLine();
		return w1;

	}

	public static int moveWord(Scanner keyboard) {
		System.out.println("How many spaces would you like to shift by?");
		return keyboard.nextInt();
	}

	public static void encryptWord(Scanner keyboard) {
		String enteredWord = getInput(keyboard).toUpperCase();
		int spacesMoved = moveWord(keyboard) % 26;
		char[] letters = new char[enteredWord.length()];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = enteredWord.charAt(i);
			if (letters[i] != 32 && letters[i] >= 65 && letters[i] <= 90) {
				letters[i] = (char) ((letters[i] + spacesMoved) <= 90 ? (letters[i] + spacesMoved)
						: (letters[i] + spacesMoved - 26));

			}
			System.out.print(letters[i]);
		}

	}

	public static void decryptWord(Scanner keyboard) {
		String enteredWord = getInput(keyboard).toUpperCase();
		int spacesMoved = moveWord(keyboard) % 26;
		char[] letters = new char[enteredWord.length()];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = enteredWord.charAt(i);
			if (letters[i] != 32 && letters[i] >= 65 && letters[i] <= 90) {
				letters[i] = (char) ((letters[i] - spacesMoved) >= 65 ? (letters[i] - spacesMoved)
						: (letters[i] - spacesMoved + 26));
			}

			System.out.print(letters[i]);

		}
	}
}
