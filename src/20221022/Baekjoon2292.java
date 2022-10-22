import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// String input = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		int criteria = 1;
		int answer = 1;
		for (int i = 1; N > criteria; i++) {
			criteria += 6*i;
			answer++;
			if (N == criteria) break;
		}
		System.out.println(answer);
		
		// System.out.println();
	}
}


/**
  * 2292. ¹úÁı
  * 
**/