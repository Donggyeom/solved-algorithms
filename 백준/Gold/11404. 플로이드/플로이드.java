import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX = 123_456_789;
	static int n, m;
	static int[][] edgeArray;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
	
		edgeArray = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				
				edgeArray[i][j] = MAX;
			}
		}
		
		String[] input = null;
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int begin = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			
			edgeArray[begin][end] = Math.min(edgeArray[begin][end], cost);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (k == i || k == j) continue;
					
					edgeArray[i][j] = Math.min(edgeArray[i][k] + edgeArray[k][j], edgeArray[i][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder(10);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (edgeArray[i][j] == MAX) sb.append("0 "); 
				else sb.append(edgeArray[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}	

/**
 *  11404. 플로이드
 *  
 */