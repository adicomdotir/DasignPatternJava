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

	public int squareDigits(int n) {
		String temp = "";
		while(n > 0) {
			int x = n % 10;
			x *= x;
			temp = x + temp;
			n /= 10;
		}
		return Integer.parseInt(temp);
	}

	public int solution(int number) {
	    int sum = 0;
	    for (int i = 1; i < number; i++) {
	    	if (i % 3 == 0 || i % 5 == 0) {
	    		sum += i;
	    	}
	    }
	    return sum;
	}

	public boolean getXO(String str) {
		int countX, countO;
		countX = countO = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'x' || str.charAt(i) == 'X') {
				countX++;
			} else if (str.charAt(i) == 'o' || str.charAt(i) == 'O') {
				countO++;
			}
		}
		return countX == countO;
	}

	public static void main(String[] args) {
		System.out.println(new Kata().solution(10));
	}
}