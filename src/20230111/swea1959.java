import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 테스트케이스 시작
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			input = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(input[i]);
			}
			input = br.readLine().split(" ");
			int[] B = new int[M];
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(input[i]);
			}
			
			int diff = M - N;
			if (diff < 0) {
				int[] temp = A;
				A = B;
				B = temp;
				diff *= -1;
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= diff; i++) {
				int sum = 0;
				for (int j = 0; j < A.length; j++) {
					sum += A[j] * B[i+j];
				}
				max = Math.max(sum, max);
			}
			
			bw.write("#" + Integer.toString(tc+1) + " " + max + "\n");
			// 테스트케이스 끝
		}
		bw.flush();
	}

}
