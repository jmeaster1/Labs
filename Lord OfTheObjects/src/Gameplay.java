import java.util.Scanner;

public class Gameplay {

	static GoodGuy g1 = new GoodGuy();
	static BadGuy b1 = new BadGuy();
	static Weapon[] goodGuyWeapons = { new Weapon("Fart Gun", 10), new Weapon("Snot Rocket", 15),
			new Weapon("T-Rex", 20), new Weapon("Rubber Chicken", 18),
			new Weapon("a Chicken...like, an actual Chicken", 17), new Weapon("Java textbook", 25) };
	static Weapon[] badGuyWeapons = { new Weapon("Laser Beam", 5), new Weapon("Sharknado!", 10),
			new Weapon("garbage truck", 15), new Weapon("Spare Tire", 18),
			new Weapon("Steve's smelly running shoes", 17), new Weapon("Pervasive Body Odor", 25) };

	public static void main(String[] args) throws InterruptedException {
		int turn = 0;
		int menuChoice = 0;
		int random = (int) ((Math.random() * 5) + 1);//

		Scanner keyboard = new Scanner(System.in);

		initGame(keyboard, menuChoice, random, turn);

	}

	// this method throws an "Exception" because of THREAD.SLEEP(). the compiler is
	// saying that there MAY be an exception
	// so you must handle the exception by THROWING IT or CATCHING IT using a
	// TRY/CATCH
	// you will get an exception IF the parameter is negative
	public static void initGame(Scanner keyboard, int choice, int random, int turn) throws InterruptedException {

		g1.setHealth(300);
		g1.setWeapon(goodGuyWeapons[random]);
		g1.setName("Good Guy Gus");

		b1.setHealth(80);
		b1.setWeapon(badGuyWeapons[random]);

		System.out.println("Welcome to the most random adventure EVER!");
		Thread.sleep(1000);
		System.out.println("See if you can get the treasure.\nYou will need to defeat multiple enemies along the way");
		Thread.sleep(2000);
		System.out.println("Are you ready to begin? (1) Heck Ya (2) Nope");

		choice = keyboard.nextInt();
		while (choice == 1 && turn < 3) {
			// System.out.println("Meet your imaginary random character you will vicariously
			// live through for the next 30 seconds: ");
			turn = battleSeq(keyboard, choice, random, turn);
			if (g1.getHealth() <= 0) {
				choice = playAgain(choice, keyboard);
			}
		}
//	
			methTreasure();
//		
	}

	public static int battleSeq(Scanner keyboard, int menuChoice, int random, int turn) throws InterruptedException {

		System.out.println(g1);

		System.out.println();
		Thread.sleep(2400);
		switch (turn) {
		case 0:
			System.out.println("Release the Kraken!!!...like the rum? Doesn't matter. FIGHT!\n");
			b1.setName("World hunger");
			break;
		case 1:
			System.out.println("Do you feel lucky, punk? Well, do ya? Ready or not, here we go!\n");
			b1.setName("The Michigan Wolverine");
			break;
		case 2:
			System.out.println("Hide your kids! Hide your wife! It's about to go DOWN!\n");
			b1.setName("Frockalypse");
			break;


		}
		Thread.sleep(1500);
		System.out.println("**********POW!**********");
		Thread.sleep(1500);
		System.out.println("****BAM!!***************");
		Thread.sleep(1500);
		System.out.println("**************WTF??*****");
		Thread.sleep(1500);

		while (b1.getHealth() >= 0 && g1.getHealth() >= 0) {
			b1.attack(g1);
			g1.attack(b1);
		}

		if (b1.getHealth() <= 0) {
			turn++;
			System.out.println("Congratulations, you won! Are you not entertained?");
			Thread.sleep(1000);
			System.out.println("Your remaining health is: " + g1.getHealth() + ". You have defeated " + b1.getName()
					+ "'s " + b1.getWeapon().getName() + " with your " + g1.getWeapon().getName() + ".");
			System.out.println();
			if (turn < 3) {
				System.out.println("Are you ready for the next engagement? 1) Heck Ya (2) Nope");
				menuChoice = keyboard.nextInt();
				if (menuChoice == 1) {
					b1 = new BadGuy();
					b1.setHealth(80);
					random = (int) ((Math.random() * 5) + 1);
					System.out.println();
					b1.setWeapon(badGuyWeapons[random]);
					g1.setWeapon(goodGuyWeapons[random]);
				}
			}
			

		}
		return turn;
	}

	public static int playAgain(int menuChoice, Scanner keyboard) {
		System.out.println("You dead. Straight up. You got knocked the &*%^ out!");
		System.out.println("Are you a glutton for punishment? Want some more? (1) Heck Ya (2) Nope");
		menuChoice = keyboard.nextInt();
		return menuChoice;
	}

	public static void methTreasure() throws InterruptedException {
		System.out.println("****************************************************");
		Thread.sleep(400);
		System.out.println("****                                            ****");
 		Thread.sleep(400);
		System.out.println("**** CHUCK NORRIS THANKS YOU FOR YOUR SERVICE   ****");
		Thread.sleep(400);
		System.out.println("**** YOU HAVE BEEN AWARDED THE WEEKEND OFF      ****");
		Thread.sleep(400);
		System.out.println("****...EXCEPT YOU SHOULD PROBABLY STILL COME IN ****");
		Thread.sleep(400);
		System.out.println("****                                            ****");
		Thread.sleep(400);
		System.out.println("****************************************************\n");
		System.out.println("THIS PROGRAM BROUGHT TO YOU BY: THE 2 BEST BEARDS IN THE ROOM...YOU'RE WELCOME");

	}
}
