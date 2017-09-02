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
		int[] newArr = new int[n*n];
		for (int i=n-1; i<newArr.length; i+=n) {
			for (int j=i; j<i-i/n; j--) {
				
			}
		}
	}
}