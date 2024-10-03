import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static final long DIVISOR = 1000000000;

	static int N;
	static long dp[][] = new long[101][10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < 9; j++) {
				dp[i][j] = ((dp[i - 1][j - 1] % DIVISOR) + (dp[i - 1][j + 1] % DIVISOR) % DIVISOR);
			}
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];
		}

		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[N][i];
			answer %= DIVISOR;
		}

		System.out.println(answer);
	}

}

/**
 * 10844. 쉬운 계단 수
 * 
 */