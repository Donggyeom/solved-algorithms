import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		int n = s1.length;
		int m = s2.length;
		
		int[][] dp = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1[i-1] == s2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(dp[n][m]);
	}
}

/**
  * 9251. LCS
  * 
  * 
**/