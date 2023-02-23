import java.io.*;
import java.util.*;
class Main {
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[][] map = new int[n][m];
		int[] S = new int[2];
		for (int i = 0; i < n; i++) {
			map[i] = new int[m];
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 2) {
					S[0] = i;
					S[1] = j;
				}
				else if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		
		int answer = 0;
		
		boolean[][] bVisited = new boolean[n][m];
        Queue<Point> bfs = new LinkedList<>();
        Point sPoint = new Point(S[0], S[1]);
        bfs.offer(sPoint);

        while( !bfs.isEmpty() ) {
            Queue<Point> nextQue = new LinkedList<>();
            while ( !bfs.isEmpty() ) {
                Point p = bfs.poll();
                if (bVisited[p.x][p.y]) continue;
                bVisited[p.x][p.y] = true;
                map[p.x][p.y] = answer; 
                
                // System.out.println("["+p.x+", "+p.y+"]");

                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx >= 0 && nx < n
                        && ny >= 0 && ny < m
                        && !bVisited[nx][ny]
                        && map[nx][ny] == -1) {
                            Point np = new Point(nx, ny);
                            nextQue.offer(np);
                    }
                }
            }
            // System.out.println(answer + " end ======");
            answer++;
            bfs = nextQue;
        }
		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
		        bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
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
  * 14940. 쉬운 최단거리
  * 
**/