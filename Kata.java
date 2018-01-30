import java.util.*;

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

    public int sequence(int[] arr) {
	    if (arr.length == 0) return 0;
	    for (int i = 0; i < arr.length; i++) {
	      for (int j = i + 1; j < arr.length; j++) {
	        if (arr[i] < arr[j]) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
	        }
	      }
	    }
	    int sum = 0;
	    if (arr[0] >= 0) {
	        for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == arr[i + 1]) continue;
				sum += arr[i];
				if (arr[i] < 0) break;
		    }
	    }
	    return sum;
	 }

	public int sortDesc(final int num) {
		String str = "" + num;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] > charArray[j]) {
					char t = charArray[i];
					charArray[i] = charArray[j];
					charArray[j] = t;
				}
			}
		}
		int number = 0;
		for (int i = charArray.length - 1; i >= 0; i--) {
			number += (charArray[i] - '0') * Math.pow(10, i);
		}
		return number;
	}

	public boolean groupCheck(String s){
		Stack stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push(s.charAt(i));
			if (s.charAt(i) == ')') {
				if(stack.empty() || (Character)stack.pop() != '(') return false;
			}
			if (s.charAt(i) == ']') {
				if(stack.empty() || (Character)stack.pop() != '[') return false;
			}
			if (s.charAt(i) == '}') {
				if(stack.empty() || (Character)stack.pop() != '{') return false;
			}
		}
		return stack.empty();
	}

	public int dblLinear (int n) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= (n + 1) * 2; i++) {
        	int y = i * 2 + 1;
        	boolean isY = false;
        	for (int j = 0; j < arr.size(); j++) {
        		if (arr.get(j) == y) isY = true;
        	}
        	if (!isY) {
        		arr.add(i * 2 + 1);
        	}
        	y = i * 3 + 1;
        	isY = false;
        	for (int j = 0; j < arr.size(); j++) {
        		if (arr.get(j) == y) isY = true;
        	}
        	if (!isY) {
        		arr.add(i * 3 + 1);
        	}
        }
        Integer[] u = arr.toArray(new Integer[0]);
        Arrays.sort(u);
        System.out.println(Arrays.toString(u));
        return u[n];
    }

	public int nbYear(int p0, double percent, int aug, int p) {
		int index = 0;
		while (p0 < p) {
			p0 += p0 * percent / 100 + aug;
			index++;
		}
		return index;
    }

	public String toCamelCase(String s) {
		for (int i = 1; i < s.length(); i++) {
			if ((s.charAt(i) == '-' || s.charAt(i) == '_') && i + 1 < s.length()) {
				if (s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z') {
					s = s.substring(0, i + 1) + Character.toUpperCase(s.charAt(i + 1)) + s.substring(i + 2);
				}
			}
		}
	    s = s.replace("-", "");
	    s = s.replace("_", "");
		return s;
	}
	
	public List<Long> sumDigPow(long a, long b) {
		List<Long> list = new ArrayList<>();
        for (long i = a; i < b; i++) {
        	long powNum = 0;
        	int index = 1;
        	String s = String.valueOf(i);
        	for (int j = 0; j < s.length(); j++) {
        		int x = s.charAt(j) - '0';
        		powNum += (int) Math.pow(x, index);
        		index++;
        	}
        	if (powNum == i) {
        		list.add(powNum);
        	}
        }
        return list;
    }

    public int josephusSurvivor(final int n, final int k) {
    	int x = k - 1;
    	List<Integer> list = new ArrayList<>();
    	for (int i = 1; i <= n; i++) {
    		list.add(i);
    	}
    	while (list.size() > 1) {
    		while (list.size() <= x) {
    			x -= list.size();
    		}
    		list.remove(x);
    		x += k - 1;
    	}
    	return list.get(0);
	}

	public static String Tickets(int[] peopleInLine) {
	    int money25 = 0;
	    int money50 = 0;
	    int money100 = 0;
	    for (int i = 0; i < peopleInLine.length; i++) {
			switch (peopleInLine[i]) {
				case 25: money25++;
				break;
				case 50: {	
					money50++;
					if (money25 > 0) money25--;
					else return "NO";
				}
				break;
				case 100: {	
					money100++;
					if (money50 > 0 && money25 > 0) {
						money25--;
						money50--;
					} else return "NO";
				}
				break;
			}
	    }
	    return "YES";
	}

	public static void main(String[] args) {
		System.out.println("" + new Kata().josephusSurvivor(7, 3));
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
