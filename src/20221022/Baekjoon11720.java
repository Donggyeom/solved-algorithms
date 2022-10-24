import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine(); // N 버림
		String input = br.readLine();
		int N = input.length();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (input.charAt(i) - '1' + 1);
		}
		
		System.out.println(sum);
	}
}


/**
  * 11720. 숫자의 합
  * 
**/