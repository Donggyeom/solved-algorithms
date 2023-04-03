import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, List<Integer>> edges = new HashMap<>();
		for (int i = 0; i < N; i++) {
			edges.put(i, new ArrayList<>());
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int[] num = new int[2];
			num[0] = Integer.parseInt(st.nextToken()) - 1;
			num[1] = Integer.parseInt(st.nextToken()) - 1;
			
			edges.get(num[0]).add(num[1]);
			edges.get(num[1]).add(num[0]);
		}

		Bfs bfs = new Bfs(edges, N);
		bfs.init(0);
		bfs.execute();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(bfs.answer[i]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}

class Bfs {
	Queue<Integer> que;
	Map<Integer, List<Integer>> edges;
	int n;
	boolean[] visited;
	
	int[] answer;
	
	public Bfs(Map<Integer, List<Integer>> edges, int n) {
		que = new LinkedList<>();
		this.edges = edges;
		this.answer = new int[n+1];
		this.n = n;
		this.visited = new boolean[n];
	}
	
	void init(int root) {
		que.clear();
		que.add(root);
	}
	
	void execute() {
		while ( !que.isEmpty() ) {
			int len = que.size();
			for (int j = 0; j < len; j++) {
				int p = que.poll();
				if ( !visited[p] ) {
					visited[p] = true;
					for (int c : edges.get(p)) {
						if ( !visited[c] ) {
							answer[c+1] = p+1;
							que.offer(c);
						}
					}
				}
			}
		}
	}
}

/**
  * 11725. 트리의 부모 찾기
  * 
**/