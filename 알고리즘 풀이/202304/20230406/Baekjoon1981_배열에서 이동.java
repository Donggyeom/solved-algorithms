import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	static final int MAX_DIFF = 200;
	
	static int map[][], N, dest, minNumber = 200, maxNumber; 
	static boolean[] visited;
	
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dest = N-1;
		map = new int[N][N];
		visited = new boolean[N*N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				minNumber = Math.min(minNumber, map[i][j]);
				maxNumber = Math.max(maxNumber, map[i][j]);
			}
		}
		
		int s = 0;
		int e = maxNumber - minNumber;
		int res = -1;
		while (s <= e) {
			int mid = (s + e) / 2;
			boolean suc = false;
			for (int i = minNumber; i <= maxNumber; i++) {
				if ((suc = bfs(i, i+mid))) {
					res = mid;
					e = mid-1;
					break;
				}
			}
			
			if (!suc) s = mid + 1;
		}
		
		System.out.println(res);
	}
	
	private static boolean bfs(int s, int e) {
		Queue<int[]> bfs = new ArrayDeque<>();
		Arrays.fill(visited, false);
		if (map[0][0] < s || map[0][0] > e) return false;
		
		bfs.offer(new int[] {0, 0});
		visited[0] = true;
		while (!bfs.isEmpty()) {
			int[] item = bfs.poll();	
			int x = item[0];
			int y = item[1];
			
			if (x == dest && y == dest) return true;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isValidCoord(nx, ny) && !visited[nx*N+ny] && map[nx][ny] >= s && map[nx][ny] <= e) {
					bfs.offer(new int[] {nx, ny});
					visited[nx*N+ny] = true;
				}
			}
		}
		return false;
	}
	
	private static boolean isValidCoord(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

/**
 *  1981. 배열에서 이동
 *  
 */
