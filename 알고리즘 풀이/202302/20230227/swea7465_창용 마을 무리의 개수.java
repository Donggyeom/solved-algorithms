import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, N, M;
	static int parents[];
	
	private static int[] input() throws IOException {
		String[] input = br.readLine().split(" ");
		int[] intArr = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intArr[i] = Integer.parseInt(input[i]);
		}
		return intArr;
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder(10);
		T = input()[0];
		for (int tc = 1; tc <= T; tc++) {
			int[] intArr = input();
			N = intArr[0];
			M = intArr[1];
			parents = new int[N+1];
			// makeSet
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < M; i++) {
				union(input());
			}
			
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(findSet(i));
			}
			
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
		
	}

	private static void union(int[] v) {
		int root1 = findSet(v[0]);
		int root2 = findSet(v[1]);
		
		if (root1 == root2) return;
		
		parents[root2] = root1;
	}

	private static int findSet(int v) {
		if (parents[v] == v) return v;
		
		return (parents[v] = findSet(parents[v]));
	}
}

/**
 *  swea 7465. 창용 마을 무리의 개수
 */