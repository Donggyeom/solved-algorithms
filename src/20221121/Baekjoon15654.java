import java.io.*;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		
		Permutation p = new Permutation(arr, N, M);
		p.recursive(0);

		System.out.print(p.output);
	}
}

class Permutation {
	int[] arr;
	int n;
	int r;

	private int[] temp;
	private boolean[] visited;
	
	public StringBuilder output;
	
	public Permutation(int[] arr, int n, int r) {
		this.arr = arr;
		this.n = n;
		this.r = r;
		
		this.temp = new int[r];
		this.visited = new boolean[n];
		output = new StringBuilder();
	}
	
	void recursive(int depth) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				output.append(temp[i] + " ");
			}
			output.append("\n");
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if ( !visited[i] ) {
				visited[i] = true;
				temp[depth] = arr[i];
				recursive(depth+1);
				
				visited[i] = false;
			}
		}
	}
}

/**
  * 15654. N과 M (5)
  * 
**/