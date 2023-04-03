import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Node> nodeList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nodeList.add(new Node());
		}
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			Node e = nodeList.get(Integer.parseInt(input[0])-1);
			Map<Integer, Integer> edges = e.edges;
			int end = Integer.parseInt(input[1]) - 1;
			Integer cost = edges.get(end);
			if (cost == null) {
				edges.put(end, Integer.parseInt(input[2]));
			}
			else {
				cost = Math.min(cost, Integer.parseInt(input[2]));
				edges.put(end, cost);
			}
		}
		
		String[] input = br.readLine().split(" ");
		int begin = Integer.parseInt(input[0])-1;
		int dest = Integer.parseInt(input[1])-1;
		
		PriorityQueue<Cost> dijkstra = new PriorityQueue<>();
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		d[begin] = 0;
		boolean[] visited = new boolean[N];

		dijkstra.offer(new Cost(begin, d[begin]));
		
		while ( !dijkstra.isEmpty() ) {
			Cost c = dijkstra.poll();
			
			int num = c.num;
			int cost = c.val;
			visited[num] = true;
			
			Map<Integer, Integer> edges = nodeList.get(num).edges;
			Set<Integer> keyset = edges.keySet();
			
			dijkstra.clear();
			for (int i = 0; i < N; i++) {
				if (keyset.contains(i)) {
					if (cost != Integer.MAX_VALUE)
						d[i] = Math.min(d[i], cost + edges.get(i).intValue());
				}
				
				if (visited[i]) continue;
				
				dijkstra.offer(new Cost(i, d[i]));
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.print(d[i] + " ");
//			}
//			System.out.println();
		}
		
		System.out.println(d[dest]);
	}
}

class Node {
	int num;
	Map<Integer, Integer> edges;
	
	public Node() {
		edges = new HashMap<>();
	}
}

class Cost implements Comparable<Cost> {
	int num;
	int val;
	
	public Cost(int n, int v) {
		num = n;
		val = v;
	}
	
	@Override
	public int compareTo(Cost o) {
		return this.val - o.val;
	}
}

/**
  * 1916. 최소비용 구하기
  * 
**/