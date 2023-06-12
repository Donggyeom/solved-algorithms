import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


class Point {
	int x, y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point() {
	}
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Point [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}
}

public class Main {
	
	static int N, M;
	
	static int[] dx = { -1,  0,  1,  0 };
	static int[] dy = {  0,  1,  0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(0,0));
		map[0][0] = '0';	// '0' 방문표시
		int step = 2;
		BFS:
			while(!queue.isEmpty()) {
				for (int i = 0, size = queue.size(); i < size; i++) {
					Point cur = queue.poll();
					int curX = cur.x;
					int curY = cur.y;
					
					for (int j = 0; j < 4; j++) {
						int nextX = curX + dx[j];
						int nextY = curY + dy[j];
						
						if (!isValidPoint(nextX, nextY) || map[nextX][nextY] == '0') continue;
						
						if (nextX == N-1 && nextY == M-1) break BFS;
						
						queue.offer(new Point(nextX, nextY));
						map[nextX][nextY] = '0';
					}
				}
				step++;
			}
		
		System.out.println(step);
	}

	private static boolean isValidPoint(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}

/**
 *  2178. 미로 탐색
 *  
 */