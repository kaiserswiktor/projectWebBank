/**
 * 
 */
package lesson1_2;

import java.util.Scanner;

/**
 * @author User
 *  class determinated leap year 
 */
public class Task_4 {
	private static Scanner scanner;
	private static int year;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		determinated();
	}

	public static void determinated() {
		scanner = new Scanner(System.in);
		System.out.println("write year");
		year = scanner.nextInt();
		if (year % 400 == 0) {
			System.out.println("Year-leap ");
		} else if (year % 100 == 0) {
			System.out.println("Year-no leap ");
		} else if (year % 4 == 0) {
			System.out.println("Year-leap ");
		} else {
			System.out.println("Year- no leap ");
		}
	}
}
