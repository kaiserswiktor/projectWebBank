
package lesson1_2;

import java.util.*;

/**
 * @author User
 *class take the name and print welcome "user" his name
 */
public class Name {

	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("write your name");
		String name = scanner.next();
		System.out.println("God day " + name + "!");
	}

}
