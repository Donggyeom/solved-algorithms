import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		Combination c = new Combination(arr, N, M, bw);
		c.recursive(0, 0);
		
		bw.flush();
	}
}

class Combination {
	int[] arr;
	int n;
	int r;
	
	private int[] temp;
	boolean[] visited;
	BufferedWriter bw;
	
	public Combination(int[] arr, int n, int r, BufferedWriter bw) {
		this.arr = arr;
		this.n = n;
		this.r = r;
		
		this.temp = new int[r];
		this.visited = new boolean[n];
		this.bw = bw;
	}
	
	public void recursive(int start, int l) throws IOException {
		if (l == r) {
			for (int i = 0; i < r; i++) {
				bw.append(temp[i] + " ");
			}
			bw.append("\n");
			return;
		}
		
		for (int i = start; i < n; i++) {
			if ( !visited[i] ) {
				visited[i] = true;
				temp[l] = arr[i];
				recursive(i+1, l+1);
				
				visited[i] = false;
			}
		}
	}
}

/**
  * 15650. N과 M (2)
  * 
**/