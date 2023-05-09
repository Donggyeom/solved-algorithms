import java.io.*;
import java.util.*;

class Tongnamu {
	int cr, cc, bHorizontal;	// 중심 행, 열, 수평 여부
	public Tongnamu(int cr, int cc, int bHorizontal) {
		super();
		this.cr = cr;
		this.cc = cc;
		this.bHorizontal = bHorizontal;
	}
	public boolean equals(Tongnamu obj) {
		if (bHorizontal != obj.bHorizontal) return false;
		if (cc != obj.cc) return false;
		if (cr != obj.cr) return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Tongnamu [cr=" + cr + ", cc=" + cc + ", bHorizontal=" + bHorizontal + "]";
	}
}

class Main {
	
	static final int U = 0;
	static final int R = 1;
	static final int D = 2;
	static final int L = 3;
	
	static char[][] map;
	static int N;
	static int[] dr = { -1,  0,  1,  0 };
	static int[] dc = {  0,  1,  0, -1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 받기 위한 버퍼드 리더
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		Tongnamu B = null, E = null;
		
		// 입력 받은 데이터 저장
		for (int i = 0; i < N; i++) {
			char[] inputArray = br.readLine().toCharArray();
			
			for (int j = 0; j < N; j++) {
				char inputChar = inputArray[j];
				// 처음 B를 만나면 B 통나무 객체 생성 후 맵을 1로 초기화
				if (inputChar == 'B') {
					inputChar = '0';
					if (B == null) {
						if (j == N-1 || inputArray[j+1] != 'B') {
							B = new Tongnamu(i+1, j, 0);
						}
						else {
							B = new Tongnamu(i, j+1, 1);
						}
					}
				}
				// 처음 E를 만나면 E 통나무 객체 생성 후 맵을 0으로 초기화
				else if (inputChar == 'E') {
					inputChar = '0';
					if (E == null) {
						if (j == N-1 || inputArray[j+1] != 'E') {
							E = new Tongnamu(i+1, j, 0);
						}
						else {
							E = new Tongnamu(i, j+1, 1);
						}
					}
				}
				
				map[i][j] = inputChar;
			}
		}
		// BFS 실행
		boolean[][][] visited = new boolean[N][N][2];	// 맵 행,열,수평여부로 방문검사
		Queue<Tongnamu> queue = new ArrayDeque<>();
		queue.offer(B);
		visited[B.cr][B.cc][B.bHorizontal] = true;
		int actionCount = 0;	// 행동횟수 저장
		boolean isDest = false;
		GET_COUNT:
			while (!queue.isEmpty()) {
				for (int i = 0, size = queue.size(); i < size; i++) {	// 현재 깊이에 있는 노드 모두 순회
					Tongnamu now = queue.poll();
					if (now.equals(E)) {
						isDest = true;
						break GET_COUNT;
					}
					
					int cr = now.cr;
					int cc = now.cc;
					int bHorizontal = now.bHorizontal;
					
					for (int j = 0; j < 4; j++) {
						int ncr = cr + dr[j];
						int ncc = cc + dc[j];
						if (!canMove(ncr, ncc, bHorizontal, j)) continue;
						if (visited[ncr][ncc][bHorizontal]) continue; 
						
						queue.offer(new Tongnamu(ncr, ncc, bHorizontal));
						visited[ncr][ncc][bHorizontal] = true;
					}
					
					if (visited[cr][cc][1-bHorizontal] || !canTurn(cr, cc)) continue;
					queue.offer(new Tongnamu(cr, cc, 1-bHorizontal));
				}
				actionCount++;	// 행동횟수+1
			}
		
		if (!isDest) actionCount = 0;	// 도착하지 못했을 경우 0으로 설정
		
		System.out.println(actionCount);
	}

	// 회전 가능 여부 반환
	private static boolean canTurn(int cr, int cc) {
		for (int i = cr-1; i <= cr+1; i++) {
			for (int j = cc - 1; j <= cc+1; j++) {
				if (!isValidPoint(i, j) || map[i][j] == '1') return false;
			}
		}
		return true;
	}

	// 해당 위치로 이동 가능한 지 반환
	private static boolean canMove(int ncr, int ncc, int bHorizontal, int dir) {
		if (!isValidPoint(ncr, ncc)) return false;
		if (bHorizontal == 1) {
			if (!isValidPoint(ncr, ncc-1)) return false;
			if (!isValidPoint(ncr, ncc+1)) return false;
			for (int i = ncc-1; i <= ncc+1; i++) {
				if (map[ncr][i] != '0') return false;
			}
		}
		else {
			if (!isValidPoint(ncr-1, ncc)) return false;
			if (!isValidPoint(ncr+1, ncc)) return false;
			for (int i = ncr-1; i <= ncr+1; i++) {
				if (map[i][ncc] != '0') return false;
			}
		}
		return true;
	}
	
	
	// 현재 위치가 맵에 포함되는지 여부 반환
	private static boolean isValidPoint(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	// 해당 위치부터 3 길이만큼 해당 c 문자로 맵에 설정
	private static void setCharToMap(char c, int cr, int cc, int bHorizontal) {
		if (bHorizontal == 1) {
			for (int i = cc-1; i <= cc+1; i++) {
				map[cr][i] = c;
			}
		}
		else {
			for (int i = cr-1; i <= cr+1; i++) {
				map[i][cc] = c;
			}
		}
	}
}