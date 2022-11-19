
class Main {
	
	public static void main(String[] args) {
		int n = 3;
		int[] arr = {1, 2, 3};
		
		Permutation p = new Permutation(arr, n, 3);
		for (int i = 1; i <= 3; i++) {
			p.r = i;
			p.recursive(0);
		}
		
	}
}

class Permutation {
	int[] arr;
	int n;
	int r;
	int[] output;
	boolean[] visited;
	
	public Permutation(int[] arr, int n, int r) {
		this.arr = arr;
		this.n = n;
		this.r = r;
		output = new int[n];
		visited = new boolean[n];
	}
	
	void recursive(int depth) {
		if (depth == r) {
			print(r);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if ( !visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				recursive(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	void print(int r) {
		for (int i = 0; i < r; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
}