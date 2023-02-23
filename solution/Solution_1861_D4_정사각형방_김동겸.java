import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Solution_1861_D4_정사각형방_김동겸 {
	
	static int[] dx = { -1,  0, +1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			// 맵 초기화
			Map<Integer, Integer> coordMap = new HashMap<>();	// 31~16bit : x, 15~0bit : y
			int[][] map = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(input[j-1]);	// 1 ~ N^2
					coordMap.put(map[i][j], (i<<16) | j );
				}
			}
			
			int size = N*N;
			int idx = 1;	// 시작값
			int resultIdx = 1;
			int resultLength = 1;
			int[] validCoords = new int[4];		// 다음 가능 좌표값
			validCoords[0] = coordMap.get(1);
			for (int i = 1; i <= size; i++) {
				
				int coord = coordMap.get(i);
				
				boolean isExtended = false;		// 연장 가능 여부 검사
				for (int valid : validCoords) {
//					// debug
//					
//					int x = valid >> 16;
//					int y = valid & ((1 << 16) - 1);
//					
//					System.out.println("i: " + i + " valid");
//					System.out.printf("%d %d\n", x, y);
					
					if (coord == valid) {
						isExtended = true;
						break;
					}
				}
				
				if (!isExtended) {
					if (resultLength < i - idx) {
						resultLength = i - idx;
						resultIdx = idx;
					}
					idx = i;
				}
				
				// i == size이고, 연장됐을 때
				if (i == size) {
					if (resultLength < i - idx + 1) {
						resultLength = i - idx + 1;
						resultIdx = idx;
					}
					break;
				}
				
				int x = coord >> 16;
				int y = coord & ((1 << 16) - 1);
				
				// 사방좌표
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (isValidCoord(N, nx, ny))
						validCoords[j] = nx << 16 | ny;
					else
						validCoords[j] = 0;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(resultIdx).append(" ").append(resultLength).append("\n");
		}
		System.out.print(sb);
	}

	private static boolean isValidCoord(int N, int nx, int ny) {
		return nx>0 && nx<=N && ny>0 && ny<=N;
	}
	
}

/**
 * SWEA 정사각형 방
 * 
 */
