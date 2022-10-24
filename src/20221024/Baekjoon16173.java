import java.io.*;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			map[i] = new int[N+1];
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		Stack<Point> dfs = new Stack<>();
		boolean[][] bVisited = new boolean[N][N];
		Point root = new Point(0, 0, map[0][0]);
		dfs.push(root);
		Point idx = null;
		String answer = "Hing";
		while ( !dfs.isEmpty() ) {
			idx = dfs.pop();
			// System.out.println(idx.x + " " + idx.y + " " + idx.val);
			bVisited[idx.x][idx.y] = true;
			if (idx.x >= 0 && idx.x < N &&
					idx.y >= 0 && idx.y < N) {
				// 도착
				if (idx.val == -1) {
					answer = "HaruHaru";
					break;
				}
				
				if (idx.x + idx.val >= 0 && idx.x + idx.val < N &&
						bVisited[idx.x + idx.val][idx.y] == false) {
					dfs.push(new Point(idx.x + idx.val, idx.y, map[idx.x + idx.val][idx.y]));
				}
				if (idx.y + idx.val >= 0 && idx.y + idx.val < N &&
						bVisited[idx.x][idx.y + idx.val] == false) {
					dfs.push(new Point(idx.x, idx.y + idx.val, map[idx.x][idx.y + idx.val]));
				}
			}
		}
		
		System.out.println(answer);
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
	}
}

class Point {
	int x;
	int y;
	int val;
	
	public Point(int x_, int y_, int _val) {
		x = x_;
		y = y_;
		val = _val;
	}
}


/**
  * 16173. 점프왕 쩰리 (Small)
  * 
**/