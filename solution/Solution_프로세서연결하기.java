import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution_프로세서연결하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(10);
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			// 테스트케이스 시작
			int coreCnt = 0;
			int connectedCoreCnt = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N+1][N+1];
			// 맵 초기화
			for (int i = 1; i <= N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(input[j-1]);
					
					// 코어 개수 카운트
					if (map[i][j] == 1) {
						coreCnt++;
						// 끝 단에 있는 코어만큼 연결된 코어 개수 증가
						if (i == 1 || i == N
								|| j == 1 || j == N) {
							connectedCoreCnt++;
						}
					}
				}
			}
			
			// 
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
}

/**
  * 1767. 프로세서 연결하기
  * 
	[입력]
	테스트케이스의 수
	코어의 수	// 7 <= N <= 12
	전체 맵[0,1]
**/ 