public class AP1 {
	/*
	Given an array of scores, compute the int average of the first 
	half and the second half, and return whichever is larger. We'll 
	ay that the second half begins at index length/2. The array 
	length will be at least 2. To practice decomposition, write a 
	separate helper method 
	int average(int[] scores, int start, int end) { which computes 
	the average of the elements between indexes start..end. Call your 
	elper method twice to implement scoresAverage(). Write your 
	helper method after your scoresAverage() method in the JavaBat 
	text area. Normally you would compute averages with doubles, 
	but here we use ints so the expected results are exact.

	scoresAverage([2, 2, 4, 4]) → 4
	scoresAverage([4, 4, 4, 2, 2, 2]) → 4
	scoresAverage([3, 4, 5, 1, 2, 3]) → 4
	*/
	public int scoresAverage(int[] scores) {
		int firstHalf = 0, secondHalf = 0;
		int half = scores.length / 2;
		for (int i=0; i<scores.length; i++) {
			if (i<half) {
				firstHalf += scores[i];
			} else {
				secondHalf += scores[i];
			}
		}
		firstHalf /= half;
		secondHalf /= half;
		return firstHalf > secondHalf ? firstHalf : secondHalf;
	}

	/*
	Given an array of strings, return the count of the number of 
	strings with the given length.

	wordsCount(["a", "bb", "b", "ccc"], 1) → 2
	wordsCount(["a", "bb", "b", "ccc"], 3) → 1
	wordsCount(["a", "bb", "b", "ccc"], 4) → 0
	*/
	public int wordsCount(String[] words, int len) {
		int sum = 0;
		for (int i=0; i<words.length; i++) {
			if (words[i].length() == len) {
				sum++;
			}
		}
		return sum;
	}

	/*
	Given an array of strings, return a new array containing the 
	first N strings. N will be in the range 1..length.

	wordsFront(["a", "b", "c", "d"], 1) → ["a"]
	wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
	wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
	*/
	public String[] wordsFront(String[] words, int n) {
		String[] newStr = new String[n];
		for (int i=0; i<n; i++) {
			newStr[i] = words[i];
		}
		return newStr;
	}

	/*
	Given an array of strings, return a new List (e.g. an ArrayList)
	where all the strings of the given length are omitted. See 
	wordsWithout() below which is more difficult because it uses arrays.

	wordsWithoutList(["a", "bb", "b", "ccc"], 1) → ["bb", "ccc"]
	wordsWithoutList(["a", "bb", "b", "ccc"], 3) → ["a", "bb", "b"]
	wordsWithoutList(["a", "bb", "b", "ccc"], 4) → ["a", "bb", "b", "ccc"]
	*/
	public List wordsWithoutList(String[] words, int len) {
		List<String> list = new ArrayList<>();
		for (int i=0; i<words.length; i++) {
			if (words[i].length() != len) {
				list.add(words[i]);
			}
		}
		return list;
	}

	/*
	We'll say that a positive int divides itself if every digit in the 
	number divides into the number evenly. So for example 128 divides 
	itself since 1, 2, and 8 all divide into 128 evenly. We'll say that 
	0 does not divide into anything evenly, so no number with a 0 digit 
	divides itself. Note: use % to get the rightmost digit, and / to 
	discard the rightmost digit.

	dividesSelf(128) → true
	dividesSelf(12) → true
	dividesSelf(120) → false
	*/
	public boolean dividesSelf(int n) {
		int number = n;
		while (number > 0) {
			int x = number % 10;
			if (x == 0) return false;
			if (n % x != 0) return false; 
			number /= 10;
		}
		return true;
	}

	/*
	Given an array of positive ints, return a new array of length "count" 
	containing the first even numbers from the original array. 
	The original array will contain at least "count" even numbers.

	copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
	copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
	copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
	*/
	public int[] copyEvens(int[] nums, int count) {
		int[] numbers = new int[count];
		for (int i = 0, j = 0; i < count; j++) {
			if (nums[j] % 2 == 0) {
				numbers[i] = nums[j];
				i++;
			}			
		}
		return numbers;
	}

	/*
	We'll say that a positive int n is "endy" if it is in the range 
	0..10 or 90..100 (inclusive). Given an array of positive ints, 
	return a new array of length "count" containing the first endy 
	numbers from the original array. Decompose out a separate isEndy(int n) 
	method to test if a number is endy. The original array will contain 
	at least "count" endy numbers.

	copyEndy([9, 11, 90, 22, 6], 2) → [9, 90]
	copyEndy([9, 11, 90, 22, 6], 3) → [9, 90, 6]
	copyEndy([12, 1, 1, 13, 0, 20], 2) → [1, 1]
	*/
	public int[] copyEndy(int[] nums, int count) {
		int[] numbers = new int[count];
		for (int i = 0, j = 0; i < count; j++) {
			if ((nums[j] >= 0 && nums[j] <= 10) || (nums[j] >= 90 && nums[j] <= 100)) {
				numbers[i] = nums[j];
				i++;
			}			
		}
		return numbers;
	}

}