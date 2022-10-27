import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] cards = new int [N];
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(cards);
		int answer = 0;
		for ( int i = 0; i < N - 2; i++ ) {
			for (int j = i + 1; j < N - 1; j++ ) {
				for (int k = j + 1; k < N; k++ ) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum <= M) {
						if (answer < sum) answer = sum;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
}

/**
  * 2798. 블랙잭
  * 
**/