import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		String[] input = br.readLine().split(" ");
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(input[i]);
			min = min > num ? num : min;
			max = max < num ? num : max;
		}
		System.out.println(min + " " + max);
	}
}


/**
  * 10818. 최소, 최대
  * 
**/