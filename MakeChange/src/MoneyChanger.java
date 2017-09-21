import java.util.Scanner;

public class MoneyChanger {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);// Scanner created to receive user input
		makeChange();
	}

	public static void makeChange() {
		double itemCost, amtTend;
		Scanner keyboard = new Scanner(System.in);// Scanner created to receive user input

		System.out.println("What is the price of the item you would like to purchase?: ");// Prompts user for item cost
		itemCost = keyboard.nextDouble();

		System.out.println("What is the amount tendered?: ");// Prompts user for amount tendered
		amtTend = keyboard.nextDouble();

		double changeDue = (amtTend - itemCost);// calculates total change due

		int change = (int) ((amtTend * 100) - (100 * itemCost));// converts the total change due into cents and casts
																// into an int because I want the number
																// of whole dollar bills (ex: 5, not 5.12)

		int numHundreds = change / 10000;// determines how many 50 dollar bills
		change = change % 10000;// determines remaining change for next calculation
		if (numHundreds == 1) {
			System.out.println(numHundreds + " Hundred");// ensures that the denominations do not print if equal to zero
		} else if (numHundreds > 1) {
			System.out.println(numHundreds + " Hundreds");
		}

		int numFifties = change / 5000;// determines how many 50 dollar bills
		change = change % 5000;// determines remaining change for next calculation
		if (numFifties == 1) {
			System.out.println(numFifties + " Fifty");// ensures that the denominations do not print if equal to zero
		} else if (numFifties > 1) {
			System.out.println(numFifties + " Fifties");
		}

		int numTwenties = change / 2000;// determines how many 20 dollar bills
		change = change % 2000;// determines remaining change for next calculation
		if (numTwenties == 1) {
			System.out.println(numTwenties + " Twenty");// ensures that the denominations do not print if equal to zero
		} else if (numTwenties > 1) {
			System.out.println(numTwenties + " Twenties");
		}

		int numTens = change / 1000;// determines how many 10 dollar bills
		change = change % 1000;// determines remaining change for next calculation
		if (numTens == 1) {
			System.out.println(numTens + " Ten");// ensures that the denominations do not print if equal to zero
		} else if (numTens > 1) {
			System.out.println(numTens + " Tens");
		}

		int numFives = change / 500;// determines how many 5 dollar bills
		change = change % 500;// determines remaining change for next calculation
		if (numFives == 1) {
			System.out.println(numFives + " Five");// ensures that the denominations do not print if equal to zero
		} else if (numFives > 1) {
			System.out.println(numFives + " Fives");
		}

		int numOnes = change / 100;// determines how many dollar bills
		change = change % 100;// determines remaining change for next calculation
		if (numOnes == 1) {
			System.out.println(numOnes + " One");// ensures that the denominations do not print if equal to zero
		} else if (numOnes > 1) {
			System.out.println(numOnes + " Ones");
		}

		int numQuarters = change / 25;// determines how many quarters
		change = change % 25;

		if (numQuarters == 1) {
			System.out.println(numQuarters + " Quarter");
		} else if (numQuarters > 1) {
			System.out.println(numQuarters + " Quarters");
		}
		int numDimes = change / 10;// determines how many dimes
		change = change % 10;

		if (numDimes == 1) {
			System.out.println(numDimes + " Dime");
		} else if (numDimes > 1) {
			System.out.println(numDimes + " Dimes");
		}
		int numNickels = change / 5;// determines how many nickels
		change = change % 5;

		if (numNickels == 1) {
			System.out.println(numNickels + " Nickel");
		} else if (numNickels > 1) {
			System.out.println(numNickels + " Nickels");
		}
		int numPennies = change;// determines how many pennies
		if (numPennies == 1) {
			System.out.println(numPennies + " Penny");
		} else if (numPennies > 1) {
			System.out.println(numPennies + " Pennies");
		}

		if (itemCost > amtTend) {
			System.out.println("You don't have enough money to purchase this item ");// message displays if user
																						// doesn't have enough $
		} else if (itemCost == amtTend) {
			System.out.println("You have paid the exact amount. No change is due.");// message displays if user pays in
																					// exact change
		} else if (amtTend > itemCost) {

			System.out.printf("You are due $ %.2f in change from this transaction.", changeDue);// limits decimal
																								// precision to 2
		} 																						// decimal places
	}

}
