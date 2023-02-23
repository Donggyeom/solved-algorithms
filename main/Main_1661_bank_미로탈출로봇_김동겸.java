import java.io.*;
import java.util.*;

class Main_1661_bank_미로탈출로봇_김동겸 {

	static int WIDTH;	// column 크기 
	static int HEIGHT;	// row 크기
	static int[][] map;
	
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		WIDTH = Integer.parseInt(input[0]);		// x->WIDTH = column
		HEIGHT = Integer.parseInt(input[1]);	// y->HEIGHT = row
		map = new int[HEIGHT][WIDTH];
		input = br.readLine().trim().split(" ");
		// x -> s[1] = column, y -> s[0] = row
		int[] start	 = new int[] {Integer.parseInt(input[1])-1, Integer.parseInt(input[0])-1};
		int[] dest	 = new int[] {Integer.parseInt(input[3])-1, Integer.parseInt(input[2])-1};
		for (int i = 0; i < HEIGHT; i++) {
			char[] cArr = br.readLine().toCharArray();
			for (int j = 0; j < WIDTH; j++) {
				if (cArr[j] != '0') map[i][j] = Integer.MAX_VALUE;	// 1은 인트 최댓값으로 초기화
			}
		}
		
//		bfs(start, dest);
		dfs(start, dest);
		System.out.println(map[dest[0]][dest[1]]);
	}

	private static void dfs(int[] start, int[] dest) {
		Stack<Integer> stk = new Stack<>();		// r, c, step 순으로 3개 씩 입력
		
		map[start[0]][start[1]] = 1;
		stk.push(start[0]);
		stk.push(start[1]);
		stk.push(0);
		
		while (!stk.isEmpty()) {
			
			// 뺄 때 반대로
			int d = stk.pop() + 1;	// step수 1 증가
			int y = stk.pop();
			int x = stk.pop();	
			
//			// 디버그
//			printMap(d);

			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isValidPoint(nx, ny) && 
						(map[nx][ny] == 0 || map[nx][ny] > d)) {
					map[nx][ny] = d;
					stk.push(nx);
					stk.push(ny);
					stk.push(d);
				}
			}
		}
	}

	private static void printMap(int step) {
		System.out.println("step: " + step);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (map[i][j] == Integer.MAX_VALUE)
					System.out.print("-");
				else 
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("===================================");
	}

	private static void bfs(int[] start, int[] dest) {
		Queue<Integer> queue = new LinkedList<>();	// r, c 순으로 2개 씩 입력
		
		// 출발점 추가
		queue.offer(start[0]);
		queue.offer(start[1]);
		
		int step = 0;
		while (!queue.isEmpty()) {
			step++;
			int size = queue.size() / 2;
			while (--size >= 0) {
				int x = queue.poll();
				int y = queue.poll();
				
				if (x == dest[0] && y == dest[1]) {
					queue.clear();
					break;
				}
				
				// 사방탐색
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (isValidPoint(nx, ny)
							&& map[nx][ny] == 0) {
						queue.offer(nx);
						queue.offer(ny);
						
						map[nx][ny] = step;
					}
				}
			}
		}
	}

	private static boolean isValidPoint(int nx, int ny) {
		return nx >= 0 && nx < HEIGHT && ny >= 0 && ny < WIDTH
				&& map[nx][ny] != Integer.MAX_VALUE;
	}
	
	
}

/**
 *  정올_1661. 미로 탈출 로봇
 */