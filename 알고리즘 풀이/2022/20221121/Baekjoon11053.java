import java.io.*;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			if (dp[i] == 0) {
				dp[i] = 1;
			}
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = dp[i] < (dp[j] + 1) ? (dp[j] + 1) : dp[i];
				}
			}
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}

/**
  * 11053. 가장 긴 증가하는 부분 수열
  * 
**/