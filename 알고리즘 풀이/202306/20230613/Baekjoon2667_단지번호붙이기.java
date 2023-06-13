import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				
				if (map[i][j] == '0') {
					visited[i][j] = true;
					continue;
				}
				
				// dfs
				int count = 0;
				Stack<Point> stk = new Stack<>();
				stk.push(new Point(i, j));
				while (!stk.isEmpty()) {
					Point cur = stk.pop();
					int x = cur.x;
					int y = cur.y;
					
					if (visited[x][y]) continue;
					
					visited[x][y] = true;
					count++;
					
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						
						if (!isValidPoint(nx, ny) || visited[nx][ny]) continue;
						
						if (map[nx][ny] == '0') {
							visited[nx][ny] = true;
							continue;
						}
						
						stk.push(new Point(nx, ny));
					}
				}
				result.add(count);
			}
		}
		
		StringBuilder sb = new StringBuilder(10);
		result.sort(Comparator.naturalOrder());
		sb.append(result.size()).append("\n");
		result.forEach(i -> sb.append(i).append("\n"));
		System.out.println(sb);
	}
	
	private static boolean isValidPoint(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

/**
 *  2667. 단지번호붙이기
 *  
 */