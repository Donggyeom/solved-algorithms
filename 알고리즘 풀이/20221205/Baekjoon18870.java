import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		int[] sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		int[] dp = new int[N];
		for (int i = 1; i < N; i++) {
			if (sortedArr[i] > sortedArr[i-1]) {
				dp[i] = dp[i-1]+1;
			}
			else {
				dp[i] = dp[i-1];
			}
		}
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			idxMap.put(sortedArr[i], dp[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(idxMap.get(arr[i]));
			sb.append(" ");
		}
		System.out.print(sb.toString());
	}
}


/**
  * 18870. 좌표 압축
  * 
**/