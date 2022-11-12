import java.io.*;
import java.util.*;
class Main {
	
	static int N;
	static int[][] map;
	static int[] dx = { -1,  0,  1,  0};
	static int[] dy = {  0,  1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = new int[N];
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[] res = getPaperCounts(0, 0, N);
		
		bw.write(Integer.toString(res[0]));
		bw.write("\n");
		bw.write(Integer.toString(res[1]));
		bw.write("\n");
		
		bw.flush();
	}
	
	static int[] getPaperCounts(int x, int y, int l) {
		
		// System.out.println(x + ", " + y + ", " + l);
		// System.out.println();
		// 하나의 색인지 확인
		int cnt = 0;
		int color = map[x][y];
		COUNT_LOOP:
		for (int i = x; i < x+l; i++) {
			for (int j = y; j < y+l; j++) {
				if (map[i][j] != color) {
					break COUNT_LOOP;
				}
				cnt++;
			}
		}
		
		if (cnt == (int) Math.pow(l, 2)) {
			int[] res = new int[2];
			res[color] = 1;
			res[1-color] = 0;
			return res;
		}
		
		// 분할재귀
		int[] res = new int[2];
		l /= 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int[] temp = getPaperCounts(x + i*l, y + j*l, l);
				res[0] += temp[0];
				res[1] += temp[1];
			}
		}
		// System.out.println("l : " + l + ", 0 : " + res[0] + ", 1 : " + res[1]);
		return res;
	}
}



/**
  * 2630. 색종이 만들기
  * 
**/