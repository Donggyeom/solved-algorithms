import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	
	static final char VISITED = '-';

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int SIZE;
	static int N;			// 1 ~ 100
	static char[][] map, cpyMap;	
	
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		SIZE = N*N;
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception{
		init();
		
		int normalCnt = getSectionCount();
		
		// R -> G로 변환
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		
		int abnormalCnt = getSectionCount();

		System.out.println(normalCnt + " " + abnormalCnt);
		
		br.close();
	}

	private static int getSectionCount() {
		cpyMap = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cpyMap[i][j] = map[i][j];
			}
		}
		
		int sectionCount = 0;
		int visitCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cpyMap[i][j] != VISITED) {
					visitCount += dfs(i, j);
					sectionCount++;
				}
				
				if (visitCount == SIZE) {
					j = N; i = N;	// for Loop 탈출
				}
			}
		}
		
		return sectionCount;
	}

	private static int dfs(int x, int y) {
		int sum = 0;
		cpyMap[x][y] = VISITED;
		char target = map[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isValidCoord(nx, ny) && cpyMap[nx][ny] == target) {
				sum += dfs(nx, ny);
			}
		}
		return sum;
	}

	private static boolean isValidCoord(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	
}

/**
 *  10026. 적록색약
 */