import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		final int VACCUM	= 0;
		final int WALL		= 1;
		final int HORIZONTAL	= 0;
		final int VERTICAL		= 1;
		final int ASKEW			= 2;	// 비스듬한
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = null;
		int N = Integer.parseInt(br.readLine());
		long[][] map = new long[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(input[j-1]);
			}
		}
		
		// [상태][r][c]일 때 놓을 수 있는 경우의 수를 저장하는 dp 배열. 놓일 수 없는 경우 -1로 저장
		long[][][] dp = new long[3][N+1][N+1];
		dp[HORIZONTAL][1][2] = 1;	// [0,1] 위치에 수평으로 놓인 상태로 시작
		
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				// 현재 위치가 벽이라면 다음 칸으로 이동
				if (map[i][j] == WALL) continue;
				
				long cnt = 0;
				// 수평 상태로 놓일 수 있는 경우의 수
				cnt = 0;
				cnt += dp[HORIZONTAL][i][j-1];
				cnt += dp[ASKEW][i][j-1];
				dp[HORIZONTAL][i][j] = cnt;
				
				// 수직 상태로 놓일 수 있는 경우의 수
				cnt = 0;
				cnt += dp[VERTICAL][i-1][j];
				cnt += dp[ASKEW][i-1][j];
				dp[VERTICAL][i][j] = cnt;
				
				// 대각선 상태로 놓일 수 있는 경우의 수
				cnt = 0;
				if (map[i-1][j] != WALL && map[i][j-1] != WALL) {
					cnt += dp[HORIZONTAL][i-1][j-1];
					cnt += dp[VERTICAL][i-1][j-1];
					cnt += dp[ASKEW][i-1][j-1];
				}
				dp[ASKEW][i][j] = cnt;
			}
		}
		
//		for (int i = 0; i < 3; i++) {
//			for (int j = 1; j <= N; j++) {
//				for (int k = 1; k <= N; k++) {
//					System.out.print(dp[i][j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==================");
//		}
		System.out.println(dp[HORIZONTAL][N][N] + dp[VERTICAL][N][N] + dp[ASKEW][N][N]);
	}
}

/**
 *	17069. 파이프 옮기기 2
 */