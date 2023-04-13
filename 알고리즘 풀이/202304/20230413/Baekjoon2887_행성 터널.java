import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static class Planet {
		int num;
		int x;
		int y;
		int z;
		@Override
		public String toString() {
			return "Planet [num=" + num + ", x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		public Planet(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public Planet() {
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int s;
		int d;
		long w;
		public Edge(int s, int d, long w) {
			super();
			this.s = s;
			this.d = d;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", d=" + d + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	static int N, parents[];
	static Planet[] planets;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		planets = new Planet[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			planets[i] = new Planet(i, Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
		}

		makeSet(N);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.x, p2.x));
		for (int i = 0, e = N-1; i < e; i++) {
			pq.offer(new Edge(planets[i].num, planets[i+1].num, Math.abs(planets[i].x - planets[i+1].x)));
		}
		Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.y, p2.y));
		for (int i = 0, e = N-1; i < e; i++) {
			pq.offer(new Edge(planets[i].num, planets[i+1].num, Math.abs(planets[i].y - planets[i+1].y)));
		}
		Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.z, p2.z));
		for (int i = 0, e = N-1; i < e; i++) {
			pq.offer(new Edge(planets[i].num, planets[i+1].num, Math.abs(planets[i].z - planets[i+1].z)));
		}

		int cnt = 0;
		long wSum = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if (findSet(edge.s) == findSet(edge.d)) continue;
			
			union(edge.s, edge.d);
			
			wSum += edge.w;
		}
		
		System.out.println(wSum);
	}
	
	static void makeSet(int N) {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int v) {
		if (parents[v] == v) return v;
		return (parents[v] = findSet(parents[v]));
	}
	
	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA == rootB) return;
		parents[rootB] = rootA;
	}
}

/**
 *  2887. 행성 터널
 *  
 */