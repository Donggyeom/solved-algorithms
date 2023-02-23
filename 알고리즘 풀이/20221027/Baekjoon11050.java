import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);	
		
		K = K > N-K ? N-K : K; 
		
		int[][] pascalDp = new int[N + 1][N + 3];
		pascalDp[0][0] = 1;
		pascalDp[1][0] = 1;
		pascalDp[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			pascalDp[i][0] = 1;
			pascalDp[i][i] = 1;
			for (int j = 1; j <= i; j++) {
				pascalDp[i][j] = pascalDp[i-1][j-1] + pascalDp[i-1][j];
			}
		}
		
		System.out.println(pascalDp[N][K]);
	}
}

/**
  * 11050. 이항 계수 1 
  * 
  * nCk = 파스칼 삼각형 n행 k열 값과 같다. (n >= 0, k >= 0)
  * 
  * 파스칼 삼각형
  * dp[0][0] = 1
  * dp[1][0] = dp[1][1] = 1
  * ...
  * dp[n][0] = 1
  * dp[n][k] = dp[n-1][k-1] + dp[n-1][k] (k >= 1)
  * 
**/