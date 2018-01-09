public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] {6, 8, 2, 4, 1, 5, 7, 9};
		print(arr);
		System.out.println("");
		new MergeSort().mergeSort(arr, 0, 7);
		print(arr);
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	public void mergeSort(int[] arr, int l, int r) {
	    if (l < r) {
	        // Same as (l+r)/2, but avoids overflow for
	        // large l and h
	        int m = l + (r - l) / 2;
	 
	        // Sort first and second halves
	        mergeSort(arr, l, m);
	        mergeSort(arr, m + 1, r);
	 
	        merge(arr, l, m, r);
	    }
	}

	public void merge(int[] arr, int l, int m, int r) {
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;
	 
	    /* create temp arrays */
	    int[] L = new int[n1];
	    int[] R = new int[n2];
	 
	    /* Copy data to temp arrays L[] and R[] */
	    for (i = 0; i < n1; i++)
	        L[i] = arr[l + i];
	    for (j = 0; j < n2; j++)
	        R[j] = arr[m + 1+ j];
	 
	    /* Merge the temp arrays back into arr[l..r]*/
	    i = 0; // Initial index of first subarray
	    j = 0; // Initial index of second subarray
	    k = l; // Initial index of merged subarray
	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            arr[k] = L[i];
	            i++;
	        } else {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	 
	    /* Copy the remaining elements of L[], if there
	       are any */
	    while (i < n1) {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	 
	    /* Copy the remaining elements of R[], if there
	       are any */
	    while (j < n2) {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
}