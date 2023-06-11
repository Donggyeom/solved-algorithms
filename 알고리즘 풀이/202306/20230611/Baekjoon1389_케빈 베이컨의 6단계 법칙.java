import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N, M;
		N = Integer.parseInt(input[0]);	// 유저의 수(2 <= N <= 100)
		M = Integer.parseInt(input[1]);	// 관계의 수(1 <= M <= 5000)
		
		// 정점의 최대값이 작으므로 인접 행렬 사용
		int[][] adjMatrix = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			adjMatrix[a][b] = adjMatrix[b][a] = 1;
		}
		
		int[][] d = new int[N+1][N+1];
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(i);
			int dist = 1;
			int sum = 0;
			while(!queue.isEmpty()) {
				for (int j = 0, size = queue.size(); j < size; j++) {
					int v = queue.poll();
					for (int k = 1; k <= N; k++) {
						if (k == i || d[i][k] != 0 || adjMatrix[v][k] == 0) continue;
						
						queue.offer(k);
						d[i][k] = dist;
						sum += dist;
					}
				}
				dist++;
			}
//			//debug
//			System.out.print(Arrays.toString(d[i]));
//			System.out.println(sum);
			if (sum < min) {
				min = sum;
				answer = i;
			}
		}
		System.out.println(answer);
	}
}

/**
 *  1389. 케빈 베이컨의 6단계 법칙
 *  
 */