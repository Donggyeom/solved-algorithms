import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	static final int MOD = 10007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(10);
			return;
		}
		long[] dp = new long[9];
		Arrays.fill(dp, 1);
		long cnt = 1;
		for (int i = 2, len = N+2; i < len; i++) {
			for (int j = 1; j < 9; j++) {
				dp[j] = (dp[j] + dp[j-1]) % MOD;
			}
			cnt = (cnt + dp[8]) % MOD;
		}
		System.out.println(cnt);
	}
}

/**
 *  11057. 오르막 수
 *  
 */
