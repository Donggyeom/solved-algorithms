import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE>>2;
	
	static class Edge implements Comparable<Edge> {
		int p;
		int v;
		int w;
		public Edge(int p, int v, int w) {
			this.p = p;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		@Override
		public String toString() {
			return "Edge [p=" + p + ", v=" + v + ", w=" + w + "]";
		}
	}
	
	static int N, M, path[], parents[];
	static boolean[] visited;
	static List<Edge>[] edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder(10); 
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 간선 수
			M = Integer.parseInt(st.nextToken());	// 정점 수
			parents = new int[M];
			visited = new boolean[M];
			int[] D = new int[M];
			edges = new List[M];
			for (int i = 0; i < M; i++) {
				edges[i] = new ArrayList<>();
				D[i] = INF;
			}
			D[0] = 0;
			parents[0] = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[s].add(new Edge(s, d, w));
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(-1, 0,0));
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				if (visited[cur.v]) continue;
				visited[cur.v] = true;
				if (cur.v == M-1) break;
				for (Edge next : edges[cur.v]) {
					int v = next.v;
					if (visited[v]) continue;
					int w = next.w;
					if (D[v] > D[cur.v] + w) {
						D[v] = D[cur.v] + w;
						pq.offer(new Edge(cur.v, v, D[v]));
						parents[v] = cur.v;
					}
				}
			}
			
			sb.append("Case #").append(tc).append(": ");
			if (!visited[M-1]) {
				sb.append("-1");
			}
			else {
				int idx = M-1;
				List<Integer> order = new ArrayList<>();
				while (idx != -1) {
					order.add(0, idx);
					idx = parents[idx];
				}
				for (int i : order) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
		br.close();
	}
}

/**
 *  9694. 무엇을 아느냐가 아니라 누구를 아느냐가 문제다
 *  
 */
