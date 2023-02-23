import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		int K = Integer.parseInt(br.readLine());
		
		Map<Integer, Map<Integer, Integer>> allEdgeMap = new HashMap<>();
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			
			Map<Integer, Integer> edgeMap = allEdgeMap.get(u);
			if (edgeMap == null) {
				edgeMap = new HashMap<Integer, Integer>();
				allEdgeMap.put(u, edgeMap);
			}

			Integer weight = edgeMap.get(v);
			if (weight == null) {
				edgeMap.put(v, w);
			}
			else {
				edgeMap.put(v, Math.min(weight, w));
			}
		}
		
		int[] distance = new int[V+1];
		for (int i = 0; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[K] = 0;
		PriorityQueue<Edge> bfs = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		bfs.offer(new Edge(K, 0));
		while ( !bfs.isEmpty() ) {
			Edge edge = bfs.poll();
			
			if (visited[edge.dest]) continue;
			
			visited[edge.dest] = true;
			
			Map<Integer, Integer> edgeMap = allEdgeMap.get(edge.dest);
			if (edgeMap == null) continue;
			for (Integer num : edgeMap.keySet()) {
				distance[num] = Math.min(distance[num], distance[edge.dest] + edgeMap.get(num));
				
				if (!visited[num]) {
					bfs.offer(new Edge(num, distance[num]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (distance[i] != Integer.MAX_VALUE)
				System.out.println(distance[i]);
			else {
				System.out.println("INF");
			}
		}
		
//		for (Integer nKey : allEdgeMap.keySet().stream().sorted().collect(Collectors.toList())) {
//			System.out.println("node : " + nKey);
//			for (Integer edge : allEdgeMap.get(nKey).keySet().stream().sorted().collect(Collectors.toList())) {
//				System.out.println("edge : " + edge + ", weight : " + allEdgeMap.get(nKey).get(edge));
//			}
//		}
	}
}

class Edge implements Comparable<Edge> {
	int dest;
	int weight;
	
	public Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

/**
  * 1753. 최단경로
  * 
**/