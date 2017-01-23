
package lesson1_2;

/**
 * @author User
 *class share word on two part
 */
public class Task_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String word = "Hearthstone";
		System.out.println(word.length());
		String firstPartWord = word.substring(0, word.length() / 2 + 1);
		String secondPartWord = word.substring(word.length() - word.length() / 2);
		System.out.println(firstPartWord + "-" + secondPartWord);
	}

}
