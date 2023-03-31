import java.util.Arrays;

public class UnionFind {
	
	static int N = 5;
	static int[] parents;
	
	private static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
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

	public static void main(String[] args) {
		makeSet();
		
		union(2, 4);
		
		union(1, 4);
		
		findSet(4);
		
		System.out.println(Arrays.toString(parents));
	}

}
