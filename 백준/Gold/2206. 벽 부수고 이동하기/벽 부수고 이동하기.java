import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int N, M;
	static char[][] map;
	
	// bfs
	static boolean[][][] visited;
	static final int[] dx = { -1,  0,  1,  0 };
	static final int[] dy = {  0,  1,  0, -1 };
	static boolean isArrived = false;
	static int answer = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		map = new char[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = chars[j-1];
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		visited = new boolean[N+1][M+1][2];
		queue.offer(new int[] {1, 1, 0});	// x, y, isCrashed
		visited[1][1][0] = true;
		if (N == 1 && M == 1) isArrived = true;
		BFS:
		while(!isArrived && !queue.isEmpty()) {
			answer++;
			for (int m = 0, size = queue.size(); m < size; m++) {
				int[] item = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nx = item[0] + dx[i];
					int ny = item[1] + dy[i];
					
					if (nx == N && ny == M) {
						isArrived = true;
						break BFS;
					}
					
					if (!isValidPoint(nx, ny)) continue;
					if (visited[nx][ny][item[2]]) continue;
					if (map[nx][ny] == '1' && item[2] == 1) continue;
					
					if (item[2] == 0 && map[nx][ny] == '0') {
						queue.offer(new int[] {nx, ny, 0});
						visited[nx][ny][0] = visited[nx][ny][1] = true;
					}
					else {
						queue.offer(new int[] {nx, ny, 1});
						visited[nx][ny][1] = true;
					}
				}
			}
		}
		
		if (isArrived) System.out.println(answer);
		else System.out.println(-1);
	}

	private static boolean isValidPoint(int x, int y) {
		return x > 0 && x <= N && y > 0 && y <= M;
	}
}

/**
 *  2206. 벽 부수고 이동하기
 *  
 */