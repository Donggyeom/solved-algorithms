import java.io.*;
import java.util.*;

class Main {
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	static int[] dkx = { -2, -2, -1,  1,  2,  2,  1, -1 };
	static int[] dky = { -1,  1,  2,  2,  1, -1, -2, -2 };
	static int W, H;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		W = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);
		int[][] map = new int[H][W];
		boolean[][][] visited = new boolean[K+1][H][W];
		for (int i = 0; i < H; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		int destX = H-1;
		int destY = W-1;
		Queue<int[]> bfs = new ArrayDeque<>();
		bfs.offer(new int[] {0, 0, 0});
		visited[0][0][0] = true;
		int count = 0;
		boolean isArrive = false;
		BFS:
			while (!bfs.isEmpty()) {
//				System.out.println("=========== " + count + "============");
				for (int i = 0, size = bfs.size(); i < size; i++) {
					int[] move = bfs.poll();
					int x = move[0];
					int y = move[1];
					int kMoveCnt = move[2];
//					System.out.println(Arrays.toString(move));
					if (x == destX && y == destY) {
						isArrive = true;
						break BFS;
					}
					
					// 사방탐색
					for (int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						
						if (isValidCoord(nx, ny) && map[nx][ny] != 1 && !visited[kMoveCnt][nx][ny]) {
							visited[kMoveCnt][nx][ny] = true;
							bfs.offer(new int[] {nx, ny, kMoveCnt});
						}
					}
					
					if (kMoveCnt == K) continue; 
					// 나이트 이동
					kMoveCnt++;
					for (int j = 0; j < 8; j++) {
						int nx = x + dkx[j];
						int ny = y + dky[j];
						
						if (isValidCoord(nx, ny) && map[nx][ny] != 1 && !visited[kMoveCnt][nx][ny]) {
							visited[kMoveCnt][nx][ny] = true;
							bfs.offer(new int[] {nx, ny, kMoveCnt});
						}
					}
				}
				count++;
			}
		
		if (isArrive) System.out.println(count);
		else System.out.println(-1);
	}

	private static boolean isValidCoord(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}

}

/**
 *	1600. 말이 되고픈 원숭이
 */