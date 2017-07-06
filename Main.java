import java.util.stream.*;
import java.util.*;

public class Main {
	@Override
	public void finalize(){
		System.out.println("object is garbage collected");
	}

	public static Integer threadCounter = new Integer(0);
	public static void main(String[] args) {

		// THIS EDIT BY VIM
		Student p1 = new Student();
		Student p2 = new Student();
		p2.setGrade(15.2);
		System.out.println(p1.equals(p2));

		Circle c1 = new Circle(2);
		Circle c2 = c1;
		System.out.println(c1.equals(c2));
		c2 = new Circle(2);
		System.out.println(c1.equals(c2));

		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);

		myStream();

		MathOperation division = (int a, int b) -> a / b;
		System.out.println("" + division.operation(8,2));

		methodReferencesExample();

		List<Integer> list = Arrays.asList(1, 2, 3, 5, 4);
		list.forEach(x -> System.out.println(x));

		String value = "hassan";
		String str = Optional.ofNullable(value).map(x -> x.toUpperCase()).orElse("NONE");
		System.out.println(str);

		for (int i=0; i<5; i++) {
			Thread t = new Thread(new CountAndPrint("Instance " + i));
			t.start();
			try {
				t.join();
			}
			catch(Exception e) {
				e.getMessage();
			}
		}

		System.out.println("");
		System.out.println("Thread Counter: " + threadCounter);

