import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class Solution_1225_D3_암호생성기_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[] password = new int[9];	// 0버림
			int minPass = Integer.MAX_VALUE;
			int minIdx = Integer.MAX_VALUE;
			int minQuotient = Integer.MAX_VALUE;
			
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < 8; i++) {
				int num = Integer.parseInt(input[i]);
				int idx = i+1;
				password[idx] = num;
				if (num < minPass) {
					minIdx = idx;
					minPass = num;
				}
			}
			minQuotient = minPass/15;
			if (minPass % 15 == 0 && minIdx != 8) {
				minQuotient -= 1;
			}
			int deduction = minQuotient * 15;
			for (int i = 1; i <= 8; i++) {
				password[i] -= deduction;
			}
			
			Deque<Integer> deque = new LinkedList<Integer>();
			for (int i = 1; i <= 8; i++) {
				deque.addLast(password[i]);
			}
			int i = 0;
			while (deque.peekLast() != 0) {
				int num = deque.poll() - (i%5 + 1);
				num = Math.max(num, 0);
				deque.addLast(num);
				i++;
			}
			
			//sb.append(String.format("#%d %s\n", tc, Arrays.toString(password).replaceAll("[\\[,\\]]", "")));
			sb.append("#").append(tc).append(" ");
			for (int j = 1; j <= 8; j++) {
				sb.append(deque.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}


/**
  * 1225. 암호생성기
  * 
**/