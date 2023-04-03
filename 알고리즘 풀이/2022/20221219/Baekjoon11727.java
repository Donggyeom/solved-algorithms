import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][4];
		dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = 0;
		dp[1][0] = 1;
		dp[1][1] = 0;
		dp[1][2] = 0;
		dp[1][3] = 1;
		if (n > 1) {
			dp[2][0] = 1;
			dp[2][1] = 1;
			dp[2][2] = 1;
			dp[2][3] = 3;
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i][0] = dp[i-1][3];
			dp[i][1] = dp[i-2][3];
			dp[i][2] = dp[i-2][3];
			dp[i][3] = (dp[i][0] + dp[i][1] + dp[i][2]) % 10007;
		}
		System.out.println(dp[n][3]);
	}
}

/**
  * 11727. 2xn 타일링 2
  * 
**/