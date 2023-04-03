import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
	static final int MAX_ARCHERS = 3;
	
	static int N, M, D;
	static int[][] map;
	static int[] archerPositions;
	
	static List<int[]> enemies;
	static List<int[]> enemiesClone;
	static Set<Integer> deathIdx;
	
	static int maxResult;
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N  = Integer.parseInt(input[0]);	// max row
		M  = Integer.parseInt(input[1]);	// max col
		D  = Integer.parseInt(input[2]);	// distance
		map = new int[N+1][M];	// 궁수 배치할 행 + 1
		archerPositions = new int[MAX_ARCHERS];	// 아처의 열 번호
		enemies = new ArrayList<>();
		deathIdx = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(input[j]);
				map[i][j] = num;
				if (num == 1) enemies.add(new int[] {i, j});	// 리스트에 적 추가
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		init();
		
		// 궁수 배치 조합으로 순회
		combination(0, 0);
		
		System.out.println(maxResult);
	}

	// 조합 순회
	private static void combination(int cnt, int s) {
		if (cnt == MAX_ARCHERS) {
			simulate();
			return;
		}
		
		for (int i = s; i < M; i++) {
			archerPositions[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	private static void simulate() {
		int deathCntTotal = 0;
		enemiesClone = new ArrayList<>();
		for (int[] p : enemies) {
			enemiesClone.add(p.clone());
		}
		while (!enemiesClone.isEmpty()) {
			
			deathCntTotal += attack();
			
			// 적 이동
			for (int i = enemiesClone.size()-1; i >= 0; i--) {
				if (enemiesClone.get(i)[0] == N-1) {
					enemiesClone.remove(i);
					continue;
				}
				
				enemiesClone.get(i)[0]++;
			}
		}
		
		maxResult = Math.max(maxResult, deathCntTotal);
	}

	private static int attack() {
		// 적을 순회하며, 궁수의 범위에 있으면 사망처리(궁수의 활성 여부 확인)
		// 해당 궁수는 비활성화
		
		deathIdx.clear();	// 죽은 적 인덱스 초기화
		for (int i = 0; i < MAX_ARCHERS; i++) {
			int[] myPosition = new int[] {N, archerPositions[i]};
			int minDist = 1<<10;
			int target = -1;
			int targetCol = -1;
			for (int j = 0, size = enemiesClone.size(); j < size; j++) {
				int dist = getDistance(enemiesClone.get(j), myPosition);
				if (dist <= D && minDist >= dist) {
					if (minDist != dist) {
						minDist = dist;
						target = j;
						targetCol = enemiesClone.get(j)[1];
					}
					else if (targetCol >= enemiesClone.get(j)[1]) {
						target = j;
						targetCol = enemiesClone.get(j)[1];
					}
				}
			}
			if (target != -1) {
				deathIdx.add(target);
			}
		}
		int deathCnt = deathIdx.size();
		int[] list = new int[deathIdx.size()];
		int idx = 0;
		for (int i : deathIdx) {
			list[idx++] = i;
		}
		Arrays.sort(list);
		for (int i = deathCnt-1; i >= 0; i--) {
			enemiesClone.remove(list[i]);	// 리스트 인덱스 유지를 위해 뒤에서부터 삭제
		}
		return deathCnt;
	}

	private static int getDistance(int[] p1, int[] p2) {
		return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
	}
}

/**
 *  17135. 캐슬 디펜스
 */