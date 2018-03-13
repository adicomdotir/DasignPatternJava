import java.util.stream.*;
import java.util.*;

public class Main {

	// Code Convention For Java
	public static final int MAX = 100;
	public static int count = 0;
	private static int sInner = 0;
	private int mMin = 0;
	protected int mMax = 0;

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

	public void weightedMean() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] xArray = new int[n];
		int[] wArray = new int[n];
		for (int i = 0; i < n; i++) {
			xArray[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			wArray[i] = sc.nextInt();
		}

		float result = 0;
		int w = 0;
		for (int i = 0; i < n; i++) {
			result += xArray[i] * wArray[i];
			w += wArray[i];
		}
		System.out.println(result / w + "");
	}

	public void interquartileRange() {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] el = new int[n];
        int[] fr = new int[n];
        for (int i = 0; i < n; i++) {
            el[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            fr[i] = sc.nextInt();
        }
        int size = 0;
        for (int i = 0; i < n; i++) {
            size += fr[i];
        }
        int[] arr = new int[size];
        int j = 0;
        for(int i = 0; i < n; i++) {
            for (int k = 0; k < fr[i]; k++) {
                arr[j] = el[i];
                j++;
            }
        }
        Arrays.sort(arr);
        int mid = size / 2;
        int q1 = 0;
        if (mid % 2 == 0) {
            q1 = arr[mid / 2] + arr[mid / 2 - 1] / 2;
        } else {
            q1 = arr[mid / 2];
        }
        int q3 = 0;
        if (mid % 2 == 0) {
            q3 = arr[size - mid / 2] + arr[size - mid / 2 - 1] / 2;
        } else {
            q3 = arr[size - mid / 2 - 1];
        }
        System.out.println("" + (q3 - q1));
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
	}

	/*
	Given a string, return true if it is a nesting of zero or more pairs
	of parenthesis, like "(())" or "((()))". Suggestion: check the first
	and last chars, and then recur on what's inside them.

	nestParen("(())") → true
	nestParen("((()))") → true
	nestParen("(((x))") → false
	*/
	public boolean nestParen(String str) {
		int len = str.length();
    	if(len==0) return true;
		if(len==1) return false;
		if(str.charAt(0)=='(' && str.charAt(len-1)==')') return nestParen(str.substring(1,len-1));
		else return false;
	}

	/*
	Given a string and a non-empty substring sub, compute recursively
	the number of times that sub appears in the string, without the
	sub strings overlapping.

	strCount("catcowcat", "cat") → 2
	strCount("catcowcat", "cow") → 1
	strCount("catcowcat", "dog") → 0
	*/
	public int strCount(String str, String sub) {
		int len = sub.length();
		if(str.length() < len) return 0;
		if(str.substring(0,len).equals(sub)) return 1 + strCount(str.substring(len), sub);
		else return strCount(str.substring(1), sub);
	}

	/*
	Given a string and a non-empty substring sub, compute recursively
	if at least n copies of sub appear in the string somewhere,
	possibly with overlapping. N will be non-negative.

	strCopies("catcowcat", "cat", 2) → true
	strCopies("catcowcat", "cow", 2) → false
	strCopies("catcowcat", "cow", 1) → true
	*/
	public boolean strCopies(String str, String sub, int n) {
		int len = sub.length();
		if(str.length() < len) {
			if(n == 0) return true;
			else return false;
		}
		if(str.substring(0,len).equals(sub)) return strCopies(str.substring(1), sub, n-1);
		else return strCopies(str.substring(1), sub, n);
	}

	/*
	Given a string and a non-empty substring sub, compute recursively
	the largest substring which starts and ends with sub and return
	its length.

	strDist("catcowcat", "cat") → 9
	strDist("catcowcat", "cow") → 3
	strDist("cccatcowcatxx", "cat") → 9
	*/
	public int strDist(String str, String sub) {
  		int len = sub.length();
  		if(str.length() < len) return 0;
  		if(str.substring(0,len).equals(sub) && str.substring(str.length() - len).equals(sub))
  			return str.length();
  		if(!str.substring(0,len).equals(sub))
  			return strDist(str.substring(1), sub);
  		return strDist(str.substring(0, str.length() - 1), sub);
	}

	/*
	Given an array of strings, return a Map<String, Integer> containing
	a key for every different string in the array, always with the value 0.
	For example the string "hello" makes the pair "hello":0. We'll do more
	complicated counting later, but for this problem the value is simply 0.

	word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
	word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
	word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
	*/
	public Map<String, Integer> word0(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		for(String str: strings) {
			map.put(str, 0);
		}
		return map;
	}

	/*
	Given an array of strings, return a Map<String, Integer> containing
	a key for every different string in the array, and the value is
	that string's length.

	wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
	wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
	wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
	*/
	public Map<String, Integer> wordLen(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		for(String str: strings) {
			map.put(str, str.length());
		}
		return map;
	}

	/*
	Given an array of non-empty strings, create and return a
	Map<String, String> as follows: for each string add its first
	character as a key with its last character as the value.

	pairs(["code", "bug"]) → {"b": "g", "c": "e"}
	pairs(["man", "moon", "main"]) → {"m": "n"}
	pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
	*/
	public Map<String, String> pairs(String[] strings) {
		Map<String, String> map = new HashMap<>();
		for(String str: strings) {
			map.put(str.substring(0,1), str.substring(str.length()-1));
		}
		return map;
	}

	/*
	The classic word-count algorithm: given an array of strings,
	return a Map<String, Integer> with a key for each different
	string, with the value the number of times that string appears
	in the array.

	wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
	wordCount(["c", "c", "c", "c"]) → {"c": 4}
	*/
	public Map<String, Integer> wordCount(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		for(String str: strings) {
			if(!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}
		return map;
	}

	/*
	Given an array of non-empty strings, return a Map<String, String>
	with a key for every different first character seen, with the
	value of all the strings starting with that character appended
	together in the order they appear in the array.

	firstChar(["salt", "tea", "soda", "toast"]) →
	{"s": "saltsoda", "t": "teatoast"}
	firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) →
	{"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
	firstChar([]) → {}
	*/
	public Map<String, String> firstChar(String[] strings) {
		Map<String, String> map = new HashMap<>();
		for(String str: strings) {
			if(!map.containsKey(str.substring(0,1))) {
				map.put(str.substring(0,1), str);
			} else {
				map.put(str.substring(0,1), map.get(str.substring(0,1)) + str);
			}
		}
		return map;
	}

	/*
	Loop over the given array of strings to build a result string
	like this: when a string appears the 2nd, 4th, 6th, etc. time
	in the array, append the string to the result. Return the
	empty string if no string appears a 2nd time.

	wordAppend(["a", "b", "a"]) → "a"
	wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
	wordAppend(["a", "", "a"]) → "a"
	*/
	public String wordAppend(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		String result = "";
		for(int i=0; i<strings.length; i++) {
			String key = strings[i];
			if(map.containsKey(key)) {
				int value = map.get(key);
				value++;
				if(value%2 == 0) {
					result += key;
				}
				map.put(key, value);
			} else	map.put(key, 1);
		}
		return result;
	}

	/*
	Given an array of strings, return a Map<String, Boolean>
	where each different string is a key and its value is
	true if that string appears 2 or more times in the array.

	wordMultiple(["a", "b", "a", "c", "b"]) →
	{"a": true, "b": true, "c": false}
	wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
	wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	*/
	public Map<String, Boolean> wordMultiple(String[] strings) {
  		Map<String, Boolean> map = new HashMap<>();
		for(int i=0; i<strings.length; i++) {
			String key = strings[i];
			if(map.containsKey(key)) {
				map.put(key, true);
			} else	map.put(key, false);
		}
		return map;
	}

	/*
	list.replaceAll(lambda) -- calls the lambda once for each item in the
	list, storing the result back into the list (or other type of collection).
	e.g. nums.replaceAll(n -> n * 2);

	list.removeIf(lambda) -- calls the lambda once for each item in the
	collection, removing each item where the lambda returns true.
	e.g. nums.removeIf(n -> n < 0);

	Simple Lambda Examples -- the data types are inferred from the context
	and from the type of the expression following the "->":
	n -> n * 2 -- takes Integer, returns Integer
	n -> n < 0 && n >= -10 -- takes Integer, returns boolean
	s -> s.length()  -- takes String, returns Integer
	s -> s.startsWith("hi") -- takes String, returns boolean

	The Java stream system provides more complicated lambda features.
	The stream calls do not modify the original list, returning a new data
	structure of the results. Note that the boolean logic of filter() is
	the opposite of removeIf().

	  List<Integer> nums = -something-;
	  nums = nums.stream()
		.map(n -> n * 2)
		.filter(n -> n >= 0)
		.collect(Collectors.toList());
	*/

	/*
	Given a list of integers, return a list of the integers, omitting any
	that are less than 0.

	noNeg([1, -2]) → [1]
	noNeg([-3, -3, 3, 3]) → [3, 3]
	noNeg([-1, -1, -1]) → []
	*/
	public List<Integer> noNeg(List<Integer> nums) {
		return nums.stream()
		.filter(n -> n>=0)
		.collect(Collectors.toList());
	}

	/*
	Given a list of non-negative integers, return a list of those numbers
	except omitting any that end with 9. (Note: % by 10)

	no9([1, 2, 19]) → [1, 2]
	no9([9, 19, 29, 3]) → [3]
	no9([1, 2, 3]) → [1, 2, 3]
	*/
	public List<Integer> no9(List<Integer> nums) {
		return nums.stream()
		.filter(n -> n%10!=9)
		.collect(Collectors.toList());
	}

	/*
	Given a list of integers, return a list of those numbers, omitting
	any that are between 13 and 19 inclusive.

	noTeen([12, 13, 19, 20]) → [12, 20]
	noTeen([1, 14, 1]) → [1, 1]
	noTeen([15]) → []
	*/
	public List<Integer> noTeen(List<Integer> nums) {
		return nums.stream()
		.filter(n -> n<13 || n>19)
		.collect(Collectors.toList());
	}

	/*
	Given a list of strings, return a list of the strings, omitting
	any string length 4 or more.

	noLong(["this", "not", "too", "long"]) → ["not", "too"]
	noLong(["a", "bbb", "cccc"]) → ["a", "bbb"]
	noLong(["cccc", "cccc", "cccc"]) → []
	*/
	public List<String> noLong(List<String> strings) {
		return strings.stream()
		.filter(s -> s.length()<4)
		.collect(Collectors.toList());
	}

	/*
	Given a list of strings, return a list of the strings,
	omitting any string that contains a "z".
	(Note: the str.contains(x) method returns a boolean)

	noZ(["aaa", "bbb", "aza"]) → ["aaa", "bbb"]
	noZ(["hziz", "hzello", "hi"]) → ["hi"]
	noZ(["hello", "howz", "are", "youz"]) → ["hello", "are"]
	 */
	 public List<String> noZ(List<String> strings) {
  		return strings.stream()
		.filter(s -> !s.contains("z"))
		.collect(Collectors.toList());
	}

	/*
	Given a list of strings, return a list of the strings,
	omitting any string length 3 or 4.

	no34(["a", "bb", "ccc"]) → ["a", "bb"]
	no34(["a", "bb", "ccc", "dddd"]) → ["a", "bb"]
	no34(["ccc", "dddd", "apple"]) → ["apple"]
	*/
	public List<String> no34(List<String> strings) {
  		return strings.stream()
		.filter(s -> s.length()!=3 && s.length()!=4)
		.collect(Collectors.toList());
	}

	/*
	Given a list of strings, return a list where each string
	has "y" added at its end, omitting any resulting strings
	that contain "yy" as a substring anywhere.

	noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
	noYY(["a", "b", "cy"]) → ["ay", "by"]
	noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
	*/
	public List<String> noYY(List<String> strings) {
  		return strings.stream()
		.map(s -> s += "y")
		.filter(s -> !s.contains("yy"))
		.collect(Collectors.toList());
	}

	/*
	Given a list of non-negative integers, return a list of
	those numbers multiplied by 2, omitting any of the
	resulting numbers that end in 2.

	two2([1, 2, 3]) → [4, 6]
	two2([2, 6, 11]) → [4]
	two2([0]) → [0]
	*/
	public List<Integer> two2(List<Integer> nums) {
		return nums.stream()
		.map(n -> n*2)
		.filter(n -> n%10!=2)
		.collect(Collectors.toList());
	}

	/*
	Given a list of integers, return a list of those numbers
	squared and the product added to 10, omitting any of the
	resulting numbers that end in 5 or 6.

	square56([3, 1, 4]) → [19, 11]
	square56([1]) → [11]
	square56([2]) → [14]
	*/
	public List<Integer> square56(List<Integer> nums) {
  		return nums.stream()
		.map(n -> n*n + 10)
		.filter(n -> n%10!=5 && n%10!=6)
		.collect(Collectors.toList());
	}

	/*
	We'll say that 2 strings "match" if they are non-empty and
	their first chars are the same. Loop over and then return
	the given array of non-empty strings as follows: if a string
	matches an earlier string in the array, swap the 2 strings
	in the array. When a position in the array has been swapped,
	it no longer matches anything. Using a map, this can be solved
	making just one pass over the array. More difficult than it looks.

	allSwap(["ab", "ac"]) → ["ac", "ab"]
	allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) →
	["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
	allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) →
	["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
	 */
	public String[] allSwap(String[] strings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
			String key = String.valueOf(strings[i].charAt(0));
			if (map.containsKey(key)) {
				int    pos   = map.get(key);
				String tmp   = strings[pos];
				strings[pos] = strings[i];
			  	strings[i]   = tmp ;
			  	map.remove(key);
			} else {
			  	map.put(key, i);
			}
		}
		return strings;
	}

	/*
	We'll say that 2 strings "match" if they are non-empty and their first
	chars are the same. Loop over and then return the given array of non-empty
	strings as follows: if a string matches an earlier string in the array,
	swap the 2 strings in the array. A particular first char can only cause 1
	swap, so once a char has caused a swap, its later swaps are disabled.
	Using a map, this can be solved making just one pass over the array.
	More difficult than it looks.

	firstSwap(["ab", "ac"]) → ["ac", "ab"]
	firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) →
	["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
	firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) →
	["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
	*/
	public String[] firstSwap(String[] strings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
			String key = String.valueOf(strings[i].charAt(0));
			if (map.containsKey(key)) {
				int val = map.get(key);
				if (val == -1) {
					continue;
				}
				int    pos   = map.get(key);
				String tmp   = strings[pos];
				strings[pos] = strings[i];
				strings[i]   = tmp ;
				map.put(key, -1);
			} else {
				map.put(key, i);
			}
		}
		return strings;
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
