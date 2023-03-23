import java.io.BufferedReader;
import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge> {
	int S;
	int D;
	int P;
	public Edge(int d, int p) {
		D = d;
		P = p;
	}
	public Edge(int s, int d, int p) {
		S = s;
		D = d;
		P = p;
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.P, o.P);
	}
	@Override
	public String toString() {
		return "["+S+" "+D+" "+P+"]";
	}
}

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder sb = new StringBuilder(10);
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>();

	static int N, M, S, D;
	static List<Edge>[] edgeList = new List[500];
	static List<Integer>[] parents = new List[500];	// 각 인덱스의 이전 노드로 부터 연결된 간선 저장
	static int[] distances = new int[500];
	static Queue<Integer> nextQueue = new ArrayDeque<>();
	static boolean[] visited = new boolean[500];
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
	
	static int inputToInt() {
		return Integer.parseInt(st.nextToken());
	}
	
	static boolean init() {
		try {
			input();	// N, M
			N = inputToInt();
			M = inputToInt();
			if (N == 0 && M == 0) {
				System.out.println(sb);	// 결과 출력
				return false;
			}
			
			input();	// S, D
			S = inputToInt();
			D = inputToInt();
			for (int i = 0; i < N; i++) {
				edgeList[i].clear();
			}
			for (int i = 0; i < M; i++) {
				input();	// edge s, d, p
				int s = inputToInt();
				int d = inputToInt();
				int p = inputToInt();
				List<Edge> edges = edgeList[s];
				Edge e = new Edge(s, d, p);
				edges.add(e);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return true;
	}
	
	public static void main(String[] args) {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 500; i++) {
			edgeList[i] = new ArrayList<>();
			parents[i] = new ArrayList<>();
		}
		while (init()) {
			// 다익스트라 최단거리를 구하고(경로를 모두 저장) 해당 간선을 모두 삭제
			dijkstras();
			res = distances[D];
			
			if (res == Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
				continue;
			}
			
			// 다시 다익스트라로 최단 경로를 구하고 출력 문자열에 세팅
			removePath();
			dijkstras();
			res = distances[D];
		
			if (res == Integer.MAX_VALUE) {
				res = -1;
			}
			sb.append(res).append("\n");
		}
	}
	
	private static void removePath() {
		nextQueue.clear();
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		nextQueue.offer(D);
		visited[D] = true;
		
		while (!nextQueue.isEmpty()) {
			int d = nextQueue.poll();
			List<Integer> list = parents[d];
			for (int i = list.size()-1; i >= 0; i--) {
				int p = list.get(i);
				
				if (!visited[p])
					nextQueue.offer(p);
				
				visited[p] = true;
				
				List<Edge> eList = edgeList[p];
				for (int j = 0, len = eList.size(); j < len; j++) {
					if (eList.get(j).D != d) continue;
					eList.remove(j);
					break;
				}
			}
		}
	}

	private static void dijkstras() {
		for (int i = 0; i < N; i++) {
			distances[i] = Integer.MAX_VALUE;
			parents[i].clear();
		}
		distances[S] = 0;
		pqueue.clear();
		pqueue.add(new Edge(S, 0));
		while (!pqueue.isEmpty()) {
			Edge node = pqueue.poll();
			int now = node.D;
			int pathSum = node.P;
			
			if (now == D) continue;
			
			if (distances[now] < pathSum) continue;
			
			for (int i = 0, length = edgeList[now].size(); i < length; i++) {
				Edge edge = edgeList[now].get(i);
				int next = edge.D;
				
				if (distances[next] == (pathSum + edge.P)) {
					parents[next].add(now);
				}
				else if (distances[next] >= (pathSum + edge.P)) {
					distances[next] = (pathSum + edge.P);
					Edge path = new Edge(edge.S, next, distances[next]);
					parents[next].clear();
					parents[next].add(now);
					pqueue.offer(path);
				};
			}
		}
	}
}

/**
 *	5719. 거의 최단 경로 
 */