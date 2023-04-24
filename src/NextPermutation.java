import java.util.Arrays;

public class NextPermutation {
	
	static int[] arr = {1,2,3,4,5,6};
	static int N = arr.length;
	
	public static void main(String[] args) {
		do {
			System.out.println(Arrays.toString(arr));
		} while(np());
	}

	private static boolean np() {
		int n = N-1;
		int i = n;
		while ( i > 0 && arr[i-1] >= arr[i] ) i--;
		if (i == 0) return false;
		
		int j = n;
		while (arr[i-1]>= arr[j]) j--;
		
		swap(i-1, j);
		
		j = n;
		while (i < j) swap(i++, j--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
