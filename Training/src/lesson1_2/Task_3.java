/**
 * 
 */
package lesson1_2;

import java.util.Scanner;

/**
 * @author User class share two number
 */
public class Task_3 {
	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("write first number");
		double firstNumber = scanner.nextDouble();
		System.out.println("write second number");
		double secondNumber = scanner.nextDouble();
		double numberPrivat = firstNumber / secondNumber;
		System.out.println("private two number=" + numberPrivat);
	}

}
