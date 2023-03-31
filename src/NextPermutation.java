import java.util.Arrays;

public class NextPermutation {

	static int[] nextPerm = {1,2,3,4,5,6};
	static int N = nextPerm.length;
	
	public static void main(String[] args) {
		
		do {
			System.out.println(Arrays.toString(nextPerm));
		} while (np());
	}

	private static boolean np() {
		
		int n = N-1;
		
		int i = n;
		while (i > 0 && nextPerm[i-1] >= nextPerm[i]) i--;
		if (i == 0) return false;
		
		int j = n;
		while (nextPerm[i-1] >= nextPerm[j]) j--;
		
		swap(i-1, j);
		
		j = n;
		while (i < j) swap(i++, j--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = nextPerm[i];
		nextPerm[i] = nextPerm[j];
		nextPerm[j] = temp;
	}

	
}
