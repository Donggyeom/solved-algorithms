import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int n;
	static List<Edge>[] edges;
	
	// dfs
	static long max = 0;
	static int maxIdx = 1;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		edges = new List[n+1];
		String[] input = null;
		for (int i = 1; i <= n; i++) {
			input = br.readLine().split(" ");
			int cur = Integer.parseInt(input[0]);
			edges[cur] = new ArrayList<>();
			int j = 1;
			while (true) {
				int edge = Integer.parseInt(input[j]);
				if (edge == -1) break;
				int weight = Integer.parseInt(input[j+1]);
				
				edges[cur].add(new Edge(edge, weight));
				j += 2;
			}
		}
		
//		for (int i = 1; i <= n; i++) {
//			System.out.print(edges[i]);
//			edges[i].forEach(num -> System.out.print(num + " "));
//			System.out.println();
//		}
		
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(1, 0);
		
		max = 0;
		Arrays.fill(visited, false);
		visited[maxIdx] = true;
		dfs(maxIdx, 0);
		
		System.out.println(max);
	}

	private static void dfs(int node, long weight) {
		if (max < weight) {
			max = weight;
			maxIdx = node;
		}
		
		for (Edge e : edges[node]) {
			if (visited[e.number]) continue;
			visited[e.number] = true;
			
			dfs(e.number, weight + e.weight);
		}
	}
	
}

class Edge {
	int number;
	int weight;
	
	public Edge(int number, int weight) {
		this.number = number;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [number=" + number + ", weight=" + weight + "]";
	}
}

/**
 *  1967. 트리의 지름
 *  
 */