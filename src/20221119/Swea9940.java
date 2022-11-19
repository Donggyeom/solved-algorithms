import java.io.*;
import java.util.Arrays;

class Solution {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}
			
			Arrays.sort(arr);
			
			sb.append("#");
			sb.append(i+1);
			sb.append(" ");
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (j != arr[j-1]) break;
				
				cnt++;
			}
			
			if (cnt == n) {
				sb.append("Yes");
			}
			else {
				sb.append("No");
			}
			sb.append("\n");
		}

        System.out.println(sb.toString());
	}
}

/**
 *  SWEA
 *  9940. 순열1	
 */
	