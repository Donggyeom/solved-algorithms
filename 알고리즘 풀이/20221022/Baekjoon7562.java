import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// String[] input = br.readLine().split(" ");
		
		int[] dx = {-1, -2, -2, -1, 1, 2,  2,  1};
		int[] dy = {-2, -1,  1,  2, 2, 1, -1, -2};
				
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int l = Integer.parseInt(br.readLine());
			
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			input = br.readLine().split(" ");
			int toX = Integer.parseInt(input[0]);
			int toY = Integer.parseInt(input[1]);
			
			if (x == toX && y == toY) {
				System.out.println(0);
				continue;
			}
			
			boolean[][] bVisited = new boolean[l][l];
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(x, y));
			int moveCnt = 0;
			Queue<Point> nextQ = new LinkedList<>();
			MOVE_LOOP:
				while ( !q.isEmpty() ) {
					Point p = q.poll();
					if (p.x == toX && p.y == toY) {
						System.out.println(moveCnt);
						break MOVE_LOOP;
					}
					// System.out.println(p.x + " " + p.y);
					
					for (int j = 0; j < 8; j++) {
						x = p.x + dx[j];
						y = p.y + dy[j];
						
						if ( (x >= 0 && x < l) && 
								(y >= 0 && y < l) &&
								bVisited[x][y] == false) {
							nextQ.offer(new Point(x, y));
							bVisited[x][y] = true;
						}
					}
					if (q.isEmpty()) {
						q = nextQ;
						nextQ = new LinkedList<>();
						moveCnt++;
						// System.out.println(moveCnt + "==================");
					}
				}
			// GET_MOVE_LOOP end;
		}
			
		

		// System.out.println();
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x_, int y_) {
		x = x_;
		y = y_;
	}
}


/**
  * 7562. 나이트의 이동
  * 
**/