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

public class Dijkstras {
	
	static class Edge implements Comparable<Edge> {
		int v;
		int w;
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}

	private static final int MAX_VALUE = Integer.MAX_VALUE>>2;
	
	static int N, M;
	static List<Edge>[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		edges = new List[N];
		int[] D = new int[N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
			D[i] = MAX_VALUE;
		}
		D[0] = 0;
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int d = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			edges[s].add(new Edge(d, w));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,0));
		visited[0] = true;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (Edge next : edges[cur.v]) {
				int v = next.v;
				int ww = next.w;
				if (D[v] > D[cur.v] + ww) {
					D[v] = D[cur.v]+ww;
					pq.offer(new Edge(v, D[v]));
				}
			}
		}
		System.out.println(Arrays.toString(D));
	}
}
