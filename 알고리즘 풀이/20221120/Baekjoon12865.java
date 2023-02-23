import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);		// 물품의 수
		int K = Integer.parseInt(input[1]);		// 버틸 수 있는 무게
		
		Stuff[] arr = new Stuff[N + 1];				// 물품 배열
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			arr[i] = new Stuff(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		int[][] dp = new int[K+1][N+1];
		
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (i >= arr[j].weight )
					dp[i][j] = Math.max(dp[i-arr[j].weight][j-1] + arr[j].value, dp[i][j-1]);
				else
					dp[i][j] = dp[i][j-1];
			}
		}
		
		System.out.println(dp[K][N]);
	}
}

class Stuff {
	int weight;	// 무게
	int value;	// 가치
	
	public Stuff(int wi, int vi) {
		weight = wi;
		value = vi;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return weight + " " + value;
	}
}

/**
  * 12865. 평범한 배낭
  * 
**/