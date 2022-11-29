import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] tree = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j <= i; j++) {
				tree[i+1][j+1] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = (dp[i-1][j-1] > dp[i-1][j] ? dp[i-1][j-1] : dp[i-1][j]) + tree[i][j];
			}
		}
		
		System.out.println(Arrays.stream(dp[n]).max().getAsInt());
	}
}


/**
  * 1932. 정수 삼각형
  * 
**/