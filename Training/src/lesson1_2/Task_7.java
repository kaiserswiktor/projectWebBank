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
		System.out.println("������� ���� ������");
		int day = scanner.nextInt();
		switch (day) {
		case (1):
			System.out.println("�����������");
			break;
		case (2):
			System.out.println("�������");
			break;
		case (3):
			System.out.println("�����");
			break;
		case (4):
			System.out.println("�������");
			break;
		case (5):
			System.out.println("�������");
			break;
		case (6):
			System.out.println("�������");
			break;
		case (7):
			System.out.println("�����������");
			break;
		default:
			System.out.println("��� � ����� ������� ������ �� ����������");
			break;
		}

	}

}
