import java.io.BufferedReader;
import java.io.*;
import java.util.*;



class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + (dp[i-2]*2)%20100529)%20100529;
		}
		
		System.out.println(dp[n]);
	}

}

/**
 *	Jungol 1411. 두 줄로 타일 깔기 
 */