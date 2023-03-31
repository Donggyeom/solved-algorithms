import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest1 {

	private static long callCnt1;
	private static long callCnt2;
	
	// non-memo
	private static long fibo1 (int n) {
		callCnt1++;
		// 기저
		if (n <= 1) return n;
		// 유도
		return fibo1(n-1)+fibo1(n-2);
	}
	
	private static long[] memo;
	private static long fibo2(int n) {
		callCnt2++;
		if (memo[n]==-1) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibo1(n));
		System.out.println(callCnt1);
		System.out.println();
		
		memo = new long[n+1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(fibo2(n));
		System.out.println(callCnt2);
		System.out.println();
	}

}
