import java.io.*;
import java.util.StringTokenizer;

class Solution_5215_D3_햄버거다이어트_김동겸 {
	
	private static int N;
	private static int L;
	private static int max;
	private static int[] scores;
	private static int[] calories;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(10);
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			// 테스트케이스 시작
			max = 0;	// 결과값
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			L = Integer.parseInt(input[1]);
			
			// 재료의 점수와 칼로리 배열 초기화
			scores = new int[N];
			calories = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			generateSubset(0, 0, 0);
		
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
	private static void generateSubset(int cnt, int scoreSum, int calorySum) {
		if (calorySum > L) return;
		if (cnt == N) {
			max = Math.max(max, scoreSum);
			return;
		}
		generateSubset(cnt+1, scoreSum + scores[cnt], calorySum + calories[cnt]);
		generateSubset(cnt+1, scoreSum, calorySum);
		
		
	}
}

