import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int destX, destY;
	static int[] S;
	static Queue<int[]> waters;
	
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][];
		visited = new boolean[R][C];
		waters = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'D') {
					destX = i;
					destY = j;
				}
				else if (map[i][j] == 'S') {
					S = new int[] {i, j};
				}
				else if (map[i][j] == '*') {
					waters.offer(new int[] {i, j});
				}
			}
		}
		
		boolean isArrived = false;
		Queue<int[]> bfs = new ArrayDeque<>();
		bfs.offer(S);
		visited[S[0]][S[1]] = true;
		int time = 1;
		BFS:
			while (!bfs.isEmpty()) {
				// 물 범람
				for (int i = 0, size = waters.size(); i < size; i++) {
					int[] p = waters.poll();
					for (int j = 0; j < 4; j++) {
						int nx = p[0] + dx[j];
						int ny = p[1] + dy[j];
						if (isValidCoord(nx, ny) && map[nx][ny] != 'X' && map[nx][ny] != '*' && map[nx][ny] != 'D') {
							map[nx][ny] = '*';
							waters.offer(new int[] {nx, ny});
						}
					}
				}
				
				// 고슴도치 이동
				for (int i = 0, size = bfs.size(); i < size; i++) {
					int[] p = bfs.poll();
					int x = p[0];
					int y = p[1];
					for (int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if (isValidCoord(nx, ny) && !visited[nx][ny] && map[nx][ny] != 'X' && map[nx][ny] != '*') {
							
							if (nx == destX && ny == destY) {
								isArrived = true;
								break BFS;
							}
							
							bfs.offer(new int[] {nx, ny});
							visited[nx][ny] = true;
						}
					}
				}
				
				time++;
			}

		if (isArrived) System.out.println(time);
		else System.out.println("KAKTUS");
	}

	private static boolean isValidCoord(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}

/**
 * 3055. 탈출
 */
