import java.io.*;
import java.util.*;

class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, minWeight;
	static int[][] weights;
	static int[] nextPerm;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = null;
		N = Integer.parseInt(br.readLine());
		minWeight = INF;
		weights = new int[N][N];
//		int min = INF;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(input[j]);
				if (num == 0) weights[i][j] = INF;
				else weights[i][j] = num;
				
//				if (min > num) {
//					min = 
//				}
			}
		}
		
		nextPerm = new int[N-1];
		for (int i = 0, length = N-1; i < length; i++) {
			nextPerm[i] = i+1;
		}
		NEXT_PERMUTATION:
			do {
				int sum = 0;
				
				int startWeight = weights[0][nextPerm[0]];
				int lastWeight = weights[nextPerm[N-2]][0];
				if (startWeight == INF || lastWeight == INF) continue NEXT_PERMUTATION;	// 불가능한 경로
				
				sum += startWeight + lastWeight;
				for (int i = 0, length = N-2; i < length; i++) {
					int s = nextPerm[i];
					int d = nextPerm[i+1];
					if (weights[s][d] == INF) continue NEXT_PERMUTATION;	// 불가능한 경로
					
					sum += weights[s][d];
				}
				minWeight = Math.min(minWeight, sum);
			} while (np());
		
		System.out.println(minWeight);
	}

	private static boolean np() {
		int i = N-2;
		while (i > 0 && nextPerm[i-1] >= nextPerm[i]) i--;
		if (i == 0) return false;
		
		int j = N-2;
		while (nextPerm[i-1] >= nextPerm[j]) j--;
		
		swap(i-1, j);
		
		j = N-2;
		while (i < j) {
			swap(i++, j--);
		}
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = nextPerm[i];
		nextPerm[i] = nextPerm[j];
		nextPerm[j] = temp;
	}
	
	
}

/**
 *	10971. 외판원 순회 2
 */