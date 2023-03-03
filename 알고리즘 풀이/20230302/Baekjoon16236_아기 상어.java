import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class Main {
	
	static int N;
	static int[][] map;
	
	static int[] babyShark;
	static boolean[][] visited;
	static int numOfBite;
	
	static int time;
	
	// 먹이 우선 순위를 충족하기 위해 상, 좌, 우, 하로 순회
	static int[] dx = { -1,  0,  0,  1 };
	static int[] dy = {  0, -1,  1,  0 };
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		babyShark = new int[2];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 9) {
					babyShark[0] = i;
					babyShark[1] = j;
					map[i][j] = 2;	// 상어 크기 세팅
				}
			}
		}
		
		// 먹을 수 있는 물고기 찾아서 먹기
		while (find());
		
		System.out.println(time);
	}
	
	private static boolean find() {
		Queue<int[]> queue = new ArrayDeque<>();
		visitedInitiate();
		queue.offer(babyShark);
		visited[babyShark[0]][babyShark[1]] = true;
		int weight = map[babyShark[0]][babyShark[1]];	// 상어 크기
		int curTime = 0;
		int[] target = new int[] {N, N};
		boolean isFind = false;
		while ( !queue.isEmpty() ) {
			curTime++;
			
			for (int i = 0, size = queue.size(); i < size; i++) {
				int[] curP = queue.poll();
				
				// 사방탐색
				for (int j = 0; j < 4; j++) {
					int nx = curP[0] + dx[j];
					int ny = curP[1] + dy[j];
					
					if (isValidCoord(nx, ny) && !visited[nx][ny] && map[nx][ny] <= weight) {
						if (map[nx][ny] > 0 && map[nx][ny] < weight) {
							if (target[0] > nx || 
									(target[0]==nx && target[1] > ny)) {
								target[0] = nx;
								target[1] = ny;
								isFind = true;
							}
						}
						
						queue.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
				
			}
			if (isFind) {
				eat(target[0], target[1], curTime);
				return true;
			}
		}
		return false;
	}
	
	private static boolean isValidCoord(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	private static void visitedInitiate() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	private static void eat(int x, int y, int spentedTime) {
		map[x][y] = map[babyShark[0]][babyShark[1]];
		map[babyShark[0]][babyShark[1]] = 0;
		babyShark[0] = x;
		babyShark[1] = y;
		time += spentedTime;
		if (++numOfBite == map[x][y]) {
			// 아기 상어 성장
			map[x][y]++;
			numOfBite = 0;
		}
		
//		// debug
//		System.out.println("==============");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (i != babyShark[0] || j != babyShark[1])
//					System.out.print(map[i][j] + " ");
//				else
//					System.out.print("*" + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(time +" " + map[babyShark[0]][babyShark[1]] + " " + numOfBite);
	}
}

/**
 *	16236. 아기 상어 
 */