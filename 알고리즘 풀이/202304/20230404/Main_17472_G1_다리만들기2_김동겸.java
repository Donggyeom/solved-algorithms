import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int v1, v2, w;

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", w=" + w + "]";
		}

		public Edge(int v1, int v2, int w) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static final int INF = Integer.MAX_VALUE>>2;

	static int N, M, islandCount;
	static int[][] map;
	static PriorityQueue<Edge> edges;
	
	// 서로소
	static int[] parents;
	
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		edges = new PriorityQueue<>();
		Queue<int[]> lands = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(input[j]);
				if (num == 1) {
					lands.offer(new int[] {i, j});
					num = 9;	// 초기화되기 전 섬을 9로 세팅
				}
				map[i][j] = num;
			}
		}
		
		// 섬 번호 세팅
		int islandNumber = 1;
		while (!lands.isEmpty()) {
			int[] p = lands.poll();
			int x = p[0];
			int y = p[1];
			if (map[x][y] != 9) continue;
			
			Queue<int[]> bfs = new ArrayDeque<>();
			bfs.offer(p);
			map[x][y] = islandNumber;
			while (!bfs.isEmpty()) {
				p = bfs.poll();
				x = p[0];
				y = p[1];
				for (int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if (isValidCoord(nx, ny) && map[nx][ny] == 9) {
						map[nx][ny] = islandNumber;
						bfs.offer(new int[] {nx, ny});
					}
				}
			}
			islandNumber++;
		}
		
		// 섬 간 거리 계산
		// 가로
		int start = -1, distance = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					if (start == -1) {
						start = map[i][j];
						distance = 0;
					}
					else if (map[i][j] == start) {
						distance = 0;
					}
					else if (map[i][j] != start) {
						// 간선 추가
						if (distance > 1)
							edges.offer(new Edge(start, map[i][j], distance));
						start = map[i][j];
						distance = 0;
					}
				}
				else {
					if (start != -1) distance++;
				}
			}
			start = -1;
			distance = 0;
		}
		// 세로
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (map[i][j] != 0) {
					if (start == -1) {
						start = map[i][j];
						distance = 0;
					}
					else if (map[i][j] == start) {
						distance = 0;
					}
					else if (map[i][j] != start) {
						// 간선 추가
						if (distance > 1)
							edges.offer(new Edge(start, map[i][j], distance));
						start = map[i][j];
						distance = 0;
					}
				}
				else {
					if (start != -1) distance++;
				}
			}
			start = -1;
			distance = 0;
		}
		
//		// DEBUG: 섬 출력
//		edges.forEach(System.out::println);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		// makeSet
		islandCount = islandNumber-1;
		parents = new int[islandCount + 1];
		for (int i = 1; i <= islandCount; i++) {
			parents[i] = i;	
		}
		
		int edgeCnt = islandCount - 1;
		int sum = 0;
		while (edgeCnt > 0 && !edges.isEmpty()) {
			Edge e = edges.poll();
			int v1 = e.v1;
			int v2 = e.v2;
			if (findSet(v1) == findSet(v2)) continue;
			
			union(v1, v2);
			sum += e.w;
			edgeCnt--;
		}
		
		if (edgeCnt == 0) System.out.println(sum);
		else System.out.println(-1);
		
		
		
	}

	private static boolean isValidCoord(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	private static int findSet(int v) {
		if (v == parents[v]) return v;
		return (parents[v] = findSet(parents[v]));
	}
	
	private static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA == rootB) return;
		parents[rootB] = rootA;
	}
}

/**
 *  17472. 다리 만들기 2
 */
