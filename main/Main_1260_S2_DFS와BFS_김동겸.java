import java.io.*;
import java.util.*;

class Main_1260_S2_DFS와BFS_김동겸 {
	
	static int N, M, V;
	
	static int[][] adjMatrix;
	
	static StringBuilder sb = new StringBuilder(10);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);	// 정점의 개수
		M = Integer.parseInt(input[1]);	// 간선의 개수
		V = Integer.parseInt(input[2]);	// 시작 정점
		
		// 인접 행렬 초기화
		adjMatrix = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			// M개의 간선
			input = br.readLine().split(" ");
			int v1 = Integer.parseInt(input[0]);	// 정점 번호 1
			int v2 = Integer.parseInt(input[1]);	// 정점 번호 2
			
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		
		// dfs 결과 생성
		dfs(V);
		// bfs 결과 생성
		bfs(V);
		
		// 결과 출력
		System.out.print(sb);
		
		// 프로그램 종료
		br.close();
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(v);
		
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (visited[num]) continue;
			sb.append(num).append(" ");
			visited[num] = true;
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adjMatrix[num][i] == 1) {
					queue.offer(i);
				}
			}
		}
		sb.append("\n");
	}

	private static void dfs(int v) {
		Stack<Integer> stk = new Stack<>();
		boolean[] visited = new boolean[N+1];
		
		stk.push(v);
		while (!stk.isEmpty()) {
			int num = stk.pop();
			if (visited[num]) continue;
			
			visited[num] = true;
			sb.append(num).append(" ");
			
			for (int i = N; i > 0; i--) {
				if (!visited[i] && adjMatrix[num][i] == 1) {
					stk.push(i);
				}
			}
		}
		sb.append("\n");
	}
	
}

/**
 *  1260. DFS와 BFS
 */