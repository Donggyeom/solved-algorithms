import java.io.*;
import java.util.Scanner;

class Solution {
	
	static int[] parents;
	static int T, N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(10);
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			parents = new int[N+1];
			
			// makeSet
			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			sb.append("#").append(tc).append(" ");
			
			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				int op = Integer.parseInt(input[0]);
				int a = Integer.parseInt(input[1]);
				int b = Integer.parseInt(input[2]);
				if (op == 0) {
					union(a, b);
				}
				else {
					if (findSet(a) == findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void union(int a, int b) {
		int root1 = findSet(a);
		int root2 = findSet(b);
		
		if (root1 == root2) return;
		
		parents[root2] = root1;
	}

	private static int findSet(int v) {
		if (parents[v] == v) return v;
		
		return (parents[v] = findSet(parents[v]));
	}
}

/**
 *  swea 3289. 서로소 집합
 */