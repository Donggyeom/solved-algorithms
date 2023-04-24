import java.util.Arrays;

public class UnionFind {
	
	static int[] parents = {0,1,2,3,4,5};
	
	public static void main(String[] args) {
		
		union(1, 3);
		union(2, 4);
		
		System.out.println(Arrays.toString(parents));
		
		union(1,2);
		
		System.out.println(Arrays.toString(parents));
		
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
