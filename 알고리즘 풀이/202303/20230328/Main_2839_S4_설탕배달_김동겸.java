import java.io.BufferedReader;
import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int INF = Integer.MAX_VALUE;
		
		int n = sc.nextInt();
		int[] dp = new int [5001];
		Arrays.fill(dp, INF);
		dp[3] = 1;
		dp[5] = 1;
		for (int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5]);
			if (dp[i] == INF) continue;
			
			dp[i]++;
		}
		if (dp[n] == INF)
			System.out.println(-1);
		else
			System.out.println(dp[n]);
	}

}

/**
 *	2839. 설탕 배달
 */