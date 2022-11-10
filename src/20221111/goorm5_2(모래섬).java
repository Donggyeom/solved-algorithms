import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = new int[M];
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int minutes = 0;
		int state = 1;
		while ((state = getSandState(map, N, M)) == 1) {
			// 물 증가
			ArrayList<int[]> toWaterList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							
							if (nx >= 0 && nx < N
								 && ny >= 0 && ny < M) {
								int[] np = new int[2];
								np[0] = nx;
								np[1] = ny;
								toWaterList.add(np);
							}
						}
					}
				}
			}
			for (int[] p : toWaterList) {
				map[p[0]][p[1]] = 0;
			}
			
			minutes++;
		}
		
		// 맵 출력 코드
		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < M; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		
		if (state == -1)
			minutes = -1;
		
		System.out.println(minutes);
	}
	
	public static int getSandState(int[][] map, int N, int M) {
		// 모래블럭 갯수 확인
		int sandCount = getSandCount(map, N, M);
		
		// 모래블럭이 없으면 -1 반환
		if (sandCount == 0) return -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					// 처음 만나는 모래 블럭에서 dfs
					int[] p = new int[2];
					p[0] = i;
					p[1] = j;
					// 모래 블럭 dfs 개수 확인
					if (sandCount == sandDfs(map, N, M, p))
						// 개수가 같으면 1 반환
						return 1;
					else
						// 개수가 다르면 0 반환
						return 0;
				}
			}
		}
		
		return 0;
	}
	
	public static int sandDfs(int[][] map, int N, int M, int[] p) {
		int sandCount = 0;
		boolean[][] bVisited = new boolean[N][M];
		Stack<int[]> dfs = new Stack<>();
		dfs.push(p);
		while ( !dfs.isEmpty() ) {
			int[] point = dfs.pop();
			if ( !bVisited[point[0]][point[1]] ) {
				bVisited[point[0]][point[1]] = true;
				sandCount++;
				
				for (int i = 0; i < 4; i++) {
					int nx = point[0] + dx[i];
					int ny = point[1] + dy[i];
					if (nx >= 0 && nx < N
						 && ny >= 0 && ny < M
						 && !bVisited[nx][ny]
						 && map[nx][ny] == 1) {
						int[] np = new int[2];
						np[0] = nx;
						np[1] = ny;
						dfs.push(np);
					}
				}
			}
		}
		
		return sandCount;
	}
	
	public static int getSandCount(int[][] map, int N, int M) {
		int sandCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) sandCount++;
			}
		}
		return sandCount;
	}
}

// 모래 : 1
// 물   : 0