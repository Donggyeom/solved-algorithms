import java.io.*;
import java.util.*;

class Main {
	
	static class Point {
		int x;
		int y;
		int key;	// 각 비트 자리가 키 보유 여부를 나타냄
		public Point(int x, int y, int key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
	
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	
	static char[][] map;
	static boolean[][][] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new char[N][];
		visited = new boolean[(1<<6)][N][M];
		int startX = 0, startY = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}
		Queue<Point> bfs = new ArrayDeque<>();
		bfs.offer(new Point(startX, startY, 0));
		boolean isExited = false;
		int step = 0;
		BFS:
			while (!bfs.isEmpty()) {
				for (int i = 0, size = bfs.size(); i < size; i++) {
					Point p = bfs.poll();
					int x = p.x;
					int y = p.y;
					int key = p.key;
					if (map[x][y] == '1') {
						System.out.printf("%d %d %s\n", x, y, Integer.toBinaryString(key));
						isExited = true;
						break BFS;
					}
					
					for (int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if (!isValidCoord(nx, ny)) continue;
							
						key |= updateKey(nx, ny, step);
						
						if (canMove(nx, ny, key) && !visited[key][nx][ny]) {
							bfs.offer(new Point(nx, ny, key));
							visited[key][nx][ny] = true;
						}
					}
				}
				step++;
			}
		
		if (isExited) System.out.println(step);
		else System.out.println(-1);
	}

	private static boolean canMove(int x, int y, int key) {
		char c = map[x][y];
		if (c == '#') return false;
		if (c >= 'A' && c <= 'F') {
			if (c == 'A') {
				System.out.printf("A lock %s - %s\n", Integer.toBinaryString(1 << (c - 'A')), Integer.toBinaryString(key));
			}
			int lock = 1 << (c - 'A');
			return (lock & key) > 0;
		}
		return true;
	}

	private static int updateKey(int x, int y, int step) {
		if (map[x][y] >= 'a' && map[x][y] <= 'f') {
			System.out.printf("key : %c step : %d\n", map[x][y], step);
			return 1 << (map[x][y]-'a');
		}
		return 0;
	}

	private static boolean isValidCoord(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

/**
 *	1194. 달이 차오른다, 가자
 */