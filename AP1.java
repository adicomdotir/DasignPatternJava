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
}