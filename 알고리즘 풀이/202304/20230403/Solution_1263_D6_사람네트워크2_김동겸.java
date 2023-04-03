import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	private static int INF = Integer.MAX_VALUE>>2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(10);
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N]; 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && map[i][j] == 0) map[i][j]= INF;
				}
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			
			int min = INF ;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[i][j];
				}
				min = Math.min(min, sum);
			}
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
	}

}
