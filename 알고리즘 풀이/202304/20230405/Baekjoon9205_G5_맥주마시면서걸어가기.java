import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	static final int INF = Integer.MAX_VALUE>>8;
	
	static class Node {
		int x, y;
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static Node[] nodes;
	static int[][] adj;
	static int size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		adj = new int[102][102];
		nodes = new Node[102];
		StringBuilder sb = new StringBuilder(10);
		for (int tc = 0; tc < T; tc++) {
			// 입력 초기화
			n = Integer.parseInt(br.readLine());
			size = n+2;
			for (int i = 0; i < size; i++) {
				String[] input = br.readLine().split(" ");
				nodes[i] = new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = i+1; j < size; j++) {
					adj[i][j] = adj[j][i] = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y) <= 1000 ? 1 : 0;
				}
			}
			
			Queue<Integer> bfs = new ArrayDeque<>();
			bfs.offer(0);
			boolean[] visited = new boolean[102];
			visited[0] = true;
			boolean isArrived = false;
			while (!bfs.isEmpty()) {
				int v = bfs.poll();
				if (v == size-1) {
					isArrived = true;
					break;
				}
				for (int next = 0; next < size; next++) {
					if (visited[next]) continue;
					if (adj[v][next] == 1) {
						bfs.offer(next);
						visited[next] = true;
					}
				}
			}
			
			if (isArrived) sb.append("happy");
			else sb.append("sad");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

/**
 *  9205. 맥주 마시면서 걸어가기
 *  
 *  상근이네 집 출발
 *  맥주 (시작) 20 / (최대) 20
 *  1병 = 50미터
 *  
 *  편의점 개수 n
 *  시작 좌표
 *  loop n:
 *    편의점 좌표
 *  도착 좌표
 */
