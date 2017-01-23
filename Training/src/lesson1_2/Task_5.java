/**
 * 
 */
package lesson1_2;

import java.util.Scanner;

/**
 * @author User
 *class considers optimal weight
 */
public class Task_5 {
	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("write your height");
		int height = scanner.nextInt();
		System.out.println("write your weight");
		int weight = scanner.nextInt();
		if (height - 100 == weight) {
			System.out.println(" you weight ideall!!!");
		} else if (height - 100 > weight) {
			int onWeight = height - 100 - weight;
			System.out.println(" you should dial on " + onWeight);
		} else if (height - 100 < weight) {
			int onWeight = weight - (height - 100);
			System.out.println(" you should grow thin on " + onWeight);
		}
	}

}
