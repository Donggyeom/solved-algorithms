import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] costs = new int[N][3];		
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				costs[i][j] = Integer.parseInt(input[i]);
			}
		}
		
		int[][] dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = costs[i-1][0] + (dp[i-1][1] < dp[i-1][2] ? dp[i-1][1] : dp[i-1][2]);
			dp[i][1] = costs[i-1][1] + (dp[i-1][0] < dp[i-1][2] ? dp[i-1][0] : dp[i-1][2]);
			dp[i][2] = costs[i-1][2] + (dp[i-1][0] < dp[i-1][1] ? dp[i-1][0] : dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));		
	}
}


/**
  * 1149. RGB거리
  * 
**/