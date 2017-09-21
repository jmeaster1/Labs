import java.sql.Date;
import java.util.Scanner;

/**
 * @author jimmy
 *
 */
public class HelloEclipse {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, Eclipse! What is your name?: ");
		Scanner keyboard = new Scanner(System.in);
		String name = keyboard.nextLine();
		System.out.println("Hi, " + name + "!");
		keyboard.close();
		System.out.println("Well, bye.");
		
		
		int i = 1, j = 10;
		do {
			if (i++ > --j) continue;
		} while (i < 5);
		System.out.println("i=" + i + " j=" + j);
	}
}
