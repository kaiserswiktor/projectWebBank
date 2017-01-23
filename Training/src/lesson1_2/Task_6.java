/**
 * 
 */
package lesson1_2;

import java.util.Scanner;

/**
 * @author User
 *class substitute word 
 */
public class Task_6 {
	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("введите количество (целым числом)");
		int rubley = scanner.nextInt();
		if (rubley == 11 | rubley == 12 | rubley == 13 | rubley == 14 | rubley % 10 == 5 | rubley % 10 == 6
				| rubley % 10 == 7 | rubley % 10 == 8 | rubley % 10 == 9 | rubley % 10 == 0) {
			System.out.println(rubley + "-рублей");
		} else if (rubley % 10 == 1) {
			System.out.println(rubley + "-рубль");
		} else if (rubley % 10 == 2 | rubley % 10 == 3 | rubley % 10 == 4) {
			System.out.println(rubley + "-рубля");
		}
	}

}
