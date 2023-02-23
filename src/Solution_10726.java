import java.util.Scanner;

public class Solution_10726 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(10);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			final int toBe = (1 << N) - 1;	// 2^N - 1 = 1111...1 ( 길이 = N )
			
			sb.append("#").append(tc).append(" ");
			if ((M & toBe) == toBe)
				sb.append("ON\n");
			else
				sb.append("OFF\n");
		}
		System.out.println(sb.toString());
		
		sc.close();
	}

}

/**
 * 	SWEA 10726. 이진수 표현
 * 
	정수 N, M 이 주어질 때, M의 이진수 표현의 마지막 N 비트가 모두 1인지 아닌지를 판별하여 출력하라.
	
	[입력]

	테스트 케이스의 수 : T
	for i in 1 to TC:
		N, M (1 ≤ N ≤ 30 , 0 ≤ M ≤ 108)
	
	[출력]
	
	for i in 1 to TC:
		#TC [ON | OFF]	// N개의 비트가 모두 1인지
 */