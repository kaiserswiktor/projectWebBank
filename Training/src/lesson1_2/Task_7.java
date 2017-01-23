/**
 * 
 */
package lesson1_2;

import java.util.Scanner;

/**
 * @author User class defining day week
 */
public class Task_7 {
	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Введите день недели");
		int day = scanner.nextInt();
		switch (day) {
		case (1):
			System.out.println("Понедельник");
			break;
		case (2):
			System.out.println("Вторник");
			break;
		case (3):
			System.out.println("Среда");
			break;
		case (4):
			System.out.println("Четверг");
			break;
		case (5):
			System.out.println("Пятница");
			break;
		case (6):
			System.out.println("Суббота");
			break;
		case (7):
			System.out.println("Воскресенье");
			break;
		default:
			System.out.println("Дня с таким номером недели не существует");
			break;
		}

	}

}
