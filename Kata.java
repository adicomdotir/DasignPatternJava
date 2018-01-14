import java.util.Arrays;

public class Kata {
	public static int[] sortArray(int[] array) {
		if (array == null || array.length == 0) return array;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] % 2 == 1 && array[j] % 2 == 1) {
					if (array[i] > array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}
		return array;
	}

	public String toJadenCase(String phrase) {
		if (phrase == null || phrase.length() == 0) return null;
		phrase = Character.toUpperCase(phrase.charAt(0)) + phrase.substring(1);
		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == ' ') {
				phrase = phrase.substring(0, i + 1) + Character.toUpperCase(phrase.charAt(i + 1)) + phrase.substring(i + 2);
			}		
		}	
		return phrase;
	}

	public static void main(String[] args) {
		System.out.println(new Kata().toJadenCase("most trees are blue"));
	}
}