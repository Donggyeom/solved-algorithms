import java.io.*;
import java.util.Stack;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]);		// y열
			int N = Integer.parseInt(input[1]);		// x행
			
			int K = Integer.parseInt(input[2]);
			
			Point[] cabbages = new Point[K];
			for (int j = 0; j < K; j++) {
				input = br.readLine().split(" ");
				int y = Integer.parseInt(input[0]);
				int x = Integer.parseInt(input[1]);
				cabbages[j] = new Point(x, y);
			}
			
			int[] dx = {-1,  1,  0,  0};	// 상, 하, 좌, 우
			int[] dy = { 0,  0, -1,  1};
			int answer = 0;
			boolean[][] bVisited = new boolean[N][M];
			for (int j = 0; j < N; j++) {
				for (int l = 0; l < M; l++) {
					bVisited[j][l] = true;
				}
			}
			for (Point pi : cabbages) {
				bVisited[pi.x][pi.y]= false; 
			}
			
//			System.out.println();
//			for (int j = 0; j < N; j++) {
//				for (int l = 0; l < M; l++) {
//					System.out.printf("%5s ", bVisited[j][l]);
//				}
//				System.out.println();
//			}
			
			// dfs
			for (int j = 0; j < K; j++) {
				Point p = cabbages[j];
				if (bVisited[p.x][p.y] == false) {
					bVisited[p.x][p.y] = true;
					answer++;
					
					Stack<Point> dfs = new Stack<>();
					dfs.push(p);
					while ( !dfs.isEmpty() ) {
						p = dfs.pop();
						bVisited[p.x][p.y] = true;
//						System.out.println(p);
						
						for (int l = 0; l < 4; l++) {
							int nextX = p.x + dx[l];
							int nextY = p.y + dy[l];
							
							if (nextX >= 0 && nextX < N &&
									nextY >= 0 && nextY < M &&
									bVisited[nextX][nextY] == false) {
								dfs.push(new Point(nextX, nextY));
							}
						}
//						System.out.println("stk : " + dfs.toString());
//						System.out.println("answer : " + answer);
					}
				}
			}
			
			System.out.println(answer);
		}	// 테스트 케이스 Loop End.
		
	}
}

class Point {
	int x;
	int y;
	
	public Point(int xi, int yi) {
		x = xi;
		y = yi;
	}
	
	public String toString() {
		return ""+x+" "+y;
	}
}


/**
  * 1012. 유기농 배추
  * 
**/