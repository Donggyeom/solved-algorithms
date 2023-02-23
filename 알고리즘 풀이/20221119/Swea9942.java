import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10];
		for (int i = 1; i <= 10; i++) {
			arr[i-1] = i;
		}
		
		Permutation[] p = new Permutation[10];
		for (int i = 1; i <= 10; i++) {
			p[i-1] = new Permutation(arr, i, i);
			p[i-1].recursive(0);
		}
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < tc; i++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);

			List<int[]> pArr = p[n-1].output;
			long cnt = 0;

			for (int[] perm : pArr) {
				int sum = 0;
				for (int a = 1; a <= n; a++) {
					sum += Math.max(a, perm[a-1]);
					if (sum >= k) {
						cnt++;
						break;
					}
				}
			}
			cnt *= pArr.size();
			
			System.out.println("#"+(i+1)+" " + cnt);
		}
	}
}

class Permutation {
	int[] arr;
	private int[] temp;
	ArrayList<int[]> output;
	boolean[] visited;
	int n;
	int r;
	
	public Permutation(int[] arr, int n, int r) {
		this.arr = arr;
		this.n = n;
		this.r = r;
		this.temp = new int[r];
		this.output = new ArrayList<>();
		this.visited = new boolean[n];
	}
	
	void recursive(int depth) {
		if (depth == r) {
			output.add(temp.clone());
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
 *  SWEA
 *  9942. 순열2
 */
	