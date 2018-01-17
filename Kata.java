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

	public String maskify(String str) {
		String newString = "";
		if (str.length() < 4) return str;
		for (int i = 0; i < str.length() - 4; i++) {
			newString += "#";
		}
		return newString + str.substring(str.length() - 4);
    }

    public int digital_root(int n) {
    	int temp = 0;
    	while (n > 0) {
    		temp += n % 10;
    		n /= 10;
    		if (n == 0 && temp > 9) {
    			n = temp;
    			temp = 0;
    		}
    	}
    	return temp;
  	}

	public boolean validPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() != 14) return false;
		for (int i = 0; i < phoneNumber.length(); i++) {
			if (i == 0 && phoneNumber.charAt(i) != '(') {
				return false;
			}
			if (i == 4 && phoneNumber.charAt(i) != ')') {
				return false;
			}
			if (i == 5 && phoneNumber.charAt(i) != ' ') {
				return false;
			}
			if (i == 9 && phoneNumber.charAt(i) != '-') {
				return false;
			}
			if (i != 0 && i != 4 && i != 5 && i != 9 && !Character.isDigit(phoneNumber.charAt(i))) {
				return false;
			} 
		}
		return true;
	}

	public char findMissingLetter(char[] array) {
		int len = array.length;
		char first = array[0];
		char miss = '\0';
		for (int i = 1; i < len; i++) {
			if (first + i != array[i]) { 
				miss = (char) (first + i);
				break;
			}
		}
	    return miss;
	}

	public String dashatize(int num) {
		num = num < 0 ? num * -1 : num;
		if (num < 10) return num + "";
		int x = num % 10;
		String temp = "";
		if (x % 2 == 1) {
			temp = "-" + x + temp;
		}
      	num /= 10;
  		while (num > 9) {
  			x = num % 10;
  			num /= 10;
  			if (x % 2 == 1) {
		      	if (temp.charAt(0) == '-') {
		        	temp = "-" + x + temp;
	  			} else temp = "-" + x + "-" + temp;
  			} else temp = x + temp;
  		}
  		if (num % 2 == 1) {
			temp = num + "-" + temp;
		}
  		return temp;
    }

	public static void main(String[] args) {
		System.out.println(new Kata().dashatize(-1));
		System.out.println(new Kata().dashatize(-28369));
		System.out.println(new Kata().dashatize(86320));
		System.out.println(new Kata().dashatize(974302));

		System.out.println("" + Color.BLUE.getText());
		System.out.println("" + Level.HIGH);
	}
}

enum Color {
	BLUE(1, "Blue"),
	GREEN(2, "Green"),
	RED(3, "Red");

	private final int id;
	private final String text;

	Color(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() { return id; }
	public String getText() { return text; }
}

enum Level {
    HIGH,
    MEDIUM,
    LOW
}
