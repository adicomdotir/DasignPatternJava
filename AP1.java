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

	/*
	Given 2 arrays that are the same length containing strings, compare 
	the 1st string in one array to the 1st string in the other array, the 
	2nd to the 2nd and so on. Count the number of times that the 2 strings 
	are non-empty and start with the same char. The strings may be any 
	length, including 0.

	matchUp(["aa", "bb", "cc"], ["aaa", "xx", "bb"]) → 1
	matchUp(["aa", "bb", "cc"], ["aaa", "b", "bb"]) → 2
	matchUp(["aa", "bb", "cc"], ["", "", "ccc"]) → 1
	*/
	public int matchUp(String[] a, String[] b) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i].length() > 0 && b[i].length() > 0 && a[i].charAt(0) == b[i].charAt(0)) {
				count++;
			}			
		}
		return count;
	}

	/*
	The "key" array is an array containing the correct answers to an exam, 
	like {"a", "a", "b", "b"}. the "answers" array contains a student's answers, 
	with "?" representing a question left blank. The two arrays are not empty 
	and are the same length. Return the score for this array of answers, giving 
	+4 for each correct answer, -1 for each incorrect answer, and +0 for each
	blank answer.

	scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
	scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
	scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
	*/
	public int scoreUp(String[] key, String[] answers) {
		int score = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i].charAt(0) != '?') {
				if (answers[i].charAt(0) == key[i].charAt(0)) {
					score += 4;
				} else {
					score -= 1;
				}
			}			
		}
		return score;
	}

	/*
	Given an array of strings, return a new array without the strings that 
	are equal to the target string. One approach is to count the occurrences 
	of the target string, make a new array of the correct length, and then 
	copy over the correct strings.

	wordsWithout(["a", "b", "c", "a"], "a") → ["b", "c"]
	wordsWithout(["a", "b", "c", "a"], "b") → ["a", "c", "a"]
	wordsWithout(["a", "b", "c", "a"], "c") → ["a", "b", "a"]
	*/
	public String[] wordsWithout(String[] words, String target) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals(target)) {
				count++;
			}
		}
		String[] newStr = new String[count];
		for (int i = 0, j = 0; i < words.length; i++) {
			if (!words[i].equals(target)) {
				newStr[j] = words[i];
				j++;
			}
		}
		return newStr;
	}

	/*
	Given two arrays, A and B, of non-negative int scores. A "special" score is 
	one which is a multiple of 10, such as 40 or 90. Return the sum of largest 
	special score in A and the largest special score in B. To practice decomposition, 
	write a separate helper method which finds the largest special score in an array. 
	Write your helper method after your scoresSpecial() method in the JavaBat text area.

	scoresSpecial([12, 10, 4], [2, 20, 30]) → 40
	scoresSpecial([20, 10, 4], [2, 20, 10]) → 40
	scoresSpecial([12, 11, 4], [2, 20, 31]) → 20
	*/
	public int scoresSpecial(int[] a, int[] b) {
		return largestHelper(a) + largestHelper(b);
	}
	public int largestHelper(int[] x) {
		int largest = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] % 10 == 0 && x[i] > largest) largest = x[i];
		}
		return largest;
	}

	/*
	We have an array of heights, representing the altitude along a walking trail. 
	Given start/end indexes into the array, return the sum of the changes for a walk 
	beginning at the start index and ending at the end index. For example, with the 
	heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6. The start 
	end end index will both be valid indexes into the array with start <= end.

	sumHeights([5, 3, 6, 7, 2], 2, 4) → 6
	sumHeights([5, 3, 6, 7, 2], 0, 1) → 2
	sumHeights([5, 3, 6, 7, 2], 0, 4) → 11
	*/
	public int sumHeights(int[] heights, int start, int end) {
		int sum = 0;
		for (int i = start + 1; i <= end; i++) {
			sum += Math.abs(heights[i-1] - heights[i]);
		}
		return sum;
	}
}