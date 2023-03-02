import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
	
	static class Edge implements Comparable<Edge> {
		int to;
		int w;
		public Edge(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		@Override
		public String toString() {
			return "["+to+", "+w+"]";
		}
	}
	
	static int V, E, S;	// 정점의 개수 V와 간선의 개수 E, 시작 정점의 번호 S
	static ArrayList<Edge>[] edgeList;
	static int[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		S = Integer.parseInt(br.readLine());
		edgeList = new ArrayList[V+1];
		distance = new int[V+1];
		visited = new boolean[V+1];
		for (int i = 1; i <= V; i++) {
			edgeList[i] = new ArrayList<Edge>(); 
		}
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			
			edgeList[u].add(new Edge(v, w));
			//edgeList[v].add(new Edge(u, w));
		}
		
		dijkstra();
		
		StringBuilder sb = new StringBuilder(10);
		for (int i = 1; i <= V; i++) {
			if (distance[i] != Integer.MAX_VALUE)
				sb.append(distance[i]).append("\n");
			else 
				sb.append("INF\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra() {
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[S] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(S, 0));
		
		while (!pq.isEmpty()) {	
			Edge cur = pq.poll();
			
			if (visited[cur.to]) continue;
			
			visited[cur.to] = true;
			distance[cur.to] = cur.w;
			
			for (Edge e : edgeList[cur.to]) {
				int dest = e.to;
				if (visited[dest]) continue;
				
				distance[dest] = Math.min(distance[dest], distance[cur.to] + e.w);
				pq.offer(new Edge(dest, distance[dest]));
			}
		}
	}
}

/**
 *	1753. 최단경로 
 */