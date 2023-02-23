import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] arr = new int[N];
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		
		Permutation p = new Permutation(arr, N, M);
		p.execute(0, 0);
	}
}

class Permutation {
	int n;
	int r;
	
	int[] arr;
	int[] temp;
	
	public Permutation(int[] arr, int n, int r) {
		this.arr = arr;
		this.n = n;
		this.r = r;
		
		this.temp = new int[n];
	}
	
	void execute(int l, int s) {
		if (l == r) {
			for (int i = 0; i < l; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = s; i < n; i++) {
			temp[l] = arr[i];
			execute(l+1, i);
		}
	}
}

/**
  * 15657. N과 M (8)
  * 
**/