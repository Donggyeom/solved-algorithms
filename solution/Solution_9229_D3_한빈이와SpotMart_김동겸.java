import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution_9229_D3_한빈이와SpotMart_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(10);
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력값 세팅
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(input[i]);
			}
			
			Arrays.sort(a);	// 무게 배열 정렬

			int max = -1;
			for (int i = 0, end = N - 1; i < end; i++) {
				if (a[i] + a[i+1] > M) break;
				
				for (int j = i + 1; j < N; j++) {
					int sum = a[i] + a[j];
					if (sum <= M)
						max = Math.max(max, a[i] + a[j]);
					else
						break;
				}
			}
			
			// 출력값 세팅
			sb.append("#").append(tc).append(" ")
				.append(max).append("\n");
		}
		// 결과 출력
		System.out.println(sb);
	}
	
}


/**
  * 9229. 한빈이와 Spot Mart
  * 
	N개의 과자 봉지 중 2개를 골라서 M그램 이하의 최댓값을 구하시오.
	
	[입력]
	첫 번째 줄에 테스트 케이스의 수 TC
	for TC:
		N, M : 과자 봉지의 개수, 무게 합 제한 (2 ≤ N ≤ 1000 , 2 ≤ M ≤ 2000000)
		각 과자봉지의 무게 a[N] (1 ≤ a[i] ≤ 1000000)
		
	[출력]
	for TC:
		sysout(#tc [result])	// 두 과자를 들고 갈 방법이 없는 경우, -1
**/