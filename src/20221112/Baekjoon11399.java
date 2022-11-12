import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(nums);
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += nums[i]*(N-i);
		}
		bw.write(Integer.toString(answer));		
		bw.flush();
	}
}


/**
  * 11399. ATM
  * 
**/