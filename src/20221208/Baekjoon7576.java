import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	
	static int MAX = 100000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);

		
		Bfs bfs = new Bfs(N, M, new int[N][M]);
		int[][] box = bfs.box;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			box[i] = new int[M];
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(input[j]);
				if (box[i][j] == 1) {
					bfs.que.offer(new Point(i, j));
				}
				else if (box[i][j] == 0) {
					bfs.remainder++;
				}
			}
		}
		
		bfs.execute();
		
		System.out.println(bfs.answer);
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return x + " " + y;
	}
}

class Bfs {
	// 위, 오른쪽, 아래, 왼쪽
	static int[] dx = {-1,  0, +1,  0};
	static int[] dy = { 0, +1,  0, -1};
	
	Queue<Point> que;
	boolean[][] visited;
	int N;
	int M;
	int[][] box;
	
	int remainder;
	int answer;
	
	public Bfs(int N, int M, int[][] box) {
		this.N = N;
		this.M = M;
		this.box = box;
		
		this.que = new LinkedList<>();
		this.visited = new boolean[N][M];
		
		this.answer = 0;
		this.remainder = 0;
	}
	
	void execute() {
		while ( !que.isEmpty() ) {
			int length = que.size();
			for (int i = 0; i < length; i++) {
				Point p = que.poll();
				
				if (visited[p.x][p.y]) continue;
				
				visited[p.x][p.y] = true;				
				if (box[p.x][p.y] == 0) {
					remainder--;
					box[p.x][p.y] = 1;
				}

				if (remainder == 0) {
					return;
				}
				
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					
					if (nx >= 0 && nx < N
							&& ny >= 0 && ny < M
							&& !visited[nx][ny]
							&& box[nx][ny] == 0) {
						que.offer(new Point(nx, ny));
					}
				}
			}
			
			answer++;
		}
		
		answer = -1;
	}
}

/**
  * 7576. 토마토
  * 
**/