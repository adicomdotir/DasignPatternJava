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

	public static void main(String[] args) {
		System.out.println( Arrays.toString(new Kata().sortArray(new int[] {5, 3, 2 ,8, 1, 4})) );
	}
}