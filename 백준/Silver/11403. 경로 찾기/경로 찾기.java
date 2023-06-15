import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = null;
		int[][] adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1) adjMatrix[i][j] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(Arrays.toString(adjMatrix[i]).replaceAll("[\\[\\],]", "")).append("\n");
		System.out.println(sb);
	}
}

/**
 *  11403. 경로 찾기
 *  
 */