import java.io.*;
import java.util.*;

class Tongnamu {
	int cr, cc, bHorizontal;	// �߽� ��, ��, ���� ����
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// �Է��� �ޱ� ���� ���۵� ����
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		Tongnamu B = null, E = null;
		
		// �Է� ���� ������ ����
		for (int i = 0; i < N; i++) {
			char[] inputArray = br.readLine().toCharArray();
			
			for (int j = 0; j < N; j++) {
				char inputChar = inputArray[j];
				// ó�� B�� ������ B �볪�� ��ü ���� �� ���� 1�� �ʱ�ȭ
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
				// ó�� E�� ������ E �볪�� ��ü ���� �� ���� 0���� �ʱ�ȭ
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
		// BFS ����
		boolean[][][] visited = new boolean[N][N][2];	// �� ��,��,���򿩺η� �湮�˻�
		Queue<Tongnamu> queue = new ArrayDeque<>();
		queue.offer(B);
		visited[B.cr][B.cc][B.bHorizontal] = true;
		int actionCount = 0;	// �ൿȽ�� ����
		boolean isDest = false;
		GET_COUNT:
			while (!queue.isEmpty()) {
				for (int i = 0, size = queue.size(); i < size; i++) {	// ���� ���̿� �ִ� ��� ��� ��ȸ
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
				actionCount++;	// �ൿȽ��+1
			}
		
		if (!isDest) actionCount = 0;	// �������� ������ ��� 0���� ����
		
		System.out.println(actionCount);
	}

	// ȸ�� ���� ���� ��ȯ
	private static boolean canTurn(int cr, int cc) {
		for (int i = cr-1; i <= cr+1; i++) {
			for (int j = cc - 1; j <= cc+1; j++) {
				if (!isValidPoint(i, j) || map[i][j] == '1') return false;
			}
		}
		return true;
	}

	// �ش� ��ġ�� �̵� ������ �� ��ȯ
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
	
	
	// ���� ��ġ�� �ʿ� ���ԵǴ��� ���� ��ȯ
	private static boolean isValidPoint(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	// �ش� ��ġ���� 3 ���̸�ŭ �ش� c ���ڷ� �ʿ� ����
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