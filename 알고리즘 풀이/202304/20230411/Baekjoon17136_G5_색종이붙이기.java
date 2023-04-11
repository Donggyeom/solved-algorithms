import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] map;
	static int minCount = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10];
		for (int i = 0; i < 10; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				int num = Integer.parseInt(input[j]);
				map[i] <<= 1;	// 1비트 이동
				map[i] += num;	// 해당 비트 값 설정
			}
		}
		
		dfs(new int[] {0, 5, 5, 5, 5, 5});
		
		if (minCount != Integer.MAX_VALUE)
			System.out.println(minCount);
		else
			System.out.println(-1);
		
		br.close();
	}

	private static void dfs(int[] canUseCount) {
		int zeroCount = 0;
		int oneIdx = 0;
		for (int i = 9; i >= 0; i--) {
			if (map[i] == 0) zeroCount++;
			else oneIdx = i;	// 1이 나오는 첫번째 행 인덱스
		}
		if (zeroCount == 10) {
			// 사용한 색종이 개수 계산
			int usedCount = 0;
			for (int i = 1; i <= 5; i++) usedCount += (5-canUseCount[i]);
			minCount = Math.min(minCount, usedCount);	// 최소값 저장
			return;
		}
		
		int x = oneIdx;
		int y = -1;
		for (int i = 1; i <= 5; i++) {
			if (canUseCount[i] == 0) continue;
			if ((y = canBatch(oneIdx, i)) != -1) {
				fillZero(x, y, i);
				canUseCount[i]--;
//				// DEBUG: printMap
//				for (int k = 0; k < 10; k++) {
//					System.out.printf("%10s\n",Integer.toBinaryString(map[k]));
//				}
//				System.out.println("====================");
				dfs(canUseCount);
				fillOne(x, y, i);
				canUseCount[i]++;
			}
		}
	}

	private static void fillOne(int x, int y, int l) {
		int bitMask = (1<<l)-1;
		for (int i = x, e = x+l; i < e; i++)
			map[i] |= bitMask << (10-y-l);	// 1...1 (길이는 l)인 값을 (10-y-l)만큼 이동시키고 bit OR연산
	}

	private static void fillZero(int x, int y, int l) {
		int bitMask = (1<<l)-1;
		for (int i = x, e = x+l; i < e; i++)
			map[i] &= ~(bitMask << (10-y-l));// 1...1 (길이는 l)인 값을 (10-y-l)만큼 이동시키고 1<->0 뒤집어서 AND연산
	}

	private static int canBatch(int x, int l) {
		if (x + l > 10) return -1;
		
		int y = 0;
		int targetNum = (1<<l)-1;
		int bitMask = targetNum<<(10-y-l);
		do {
			boolean isValid = true;
			for (int i = x, e = x+l; i < e; i++) {
				if (((map[i] & bitMask) >> (10-y-l)) != targetNum) {
					isValid = false;
					break;
				}
			}
			if (isValid) return y;
			
			y++;
			bitMask >>= 1;
		} while (y+l <= 10);
		
		return -1;
	}
}

/**
 *  17136. 색종이 붙이기
 *  
 */
