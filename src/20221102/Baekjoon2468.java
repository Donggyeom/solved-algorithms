import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] mapSource = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			mapSource[i] = new int[N];
			for (int j = 0; j < N; j++) {
				mapSource[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[] dx = {-1, 0, 1,  0};
		int[] dy = { 0, 1, 0, -1};
		
		int answer = -1;
		for (int k = 0; k <= 100; k++) {
			int safety = 0;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = mapSource[i].clone();
			}
			for (int i = 0; i < N; i++ ) {
				for (int j = 0; j < N; j++) {
					
					Stack<Point> dfs = new Stack<>();
					if (map[i][j] > k) {
						dfs.push(new Point(i, j));
						safety++;
						while ( !dfs.isEmpty() ) {
							Point p = dfs.pop();
							if (map[p.x][p.y] > k) {
								map[p.x][p.y] = 0;
							}
							for (int l = 0; l < 4; l++) {
								int nx = p.x + dx[l];
								int ny = p.y + dy[l];
								
								if (nx >= 0 && nx < N
										&& ny >= 0 && ny < N) {
									if (map[nx][ny] > k) {
										dfs.push(new Point(nx, ny));
									}
									else {
										map[nx][ny] = 0;
									}
								}
							}
						}
					}
					else {
						map[i][j] = 0;
					}
				}
			}

			if (answer > safety) break;
			answer = answer > safety ? answer : safety;
		}
		
		System.out.println(answer);
	}
}

class Point {
	int x;
	int y;
	
	public Point(int xi, int yi) {
		x = xi;
		y = yi;
	}
}

/**
  * 2468. 안전 영역
  * 
**/