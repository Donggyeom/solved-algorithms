import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	private static final int MAX_LENGTH = 100;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[MAX_LENGTH][MAX_LENGTH];
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int X = Integer.parseInt(input[1]);
		
		int validCount = 0;
		int rHeight = 0;
		int cHeight = 0;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			rHeight = map[i][0];
			cHeight = map[0][i];
			int rValidCnt = 1;
			int cValidCnt = 1;
			boolean rValid = true;
			boolean cValid = true;
			for (int j = 1; j < N; j++) {
				// 가로
				if (rHeight != map[i][j]) {
					if (map[i][j] - rHeight == 1 && rValidCnt >= X) {
						rHeight = map[i][j];
						rValidCnt = 1;
					}
					else if (rHeight - map[i][j] == 1 && putSlope(i, j, true, N, X)) {
						j += X-1;
						rHeight = map[i][j];
						rValidCnt = 0;
					}
					else {
						rValid = false;
						break;
					}
				}
				else rValidCnt++;
			}
			for (int j = 1; j < N; j++) {
				// 세로
				if (cHeight != map[j][i]) {
					if (map[j][i] - cHeight == 1 && cValidCnt >= X) {
						cHeight = map[j][i];
						cValidCnt = 1;
					}
					else if (cHeight - map[j][i] == 1 &&putSlope(j, i, false, N, X)) {
						j += X-1;
						cHeight = map[j][i];
						cValidCnt = 0;
					}
					else {
						cValid = false;
						break;
					}
				}
				else cValidCnt++;
			}
			
			if (rValid) validCount++;
			if (cValid) validCount++;
			
		}
		System.out.println(validCount);
	}

	private static boolean putSlope(int x, int y, boolean isHorizontal, int N, int X) {
		
		boolean canPlaced = true;
		int height = map[x][y];
		int dx = isHorizontal? 0 : 1;
		int dy = 1 - dx;
		for (int i = 0, len = X-1; i < len; i++) {
			if ((x += dx) == N || (y += dy) == N || map[x][y] != height) {
				canPlaced = false;
				break;
			}
		}
		return canPlaced;
	}
}

/**
 *  14890. 경사로
 */
