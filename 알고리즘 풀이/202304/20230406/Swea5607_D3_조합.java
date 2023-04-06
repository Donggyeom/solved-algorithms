import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static final long MOD = 1234567891;
	
	static long fac[] = new long[1000001];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(10);
		// fac
		fac[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			fac[i] = (fac[i-1] % MOD) * i % MOD;
		}
		
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int R = Integer.parseInt(input[1]);
			
			long res = (fac[N]*power(fac[R],MOD-2)) % MOD * power(fac[N-R], MOD-2) % MOD;
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	private static long power(long x, long y) {
		long res = 1L;
		x %= MOD;
		while (y > 0) {
			if (y % 2 == 1) {
				res = res * x % MOD;
			}
			y = y >> 1;
			x = (x*x)%MOD;
		}
		return res;
	}
	
}

/**
 *  swea 5607. 조합
 */
