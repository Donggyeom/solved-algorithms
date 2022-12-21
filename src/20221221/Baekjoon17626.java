import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		int maxSqrtNumber = (int) (Math.ceil(Math.sqrt(n)));
		int[] squareNumbers = new int[maxSqrtNumber + 1];
		for (int i = 1; i <= maxSqrtNumber; i++) {
			squareNumbers[i] = i*i;
		}
		
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int j = 1;
			dp[i] = Integer.MAX_VALUE;
			while (j <= maxSqrtNumber && squareNumbers[j] <= i) {
				dp[i] = Math.min(dp[i], dp[i-squareNumbers[j]] + 1);
				j++;
			}
		}
		System.out.println(dp[n]);
	}
}

/**
  * 17626. Four Squares
  * 
**/