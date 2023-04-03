import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
		arr = Arrays.stream(arr).sorted().toArray();
		
		Permutation p = new Permutation(arr, arr.length, M);
		p.execute(0, 0);
		
		for (String s : p.output.stream().distinct().map(s -> s.trim()).collect(Collectors.toList())) {
			System.out.println(s);
		}
	}
}

class Permutation {
	int n;
	int r;
	
	int[] arr;
	int[] temp;
	
	ArrayList<String> output;
	
	public Permutation(int[] arr, int n, int r) {
		this.arr = arr;
		this.n = n;
		this.r = r;
		
		this.temp = new int[n];
		this.output = new ArrayList<>();
	}
	
	void execute(int l, int s) {
		if (l == r) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < l; i++) {
				sb.append(temp[i] + " ");
			}
			output.add(sb.toString());
			return;
		}
		
		for (int i = s; i < n; i++) {
			temp[l] = arr[i];
			execute(l+1, i);
		}
	}
}

/**
  * 15666. N과 M (12)
  * 
**/