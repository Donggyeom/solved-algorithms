import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] numbers = new int[N+1];
		int[] sumDp = new int[N+1];
		
		input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(input[i-1]);
			sumDp[i] = sumDp[i-1] + numbers[i];
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			int answer = sumDp[b] - sumDp[a-1];
			System.out.println(answer);
		}

		// System.out.println();
	}
}


/**
  * 11659. 구간 합 구하기 4
  * 
**/