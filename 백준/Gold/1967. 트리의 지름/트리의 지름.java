import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int n;
	static Node[] nodes;
	static boolean[] visited;
	
	static int max, maxIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nodes = new Node[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}
		String[] input = null;
		for (int i = 0; i < n-1; i++) {
			input = br.readLine().split(" ");
			int a, b, w;
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			w = Integer.parseInt(input[2]);
			nodes[a].link(b, w);
			nodes[b].link(a, w);
		}
		
		// 가중치가 가장 큰 노드 찾기
		visited[1] = true;
		maxIdx = 1;
		dfs(1, 0);
		
		// 가중치가 가장 큰 노드를 루트로 dfs
		Arrays.fill(visited, false);
		visited[maxIdx] = true;
		dfs(maxIdx, 0);
		
		System.out.println(max);
	}

	public static void dfs(int idx, int weight) {
		
		if (max < weight) {
			max = weight;
			maxIdx = idx;
		}
		
		for (Edge e : nodes[idx].edges) {
			if (visited[e.dest]) continue;
			visited[e.dest] = true;
			dfs(e.dest, weight + e.weight);
		}
	}
	
}

class Node {
	int number;
	List<Edge> edges = new ArrayList<>();
	
	public Node(int n) {
		this.number = n;
	}
	
	public void link(int d, int w) {
		this.edges.add(new Edge(d, w)); 
	}
	
}

class Edge {
	int dest;
	int weight;
	public Edge(int dest, int weight) {
		super();
		this.dest = dest;
		this.weight = weight;
	}
}

/**
 *  1967. 트리의 지름
 *  
 */