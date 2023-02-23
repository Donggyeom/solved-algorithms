import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11659_S3_구간합구하기4_김동겸 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] numbers = new int[N];
		int[] dp = new int[N+1];
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(input[i]);
			dp[i+1] = dp[i] + numbers[i];
		}
		
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]) - 1;
			int end = Integer.parseInt(input[1]);
			sb.append(dp[end] - dp[start]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
