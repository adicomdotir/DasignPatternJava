public class Array3 {
	/*
	Given n>=0, create an array length n*n with the following pattern, 
	shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} 
	(spaces added to show the 3 groups).

	squareUp(3) ? [0, 0, 1, 0, 2, 1, 3, 2, 1]
	squareUp(2) ? [0, 1, 2, 1]
	squareUp(4) ? [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
	*/
	public int[] squareUp(int n) {
		int[] result = new int[n * n];
		int x = n-1, pass = 1, index = 0;
		if(n == 0) { return result; }
		for(int i = n-1; i < result.length; i+=n) {
			index = i;
			for(int k = 1; k <= pass; k++) {
				if(k == 0) { break; }
				result[index] = k;
				index--;
			}
			pass++;
		}
		return result;
	}
	
	/*
	Given n>=0, create an array with the pattern 
	{1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} 
	(spaces added to show the grouping). Note that the length of 
	the array will be 1 + 2 + 3 ... + n, which is known to sum to 
	exactly n*(n + 1)/2.

	seriesUp(3) → [1, 1, 2, 1, 2, 3]
	seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
	seriesUp(2) → [1, 1, 2]
	*/
	public int[] seriesUp(int n) {
		int[] arr = new int[n*(n+1)/2];
		for (int i=1; i<=n; i++) {
			for (int j=1, k=i*(i+1)/2-i; j<=i; j++,k++) {
				arr[k] = j;
			}
		}
		return arr;
	}
	/*
	We'll say that a "mirror" section in an array is a group of contiguous elements 
	such that somewhere in the array, the same group appears in reverse order. 
	For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). 
	Return the size of the largest mirror section found in the given array.

	maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
	maxMirror([1, 2, 1, 4]) → 3
	maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
	*/
	public int maxMirror(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
				if (nums[i + count] == nums[j]) {
					count++;
				} else {
					count = 0;
				}
				if (count > max) max = count;
			}
		}
		return max;
	}
	
	/*
	Say that a "clump" in an array is a series of 2 or more adjacent elements of 
	the same value. Return the number of clumps in the given array.

	countClumps([1, 2, 2, 3, 4, 4]) → 2
	countClumps([1, 1, 2, 1, 1]) → 2
	countClumps([1, 1, 1, 1, 1]) → 1
	*/
	public int countClumps(int[] nums) {
		boolean match = false;
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i+1] && !match) {
				match = true;
				count++;
			} else if (nums[i] != nums[i+1]) {
				match = false;
			}
		}
		return count;
	}
}
