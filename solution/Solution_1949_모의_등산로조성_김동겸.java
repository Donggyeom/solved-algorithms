import java.io.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder(20);
	
	static int N, K, result;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	private static int init() throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		map = new int[N][N];
		visited = new boolean[N][N];
		result = 0;
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			// 테스트케이스 시작
			int max = init();	// 최대 높이를 저장
			
			// 1. 최대 높이 인덱스를 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != max) continue;
					
					// 2. dfs 돌면서 최대 길이의 경로를 구함
					dfs(i, j, 1, false);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		} // 테스트케이스 끝
		
		System.out.print(sb);
	}

	private static void dfs(int x, int y, int cnt, boolean kUsed) {
		

		visited[x][y] = true;
		
		int currentNumber = map[x][y];
		int nextCount = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isValidCoord(nx, ny) && !visited[nx][ny]) {
				if (map[nx][ny] < currentNumber) {
					dfs(nx, ny, cnt+1, kUsed);
					nextCount++;
				}
				else if (!kUsed && map[nx][ny] - K < currentNumber) {
					int temp = map[nx][ny]; 
					map[nx][ny] = currentNumber-1;
					dfs(nx, ny, cnt+1, true);
					map[nx][ny] = temp;
					nextCount++;
				}
			}
		}
		
		if (nextCount == 0) result = Math.max(result, cnt);
		
		visited[x][y] = false;
	}

	private static boolean isValidCoord(int nx, int ny) {
		return nx>=0&&nx<N&&ny>=0&&ny<N;
	}
	
}

/**
 *  1949. 등산로 조성
 */