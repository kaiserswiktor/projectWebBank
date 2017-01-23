/**
 * 
 */
package lesson1_2;

import java.util.Scanner;

/**
 * @author User
 * class compare two number
 */
public class Task_2 {

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
		if (firstNumber > secondNumber) {
			System.out.println(firstNumber + " more " + secondNumber);
		} else if (firstNumber < secondNumber) {
			System.out.println(secondNumber + " more " + firstNumber);
		} else if (firstNumber == secondNumber) {
			System.out.println(secondNumber + " equally " + firstNumber);
		}
	}

}
