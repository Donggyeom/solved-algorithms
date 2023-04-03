import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] values = new int[N];
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		int idx = N-1;
		while (true) {
			answer = answer + (K / values[idx]);
			K %= values[idx];
			
			idx--;
			
			if (K == 0) break;
		}
		System.out.println(answer);
	}
}

/**
  * 11047. 동전 0
  * 
**/