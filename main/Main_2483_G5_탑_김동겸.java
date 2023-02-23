import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Main_2483_G5_탑_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[N+1];
		int[] results = new int[N+1];
		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			heights[i] = Integer.parseInt(input[i-1]);
		}
		
		Stack<Integer> hStk = new Stack<>();
		Stack<Integer> idxStk = new Stack<>();
		hStk.add(Integer.MAX_VALUE);
		idxStk.add(0);
		for (int i = 1; i <= N; i++) {
			while (hStk.peek() < heights[i]) {
				hStk.pop();
				idxStk.pop();
			}
			results[i] = idxStk.peek();	// 받는 탑 인덱스 저장
			
			// 스택에 현재 탑 추가
			hStk.add(heights[i]);
			idxStk.add(i);
		}
		
		StringBuilder sb = new StringBuilder(N*3);
		for (int i = 1; i <= N; i++) {
			sb.append(results[i]).append(" ");
		}
		System.out.println(sb);
	}
}


/**
  * 백준 2493. 탑 문제
  * 

**/