		Main m = new Main();
		m = null;
		System.gc();
	}

	public static void myStream() {
		Stream<String> fruitStream = Stream.of("tomato", "apple",
			"banana", "kiwi", "orange");
		fruitStream.filter(s -> s.contains("a"))
		.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	public static void methodReferencesExample() {
		System.out.println("/////////////////////////");
		System.out.println("Method References Example");
		System.out.println("/////////////////////////");
		List names = new ArrayList();
		names.add("Sajjad");
		names.add("Saeed");
		names.add("Farzad");
		names.forEach(x -> System.out.println(x));
		// names.forEach(System.out::println);
	}

	/*
	Given an array of ints, compute recursively the number of times that the
	value 11 appears in the array. We'll use the convention of considering
	only the part of the array that begins at the given index. In this way,
	a recursive call can pass index+1 to move down the array. The initial
	call will pass in index as 0.

	array11([1, 2, 11], 0) → 1
	array11([11, 11], 0) → 2
	array11([1, 2, 3, 4], 0) → 0
	*/
	public int array11(int[] nums, int index) {
		if(nums.length == 0) return 0;
		if(nums[index] == 11) return 1 + array11(nums, index+1);
		else return array11(nums, index + 1);
	}

	/*
	Given an array of ints, compute recursively if the array contains somewhere a
	value followed in the array by that value times 10. We'll use the convention
	of considering only the part of the array that begins at the given index.
	In this way, a recursive call can pass index+1 to move down the array.
	The initial call will pass in index as 0.

	array220([1, 2, 20], 0) → true
	array220([3, 30], 0) → true
	array220([3], 0) → false
	*/
	public boolean array220(int[] nums, int index) {
		if(index == nums.length-1) return false;
		if(nums.length == 1) return false;
		if(nums[index]*10 == nums[index+1]) return true;
		else return array220(nums, index+1);
	}

	/*
	Given a string, compute recursively a new string where identical chars that
	are adjacent in the original string are separated from each other by a "*".

	pairStar("hello") → "hel*lo"
	pairStar("xxyy") → "x*xy*y"
	pairStar("aaaa") → "a*a*a*a"
	*/
	public String pairStar(String str) {
		if(str.length() <= 1) return str;
		if(str.charAt(0) == str.charAt(1)) return str.charAt(0) + "*" + pairStar(str.substring(1));
		else return str.substring(0, 1) + pairStar(str.substring(1));
	}

	/*
	Given a string, compute recursively a new string where all the lowercase 'x'
	chars have been moved to the end of the string.

	endX("xxre") → "rexx"
	endX("xxhixx") → "hixxxx"
	endX("xhixhix") → "hihixxx"
	*/
	public String endX(String str) {
		if(str.length() <= 1) return str;
		if(str.charAt(0) == 'x') return endX(str.substring(1)) + 'x';
		else return str.substring(0,1) + endX(str.substring(1));
	}

	/*
	We'll say that a "pair" in a string is two instances of a char separated
	by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA"
	contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number
	of pairs in the given string.

	countPairs("axa") → 1
	countPairs("axax") → 2
	countPairs("axbx") → 1
	*/
	public int countPairs(String str) {
		if (str.length() < 3) return 0;
		if (str.charAt(0) == str.charAt(2))
			return 1 + countPairs(str.substring(1));
		return countPairs(str.substring(1));
	}

	/*
	Count recursively the total number of "abc" and "aba" substrings that
	appear in the given string.

	countAbc("abc") → 1
	countAbc("abcxxabc") → 2
	countAbc("abaxxaba") → 2
	*/
	public int countAbc(String str) {
		if(str.length() < 3) return 0;
		if(str.charAt(0) == 'a' && str.charAt(1) == 'b' && str.charAt(2) == 'c') return 1 + countAbc(str.substring(3));
		if(str.charAt(0) == 'a' && str.charAt(1) == 'b' && str.charAt(2) == 'a') return 1 + countAbc(str.substring(3));
		return countAbc(str.substring(1));
	}
	
	/*
	Given a string, compute recursively (no loops) the number of "11" 
	substrings in the string. The "11" substrings should not overlap.

	count11("11abc11") → 2
	count11("abc11x11x11") → 3
	count11("111") → 1
	*/
	public int count11(String str) {
		if(str.length() < 2) return 0;
		if(str.charAt(0)=='1' && str.charAt(1)=='1') return 1 + count11(str.substring(2));
		else return count11(str.substring(1));
	}
	
	/*
	Given a string, return recursively a "cleaned" string where adjacent
	chars that are the same have been reduced to a single char. 
	So "yyzzza" yields "yza".

	stringClean("yyzzza") → "yza"
	stringClean("abbbcdd") → "abcd"
	stringClean("Hello") → "Helo" 
	*/
	public String stringClean(String str) {
		if(str.length() < 2) return str;
		if(str.charAt(0)==str.charAt(1)) return stringClean(str.substring(1));
		else return str.substring(0,1) + stringClean(str.substring(1));
	}
	
	/*
	Given a string, compute recursively the number of times lowercase 
	"hi" appears in the string, however do not count "hi" that have 
	an 'x' immedately before them.

	countHi2("ahixhi") → 1
	countHi2("ahibhi") → 2
	countHi2("xhixhi") → 0
	*/
	public int countHi2(String str) {
		if(str.length() < 2) return 0;
		if(str.charAt(0) == 'h' && str.charAt(1) == 'i') return 1 + countHi2(str.substring(2));
		if(str.charAt(0) == 'x' && str.charAt(1) == 'h' && str.charAt(2) == 'i') return countHi2(str.substring(2));
		else return countHi2(str.substring(1));
	}
	
	/*
	Given a string that contains a single pair of parenthesis, compute
	recursively a new string made of only of the parenthesis and their
	contents, so "xyz(abc)123" yields "(abc)".

	parenBit("xyz(abc)123") → "(abc)"
	parenBit("x(hello)") → "(hello)"
	parenBit("(xy)1") → "(xy)"
	*/
	public String parenBit(String str) {
		int len = str.length();
		if(len < 2) return "";
		if(str.charAt(0) == '(' && str.charAt(len-1) == ')') return str;
		if(str.charAt(0) == '(' && str.charAt(len-1) != ')') return parenBit(str.substring(0,len-1));
		else return parenBit(str.substring(1));
	}
}

class CountAndPrint implements Runnable {
	private final String name;
	CountAndPrint(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Main.threadCounter++;
			System.out.println(this.name + ": " + i);
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
   		System.out.println("My thread is in running state.");
  	}
}
